package com.falstaff.core.lookup.filter;

import com.falstaff.core.lookup.ktup.IKtup;

public class KtupFirstByteBoundsFilter<T extends IKtup> extends NAbstractKtupFilter<T> implements INKtupFilter<T> {
	
	private static int UNSIGNED_SHIFT = -Byte.MIN_VALUE;
	
	private int lowBound;
	private int highBound;

	public KtupFirstByteBoundsFilter(int lowBound, int highBound) {
		super();
		this.lowBound = lowBound;
		this.highBound = highBound;
	}

	protected boolean filterInternal(T ktup) {
		return filterInternal(ktup.getByte(0));
	}

	protected boolean filterInternal(byte b) {
		int byteValue = b + UNSIGNED_SHIFT;
		if (byteValue >= lowBound && byteValue <= highBound) {
			return false;
		}
		return true;
	}

	public int getLowBound() {
		return lowBound;
	}

	public void setLowBound(int lowBound) {
		this.lowBound = lowBound;
	}

	public int getHighBound() {
		return highBound;
	}

	public void setHighBound(int highBound) {
		this.highBound = highBound;
	}
	
}
