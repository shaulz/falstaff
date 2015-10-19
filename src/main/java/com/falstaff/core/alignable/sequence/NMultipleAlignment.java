package com.falstaff.core.alignable.sequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.ByteArrayCharSequence;
import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.alignable.NAbstractAlignment;
import com.falstaff.core.alignable.NAlignedRows;
import com.falstaff.core.alignable.NAlignedRows.Padding;
import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.lookup.filter.INKtupFilter;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.ScorableKtup;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.IScoreCalculator;

public class NMultipleAlignment extends NAbstractAlignment implements INMultipleAlignment {

	private static final Logger log = LoggerFactory
	.getLogger(NMultipleAlignment.class.getName());
	
	private int score;
	private List<ByteDistribution> columnByteDistribution;
	private List<Byte> columnValues;
	private NAlignedRows rows;
	private IScoreCalculator scoreCalculator;
	
	public NMultipleAlignment() {
		columnValues = new ArrayList<Byte>();
		rows = new NAlignedRows();
		columnByteDistribution = new ArrayList<ByteDistribution>();
		score = 0;
	}
	
	public class AlignmentKtupIterator implements INKtupIterator<IScorableKtup> {
		private int index;
		private final int ktupLength;
		private int maxIndex;
		private INKtupFilter<IScorableKtup> filter;

		public AlignmentKtupIterator(int ktupLength, INKtupFilter<IScorableKtup> filter) {
			this(ktupLength, 0, length() - 1, filter);
		}
		
		private AlignmentKtupIterator(int index, int ktupLength, INKtupFilter<IScorableKtup> filter) {
			this(ktupLength, index, length() - 1, filter);
		}
		
		public AlignmentKtupIterator(int ktupLength, int alignableStart, int alignableEnd, INKtupFilter<IScorableKtup> filter) {
			this.ktupLength = ktupLength;
			this.maxIndex = alignableEnd - ktupLength + 1;
			this.filter = filter;
			index = findKtup(alignableStart);
		}

		private int findKtup(int index) {
			int cnt = 0;
			while (cnt < ktupLength && index <= maxIndex) {
				if (columnValues.get(index + cnt) != null) {
					cnt++;
					if (filter != null) {
						IScorableKtup ktup = getKtup(index, ktupLength);
						if (filter.filter(ktup)) {
							cnt--;
						}
					}
				} else {
					index = index + cnt + 1;
					cnt = 0;
				}
			}
			return index;
		}

		public boolean hasNext() {
			return index <= maxIndex;
		}

		public IScorableKtup next() {
			// TODO Auto-generated method stub
			IScorableKtup ktup = getKtup(index, ktupLength);
			index = findKtup(index + 1);
			return ktup;
		}

		@Override
		public void remove() {
		}

		@Override
		public INKtupIterator<IScorableKtup> copy() {
			return new AlignmentKtupIterator(index, ktupLength,filter);
		}

		public INKtupFilter<IScorableKtup> getFilter() {
			return filter;
		}

		public void setFilter(INKtupFilter<IScorableKtup> filter) {
			this.filter = filter;
		}
	}
	
	@Override
	public IScorableKtup getKtup(int index, int length) {
		return new ScorableKtup(index, length, this);
	}

	@Override
	public INKtupIterator<IScorableKtup> ktupIterator(int ktupLength) {
		return ktupIterator(ktupLength, null);
	}
	
	@Override
	public INKtupIterator<IScorableKtup> ktupIterator(int ktupLength,
			int alignableStart, int alignableEnd) {
		return ktupIterator(ktupLength, alignableStart, alignableEnd, null);
	}
	
	@Override
	public INKtupIterator<IScorableKtup> ktupIterator(int ktupLength, INKtupFilter<IScorableKtup> filter) {
		return new AlignmentKtupIterator(ktupLength, filter);
	}
	
	@Override
	public INKtupIterator<IScorableKtup> ktupIterator(int ktupLength,
			int alignableStart, int alignableEnd, INKtupFilter<IScorableKtup> filter) {
		return new AlignmentKtupIterator(ktupLength, alignableStart, alignableEnd, filter);
	}
	
	public void addColumn(Byte columnValue, int columnScore, INScorableAlignable alignableX, int alignableXStart, int alignableXEnd, INScorableAlignable alignableY, int alignableYStart, int alignableYEnd) {
		columnValues.add(columnValue);
		score += columnScore;
		rows.addColumn(alignableX, alignableXStart, alignableXEnd, alignableY, alignableYStart, alignableYEnd);
		ByteDistribution byteDistribution = rows.getByteDistribution(columnByteDistribution.size());
		columnByteDistribution.add(byteDistribution);
		// columnScores.add(columnScore);
	}

	@Override
	public int length() {
		return columnValues.size();
	}

	@Override
	public Byte getByte(int index) {
		return columnValues.get(index);
	}

	@Override
	public Set<INScorableAlignable> getAligned() {
		return rows.getAligned();
	}

