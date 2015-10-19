package com.falstaff.core.alignable.signature.pronom;

import java.util.List;
import java.util.regex.Pattern;

public class NSequencePattern extends NAbstractPattern {

	private List<INSignaturePattern> sequencePatterns;
	private Pattern pattern = null;

	public NSequencePattern(List<INSignaturePattern> sequencePatterns) {
		super();
		if (sequencePatterns.isEmpty())
			throw new RuntimeException("sequence patterns list is empty");
		this.sequencePatterns = sequencePatterns;
	}
	
	public void addPattern(INSignaturePattern signaturePattern) {
		sequencePatterns.add(signaturePattern);
		pattern = null;
	}

	public List<INSignaturePattern> getSequencePatterns() {
		return sequencePatterns;
	}

	@Override
	public Pattern getPattern() {
		if (pattern == null) {
			StringBuffer patternBuffer = new StringBuffer("");
			for (INSignaturePattern sequencePattern : sequencePatterns) {
				patternBuffer.append(sequencePattern.getPattern().pattern());
			}
			pattern = Pattern.compile(patternBuffer.toString());

		}
		return pattern;
	}

	@Override
	public int minLength() {
		int minLen = 0;
		for (INSignaturePattern sequencePattern : sequencePatterns) {
			minLen += sequencePattern.minLength();
		}
		return minLen;
	}

	@Override
	public int maxLength() {
		int maxLen = 0;
		for (INSignaturePattern sequencePattern : sequencePatterns) {
			maxLen += sequencePattern.maxLength();
		}
		return maxLen;
	}

	@Override
	public double probability() {
		double probabilityProduct = 1.0;
		for (INSignaturePattern sequencePattern : sequencePatterns) {
			probabilityProduct *= sequencePattern.probability();
		}		
		return probabilityProduct;
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
		NSequencePattern other = (NSequencePattern) obj;
		if (getPattern() == null) {
			if (other.getPattern() != null)
				return false;
		} else if (!getPattern().pattern().equals(other.getPattern().pattern()))
			return false;
		return true;
	}
}
