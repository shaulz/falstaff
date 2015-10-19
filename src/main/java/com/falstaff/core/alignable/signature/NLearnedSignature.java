package com.falstaff.core.alignable.signature;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.lookup.filter.INKtupFilter;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.score.Alphabet;

public class NLearnedSignature extends NSignature {

	private static final Logger log = LoggerFactory.getLogger(NLearnedSignature.class
			.getName());
	//protected String regExpChars = null;
	protected Segment BOFoffset;
	protected Segment EOFoffset;
	//protected List<INSignaturePattern> patterns = null;	

	public NLearnedSignature() {
		super();
	}
	
	public NLearnedSignature(Pattern pattern) {
		super(pattern);
	}
	
	public NLearnedSignature(INMultipleAlignment alignment) {
		setSignatureId();
		buildRegExp(alignment);
		pattern = Pattern.compile(regularExpression);
		BOFoffset = alignment.getBOFOffset();
		EOFoffset = alignment.getEOFOffset();
	}
	
	public Pattern finalPattern() {
		Pattern finalPattern = appendBOFoffset(pattern);
		finalPattern = appendEOFoffset(finalPattern);
		return finalPattern;
	}
	
	private Pattern appendBOFoffset(Pattern rootPattern) {
		if (BOFoffset == null) {
			return rootPattern;
		}
		String regExpChars = rootPattern.pattern();
		if (isMagic(BOFoffset)) {
			regExpChars = '^' + offsetChars(BOFoffset) + regExpChars;
			rootPattern = Pattern.compile(regExpChars);
		}
		return rootPattern;
	}
	
	private Pattern appendEOFoffset(Pattern rootPattern) {
		if (EOFoffset == null) {
			return rootPattern;
		}
		String regExpChars = rootPattern.pattern();
		if (isMagic(EOFoffset)) {
			regExpChars = regExpChars + offsetChars(EOFoffset) + '$';
			rootPattern = Pattern.compile(regExpChars);
		}
		return rootPattern;
	}	
	
	private boolean isMagic(Segment segment) {
		return segment.getEnd() <= 4;
	}
	
	private String offsetChars(Segment segment) {
		StringBuilder chars = new StringBuilder();
		if (segment.getStart() > 0 || segment.getLength() > 1) {
			chars.append('.').append('{').append(segment.getStart());
			if (segment.getLength() > 1) {
				chars.append(',').append(segment.getEnd());
			}
			chars.append('}');
		}
		return chars.toString();
	}

	public INKtupIterator<IKtup> ktupIterator(int ktupLength) {
		return ktupIterator(ktupLength, null);
	}
	
	@Override
	public INKtupIterator<IKtup> ktupIterator(int ktupLength,
			INKtupFilter<IKtup> filter) {
		return new SignatureKtupIterator(ktupLength, filter);
	}
	
	public Segment getBOFoffset() {
		return BOFoffset;
	}

	public void setBOFoffset(Segment BOFoffset) {
		this.BOFoffset = BOFoffset;
	}

	public Segment getEOFoffset() {
		return EOFoffset;
	}

	public void setEOFoffset(Segment EOFoffset) {
		this.EOFoffset = EOFoffset;
	}

