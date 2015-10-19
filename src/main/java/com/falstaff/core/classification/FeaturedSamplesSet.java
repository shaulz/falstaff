package com.falstaff.core.classification;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.hibernate.validator.constraints.NotEmpty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.AutoPopulatingList;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.alignable.INLookupAlignable;
import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.alignable.signature.NLearnedSignature;
import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.aligner.ContentPropertiesFeatureAssigner;
import com.falstaff.core.aligner.Lexer;
import com.falstaff.core.aligner.NAbstractAligner;
import com.falstaff.core.aligner.NFilePropertiesFeatureAssigner;
import com.falstaff.core.aligner.NSignatureFeatureAssigner;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults.ClassificationResult;
import com.falstaff.core.classification.FeaturedSignature.SamplesSetMatch;
import com.falstaff.core.execution.IProcessMonitor;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.execution.ProcessStatus;
import com.falstaff.core.feature.IFeature;
import com.falstaff.core.feature.TokenFeature;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.maxent.Datum;
import com.falstaff.core.ontology.FileFormatOntology;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.util.IdGenerator;
import com.falstaff.crawler.ILocalSamplesDownloader;
import com.falstaff.crawler.IRemoteSamplesDownloader;
import com.falstaff.crawler.RemoteSamplesDownloader;

public class FeaturedSamplesSet implements IDatumSource, IProcessMonitor {

	private static final Logger log = LoggerFactory
			.getLogger(FeaturedSamplesSet.class.getName());

	public transient static int maxTrainSamplesDefault;
	public transient static int minTestSamplesDefault;
	public transient static int maxAlignSamplesDefault;

	@NotEmpty(message = "Name is required.")
	protected String name;
	protected String folder;
	protected List<FeaturedSample> samples;
	protected FileFormat format;
	protected Calendar created;
	protected Calendar updated;
	private Calendar featuresCreated;
	protected List<SamplesUrl> sampleURLs;
	private String description;
	protected transient int id;
	protected transient ProcessMonitor processMonitor = null;
	private transient ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
	private Integer maxTrainSamples;
	private Integer minTestSamples;
	private Integer maxAlignSamples;

	public static class SamplesUrl {
		private String url;
		private String description;
		private Integer samplesNumber;

		public SamplesUrl() {
		}

		public SamplesUrl(String url, String description) {
			super();
			this.url = url;
			this.description = description;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Integer getSamplesNumber() {
			return samplesNumber;
		}

		public void setSamplesNumber(Integer samplesNumber) {
			this.samplesNumber = samplesNumber;
		}
	}

	class FilesFinder extends SimpleFileVisitor<Path> {
		List<String> files;

		private FilesFinder() {
			super();
			files = new LinkedList<String>();
		}

		@Override
		public FileVisitResult visitFile(Path path, BasicFileAttributes attrs) {
			if (path.toFile().isFile()) {
				path = new File(getFolder()).toPath().relativize(path);
				files.add(path.toString());
			}
			return FileVisitResult.CONTINUE;
		}

		public List<String> getFiles() {
			return files;
		}
	}

	public class ExtensionFilter implements FilenameFilter {

		private FileFormatOntology ontology;

		public ExtensionFilter(FileFormatOntology ontology) {
			super();
			this.ontology = ontology;
		}

		@Override
		public boolean accept(File dir, String name) {
			Set<String> extensions = ontology.getExtensions();
			for (String extension : extensions) {
				if (name.endsWith(extension)
						|| name.toUpperCase().endsWith(extension.toUpperCase())) {
					return true;
				}
			}
			return false;
		}
	}

	public FeaturedSamplesSet(String name, String folder, FileFormat format) {
		super();
		this.name = name;
		this.folder = folder;
		this.format = format;
		created = Calendar.getInstance();
		updated = created;
		setId();
		sampleURLs = new ArrayList<SamplesUrl>();
		samples = new LinkedList<FeaturedSample>();
	}

	public FeaturedSamplesSet(String name, String folder, FileFormat format,
			Integer maxTrainSamples, Integer minTestSamples,
			Integer maxAlignSamples) throws IOException {
		this(name, folder, format);
		this.maxTrainSamples = maxTrainSamples;
		this.minTestSamples = minTestSamples;
		this.maxAlignSamples = maxAlignSamples;
		setSamples();
	}

