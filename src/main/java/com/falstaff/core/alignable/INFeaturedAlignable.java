package com.falstaff.core.alignable;

import java.util.Set;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.feature.IFeature;
import com.falstaff.core.lookup.ktup.IKtup;

public interface INFeaturedAlignable<T extends IKtup> extends INScorableAlignable {
	public String getFileName();
	public long getFileSize();
	public long getLastModified();
	public void addFeature(IFeature feature);
	public Set<IFeature> getFeatures();
	public Set<NSignature> getAlignedSignatures();
	public void setAlignedSignatures(Set<NSignature> alignedSignatures);
	public void setSequence(byte[] sequence);
	public void setEncoding(String encoding);
	public String getEncoding();
	public boolean isText();
}
