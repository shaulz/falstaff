package com.falstaff.core.aligner;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.alignable.NAlignedRows.Padding;
import com.falstaff.core.aligner.cluster.NClusterStrategy;
import com.falstaff.core.lookup.INLookupTable;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.CountsCentroidFilter;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;
import com.falstaff.core.score.IScoreCalculator;

public class MagicNumberClusterer extends AbstractClusterer {

	private static final Logger log = LoggerFactory
			.getLogger(MagicNumberClusterer.class.getName());

	// minimal number of alignables
	private int minMagicCutoff = 50;
	// minimal percentage of alignables
	private int minMagicPercentageCutoff = 20;
	// the distance from both file ends to lookup magic signatures
	private int maxMagicOffset = 32;
	// the maximum difference in magic position
	private int maxMagicPositionShift = 2;
	
	public MagicNumberClusterer(IScoreCalculator scoreCalculator,
			INLookupTable<IScorableKtup> lookup, NClusterStrategy strategy) {
		super(scoreCalculator, lookup, strategy);
	}

	public MagicNumberClusterer(NClusterStrategy strategy,
			MagicClustererContext context) {
		super(strategy, context);
		this.maxMagicOffset = context.getMagicOffset();
		this.maxMagicPositionShift = context.getMaxMagicPositionShift();
	}

	@Override
	public Collection<? extends INMultipleAlignment> transformInternal(
			Collection<? extends INScorableAlignable> alignables) {	
		log.info("magic alignment of " + alignables.size() + " alignables started");

		// set score calculator
		//updateScoreCalculator(alignables);
		createScoreCalculator(alignables);
		
		// construct filter
		//CountsCentroidFilter<IScorableKtup> filter = updateFilter(alignables.size());
		
		// set post fill filter
		createPostFillFilter(alignables);
				
		List<INMultipleAlignment> alignments = new LinkedList<INMultipleAlignment>();
		
		// magic start
		for (int offset = 0; offset < maxMagicOffset; offset++) {
			
			// fill lookup
			lookup.clear();
			for (INScorableAlignable alignable : alignables) {
				for (int i = 0; i < maxMagicPositionShift; i++) {
					fillKtup(alignable, offset + i);
				}
			}
		
			lookup.remove(postFillFilter);
		
			// cluster centroids
			List<INMultipleAlignment> startAlignments = getAlignments();
			
			for (INMultipleAlignment alignment : startAlignments) {
				log.debug("magic start alignment with " + offset + " offset " + alignment + " was created");
			}
			
			alignments.addAll(startAlignments);
		}
		
			/*
			// merge alignments
			INMultipleAlignment magicAlignmentStart = null;
			for (INMultipleAlignment alignment : alignments) {
				if (magicAlignmentStart == null) {
					magicAlignmentStart = alignment;
				}
				else {
					magicAlignmentStart.merge(0, magicAlignmentStart.length() - 1, alignment, 0, alignment.length() - 1, Padding.RIGHT);
				}
			}
			 */
		
		// magic end
		for (int offset = 0; offset < maxMagicOffset; offset++) {
			// fill lookup
			lookup.clear();
			for (INScorableAlignable alignable : alignables) {
				for (int i = 0; i < maxMagicPositionShift; i++) {
					fillKtup(alignable, alignable.length() - lookup.getKtupLength() - i);
				}
			}
		
			// construct filter
			/*
			// remove start filter
			if (postFillFilter == startFilter) {
				postFillFilter = null;
			}
			else {
				INKtupCentroidFilter<IScorableKtup> filter = postFillFilter;
				while (filter.getNextFilter() != startFilter) {
					filter = filter.getNextFilter();
				}
				filter.setNextFilter(null);
			}
			updateFilter(alignables.size());
			*/
			lookup.remove(postFillFilter);
		
			// cluster centroids
			List<INMultipleAlignment> endAlignments = getAlignments();
		
			// merge alignments
			/*
			INMultipleAlignment magicAlignmentEnd = null;
			for (INMultipleAlignment alignment : alignments) {
				if (magicAlignmentEnd == null) {
					magicAlignmentEnd = alignment;
				}
				else {
					magicAlignmentEnd.merge(0, magicAlignmentEnd.length() - 1, alignment, 0, alignment.length() - 1, Padding.LEFT);
				}
			}
			 */
			
			for (INMultipleAlignment alignment : endAlignments) {
				log.debug("magic end alignment with " + offset + " offset " + alignment + " was created");
			}
		
			alignments.addAll(endAlignments);
		}

		return alignments;
	}
	
	private void fillKtup(INScorableAlignable alignable, int offset) {
		IScorableKtup ktup = alignable.getKtup(offset, lookup.getKtupLength());
		if (fillFilter != null && fillFilter.filter(ktup)) {
			return;
		}
		lookup.add(ktup);		
	}
	
	/*
	private CountsCentroidFilter<IScorableKtup> updateFilter(int alignablesCount) {
		
		int alignablesCountCutoff = alignablesCount * minMagicPercentageCutoff / 100;
		alignablesCountCutoff = Math.min(alignablesCountCutoff, minMagicCutoff);
	
		CountsCentroidFilter<IScorableKtup> filter = new CountsCentroidFilter<IScorableKtup>(alignablesCountCutoff, alignablesCountCutoff);
		if (postFillFilter == null) {
			postFillFilter = filter;
		}
		else {
			postFillFilter.setNextFilter(filter);
		}	
		
		return filter;
	}
	*/
	
	public int getMinMagicPercentageCutoff() {
		return minMagicPercentageCutoff;
	}

	public void setMinMagicPercentageCutoff(int minMagicPercentageCutoff) {
		this.minMagicPercentageCutoff = minMagicPercentageCutoff;
	}

	public int getMinMagicCutoff() {
		return minMagicCutoff;
	}

	public void setMinMagicCutoff(int minMagicCutoff) {
		this.minMagicCutoff = minMagicCutoff;
	}

	public int getMaxMagicOffset() {
		return maxMagicOffset;
	}

	public void setMaxMagicOffset(int maxMagicOffset) {
		this.maxMagicOffset = maxMagicOffset;
	}

	public int getMaxMagicPositionShift() {
		return maxMagicPositionShift;
	}

	public void setMaxMagicPositionShift(int maxMagicPositionShift) {
		this.maxMagicPositionShift = maxMagicPositionShift;
	}

	@Override
	public String getName() {
		return "magic number clusterer";
	}

}
