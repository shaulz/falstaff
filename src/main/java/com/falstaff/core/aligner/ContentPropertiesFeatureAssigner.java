package com.falstaff.core.aligner;

import java.io.UnsupportedEncodingException;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.feature.FileContentFeature;
import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.score.Alphabet;

public class ContentPropertiesFeatureAssigner extends
		NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> {
	
	private static final Logger log = LoggerFactory
			.getLogger(ContentPropertiesFeatureAssigner.class.getName());
	
	private static final int MAXLINELEN = 300;
	
	private int testLength = 1000;
	
	public enum LineDelimiter {
		CRLF,
		CR,
		LF,
		NEL,
		NONE
	};

	public ContentPropertiesFeatureAssigner() {
		super();
	}

	private char[] textChars = {
			/*                                 BEL  BS   HT   LF        FF   CR    */
			'F', 'F', 'F', 'F', 'F', 'F', 'F', 'T', 'T', 'T', 'T', 'F', 'T', 'T', 'F', 'F',  /* 0x0X */
			/*                                                     ESC          */
			'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'F', 'T', 'F', 'F', 'F', 'F',  /* 0x1X */
			'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',  /* 0x2X */
			'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',  /* 0x3X */
			'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',  /* 0x4X */
			'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',  /* 0x5X */
			'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T',  /* 0x6X */
			'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'T', 'F',  /* 0x7X */
			/*                       NEL                            */
			'X', 'X', 'X', 'X', 'X', 'T', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',  /* 0x8X */
			'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X', 'X',  /* 0x9X */
			'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I',  /* 0xaX */
			'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I',  /* 0xbX */
			'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I',  /* 0xcX */
			'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I',  /* 0xdX */
			'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I',  /* 0xeX */
			'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I', 'I'   /* 0xfX */
		};

	private boolean isAscii(INFeaturedAlignable alignable) {
		for (int i = 0; i < Math.min(testLength, alignable.length()); i++) {
			Byte b = alignable.getByte(i);
			char t = textChars[Alphabet.byte2int(b)];
			if (t != 'T') {
				return false;
			}
		}
		return true;
	}
	
	private boolean isLatin1(INFeaturedAlignable alignable) {
		for (int i = 0; i < Math.min(testLength, alignable.length()); i++) {
			Byte b = alignable.getByte(i);
			char t = textChars[Alphabet.byte2int(b)];
			if (t != 'T' && t != 'I') {
				return false;
			}
		}
		return true;
	}
	
	private boolean isExtended(INFeaturedAlignable alignable) {
		for (int i = 0; i < Math.min(testLength, alignable.length()); i++) {
			Byte b = alignable.getByte(i);
			char t = textChars[Alphabet.byte2int(b)];
			if (t != 'T' && t != 'I' && t != 'X') {
				return false;
			}
		}
		return true;
	}
	
	private int isUtf8(INFeaturedAlignable alignable, int start) {
		int gotone = 0, ctrl = 0;
		byte b;
		for (int i = start; i < Math.min(testLength, alignable.length()); i++) {
			b = alignable.getByte(i).byteValue();
			
			if ((b & 0x80) == 0) {	   /* 0xxxxxxx is plain ASCII */
				/*
				 * Even if the whole file is valid UTF-8 sequences,
				 * still reject it if it uses weird control characters.
				 */

				if (textChars[b] != 'T')
					ctrl = 1;

			} else if ((b & 0x40) == 0) { /* 10xxxxxx never 1st byte */
				return -1;
			} else {			   /* 11xxxxxx begins UTF-8 */
				int following;

				if ((b & 0x20) == 0) {		/* 110xxxxx */
					following = 1;
				} else if ((b & 0x10) == 0) {	/* 1110xxxx */
					following = 2;
				} else if ((b & 0x08) == 0) {	/* 11110xxx */
					following = 3;
				} else if ((b & 0x04) == 0) {	/* 111110xx */
					following = 4;
				} else if ((b & 0x02) == 0) {	/* 1111110x */
					following = 5;
				} else
					return -1;

				for (int n = 0; n < following; n++) {
					i++;
					b = alignable.getByte(i).byteValue();
					if (i >= Math.min(testLength, alignable.length())) {
						return ctrl != 0 ? 0 : (gotone != 0 ? 2 : 1);
					}

					if ((b & 0x80) == 0 || (b & 0x40) != 0)
						return -1;

				}
				gotone = 1;
			}
		}
		return ctrl != 0 ? 0 : (gotone != 0 ? 2 : 1);
	}
	
	private int isUtf8WithBOM(INFeaturedAlignable alignable) {
		if (Math.min(testLength, alignable.length()) > 3 && alignable.getByte(0).byteValue() == 0xef && alignable.getByte(1).byteValue() == 0xbb && alignable.getByte(2).byteValue() == 0xbf)
			return isUtf8(alignable, 3);
		else
			return -1;
	}
	
	private int isUcs16(INFeaturedAlignable alignable)
	{
		int bigend;

		if (Math.min(testLength, alignable.length()) < 2)
			return 0;

		if (alignable.getByte(0).byteValue() == 0xff && alignable.getByte(1).byteValue() == 0xfe)
			bigend = 0;
		else {
			if (alignable.getByte(0).byteValue() == 0xfe && alignable.getByte(1).byteValue() == 0xff)
				bigend = 1;
			else
				return 0;
		}

		for (int i = 2; i + 1 < Math.min(testLength, alignable.length()); i += 2) {
			/* XXX fix to properly handle chars > 65536 */

			int test;
			if (bigend != 0)
				test = alignable.getByte(i + 1).byteValue() + 256 * alignable.getByte(i).byteValue();
			else
				test = alignable.getByte(i).byteValue() + 256 * alignable.getByte(i + 1).byteValue();

			if (test == 0xfffe)
				return 0;
			if (test < 128 && textChars[test] != 'T')
				return 0;
		}

		return 1 + bigend;
	}
	
	private char ebcdicToAscii[] = {
			  0,   1,   2,   3, 156,   9, 134, 127, 151, 141, 142,  11,  12,  13,  14,  15,
			 16,  17,  18,  19, 157, 133,   8, 135,  24,  25, 146, 143,  28,  29,  30,  31,
			128, 129, 130, 131, 132,  10,  23,  27, 136, 137, 138, 139, 140,   5,   6,   7,
			144, 145,  22, 147, 148, 149, 150,   4, 152, 153, 154, 155,  20,  21, 158,  26,
			' ', 160, 161, 162, 163, 164, 165, 166, 167, 168, 213, '.', '<', '(', '+', '|',
			'&', 169, 170, 171, 172, 173, 174, 175, 176, 177, '!', '$', '*', ')', ';', '~',
			'-', '/', 178, 179, 180, 181, 182, 183, 184, 185, 203, ',', '%', '_', '>', '?',
			186, 187, 188, 189, 190, 191, 192, 193, 194, '`', ':', '#', '@', '\'','=', '"',
			195, 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 196, 197, 198, 199, 200, 201,
			202, 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', '^', 204, 205, 206, 207, 208,
			209, 229, 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 210, 211, 212, '[', 214, 215,
			216, 217, 218, 219, 220, 221, 222, 223, 224, 225, 226, 227, 228, ']', 230, 231,
			'{', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 232, 233, 234, 235, 236, 237,
			'}', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 238, 239, 240, 241, 242, 243,
			'\\',159, 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 244, 245, 246, 247, 248, 249,
			'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 250, 251, 252, 253, 254, 255
			};

	private char ebcdic1047To8859[] = {
			0x00,0x01,0x02,0x03,0x9C,0x09,0x86,0x7F,0x97,0x8D,0x8E,0x0B,0x0C,0x0D,0x0E,0x0F,
			0x10,0x11,0x12,0x13,0x9D,0x0A,0x08,0x87,0x18,0x19,0x92,0x8F,0x1C,0x1D,0x1E,0x1F,
			0x80,0x81,0x82,0x83,0x84,0x85,0x17,0x1B,0x88,0x89,0x8A,0x8B,0x8C,0x05,0x06,0x07,
			0x90,0x91,0x16,0x93,0x94,0x95,0x96,0x04,0x98,0x99,0x9A,0x9B,0x14,0x15,0x9E,0x1A,
			0x20,0xA0,0xE2,0xE4,0xE0,0xE1,0xE3,0xE5,0xE7,0xF1,0xA2,0x2E,0x3C,0x28,0x2B,0x7C,
			0x26,0xE9,0xEA,0xEB,0xE8,0xED,0xEE,0xEF,0xEC,0xDF,0x21,0x24,0x2A,0x29,0x3B,0x5E,
			0x2D,0x2F,0xC2,0xC4,0xC0,0xC1,0xC3,0xC5,0xC7,0xD1,0xA6,0x2C,0x25,0x5F,0x3E,0x3F,
			0xF8,0xC9,0xCA,0xCB,0xC8,0xCD,0xCE,0xCF,0xCC,0x60,0x3A,0x23,0x40,0x27,0x3D,0x22,
			0xD8,0x61,0x62,0x63,0x64,0x65,0x66,0x67,0x68,0x69,0xAB,0xBB,0xF0,0xFD,0xFE,0xB1,
			0xB0,0x6A,0x6B,0x6C,0x6D,0x6E,0x6F,0x70,0x71,0x72,0xAA,0xBA,0xE6,0xB8,0xC6,0xA4,
			0xB5,0x7E,0x73,0x74,0x75,0x76,0x77,0x78,0x79,0x7A,0xA1,0xBF,0xD0,0x5B,0xDE,0xAE,
			0xAC,0xA3,0xA5,0xB7,0xA9,0xA7,0xB6,0xBC,0xBD,0xBE,0xDD,0xA8,0xAF,0x5D,0xB4,0xD7,
			0x7B,0x41,0x42,0x43,0x44,0x45,0x46,0x47,0x48,0x49,0xAD,0xF4,0xF6,0xF2,0xF3,0xF5,
			0x7D,0x4A,0x4B,0x4C,0x4D,0x4E,0x4F,0x50,0x51,0x52,0xB9,0xFB,0xFC,0xF9,0xFA,0xFF,
			0x5C,0xF7,0x53,0x54,0x55,0x56,0x57,0x58,0x59,0x5A,0xB2,0xD4,0xD6,0xD2,0xD3,0xD5,
			0x30,0x31,0x32,0x33,0x34,0x35,0x36,0x37,0x38,0x39,0xB3,0xDB,0xDC,0xD9,0xDA,0x9F
			};
	
	private char[] fromEbcdic(INFeaturedAlignable alignable)
	{
		char[] ascii = new char[Math.min(testLength, alignable.length())];
		
		for (int i = 0; i < Math.min(testLength, alignable.length()); i++) {
			ascii[i] = ebcdicToAscii[alignable.getByte(i).byteValue()];
		}
		return ascii;
	}

	@Override
	public Collection<? extends INFeaturedAlignable> transformInternal(
			Collection<? extends INFeaturedAlignable> formatFiles) {
		int assignedFormatFilesCount = 0;
		for (INFeaturedAlignable formatFile : formatFiles) {
			try {
				assign(formatFile);
			} catch (Exception e) {
				log.error("failed to assign content features to file " + formatFile.getFileName() + " " + e.getMessage());
				e.printStackTrace();
			}
			assignedFormatFilesCount++;
			if (processMonitor != null) {
				processMonitor.setPercentageCompleted(assignedFormatFilesCount
						* 100 / formatFiles.size());
			}
		}
		return formatFiles;
	}

	private void assign(INFeaturedAlignable alignable) throws UnsupportedEncodingException {
		String encoding = null;
		LineDelimiter lineDelimiter = null;
		if (isAscii(alignable)) {
			encoding = "ASCII";
		}
		else {
			if (isUtf8WithBOM(alignable) > 0) {
				encoding = "UTF8";
			}
			else {
				if (isUtf8(alignable, 0) > 1) {
					encoding = "UTF8";
				}
				else {
					int ucsType = isUcs16(alignable);
					if (ucsType != 0) {
						if (ucsType == 1) {
							encoding = "UnicodeLittleUnmarked";
						} else {
							encoding = "UnicodeBigUnmarked";
						}
					}
					else {
						if (isLatin1(alignable)) {
							encoding = "ISO8859_1";
						}
						else {
							if (isExtended(alignable)) {
								encoding = "";
							}
						}
					}
				}
			}
		}
		
		if (encoding != null) {
			if (!encoding.isEmpty()) {
				alignable.setEncoding(encoding);
				alignable.addFeature(new FileContentFeature("encoding", encoding));
			}
			log.info("file " + alignable.getFileName() + " is text with encoding " + encoding);
		}
		else {
			log.info("file " + alignable.getFileName() + " is binary");
		}
		
		char[] chars = null;
		if (encoding != null && !encoding.isEmpty()) {
			byte[] bytes = new byte[Math.min(testLength, alignable.length())];
			for (int i = 0; i < Math.min(testLength, alignable.length()); i++) {
				bytes[i] = alignable.getByte(i).byteValue();
			}
			String string = new String(bytes, encoding);
			chars = string.toCharArray();
		}
		if (encoding != null && encoding.isEmpty()) {
			byte[] bytes = new byte[Math.min(testLength, alignable.length())];
			for (int i = 0; i < Math.min(testLength, alignable.length()); i++) {
				bytes[i] = alignable.getByte(i).byteValue();
			}
			String string = new String(bytes);
			chars = string.toCharArray();
		}
		
		if (chars != null) {
			boolean seenCr = false;
			int crlfNum = 0;
			int lfNum = 0;
			int crNum = 0;
			int nelNum = 0;
			int lastLineEnd = 0;
			boolean hasLongLines = false;
			boolean hasEscapes = false;
			boolean hasBackSpaces = false;
			for (int i = 0; i < chars.length; i++) {
				if (chars[i] == '\n') {
					if (seenCr)
						crlfNum++;
					else
						lfNum++;
					lastLineEnd = i;
				} else if (seenCr)
					crNum++;

				seenCr = (chars[i] == '\r');
				if (seenCr)
					lastLineEnd = i;

				if (chars[i] == 0x85) { /* X3.64/ECMA-43 "next line" character */
					nelNum++;
					lastLineEnd = i;
				}

				/* If this line is _longer_ than MAXLINELEN, remember it. */
				if (i > lastLineEnd + MAXLINELEN)
					hasLongLines = true;

				if (chars[i] == '\033')
					hasEscapes = true;
				if (chars[i] == '\b')
					hasBackSpaces = true;
			}

			/* Beware, if the data has been truncated, the final CR could have
			   been followed by a LF.  If we have HOWMANY bytes, it indicates
			   that the data might have been truncated, probably even before
			   this function was called. */
			if (seenCr)
				crNum++;

			if (hasLongLines) {
				log.info("file " + alignable.getFileName() + " has long lines");
				alignable.addFeature(new FileContentFeature("lines", "long"));
			}
			else {
				alignable.addFeature(new FileContentFeature("lines", "short"));
			}
			
			if (crlfNum == 0 && crNum == 0 && nelNum == 0 && lfNum == 0) {
				log.info("file " + alignable.getFileName() + " has no line delimiter");
				lineDelimiter = LineDelimiter.NONE;
			}
			
			if (lineDelimiter == null && crlfNum >= crNum && crlfNum >= lfNum && crlfNum >= nelNum) {
				log.info("file " + alignable.getFileName() + " has CRLF line delimiter");
				lineDelimiter = LineDelimiter.CRLF;
			}
			
			if (lineDelimiter == null && crNum > crlfNum && crNum > lfNum && crNum > nelNum) {
				log.info("file " + alignable.getFileName() + " has CR line delimiter");
				lineDelimiter = LineDelimiter.CR;
			}
			
			if (lineDelimiter == null && lfNum > crlfNum && lfNum > crNum && lfNum > nelNum) {
				log.info("file " + alignable.getFileName() + " has LF line delimiter");
				lineDelimiter = LineDelimiter.LF;
			}
			
			if (lineDelimiter == null && nelNum > crlfNum && nelNum > crNum && nelNum > lfNum) {
				log.info("file " + alignable.getFileName() + " has NEL line delimiter");
				lineDelimiter = LineDelimiter.NEL;
			}
			
			if (lineDelimiter != null) {
				alignable.addFeature(new FileContentFeature("line_delimiter", lineDelimiter.toString()));
			}
		}
	}

	@Override
	public void clear() {
	}

	@Override
	public String getName() {
		return "content propeties features assigner";
	}

}
