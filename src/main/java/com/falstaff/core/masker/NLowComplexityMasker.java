package com.falstaff.core.masker;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.aligner.NAbstractAligner;
import com.falstaff.core.geometry1D.BoundedSegmentedLine;
import com.falstaff.core.geometry1D.Segment;
import com.falstaff.core.score.ByteDistribution;

public class NLowComplexityMasker extends NAbstractAligner<INScorableAlignable, INScorableAlignable> {

	private static final Logger log = LoggerFactory
			.getLogger(NLowComplexityMasker.class.getName());

	private int lowWindow = 4;
	private double[] lowProbabilities = { 0.75, 0.25 };
	private double lowCutOff = NLowComplexityMasker
			.calculateEntropy(lowProbabilities);
	private int highWindow = 8;
	private double[] highProbabilities = { 0.7, 0.15, 0.15 };
	private double highCutOff = NLowComplexityMasker
			.calculateEntropy(highProbabilities);

	public static double calculateEntropy(double[] probabilities) {
		double entropy = 0;
		for (int i = 0; i < probabilities.length; i++) {
			entropy -= probabilities[i] * Math.log(probabilities[i]);
		}
		return entropy /= Math.log(2);
	}

	@Override
	public Collection<? extends  INScorableAlignable> transformInternal(
			Collection<? extends INScorableAlignable> alignables) {
		int processedAlignablesCount = 0;
		log.info("masking of low complexity regions of " + alignables.size() + " alignables started");

		for (INScorableAlignable alignable : alignables) {
			maskLowComplexity(alignable);
			processedAlignablesCount++;
			if (processMonitor != null) {
				processMonitor.setPercentageCompleted(processedAlignablesCount * 100 / alignables.size());
			}
		}
		
		log.info("masking of low complexity regions of " + alignables.size() + " alignables finished");

		return alignables;
	}
	
	public <T extends INScorableAlignable> void maskLowComplexity(T alignable) {

		int lowWindowCount = 0;
		int highStart;

		if (alignable.length() < lowWindow)
			return;

		// initialize low window distribution
		ByteDistribution lowBytesDistribution = new ByteDistribution();
		ByteDistribution highBytesDistribution = new ByteDistribution();
		for (int i = 0; i < lowWindow - 1; i++) {
			lowBytesDistribution.add(alignable.getByte(i));
			highBytesDistribution.add(alignable.getByte(i));
		}

		for (int lowStart = 0; lowStart <= alignable.length() - lowWindow; lowStart++) {
			lowBytesDistribution.add(alignable.getByte(lowStart + lowWindow - 1));
			highBytesDistribution.add(alignable.getByte(lowStart + lowWindow - 1));

			highStart = lowStart - (highWindow - lowWindow);

			lowProbabilities = lowBytesDistribution.getNotZeroProbabilities();
			double lowEntropy = calculateEntropy(lowProbabilities);
			if (lowEntropy <= lowCutOff) {
				lowWindowCount++;
			} else {
				lowWindowCount = 0;
			}
			
			// mask low window if all bytes are identical i.e. entropy is 0
		    if (lowEntropy == 0.0) {
			//if (lowEntropy <= lowCutOff) {
				Segment maskSegment = new Segment(lowStart, lowWindow);
				alignable.mask(maskSegment);
				if (log.isTraceEnabled())
					log.trace("alignable " + alignable.getId()
							+ " low complexity segment "
							+ alignable.toString(maskSegment)
							+ " at offset " + maskSegment.getStart()
							+ " was masked");
			}
			if (lowWindowCount >= highWindow - lowWindow + 1) {
				highProbabilities = highBytesDistribution
						.getNotZeroProbabilities();
				double highEntropy = calculateEntropy(highProbabilities);
				if (highEntropy <= highCutOff) {
					Segment maskSegment = new Segment(highStart, highWindow);
					alignable.mask(maskSegment);
					if (log.isTraceEnabled())
						log.trace("alignable " + alignable.getId()
								+ " low complexity segment "
								+ alignable.toString(maskSegment)
								+ " at offset " + maskSegment.getStart()
								+ " was masked");
				}
			}
			lowBytesDistribution.remove(alignable.getByte(lowStart));
			if (highStart >= 0) {
				highBytesDistribution.remove(alignable.getByte(highStart));
			}
		}
		if (log.isDebugEnabled()) {
			BoundedSegmentedLine mask = alignable.getMask();
			int length = 0;
			if (mask != null) {
				length = mask.length();
			}
			log.debug("alignable {} low complexity masked , mask length {}",
					alignable.getId(), length);
		}
	}


	@Override
	public void clear() {
	}
	
	@Override
	public String getName() {
		return "low complexity masker";
	}
}
