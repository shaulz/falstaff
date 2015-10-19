package com.falstaff.service;

import com.falstaff.core.aligner.ClustererContext;
import com.falstaff.core.aligner.MagicClustererContext;
import com.falstaff.core.classification.AlignedSignaturesSet;

public class AlignerContext {

	private boolean alignVariablePosition = true;
	private boolean alignMagic = true;
	private boolean lowComplexityMasker;
	private ClustererContext variablePositionContext;
	private MagicClustererContext magicContext;
	private AlignedSignaturesSet signaturesSet;
	
	public AlignerContext(boolean alignVariablePosition, boolean alignMagic,
			boolean lowComplexityMasker,
			ClustererContext variablePositionContext,
			MagicClustererContext magicContext,
			AlignedSignaturesSet signaturesSet) {
		super();
		this.alignVariablePosition = alignVariablePosition;
		this.alignMagic = alignMagic;
		this.lowComplexityMasker = lowComplexityMasker;
		this.variablePositionContext = variablePositionContext;
		this.magicContext = magicContext;
		this.signaturesSet = signaturesSet;
	}
	
	public AlignerContext() {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isAlignVariablePosition() {
		return alignVariablePosition;
	}

	public void setAlignVariablePosition(boolean alignVariablePosition) {
		this.alignVariablePosition = alignVariablePosition;
	}

	public boolean isAlignMagic() {
		return alignMagic;
	}

	public void setAlignMagic(boolean alignMagic) {
		this.alignMagic = alignMagic;
	}

	public boolean isLowComplexityMasker() {
		return lowComplexityMasker;
	}

	public void setLowComplexityMasker(boolean lowComplexityMasker) {
		this.lowComplexityMasker = lowComplexityMasker;
	}

	public ClustererContext getVariablePositionContext() {
		return variablePositionContext;
	}

	public void setVariablePositionContext(ClustererContext variablePositionContext) {
		this.variablePositionContext = variablePositionContext;
	}

	public MagicClustererContext getMagicContext() {
		return magicContext;
	}

	public void setMagicContext(MagicClustererContext magicContext) {
		this.magicContext = magicContext;
	}

	public AlignedSignaturesSet getSignaturesSet() {
		return signaturesSet;
	}

	public void setSignaturesSet(AlignedSignaturesSet signaturesSet) {
		this.signaturesSet = signaturesSet;
	}
}
