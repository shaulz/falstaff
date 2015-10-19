package com.falstaff.core.lookup.ktup;

import java.util.Iterator;

import com.falstaff.core.lookup.filter.INKtupFilter;

public interface INKtupIterator<T extends IKtup> extends Iterator<T> {
	public INKtupIterator<T> copy();
	public INKtupFilter<T> getFilter();	
	public void setFilter(INKtupFilter<T> filter);
}
