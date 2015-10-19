package com.falstaff.core.alignable.signature.pronom;

import java.util.regex.Pattern;

import com.falstaff.core.alignable.sequence.NSequenceAlignable;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.score.Alphabet;

public class NByteSequencePattern extends NAbstractPattern {

	private byte[] sequence;
	private Pattern pattern = null;
	transient private NSequenceAlignable<IKtup> alignable = null;
	private Double probability = null;
	
	public NByteSequencePattern(byte[] sequence) {
		super();
		this.sequence = sequence;
		alignable = null;
	}

	@Override
	public Pattern getPattern() {
		if (pattern != null)
			return pattern;
		StringBuilder patternBuilder = new StringBuilder("");
		for (int i = 0; i < sequence.length; i++) {
			patternBuilder.append(Alphabet.byte2chars(sequence[i]));
		}
		pattern = Pattern.compile(patternBuilder.toString());
		return pattern;
	}

	@Override
	public int minLength() {
		return sequence.length;
	}

	@Override
	public int maxLength() {
		return sequence.length;
	}

	@Override
	public double probability() {
		if (probability == null) {
			probability = new Double(1.0);
			for (int i = 0; i < sequence.length; i++)
				probability *= Alphabet.getAlphabet().getBytesDistribution().getProbability(sequence[i]);
		}
		return probability;
	}

	@Override
	public String toString() {
		return pattern.toString();
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
		NByteSequencePattern other = (NByteSequencePattern) obj;
		if (getPattern() == null) {
			if (other.getPattern() != null)
				return false;
		} else if (!getPattern().pattern().equals(other.getPattern().pattern()))
			return false;
		return true;
	}

}
