package com.falstaff.core.classification;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;
import com.falstaff.core.feature.IFeature;
import com.falstaff.core.maxent.Datum;

public abstract class SimulatedFeaturedSample implements IDatumSource {

	private Set<IFeature> features;
	private ClassificationResults testingResults;

	public SimulatedFeaturedSample(Set<IFeature> features) {
		super();
		this.features = features;
	}

	public Set<IFeature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<IFeature> features) {
		this.features = features;
	}

	public ClassificationResults getTestingResults() {
		return testingResults;
	}

	public void setTestingResults(ClassificationResults testingResults) {
		this.testingResults = testingResults;
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
		
		if (testingResults.getResults().get(0).getFormatName().equals(getFormat().getName())) {
			return false;
		}
		
		return true;
	}
	
	@Override
	public List<Datum> getDatum(int simulatedFeaturesNumbe) {
		List<Datum> datums = new LinkedList<Datum>();
		if (features == null || features.isEmpty()) {
			return datums;
		}
		Set<String> featureNames = new HashSet<String>();
		for (IFeature feature : features) {
			featureNames.add(feature.getName());
		}
		Datum datum = new Datum(getFormat().getName(), featureNames);
		datums.add(datum);
		return datums;
	}
	
	protected abstract FileFormat getFormat();

}
