package com.falstaff.core.lookup.ktup.centroid;

import com.falstaff.core.lookup.ktup.IKtup;

public abstract class AbstractCentroidFilter<T extends IKtup> implements INKtupCentroidFilter<T> {

	private INKtupCentroidFilter<T> nextFilter;
	
	@Override
	public boolean filter(IKtupCentroid<T> centroid) {
		boolean filtered = filterInternal(centroid);
		if (!filtered && nextFilter != null) {
			filtered = nextFilter.filter(centroid);
		}
		return filtered;
	}

	@Override
	public INKtupCentroidFilter<T> getNextFilter() {
		return nextFilter;
	}

	@Override
	public void setNextFilter(INKtupCentroidFilter<T> nextFilter) {
		this.nextFilter = nextFilter;
	}

	@Override
	public void clear() {
		nextFilter = null;
	}

	protected abstract boolean filterInternal(IKtupCentroid<T> centroid);

}