	public void setSamples() throws IOException {
		samples = new LinkedList<FeaturedSample>();

		// add files
		File samplesDir = new File(folder);
		FilenameFilter filter = new ExtensionFilter(format.getOntology());
		File[] files;
		files = samplesDir.listFiles();
		if (files == null) {
			return;
		}
		
		List<List<FeaturedSample>> samplesList = new LinkedList<List<FeaturedSample>>();

		if (files.length > 0) {
			for (File file : files) {
				List<FeaturedSample> sampleList = new LinkedList<FeaturedSample>();
				if (file.isFile()) {
					FeaturedSample sample = new FeaturedSample(file.getName(), this);
					samples.add(sample);
					sampleList.add(sample);
				}
				else {
					FilesFinder filesFinder = new FilesFinder();
					Files.walkFileTree(file.toPath(), filesFinder);
					for (String sampleFile : filesFinder.getFiles()) {
						FeaturedSample sample = new FeaturedSample(sampleFile, this);
						samples.add(sample);
						sampleList.add(sample);
					}
				}
				samplesList.add(sampleList);
			}
		}

		// set training and testing
		setTrainingAndTestingSamples(samplesList);

		// set aligning
		setAligningSamples();
	}
	
	public void setTrainingAndTestingSamples(List<List<FeaturedSample>> samplesLists) {
		if (samplesLists.size() == 0) {
			return;
		}
		
		List<List<FeaturedSample>> samplesListTrain = new LinkedList<List<FeaturedSample>>(samplesLists);
		
		int maxTrain = getMaxTrainSamples();
		int trainingNumber = 0;
		while (trainingNumber < maxTrain && samplesListTrain.size() > 0) {
			int index = random(0, samplesListTrain.size() - 1);
			for (FeaturedSample sample : samplesListTrain.get(index)) {
				sample.setTraining(true);
			}
			trainingNumber += samplesListTrain.get(index).size();
			samplesListTrain.remove(index);
		}
		
		for (List<FeaturedSample> samplesList : samplesLists) {
			for (FeaturedSample sample : samplesList) {
				sample.setTesting(!sample.isTraining());
			}
		}

		// maxTestSamples tells the minimum number of testing samples we want to
		// have
		// even if we have to borrow from training
		int testingToComplete = getMinTestSamples()
				- (samples.size() - trainingNumber);

		if (testingToComplete > 0) {
			int borrowFromTraining = Math
					.min(testingToComplete, trainingNumber);
			boolean[] isBorrowing = new boolean[trainingNumber];
			FeaturedSample[] training = new FeaturedSample[trainingNumber];
			int i = 0;
			for (FeaturedSample sample : samples) {
				if (sample.isTraining()) {
					training[i] = sample;
					i++;
				}
			}
			selectUniform(isBorrowing, borrowFromTraining);
			for (i = 0; i < trainingNumber; i++) {
				if (isBorrowing[i]) {
					training[i].setTesting(true);
				}
			}
		}
	}

	public void setTrainingAndTestingSamples() {
		if (samples.size() == 0) {
			return;
		}
		boolean[] isTraining = new boolean[samples.size()];
		int trainingNumber = selectUniform(isTraining, getMaxTrainSamples());
		for (int i = 0; i < isTraining.length; i++) {
			samples.get(i).setTraining(isTraining[i]);
		}
		boolean[] isTesting = new boolean[samples.size()];
		for (int i = 0; i < isTesting.length; i++) {
			isTesting[i] = !isTraining[i];
		}

		// maxTestSamples tells the minimum number of testing samples we want to
		// have
		// even if we have to borrow from training
		int testingToComplete = getMinTestSamples()
				- (samples.size() - trainingNumber);

		if (testingToComplete > 0) {
			int borrowFromTraining = Math
					.min(testingToComplete, trainingNumber);
			boolean[] isBorrowing = new boolean[trainingNumber];
			int borrowingNumber = selectUniform(isBorrowing, borrowFromTraining);
			int borrowingIndex = 0;
			for (int i = 0; i < isTraining.length; i++) {
				if (isTraining[i] && isBorrowing[borrowingIndex]) {
					isTesting[i] = true;
				}
				if (isTraining[i]) {
					borrowingIndex++;
				}
			}
		}
		for (int i = 0; i < isTesting.length; i++) {
			samples.get(i).setTesting(isTesting[i]);
		}
	}

	public void setAligningSamples() {
		if (samples.size() == 0) {
			return;
		}
		boolean[] isAligning = new boolean[samples.size()];
		int aligningNumber = selectUniform(isAligning, getMaxAlignSamples());
		for (int i = 0; i < isAligning.length; i++) {
			samples.get(i).setAligning(isAligning[i]);
		}
	}
	
	private static int random(int low, int high) {
		Random r = new Random();
		int random = r.nextInt(high-low) + low;
		return random;
	}

