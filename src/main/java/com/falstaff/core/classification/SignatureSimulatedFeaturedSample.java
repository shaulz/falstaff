package com.falstaff.core.classification;

import java.util.Set;

import com.falstaff.core.feature.IFeature;

public class SignatureSimulatedFeaturedSample extends SimulatedFeaturedSample {

	private FeaturedSignature signature;
	
	public SignatureSimulatedFeaturedSample(Set<IFeature> features, FeaturedSignature signature) {
		super(features);
		this.signature = signature;
	}

	@Override
	protected FileFormat getFormat() {
		return signature.getSignaturesSet().getFormat();
	}

}
