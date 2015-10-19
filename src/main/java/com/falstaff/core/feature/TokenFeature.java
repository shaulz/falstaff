package com.falstaff.core.feature;

import com.falstaff.core.classification.FeaturedTokensSet;
import com.falstaff.core.util.IdGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class TokenFeature extends NAbstractFeature {
	
	private static final String tokenFeaturePrefix = "tok";
	private FeaturedTokensSet featuredTokensSet;
	private transient int id;

	public TokenFeature(String token) {
		super();
		StringBuilder nameBuilder = new StringBuilder();
		name = nameBuilder.append(tokenFeaturePrefix).append(featureNameDelimiter).append(token).toString();
		setId();
	}
	
	public TokenFeature(String token1, String token2, String space) {
		super();
		StringBuilder nameBuilder = new StringBuilder();
		nameBuilder.append(tokenFeaturePrefix).append(featureNameDelimiter).append(token1);
		if (space != null && !space.isEmpty()) {
			nameBuilder.append(featureNameDelimiter).append(space);
		}
		nameBuilder.append(featureNameDelimiter).append(token2);
		
		name = nameBuilder.toString();
		setId();
	}

	@Override
	@JsonIgnore
	public FeatureType getType() {
		return FeatureType.token;
	}

	@Override
	public String getValue() {
		return name.substring(tokenFeaturePrefix.length() + featureNameDelimiter.length());
	}
	
	public void setValue(String value) {
		StringBuilder nameBuilder = new StringBuilder();
		name = nameBuilder.append(tokenFeaturePrefix).append(featureNameDelimiter).append(value).toString();
	}
	
	public int getId() {
		return id;
	}

	public void setId() {
		id = IdGenerator.getIdGenerator().getId(TokenFeature.class.getName());
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public FeaturedTokensSet getFeaturedTokensSet() {
		return featuredTokensSet;
	}

	public void setFeaturedTokensSet(FeaturedTokensSet featuredTokensSet) {
		this.featuredTokensSet = featuredTokensSet;
	}

	public Boolean isMissClassified() {
		return null;
	}
}
