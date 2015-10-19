package com.falstaff.core.lookup.filter.match;

import java.util.List;

import com.falstaff.core.lookup.ktup.IKtup;

public interface INKtupMatchFilter<T extends IKtup> {
	public boolean filter(T matchingKtup,T matchedKtup);
	public boolean filterAll(T matchingKtup,List<T> matchedKtups);
	public void setNextFilter(INKtupMatchFilter<T> filter);
	public INKtupMatchFilter<T> getNextFilter();
	public void clear();
}
