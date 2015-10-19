package com.falstaff.core.classification;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;
import com.falstaff.core.lookup.ktup.IKtup;

public interface IIdentifiableAlignable extends INFeaturedAlignable<IKtup> {
	public void setIdentificationResult(ClassificationResults identificationResult);
	public ClassificationResults getIdentificationResult();
}
