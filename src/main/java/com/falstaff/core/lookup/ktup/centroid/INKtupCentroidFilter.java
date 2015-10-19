package com.falstaff.core.lookup.ktup.centroid;

import com.falstaff.core.lookup.ktup.IKtup;

public interface INKtupCentroidFilter<T extends IKtup> {
	public boolean filter(IKtupCentroid<T> centroid);
	public void setNextFilter(INKtupCentroidFilter<T> filter);
	public INKtupCentroidFilter<T> getNextFilter();
	public void clear();
}
