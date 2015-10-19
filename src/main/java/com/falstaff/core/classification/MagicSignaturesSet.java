package com.falstaff.core.classification;

import java.util.LinkedList;
import java.util.List;

import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.alignable.signature.pronom.PronomParser;
import com.falstaff.core.ontology.MagicNumbers.MagicNumberRecord;

public class MagicSignaturesSet extends FeaturedSignaturesSet {
	
	public static final String magicName = "gck";
	public static final String magicURL = "http://www.garykessler.net/library/file_sigs.html";
	
	public MagicSignaturesSet() {
		super();
		source = SignaturesSource.MAGIC;
	}

	public MagicSignaturesSet(List<MagicNumberRecord> magicNumberRecords, FileFormat format, boolean importSignatures) {
		super(magicName, SignaturesSource.MAGIC, new LinkedList<NSignature>(), format);
		String description = "signatures were imported from Gary C. Kessler database " + magicURL + "\n";
		for (MagicNumberRecord magicNumberRecord : magicNumberRecords) {
			description += "\n" + magicNumberRecord.getDescription();
			if (importSignatures) {
				addSignatures(magicNumberRecord.getSignatures());
			}
		}
		setDescription(description);
	}
	
	@Override
	public String getURL() {
		return magicURL;
	}
	
	@Override
	public String getURLName() {
		return "Gary C. Kessler database";
	}

	@Override
	public String getURLDescription() {
		return "signatures were imported from ";		
	}
}
