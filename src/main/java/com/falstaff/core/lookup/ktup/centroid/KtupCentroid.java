package com.falstaff.core.lookup.ktup.centroid;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.falstaff.core.alignable.INContinuousAlignable;
import com.falstaff.core.alignable.INLookupAlignable;
import com.falstaff.core.lookup.ktup.IKtup;

public class KtupCentroid<T extends IKtup> implements IKtupCentroid<T> {

	private List<T> ktups;

	public KtupCentroid(List<T> ktups) {
		super();
		this.ktups = ktups;
	}

	@Override
	public List<T> getKtups() {
		return ktups;
	}

	@Override
	public int getKtupsCount() {
		return ktups.size();
	}

	@Override
	public int getAlignablesCount() {
		Set<INLookupAlignable> alignables = new HashSet<INLookupAlignable>();
		for (T ktup : ktups) {
			alignables.add(ktup.getAlignable());
		}
		return alignables.size();
	}
}
