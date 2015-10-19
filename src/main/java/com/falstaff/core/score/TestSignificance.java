package com.falstaff.core.score;

import java.util.Random;

public class TestSignificance {

	public int bufferLength;
	public int score;
	public TestSignificance(int bufferLength, int score) {
		super();
		this.bufferLength = bufferLength;
		this.score = score;
	}

	public char[] createRandomBuffer() {
		char[] buffer = new char[bufferLength];
		Random generator = new Random();
		for (int i = 0 ; i < bufferLength ; i++)
			buffer[i] = (char)generator.nextInt(256);
		return buffer;
	}

	public boolean compare(char[] buffer1,char[] buffer2,char[] buffer3) {
		String str1 = new String(buffer1);
		String str2 = new String(buffer2);
		String str3 = new String(buffer3);
		for (int i = 0; i < bufferLength - score ; i++) {
			CharSequence align = str1.subSequence(i,i + score);
			if (str2.contains(align) && str3.contains(align)) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int cnt = 0;
		TestSignificance test = new TestSignificance(1024 * 1024, 4);

		for (int i = 0; i < 100; i++) {
			char[] buffer1 = test.createRandomBuffer();
			char[] buffer2 = test.createRandomBuffer();
			char[] buffer3 = test.createRandomBuffer();
			if (test.compare(buffer1, buffer2,buffer3)) {
				cnt++;
			}
			System.out.println("iteration " + i);
		}
		System.out.println("Alignment was found in " + cnt + " out of 100 cases");
	}
}
