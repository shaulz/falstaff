package com.falstaff.core.alignable.signature.pronom;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.apache.xmlbeans.XmlException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import uk.gov.nationalarchives.pronom.ByteSequenceDocument.ByteSequence;
import uk.gov.nationalarchives.pronom.FileFormatDocument.FileFormat;
import uk.gov.nationalarchives.pronom.FileFormatIdentifierDocument.FileFormatIdentifier;
import uk.gov.nationalarchives.pronom.InternalSignatureDocument.InternalSignature;
import uk.gov.nationalarchives.pronom.PRONOMReportDocument;
import uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.Enum;

import com.falstaff.core.alignable.sequence.NSequenceAlignable;
import com.falstaff.core.alignable.signature.NLearnedSignature;
import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.alignable.signature.pattern.Matcher;
import com.falstaff.core.alignable.signature.pattern.Pattern;
import com.falstaff.core.geometry1D.Segment;


public class PronomParser {

	private static final String puidIdentifier = "PUID";
	private static final int MAX_ANY_BYTE = 16;
	public static final String pronomBaseUrl = "http://www.nationalarchives.gov.uk/PRONOM";

	private static final Logger log = LoggerFactory.getLogger(PronomParser.class
			.getName());

	private static String BYTE_PATTERN = "(?:[0-9A-F]{2})";
	private static String BYTE_SEQUECE_PATTERN = "(?:" + BYTE_PATTERN + ")+";
	private static String BYTE_RANGE_PATTERN = "\\[[0-9A-F]{2}\\:[0-9A-F]{2}\\]";
	private static String ALTERNATIVE_PATTERN = "\\((?:(?:" + BYTE_PATTERN
			+ "|" + BYTE_RANGE_PATTERN + ")+\\|)*(?:" + BYTE_PATTERN + "|"
			+ BYTE_RANGE_PATTERN + ")+\\)";
	private static String ANY_BYTE_PATTERN = "\\?\\?";
	private static String ANY_BYTE_ANY_LENGTH_PATTERN = "\\*";
	private static String ANY_BYTE_FIXED_LENGTH_PATTERN = "\\{\\d+\\}";
	private static String ANY_BYTE_FIXED_LENGTH_EXTRACT_PATTERN = "\\{(\\d+)\\}";
	private static String ANY_BYTE_BOUNDED_LENGTH_PATTERN = "\\{\\d+\\-\\d+\\}";
	private static String ANY_BYTE_BOUNDED_LENGTH_EXTRACT_PATTERN = "\\{(\\d+)\\-(\\d+)\\}";
	private static String ANY_BYTE_UNBOUNDED_LENGTH_PATTERN = "\\{\\d+\\-\\*\\}";
	private static String ANY_BYTE_UNBOUNDED_LENGTH_EXTRACT_PATTERN = "\\{(\\d+)\\-\\*\\}";
	private static String NEGATIVE_LOOKAHEAD_PATTERN = "\\[\\!"
			+ BYTE_SEQUECE_PATTERN + "\\]";

	private static Pattern regGroups = Pattern.compile("(?:" + "("
			+ BYTE_SEQUECE_PATTERN + ")" + "|" + "(" + BYTE_RANGE_PATTERN + ")"
			+ "|" + "(" + ALTERNATIVE_PATTERN + ")" + "|" + "("
			+ ANY_BYTE_PATTERN + ")" + "|" + "(" + ANY_BYTE_ANY_LENGTH_PATTERN
			+ ")" + "|" + "(" + ANY_BYTE_FIXED_LENGTH_PATTERN + ")" + "|" + "("
			+ ANY_BYTE_BOUNDED_LENGTH_PATTERN + ")" + "|" + "("
			+ ANY_BYTE_UNBOUNDED_LENGTH_PATTERN + ")" + "|" + "("
			+ NEGATIVE_LOOKAHEAD_PATTERN + ")" + ")");

	private static Pattern anyByteFixedLengthExtractPattern = Pattern
			.compile(ANY_BYTE_FIXED_LENGTH_EXTRACT_PATTERN);
	private static Pattern anyByteBoundedLengthExtractPattern = Pattern
			.compile(ANY_BYTE_BOUNDED_LENGTH_EXTRACT_PATTERN);
	private static Pattern anyByteUnboundedLengthExtractPattern = Pattern
			.compile(ANY_BYTE_UNBOUNDED_LENGTH_EXTRACT_PATTERN);