	private static int selectUniform(boolean[] selection, int numberToSelect) {
		int selectionSize = selection.length;
		int selected = 0;
		for (int i = 0; i < selectionSize; i++) {
			if (i * numberToSelect >= selectionSize * selected) {
				selection[i] = true;
				selected++;
			} else {
				selection[i] = false;
			}
		}
		return selected;
	}

	public ByteDistribution getByteDistribution() {
		ByteDistribution distribution = new ByteDistribution();
		for (FeaturedSample sample : samples) {
			if (!sample.isAligning()) {
				continue;
			}
			sample.setSequence();
			distribution.add(sample.byteIterator());
			sample.unsetSequence();
		}

		return distribution;
	}

	public int getAligningSamplesCount() {
		int count = 0;
		for (FeaturedSample sample : samples) {
			if (!sample.isAligning()) {
				continue;
			}
			count++;
		}
		return count;
	}

	public Set<NSignature> align(
			NAbstractAligner<INScorableAlignable, INScorableAlignable> aligner) {
		List<FeaturedSample> aligningSamples = new LinkedList<FeaturedSample>();
		for (FeaturedSample sample : samples) {
			if (!sample.isAligning()) {
				continue;
			}
			sample.setSequence();
			aligningSamples.add(sample);
		}
		Collection<INLookupAlignable> signatures = null;
		signatures = aligner.transform(aligningSamples);
		Set<NSignature> signaturesSet = new HashSet<NSignature>();

		for (INLookupAlignable learnedSignature : signatures) {
			NSignature signature = new NSignature(
					((NLearnedSignature) learnedSignature).finalPattern());
			signaturesSet.add(signature);
		}

		for (FeaturedSample sample : samples) {
			if (!sample.isAligning()) {
				continue;
			}
			sample.unsetSequence();
		}

		return signaturesSet;
	}

	public void setSignatures(List<NSignature> signatures) {
		AlignedSignaturesSet signaturesSet = new AlignedSignaturesSet(this,
				signatures);
		setSignaturesSet(signaturesSet);
	}

	public void setSignaturesSet(AlignedSignaturesSet signaturesSet) {
		this.getFormat().updateSignaturesSet(signaturesSet);
	}

	public AlignedSignaturesSet getSignaturesSet() {
		return (AlignedSignaturesSet) getFormat().getSignaturesSet(getName(),
				SignaturesSource.FALSTAFF);
	}

	public SamplesSetMatch getCoverage(FeaturedSignature signature) {
		if (samples == null) {
			return null;
		}
		SamplesSetMatch coverage = new SamplesSetMatch();
		for (INFeaturedAlignable sample : samples) {
			try {
				((FeaturedSample) sample).setSequence();
				boolean isAligned = signature.getSignature().align(sample);
				if (isAligned) {
					coverage.getMatchedSamples().add((FeaturedSample) sample);
				} else {
					coverage.getUnmatchedSamples().add((FeaturedSample) sample);
				}
			} catch (Exception e) {
				continue;
			}
			((FeaturedSample) sample).unsetSequence();
		}

		return coverage;
	}
	
	public Set<TokenFeature> lex(ContentPropertiesFeatureAssigner contentPropertiesFeatureAssigner, Lexer lexer) {
		if (processMonitor != null) {
			processMonitor.setProcessName("loading training samples");
			processMonitor.setPercentageCompleted(0);
			processMonitor.setStatus(ProcessStatus.PROCESS_STARTED);
		}
		List<FeaturedSample> aligningSamples = new LinkedList<FeaturedSample>();
		int count = 0;
		for (FeaturedSample sample : samples) {
			count++;
			if (!sample.isTraining()) {
				continue;
			}
			sample.setSequence();
			aligningSamples.add(sample);
			if (processMonitor != null) {
				processMonitor.setPercentageCompleted(count * 100 / samples.size());
			}
		}
		if (processMonitor != null) {
			processMonitor.setStatus(ProcessStatus.PROCESS_FINISHED);
		}
		contentPropertiesFeatureAssigner.transform(aligningSamples);
		lexer.transform(aligningSamples);
		Set<TokenFeature> tokens = lexer.getFeatures();

		for (FeaturedSample sample : samples) {
			if (!sample.isTraining()) {
				continue;
			}
			sample.unsetSequence();
		}
		return tokens;
		
	}

	public int getMaxTrainSamples() {
		if (maxTrainSamples == null) {
			return maxTrainSamplesDefault;
		}
		return maxTrainSamples;
	}

	public void setMaxTrainSamples(int maxTrainSamples) {
		this.maxTrainSamples = maxTrainSamples;
	}

	public int getMinTestSamples() {
		if (minTestSamples == null) {
			return minTestSamplesDefault;
		}
		return minTestSamples;
	}

