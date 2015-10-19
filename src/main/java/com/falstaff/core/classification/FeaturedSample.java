package com.falstaff.core.classification;

import java.io.File;
import java.nio.file.Path;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.alignable.sequence.NScorableSequenceAlignable;
import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;
import com.falstaff.core.feature.IFeature;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.maxent.Datum;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FeaturedSample extends NScorableSequenceAlignable implements IDatumSource, INFeaturedAlignable<IKtup> {

	private String fileName;
	private Set<IFeature> features;
	private Boolean training;
	private Boolean testing;
	private ClassificationResults testingResults;
	private Boolean aligning;
	private Set<NSignature> alignedSignatures;
	// set to which the sample belongs
	private FeaturedSamplesSet samplesSet;
	
	private static final Logger log = LoggerFactory
			.getLogger(FeaturedSample.class.getName());
	
	public FeaturedSample() {
	}
	
	public FeaturedSample(String fileName, FeaturedSamplesSet samplesSet) {
		super();
		this.fileName = fileName;
		this.samplesSet = samplesSet;
		features = new HashSet<IFeature>();
		alignedSignatures = new HashSet<NSignature>();
	}

	public String getPath() {
		return samplesSet.getFolder() + '/' + fileName;
	}

	public File getFile() {
		return new File(getPath());
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public Set<IFeature> getFeatures() {
		if (features == null) {
			features = new HashSet<IFeature>();
		}
		return features;
	}

	public void setFeatures(Set<IFeature> features) {
		this.features = features;
	}
	
	public void addFeature(IFeature feature) {
		if (features == null) {
			features = new HashSet<IFeature>();
		}
		features.add(feature);
	}

	public Boolean isTraining() {
		if (training == null) {
			//log.warn("sample " + fileName + " from samples set " + samplesSet.getName() + " format " + samplesSet.getFormat().getName() + " has training unset");
			return false;
		}
		return training;
	}

	public void setTraining(Boolean training) {
		this.training = training;
	}

	public Boolean isTesting() {
		if (testing == null) {
			log.warn("sample " + fileName + " from samples set " + samplesSet.getName() + " format " + samplesSet.getFormat().getName() + " has testing unset");
			return false;
		}
		return testing;
	}

	public void setTesting(Boolean testing) {
		this.testing = testing;
	}

	public ClassificationResults getTestingResults() {
		return testingResults;
	}

	public void setTestingResults(ClassificationResults testingResults) {
		this.testingResults = testingResults;
	}

	public Boolean isAligning() {
		if (aligning == null) {
			log.warn("sample " + fileName + " from samples set " + samplesSet.getName() + " fromat " + samplesSet.getFormat().getName() + " has aligning unset");
			return false;
		}
		return aligning;
	}
	public void setAligning(Boolean aligning) {
		this.aligning = aligning;
	}
	
	public void setSequence() {
		super.setSequenceFromFile(getFile());
	}
	
	public void unsetSequence() {
		super.setSequenceFromFile((File)null);
	}

	@Override
	public List<Datum> getDatum(int simulatedFeaturesNumber) {
		List<Datum> datums = new LinkedList<Datum>();
		if (training == null || !isTraining() || features == null || features.isEmpty()) {
			return datums;
		}
		Set<String> featureNames = new HashSet<String>();
		for (IFeature feature : features) {
			featureNames.add(feature.getName());
		}
		Datum datum = new Datum(samplesSet.getFormat().getName(), featureNames);
		datums.add(datum);
		return datums;
	}

	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public long getFileSize() {
		return getFile().length();
	}

	@Override
	public long getLastModified() {
		return getFile().lastModified();
	}
	
	public Calendar getLastModifiedCalendar() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(getFile().lastModified());
		return calendar;
	}

	public FeaturedSamplesSet getSamplesSet() {
		return samplesSet;
	}
	
	public Long getIndex() {
		for (int i = 0; i < samplesSet.getSamples().size(); i++) {
			if (samplesSet.getSamples().get(i).getFileName().equals(fileName)) {
				return (long)i;
			}
		}
		return null;		
	}

	@Override
	public Set<NSignature> getAlignedSignatures() {
		if (alignedSignatures == null) {
			alignedSignatures = new HashSet<NSignature>();
		}
		return alignedSignatures;
	}

	@Override
	public void setAlignedSignatures(Set<NSignature> alignedSignatures) {
		this.alignedSignatures = alignedSignatures;
	}
	
	public void filterAlignedSignatures(Set<NSignature> filterSignatures) {
		if (alignedSignatures == null) {
			return;
		}
		Iterator<NSignature> iterator = alignedSignatures.iterator();
		while (iterator.hasNext()) {
			NSignature alignedSignature = iterator.next();
		    if (!filterSignatures.contains(alignedSignature)) {
		        iterator.remove();
		    }
		}
	}
	
	public Boolean isMissClassified() {
		if (testingResults == null) {
			return null;
		}
		
		if (testingResults.getResults() == null) {
			return true;
		}
		
		if (testingResults.getResults().size() == 0) {
			return true;
		}
		
		if (testingResults.getResults().get(0).getFormatName().equals(samplesSet.getFormat().getName())) {
			return false;
		}
		
		return true;
	}
	
	public boolean isCorrectlyClassified() {
		if (testingResults == null) {
			return false;
		}
		
		if (testingResults.getResults() == null) {
			return false;
		}
		
		if (testingResults.getResults().size() == 0) {
			return false;
		}
		
		if (testingResults.getResults().get(0).getFormatName().equals(samplesSet.getFormat().getName())) {
			return true;
		}
		
		return false;
	}

	public String getProject() {
		String project = new File(fileName).toPath().subpath(0, 1).toString();
		return project;
	}
}
