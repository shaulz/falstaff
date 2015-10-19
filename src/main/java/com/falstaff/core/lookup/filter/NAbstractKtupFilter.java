package com.falstaff.core.lookup.filter;

import com.falstaff.core.lookup.ktup.IKtup;

public abstract class NAbstractKtupFilter <T extends IKtup> implements INKtupFilter<T> {

	private INKtupFilter<T> nextFilter;
	
	@Override
	public boolean filter(T ktup) {
		boolean filtered = filterInternal(ktup);
		if (!filtered && nextFilter != null) {
			filtered = nextFilter.filter(ktup);
		}
		return filtered;
	}

	@Override
	public INKtupFilter<T> getNextFilter() {
		return nextFilter;
	}

	@Override
	public boolean filter(byte b) {
		boolean filtered = filterInternal(b);
		if (!filtered && nextFilter != null) {
			filtered = nextFilter.filter(b);
		}
		return filtered;
	}

	@Override
	public void setNextFilter(INKtupFilter<T> nextFilter) {
		if (getNextFilter() != null) {
			getNextFilter().setNextFilter(nextFilter);
		}
		else {
			this.nextFilter = nextFilter;
		}
	}

	@Override
	public void clear() {
		nextFilter = null;
	}

	protected abstract boolean filterInternal(T ktup);	
	protected abstract boolean filterInternal(byte b);	

}
