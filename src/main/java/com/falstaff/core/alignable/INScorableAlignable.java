package com.falstaff.core.alignable;

import java.util.Set;

import com.falstaff.core.lookup.filter.INKtupFilter;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.IScoreCalculator;

public interface INScorableAlignable extends INSequenceAlignable<IScorableKtup> {	
	public Set<INScorableAlignable> getAligned();
	public int getAlignedCount();
	public Byte getAlignedByte(INScorableAlignable aligned, int column);
	public int getAlignedByteStart(INScorableAlignable aligned, int column);
	public int getAlignedByteEnd(INScorableAlignable aligned, int column);
	public int getScore();
	public int getScore(int column);
	public void setScoreCalculator(IScoreCalculator scoreCalculator);
	public IScoreCalculator getScoreCalculator();
	public int matchScore(int columnThis, INScorableAlignable other, int columnOther);
	public int matchScore(int columnThis, ByteDistribution distribution);
	public int matchScore(int columnThis, Byte b);
	public int insertionScore(int columnThis, INScorableAlignable other, int columnOther);
	public int deletionScore(int columnThis, INScorableAlignable other, int columnOther);
	public INKtupIterator<IScorableKtup> ktupIterator(int ktupLength, int alignableStart, int alignableEnd);
	public INKtupIterator<IScorableKtup> ktupIterator(int ktupLength, int alignableStart, int alignableEnd, INKtupFilter<IScorableKtup> filter);
}
