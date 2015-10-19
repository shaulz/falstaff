package com.falstaff.core.alignable.sequence;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.lookup.filter.INKtupFilter;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.ScorableKtup;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.IScoreCalculator;

public class NScorableSequenceAlignable extends NSequenceAlignable<IScorableKtup> implements INScorableAlignable {

	protected transient IScoreCalculator scoreCalculator;
	
	public NScorableSequenceAlignable() {
		super();
	}

	public NScorableSequenceAlignable(byte[] sequence) {
		super(sequence);
	}
	
	public NScorableSequenceAlignable(File path) {
		super(path);
	}

	/*
	public class ScorableAlignableKtupIterator extends SequenceAlignableKtupIterator<IScorableKtup> {

		public ScorableAlignableKtupIterator(int length) {
			super(length);
		}

		@Override
		public IScorableKtup next() {
			return (IScorableKtup)super.next();
		}		
	}
	*/

	// scoring
	
	public IScoreCalculator getScoreCalculator() {
		return scoreCalculator;
	}

	public void setScoreCalculator(IScoreCalculator scoreCalculator) {
		this.scoreCalculator = scoreCalculator;
	}
	
	@Override
	public int matchScore(int columnThis, INScorableAlignable other, int columnOther) {
		Byte b = getByte(columnThis);
		return other.matchScore(columnOther, b);
	}
	
	@Override
	public int matchScore(int columnThis, ByteDistribution distribution) {
		Byte b = getByte(columnThis);
		return scoreCalculator.score(distribution, b);
	}

	@Override
	public int matchScore(int columnThis, Byte b) {
		Byte bThis = getByte(columnThis);
		return scoreCalculator.score(bThis, b);
	}

	@Override
	public int insertionScore(int columnThis, INScorableAlignable other, int columnOther) {
		Byte b = getByte(columnThis);
		int otherAlignedCount = other.getAlignedCount();
		return scoreCalculator.score(b, 1, null, otherAlignedCount);
	}

	@Override
	public int deletionScore(int columnThis, INScorableAlignable other, int columnOther) {
		return other.insertionScore(columnOther, this, columnThis);
	}

	@Override
	public INKtupIterator<IScorableKtup> ktupIterator(int ktupLength) {
		return new SequenceAlignableKtupIterator<IScorableKtup>(ktupLength, null);
	}
	
	@Override
	public INKtupIterator<IScorableKtup> ktupIterator(int ktupLength, int alignableStart, int alignableEnd) {
		return new SequenceAlignableKtupIterator<IScorableKtup>(ktupLength, alignableStart, alignableEnd, null);
	}

	@Override
	public INKtupIterator<IScorableKtup> ktupIterator(int ktupLength, INKtupFilter<IScorableKtup> filter) {
		return new SequenceAlignableKtupIterator<IScorableKtup>(ktupLength, filter);
	}
	
	@Override
	public INKtupIterator<IScorableKtup> ktupIterator(int ktupLength, int alignableStart, int alignableEnd, INKtupFilter<IScorableKtup> filter) {
		return new SequenceAlignableKtupIterator<IScorableKtup>(ktupLength, alignableStart, alignableEnd, filter);
	}

	@Override
	public IScorableKtup getKtup(int index, int length) {
		return new ScorableKtup(index, length, this);
	}

	@Override
	public Set<INScorableAlignable> getAligned() {
		Set<INScorableAlignable> aligned = new HashSet<INScorableAlignable>();
		aligned.add(this);
		return aligned;
	}

	@Override
	public int getAlignedCount() {
		return 1;
	}

	@Override
	public Byte getAlignedByte(INScorableAlignable aligned, int column) {
		if (!this.equals(aligned)) {
			throw new RuntimeException("can not return aligned byte from not aligned alignable");
		}
		return getByte(column);
	}
	
	@Override
	public int getAlignedByteStart(INScorableAlignable aligned, int column) {
		if (!this.equals(aligned)) {
			throw new RuntimeException("can not return aligned byte from not aligned alignable");
		}
		return column;
	}

	@Override
	public int getAlignedByteEnd(INScorableAlignable aligned, int column) {
		return getAlignedByteStart(aligned, column + 1);
	}

	@Override
	public int getScore() {
		return 0;
	}

	@Override
	public int getScore(int column) {
		return scoreCalculator.score(getByte(column));
	}

}
