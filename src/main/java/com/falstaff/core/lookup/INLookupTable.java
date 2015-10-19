package com.falstaff.core.lookup;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import com.falstaff.core.lookup.filter.INKtupFilter;
import com.falstaff.core.lookup.filter.match.INKtupMatchFilter;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.centroid.CentroidIterator;
import com.falstaff.core.lookup.ktup.centroid.IKtupCentroid;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;

public interface INLookupTable<T extends IKtup> {
	public boolean add(T ktup);
	public void add(INKtupIterator<? extends T> iterator);
	public void add(Collection<INKtupIterator<? extends T>> iterators, INKtupCentroidFilter<T> postFillFilter);
	public void remove(INKtupCentroidFilter<T> centroidFillFilter);
	public void remove(Collection<INKtupIterator<? extends T>> iterators, INKtupCentroidFilter<T> postFillFilter);
	public IKtupCentroid<T> getCentroid(T ktup, INKtupCentroidFilter<T> filter);
	public CentroidIterator<T> getCentroids(INKtupCentroidFilter<T> filter);
	public int getCentroidsCount();
	public NLookupTableStats getStats();
	public void fillStats();
	public void clear();
	public int getKtupLength();
}
