package com.falstaff.core.aligner;

import java.util.List;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;

public interface INCluster {
	List<INMultipleAlignment> cluster(List<IScorableKtup> orderedKtups);
	List<INMultipleAlignment> cluster(List<IScorableKtup> orderedKtups, INKtupCentroidFilter<IScorableKtup> filter);
}
