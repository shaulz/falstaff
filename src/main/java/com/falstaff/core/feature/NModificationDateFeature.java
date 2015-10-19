package com.falstaff.core.feature;

import java.io.File;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NModificationDateFeature extends NAbstractFeature {
	
	private static final String fileModificationDateFeaturePrefix = "file_modification_date";

	public NModificationDateFeature(File file) {
		this(file.lastModified());
	}
	
	public NModificationDateFeature(long lastModified) {
		super();
		StringBuilder nameBuilder = new StringBuilder();
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(lastModified);
		int year = calendar.get(Calendar.YEAR);
		nameBuilder.append(fileModificationDateFeaturePrefix).append(featureNameDelimiter).append(year);
		name = nameBuilder.toString();
	}
	
	public NModificationDateFeature() {
	}

	@Override
	@JsonIgnore
	public FeatureType getType() {
		return FeatureType.file_modification_date;
	}

	@Override
	@JsonIgnore
	public String getValue() {
		return name.substring(fileModificationDateFeaturePrefix.length() + featureNameDelimiter.length());
	}

}
