package com.falstaff.core.feature;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class NFileExtensionFeature extends NAbstractFeature {
	
	private static final String fileExtensionFeaturePrefix = "file_extension";

	public NFileExtensionFeature(File file) {
		super();
		int extensionIndex = file.getName().lastIndexOf(".");
		if (extensionIndex < 0) {
			name = null;
		}
		else {
			StringBuilder nameBuilder = new StringBuilder();
			String extension = file.getName().substring(extensionIndex + 1, file.getName().length())
					.toLowerCase();
			nameBuilder.append(fileExtensionFeaturePrefix).append(featureNameDelimiter).append(extension);
			name = nameBuilder.toString();
		}
	}
	
	public NFileExtensionFeature() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NFileExtensionFeature(String fileName, boolean extractExtension) {
		super();
		String extension;
		int extensionIndex = fileName.lastIndexOf(".");
		if (extensionIndex < 0) {
			if (!extractExtension) {
				StringBuilder nameBuilder = new StringBuilder();
				extension = fileName;
				nameBuilder.append(fileExtensionFeaturePrefix).append(featureNameDelimiter).append(extension.toLowerCase());
				name = nameBuilder.toString();
			}
			else {
				name = null;
			}
		}
		else {
			StringBuilder nameBuilder = new StringBuilder();
			extension = fileName.substring(extensionIndex + 1, fileName.length())
					.toLowerCase();
			nameBuilder.append(fileExtensionFeaturePrefix).append(featureNameDelimiter).append(extension);
			name = nameBuilder.toString();
		}		
	}

	@Override
	@JsonIgnore
	public FeatureType getType() {
		return FeatureType.extension;
	}

	@Override
	@JsonIgnore
	public String getValue() {
		return name.substring(fileExtensionFeaturePrefix.length() + featureNameDelimiter.length());
	}	
}
