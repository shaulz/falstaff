package com.falstaff.core.aligner;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.signature.NLearnedSignature;

public class SignaturesBuilder extends NAbstractAligner<INMultipleAlignment, NLearnedSignature> {

	private static final Logger log = LoggerFactory
			.getLogger(SignaturesBuilder.class.getName());

	@Override
	public Collection<NLearnedSignature> transformInternal(
			Collection<? extends INMultipleAlignment> alignables) {
		Set<NLearnedSignature> signatures = new HashSet<NLearnedSignature>();
		int processedAlignmentsCount = 0;
		for (INMultipleAlignment alignment : alignables) {
			NLearnedSignature signature = new NLearnedSignature(alignment);
			log.info("signature with " + alignment.getAlignedCount() + " alignables " + signature.toString() + " was built");
			signature.merge(signatures);
			processedAlignmentsCount++;
			if (processMonitor != null) {
				processMonitor.setPercentageCompleted(processedAlignmentsCount * 100 / alignables.size());
			}
		}
		
		for (NLearnedSignature signature : signatures) {
			log.info("final signature " + signature.toString() + (signature.getBOFoffset() != null ? " BOF offset " + signature.getBOFoffset().toString() : "") + (signature.getEOFoffset() != null ? " EOF offset " + signature.getEOFoffset().toString() : "") + " was built");
		}
		
		return signatures;
	}
	
	@Override
	public void clear() {
	}
	
	@Override
	public String getName() {
		return "signature builder";
	}
}
