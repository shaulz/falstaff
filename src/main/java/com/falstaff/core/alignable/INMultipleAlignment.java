package com.falstaff.core.alignable;

import com.falstaff.core.alignable.NAlignedRows.Padding;
import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.score.ByteDistribution;

public interface INMultipleAlignment extends INScorableAlignable {
	public void addColumn(Byte columnValue, int columnScore, INScorableAlignable alignableX, int alignableXStart, int alignableXEnd, INScorableAlignable alignableY, int alignableYStart, int alignableYEnd);
	public boolean isAligned(INScorableAlignable alignable);
	public int getStart(INScorableAlignable alignable);
	public int getEnd(INScorableAlignable alignable);
	public Segment getBOFOffset();
	public Segment getEOFOffset();
	public void merge(int start, int end, INScorableAlignable alignable,
			int alignableStart, int alignableEnd, Padding padding);
	public ByteDistribution getByteDistribution(int column);
}
