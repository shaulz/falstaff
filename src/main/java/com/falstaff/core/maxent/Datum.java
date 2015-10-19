package com.falstaff.core.maxent;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Datum {
	private String label;
	private List<String> features;
	
	
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public List<String> getFeatures() {
		return features;
	}
	public void setFeatures(List<String> features) {
		this.features = features;
	}
	public Datum(String label, Collection<String> features) {
		super();
		this.label = label;
		this.features = new LinkedList<String>();
		this.features.addAll(features);
	}
	
}
