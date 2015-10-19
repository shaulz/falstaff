package com.falstaff.core.aligner.cluster;

import java.util.List;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.aligner.INCluster;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;

public class NClusterStrategy implements INCluster {
	
	private INCluster strategy;

	public NClusterStrategy(INCluster strategy) {
		super();
		this.strategy = strategy;
	}

	@Override
	public List<INMultipleAlignment> cluster(List<IScorableKtup> orderedKtups) {
		return strategy.cluster(orderedKtups);
	}

	@Override
	public List<INMultipleAlignment> cluster(List<IScorableKtup> orderedKtups,
			INKtupCentroidFilter<IScorableKtup> filter) {
		return strategy.cluster(orderedKtups, filter);
	}
}
