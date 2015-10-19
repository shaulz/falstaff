package com.falstaff.core.feature;

import com.falstaff.core.alignable.signature.NSignature;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class NSignatureFeature extends NAbstractFeature {
	
	private static final String signatureFeaturePrefix = "signature";

	public NSignatureFeature(NSignature signature) {
		super();
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(signatureFeaturePrefix).append(featureNameDelimiter).append(signature.toString());
		name = nameBuilder.toString();
	}
	
	public NSignatureFeature() {
	}

	@Override
	@JsonIgnore
	public FeatureType getType() {
		return FeatureType.signature;
	}

	@Override
	@JsonIgnore
	public String getValue() {
		return name.substring(signatureFeaturePrefix.length() + featureNameDelimiter.length());
	}

}
