package com.falstaff.core.alignable.signature.pronom;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;

public class NAlternativePattern extends NAbstractPattern {

	private List<INSignaturePattern> alternativePatterns;
	private Pattern pattern = null;
	private boolean emptyAlternative = false;

	public static class PatternComparator implements
			Comparator<INSignaturePattern> {

		@Override
		public int compare(INSignaturePattern sp1, INSignaturePattern sp2) {
			return (sp1.getPattern().pattern().compareTo(sp2.getPattern().pattern()));
		}
	}

	public NAlternativePattern(List<INSignaturePattern> alternativePatterns) {
		super();
		if (alternativePatterns.isEmpty())
			throw new RuntimeException("alternative patterns list is empty");
		this.alternativePatterns = alternativePatterns;
		Collections.sort(alternativePatterns, new PatternComparator());
	}

	public void addPattern(INSignaturePattern alternativePattern) {
		int index = Collections.binarySearch(alternativePatterns, alternativePattern, new PatternComparator());
		if (index < 0) {
			index = -(index + 1);
		}
		alternativePatterns.add(index,alternativePattern);
		pattern = null;
	}

	public boolean isEmptyAlternative() {
		return emptyAlternative;
	}

	public void setEmptyAlternative(boolean emptyAlternative) {
		this.emptyAlternative = emptyAlternative;
	}

	@Override
	public Pattern getPattern() {
		if (pattern == null) {
			StringBuffer patternBuffer = new StringBuffer("");
			patternBuffer.append("(?:");
			for (INSignaturePattern alternativePattern : alternativePatterns) {
				patternBuffer.append(alternativePattern.getPattern().pattern());
				patternBuffer.append('|');
			}
			if (isEmptyAlternative()) {
				patternBuffer.append('|');
			}
			patternBuffer.replace(patternBuffer.length() - 1,
					patternBuffer.length(), ")");
			pattern = Pattern.compile(patternBuffer.toString());

		}
		return pattern;
	}

	@Override
	public int minLength() {
		int minLen = alternativePatterns.get(0).minLength();
		for (INSignaturePattern alternativePattern : alternativePatterns) {
			if (minLen > alternativePattern.minLength()) {
				minLen = alternativePattern.minLength();
			}
		}
		return minLen;
	}

	@Override
	public int maxLength() {
		int maxLen = 0;
		for (INSignaturePattern alternativePattern : alternativePatterns) {
			if (maxLen < alternativePattern.maxLength()) {
				maxLen = alternativePattern.maxLength();
			}
		}
		return maxLen;
	}

	@Override
	public double probability() {
		double probabilitiesSum = 0.0;
		for (INSignaturePattern alternativePattern : alternativePatterns) {
			probabilitiesSum += alternativePattern.probability();
		}
		return Math.min(probabilitiesSum, 1.0);
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
		NAlternativePattern other = (NAlternativePattern) obj;
		if (getPattern() == null) {
			if (other.getPattern() != null)
				return false;
		} else if (!getPattern().pattern().equals(other.getPattern().pattern()))
			return false;
		return true;
	}

}
