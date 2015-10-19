package com.falstaff.core.lookup.filter;

import com.falstaff.core.lookup.ktup.IKtup;

public interface INKtupFilter<T extends IKtup> {
	public boolean filter(T ktup);
	public boolean filter(byte b);
	public void setNextFilter(INKtupFilter<T> filter);
	public INKtupFilter<T> getNextFilter();
	public void clear();
}