	public void setMinTestSamples(int minTestSamples) {
		this.minTestSamples = minTestSamples;
	}

	public int getMaxAlignSamples() {
		if (maxAlignSamples == null) {
			return maxAlignSamplesDefault;
		}
		return maxAlignSamples;
	}

	public void setMaxAlignSamples(int maxAlignSamples) {
		this.maxAlignSamples = maxAlignSamples;
	}

	public FeaturedSamplesSet() {
		sampleURLs = new ArrayList<SamplesUrl>();
		samples = new LinkedList<FeaturedSample>();
	}

	public FeaturedSamplesSet(FileFormat format) {
		super();
		this.format = format;
		setId();
		sampleURLs = new ArrayList<SamplesUrl>();
		samples = new LinkedList<FeaturedSample>();
	}

	public int getId() {
		return id;
	}

	public void setId() {
		id = IdGenerator.getIdGenerator().getId(
				FeaturedSamplesSet.class.getName());
	}

	public void setId(int id) {
		this.id = id;
	}

	public FeaturedSample getSample(int sampleId) {
		if (samples == null) {
			return null;
		}
		for (FeaturedSample sample : samples) {
			if (sample.getId() == sampleId) {
				return sample;
			}
		}
		return null;
	}

	public void addSample(FeaturedSample sample) {
		if (samples == null) {
			samples = new LinkedList<FeaturedSample>();
		}
		samples.add(sample);
	}

	public String getName() {
		return name;
	}

