package com.falstaff.core.lookup;

import java.util.Iterator;

import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.centroid.IKtupCentroid;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;

public interface INCentroidsLookupTable<T extends IKtup> extends INLookupTable<T> {
	public void setCentroidFilter(INKtupCentroidFilter<T> filter);
	public Iterator<IKtupCentroid<T>> getCentroids();
}
