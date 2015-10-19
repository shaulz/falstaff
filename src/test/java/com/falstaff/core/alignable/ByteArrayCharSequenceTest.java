package com.falstaff.core.alignable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import com.falstaff.core.alignable.ByteArrayCharSequence;
import com.falstaff.core.score.Alphabet;


public class ByteArrayCharSequenceTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testAllChars() {
		StringBuffer chars = new StringBuffer("");
		int length = 256;
		byte[] bytes = new byte[length];
		for (int b = 0; b <= length - 1; b++) {		
			chars.append(Alphabet.byte2chars((byte)b));
			bytes[b] = (byte)b;
		}
		ByteArrayCharSequence seq = new ByteArrayCharSequence(bytes);
		Pattern pattern = Pattern.compile(chars.toString());
		Matcher matcher = pattern.matcher(seq);
		assertTrue(matcher.matches());		
	}

}
