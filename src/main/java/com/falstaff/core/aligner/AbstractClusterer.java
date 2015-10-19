package com.falstaff.core.aligner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.aligner.cluster.NClusterStrategy;
import com.falstaff.core.lookup.INLookupTable;
import com.falstaff.core.lookup.LookupTableFactory;
import com.falstaff.core.lookup.filter.INKtupFilter;
import com.falstaff.core.lookup.filter.NKtupScoreFilter;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.CentroidIterator;
import com.falstaff.core.lookup.ktup.centroid.CountsCentroidFilter;
import com.falstaff.core.lookup.ktup.centroid.IKtupCentroid;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.EntropyScoreCalculator;
import com.falstaff.core.score.IScoreCalculator;

public abstract class AbstractClusterer extends NAbstractAligner<INScorableAlignable, INScorableAlignable> {

	private static final Logger log = LoggerFactory
			.getLogger(AbstractClusterer.class.getName());
	
	protected IScoreCalculator scoreCalculator;
	protected INLookupTable<IScorableKtup> lookup;
	protected INKtupFilter<IScorableKtup> fillFilter;
	protected INKtupCentroidFilter<IScorableKtup> postFillFilter;
	protected NClusterStrategy strategy;
	protected double ktupMinAlignablesFractionCutoff;
	protected int minAlignablesCutoff;
	protected int minScoreAlternativesCount;

	
	public AbstractClusterer(IScoreCalculator scoreCalculator,
			INLookupTable<IScorableKtup> lookup, NClusterStrategy strategy) {
		super();
		this.scoreCalculator = scoreCalculator;
		this.lookup = lookup;
		this.strategy = strategy;
	}
	
	public AbstractClusterer(NClusterStrategy strategy, ClustererContext context) {
		this.strategy = strategy;
		ktupMinAlignablesFractionCutoff = context.getKtupMinAlignablesFractionCutoff();
		minAlignablesCutoff = context.getMinAlignablesCutoff();
		minScoreAlternativesCount = context.getMinScoreAlternativesCount();
		LookupTableFactory<IScorableKtup> lookupTableFactory = new LookupTableFactory<IScorableKtup>();
		lookup = lookupTableFactory.getTable(context.getLookupType(), context.getAlignmentKtupLength());
		fillFilter = new NKtupScoreFilter(context.getKtupScoreCutoff());
	}
	
	protected void updateScoreCalculator(Collection<? extends INScorableAlignable> alignables) {
		ByteDistribution distribution = new ByteDistribution();
		for (INScorableAlignable alignable : alignables) {
			distribution.add(alignable.byteIterator());
		}
		scoreCalculator.setAlphabet(distribution);
		scoreCalculator.setDbSize(alignables.size());
		for (INScorableAlignable alignable : alignables) {
			alignable.setScoreCalculator(scoreCalculator);
		}		
	}
	
	protected void createScoreCalculator(Collection<? extends INScorableAlignable> alignables) {
		ByteDistribution distribution = new ByteDistribution();
		for (INScorableAlignable alignable : alignables) {
			distribution.add(alignable.byteIterator());
		}
		
		scoreCalculator = new EntropyScoreCalculator(
				distribution, alignables.size(), minScoreAlternativesCount);

		for (INScorableAlignable alignable : alignables) {
			alignable.setScoreCalculator(scoreCalculator);
		}		
	}
		
	protected void createPostFillFilter(Collection<? extends INScorableAlignable> alignables) {
		int alignablesCutoff = Math.min(minAlignablesCutoff, (int) (alignables.size() * ktupMinAlignablesFractionCutoff));
		log.info("centroids filter set to minimum of "
				+ alignablesCutoff + " alignables");
		postFillFilter = new CountsCentroidFilter<IScorableKtup>(
				alignablesCutoff, alignablesCutoff);
	}
		
	protected List<INMultipleAlignment> getAlignments() {
		List<INMultipleAlignment> alignments = new ArrayList<INMultipleAlignment>();
		// cluster centroids
		CentroidIterator<IScorableKtup> centroids = lookup.getCentroids(postFillFilter);
		int centroidsCount = lookup.getCentroidsCount();
		int processedCentroidsCount = 0;
		while (centroids.hasNext()) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			List<IScorableKtup> ktups = centroid.getKtups();
			if (ktups.size() == 0) {
				processedCentroidsCount++;
				if (processMonitor != null) {
					setPercentageCompleted(processedCentroidsCount * 100 / centroidsCount);
				}
				continue;
			}
			log.debug("cluster of centroid with ktup "  + ktups.get(0).getChars() + " and " + centroid.getAlignablesCount() + " alignables and " + centroid.getKtupsCount() + " ktups started");
			long startTime = System.currentTimeMillis();
			List<INMultipleAlignment> clusteredAlignments = strategy.cluster(ktups, postFillFilter);
			for (INMultipleAlignment alignment : clusteredAlignments) {
				alignments.add(alignment);
				// remove aligned ktups from the lookup table
				List<INKtupIterator<? extends IScorableKtup>> removeIterators = new ArrayList<INKtupIterator<? extends IScorableKtup>>();
				Set<INScorableAlignable> aligned = alignment.getAligned();
				for (INScorableAlignable alignable : aligned) {
					int start = alignment.getStart(alignable);
					int end = alignment.getEnd(alignable);
					INKtupIterator<IScorableKtup> removeIterator = alignable.ktupIterator(lookup.getKtupLength(), start, end);
					removeIterators.add(removeIterator);
				}
				lookup.remove(removeIterators, null);
				log.debug("alignment " + alignment.toString() + " was created");
			}
			processedCentroidsCount++;
			if (processMonitor != null) {
				setPercentageCompleted(processedCentroidsCount * 100 / centroidsCount);
			}
			long duration = (System.currentTimeMillis() - startTime) / 1000;
			log.debug("cluster took " + duration + " sec");

		}
		
		log.debug("\ncluster created alignments : \n");
		for (INMultipleAlignment alignment : alignments) {
			log.debug("cluster created alignment with " + alignment.getAlignedCount() + " alignables '" + alignment.toString() + "'");
		}
		
		return alignments;
	}
	
	public void setScoreCalculator(IScoreCalculator scoreCalculator) {
		this.scoreCalculator = scoreCalculator;
	}

	public void setPostFillFilter(INKtupCentroidFilter<IScorableKtup> postFillFilter) {
		this.postFillFilter = postFillFilter;
	}

	public void setFillFilter(INKtupFilter<IScorableKtup> fillFilter) {
		this.fillFilter = fillFilter;
	}

	@Override
	public void clear() {
		lookup.clear();
	}


}
