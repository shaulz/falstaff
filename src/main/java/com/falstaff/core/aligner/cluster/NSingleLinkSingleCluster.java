package com.falstaff.core.aligner.cluster;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.extender.AlignmentExtender;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.IKtupCentroid;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;

@Component("singleLinkSingleCluster")
@Qualifier("singleLinkSingleCluster")
@Scope("prototype")
public class NSingleLinkSingleCluster extends NAbstractCluster implements IKtupCentroid<IScorableKtup> {
	
	private static final Logger log = LoggerFactory
			.getLogger(NSingleLinkSingleCluster.class.getName());
	
	private int bestMatchScore;
	private int bestMatchAlignableIndex;
	private int bestMatchAlignableKtupIndex;
	private INMultipleAlignment alignment;
	private IScorableKtup alignmentKtup;

	public NSingleLinkSingleCluster() {
	}
	
	@Override
	public void init(int alignablesCount,
			IScorableKtup[][] ktups, int[] ktupsCount,
			Map<Integer, Integer> alignableIdToAlignableIndex,
			int[][] alignableScoreTableIndexes, int[] scoreTableIndexAlignable,
			int[] scoreTableIndexAlignableIndex, int filledKtupsCount,
			int[][] scores, INKtupCentroidFilter<IScorableKtup> filter) {
		super.init(alignablesCount, ktups, ktupsCount, alignableIdToAlignableIndex,
				alignableScoreTableIndexes, scoreTableIndexAlignable,
				scoreTableIndexAlignableIndex, filledKtupsCount, scores, filter);
		log.info("single link cluster initialized with " + alignablesCount + " alignables and " + getKtupsCount() + " ktups");
	}


	public List<INMultipleAlignment> cluster(List<IScorableKtup> orderedKtups, INKtupCentroidFilter<IScorableKtup> filter) {
		initKtups(orderedKtups, filter);
		
		initScores();
		
		List<INMultipleAlignment> alignments = new ArrayList<INMultipleAlignment>();
		INMultipleAlignment alignment = clusterOne();
		while (alignment != null) {
			alignments.add(alignment);
			alignment = clusterOne();
		}
		return alignments;
	}
	
	public INMultipleAlignment clusterOne() {
		// check filter
		if (filter != null && filter.filter(this)) {
			log.info("cluster was filtered out");
			return null;
		}
		
		// initialize state
		bestMatchScore = AlignmentExtender.MIN_SCORE;
		int alignedAlignableIndex = -1;
		int alignedAlignableKtupIndex = -1;
		alignment = null;
		alignmentKtup = null;
				
		// find pair of ktups with best score
        // if no pair with positive scores sum exists null will be returned
        int maxScoresSum = 0;
        int maxScoreTableIndex = -1;
        for (int i = 0; i < filledKtupsCount; i++) {
        	int rawScoreTableIndexAlignable = scoreTableIndexAlignable[i];
        	int rawScoreTableIndexAlignableIndex = scoreTableIndexAlignableIndex[i];
        	if (ktups[rawScoreTableIndexAlignable][rawScoreTableIndexAlignableIndex] == null) {
        		continue;
        	}
        	int scoresSum = 0;
        	for (int j = 0; j < filledKtupsCount; j++) {
            	int columnScoreTableIndexAlignable = scoreTableIndexAlignable[j];
            	int columnScoreTableIndexAlignableIndex = scoreTableIndexAlignableIndex[j];
            	if (ktups[columnScoreTableIndexAlignable][columnScoreTableIndexAlignableIndex] == null) {
            		continue;
            	}        		
        		scoresSum += Math.max(0, scores[i][j]);
        	}
        	if (scoresSum > maxScoresSum) {
        		maxScoresSum = scoresSum;
        		alignedAlignableIndex = scoreTableIndexAlignable[i];
        		alignedAlignableKtupIndex = scoreTableIndexAlignableIndex[i];
        		maxScoreTableIndex = i;
        	}
        }
        
        if (maxScoresSum == 0) {
        	log.info("clustering ceased, maxScoreSum is 0");
        	return null;
        }
        
        for (int i = 0; i < filledKtupsCount; i++) {
           	int rawScoreTableIndexAlignable = scoreTableIndexAlignable[i];
        	int rawScoreTableIndexAlignableIndex = scoreTableIndexAlignableIndex[i];
        	if (ktups[rawScoreTableIndexAlignable][rawScoreTableIndexAlignableIndex] == null) {
        		continue;
        	}
        	if (scores[maxScoreTableIndex][i] > bestMatchScore) {
        		bestMatchScore = scores[maxScoreTableIndex][i];
        		bestMatchAlignableIndex = rawScoreTableIndexAlignable;
        		bestMatchAlignableKtupIndex = rawScoreTableIndexAlignableIndex;
        	}
        }
        				
		// align best pair
		alignLink(alignedAlignableIndex, alignedAlignableKtupIndex);

		boolean found = true;
		while (found) {
			// find ktup which scores best with the alignment
			// the loop will end only after all alignables will be aligned
			// even if extension score dropes to zero
			found = false;
			bestMatchScore = AlignmentExtender.MIN_SCORE;
			bestMatchAlignableIndex = -1;
			bestMatchAlignableKtupIndex = -1;

			if (findLink(alignmentKtup)) {
				found = true;
			}
			
			// align alignment and best ktup
			if (found) {
				alignLink(alignmentKtup);
			}
			
			log.debug("current alignment " + alignment + " score " + alignment.getScore());
		}
			
		return alignment;
	}
	
