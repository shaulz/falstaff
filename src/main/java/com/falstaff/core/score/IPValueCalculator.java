package com.falstaff.core.score;

public interface IPValueCalculator extends IScoreCalculator {
	public double pvalue(int score, int length);
	public double pvalue(int score, int lengthX, int lengthY);
}
