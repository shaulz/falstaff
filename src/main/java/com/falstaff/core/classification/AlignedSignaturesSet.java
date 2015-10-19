package com.falstaff.core.classification;

import java.util.LinkedList;
import java.util.List;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.maxent.Datum;

public class AlignedSignaturesSet extends FeaturedSignaturesSet {
	
	public AlignedSignaturesSet() {
		super();
		source = SignaturesSource.FALSTAFF;	
	}
	
	public AlignedSignaturesSet(FeaturedSamplesSet samplesSet) {
		super(samplesSet.getName(), samplesSet.getFormat()); 
		source = SignaturesSource.FALSTAFF;
	}
	
	public AlignedSignaturesSet(FeaturedSamplesSet samplesSet, List<NSignature> signatures) {
		super(samplesSet.getName(), SignaturesSource.FALSTAFF, signatures, samplesSet.getFormat());
	}
	
	public FeaturedSamplesSet getSamplesSet() {
		return format.getSamplesSet(name);
	}

	@Override
	public String getDescription() {
		if (description == null || description.isEmpty()) {
			return "";
		}
		return description;
	}

	@Override
	public List<Datum> getDatum(int simulatedFeaturesNumbe) {
		return new LinkedList<Datum>();
	}

	@Override
	public Boolean isMissClassified() {
		return false;
	}

	@Override
	public void setSimulatedSamples() {
		for (FeaturedSignature signature : signatures) {
			signature.setSimulatedSamples(null);
		}
	}

	@Override
	public String getURL() {
		return "/formats/" + getFormat().getId() + "/samples-sets/" + getSamplesSet().getId();
	}

	@Override
	public String getURLName() {
		return getSamplesSet().getName();
	}

	@Override
	public String getURLDescription() {
		return "signatures were computed from a samples set ";
	}
}
