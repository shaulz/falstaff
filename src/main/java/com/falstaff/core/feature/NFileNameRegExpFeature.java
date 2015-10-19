package com.falstaff.core.feature;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class NFileNameRegExpFeature extends NAbstractFeature {

	private static final String fileNameRegExpFeaturePrefix = "file_name";

	public NFileNameRegExpFeature(Pattern regExp) {
		super();
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(fileNameRegExpFeaturePrefix).append(featureNameDelimiter).append(regExp.pattern());
		name = nameBuilder.toString();
	}
	
	public NFileNameRegExpFeature() {
		super();
	}



	public static Set<NFileNameRegExpFeature> createFileNameRegExpFeatures(File file, Set<Pattern> regExps) {
		String name = file.getName();

		return createFileNameRegExpFeatures(name, regExps);
	}
	
	public static Set<NFileNameRegExpFeature> createFileNameRegExpFeatures(String fileName, Set<Pattern> regExps) {
		Set<NFileNameRegExpFeature> features = null;
		for (Pattern pattern : regExps) {
			if (!pattern.matcher(fileName).matches()) {
				continue;
			}
			if (features == null) {
				features = new HashSet<NFileNameRegExpFeature>();
			}
			features.add(new NFileNameRegExpFeature(pattern));
		}
		return features;
	}
	
	@Override
	@JsonIgnore
	public FeatureType getType() {
		return FeatureType.file_name_regular_expression;
	}

	@Override
	@JsonIgnore
	public String getValue() {
		return name.substring(fileNameRegExpFeaturePrefix.length() + featureNameDelimiter.length());
	}
	
}
