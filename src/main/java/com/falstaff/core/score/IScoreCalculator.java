package com.falstaff.core.score;

public interface IScoreCalculator {
	public int score(ByteDistribution byteDistribution);
	public int score(ByteDistribution d1, ByteDistribution d2);
	public int score(ByteDistribution byteDistribution, Byte b);
	public int score(ByteDistribution byteDistribution, Byte b, int byteCount);
	public int score(Byte b1, Byte b2);
	public int score(Byte b1, int b1Count, Byte b2, int b2Count);
	public int score(Byte b);
	public double pvalue(int score, int length, int alignedCount);
	public double pvalue(int score, int[] alignedLengths);
	public double evalue(int score, int length, int alignedCount);
	public double evalue(int score, int[] alignedLengths);
	public void setAlphabet(ByteDistribution alphabet);
	public void setDbSize(int dbSize);
}
