package com.falstaff.core.lookup.filter;

import com.falstaff.core.lookup.ktup.IScorableKtup;

public class NKtupScoreFilter extends NAbstractKtupFilter<IScorableKtup> implements INKtupFilter<IScorableKtup>{

	private int scoreCutoff;
	
	
	public NKtupScoreFilter(int scoreCutoff) {
		super();
		this.scoreCutoff = scoreCutoff;
	}


	@Override
	public boolean filterInternal(IScorableKtup ktup) {
		int score = ktup.getScore();
		return score < scoreCutoff;
	}


	@Override
	public boolean filterInternal(byte b) {
		return false;
	}

}
