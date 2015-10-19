package com.falstaff.core.alignable.signature.pronom;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.score.Alphabet;

public class NSignaturePatternCompiler {

	private static final Logger log = LoggerFactory.getLogger(NSignaturePatternCompiler.class
			.getName());

	private static String BYTE_RANGE_GROUP_PATTERN = "\\[([0-9A-F]{2})\\:([0-9A-F]{2})\\]";
	private static Pattern byteRangeGroupPattern = Pattern.compile(BYTE_RANGE_GROUP_PATTERN);
	private static String ALTERNATIVE_BODY = "^\\((.*)\\)$";
	private static Pattern alternativeBodyPattern = Pattern.compile(ALTERNATIVE_BODY);
	private static String BYTE_PATTERN = "(?:[0-9A-F]{2})";
	private static String BYTE_SEQUENCE_PATTERN = "(?:" + BYTE_PATTERN + ")+";
	private static String BYTE_RANGE_PATTERN = "\\[[0-9A-F]{2}\\:[0-9A-F]{2}\\]";
	private static String ANY_BYTE_FIXED_LENGTH_PATTERN = "\\{(\\d+)\\}";
	private static Pattern anyByteFixedLengthGroupPattern = Pattern.compile(ANY_BYTE_FIXED_LENGTH_PATTERN);
	private static String ANY_BYTE_BOUNDED_LENGTH_PATTERN = "\\{(\\d+)\\-(\\d+)\\}";
	private static Pattern anyByteBoundedLengthGroupPattern = Pattern.compile(ANY_BYTE_BOUNDED_LENGTH_PATTERN);

	private static String SEQUENCE_PATTERN = "(?:(" + BYTE_SEQUENCE_PATTERN + ")|(" + BYTE_RANGE_PATTERN + ")|(" + "\\((?:[^\\)]*)\\)" + ")|(" + "\\{([^\\}]*)\\}" + "))";
	private static Pattern sequencePattern = Pattern.compile(SEQUENCE_PATTERN);


	public static NByteSequencePattern hex2ByteSequencePattern(String hexString) {
		byte[] sequence = new byte[hexString.length()/2];
		for (int j = 0; j < hexString.length()/2; j++) {
			sequence[j] = Alphabet.hex2byte(hexString.substring(j * 2, j * 2 + 2)); 
		}
		NByteSequencePattern pattern = new NByteSequencePattern(sequence);
		return pattern;		
	}
	
	public static NRangePattern hex2RangePattern(String hexString) {
		Matcher byteRangeGroupMatcher= byteRangeGroupPattern.matcher(hexString);
		if (!byteRangeGroupMatcher.matches()) {
			throw new RuntimeException("illegal range pattern " + hexString);
		}
		NRangePattern pattern = new NRangePattern(Alphabet.hex2byte(byteRangeGroupMatcher.group(1)),Alphabet.hex2byte(byteRangeGroupMatcher.group(2)));
		return pattern;		
	}
	
	public static NQuantifierPattern hex2AnySequencePattern(String hexString) {
		NQuantifierPattern pattern;
		Matcher anyByteFixedLengthGroupMatcher = anyByteFixedLengthGroupPattern.matcher(hexString);
		if (anyByteFixedLengthGroupMatcher.matches()) {
			pattern = new NQuantifierPattern(new Integer(anyByteFixedLengthGroupMatcher.group(1)), new Integer(anyByteFixedLengthGroupMatcher.group(1)));
		}
		else {
			Matcher anyByteBoundedLengthGroupMatcher = anyByteBoundedLengthGroupPattern.matcher(hexString);
			if (!anyByteBoundedLengthGroupMatcher.matches()) {
				throw new RuntimeException("illegal any pattern " + hexString);
			}
			pattern = new NQuantifierPattern(new Integer(anyByteBoundedLengthGroupMatcher.group(1)), new Integer(anyByteBoundedLengthGroupMatcher.group(2)));

		}
		return pattern;		
	}
	
	public static NAlternativePattern hex2AlternativeSequencePattern(String hexString) {
		boolean emptyPattern = false;
		Matcher bodyMatcher = alternativeBodyPattern.matcher(hexString);
		if (!bodyMatcher.matches()) {
			throw new RuntimeException("illegal alternative pattern " + hexString);
		}
		
		String body = bodyMatcher.group(1);
		if (body.endsWith("|")) {
			body = "|" + body;
		}
		String[] alternativeHexStrings = body.split("\\|");
		List<INSignaturePattern> alternativePatterns = new ArrayList<INSignaturePattern>();
		for (int i = 0; i < alternativeHexStrings.length; i++) {
			if (alternativeHexStrings[i].length() == 0) {
				emptyPattern = true;
			}
			else {
				alternativePatterns.add(hex2SequencePattern(alternativeHexStrings[i]));
			}
		}
		NAlternativePattern alternativePattern =  new NAlternativePattern(alternativePatterns);
		alternativePattern.setEmptyAlternative(emptyPattern);
		return alternativePattern;
	}
	
	public static NSequencePattern hex2SequencePattern(String hexString) {
		List<INSignaturePattern> sequencePatterns = new ArrayList<INSignaturePattern>();
		int expectedStart = 0;
		Matcher sequenceMatcher = sequencePattern.matcher(hexString);
		while (true) {
			if (!sequenceMatcher.find() || sequenceMatcher.start() != expectedStart) {
				throw new RuntimeException("illegal sequence pattern " + hexString);
			}
			if (sequenceMatcher.group(1) != null) {
				sequencePatterns.add(hex2ByteSequencePattern(sequenceMatcher.group(1)));
			}
			if (sequenceMatcher.group(2) != null) {
				sequencePatterns.add(hex2RangePattern(sequenceMatcher.group(2)));				
			}
			if (sequenceMatcher.group(3) != null) {
				sequencePatterns.add(hex2AlternativeSequencePattern(sequenceMatcher.group(3)));				
			}
			if (sequenceMatcher.group(4) != null) {
				sequencePatterns.add(hex2AnySequencePattern(sequenceMatcher.group(4)));				
			}
			if (sequenceMatcher.end() == hexString.length())
				break;
			expectedStart = sequenceMatcher.end();
		}
		NSequencePattern sequencePattern = new NSequencePattern(sequencePatterns);
		return sequencePattern;
	}

}
