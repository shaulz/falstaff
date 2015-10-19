package com.falstaff.core.score;

import static org.junit.Assert.*;

import org.junit.Test;

public class EntropyScoreCalculatorTest {

	@Test
	public void test() {
		EntropyScoreCalculator calculator = new EntropyScoreCalculator(new ByteDistribution(), 500, 20);
		calculator.setCorrectScore(false);
		ByteDistribution distribution = new ByteDistribution();
		byte b = 100;
		distribution.add(b);
		b = 100;
		distribution.add(b);
		int s1 = calculator.score(distribution, b, 1);
		distribution.add(b);
		int s2 = calculator.score(distribution);
		assertEquals(s2, s1);
		
		distribution = new ByteDistribution();
		b = 100;
		distribution.add(b);
		b = 100;
		distribution.add(b);
		b = 101;
		s1 = calculator.score(distribution, b, 1);
		distribution.add(b);
		s2 = calculator.score(distribution);
		assertEquals(s2, s1);
		
		b = 101;
		s1 = calculator.score(distribution, b, 3);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		s2 = calculator.score(distribution);
		assertEquals(s2, s1);
		
		b = 102;
		s1 = calculator.score(distribution, b, 6);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		s2 = calculator.score(distribution);
		assertEquals(s2, s1);
		
		b = 102;
		s1 = calculator.score(distribution, b, 12);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		s2 = calculator.score(distribution);
		assertEquals(s2, s1);
		
		b = 102;
		s1 = calculator.score(distribution, b, 100);
		for (int i = 0 ; i < 100; i++) {
			distribution.add(b);
		}
		s2 = calculator.score(distribution);
		assertEquals(s2, s1);
		
		b = 103;
		s1 = calculator.score(distribution, b, 100);
		for (int i = 0 ; i < 100; i++) {
			distribution.add(b);
		}
		s2 = calculator.score(distribution);
		assertEquals(s2, s1);
		
		b = 104;
		s1 = calculator.score(distribution, b, 100);
		for (int i = 0 ; i < 100; i++) {
			distribution.add(b);
		}
		s2 = calculator.score(distribution);
		assertEquals(s2, s1);
		
		b = 105;
		s1 = calculator.score(distribution, b, 100);
		for (int i = 0 ; i < 100; i++) {
			distribution.add(b);
		}
		s2 = calculator.score(distribution);
		assertEquals(s2, s1);
	}
	
	@Test
	public void testScoreTable() {
		EntropyScoreCalculator calculator = new EntropyScoreCalculator(new ByteDistribution(), 25, 1);
		
		for (int i = 1; i <= 25; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print("alignable count " + i + " distinct bytes " + j + " score " + calculator.getScore(i,j) + "\n");
			}
		}
	}
}
