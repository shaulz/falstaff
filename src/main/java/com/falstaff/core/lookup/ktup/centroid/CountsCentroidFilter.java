package com.falstaff.core.lookup.ktup.centroid;

import com.falstaff.core.lookup.ktup.IKtup;

public class CountsCentroidFilter<T extends IKtup> extends AbstractCentroidFilter<T> implements INKtupCentroidFilter<T> {

	private int alignablesCountCutoff;
	private int ktupsCountCutoff;
	
	public CountsCentroidFilter(int alignablesCountCutoff, int ktupsCountCutoff) {
		super();
		this.alignablesCountCutoff = alignablesCountCutoff;
		this.ktupsCountCutoff = ktupsCountCutoff;
	}

	@Override
	protected boolean filterInternal(IKtupCentroid<T> centroid) {
		return (centroid.getAlignablesCount() < alignablesCountCutoff || centroid.getKtupsCount() < ktupsCountCutoff);
	}	
}