	private void buildRegExp(INMultipleAlignment alignment) {

		StringBuilder regExpHexBuilder = new StringBuilder("");
		StringBuilder regExpCharsBuilder = new StringBuilder("");

		int i = 0;

		while (i < alignment.length()) {
			// sequence pattern
			if (alignment.getByte(i) != null) {
				regExpHexBuilder.append(Alphabet.byte2hex(alignment.getByte(i)));
				regExpCharsBuilder.append(Alphabet.byte2chars(alignment
						.getByte(i)));
				i++;
				continue;
			}
			
			// any pattern
			if (alignment.getScore(i) < 0) {
				int c = i + 1;
				while (alignment.getScore(c) < 0) {
					c++;
				}
				int minLength = getMinLength(alignment, i, c - 1);
				int maxLength = getMaxLength(alignment, i, c - 1);
				regExpHexBuilder.append('{').append(minLength);
				regExpCharsBuilder.append(".{").append(minLength);
				if (maxLength > minLength) {
					regExpHexBuilder.append('-').append(maxLength);
					regExpCharsBuilder.append(',').append(maxLength);
				}
				regExpHexBuilder.append('}');
				regExpCharsBuilder.append('}');
				i = c;
				continue;
			}
			
			// alternative pattern
			int j = i + 1;
			while (j < alignment.length() && alignment.getByte(j) == null && alignment.getScore(j) >= 0) {
				j++;
			}

			HashSet<String> alternativesHex = new HashSet<String>();
			HashSet<String> alternativesChars = new HashSet<String>();
			for (INScorableAlignable aligned : alignment.getAligned()) {
				StringBuilder alternativeHex = new StringBuilder("");
				StringBuilder alternativeChars = new StringBuilder("");
				for (int k = i; k < j; k++) {
					Byte b = alignment.getAlignedByte(aligned, k);
					if (b != null) {
						alternativeHex.append(Alphabet.byte2hex(b));
						alternativeChars.append(Alphabet
								.byte2chars(b));
					} else {
						alternativeHex.append(Alphabet.UNDEFINED_HEX);
					}
				}
				alternativesHex.add(alternativeHex.toString());
				alternativesChars.add(alternativeChars.toString());
			}

			regExpHexBuilder.append('(');
			for (String alternativeHex : alternativesHex) {
				regExpHexBuilder.append(alternativeHex).append('|');
			}
			regExpHexBuilder.deleteCharAt(regExpHexBuilder.length() - 1);
			regExpHexBuilder.append(')');

			regExpCharsBuilder.append("(?:");
			List<String> alternativesCharsSorted = new ArrayList<String>(alternativesChars); 
			Collections.sort(alternativesCharsSorted);
			for (String alternativeChars : alternativesCharsSorted) {
				regExpCharsBuilder.append(alternativeChars).append('|');
			}
			regExpCharsBuilder.deleteCharAt(regExpCharsBuilder.length() - 1);
			regExpCharsBuilder.append(')');
			i = j;
		}

		/*
		String regExpHex = regExpHexBuilder.toString();
		regExpHex = regExpHex.replaceAll(Alphabet.UNDEFINED_HEX, "");
		setPatterns(NSignaturePatternCompiler.hex2SequencePattern(regExpHex.toUpperCase()).getSequencePatterns());
		//regExpChars = regExpCharsBuilder.toString();
		StringBuilder regExpBuilder = new StringBuilder();
		for (INSignaturePattern pattern : getPatterns()) {
			regExpBuilder.append(pattern.getPattern().pattern());
		}
		regExpChars = regExpBuilder.toString();
		*/
		regularExpression = regExpCharsBuilder.toString();
	}
	
	private int getMinLength(INMultipleAlignment alignment, int columnStart, int columnEnd) {
		int minLength = Integer.MAX_VALUE;
		
		for (INScorableAlignable aligned : alignment.getAligned()) {
			int alignedLength = 0;
			for (int column = columnStart; column <= columnEnd; column++) {
				Byte b = alignment.getAlignedByte(aligned, column);
				if (b != null) {
					alignedLength++;
				}
			}
			if (alignedLength < minLength) {
				minLength = alignedLength;
			}
		}
		return minLength;
	}
	
	private int getMaxLength(INMultipleAlignment alignment, int columnStart, int columnEnd) {
		int maxLength = 0;
		
		for (INScorableAlignable aligned : alignment.getAligned()) {
			int alignedLength = 0;
			for (int column = columnStart; column <= columnEnd; column++) {
				Byte b = alignment.getAlignedByte(aligned, column);
				if (b != null) {
					alignedLength++;
				}
			}
			if (alignedLength > maxLength) {
				maxLength = alignedLength;
			}
		}
		return maxLength;
	}
	
	public void merge(NLearnedSignature otherSignature) {
		Segment otherBOFoffset = otherSignature.getBOFoffset();
		Segment otherEOFoffset = otherSignature.getEOFoffset();
		if (BOFoffset == null) {
			setBOFoffset(otherBOFoffset);
		}
		if (EOFoffset == null) {
			setEOFoffset(otherEOFoffset);
		}
		if (otherBOFoffset != null) {
			int start = Math.min(BOFoffset.getStart(), otherBOFoffset.getStart());
			int end = Math.max(BOFoffset.getEnd(), otherBOFoffset.getEnd());
			Segment mergedBOFoffset = new Segment(start, end - start + 1);
			setBOFoffset(mergedBOFoffset);
		}
		if (otherEOFoffset != null) {
			int start = Math.min(EOFoffset.getStart(), otherEOFoffset.getStart());
			int end = Math.max(EOFoffset.getEnd(), otherEOFoffset.getEnd());
			Segment mergedEOFoffset = new Segment(start, end - start + 1);
			setEOFoffset(mergedEOFoffset);
		}
	}
	
	public void merge(Set<NLearnedSignature> signatures) {
		if (!signatures.contains(this)) {
			signatures.add(this);
		}
		else {
			for (NLearnedSignature signature : signatures) {
				if (signature.equals(this)) {
					signature.merge(this);
					break;
				}
			}
		}
	}

}