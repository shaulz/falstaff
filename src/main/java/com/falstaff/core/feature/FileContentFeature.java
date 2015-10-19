package com.falstaff.core.feature;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class FileContentFeature extends NAbstractFeature {

	private static final String fileContentFeaturePrefix = "file_content";
	
	public FileContentFeature() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileContentFeature(String content, String contentValue) {
		super();
		StringBuilder nameBuilder = new StringBuilder();
		name = nameBuilder.append(fileContentFeaturePrefix).append(featureNameDelimiter).append(content).append(featureNameDelimiter).append(contentValue).toString();
	}

	@Override
	@JsonIgnore
	public FeatureType getType() {
		return FeatureType.file_content;
	}

	@Override
	@JsonIgnore
	public String getValue() {
		return name.substring(fileContentFeaturePrefix.length() + featureNameDelimiter.length());
	}

}
