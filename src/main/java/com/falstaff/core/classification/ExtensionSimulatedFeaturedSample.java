package com.falstaff.core.classification;

import java.util.Set;

import com.falstaff.core.feature.IFeature;

public class ExtensionSimulatedFeaturedSample extends SimulatedFeaturedSample {

	private FileFormat format;
	
	@Override
	protected FileFormat getFormat() {
		return format;
	}

	public ExtensionSimulatedFeaturedSample(Set<IFeature> features, FileFormat format) {
		super(features);
		this.format = format;
	}
}
