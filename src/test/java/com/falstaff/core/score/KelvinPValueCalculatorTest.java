package com.falstaff.core.score;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.falstaff.core.score.AbstractScoreCalculator.Kelvin;

public class KelvinPValueCalculatorTest {

	@Test
	public void testBlast() {
		double[] probabilitiesPositive = {0.3,0.1,0.6};
		Blast.Blast_ScoreFreq scoreFreq = new Blast.Blast_ScoreFreq(-1,1, probabilitiesPositive);
		
		Blast.Blast_KarlinBlk karlinBlock = new Blast.Blast_KarlinBlk();
		
		int result = Blast.Blast_KarlinBlkUngappedCalc(karlinBlock, scoreFreq);
		
		assertEquals(1, result);
		
		double[] probabilitiesSpecial = {0.6,0.1,0.3};
		
		scoreFreq = new Blast.Blast_ScoreFreq(-1,1, probabilitiesSpecial);
		
		Blast.Blast_KarlinBlk karlinBlockSpecial = new Blast.Blast_KarlinBlk();
		
		result = Blast.Blast_KarlinBlkUngappedCalc(karlinBlockSpecial, scoreFreq);

		assertEquals(0, result);
		
		assertEquals(karlinBlockSpecial.getLambda(), Math.log(0.6/0.3),0.00000000000001);
		
		assertEquals(karlinBlockSpecial.getK(), (0.6 - 0.3) * (0.6 - 0.3) / 0.6, 0.00000000000001);
		
		double[] probabilities = {0.000000000001, 0.6,0.1,0.3,0.000000000001};
		
		scoreFreq = new Blast.Blast_ScoreFreq(-2,2, probabilities);
		
		karlinBlock = new Blast.Blast_KarlinBlk();
		
		result = Blast.Blast_KarlinBlkUngappedCalc(karlinBlock, scoreFreq);

		assertEquals(0, result);
		
		assertEquals(karlinBlockSpecial.getLambda(), karlinBlock.getLambda(),0.000000001);
		
		assertEquals(karlinBlockSpecial.getK(), karlinBlock.getK(), 0.001);

		double sum = 0.0;
		
		for (int i = 0 ; i < 5; i ++) {
			sum += probabilities[i] * Math.exp((i - 2) * karlinBlock.getLambda());
		}
		
		assertEquals(1.0,sum,0.000000001);

	}
	
	@Test
	public void testCalculator() {
		int maxScore = 9;
		int minScore = -2;
		double probabilities[] = new double[maxScore - minScore + 1];
		for (int i = 0; i < probabilities.length; i++) {
			probabilities[i] = 0.0;
		}
		
		double positiveProbabilities = 0.0;
		for (int i = 1; i <= maxScore; i++) {
			int c = Math.abs(5 - i) + 1;
			if (i <= 5)
				probabilities[i - minScore] = ((double)i) * 1.0 / 256.0;
			else
				probabilities[i - minScore] = 1.0 / 256.0 / ((double)i);
			positiveProbabilities += probabilities[i - minScore];
		}
		probabilities[0] = 1.0 - positiveProbabilities;
		Map<Integer, Double> probabilitiesMap = new HashMap();
		for (int i = 0; i < probabilities.length; i++) {
			probabilitiesMap.put(i,  probabilities[i]);
		}
		EntropyScoreCalculator calculator = new EntropyScoreCalculator(new ByteDistribution(), 250, 25);
		Kelvin kelvin = calculator.new Kelvin(probabilitiesMap);
		calculator.setKelvin(250, kelvin);
		int score = 28;
		double evalue = calculator.evalue( score , (int)Math.pow(2.0, 17.0), 250);
		double pvalue = calculator.pvalue( score , (int)Math.pow(2.0, 17.0), 250);
		System.out.println("evalue " + evalue + " pvalue " + pvalue);
	}

}
