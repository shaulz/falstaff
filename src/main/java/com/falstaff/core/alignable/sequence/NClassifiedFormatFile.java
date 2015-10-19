package com.falstaff.core.alignable.sequence;

import java.io.File;

import com.falstaff.core.classification.IIdentifiableAlignable;
import com.falstaff.core.classification.FeaturedClassifier.ClassificationResults;

public class NClassifiedFormatFile extends NFormatFile implements IIdentifiableAlignable {

	private ClassificationResults identificationResult;

	public NClassifiedFormatFile() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NClassifiedFormatFile(File file) {
		super(file);
	}

	public ClassificationResults getIdentificationResult() {
		return identificationResult;
	}

	public void setIdentificationResult(ClassificationResults identificationResult) {
		this.identificationResult = identificationResult;
	}
}
