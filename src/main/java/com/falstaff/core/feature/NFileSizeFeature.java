package com.falstaff.core.feature;

import java.io.File;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NFileSizeFeature extends NAbstractFeature {
	
	private static final String fileSizeLogFeaturePrefix = "file_size_log";
	private static final String fileSizeFeaturePrefix = "file_size";

	public NFileSizeFeature(File file) {
		this(file.length(), true);
	}
	
	public NFileSizeFeature() {
	}



	public NFileSizeFeature(File file, Set<Integer> sizes) {
		super();
		StringBuilder nameBuilder = new StringBuilder();
		long length = file.length();
		if (sizes.contains(length)) {
			nameBuilder.append(fileSizeFeaturePrefix).append(featureNameDelimiter).append(length);
			name = nameBuilder.toString();
		}
	}
	
	public NFileSizeFeature(Long length, boolean log) {
		super();
		if (log && length > 0) {
			length = Math.round(Math.log10(length));
		}
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(log ? fileSizeLogFeaturePrefix : fileSizeFeaturePrefix).append(featureNameDelimiter).append(length);
		name = nameBuilder.toString();
	}
	
	public NFileSizeFeature(Long length, Set<Integer> sizes) {
		super();
		StringBuilder nameBuilder = new StringBuilder();
		if (sizes.contains(length)) {
			nameBuilder.append(fileSizeFeaturePrefix).append(featureNameDelimiter).append(length);
			name = nameBuilder.toString();
		}
	}
	
	@Override
	@JsonIgnore
	public FeatureType getType() {
		if (name.startsWith(fileSizeLogFeaturePrefix)) {
			return FeatureType.file_size_log;
		}
		return FeatureType.file_size;
	}

	@Override
	@JsonIgnore
	public String getValue() {
		if (name.startsWith(fileSizeLogFeaturePrefix)) {
			return name.substring(fileSizeLogFeaturePrefix.length() + featureNameDelimiter.length());
		}
		return name.substring(fileSizeFeaturePrefix.length() + featureNameDelimiter.length());
	}
}