	private enum PatternGroup {
		BYTE_SEQUECE_PATTERN(1), BYTE_RANGE_PATTERN(2), ALTERNATIVE_PATTERN(3), ANY_BYTE_PATTERN(
				4), ANY_BYTE_ANY_LENGTH_PATTERN(5), ANY_BYTE_FIXED_LENGTH_PATTERN(
				6), ANY_BYTE_BOUNDED_LENGTH_PATTERN(7), ANY_BYTE_UNBOUNDED_LENGTH_PATTERN(
				8), NEGATIVE_LOOKAHEAD_PATTERN(9);

		private final int group;

		private PatternGroup(int group) {
			this.group = group;
		}

		public int getGroup() {
			return group;
		}

	}

	private Set<NLearnedSignature> extract(FileFormat fileFormat) {
			InternalSignature[] internalSignatures = fileFormat
					.getInternalSignatureArray();
			Set<NLearnedSignature> signatures = new HashSet<NLearnedSignature>();			
			for (int i = 0; i < internalSignatures.length; i++) {
				InternalSignature internalSignature = internalSignatures[i];
				NLearnedSignature signature = convert(internalSignature);
				signatures.add(signature);
			}
			return signatures;
	}
	
	private NLearnedSignature convert(InternalSignature internalSignature) {
		ByteSequence[] byteSequences = internalSignature
				.getByteSequenceArray();
		List<INSignaturePattern> signaturePatternsAll = new ArrayList<INSignaturePattern>();
		List<NSignature> featureSignatures = new ArrayList<NSignature>();
		boolean isBOF = false;
		boolean isEOF = false;
		log.info("parsing pronom signature with internal id " + internalSignature.getSignatureID());
		for (int j = 0; j < byteSequences.length; j++) {
			boolean isFeaturesBOF = false;
			boolean isFeaturesEOF = false;
			ByteSequence byteSequence = byteSequences[j];
			String hexString = byteSequence.getByteSequenceValue()
					.toUpperCase();
			Enum positionType = byteSequence.getPositionType();
			String offsetString = byteSequence.getOffset();
			Integer offset = null;
			offsetString = offsetString.replaceAll("\\s+","");
			if (offsetString != null && offsetString.length() > 0)
				offset = new Integer(offsetString);
			String maxOffsetString = byteSequence.getMaxOffset();
			Integer maxOffset = null;
			maxOffsetString = maxOffsetString.replaceAll("\\s+","");
			if (maxOffsetString != null && maxOffsetString.length() > 0)
				maxOffset = new Integer(maxOffsetString);
			if (log.isInfoEnabled()) {
				log.info("parsing sequence " + j + " with value " + hexString);
			}
			List<INSignaturePattern> patterns = matchGroups(hexString);
			if (patterns == null) {
				log.error("signature patterns parse of pronom signature " + internalSignature.getSignatureID() + " failed");
				return null;
			}
			
			// copy to feature patterns			
			List<INSignaturePattern> featurePatterns = new LinkedList<INSignaturePattern>(patterns);
			
			// add offset pattern
			INSignaturePattern offsetPattern = null;
			if (offset != null && maxOffset != null && (offset > 0 || maxOffset > 0)) {
				offsetPattern = new NQuantifierPattern(offset, maxOffset);
				log.info("sequence " + j + " has offset " + offset + " and maxOffset " + maxOffset);
			}
			
			if (offset != null && maxOffset == null && offset > 0) {
				offsetPattern = new NQuantifierPattern(offset,offset);
				log.warn("sequence " + j + " has offset " + offset + " and undefined maxOffset ");
			}
			
			if (offset == null && maxOffset != null && maxOffset > 0) {
				offsetPattern = new NQuantifierPattern(0, maxOffset);
				log.info("sequence " + j + " has undefined offset and maxOffset " + maxOffset);
			}
			
			if (positionType != null && positionType
					.equals(uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.ABSOLUTE_FROM_BOF)) {
				isBOF = true;
				if (offsetPattern != null) {
					patterns.add(0, offsetPattern);
				}
				else {
					if (offset == null) {
						isBOF = false;
					}
				}
				if (offsetPattern != null && offsetPattern.maxLength() != INSignaturePattern.UNBOUNDED_LENGTH && offsetPattern.maxLength() <= MAX_ANY_BYTE) {
					featurePatterns.add(0, offsetPattern);
					isFeaturesBOF = true;
				}
				if (offsetPattern == null && offset != null && offset == 0) {
					isFeaturesBOF = true;
				}
			}
			
			if (positionType != null && positionType
					.equals(uk.gov.nationalarchives.pronom.PositionTypeDocument.PositionType.ABSOLUTE_FROM_EOF)) {
				isEOF = true;
				if (offsetPattern != null) {
					patterns.add(offsetPattern);
				}
				else {
					if (offset == null) {
						isEOF = false;
					}
				}
				if (offsetPattern != null && offsetPattern.maxLength() != INSignaturePattern.UNBOUNDED_LENGTH && offsetPattern.maxLength() <= MAX_ANY_BYTE) {
					featurePatterns.add(offsetPattern);
					isFeaturesEOF = true;
				}
				if (offsetPattern == null && offset != null && offset == 0) {
					isFeaturesEOF = true;
				}
			}
			
			if (j > 0) {
				patterns.add(0, new NQuantifierPattern(0));
			}
									
			signaturePatternsAll.addAll(patterns);
			
			// add feature signatures
			List<INSignaturePattern> featurePatternsBuffer = new LinkedList<INSignaturePattern>();
			for (INSignaturePattern featurePattern : featurePatterns) {
				int length = featurePattern.maxLength();
				if (featurePattern instanceof NQuantifierPattern && (length == NQuantifierPattern.UNBOUNDED_LENGTH || length > MAX_ANY_BYTE)) {
					if (featurePatternsBuffer.size() > 0) {
						Pattern feature = getPattern(featurePatternsBuffer, isFeaturesBOF, false);
						isFeaturesBOF = false;
						NSignature featureSignature = new NSignature(feature);
						if (featureSignature.getMaxLength() >= 2) {
							featureSignatures.add(featureSignature);
						}
						featurePatternsBuffer.clear();
					}
					else {
						featurePatternsBuffer.add(featurePattern);
					}
				}
				else {
					featurePatternsBuffer.add(featurePattern);
				}
			}
			if (featurePatternsBuffer.size() > 0) {
				Pattern feature = getPattern(featurePatternsBuffer, isFeaturesBOF, isFeaturesEOF);
				NSignature featureSignature = new NSignature(feature);
				if (featureSignature.getMaxLength() >= 2) {
					featureSignatures.add(featureSignature);
				}
				featurePatternsBuffer.clear();
			}
		}
		
		Pattern signaturePattern = getPattern(signaturePatternsAll, isBOF, isEOF);
		NLearnedSignature signature = new NLearnedSignature(signaturePattern);
		signature.addFeatureSignatureAll(featureSignatures);
		log.info("pattern of signature with internal id " + internalSignature.getSignatureID() + " is " + signature.getPattern().toString());
		for (NSignature featureSignature : featureSignatures) {
			log.info("feature pattern of signature with internal id " + internalSignature.getSignatureID() + " is " + featureSignature.getPattern().toString());
		}
		return signature;		
	}
	 
