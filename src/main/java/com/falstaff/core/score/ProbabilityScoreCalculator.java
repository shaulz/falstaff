package com.falstaff.core.score;

import java.util.HashMap;
import java.util.Map;

import javax.management.RuntimeErrorException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProbabilityScoreCalculator extends AbstractPairwiseScoreCalculator {
	
	private static final Logger log = LoggerFactory
	.getLogger(ProbabilityScoreCalculator.class.getName());
	
	public static int MAX_SCORE = 10;
	public static int MIN_SCORE = 0;
	
	public ProbabilityScoreCalculator(int mismatchPenalty, int gapPenalty,
			ByteDistribution alphabet) {
		super(mismatchPenalty, gapPenalty, alphabet, 1);
	}
	
	protected void initScores(ByteDistribution alphabet) {
		matchScores.clear();
		double averageProbability = alphabet.getAverageProbability();
		for (int i = 0; i <= Byte.MAX_VALUE - Byte.MIN_VALUE; i++) {
			Byte b = new Byte((byte) i);
			double byteProbability = alphabet.getProbability(b);
			int score = (int) Math.round(((double)MAX_SCORE) * averageProbability / ( averageProbability + byteProbability));
			matchScores.put(b, score);
			log.info("score of byte " + Alphabet.byte2hex(b) + " is " + score); 
		}	
	}
}
