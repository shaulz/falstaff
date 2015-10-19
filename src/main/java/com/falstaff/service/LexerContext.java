package com.falstaff.service;

import com.falstaff.core.classification.FeaturedTokensSet;

public class LexerContext {

	private int maxTokensCutOff;
	private FeaturedTokensSet tokensSet;
	
	public LexerContext() {
		super();
	}

	public LexerContext(int maxTokensCutOff, FeaturedTokensSet tokensSet) {
		super();
		this.maxTokensCutOff = maxTokensCutOff;
		this.tokensSet = tokensSet;
	}

	public int getMaxTokensCutOff() {
		return maxTokensCutOff;
	}

	public void setMaxTokensCutOff(int maxTokensCutOff) {
		this.maxTokensCutOff = maxTokensCutOff;
	}

	public FeaturedTokensSet getTokensSet() {
		return tokensSet;
	}

	public void setTokensSet(FeaturedTokensSet tokensSet) {
		this.tokensSet = tokensSet;
	}

}