	@Override
	public int getAlignedCount() {
		return rows.getAlignedCount();
	}

	@Override
	public Byte getAlignedByte(INScorableAlignable aligned, int column) {
		return rows.getEntryValue(aligned, column);
	}

	@Override
	public int getAlignedByteStart(INScorableAlignable aligned, int column) {
		return rows.getEntryStart(aligned, column);
	}

	@Override
	public int getAlignedByteEnd(INScorableAlignable aligned, int column) {
		return rows.getEntryEnd(aligned, column);
	}
	
	public IScoreCalculator getScoreCalculator() {
		return scoreCalculator;
	}

	public void setScoreCalculator(IScoreCalculator scoreCalculator) {
		this.scoreCalculator = scoreCalculator;
	}

	@Override
	public int matchScore(int columnThis, INScorableAlignable other, int columnOther) {
		ByteDistribution distributionThis = columnByteDistribution.get(columnThis);
		return other.matchScore(columnOther, distributionThis);
	}
		
	@Override
	public int matchScore(int columnThis, ByteDistribution distribution) {
		ByteDistribution distributionThis = columnByteDistribution.get(columnThis);
		return scoreCalculator.score(distributionThis, distribution);
	}

	@Override
	public int matchScore(int columnThis, Byte b) {
		ByteDistribution distributionThis = columnByteDistribution.get(columnThis);
		return scoreCalculator.score(distributionThis, b);
	}

	@Override
	public int insertionScore(int columnThis, INScorableAlignable other, int columnOther) {
		ByteDistribution distributionThis = columnByteDistribution.get(columnThis);
		int alignedOtherAllCount = other.getAlignedCount();
		return scoreCalculator.score(distributionThis, null, alignedOtherAllCount);
	}

	@Override
	public int deletionScore(int columnThis, INScorableAlignable other, int columnOther) {
		return other.insertionScore(columnOther, this, columnThis);
	}

	@Override
	public int getScore() {
		return score;
	}

	@Override
	public int getScore(int column) {
		ByteDistribution distribution = columnByteDistribution.get(column);
		return scoreCalculator.score(distribution);
	}

	@Override
	public boolean isAligned(INScorableAlignable alignable) {
		return rows.isAligned(alignable);
	}

	@Override
	public int getStart(INScorableAlignable alignable) {
		return rows.getStart(alignable);
	}

	@Override
	public int getEnd(INScorableAlignable alignable) {
		return rows.getEnd(alignable);
	}

	@Override
	public Segment getBOFOffset() {
		Segment segment = null;
		Set<INScorableAlignable> aligned = rows.getAligned();
		for (INScorableAlignable alignable : aligned) {
			segment = mergeSegment(alignable, segment, false);
		}
		return segment;
	}

	@Override
	public Segment getEOFOffset() {
		Segment segment = null;
		Set<INScorableAlignable> aligned = rows.getAligned();
		for (INScorableAlignable alignable : aligned) {
			segment = mergeSegment(alignable, segment, true);
		}
		return segment;
	}

	private Segment mergeSegment(INScorableAlignable alignable, Segment segment, boolean inverse) {
		int start = getStart(alignable);
		int end = getEnd(alignable) - 1;
		if (inverse) {
			int tmp = start;
			start = alignable.length() - 1 - end;
			end = alignable.length() - 1 - tmp;
		}
		if (start > alignable.length() / 2 - 1) {
			return segment;
		}
		if (segment == null) {
			segment = new Segment(start, 1);
			return segment;
		}
		if (!segment.contains(start)) {
			start = Math.min(start, segment.getStart());
			end = Math.max(start, segment.getEnd());
			int length = end - start + 1;
			segment = new Segment(start, length);
		}
		
		return segment;
	}
	
	@Override
	public ByteDistribution getByteDistribution(int column) {
		return columnByteDistribution.get(column);
	}

	@Override
	public void merge(int start, int end, INScorableAlignable alignable, int alignableStart, int alignableEnd, Padding padding) {
		rows.merge(start, end, alignable, alignableStart, alignableEnd, padding);
		int length = Math.max(end - start, alignableEnd - alignableStart) + 1;
		columnValues = new ArrayList<Byte>();
		columnByteDistribution = new ArrayList<ByteDistribution>();
		score = 0;
		for (int column = 0; column < length; column++) {
			ByteDistribution distribution = rows.getByteDistribution(column);
			columnByteDistribution.add(distribution);
			if (distribution.getGapCount() > 0 || distribution.getSize() > 1) {
				columnValues.add(null);
			}
			else {
				Byte value = distribution.getBytes().iterator().next();
				columnValues.add(value);
			}
			score += scoreCalculator.score(distribution);
		}
	}

	@Override
	public ByteArrayCharSequence charSequence() {
		return null;
	}

	@Override
	public ByteArrayCharSequence charSequence(Segment segment) {
		return null;
	}
}
