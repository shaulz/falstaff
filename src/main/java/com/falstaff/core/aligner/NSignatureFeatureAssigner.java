package com.falstaff.core.aligner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.alignable.signature.NSignature;
import com.falstaff.core.feature.NSignatureFeature;
import com.falstaff.core.lookup.INLookupTable;
import com.falstaff.core.lookup.ktup.IKtup;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.IKtupCentroid;

public class NSignatureFeatureAssigner extends NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> {
	
	private static final Logger log = LoggerFactory
			.getLogger(NSignatureFeatureAssigner.class.getName());

	
	private INLookupTable<IKtup> signaturesLookup;
	private Set<NSignature> unalignableSignatures;
	
	public NSignatureFeatureAssigner(INLookupTable<IKtup> signaturesLookup, Set<NSignature> signatures) {
		super();
		this.signaturesLookup = signaturesLookup;
		unalignableSignatures = new HashSet<NSignature>();
		List<INKtupIterator<? extends IKtup>> iterators = new LinkedList<INKtupIterator<? extends IKtup>>();
		for (NSignature signature : signatures) {
			// copy the signature
			NSignature lookupSignature = new NSignature(signature);
			INKtupIterator<IKtup> iterator = lookupSignature.ktupIterator(signaturesLookup.getKtupLength());
			if (iterator.hasNext() && lookupSignature.getPattern().pattern().charAt(0) != '^' && lookupSignature.getPattern().pattern().charAt(signature.getPattern().pattern().length() - 1) != '$' ) {
				iterators.add(iterator);
			}
			else {
				unalignableSignatures.add(lookupSignature);
			}
		}
		signaturesLookup.add(iterators, null);
	}

	@Override
	public Collection<? extends INFeaturedAlignable> transformInternal(
			Collection<? extends INFeaturedAlignable> formatFiles) {
		int assignedFormatFilesCount = 0;
		for (INFeaturedAlignable formatFile : formatFiles) {
			if (formatFile.length() > 0) {
				assign(formatFile);
			}
			assignedFormatFilesCount++;
			if (processMonitor != null) {
				processMonitor.setPercentageCompleted(assignedFormatFilesCount * 100 / formatFiles.size());
			}
			log.debug("number of signature features assigned to file " + formatFile.getFileName() + " is " + (formatFile.getFeatures() != null ? formatFile.getFeatures().size() : 0));
		}
		return formatFiles;
	}
	
	private void assign(INFeaturedAlignable<IKtup> formatFile) {
		// align signatures having ktup
		INKtupIterator<IScorableKtup> ktupIterator = formatFile.ktupIterator(signaturesLookup.getKtupLength());
		while (ktupIterator.hasNext()) {
			IKtup fileKtup = ktupIterator.next();
			IKtupCentroid<IKtup> centroid = signaturesLookup.getCentroid(fileKtup, null);
			if (centroid == null) {
				continue;
			}
			for (IKtup signatureKtup : centroid.getKtups()) {
				NSignature signature = (NSignature)signatureKtup.getAlignable();
				if (signature.align(fileKtup)) {
					formatFile.getAlignedSignatures().add(signature);
				}
			}
		}
		
		// align not alignable signatures
		for (NSignature signature : unalignableSignatures) {
			if (signature.align(formatFile)) {
				formatFile.getAlignedSignatures().add(signature);
			}
		}
		
		Set<NSignature> alignedSignatures = formatFile.getAlignedSignatures();
		if (alignedSignatures != null) {
			for (NSignature signature : alignedSignatures) {
				for (NSignature featureSignature : signature.getFeatureSignatures(true)) {
					NSignatureFeature signatureFeature = new NSignatureFeature(featureSignature);
					formatFile.addFeature(signatureFeature);
					log.info("feature " + signatureFeature.getName() + " asigned to file " + formatFile.getFileName());
				}
			}
		}
	}

	@Override
	public void clear() {
	}
	
	@Override
	public String getName() {
		return "signature propeties features assigner";
	}
}
