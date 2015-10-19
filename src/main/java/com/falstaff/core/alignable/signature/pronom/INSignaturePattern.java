package com.falstaff.core.alignable.signature.pronom;

import java.util.regex.Pattern;

public interface INSignaturePattern {
	public Pattern getPattern();
	public int minLength();
	public int maxLength();
	public double probability();
	
	public static int UNBOUNDED_LENGTH = -1;
}