	public Long getIndex() {
		for (int i = 0; i < format.getSamples().size(); i++) {
			if (format.getSamples().get(i).getName().equals(name)) {
				return (long) i;
			}
		}
		return null;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<FeaturedSample> getSamples() {
		return samples;
	}

	public void setSamples(List<FeaturedSample> samples) {
		this.samples = samples;
	}

	public void clearSample(int sampleId) {
		if (samples == null) {
			return;
		}
		for (int i = 0; i < samples.size(); i++) {
			if (samples.get(i).getId() == sampleId) {
				samples.remove(i);
				break;
			}
		}
		return;
	}

	public FileFormat getFormat() {
		return format;
	}

	public void setFormat(FileFormat format) {
		this.format = format;
	}

	public String getFolder() {
		return folder;
	}

	public void setFolder(String folder) {
		this.folder = folder;
	}

	public List<SamplesUrl> getSampleURLs() {
		return new AutoPopulatingList<SamplesUrl>(sampleURLs, SamplesUrl.class);
	}

	public void setSampleURLs(List<SamplesUrl> sampleURLs) {
		this.sampleURLs = new ArrayList<SamplesUrl>(sampleURLs);
	}

	public void addSampleURL(SamplesUrl samplesUrl) {
		sampleURLs.add(samplesUrl);
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public Calendar getCreated() {
		return created;
	}

	public Calendar getUpdated() {
		return updated;
	}

	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}

	public Calendar getFeaturesCreated() {
		return featuresCreated;
	}

	public void setFeaturesCreated(Calendar featuresCreated) {
		this.featuresCreated = featuresCreated;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public List<Datum> getDatum(int simulatedFeaturesNumber) {
		List<Datum> datums = new LinkedList<Datum>();
		for (FeaturedSample sample : samples) {
			if (!sample.isTraining()) {
				continue;
			}
			datums.addAll(sample.getDatum(simulatedFeaturesNumber));
		}
		return datums;
	}

	public void test(int classificationsBatchSize) {
		if (samples == null) {
			return;
		}

		setTestingFeatures(format.getClassifier().getFeatureAssigner(),
				classificationsBatchSize);

		for (FeaturedSample sample : samples) {
			if (!sample.isTesting()) {
				continue;
			}
			ClassificationResults results = format.getClassifier().score(
					sample.getFeatures());
			sample.setTestingResults(results);
			List<ClassificationResult> result = results.getResults();
			if (result.size() > 0) {
				getFormat().getClassifier().updateScores(
						result.get(0).getFormat().getName(),
						getFormat().getName());
			}
		}
	}

	public Boolean isMissClassified() {
		if (samples == null) {
			return false;
		}

		Boolean missClassified = false;

		for (FeaturedSample sample : samples) {
			if (!sample.isTesting()) {
				continue;
			}
			Boolean sampleMissClassified = sample.isMissClassified();
			if (sampleMissClassified == null) {
				return null;
			}
			if (sampleMissClassified) {
				missClassified = true;
			}
		}

		return missClassified;
	}

	public boolean isCorrectlyClassified() {
		if (samples == null) {
			return true;
		}

		for (FeaturedSample sample : samples) {
			if (!sample.isCorrectlyClassified()) {
				return false;
			}
		}

		return true;
	}

	public ProcessMonitor getProcessMonitor() {
		return processMonitor;
	}

	public void setProcessMonitor(ProcessMonitor processMonitor) {
		this.processMonitor = processMonitor;
	}

	public int getPercentageCompleted() {
		return processMonitor.getPercentageCompleted();
	}

	public void setPercentageCompleted(int percentageCompleted) {
		processMonitor.setPercentageCompleted(percentageCompleted);
	}

	public String getProcessName() {
		return processMonitor.getProcessName();
	}

	public void setProcessName(String processName) {
		processMonitor.setProcessName(processName);
	}

	public Calendar getStarted() {
		return processMonitor.getStarted();
	}

	public void setStarted(Calendar started) {
		processMonitor.setStarted(started);
	}

	public ProcessStatus getStatus() {
		return processMonitor.getStatus();
	}

	public void setStatus(ProcessStatus status) {
		processMonitor.setStatus(status);
	}

	public ReentrantReadWriteLock getRwl() {
		if (rwl == null) {
			rwl = new ReentrantReadWriteLock();
		}
		return rwl;
	}

	public void setRwl(ReentrantReadWriteLock rwl) {
		this.rwl = rwl;
	}

	public void download(RemoteSamplesDownloader samplesDownloader)
			throws Exception {
		getRwl().writeLock().lock();

		try {
			processMonitor = new ProcessMonitor();
			processMonitor.setProcessName("downloading files from url "
					+ samplesDownloader.getUrl());
			samplesDownloader.download();
		} catch (Exception e) {
			log.error("download of url " + samplesDownloader.getUrl()
					+ " of samples set " + name + " failed " + e.getMessage());
			processMonitor.setStatus(ProcessStatus.FINISHED);
			throw (e);
		} finally {
			rwl.writeLock().unlock();
		}
	}

	public void setTrainingFeatures(
			NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> featureAssigner,
			int classificationsBatchSize) {
		List<INFeaturedAlignable<IKtup>> trainSamples = new ArrayList<INFeaturedAlignable<IKtup>>();

		for (FeaturedSample sample : getSamples()) {
			if (!sample.isTraining()) {
				continue;
			}
			Set<IFeature> features = sample.getFeatures();
			if (features != null) {
				features.clear();
			}
			trainSamples.add(sample);
		}

		setFeatures(trainSamples, featureAssigner, classificationsBatchSize);
	}

	public void setTestingFeatures(
			NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> featureAssigner,
			int classificationsBatchSize) {
		List<INFeaturedAlignable<IKtup>> testSamples = new ArrayList<INFeaturedAlignable<IKtup>>();
		for (FeaturedSample sample : getSamples()) {
			if (!sample.isTesting()) {
				continue;
			}
			Set<IFeature> features = sample.getFeatures();
			if (features != null) {
				features.clear();
			}
			testSamples.add(sample);
		}

		setFeatures(testSamples, featureAssigner, classificationsBatchSize);

	}

	public void setFeatures(
			NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> featureAssigner,
			int classificationsBatchSize) {
		List<INFeaturedAlignable<IKtup>> samplesAll = new ArrayList<INFeaturedAlignable<IKtup>>();
		for (FeaturedSample sample : getSamples()) {
			sample.getFeatures().clear();
			samplesAll.add(sample);
		}
		setFeatures(samplesAll, featureAssigner, classificationsBatchSize);
	}

	public void setFeatures(
			List<INFeaturedAlignable<IKtup>> featuredSamples,
			NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> featureAssigner,
			int classificationsBatchSize) {
		List<INFeaturedAlignable> classifiedAlignables = new ArrayList<INFeaturedAlignable>();
		int classifiedAlignablesCount = 0;
		int skippedAlignablesCount = 0;
		for (INFeaturedAlignable sample : featuredSamples) {
			try {
				((FeaturedSample) sample).setSequence();
			} catch (Exception e) {
				skippedAlignablesCount++;
				continue;
			}
			classifiedAlignables.add(sample);
			if (classifiedAlignables.size() == classificationsBatchSize
					|| classifiedAlignables.size() == (featuredSamples.size()
							- skippedAlignablesCount - classifiedAlignablesCount)) {
				featureAssigner.transform(classifiedAlignables);
				classifiedAlignablesCount += classifiedAlignables.size();
				for (INFeaturedAlignable classifiedAlignable : classifiedAlignables) {
					((FeaturedSample) classifiedAlignable).unsetSequence();
				}
				classifiedAlignables.clear();
			}
		}
	}
}
