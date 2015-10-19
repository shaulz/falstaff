package com.falstaff.core.alignable.signature.pronom;

import java.util.regex.Pattern;

import com.falstaff.core.score.Alphabet;

public class NRangePattern extends NAbstractPattern {

	private byte low;
	private byte high;
	private Pattern pattern = null;
	private Double probability = null;
	
	public NRangePattern(byte low, byte high) {
		if (Alphabet.byte2int(low) > Alphabet.byte2int(high))
			throw new RuntimeException("illegal range " + low + "-" + high);
		this.low = low;
		this.high = high;
	}

	@Override
	public Pattern getPattern() {
		if (pattern != null)
			return pattern;
		StringBuilder patternBuilder = new StringBuilder("");
		patternBuilder.append('[').append(Alphabet.byte2chars(low)).append('-').append(Alphabet.byte2chars(high)).append(']');
		pattern = Pattern.compile(patternBuilder.toString());
		return pattern;
	}

	@Override
	public int minLength() {
		return 1;
	}

	@Override
	public int maxLength() {
		return 1;
	}

	@Override
	public double probability() {
		if (probability == null) {
			probability = new Double(0.0);
			for (int i = Alphabet.byte2int(low); i <= Alphabet.byte2int(high); i++)
				probability += Alphabet.getAlphabet().getBytesDistribution().getProbability((byte)i);
		}
		return probability;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getPattern() == null) ? 0 : getPattern().pattern().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NRangePattern other = (NRangePattern) obj;
		if (getPattern() == null) {
			if (other.getPattern() != null)
				return false;
		} else if (!getPattern().pattern().equals(other.getPattern().pattern()))
			return false;
		return true;
	}

}
