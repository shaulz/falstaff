package com.falstaff.core.classification;

import java.util.List;
import java.util.Set;

import com.falstaff.core.util.Histogram;

public class NFeature {

	private String format;
	private Set<String> features;
	
	public NFeature(String format, Set<String> features) {
		super();
		this.format = format;
		this.features = features;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public Set<String> getFeatures() {
		return features;
	}

	public void setFeatures(Set<String> features) {
		this.features = features;
	}
	
	public static Histogram<Integer> featuresPerSampleHistogram(List<NFeature> featuresList) {
		
		Histogram<Integer> histogram = new Histogram<Integer>();
		
		for (NFeature feature : featuresList) {
			histogram.increment(feature.getFeatures().size());
		}
		
		return histogram;
	}

	public static Histogram<Integer> featurePercentageHistogram(List<NFeature> featuresList) {
		
		Histogram<Integer> histogram = new Histogram<Integer>();
		
		Histogram<String> featureCounts = new Histogram<String>();
		
		for (NFeature features : featuresList) {
			for (String feature : features.getFeatures()) {
				featureCounts.increment(feature);
			}
		}
		
		for (String feature : featureCounts.keys()) {
			histogram.increment(featureCounts.get(feature) * 100 / featuresList.size());
		}
		
		return histogram;
	}
}
