package com.falstaff.core.alignable.sequence;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.feature.IFeature;
import com.falstaff.core.lookup.ktup.IKtup;

public class NFormatFile extends NScorableSequenceAlignable implements INFeaturedAlignable<IKtup> {

	public static final String MIME_FORMAT = "mime";
	public static final String PRONOM_FORMAT = "pronom";
	
	private File file;
	private Set<NSignature> alignedSignatures;
	private Set<IFeature> features;
	
	public NFormatFile() {
		super();
	}
	
	public NFormatFile(File file) {
		super(file);
		this.file = file;
		features = new HashSet<IFeature>();
		alignedSignatures = new HashSet<NSignature>();
	}

	public void addFeature(IFeature feature) {
		features.add(feature);
	}

	public Set<IFeature> getFeatures() {
		return features;
	}
	
	public File getFile() {
		return file;
	}

	@Override
	public String getFileName() {
		return file.getName();
	}

	@Override
	public long getFileSize() {
		return file.length();
	}

	@Override
	public long getLastModified() {
		return file.lastModified();
	}
	
	@Override
	public Set<NSignature> getAlignedSignatures() {
		return alignedSignatures;
	}

	@Override
	public void setAlignedSignatures(Set<NSignature> alignedSignatures) {
		this.alignedSignatures = alignedSignatures;		
	}
}