	private Pattern getPattern(List<INSignaturePattern> signaturePatterns, boolean isBOF, boolean isEOF) {
		StringBuilder regExpCharsBuilder = new StringBuilder("");
		for (INSignaturePattern signaturePattern : signaturePatterns) {
			regExpCharsBuilder.append(signaturePattern.getPattern().pattern());
		}
		String regExpChars = regExpCharsBuilder.toString();
		
		if (isBOF) {
			regExpChars = '^' + regExpChars;
		}
		
		if (isEOF) {
			regExpChars = regExpChars + '$';
		}
		return Pattern.compile(regExpChars);
	}

	
	private Segment offsetSegment(int offset, int maxOffset) {
		Segment offsetSegment;
		if (offset != -1) {
			if (maxOffset != -1) {
				offsetSegment = new Segment(offset, maxOffset - offset + 1);
			} else {
				offsetSegment = new Segment(offset, 1);
			}
		} else {
			offsetSegment = new Segment(0, NSequenceAlignable.HEADER_LENGTH);
		}

		return offsetSegment;
	}

	private Properties extractFormatIdentifiers(FileFormat fileFormat) {
		Properties properties = new Properties();
		FileFormatIdentifier[] fileFormatIdentifiers = fileFormat
				.getFileFormatIdentifierArray();
		for (int i = 0; i < fileFormatIdentifiers.length; i++) {
			properties.put(fileFormatIdentifiers[i].getIdentifierType().toString(),
					fileFormatIdentifiers[i].getIdentifier());
		}
		return properties;
	}

