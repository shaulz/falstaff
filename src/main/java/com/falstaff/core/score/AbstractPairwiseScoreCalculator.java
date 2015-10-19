package com.falstaff.core.score;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class AbstractPairwiseScoreCalculator extends AbstractScoreCalculator {

	protected final int mismatchPenalty;
	protected final int gapPenalty;	
	protected Map<Byte,Integer> matchScores;
	
	protected AbstractPairwiseScoreCalculator(int mismatchPenalty, int gapPenalty, ByteDistribution alphabet, int dbSize) {
		super(alphabet, dbSize);
		this.mismatchPenalty = mismatchPenalty;
		this.gapPenalty = gapPenalty;
		matchScores = new HashMap<Byte,Integer>();
		initScores(alphabet);
	}
	
	protected abstract void initScores(ByteDistribution alphabet);

	public int score(Byte x) {
		if (x == null) {
			return gapScore();
		}
		return matchScore(x);
	}
	
	public int score(Byte x, Byte y) {
		if (x == null || y == null) {
			return gapScore();
		}			
		if (x != y) {
			return mismatchScore();
		}
		return matchScore(x);
	}
	
	@Override
	public int score(ByteDistribution byteDistribution) {
		Set<Byte> bytes = byteDistribution.getBytes();
		int score = 0;
		for (Byte b1 : bytes) {
			for (Byte b2 : bytes) {
				if (b1.equals(b2)) {
					int pairsCount = byteDistribution.getByteCount(b1) * (byteDistribution.getByteCount(b1) - 1) / 2;
					score += pairsCount * score(b1);
				}
				else {
					score += score(b1, byteDistribution.getByteCount(b1), b2, byteDistribution.getByteCount(b2)) / 2;
				}
			}
		}
		int gapCount = byteDistribution.getGapCount();
		if (gapCount > 0) {
			int pairsCount = gapCount * (gapCount - 1) / 2;
			score += pairsCount * gapScore();
			for (Byte b1 : bytes) {
				score += score(b1, byteDistribution.getByteCount(b1), null, gapCount);
			}
		}
		return score;
	}

	@Override
	public int score(Byte b1, int b1Count, Byte b2, int b2Count) {
		int pairsCount = b1Count * b2Count;
		int scoreValue = pairsCount * score(b1, b2);
		return scoreValue;
	}

	
	protected int mismatchScore() {
		return mismatchPenalty;
	}
	
	protected int gapScore() {
		return gapPenalty;
	}
	
	protected int matchScore(Byte x) {
		return matchScores.get(x);
	}

	@Override
	public void setAlphabet(ByteDistribution alphabet) {
		super.setAlphabet(alphabet);
		initScores(alphabet);
	}
}
