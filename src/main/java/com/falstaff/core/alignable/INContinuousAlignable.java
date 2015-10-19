package com.falstaff.core.alignable;

import java.util.ListIterator;

import com.falstaff.core.geometry1D.BoundedSegmentedLine;
import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.lookup.ktup.IKtup;

public interface INContinuousAlignable<T extends IKtup> extends INLookupAlignable<T> {
	public int length();
	public Byte getByte(int index);
	public ListIterator<Byte> byteIterator();
	public String getHex(int start, int end);
	public String getChars(int start, int end);
	public void mask(Segment segment);
	public BoundedSegmentedLine getMask();
	public String toString(Segment segment);
}
