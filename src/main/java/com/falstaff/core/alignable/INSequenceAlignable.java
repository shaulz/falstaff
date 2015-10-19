package com.falstaff.core.alignable;

import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.lookup.ktup.IKtup;

public interface INSequenceAlignable<T extends IKtup> extends INContinuousAlignable<T> {
	public ByteArrayCharSequence charSequence();
	public ByteArrayCharSequence charSequence(Segment segment);
}
