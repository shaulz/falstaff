package com.falstaff.core.score;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Alphabet {

	private ByteDistribution bytesDistribution;
	private static Alphabet alphabet;
	private static final String HEXES = "0123456789ABCDEF";
	public static String UNDEFINED_HEX = "__";
	public static String UNDEFINED_CHARS = ".";
	private static HashMap<Byte, String> byte2hex = null;
	private static HashMap<String, Byte> hex2byte = null;
	private static HashMap<Byte, String> byte2chars = null;
	private static HashMap<String, Byte> chars2byte = null;

	public synchronized static Alphabet getAlphabet() {
		if (alphabet == null) {
			alphabet = new Alphabet();
		}
		return alphabet;
	}

	private Alphabet() {
		bytesDistribution = new ByteDistribution();
		
		// smoothing
		for (int b = 0; b <= Byte.MAX_VALUE - Byte.MIN_VALUE; b++) {
			bytesDistribution.add((byte)b);
		}
	}

	public int getSize() {
		return bytesDistribution.getSize();
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder("");
		double averageProbability = bytesDistribution.getAverageProbability();
		for (Byte letter : bytesDistribution.getBytes()) {
			buffer.append("\nbyte ").append(byte2chars(letter)).append(" has probability ")
					.append(bytesDistribution.getProbability(letter));
			double score =  Math.log(bytesDistribution.getProbability(letter)) / Math.log(averageProbability);
			buffer.append(" score ").append(score);
		}
		return buffer.toString();
	}

	private static void byteHexInit() {
		byte2hex = new HashMap<Byte, String>();
		hex2byte = new HashMap<String, Byte>();

		for (int i = 0; i <= Byte.MAX_VALUE - Byte.MIN_VALUE; i++) {
			byte b = (byte)i;
			String hex = "" + HEXES.charAt((b & 0xF0) >> 4)
					+ HEXES.charAt(b & 0x0F);
			byte2hex.put(b, hex);
			hex2byte.put(hex, b);
		}
	}

	public static String byte2hex(byte b) {
		if (byte2hex == null)
			byteHexInit();
		return byte2hex.get(b);
	}

	public static byte hex2byte(String s) {
		if (hex2byte == null)
			byteHexInit();
		Byte b = hex2byte.get(s);
		if (b == null) {
			throw new RuntimeException("illegal hex chars :" + s + ":");
		}
		return b;
	}
	
	public static int byte2int(byte b) {
		return (b & 0xFF);
	}

	private static void byteCharsInit() {
		byte2chars = new HashMap<Byte, String>();
		chars2byte = new HashMap<String, Byte>();

		Pattern print = Pattern.compile("\\p{Print}");
		Pattern alnum = Pattern.compile("\\p{Alnum}");

		for (int b = 0; b <= Byte.MAX_VALUE - Byte.MIN_VALUE; b++) {
			String s = "" + (char)b;
			if (!print.matcher(s).matches()) {
				switch (b) {
				case 0x09:
					s = "\\t";
					break;
				case 0x0A:
					s = "\\n";
					break;
				case 0x0D:
					s = "\\r";
					break;
				case 0x0C:
					s = "\\f";
					break;
				case 0x07:
					s = "\\a";
					break;
				case 0x1B:
					s = "\\e";
					break;
				default:
					s = "\\x" + byte2hex((byte)b);
				}
			}

			// Precede printable non alpha numeric characters with \
			if (print.matcher(s).matches() && !alnum.matcher(s).matches()) {
				s = "\\" + s;
			}
			byte2chars.put((byte)b, s);
			chars2byte.put(s, (byte)b);
		}
	}

	public static String byte2chars(byte b) {
		if (byte2chars == null)
			byteCharsInit();
		return byte2chars.get(b);
	}
	
	public ByteDistribution getBytesDistribution() {
		return bytesDistribution;
	}

	public static void main(String[] args) {
		for (int b = 0; b <= Byte.MAX_VALUE - Byte.MIN_VALUE; b++) {
			System.out.println("byte " + b + " " + byte2hex((byte)b));
		}
		
		for (int b = 0; b <= Byte.MAX_VALUE - Byte.MIN_VALUE; b++) {
			System.out.println("byte " + b + " " + byte2chars((byte)b));
		}
		
		for (int b = Byte.MIN_VALUE; b <= Byte.MAX_VALUE; b++) {
			System.out.println("byte " + ((byte)b) + " " + byte2int((byte)b));
		}
	}
	
}
