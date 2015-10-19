package com.falstaff.core.classification;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.aligner.ContentPropertiesFeatureAssigner;
import com.falstaff.core.aligner.NAbstractAligner;
import com.falstaff.core.aligner.NFilePropertiesFeatureAssigner;
import com.falstaff.core.aligner.NSignatureFeatureAssigner;
import com.falstaff.core.aligner.TokenFeaturesAssigner;
import com.falstaff.core.execution.IProcessMonitor;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.execution.ProcessStatus;
import com.falstaff.core.feature.IFeature;
import com.falstaff.core.feature.TokenFeature;
import com.falstaff.core.lookup.INLookupTable;
import com.falstaff.core.lookup.NNTreeLookupTable;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.maxent.Datum;
import com.falstaff.core.maxent.Index;
import com.falstaff.core.maxent.LogConditionalObjectiveFunction;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class FeaturedClassifier extends NClassifier implements IProcessMonitor {

	private static final Logger log = LoggerFactory
			.getLogger(FeaturedClassifier.class.getName());
	
	transient private Map<String, FileFormat> formatMap;
	private Set<NSignature> signatures;
	private Set<TokenFeature> tokens;
	private int ktupLength;
	private double probabilityCutoff;
	private Set<Integer> fileFixedSizes;
	private Set<Pattern> fileNamePatterns;
	transient private NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> featureAssigner;
	private String name;
	private String description = "";
	private Boolean assignFileProperties = true;
	private Calendar trained;
	private Calendar tested;
	private Calendar created;
	private Calendar updated;
	transient protected ProcessMonitor processMonitor = null;
	private transient ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

	public static class ClassificationResults {

		private Set<IFeature> features;
		private List<ClassificationResult> results;
		transient private double probabilityCutoff;

		public class ClassificationResult {
			transient private FileFormat format;
			private String formatName;
			private double probability;

			public ClassificationResult(FileFormat format, double probability) {
				super();
				this.format = format;
				this.formatName = format.getName();
				this.probability = probability;
			}

			public FileFormat getFormat() {
				return format;
			}

			public void setFormat(FileFormat format) {
				this.format = format;
				this.formatName = format.getName();
			}

			public double getProbability() {
				return probability;
			}

			public void setProbability(double probability) {
				this.probability = probability;
			}

			public String getFormatName() {
				return formatName;
			}
		}

		private class ClassificationResultComparator implements
				Comparator<ClassificationResult> {

			@Override
			public int compare(ClassificationResult r1, ClassificationResult r2) {
				Double p2 = r2.getProbability();
				Double p1 = r1.getProbability();
				return p2.compareTo(p1);
			}
		}

		public ClassificationResults(double probabilityCutoff) {
			super();
			this.probabilityCutoff = probabilityCutoff;
			results = new ArrayList<ClassificationResult>();
		}

		public void addResult(ClassificationResult result) {
			if (result.getProbability() < probabilityCutoff) {
				return;
			}
			results.add(result);
			Collections.sort(results, new ClassificationResultComparator());
		}

		public void addResult(FileFormat format, double probability) {
			if (probability < probabilityCutoff) {
				return;
			}
			ClassificationResult result = new ClassificationResult(format,
					probability);
			addResult(result);
		}

		public ClassificationResult bestResult() {
			return results.get(0);
		}

		public List<ClassificationResult> getResults() {
			return results;
		}

		public void removeLowProbabilityResults(double probabilityCutoff) {
			List<ClassificationResult> allResults = getResults();
			List<ClassificationResult> highProbabilityResults = new ArrayList<ClassificationResult>();
			for (int i = 0; i < allResults.size(); i++) {
				if (allResults.get(i).getProbability() < probabilityCutoff) {
					break;
				}
				highProbabilityResults.add(allResults.get(i));
			}
			results = highProbabilityResults;
		}
		
		public Set<IFeature> getFeatures() {
			return features;
		}

		public void setFeatures(Set<IFeature> features) {
			this.features = features;
		}

	}

	public FeaturedClassifier(String name, int ktupLength, double probabilityCutoff, Set<FileFormat> formats) {
		super();
		this.name = name;
		this.ktupLength = ktupLength;
		this.probabilityCutoff = probabilityCutoff;
		formatMap = new HashMap<String, FileFormat>();
		formatIndex = new Index();
		for (FileFormat format : formats) {
			formatMap.put(format.getName(), format);
			formatIndex.add(format.getName());
		}
	}
	
	public FeaturedClassifier(String name, int ktupLength, double probabilityCutoff) {
		this(name, ktupLength, probabilityCutoff, new HashSet<FileFormat>());
	}
	
	public FeaturedClassifier(String name) {
		this.name = name;
		formatMap = new HashMap<String, FileFormat>();
	}

	public FeaturedClassifier() {
		super();
	}

	public void addFormat(FileFormat fileFormat) {
		if (formatMap == null) {
			formatMap = new HashMap<String, FileFormat>();
		}
		formatMap.put(fileFormat.getName(), fileFormat);
	}
	
	public FileFormat deleteFormat(FileFormat fileFormat) {
		if (formatMap != null) {
			return formatMap.remove(fileFormat.getName());
		}
		return null;
	}
	
	public FileFormat deleteFormat(String formatName) {
		if (formatMap != null) {
			return formatMap.remove(formatName);
		}
		return null;
	}
	
	

	@JsonIgnore
	public Collection<FileFormat> getFormats() {
		if (formatMap == null) {
			formatMap = new HashMap<String, FileFormat>();
		}
		return formatMap.values();
	}

	public ClassificationResults score(Collection<IFeature> features) {
		ClassificationResults results = new ClassificationResults(probabilityCutoff);

		rwl.readLock().lock();
		
		try {
			int formatsCount = getFormatsCount();
			double[] scores = new double[formatsCount];
			for (int i = 0; i < formatsCount; i++) {
				scores[i] = 0.0;
			}
			for (IFeature feature : features) {
				double[] featureScores = formatsWeights(feature);
				if (featureScores == null) {
					continue;
				}
				for (int i = 0; i < formatsCount; i++) {
					scores[i] += featureScores[i];
				}
			}
			double Z = LogConditionalObjectiveFunction.logSum(scores);
			for (int i = 0; i < formatsCount; i++) {
				scores[i] = Math.exp(scores[i] - Z);
			}

			for (int i = 0; i < formatsCount; i++) {
				FileFormat fileFormat = formatMap.get(getFormat(i));
				if (fileFormat != null) {
					results.addResult(fileFormat, scores[i]);
				}
			}
		} catch (Exception e) {
			log.error("score by classifier " + name  + " failed " + e.getMessage());
		}finally {
			rwl.readLock().unlock();
		}
		
		return results;
	}
	
	public void setFeatureAssigner() {
		if (signatures == null) {
			signatures = new HashSet<NSignature>();
		}
		
		if (fileFixedSizes == null) {
			fileFixedSizes = new HashSet<Integer>();
		}
		
		if (fileNamePatterns == null) {
			fileNamePatterns = new HashSet<Pattern>();
		}
		
		if (tokens == null) {
			tokens = new HashSet<TokenFeature>();
		}
		
		featureAssigner = getFeatureAssigner(signatures, ktupLength, tokens, fileFixedSizes, fileNamePatterns, assignFileProperties);
	}
	
	public static NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> getFeatureAssigner(Set<NSignature> signatures, int alignmentKtupLength, Set<TokenFeature> tokens, Set<Integer> fileFixedSizes, Set<Pattern> fileNamePatterns, Boolean assignFileProperties) {
		ContentPropertiesFeatureAssigner contentPropertiesFeatureAssigner = new ContentPropertiesFeatureAssigner();
		NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> lastAligner = contentPropertiesFeatureAssigner;
		if (signatures != null && !signatures.isEmpty()) {
			INLookupTable<IKtup> signaturesLookup = new NNTreeLookupTable<IKtup>(alignmentKtupLength);		
			NSignatureFeatureAssigner signatureFeatureAssigner = new NSignatureFeatureAssigner(signaturesLookup, signatures);
			lastAligner.setNext(signatureFeatureAssigner);
			lastAligner = signatureFeatureAssigner;
		}
		if (tokens != null && !tokens.isEmpty()) {
			TokenFeaturesAssigner tokenFeaturesAssigner = new TokenFeaturesAssigner(tokens);
			lastAligner.setNext(tokenFeaturesAssigner);
			lastAligner = tokenFeaturesAssigner;
		}
		if (assignFileProperties == null || assignFileProperties) {
			NFilePropertiesFeatureAssigner filePropertiesAssigner = new NFilePropertiesFeatureAssigner();
			filePropertiesAssigner.setFileSizes(fileFixedSizes);
			filePropertiesAssigner.setFileNamePatterns(fileNamePatterns);
			lastAligner.setNext(filePropertiesAssigner);
		}

		return contentPropertiesFeatureAssigner;
	}
	
	public void train(int simulatedFeaturesNumber, int classificationsBatchSize, int alignmentKtupLength, double probabilityCutoff, Set<Integer> fixedSizes, Set<Pattern> namePatterns) {
		
		rwl.writeLock().lock();
		
		try {
			processMonitor = new ProcessMonitor();
			processMonitor.setProcessName("train");
			Collection<FileFormat> formats = getFormats();
			
			// temporary reset everything
			trained = null;
			for (FileFormat format : formats) {
				List<FeaturedSignaturesSet> signaturesSets = format.getSignatures();
				if (signaturesSets == null) {
					continue;
				}
				for (FeaturedSignaturesSet signaturesSet : signaturesSets) {
					List<FeaturedSignature> featuredSignatures = signaturesSet.getSignatures();
					for (FeaturedSignature featuredSignature : featuredSignatures) {
						featuredSignature.getSignature().resetFeatureSignatures();
					}
				}
			}
			for (FileFormat format : formats) {
				List<FeaturedSamplesSet> samplesSets = format.getSamples();
				if (samplesSets == null) {
					continue;
				}
				for (FeaturedSamplesSet samplesSet : samplesSets) {
					if (trained == null || trained.before(samplesSet.getUpdated())) {
						List<FeaturedSample> samples = samplesSet.getSamples();
						if (samples == null) {
							continue;
						}
						for (FeaturedSample sample : samples) {
							sample.setAlignedSignatures(null);
							sample.setFeatures(null);
						}
					}
				}
			}
			
			
			// collect all existing featured signatures
			processMonitor.setProcessName("train : find all featured signatures");
			int done = 0;
			Set<NSignature> featuredSignaturesAll = new HashSet<NSignature>();
			for (FileFormat format : formats) {
				List<FeaturedSignaturesSet> signaturesSets = format.getSignatures();
				if (signaturesSets == null) {
					done++;
					processMonitor.setPercentageCompleted(done * 100 / formats.size());
					continue;
				}
				for (FeaturedSignaturesSet signaturesSet : signaturesSets) {
					List<FeaturedSignature> featuredSignatures = signaturesSet.getSignatures();
					for (FeaturedSignature featuredSignature : featuredSignatures) {
						NSignature signature = featuredSignature.getSignature();
						featuredSignaturesAll.addAll(signature.getBaseFeatureSignatures());
					}
				}
				done++;
				processMonitor.setPercentageCompleted(done * 100 / formats.size());
			}
			
			// filter featured signatures, so not existing featured signatures are deleted
			processMonitor.setProcessName("train : remove features of deleted signatures");
			done = 0;
			for (FileFormat format : formats) {
				List<FeaturedSignaturesSet> signaturesSets = format.getSignatures();
				if (signaturesSets == null) {
					done++;
					processMonitor.setPercentageCompleted(done * 100 / formats.size());
					continue;
				}
				for (FeaturedSignaturesSet signaturesSet : signaturesSets) {
					List<FeaturedSignature> featuredSignatures = signaturesSet.getSignatures();
					for (FeaturedSignature featuredSignature : featuredSignatures) {
						NSignature signature = featuredSignature.getSignature();
						signature.filterFeatureSignatures(featuredSignaturesAll);
					}
				}
				done++;
				processMonitor.setPercentageCompleted(done * 100 / formats.size());
			}
			
			// update featured signatures of the signature sets that where updated after the last training
			// collect all signatures that where updated after the last training
			processMonitor.setProcessName("train : find updated/new signatures");
			done = 0;
			List<NSignature> updatedSignaturesAll = new LinkedList<NSignature>();
			List<NSignature> signaturesAll = new LinkedList<NSignature>();
			for (FileFormat format : formats) {
				List<FeaturedSignaturesSet> signaturesSets = format.getSignatures();
				if (signaturesSets == null) {
					done++;
					processMonitor.setPercentageCompleted(done * 100 / formats.size());
					continue;
				}
				for (FeaturedSignaturesSet signaturesSet : signaturesSets) {
					List<FeaturedSignature> featuredSignatures = signaturesSet.getSignatures();
					for (FeaturedSignature featuredSignature : featuredSignatures) {
						NSignature signature = featuredSignature.getSignature();
						signaturesAll.add(signature);
						if (trained != null && !trained.before(signaturesSet.getUpdated())) {
							continue;
						}
						updatedSignaturesAll.add(signature);
					}
				}
				done++;
				processMonitor.setPercentageCompleted(done * 100 / formats.size());
			}
			
			/*
			
			// mutually update all signatures with updated signatures
			processMonitor.setProcessName("train : create signatures features");
			done = 0;
			for (NSignature signature : signaturesAll) {
				for (NSignature updatedSignature : updatedSignaturesAll) {
					if (updatedSignature == signature) {
						continue;
					}
					//log.warn("extending feature signatures of signature " + signature.getPattern().toString() + " with signature " + classifierSignature.getPattern().toString());
					signature.setSupersetFeatureSignatures(updatedSignature);
					updatedSignature.setSupersetFeatureSignatures(signature);
				}
				done++;
				processMonitor.setPercentageCompleted(done * 100 / signaturesAll.size());
			}
			
			*/
			
			// create signature set features
			processMonitor.setProcessName("train : create simulated samples");
			done = 0;
			for (FileFormat format : formats) {
				List<FeaturedSignaturesSet> signaturesSets = format.getSignatures();
				if (signaturesSets == null) {
					done++;
					processMonitor.setPercentageCompleted(done * 100 / formats.size());
					continue;
				}
				for (FeaturedSignaturesSet signaturesSet : signaturesSets) {
					signaturesSet.setSimulatedSamples();
				}
				done++;
				processMonitor.setPercentageCompleted(done * 100 / formats.size());
			}
			
			// delete not existing signatures from samples sets
			Set<NSignature> updatedSignaturesAllSet = new HashSet<NSignature>(updatedSignaturesAll);
			for (FileFormat format : formats) {
				List<FeaturedSamplesSet> samplesSets = format.getSamples();
				if (samplesSets == null) {
					continue;
				}
				for (FeaturedSamplesSet samplesSet : samplesSets) {
					List<FeaturedSample> samples = samplesSet.getSamples();
					for (FeaturedSample sample : samples) {
						sample.filterAlignedSignatures(updatedSignaturesAllSet);
					}
				}
			}
			
			// collect all existing featured signatures
			processMonitor.setProcessName("train : find all token features");
			done = 0;
			Set<TokenFeature> tokenFeaturesAll = new HashSet<TokenFeature>();
			for (FileFormat format : formats) {
				List<FeaturedTokensSet> tokensSets = format.getTokens();
				if (tokensSets == null || tokensSets.isEmpty()) {
					done++;
					processMonitor.setPercentageCompleted(done * 100 / formats.size());
					continue;
				}
				for (FeaturedTokensSet tokensSet : tokensSets) {
					Set<TokenFeature> tokenFeatures = tokensSet.getTokens();
					tokenFeaturesAll.addAll(tokenFeatures);
				}
				done++;
				processMonitor.setPercentageCompleted(done * 100 / formats.size());
			}
			
			// align updated samples sets with all signatures
			processMonitor.setProcessName("train : create training features for added samples");
			done = 0;
			Set<NSignature> signaturesAllSet = new HashSet<NSignature>(signaturesAll);
			NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> signatureFeatureAssignerAll = getFeatureAssigner(signaturesAllSet, alignmentKtupLength, tokenFeaturesAll, fixedSizes, namePatterns, assignFileProperties);
			for (FileFormat format : formats) {
				List<FeaturedSamplesSet> samplesSets = format.getSamples();
				if (samplesSets == null) {
					done++;
					processMonitor.setPercentageCompleted(done * 100 / formats.size());
					continue;
				}
				for (FeaturedSamplesSet samplesSet : samplesSets) {
					if (trained == null || trained.before(samplesSet.getUpdated())) {
						samplesSet.setTrainingFeatures(signatureFeatureAssignerAll, classificationsBatchSize);
					}
				}
				done++;
				processMonitor.setPercentageCompleted(done * 100 / formats.size());
			}
			
			// align not updated samples sets with updated signatures
			processMonitor.setProcessName("train : create training features for all samples");
			done = 0;
			NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> signatureFeatureAssignerUpdated = getFeatureAssigner(updatedSignaturesAllSet, alignmentKtupLength, tokenFeaturesAll, fixedSizes, namePatterns, assignFileProperties);
			for (FileFormat format : formats) {
				List<FeaturedSamplesSet> samplesSets = format.getSamples();
				if (samplesSets == null) {
					done++;
					processMonitor.setPercentageCompleted(done * 100 / formats.size());
					continue;
				}
				for (FeaturedSamplesSet samplesSet : samplesSets) {
					if (trained != null && !trained.before(samplesSet.getUpdated())) {
						samplesSet.setTrainingFeatures(signatureFeatureAssignerUpdated, classificationsBatchSize);
					}
				}
				done++;
				processMonitor.setPercentageCompleted(done * 100 / formats.size());
			}
			
			for (FileFormat format : formats) {
				format.setSimulatedSamples();
			}
			
			// get datum
			List<Datum> datum = new LinkedList<Datum>();
			for (FileFormat format : formats) {
				datum.addAll(format.getDatum(simulatedFeaturesNumber));
			}
			
			processMonitor.setProcessName("train : create features weights");
			done = 0;
			train(datum);
			
			this.ktupLength = alignmentKtupLength;
			this.probabilityCutoff = probabilityCutoff;
			this.featureAssigner = signatureFeatureAssignerAll;
			this.signatures = signaturesAllSet;
			this.fileFixedSizes = fixedSizes;
			this.fileNamePatterns = namePatterns;
			this.tokens = tokenFeaturesAll;
			
			resetRelevance();
			
			trained = Calendar.getInstance();
			
			// initialize testing results
			
			for (FileFormat format : formats) {
				format.clearTestingResults();
			}
			
			tested = null;
			
		} catch (Exception e) {
			log.error("train of classifier " + name  + " failed " + e.getMessage());
			processMonitor.setStatus(ProcessStatus.FINISHED);
			throw(e);
		} finally {
			rwl.writeLock().unlock();
		}
		
	}
	
	public void test(int classificationsBatchSize) {
		rwl.writeLock().lock();
		
		try {
			processMonitor = new ProcessMonitor();		
			processMonitor.setProcessName("test");
			
			resetRelevance();
			initScores();
			
			Collection<FileFormat> formats = getFormats();
			for (FileFormat format : formats) {
				format.clearTestingResults();
			}
			
			tested = null;
			
			processMonitor.setProcessName("test samples");
			int done = 0;
			for (FileFormat format : formats) {
				List<FeaturedSamplesSet> samplesSets = format.getSamples();
				if (samplesSets == null) {
					done++;
					processMonitor.setPercentageCompleted(done * 100 / formats.size());
					continue;
				}
				for (FeaturedSamplesSet samplesSet : samplesSets) {
					samplesSet.test(classificationsBatchSize);
				}
				done++;
				processMonitor.setPercentageCompleted(done * 100 / formats.size());
			}

			processMonitor.setProcessName("test signature simulated samples");
			done = 0;
			for (FileFormat format : formats) {
				List<FeaturedSignaturesSet> signaturesSets = format.getSignatures();
				if (signaturesSets == null) {
					done++;
					processMonitor.setPercentageCompleted(done * 100 / formats.size());
					continue;
				}

				for (FeaturedSignaturesSet signaturesSet : signaturesSets) {
					signaturesSet.test();
				}
				done++;
				processMonitor.setPercentageCompleted(done * 100 / formats.size());
			}

			processMonitor.setProcessName("test extension simulated samples");
			done = 0;
			for (FileFormat format : formats) {
				format.test();
				done++;
				processMonitor.setPercentageCompleted(done * 100 / formats.size());
			}
			
			initPrecision();
			initRecall();
			initF();
			
			for (FileFormat format : formats) {
				format.setMissClassified();
			}
			
			tested = Calendar.getInstance();
		} catch (Exception e) {
			log.error("test of classifier " + name  + " failed " + e.getMessage());
			processMonitor.setStatus(ProcessStatus.FINISHED);
			throw(e);
		} finally {
			rwl.writeLock().unlock();
		}		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public Set<NSignature> getSignatures() {
		return signatures;
	}

	public void setSignatures(Set<NSignature> signatures) {
		this.signatures = signatures;
	}

	public int getKtupLength() {
		return ktupLength;
	}

	public void setKtupLength(int ktupLength) {
		this.ktupLength = ktupLength;
	}

	@JsonIgnore
	public Set<Integer> getFileFixedSizes() {
		return fileFixedSizes;
	}

	public void setFileFixedSizes(Set<Integer> fileFixedSizes) {
		this.fileFixedSizes = fileFixedSizes;
	}

	@JsonIgnore
	public Set<Pattern> getFileNamePatterns() {
		return fileNamePatterns;
	}

	public void setFileNamePatterns(Set<Pattern> fileNamePatterns) {
		this.fileNamePatterns = fileNamePatterns;
	}

	public double getProbabilityCutoff() {
		return probabilityCutoff;
	}

	public void setProbabilityCutoff(double probabilityCutoff) {
		this.probabilityCutoff = probabilityCutoff;
	}

	@JsonIgnore
	public NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> getFeatureAssigner() {
		if (featureAssigner == null) {
			setFeatureAssigner();
		}
		return featureAssigner;
	}

	public void setFeatureAssigner(NSignatureFeatureAssigner featureAssigner) {
		this.featureAssigner = featureAssigner;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public Boolean getAssignFileProperties() {
		return assignFileProperties;
	}

	public void setAssignFileProperties(Boolean assignFileProperties) {
		this.assignFileProperties = assignFileProperties;
	}

	public Calendar getTrained() {
		return trained;
	}

	public void setTrained(Calendar trained) {
		this.trained = trained;
	}

	public Calendar getTested() {
		return tested;
	}

	public void setTested(Calendar tested) {
		this.tested = tested;
	}

	public Calendar getCreated() {
		return created;
	}

	public void setCreated(Calendar created) {
		this.created = created;
	}

	public Calendar getUpdated() {
		return updated;
	}

	public void setUpdated(Calendar updated) {
		this.updated = updated;
	}
	
	@JsonIgnore
	public ProcessMonitor getProcessMonitor() {
		return processMonitor;
	}

	public void setProcessMonitor(ProcessMonitor processMonitor) {
		this.processMonitor = processMonitor;
	}

	@JsonIgnore
	public int getPercentageCompleted() {
		return processMonitor.getPercentageCompleted();
	}

	public void setPercentageCompleted(int percentageCompleted) {
		processMonitor.setPercentageCompleted(percentageCompleted);
	}

	@JsonIgnore
	public String getProcessName() {
		return processMonitor.getProcessName();
	}

	public void setProcessName(String processName) {
		processMonitor.setProcessName(processName);
	}

	@JsonIgnore
	public Calendar getStarted() {
		return processMonitor.getStarted();
	}

	public void setStarted(Calendar started) {
		processMonitor.setStarted(started);
	}

	@JsonIgnore
	public ProcessStatus getStatus() {
		return processMonitor.getStatus();
	}

	public void setStatus(ProcessStatus status) {
		processMonitor.setStatus(status);
	}

	@JsonIgnore
	public ReentrantReadWriteLock getRwl() {
		return rwl;
	}

	public void setRwl(ReentrantReadWriteLock rwl) {
		this.rwl = rwl;
	}
}
