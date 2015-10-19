package com.falstaff.core.lookup.ktup;

import com.falstaff.core.alignable.INScorableAlignable;

public interface IScorableKtup extends IKtup<INScorableAlignable> {
	public int matchScore(IScorableKtup ktup);
	public int matchScore(IScorableKtup ktupY, int i);
	public int getScore();
	public boolean isHead();
	public boolean isTail();
}