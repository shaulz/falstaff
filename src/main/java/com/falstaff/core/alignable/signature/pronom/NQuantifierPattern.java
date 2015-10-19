package com.falstaff.core.alignable.signature.pronom;

import java.util.regex.Pattern;

public class NQuantifierPattern extends NAbstractPattern {

	private int minLength;
	private int maxLength;
	private Pattern pattern = null;
	
	public NQuantifierPattern() {
		super();
		minLength = UNBOUNDED_LENGTH;
		maxLength = UNBOUNDED_LENGTH;
	}

	public NQuantifierPattern(int minLength) {
		super();
		this.minLength = minLength;
		maxLength = UNBOUNDED_LENGTH;
	}

	public NQuantifierPattern(int minLength, int maxLength) {
		super();
		if (minLength > maxLength) {
			throw new RuntimeException("illegal min and max quantifiers " + minLength + " " + maxLength);
		}
		this.minLength = minLength;
		this.maxLength = maxLength;
	}

	@Override
	public Pattern getPattern() {
		if (pattern == null) {
			if (minLength != UNBOUNDED_LENGTH && maxLength != UNBOUNDED_LENGTH) {
				if (maxLength > minLength) {
					pattern = Pattern.compile(".{" + minLength + "," + maxLength + "}");
				}
				else {
					pattern = Pattern.compile(".{" + minLength + "}");
				}
			}
			else {
				if (minLength != UNBOUNDED_LENGTH && minLength > 0) {
					pattern = Pattern.compile(".{" + minLength + ",}");
				}
				else {
					pattern = Pattern.compile(".*");
				}
			}
		}
		return pattern;
	}

	@Override
	public int minLength() {
		return minLength;
	}

	@Override
	public int maxLength() {
		return maxLength;
	}

	@Override
	public double probability() {
		return 1.0;
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
		NQuantifierPattern other = (NQuantifierPattern) obj;
		if (getPattern() == null) {
			if (other.getPattern() != null)
				return false;
		} else if (!getPattern().pattern().equals(other.getPattern().pattern()))
			return false;
		return true;
	}

}
