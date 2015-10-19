package com.falstaff.core.aligner;

public class MagicClustererContext extends ClustererContext {

	private int maxMagicPositionShift; 
	private int magicOffset;
	
	public MagicClustererContext() {
		super();
	}

	public MagicClustererContext(int alignmentKtupLength,
			int minScoreAlternativesCount, int ktupScoreCutoff,
			double ktupMinAlignablesFractionCutoff, int minAlignablesCutoff, int maxMagicPositionShift, int magicOffset) {
		super(alignmentKtupLength, minScoreAlternativesCount, ktupScoreCutoff,
				ktupMinAlignablesFractionCutoff, minAlignablesCutoff);
		this.maxMagicPositionShift = maxMagicPositionShift;
		this.magicOffset = magicOffset;
	}

	public int getMaxMagicPositionShift() {
		return maxMagicPositionShift;
	}

	public void setMaxMagicPositionShift(int maxMagicPositionShift) {
		this.maxMagicPositionShift = maxMagicPositionShift;
	}

	public int getMagicOffset() {
		return magicOffset;
	}

	public void setMagicOffset(int magicOffset) {
		this.magicOffset = magicOffset;
	}
}
