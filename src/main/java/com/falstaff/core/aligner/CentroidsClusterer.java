package com.falstaff.core.aligner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.aligner.cluster.NClusterStrategy;
import com.falstaff.core.lookup.INLookupTable;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.score.IScoreCalculator;

public class CentroidsClusterer extends AbstractClusterer {

	private static final Logger log = LoggerFactory
			.getLogger(CentroidsClusterer.class.getName());
	
	public CentroidsClusterer(IScoreCalculator scoreCalculator,
			INLookupTable<IScorableKtup> lookup, NClusterStrategy strategy) {
		super(scoreCalculator, lookup, strategy);
	}
	
	public CentroidsClusterer(NClusterStrategy strategy,
			ClustererContext context) {
		super(strategy, context);
	}

	@Override
	public Collection<? extends INMultipleAlignment> transformInternal(
			Collection<? extends INScorableAlignable> alignables) {
		log.info("alignment of " + alignables.size() + " alignables started");
		// set score calculator
		//updateScoreCalculator(alignables);
		createScoreCalculator(alignables);
		
		//set post fill filter
		createPostFillFilter(alignables);
		
		// fill lookup
		lookup.clear();
		List<INKtupIterator<? extends IScorableKtup>> iterators = new ArrayList<INKtupIterator<? extends IScorableKtup>>();
		for (INScorableAlignable alignable : alignables) {
			iterators.add(alignable.ktupIterator(lookup.getKtupLength(), fillFilter));
		}
		lookup.add(iterators, postFillFilter);
		
		// cluster centroids
		List<INMultipleAlignment> alignments = getAlignments();
		
		log.info("alignment of " + alignables.size() + " alignables started, " + alignments.size() + " alignments created");
		return alignments;
	}

	@Override
	public String getName() {
		return "centroids clusterer";
	}

}
