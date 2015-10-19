package com.falstaff.core.alignable.identity;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import com.falstaff.core.alignable.INSequenceAlignable;
import com.falstaff.core.alignable.INSequenceAlignment;
import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.geometry2D.DiagonalSegment;
import com.falstaff.core.score.Alphabet;

public class NIdentityAlignment implements INSequenceAlignment {

	private INSequenceAlignable alignableX;
	private INSequenceAlignable alignableY;
	private DiagonalSegment diagonalSegment;

	public NIdentityAlignment(INSequenceAlignable alignableX, INSequenceAlignable alignableY,
			DiagonalSegment diagonalSegment) {
		super();
		this.alignableX = alignableX;
		this.alignableY = alignableY;
		this.diagonalSegment = diagonalSegment;
	}
	
	public Segment getAlignmentX() {
		return diagonalSegment.getSegmentX();
	}

	public Segment getAlignmentY() {
		return diagonalSegment.getSegmentY();
	}

	@Override
	public int length() {
		return getAlignmentX().getLength();
	}

	@Override
	public Byte getByte(int index) {
		return byteXAt(index);
	}

	@Override
	public ListIterator<Byte> byteIterator() {
		List<Byte> bytes = new ArrayList<Byte>(length());
		for (int i = 0; i < length(); i++) {
			bytes.add(getByte(i));
		}
		return bytes.listIterator();
	}

	@Override
	public String getHex(int start, int end) {
		final StringBuilder hex = new StringBuilder(2 * (end - start + 1));
		for (int i = start ; i <= end ; i++) {
			hex.append(Alphabet.byte2hex(getByte(i)));
		}
		return hex.toString();
	}

	@Override
	public Byte byteXAt(int index) {
		return alignableX.getByte(getAlignmentX().getStart() + index);
	}

	@Override
	public Byte byteYAt(int index) {
		return alignableY.getByte(getAlignmentY().getStart() + index);
	}

	@Override
	public Integer indexXStartAt(int index) {
		return getAlignmentX().getStart() + index;
	}

	@Override
	public Integer indexXEndAt(int index) {
		return getAlignmentX().getStart() + index + 1;
	}

	@Override
	public Integer indexYStartAt(int index) {
		return getAlignmentY().getStart() + index;
	}

	@Override
	public Integer indexYEndAt(int index) {
		return getAlignmentY().getStart() + index + 1;
	}

	@Override
	public int lengthX() {
		return length();
	}

	@Override
	public int lengthY() {
		return length();
	}

	@Override
	public INSequenceAlignable getAlignableX() {
		return alignableX;
	}

	@Override
	public INSequenceAlignable getAlignableY() {
		return alignableY;
	}

}
