package com.falstaff.core.format;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestFormatSetGenerator {
	
	private static int filesNumber = 100;
	StringBuffer[] files = new StringBuffer[filesNumber];
	
	

	public TestFormatSetGenerator() {
		for (int i = 0; i < filesNumber; i++) {
			files[i] = new StringBuffer();
		}
		
		// generate magic header of length 4 in 30 files
		for (int i = 0; i < filesNumber; i++) {
			if (i < 30)
				files[i].append("mgch");
			else
				files[i].append(generateRandomString(4));
		}		
		
		// generate 10 random characters
		appendRandomString(10);
		
		// generate low complexity region of length 20
		appendConstantString('l',20);
		
		// generate 10 random characters
		appendRandomString(10);
		
		// generate low complexity region of length 20
		appendConstantString('2',20);		
		
		// generate 10 random characters
		appendRandomString(10);
		
		// generate 5 repeats of length 6 each separated by 10 characters each
		appendString("repeat1");
		appendRandomString(10);
		appendString("repeat2");
		appendRandomString(10);	
		appendString("repeat3");
		appendRandomString(10);	
		appendString("repeat4");
		appendRandomString(10);	
		appendString("repeat5");
		appendRandomString(10);	
		
		// generate 5 letters signature in 30 files
		for (int i = 0; i < filesNumber; i++) {
			if (i < 70)
				files[i].append(generateRandomString(5));
			else
				files[i].append("1sgn1");
		}		
		appendRandomString(10);	
		
		
		// test gap length 1,2,3
		
		// generate signature with two ktups of length 4 separated by a random gap of length 1
		appendString("2sg2");
		appendRandomString(1);
		appendString("3sg3");
		appendRandomString(10);
		
		// generate signature with two ktups of length 4 separated by a gap of length 1 consisting of A,B,C and a delete
		appendString("4sg4");
		for (int i = 0; i < 25; i++) {
			files[i].append(generateConstantString('A', 1));
		}
		for (int i = 25; i < 50; i++) {
			files[i].append(generateConstantString('B', 1));
		}
		for (int i = 50; i < 75; i++) {
			files[i].append(generateConstantString('C', 1));
		}
		appendString("5sg5");
		appendRandomString(10);
		

		// generate signature with two ktups of length 4 separated by a random gap of length 2
		appendString("6sg6");
		appendRandomString(2);
		appendString("7sg7");
		appendRandomString(10);
		
		// generate signature with two ktups of length 4 separated by a gap of length 2 consisting of 3 letters DD,EE,F and a delete
		appendString("8sg8");
		for (int i = 0; i < 25; i++) {
			files[i].append(generateConstantString('D', 2));
		}
		for (int i = 25; i < 50; i++) {
			files[i].append(generateConstantString('E', 2));
		}
		for (int i = 50; i < 75; i++) {
			files[i].append(generateConstantString('F', 1));
		}
		appendString("9sg9");
		appendRandomString(10);
		
		// generate signature with two ktups of length 4 separated by a random gap of length 3
		appendString("asga");
		appendRandomString(3);
		appendString("bsgb");
		appendRandomString(10);
		
		// generate signature with two ktups of length 4 separated by a gap of length 3 consisting of 3 letters XXX,YY,Z and a delete
		appendString("csgc");
		for (int i = 0; i < 25; i++) {
			files[i].append(generateConstantString('X', 3));
		}
		for (int i = 25; i < 50; i++) {
			files[i].append(generateConstantString('Y', 2));
		}
		for (int i = 50; i < 75; i++) {
			files[i].append(generateConstantString('Z', 1));
		}
		appendString("dsgd");
		appendRandomString(10);
		
		// generate KK + gap of length 1 + ktup of length5
		appendString("KK");
		appendRandomString(1);
		appendString("esgne");
		appendRandomString(10);
		
		// generate OO + gap of length 1 + ktup of length 5 + gap of length 1 + LL
		appendString("OO");
		appendRandomString(1);
		appendString("fsgnf");
		appendRandomString(1);
		appendString("LL");
		appendRandomString(10);
		
		// generate long signature
		appendString("1234567890qwertyuiopasdfghjklzxcvbnm");
		appendRandomString(10);
		
		// generate signature with regular expression Q | W | E | R
		appendString("gsgg");
		for (int i = 0; i < 25; i++) {
			files[i].append(generateConstantString('Q', 1));
		}
		for (int i = 25; i < 50; i++) {
			files[i].append(generateConstantString('W', 1));
		}
		for (int i = 50; i < 75; i++) {
			files[i].append(generateConstantString('E', 1));
		}
		for (int i = 75; i < 100; i++) {
			files[i].append(generateConstantString('R', 1));
		}
		appendString("isgi");
		appendRandomString(10);
		
		// generate signature with regular expression TY | UI | OP | AS
		appendString("ksgk");
		for (int i = 0; i < 25; i++) {
			files[i].append("TY");
		}
		for (int i = 25; i < 50; i++) {
			files[i].append("UI");
		}
		for (int i = 50; i < 75; i++) {
			files[i].append("OP");
		}
		for (int i = 75; i < 100; i++) {
			files[i].append("AS");
		}
		appendString("lsgl");
		appendRandomString(50);
		
		// generate magic tail of length 4
		for (int i = 0; i < filesNumber; i++) {
			if (i >= 70)
				files[i].append("mgct");
			else
				files[i].append(generateRandomString(4));
		}
		
	}
	
	private void appendString(String s) {
		for (int i = 0; i < filesNumber; i++) {
			files[i].append(s);
		}
	}
	
	private void appendRandomString(int length) {
		for (int i = 0; i < filesNumber; i++) {
			files[i].append(generateRandomString(length));
		}
	}

	
	private void appendConstantString(char f, int length) {
		String s = generateConstantString(f, length);
		for (int i = 0; i < filesNumber; i++) {
			files[i].append(s);
		}
	}

	public static int getFilesNumber() {
		return filesNumber;
	}



	public StringBuffer[] getFiles() {
		return files;
	}

	static public char generateRandomChar() {
		return (char)(Math.random() * 127);
	}
	
	static public String generateRandomString(int length) {
		StringBuffer s = new StringBuffer();
		for (int i = 0; i < length; i++) {
			s.append(generateRandomChar());
		}
		return s.toString();
	}
	
	static public String generateConstantString(char f, int length) {
		char[] a = new char[length];
		Arrays.fill(a, f);
		return new String(a);
	}

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		TestFormatSetGenerator gf = new TestFormatSetGenerator();
		StringBuffer[] s = gf.getFiles();
		for (int i = 0; i < getFilesNumber(); i++) {
			//System.out.println(s[i].toString());
			//System.out.println("file " + i + " length " + s[i].length());
			byte[] b = s[i].toString().getBytes();
			FileOutputStream fos = new FileOutputStream("C:/projects/dps-falstaff/falstaff-core/src/test/java/com/falstaff/format/../../../../resources/com/falstaff/format/test_file_" + i);
		    fos.write(b);
		    fos.close(); 
		}
	}

}

