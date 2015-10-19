package com.falstaff.core.alignable;

import java.util.ListIterator;

public interface INSequenceAlignment {
	public int length();
	public Byte getByte(int index);
	public ListIterator<Byte> byteIterator();
	public String getHex(int start, int end);
	public Byte byteXAt(int index);
	public Byte byteYAt(int index);
	public Integer indexXStartAt(int index);
	public Integer indexXEndAt(int index);
	public Integer indexYStartAt(int index);
	public Integer indexYEndAt(int index);
	public int lengthX();
	public int lengthY();
	public INSequenceAlignable getAlignableX();
	public INSequenceAlignable getAlignableY();
}
