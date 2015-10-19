package com.falstaff.core.score;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EntropyScoreCalculator extends AbstractScoreCalculator {
	
	private static final Logger log = LoggerFactory
	.getLogger(EntropyScoreCalculator.class.getName());

	public static int maxScore = 10;
	
	private int[][] scoresTable;
	private int minScoreAlternativesCount;
	private Map<Byte,Double> alphabetProbabilities;
	private double alphabetAverageProbability;
	private boolean correctScore = true;
	
	public EntropyScoreCalculator(ByteDistribution alphabet, int dbSize, int minScoreAlternativesCount) {
		super(alphabet, dbSize);
		this.minScoreAlternativesCount = minScoreAlternativesCount;
		initScoresTable();
		initAlphabetProbabilities();
		
		log.info("number of distinct letters in alphabet " + alphabet.getBytes().size());
		for (Byte b : alphabet.getBytes()) {
			int bScore = score(b);
			if (bScore < maxScore) {
				log.warn("byte " + Alphabet.byte2chars(b) + " with high probability " + alphabet.getProbability(b) + " score lowered to " + bScore);
			}
		}
		double entropy = alphabet.getEntropy() / alphabet.getSamplesNumber();
		double maxEntropy = getMaxEntropy(alphabet.getSize()) / alphabet.getSize();
		log.info("alphabet entropy " + entropy + " ,maximum entropy " + maxEntropy);

	}
	
	private void initAlphabetProbabilities() {
		alphabetProbabilities = new HashMap<Byte, Double>();
		for (Byte b : alphabet.getBytes()) {
			alphabetProbabilities.put(b, alphabet.getProbability(b));
		}
		alphabetAverageProbability = alphabet.getAverageProbability();
	}
	
	@Override
	public void setAlphabet(ByteDistribution alphabet) {
		super.setAlphabet(alphabet);
		initAlphabetProbabilities();
	}

	private void initScoresTable() {
		// number of bytes + null
		scoresTable = new int[dbSize][];
		for (int alignablesCount = 0; alignablesCount < dbSize ; alignablesCount++) {
			scoresTable[alignablesCount] = new int[alignablesCount + 1];
		}
		double coefficient = 0.5;
		for (int alignablesCount = 1; alignablesCount <= dbSize ; alignablesCount++) {
			double maxEntropy;
			if (alignablesCount > minScoreAlternativesCount) {
				maxEntropy = ByteDistribution.getNormalizedEntropy(minScoreAlternativesCount, alignablesCount);
			}
			else {
				maxEntropy = getMaxEntropy(alignablesCount);
			}
			for (int distinctBytesCount = 1; distinctBytesCount <= alignablesCount ; distinctBytesCount++) {
				double normalizedEntropy;
				if (distinctBytesCount <= minScoreAlternativesCount) {
					normalizedEntropy = ByteDistribution.getNormalizedEntropy(distinctBytesCount, alignablesCount);
				}
				else {
					normalizedEntropy = maxEntropy;
				}
				
				// make normalizedEntropy to be in the range -0.5 * maxEntropy to 0.5 * maxEntropy
				normalizedEntropy = -normalizedEntropy + coefficient * maxEntropy;
				
				// scale so scores will be in -10 to 10 range
				int score =  (int)Math.round((((double)maxScore) / (coefficient * maxEntropy)) * normalizedEntropy);
				// special case when we want only perfect alignments
				if (minScoreAlternativesCount == 1) {
					if (distinctBytesCount > 1) {
						score = -10000;
					}
					else {
						score = maxScore;
					}
				}
				scoresTable[alignablesCount - 1][distinctBytesCount - 1] = score;
			}
		}
		scoresTable[0][0] = 10;
	}
	
	public int getScore(int alignablesCount, int distinctBytesCount) {
		return scoresTable[alignablesCount - 1][distinctBytesCount -1];
	}

	@Override
	public int score(ByteDistribution d) {
		int samplesNumber = (int)d.getSamplesNumber();
		int distinctBytesCount = d.getSize() + d.getGapCount();
		int scoreValue = getScore(samplesNumber, distinctBytesCount);
		int scoreCorrection = getScoreCorrection(d, scoreValue);
		scoreValue -= scoreCorrection;
		return scoreValue;
	}	
	
	@Override
	public int score(Byte b) {
		int scoreValue = getScore(1, 1);
		int scoreCorrection = getScoreCorrection(b, scoreValue);
		scoreValue -= scoreCorrection;
		return scoreValue;
	}
	
	private int getScoreCorrection(ByteDistribution d, int score) {
		if (!correctScore) {
			return 0;
		}
		if (score <= 0) {
			return 0;
		}
		// calculate alphabet probability
		double alphabetProbability = 0;
		for (Byte b : d.getBytes()) {
			alphabetProbability += alphabetProbabilities.get(b) * d.getByteCount(b);
		}
		alphabetProbability += alphabetAverageProbability * d.getGapCount();
		alphabetProbability /= d.getSamplesNumber();
		int correction = getScoreCorrection(alphabetProbability, score);
		return correction;
	}
	
	private int getScoreCorrection(double alphabetProbability, int score) {
		if (!correctScore) {
			return 0;
		}
		if (score <= 0) {
			return 0;
		}
		double ratio = alphabetProbability / alphabetAverageProbability;
		if (ratio <= 1.0) {
			return 0;
		}
		
		double scoreRatio = Math.log(1.0 / alphabet.getSize()) / Math.log(ratio / alphabet.getSize());
		
		int correctedScore = (int) Math.ceil(((double)score) / scoreRatio);
		int correction = score - correctedScore;
		return correction;
	}
	
	@Override
	public int score(Byte b1, Byte b2) {
		return score(b1, 1, b2, 1);
	}
	
	@Override
	public int score(Byte b1, int b1Count, Byte b2, int b2Count) {
		int samplesNumber = b1Count + b2Count;
		int distinctBytesCount = 0;
		if (b1 == null) {
			if (b2 == null) {
				distinctBytesCount = b1Count + b2Count;
			}
			else {
				distinctBytesCount = b1Count + 1;
			}
		}
		else {
			if (b2 == null) {
				distinctBytesCount = 1 + b2Count;
			}
			else {
				distinctBytesCount = (b1.equals(b2) ? 1 : 2);				
			}
		}
		int scoreValue = getScore(samplesNumber, distinctBytesCount);
		int scoreCorrection = getScoreCorrection(b1, b1Count, b2, b2Count, scoreValue);
		scoreValue -= scoreCorrection;
		return scoreValue;
	}
	
	private int getScoreCorrection(Byte b1, int b1Count, Byte b2, int b2Count, int score) {
		if (score <= 0) {
			return 0;
		}
		double alphabetProbability = 0;
		if (b1 != null) {
			alphabetProbability += alphabetProbabilities.get(b1) * b1Count;
		}
		else {
			alphabetProbability += alphabetAverageProbability * b1Count;
		}
		if (b2 != null) {
			alphabetProbability += alphabetProbabilities.get(b2) * b1Count;
		}
		else {
			alphabetProbability += alphabetAverageProbability * b2Count;
		}
		alphabetProbability /= (b1Count + b2Count);
		int correction = getScoreCorrection(alphabetProbability, score);
		return correction;
	}
	
	private int getScoreCorrection(Byte b, int score) {
		if (score <= 0) {
			return 0;
		}
		double alphabetProbability = 0;
		if (b != null) {
			alphabetProbability += alphabetProbabilities.get(b);
		}
		else {
			alphabetProbability += alphabetAverageProbability;
		}

		int correction = getScoreCorrection(alphabetProbability, score);
		return correction;
	}
		
	private double getMaxEntropy(long samplesNumber) {
		return -samplesNumber * Math.log(1.0 / (double)samplesNumber) / ByteDistribution.LOG_TWO;
	}

	public boolean isCorrectScore() {
		return correctScore;
	}

	public void setCorrectScore(boolean correctScore) {
		this.correctScore = correctScore;
	}
	
}