	private List<INSignaturePattern> matchGroups(String hexString) {
		List<INSignaturePattern> patterns = new ArrayList<INSignaturePattern>();
		int expectedStart = 0;
		Matcher regMatcher = regGroups.matcher(hexString);
		while (true) {
			if (!regMatcher.find() || regMatcher.start() != expectedStart) {
				log.error("no match found for " + hexString);
				return null;
			}
			for (int i = 1; i <= regMatcher.groupCount(); i++) {
				if (regMatcher.group(i) == null)
					continue;
				String regGroup = regMatcher.group(i);
				if (log.isInfoEnabled()) {
					log.info("regGroup " + i + " " + regGroup);
				}
				if (i == PatternGroup.BYTE_SEQUECE_PATTERN.getGroup()) {
					patterns.add(NSignaturePatternCompiler
							.hex2ByteSequencePattern(regGroup));
					break;
				}
				if (i == PatternGroup.BYTE_RANGE_PATTERN.getGroup()) {
					patterns.add(NSignaturePatternCompiler
							.hex2RangePattern(regGroup));
					break;
				}
				if (i == PatternGroup.ALTERNATIVE_PATTERN.getGroup()) {
					patterns.add(NSignaturePatternCompiler
							.hex2AlternativeSequencePattern(regGroup));
				}
				if (i == PatternGroup.ANY_BYTE_PATTERN.getGroup()) {
					patterns.add(new NQuantifierPattern(1, 1));
				}
				if (i == PatternGroup.ANY_BYTE_ANY_LENGTH_PATTERN.getGroup()) {
					patterns.add(new NQuantifierPattern());
				}
				if (i == PatternGroup.ANY_BYTE_FIXED_LENGTH_PATTERN.getGroup()) {
					Matcher matcher = anyByteFixedLengthExtractPattern
							.matcher(regGroup);
					matcher.matches();
					Integer length = new Integer(matcher.group(1));
					patterns.add(new NQuantifierPattern(length, length));
				}
				if (i == PatternGroup.ANY_BYTE_BOUNDED_LENGTH_PATTERN
						.getGroup()) {
					Matcher matcher = anyByteBoundedLengthExtractPattern
							.matcher(regGroup);
					matcher.matches();
					Integer lengthMin = new Integer(matcher.group(1));
					Integer lengthMax = new Integer(matcher.group(2));
					patterns.add(new NQuantifierPattern(lengthMin, lengthMax));
				}
				if (i == PatternGroup.ANY_BYTE_UNBOUNDED_LENGTH_PATTERN
						.getGroup()) {
					Matcher matcher = anyByteUnboundedLengthExtractPattern
							.matcher(regGroup);
					matcher.matches();
					Integer length = new Integer(matcher.group(1));
					patterns.add(new NQuantifierPattern(length));
				}
				if (i == PatternGroup.NEGATIVE_LOOKAHEAD_PATTERN.getGroup()) {
					// skip lookahead
				}
			}
			if (regMatcher.end() == hexString.length())
				break;
			expectedStart = regMatcher.end();
		}

		return patterns;
	}
	
	private PRONOMReportDocument read(File file) {
		PRONOMReportDocument pronomReport = null;
		try {
			BufferedReader in = new BufferedReader(new FileReader(file));
			StringBuffer xml = new StringBuffer();
			String line;
			while ((line = in.readLine()) != null) {
				xml.append(line);
			}
			in.close();
			pronomReport = PRONOMReportDocument.Factory
					.parse(xml.toString());
		} catch (XmlException | IOException e) {
			log.error("failed to read pronom " + file + " " + e.getMessage());
			return null;
		}
				
		return pronomReport;
	}
	
	public static String getURL(String puid) {
		return pronomBaseUrl + '/' + getFile(puid);
	}
	
	public static String getFile(String puid) {
		return puid + ".xml";
	}
	
	private PRONOMReportDocument read(String puid) {
		PRONOMReportDocument pronomReport = null;
	    try {
			URL url = new URL(getURL(puid));
			BufferedReader in = new BufferedReader(
			                            new InputStreamReader(
			                                url.openStream()));

			StringBuilder response = new StringBuilder();
			String inputLine;

			while ((inputLine = in.readLine()) != null) { 
			    response.append(inputLine);
			}

			in.close();
			
			pronomReport = PRONOMReportDocument.Factory
					.parse(response.toString());
		} catch (Exception e) {
			log.error("failed to download pronom " + puid + " " + e.getMessage());
			return null;
		} 
	    
	    return pronomReport;
	}
	
	public Set<NSignature> parse(String puid) {
		PRONOMReportDocument pronom = read(puid);
		if (pronom == null) {
			return null;
		}
		FileFormat fileFormat = pronom.getPRONOMReport()
				.getReportFormatDetail().getFileFormat();
		Set<NLearnedSignature> learnedSignatures = extract(fileFormat);
		Set<NSignature> signatures = new HashSet<NSignature>();
		for (NLearnedSignature learnedSignature : learnedSignatures) {
			NSignature signature = new NSignature(learnedSignature.finalPattern());
			signature.setFeatureSignatures(learnedSignature.getFeatureSignatures(true));
			signatures.add(signature);			
		}
		return signatures;
	}			
}
