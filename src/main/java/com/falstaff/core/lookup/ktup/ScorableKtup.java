package com.falstaff.core.lookup.ktup;

import com.falstaff.core.alignable.INScorableAlignable;

public class ScorableKtup extends NKtup<INScorableAlignable> implements IScorableKtup {
	

	public ScorableKtup(int offset, int length, INScorableAlignable alignable) {
		super(offset, length, alignable);
	}

	public ScorableKtup(int offset, int length) {
		super(offset, length);
	}

	public ScorableKtup(NKtup<INScorableAlignable> ktup) {
		super(ktup);
	}

	@Override
	public int matchScore(IScorableKtup ktup) {
		int score = 0;
		for (int i = 0; i < length; i++) {
			score += matchScore(ktup, i);
		}
		return score;
	}
	
	@Override
	public int matchScore(IScorableKtup ktup, int i) {
		int score = getAlignable().matchScore(offset + i, ktup.getAlignable(), ktup.getOffset() + i);
		return score;
	}
	
	@Override
	public int getScore() {
		int score = 0;
		for (int i = 0; i < length; i++) {
			score += getAlignable().getScore(offset + i);
		}
		return score;
	}

	@Override
	public boolean isHead() {
		return offset < alignable.length() / 2;
	}

	@Override
	public boolean isTail() {
		return !isHead();
	}
}
