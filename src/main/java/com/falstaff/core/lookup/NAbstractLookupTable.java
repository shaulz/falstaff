package com.falstaff.core.lookup;

import com.falstaff.core.lookup.ktup.IKtup;

public abstract class NAbstractLookupTable<T extends IKtup> implements INLookupTable<T> {
	protected NLookupTableStats stats;
	protected final int ktupLength;
	
	public NAbstractLookupTable(int ktupLength) {
		this.ktupLength = ktupLength;
		stats = new NLookupTableStats();
	}

	public NLookupTableStats getStats() {
		return stats;
	}

	@Override
	public void clear() {
		stats = new NLookupTableStats();
	}

	public int getKtupLength() {
		return ktupLength;
	}
	
	public abstract void fillStats();
}