	private boolean findLink(IScorableKtup alignedKtup) {
		boolean found = false;
		for (int alignableIndex = 0; alignableIndex < ktups.length; alignableIndex++) {
			for (int alignableKtupIndex = 0; alignableKtupIndex < ktups[alignableIndex].length; alignableKtupIndex++) {
				int score = score(alignedKtup, alignableIndex, alignableKtupIndex);
				if (score > bestMatchScore) {
					bestMatchScore = score;
					found = true;
					bestMatchAlignableIndex = alignableIndex;
					bestMatchAlignableKtupIndex = alignableKtupIndex;
				}
			}
		}
		return found;
	}
	
	private int score(IScorableKtup alignedKtup, int alignableIndex, int alignableKtupIndex) {
		if (ktups[alignableIndex][alignableKtupIndex] == null) {
			return AlignmentExtender.MIN_SCORE;
		}			
		if (alignment != null && alignment.isAligned(ktups[alignableIndex][alignableKtupIndex].getAlignable())) {
			return AlignmentExtender.MIN_SCORE;
		}
		IScorableKtup checkMatchKtup = ktups[alignableIndex][alignableKtupIndex];
		int score = score(alignedKtup, checkMatchKtup);
		return score;
	}
	
	private void cancelScores(int fillIndex) {
		for (int i = 0; i < filledKtupsCount; i++) {
			scores[fillIndex][i] = AlignmentExtender.MIN_SCORE;
			scores[i][fillIndex] = AlignmentExtender.MIN_SCORE;
		}
	}
	
	private void alignLink(int alignedAlignableIndex, int alignedAlignableKtupIndex) {
		IScorableKtup alignedKtup = ktups[alignedAlignableIndex][alignedAlignableKtupIndex];
		ktups[alignedAlignableIndex][alignedAlignableKtupIndex] = null;
		int fillIndex = alignableScoreTableIndexes[alignedAlignableIndex][alignedAlignableKtupIndex];
		cancelScores(fillIndex);
		ktupsCount[alignedAlignableIndex]--;
		if (ktupsCount[alignedAlignableIndex] == 0) {
			alignablesCount--;
		}
		alignLink(alignedKtup);
	}
	
	private void alignLink(IScorableKtup alignedKtup) {
		IScorableKtup bestMatchKtup = ktups[bestMatchAlignableIndex][bestMatchAlignableKtupIndex];
		ktups[bestMatchAlignableIndex][bestMatchAlignableKtupIndex] = null;
		int fillIndex = alignableScoreTableIndexes[bestMatchAlignableIndex][bestMatchAlignableKtupIndex];
		cancelScores(fillIndex);
		ktupsCount[bestMatchAlignableIndex]--;
		if (ktupsCount[bestMatchAlignableIndex] == 0) {
			alignablesCount--;
		}
		
		alignmentKtup = align(alignedKtup, bestMatchKtup);
		alignment = (INMultipleAlignment)alignmentKtup.getAlignable();
	}
					
	@Override
	public List<IScorableKtup> getKtups() {
		List<IScorableKtup> ktupsList = new ArrayList<IScorableKtup>();
		for (int i = 0; i < ktups.length; i++) {
			for (int j = 0; j < ktups[i].length; j++) {
				if (ktups[i][j] != null) {
					ktupsList.add(ktups[i][j]);
				}
			}
		}
		return ktupsList;
	}

	@Override
	public int getKtupsCount() {
		int count = 0;
		for (int i = 0; i < ktupsCount.length; i++) {
			count += ktupsCount[i];
		}
		return count;
	}

	@Override
	public int getAlignablesCount() {
		return alignablesCount;
	}	

}
