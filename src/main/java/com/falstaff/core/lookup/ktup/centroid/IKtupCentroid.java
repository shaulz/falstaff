package com.falstaff.core.lookup.ktup.centroid;

import java.util.List;

import com.falstaff.core.lookup.ktup.IKtup;

public interface IKtupCentroid<T extends IKtup> {
	public List<T> getKtups();
	public int getKtupsCount();
	public int getAlignablesCount();
}
