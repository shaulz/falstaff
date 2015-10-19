package com.falstaff.core.alignable;

import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.score.Alphabet;

public class ByteArrayCharSequence implements CharSequence {

	private Segment segment;
	private byte[] sequence;
	private static char[] byte2char = null;

	public ByteArrayCharSequence(byte[] sequence) {
		this(sequence,new Segment(0,sequence.length));
	}

	public ByteArrayCharSequence(byte[] sequence, Segment segment) {
		super();
		this.sequence = sequence;
		this.segment = segment;
	}

	@Override
	public int length() {
		return segment.getLength();
	}

	@Override
	public char charAt(int index) {
		if (byte2char == null) {
			byte2char = new char[Byte.MAX_VALUE - Byte.MIN_VALUE + 1];
			for (int i = 0; i <= Byte.MAX_VALUE - Byte.MIN_VALUE; i++) {
				byte2char[i] = (char)i;
			}
		}
		return byte2char[Alphabet.byte2int(sequence[segment.getStart() + index])];
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return new ByteArrayCharSequence(sequence, new Segment(segment.getStart() + start, end - start));
	}

	public byte[] getSequence() {
		return sequence;
	}

}
