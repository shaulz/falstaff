package com.falstaff.core.classification;

import java.util.LinkedList;
import java.util.Set;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.alignable.signature.pronom.PronomParser;

public class PronomSignaturesSet extends FeaturedSignaturesSet {

	private String puid;
	
	public PronomSignaturesSet() {
		super();
		source = SignaturesSource.PRONOM;
	}
	
	public PronomSignaturesSet(String puid, FileFormat format, boolean importSignatures) {
		super(puid, SignaturesSource.PRONOM, new LinkedList<NSignature>(), format);
		if (importSignatures) {
			setSignatures();
		}
		this.puid = puid;
	}
	
	public void setSignatures() {
		Set<NSignature> pronomSignatures = new PronomParser().parse(puid);
		addSignatures(pronomSignatures);
	}

	public String getPuid() {
		return puid;
	}

	public void setPuid(String puid) {
		this.puid = puid;
	}

	@Override
	public String getURL() {
		return PronomParser.getURL(puid);
	}
	
	@Override
	public String getURLName() {
		return getFile();
	}
	
	@Override
	public String getURLDescription() {
		return "signatures were imported from a pronom file ";
	}
	
	public String getFile() {
		return PronomParser.getFile(puid);
	}
	
	@Override
	public String getDescription() {
		if (description == null || description.isEmpty()) {
			return "";
		}
		return description;
	}
}
