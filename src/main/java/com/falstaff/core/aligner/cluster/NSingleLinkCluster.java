package com.falstaff.core.aligner.cluster;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.alignable.extender.AlignmentExtender;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;
import com.falstaff.core.lookup.ktup.centroid.KtupCentroid;

@Component("singleLinkCluster")
@Qualifier("singleLinkCluster")
@Scope("prototype")
public class NSingleLinkCluster extends NAbstractCluster {
	
	private static final Logger log = LoggerFactory
			.getLogger(NSingleLinkCluster.class.getName());
	
	private int[] maxScoreIndex;
	
	public NSingleLinkCluster() {
	}
		
	protected void initScores() {
		// fill distance table
		super.initScores();
		maxScoreIndex = new int[filledKtupsCount];
		
		for (int i = 0; i < filledKtupsCount; i++) {
			maxScoreIndex[i] = -1;
			IScorableKtup ktupI = getKtup(i);
			for (int j = 0; j < filledKtupsCount; j++) {
				if (j > i) {
					break;
				}
				if (j == i) {
					continue;
				}
				
				if (scoreTableIndexAlignable[i] == scoreTableIndexAlignable[j]) {
					continue;
				}
				
				int score = scores[i][j];
				if (maxScoreIndex[i] == -1) {
					maxScoreIndex[i] = j;
				}
				else {
					if (scores[i][maxScoreIndex[i]] < score) {
						maxScoreIndex[i] = j;
					}
				}
				if (maxScoreIndex[j] == -1) {
					maxScoreIndex[j] = i;
				}
				else {
					if (scores[j][maxScoreIndex[j]] < score) {
						maxScoreIndex[j] = i;
					}
				}
			}
		}
	}
		
	public List<INMultipleAlignment> cluster(List<IScorableKtup> orderedKtups, INKtupCentroidFilter<IScorableKtup> filter) {
		initKtups(orderedKtups, filter);
		
		initScores();
				
		IScorableKtup[] alignmentKtups = new  IScorableKtup[filledKtupsCount];
		List<IScorableKtup>[] centroidKtups = new List[filledKtupsCount];
		for (int i = 0; i < filledKtupsCount; i++) {
			alignmentKtups[i] = getKtup(i);
			centroidKtups[i] = new ArrayList<IScorableKtup>();
			centroidKtups[i].add(alignmentKtups[i]);
		}
		
		while (true) {
			int maxScore = AlignmentExtender.MIN_SCORE;
			
			int i1 = -1;
			for (int i = 0; i < filledKtupsCount; i++) {
				if (maxScoreIndex[i] == -1) {
					continue;
				}
				if (scores[i][maxScoreIndex[i]] > maxScore) {
					i1 = i;
					maxScore = scores[i][maxScoreIndex[i]];
				}
			}
			if (maxScore == AlignmentExtender.MIN_SCORE) {
				break;
			}
			
			int i2 = maxScoreIndex[i1];
			/*
			StringBuffer s = new StringBuffer();
			for (int i = 0; i < filledKtupsCount; i++) {
				for (int j = 0; j < filledKtupsCount; j++) {
					s.append(" ").append(scores[i][j]).append(" ");
				}
				s.append("\n");
			}
			
			log.info(" score table: \n" + s.toString());
			*/
			removeAlignedLinks(alignmentKtups, i1, i2, true);
			
			removeAlignedLinks(alignmentKtups, i2, i1, false);
			
			mergeRows(i1, i2);
			
			IScorableKtup alignmentKtup = align(alignmentKtups[i1], alignmentKtups[i2]);
			
			log.info("alignment of entries " + i1 + "," + i2 + " , alignables number " + centroidKtups[i1].size() + "," + centroidKtups[i2].size() + " using score " + maxScore + " " + alignmentKtup.getAlignable() + " was created");
			
			alignmentKtups[i2] = null;
			
			alignmentKtups[i1] = alignmentKtup;	
			
			centroidKtups[i1].addAll(centroidKtups[i2]);
			centroidKtups[i2] = null;
		}
		
		List<INMultipleAlignment> alignments = new ArrayList<INMultipleAlignment>();
		
		for (int i = 0; i < alignmentKtups.length; i++) {
			IScorableKtup ktup = alignmentKtups[i];
			if (ktup == null) {
				continue;
			}
			if (centroidKtups[i].size() > 1) {
				if (filter != null) {
					KtupCentroid<IScorableKtup> centroid = new KtupCentroid<IScorableKtup>(centroidKtups[i]);
					if (filter.filter(centroid)) {
						continue;
					}
				}
				alignments.add((INMultipleAlignment)ktup.getAlignable());
			}
		}
		
		return alignments;
	}
	
