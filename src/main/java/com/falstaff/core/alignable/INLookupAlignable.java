package com.falstaff.core.alignable;

import com.falstaff.core.util.IIdentifiable;
import com.falstaff.core.lookup.filter.INKtupFilter;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.INKtupIterator;

public interface INLookupAlignable<T extends IKtup> extends IIdentifiable {
	public INKtupIterator<T> ktupIterator(int ktupLength);
	public INKtupIterator<T> ktupIterator(int ktupLength, INKtupFilter<T> filter);
	public T getKtup(int index, int length);
}
