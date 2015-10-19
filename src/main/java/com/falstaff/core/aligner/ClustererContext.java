package com.falstaff.core.aligner;

import com.falstaff.core.lookup.LookupTableFactory;
import com.falstaff.core.lookup.LookupTableFactory.LookupType;

public class ClustererContext {

	private int alignmentKtupLength;
	private int minScoreAlternativesCount;
	private int ktupScoreCutoff;
	private double ktupMinAlignablesFractionCutoff;
	private int minAlignablesCutoff;
	private LookupType lookupType;
	
	public ClustererContext() {
		super();
	}

	public ClustererContext(int alignmentKtupLength,
			int minScoreAlternativesCount, int ktupScoreCutoff,
			double ktupMinAlignablesFractionCutoff, int minAlignablesCutoff) {
		super();
		this.alignmentKtupLength = alignmentKtupLength;
		this.minScoreAlternativesCount = minScoreAlternativesCount;
		this.ktupScoreCutoff = ktupScoreCutoff;
		this.ktupMinAlignablesFractionCutoff = ktupMinAlignablesFractionCutoff;
		this.minAlignablesCutoff = minAlignablesCutoff;
	}

	public int getAlignmentKtupLength() {
		return alignmentKtupLength;
	}

	public void setAlignmentKtupLength(int alignmentKtupLength) {
		this.alignmentKtupLength = alignmentKtupLength;
	}

	public int getMinScoreAlternativesCount() {
		return minScoreAlternativesCount;
	}

	public void setMinScoreAlternativesCount(int minScoreAlternativesCount) {
		this.minScoreAlternativesCount = minScoreAlternativesCount;
	}

	public int getKtupScoreCutoff() {
		return ktupScoreCutoff;
	}

	public void setKtupScoreCutoff(int ktupScoreCutoff) {
		this.ktupScoreCutoff = ktupScoreCutoff;
	}

	public double getKtupMinAlignablesFractionCutoff() {
		return ktupMinAlignablesFractionCutoff;
	}

	public void setKtupMinAlignablesFractionCutoff(
			double ktupMinAlignablesFractionCutoff) {
		this.ktupMinAlignablesFractionCutoff = ktupMinAlignablesFractionCutoff;
	}

	public int getMinAlignablesCutoff() {
		return minAlignablesCutoff;
	}

	public void setMinAlignablesCutoff(int minAlignablesCutoff) {
		this.minAlignablesCutoff = minAlignablesCutoff;
	}

	public LookupType getLookupType() {
		return lookupType;
	}

	public void setLookupType(LookupType lookupType) {
		this.lookupType = lookupType;
	}	
}