	// overwrite row i1 with maximum of i1 and i2
	// set row and column i2 to AlignmentExtender.MIN_SCORE
	// update maxScoreIndex and set those previously pointing to i2 to point to i1
	private void mergeRows(int i1, int i2) {
		scores[i1][maxScoreIndex[i1]] = AlignmentExtender.MIN_SCORE;
		for (int i = 0; i < filledKtupsCount; i++) {
			int score;
			if (i == i1) {
				score = AlignmentExtender.MIN_SCORE;
			}
			else {
				score = Math.max(scores[i1][i], scores[i2][i]);
			}
			scores[i1][i] = score;
			scores[i][i1] = scores[i1][i];
			
			scores[i2][i] = AlignmentExtender.MIN_SCORE;
			scores[i][i2] = AlignmentExtender.MIN_SCORE;
			
			if (maxScoreIndex[i] == i2) {
				maxScoreIndex[i] = i1;
			}
			
			if (scores[i1][maxScoreIndex[i1]] < scores[i1][i]) {
				maxScoreIndex[i1] = i;
			}
		}
	}

	// for each alignable a2 in i2 ( alignable ids -> alignables indexes )
	// for each score table index ia2 of a2
	// make entry i1,ia2 and ia2,i1 AlignmentExtender.MIN_SCORE
	// if maxScoreIndex[ia2] points to i1, find maximum score entry for ia2 and update maxScoreIndex[ia2]
	private void removeAlignedLinks(IScorableKtup[] alignmentKtups, int i1, int i2, boolean updateAlignableScoreTableIndexes) {
		Set<INScorableAlignable> alignables = alignmentKtups[i2].getAlignable().getAligned();
		for (INScorableAlignable alignable : alignables) {
			int alignablesIndex = alignableIdToAlignableIndex.get(alignable.getId());
			for (int i = 0; i < alignableScoreTableIndexes[alignablesIndex].length; i++) {
				int ia2 = alignableScoreTableIndexes[alignablesIndex][i];
				if (ia2 == i2) {
					if (updateAlignableScoreTableIndexes) {
						alignableScoreTableIndexes[alignablesIndex][i] = i1;
					}
					continue;
				}
				scores[i1][ia2] = AlignmentExtender.MIN_SCORE;
				scores[ia2][i1] = AlignmentExtender.MIN_SCORE;
				if (maxScoreIndex[ia2] == i1) {
					maxScoreIndex[ia2] = findMaxScoreIndex(ia2, alignmentKtups);
				}
			}
		}
	}
	
	private int findMaxScoreIndex(int index, IScorableKtup[] alignmentKtups) {
		int maxScore = AlignmentExtender.MIN_SCORE;
		int indexMaxScore = -1;
		int scoreAlignedCount = 0;
		for (int i = 0; i < filledKtupsCount; i++) {
			if (scores[index][i] > maxScore || (scores[index][i] == maxScore && scores[index][i] > AlignmentExtender.MIN_SCORE && alignmentKtups[i] != null && alignmentKtups[i].getAlignable().getAlignedCount() > scoreAlignedCount)) {
				maxScore = scores[index][i];
				indexMaxScore = i;
				scoreAlignedCount = (alignmentKtups[i] != null ? alignmentKtups[i].getAlignable().getAlignedCount() : 0);
			}
		}
		return indexMaxScore;
	}

}
