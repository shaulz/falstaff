package com.falstaff.core.score;

import java.util.HashMap;
import java.util.Map;

import com.falstaff.core.score.Blast.Blast_KarlinBlk;
import com.falstaff.core.score.Blast.Blast_ScoreFreq;

public abstract class AbstractScoreCalculator implements IScoreCalculator {

	protected ByteDistribution alphabet;
	protected Map<Integer, Kelvin> kelvins;
	protected int dbSize;
	
	public class Kelvin {
		private double lambda;
		private double k;
		private Map<Integer, Double> scoreProbabilities;
		
		public Kelvin(Map<Integer, Double> scoreProbabilities) {
			super();
			this.scoreProbabilities = scoreProbabilities;
			int minScore = getMinScore();
			int maxScore = getMaxScore();
			double kelvinScoreProbabilities[] = new double[maxScore - minScore + 1];
			for (int i = minScore; i <= maxScore; i++) {
				kelvinScoreProbabilities[i] = scoreProbabilities.get(i);
			}
			Blast_ScoreFreq scoreFreq = new Blast_ScoreFreq(minScore , maxScore, kelvinScoreProbabilities);
			Blast_KarlinBlk karlinBlock = new Blast_KarlinBlk();
			int result = Blast.Blast_KarlinBlkUngappedCalc(karlinBlock, scoreFreq);
			lambda = karlinBlock.getLambda();
			k = karlinBlock.getK();
		}
		
		public int getMinScore() {
			int minScore = Integer.MAX_VALUE;
			for (Integer score : scoreProbabilities.keySet()) {
				if (score < minScore) {
					minScore = score;
				}
			}
			return minScore;
		}

		public int getMaxScore() {
			int maxScore = Integer.MIN_VALUE;
			for (Integer score : scoreProbabilities.keySet()) {
				if (score > maxScore) {
					maxScore = score;
				}
			}
			return maxScore;
		}

		public double getLambda() {
			return lambda;
		}

		public double getK() {
			return k;
		}
	}

	public AbstractScoreCalculator(ByteDistribution alphabetDistribution, int dbSize) {
		super();
		this.alphabet = alphabetDistribution;
		this.dbSize = dbSize;
		kelvins = new HashMap<Integer, Kelvin>();
	}
	
	public Kelvin getKelvin(int alignedCount) {
		if (!kelvins.containsKey(alignedCount)) {
			Map<Integer, Double> scoreProbabilities = getScoreProbabilities(alignedCount);
			Kelvin kelvin = new Kelvin(scoreProbabilities);
			kelvins.put(alignedCount, kelvin);
		}
		return kelvins.get(alignedCount);
	}
	
	public void setKelvin(int alignedCount, Kelvin kelvin) {
		kelvins.put(alignedCount, kelvin);
	}

	public Map<Integer, Double> getScoreProbabilities(int alignedCount) {
		Map<Integer, Double> scoreProbabilities = new HashMap<Integer, Double>();
		HashMap<Byte, Double> alphabetByteDistribution = alphabet.getNotZeroDistribution();
		getScoreProbabilities(scoreProbabilities, alphabetByteDistribution, alignedCount, 1.0);
		return scoreProbabilities;
	}
	
	private void getScoreProbabilities(Map<Integer, Double> scoreProbabilities, HashMap<Byte, Double> alphabetByteDistribution, int alignedCount, double columnProbability) {
		ByteDistribution columnDistribution = new ByteDistribution();
		for (Byte b : alphabetByteDistribution.keySet()) {
			columnDistribution.add(b);
			double newColumnProbability = columnProbability * alphabetByteDistribution.get(b);
			if (alignedCount == 0) {
				int score = score(columnDistribution);
				if (!scoreProbabilities.containsKey(score)) {
					scoreProbabilities.put(score, 0.0);
				}
				scoreProbabilities.put(score, scoreProbabilities.get(score) + newColumnProbability);
			}
			else {
				getScoreProbabilities(scoreProbabilities, alphabetByteDistribution, alignedCount - 1, newColumnProbability);
			}
			columnDistribution.remove(b);
		}
	}

	@Override
	public int score(ByteDistribution byteDistribution, Byte b) {
		return score(byteDistribution, b, 1);
	}
	
	@Override
	public int score(ByteDistribution byteDistribution, Byte b, int byteCount) {
		byteDistribution.add(b, byteCount);
		int score = score(byteDistribution);
		byteDistribution.remove(b, byteCount);
		return score;
	}
	
	@Override
	public int score(ByteDistribution d1, ByteDistribution d2) {
		ByteDistribution d = new ByteDistribution(d1, d2);
		return score(d);
	}

	@Override
	public double pvalue(int score, int length, int alignedCount) {
		double eLog = evalueLog(score, length, alignedCount);
		double p = pvalue(eLog);
		return p;		
	}

	@Override
	public double pvalue(int score, int[] alignedLengths) {
		double eLog = evalueLog(score, alignedLengths);
		double p = pvalue(eLog);
		return p;
	}

	@Override
	public double evalue(int score, int length, int alignedCount) {
		int[] alignedLengths = new int[alignedCount];
		for (int i =0; i < alignedCount; i++) {
			alignedLengths[i] = length;
		}
		return evalue(score, alignedLengths);
	}

	@Override
	public double evalue(int score, int[] alignedLengths) {
		double eValueLog = evalueLog(score, alignedLengths);
		double e = Math.exp(eValueLog);
		return e;
	}
	
	private double evalueLog(int score, int length, int alignedCount) {
		int[] alignedLengths = new int[alignedCount];
		for (int i =0; i < alignedCount; i++) {
			alignedLengths[i] = length;
		}
		return evalueLog(score, alignedLengths);
	}
	
	private double evalueLog(int score, int[] alignedLengths) {
		int alignedCount = alignedLengths.length;
		Kelvin kelvin = getKelvin(alignedCount);
		double k = kelvin.getK();
		double lambda = kelvin.getLambda();
		double lengthsLog = 0.0;
		for (int i = 0; i < alignedCount; i++) {
			lengthsLog += Math.log(alignedLengths[i]);
		}
		double eLog = Math.log(k) + lengthsLog + (-lambda * ((double)score));
		eLog += dbScaleLog(alignedCount);
		return eLog;		
	}
	
	private double dbScaleLog(int alignedCount) {
		double scaleLog = 0.0;
		for (int i = dbSize - alignedCount; i <= dbSize; i++) {
			scaleLog += Math.log(i);
		}
		for (int i = 1; i < alignedCount; i++) {
			scaleLog -= Math.log(i);
		}
		return scaleLog;
	}
	
	private double pvalue(double eLog) {
		double e = Math.exp(eLog);
		double p = 1.0 - Math.exp(-e);
		return p;
	}

	@Override
	public void setAlphabet(ByteDistribution alphabet) {
		this.alphabet = alphabet;
	}

	@Override
	public void setDbSize(int dbSize) {
		this.dbSize = dbSize;
	}
}
