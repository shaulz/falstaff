package com.falstaff.core.alignable;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.score.ByteDistribution;

public class NAlignedRows {

	private static final Logger log = LoggerFactory.getLogger(NAlignedRows.class
			.getName());
	
	public enum Padding { LEFT, RIGHT }
	
	private SortedMap<INScorableAlignable, List<AlignedEntry>> rows;
	
	private class AlignableIdComparator implements Comparator<INScorableAlignable> {

		@Override
		public int compare(INScorableAlignable a1, INScorableAlignable a2) {
			return a1.getId() - a2.getId();
		}		
	}
	
	private class AlignedEntry {
		int start;
		int end;
		Byte value;
		
		public AlignedEntry(int start, int end, Byte value) {
			super();
			this.start = start;
			this.end = end;
			this.value = value;
		}

		public int getStart() {
			return start;
		}
		
		public void setStart(int start) {
			this.start = start;
		}
		
		public int getEnd() {
			return end;
		}
		
		public void setEnd(int end) {
			this.end = end;
		}
		
		public Byte getValue() {
			return value;
		}
		
		public void setValue(Byte value) {
			this.value = value;
		}
	}

	public NAlignedRows() {
		rows = new TreeMap<INScorableAlignable, List<AlignedEntry>>(new AlignableIdComparator());
	}
	
	public Byte getEntryValue(INScorableAlignable alignable, int column) {
		return rows.get(alignable).get(column).getValue();
	}

	public int getEntryStart(INScorableAlignable alignable, int column) {
		return rows.get(alignable).get(column).getStart();
	}
	
	public int getEntryEnd(INScorableAlignable alignable, int column) {
		return rows.get(alignable).get(column).getEnd();
	}
	
	public int getStart(INScorableAlignable alignable) {
		return rows.get(alignable).get(0).getStart();
	}
	
	public int getEnd(INScorableAlignable alignable) {
		return rows.get(alignable).get(rows.get(alignable).size() - 1).getEnd();
	}	

	public void addColumn(INScorableAlignable alignableX, int alignableXStart, int alignableXEnd, INScorableAlignable alignableY, int alignableYStart, int alignableYEnd) {
		addColumn(alignableX, alignableXStart, alignableXEnd);
		addColumn(alignableY, alignableYStart, alignableYEnd);
	}
	
	public void merge(int start, int end, INScorableAlignable alignable,
			int alignableStart, int alignableEnd, Padding padding) {
		int paddingLength = Math.abs(end - start - (alignableEnd - alignableStart));
		for (INScorableAlignable aligned : alignable.getAligned()) {
			rows.put(aligned, new ArrayList<AlignedEntry>());
			if (alignableEnd - alignableStart < end - start && padding.equals(Padding.LEFT)) {
				int alignedStart = alignable.getAlignedByteStart(aligned, alignableStart);
				for (int i = 0; i < paddingLength; i++) {
					AlignedEntry entry = new AlignedEntry(alignedStart, alignedStart, null);
					rows.get(aligned).add(entry);
				}
			}
			for (int column = alignableStart; column <= alignableEnd; column++) {
				Byte b = alignable.getAlignedByte(aligned, column);
				int alignedStart = alignable.getAlignedByteStart(aligned, column);
				int alignedEnd = alignable.getAlignedByteStart(aligned, column);
				AlignedEntry entry = new AlignedEntry(alignedStart, alignedEnd, b);
				rows.get(aligned).add(entry);
			}
			if (alignableEnd - alignableStart < end - start && padding.equals(Padding.RIGHT)) {
				int alignedEnd = alignable.getAlignedByteEnd(aligned, alignableEnd);
				for (int i = 0; i < paddingLength; i++) {
					AlignedEntry entry = new AlignedEntry(alignedEnd, alignedEnd, null);
					rows.get(aligned).add(entry);
				}
			}
		}
		for (INScorableAlignable aligned : rows.keySet()) {
			if (alignableEnd - alignableStart > end - start && padding.equals(Padding.LEFT)) {
				int alignedStart = getEntryStart(aligned, start);
				for (int i = 0; i < paddingLength; i++) {
					AlignedEntry entry = new AlignedEntry(alignedStart, alignedStart, null);
					rows.get(aligned).add(0,entry);
				}
			}
			if (alignableEnd - alignableStart > end - start && padding.equals(Padding.RIGHT)) {
				int alignedEnd = getEntryEnd(aligned, end);
				for (int i = 0; i < paddingLength; i++) {
					AlignedEntry entry = new AlignedEntry(alignedEnd, alignedEnd, null);
					rows.get(aligned).add(entry);
				}
			}
		}
	}
	
	public void removeColumn(int column) {
		for (INScorableAlignable aligned : rows.keySet()) {
			rows.get(aligned).remove(column);
		}
	}

	private void addEntry(INScorableAlignable alignable, AlignedEntry entry) {
		if (!rows.containsKey(alignable)) {
			rows.put(alignable, new ArrayList<AlignedEntry>());
		}
		rows.get(alignable).add(entry);
	}
	
	private void addColumn(INScorableAlignable alignable, int alignableStart, int alignableEnd) {
		for (INScorableAlignable aligned : alignable.getAligned()) {
			Byte alignedValue;
			int alignedStart;
			int alignedEnd;
			int column;
			if (alignableEnd > alignableStart) {
				column = alignableStart;
				alignedValue = alignable.getAlignedByte(aligned, column);
				alignedStart = alignable.getAlignedByteStart(aligned, column);
				alignedEnd = alignable.getAlignedByteEnd(aligned, column);
			}
			else {
				if (alignableEnd == 0) {
					column = 0;
					alignedStart = alignable.getAlignedByteStart(aligned, column);
				}
				else {
					column = alignableStart - 1;
					alignedStart = alignable.getAlignedByteEnd(aligned, column);
				}
				alignedEnd = alignedStart;
				alignedValue = null;
			}
			AlignedEntry entry = new AlignedEntry(alignedStart, alignedEnd, alignedValue);
			addEntry(aligned, entry);
		}		
	}
	
	public Set<INScorableAlignable> getAligned() {
		return rows.keySet();
	}
	
	public int getAlignedCount() {
		return rows.size();
	}

	public boolean isAligned(INScorableAlignable alignable) {
		return rows.containsKey(alignable);
	}
	
	public ByteDistribution getByteDistribution(int column) {
		ByteDistribution byteDistribution = new ByteDistribution();
		for (INScorableAlignable alignable : rows.keySet()) {
			byteDistribution.add(getEntryValue(alignable, column));
		}
		return byteDistribution;
	}

}
