package com.falstaff.core.classification;

import java.util.HashSet;
import java.util.Set;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.alignable.sequence.NScorableSequenceAlignable;
import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults.ClassificationResult;
import com.falstaff.core.feature.IFeature;
import com.falstaff.core.lookup.ktup.IKtup;

public class IdentificationRequest extends NScorableSequenceAlignable implements IIdentifiableAlignable {

	private String fileName;
	private long fileSize;
	private long lastModified;
	private Set<IFeature> features;
	private Set<NSignature> alignedSignatures;
	private ClassificationResults identificationResult;
	
	public IdentificationRequest(byte[] sequence, String fileName, long fileSize,
			long lastModified) {
		super(sequence);
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.lastModified = lastModified;
		features = new HashSet<IFeature>();
		alignedSignatures = new HashSet<NSignature>();
	}

	@Override
	public String getFileName() {
		return fileName;
	}

	@Override
	public long getFileSize() {
		return fileSize;
	}

	@Override
	public long getLastModified() {
		return lastModified;
	}

	public Set<IFeature> getFeatures() {
		if (features == null) {
			features = new HashSet<IFeature>();
		}
		return features;
	}

	public void setFeatures(Set<IFeature> features) {
		this.features = features;
	}
	
	public void addFeature(IFeature feature) {
		if (features == null) {
			features = new HashSet<IFeature>();
		}
		features.add(feature);
	}
	
	@Override
	public Set<NSignature> getAlignedSignatures() {
		if (alignedSignatures == null) {
			alignedSignatures = new HashSet<NSignature>();
		}
		return alignedSignatures;
	}

	@Override
	public void setAlignedSignatures(Set<NSignature> alignedSignatures) {
		this.alignedSignatures = alignedSignatures;
	}

	@Override
	public void setIdentificationResult(
			ClassificationResults identificationResult) {
		this.identificationResult = identificationResult;
	}

	@Override
	public ClassificationResults getIdentificationResult() {
		return identificationResult;
	}

}
