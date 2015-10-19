package com.falstaff.core.score;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class ByteDistribution {
	private static int DISTRIBUTION_SIZE = Byte.MAX_VALUE - Byte.MIN_VALUE + 1;
	public static final double LOG_TWO = Math.log((double)2);
	
	protected int[] bytesDistribution;
	protected long samplesNumber;
	protected Set<Byte> bytes;
	protected int gapCount;

	public ByteDistribution() {
		bytesDistribution = new int[DISTRIBUTION_SIZE];
		for (int i = 0; i < DISTRIBUTION_SIZE; i++) {
			bytesDistribution[i] = 0;
		}
		samplesNumber = 0;
		bytes = new HashSet<Byte>();
		gapCount = 0;
	}
	
	public ByteDistribution(ByteDistribution d1, ByteDistribution d2) {
		bytesDistribution = new int[DISTRIBUTION_SIZE];
		for (int i = 0; i < DISTRIBUTION_SIZE; i++) {
			bytesDistribution[i] = d1.bytesDistribution[i] + d2.bytesDistribution[i];
		}
		bytes = new HashSet<Byte>(d1.bytes);
		bytes.addAll(d2.bytes);
		samplesNumber = d1.samplesNumber + d2.samplesNumber;
		gapCount = d1.gapCount + d2.gapCount;
	}

	public void add(Byte letter) {
		add(letter, 1);
	}
	
	public void add(Byte letter, int byteCount) {
		samplesNumber += byteCount;
		if (letter == null) {
			gapCount += byteCount;
			return;
		}
		if (bytesDistribution[(int)(letter.byteValue() & 0xFF)] == 0) {
			bytes.add(letter);
		}
		bytesDistribution[(int)(letter.byteValue() & 0xFF)] += byteCount;
	}

	public void add(Iterator<Byte> bytes) {
		while (bytes.hasNext()) {
			Byte letter = bytes.next();
			add(letter);
		}
	}
	
	public void remove(Byte letter) {
		remove(letter, 1);
	}

	public void remove(Byte letter, int byteCount) {
		if (letter == null) {
			gapCount -= byteCount;
			samplesNumber -= byteCount;
			return;
		}
		if (bytesDistribution[(int)(letter.byteValue() & 0xFF)] == 0) {
			return;
		}
		else {
			bytesDistribution[(int)(letter.byteValue() & 0xFF)] -= byteCount;
			samplesNumber -= byteCount;
			if (bytesDistribution[(int)(letter.byteValue() & 0xFF)] == 0) {
				bytes.remove(letter);
			}
		}
	}
	
	public Set<Byte> getBytes() {
		return bytes;
	}

	public int getByteCount(Byte letter) {
		return bytesDistribution[(int)(letter.byteValue() & 0xFF)];
	}

	public double getProbability(Byte letter) {
		if (samplesNumber == 0)
			return 0.0;
		return (((double)getByteCount(letter)) / ((double)samplesNumber));
	}
		
	public long getSamplesNumber() {
		return samplesNumber;
	}

	public double getAverageProbability() {
		return 1.0 / ((double)getSize());
	}

	public double[] getNotZeroProbabilities() {
		double[] probabilities = new double[getSize()];
		int i = 0;
		for (Byte b : bytes) {
			probabilities[i] = getProbability(b);
			i++;
		}
		return probabilities;
	}
	
	public HashMap<Byte, Double> getNotZeroDistribution() {
		HashMap<Byte, Double> probabilities = new HashMap<Byte, Double>();
		for (Byte b : bytes) {
			probabilities.put(b, getProbability(b));
		}
		return probabilities;
	}

	public int getSize() {
		return bytes.size();
	}

	public double getEntropy() {
		double entropy = 0.0;
		for (Byte b : bytes) {
			entropy += entropyItem(getByteCount(b), getProbability(b));
		}
		entropy += gapEntropyItem(gapCount, samplesNumber);
		return entropy;
	}
	
	public double getEntropy(double thisEntropy, Byte b) {
		return getEntropy(thisEntropy, b, 1);
	}
	
	public double getEntropy(double thisEntropy, Byte b, int count) {
		double entropy = thisEntropy;
		entropy -= Math.log(samplesNumber) / LOG_TWO * samplesNumber;
		entropy += Math.log(samplesNumber + count) / LOG_TWO * (samplesNumber + count);
		int byteCount = 0;
		if (b != null) {
			byteCount = getByteCount(b);
		}
		if (b != null) {
			if (byteCount > 0) {
				entropy -= -((double)byteCount) * (Math.log(byteCount) / LOG_TWO);
			}
			entropy += -((double)byteCount + count) * (Math.log(byteCount + count) / LOG_TWO);
		}
		
		return entropy;
	}
		
	public int getGapCount() {
		return gapCount;
	}

	public static double getEntropy(Byte b1, Byte b2) {
		return getEntropy(b1, 1, b2 ,1);
	}
	
	public static double getEntropy(Byte b1, int b1Count, Byte b2, int b2Count) {
		int count = b1Count + b2Count;
		int gapCount = 0;
		if (b1 != null && b2 != null && b1.equals(b2)) {
			return entropyItem(count, 1.0);
		}
		double entropy = 0.0;
		if (b1 == null) {
			gapCount += b1Count;
		}
		else {
			entropy += entropyItem(b1Count, ((double)b1Count) / ((double)count));
		}
		if (b2 == null) {
			gapCount += b2Count;
		}
		else {
			entropy += entropyItem(b2Count, ((double)b2Count) / ((double)count));
		}
		entropy += gapEntropyItem(gapCount, count);
		return entropy;
	}
	
	public double getNormalizedEntropy() {
		int distinctSamplesCount = getSize() + getGapCount();
		return getNormalizedEntropy(distinctSamplesCount, (int) samplesNumber);
	}
	
	public static double getNormalizedEntropy(int distinctSamplesCount, int samplesCount) {
		int itemSamplesCount = (int) (samplesCount / distinctSamplesCount);
		int itemSamplesCountResidue = (int) (samplesCount % distinctSamplesCount);
		double probability = ((double)itemSamplesCount + 1) / (double)samplesCount;
		double normalizedEntropy = itemSamplesCountResidue * entropyItem(itemSamplesCount + 1, probability);
		probability = ((double)itemSamplesCount) / (double)samplesCount;
		normalizedEntropy += (distinctSamplesCount - itemSamplesCountResidue) * entropyItem(itemSamplesCount, probability);
		return normalizedEntropy;
	}
	
	private static double entropyItem(int itemCount, double itemProbability) {
		double entropy = -((double)itemCount) * (Math.log(itemProbability) / LOG_TWO);
		return entropy;
	}
	
	private static double gapEntropyItem(int gapCount, long samplesCount) {
		double entropy = -((double)gapCount) * (Math.log(1.0 / ((double)samplesCount)) / LOG_TWO);
		return entropy;
	}
	
	public void print() {
		for (Byte letter : getBytes()) {
			System.out.println("byte " + letter + " count : "
					+ getByteCount(letter));
		}
	}

}
