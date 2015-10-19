package com.falstaff.core.aligner.cluster;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.beans.factory.annotation.Value;

import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.alignable.extender.AlignmentExtender;
import com.falstaff.core.alignable.extender.AlignmentExtenderContext;
import com.falstaff.core.alignable.extender.IAlignmentExtender;
import com.falstaff.core.alignable.extender.AlignmentExtender.Cell;
import com.falstaff.core.alignable.sequence.NMultipleAlignment;
import com.falstaff.core.aligner.INCluster;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;

public abstract class NAbstractCluster implements INCluster {
	
	private static final Logger log = LoggerFactory
			.getLogger(NAbstractCluster.class.getName());

	@Value("${falstaff.core.aligner.cluster.max_alignable_ktups}")
	protected int maxAlignableKtups;
	@Value("${falstaff.core.aligner.cluster.max_align_extension_length}")
	protected int maxAlignExtensionLength;
	@Value("${falstaff.core.aligner.cluster.max_score_extension_length}")
	protected int maxScoreExtensionLength;
	
	protected int alignablesCount;
	protected IScorableKtup[][] ktups;
	protected int[] ktupsCount;
	protected Map<Integer,Integer> alignableIdToAlignableIndex;
	
	protected int[][] alignableScoreTableIndexes;
	protected int[] scoreTableIndexAlignable;
	protected int[] scoreTableIndexAlignableIndex;
	protected int filledKtupsCount;
	
	protected int[][] scores;

	protected INKtupCentroidFilter<IScorableKtup> filter;
	
	protected IAlignmentExtender alignmentExtender;
	
	@Resource(name="alignmentExtender")
	public void setAlignmentExtender(IAlignmentExtender alignmentExtender) {
		this.alignmentExtender = alignmentExtender;
	}

	public NAbstractCluster() {
	}

	public void init(int alignablesCount, IScorableKtup[][] ktups,
			int[] ktupsCount,
			Map<Integer, Integer> alignableIdToAlignableIndex,
			int[][] alignableScoreTableIndexes, int[] scoreTableIndexAlignable,
			int[] scoreTableIndexAlignableIndex, int filledKtupsCount,
			int[][] scores, INKtupCentroidFilter<IScorableKtup> filter) {
		this.alignablesCount = alignablesCount;
		this.ktups = ktups;
		this.ktupsCount = ktupsCount;
		this.alignableIdToAlignableIndex = alignableIdToAlignableIndex;
		this.alignableScoreTableIndexes = alignableScoreTableIndexes;
		this.scoreTableIndexAlignable = scoreTableIndexAlignable;
		this.scoreTableIndexAlignableIndex = scoreTableIndexAlignableIndex;
		this.filledKtupsCount = filledKtupsCount;
		this.scores = scores;
		this.filter = filter;
	}

	@Override
	public List<INMultipleAlignment> cluster(List<IScorableKtup> orderedKtups) {
		return cluster(orderedKtups, null);
	}

	protected void initKtups(List<IScorableKtup> orderedKtups, INKtupCentroidFilter<IScorableKtup> filter) {
		log.info("starting cluster initialization with " + orderedKtups.size() + " ktups ");
		this.filter = filter;
		alignablesCount = 0;
		
		if (orderedKtups == null || orderedKtups.size() == 0) {
			return;
		}
		
		// allocate ktups array
		INScorableAlignable alignable = orderedKtups.get(0).getAlignable();
		alignablesCount++;
		for (IScorableKtup ktup : orderedKtups) {
			INScorableAlignable nextAlignable = ktup.getAlignable();
			if (!alignable.equals(nextAlignable)) {
				alignable = nextAlignable;
				alignablesCount++;
			}
		}
		ktups = new IScorableKtup[alignablesCount][];
		ktupsCount = new int[alignablesCount];
		alignableIdToAlignableIndex = new HashMap<Integer,Integer>();

		int tailAlignableFillIndex[] = new int[alignablesCount];
		int tailFillIndex[] = new int[alignablesCount];
	
		alignable = orderedKtups.get(0).getAlignable();
		int alignableIndex = 0;
		int alignableKtupsCount = 0;
		int alignableHeadKtupsCount = 0;
		alignableIdToAlignableIndex.put(alignable.getId(),alignableIndex);
		
		for (IScorableKtup ktup : orderedKtups) {
			INScorableAlignable nextAlignable = ktup.getAlignable();
			if (alignable.equals(nextAlignable)) {
				alignableKtupsCount++;
				if (ktup.isHead()) {
					alignableHeadKtupsCount++;
				}
			}
			else {				
				int filledAlignableKtupsCount = Math.min(alignableKtupsCount, maxAlignableKtups);
				ktups[alignableIndex] = new IScorableKtup[filledAlignableKtupsCount];
				ktupsCount[alignableIndex] = filledAlignableKtupsCount;
				tailAlignableFillIndex[alignableIndex] = getTailAlignableFillIndex(alignableHeadKtupsCount, alignableKtupsCount - alignableHeadKtupsCount);
				tailFillIndex[alignableIndex] = getTailFillIndex(alignableHeadKtupsCount, alignableKtupsCount - alignableHeadKtupsCount);
				alignable = nextAlignable;
				alignableKtupsCount = 1;
				alignableHeadKtupsCount = 0;
				if (ktup.isHead()) {
					alignableHeadKtupsCount++;
				}
				alignableIndex++;
				alignableIdToAlignableIndex.put(alignable.getId(),alignableIndex);

			}
		}
		int filledAlignableKtupsCount = Math.min(alignableKtupsCount, maxAlignableKtups);
		ktups[alignableIndex] = new IScorableKtup[filledAlignableKtupsCount];
		ktupsCount[alignableIndex] = filledAlignableKtupsCount;
		tailAlignableFillIndex[alignableIndex] = getTailAlignableFillIndex(alignableHeadKtupsCount, alignableKtupsCount - alignableHeadKtupsCount);
		tailFillIndex[alignableIndex] = getTailFillIndex(alignableHeadKtupsCount, alignableKtupsCount - alignableHeadKtupsCount);

		
		// fill the ktups array
		alignable = orderedKtups.get(0).getAlignable();
		alignableIndex = 0;
		int alignableKtupIndex = 0;
		int fillIndex = 0;
		for (IScorableKtup ktup : orderedKtups) {
			INScorableAlignable nextAlignable = ktup.getAlignable();
			if (!alignable.equals(nextAlignable)) {
				alignableIndex++;
				alignable = nextAlignable;
				alignableKtupIndex = 0;
				fillIndex = 0;
			}
			
			if (ktup.isTail() && alignableKtupIndex == tailAlignableFillIndex[alignableIndex]) {
				fillIndex = tailFillIndex[alignableIndex];
			}
			if (fillIndex < ktupsCount[alignableIndex]) {
				ktups[alignableIndex][fillIndex] = ktup;
				fillIndex++;
			}
			alignableKtupIndex++;
		}
		
		
		filledKtupsCount = 0;
		for (int i = 0; i < alignablesCount; i++) {
			filledKtupsCount += ktupsCount[i];
		}
		alignableScoreTableIndexes = new int[alignablesCount][];
		scoreTableIndexAlignable = new int[filledKtupsCount];
		scoreTableIndexAlignableIndex = new int[filledKtupsCount];

		fillIndex = 0;
		for (int i = 0; i < alignablesCount; i++) {
			alignableScoreTableIndexes[i] = new int[ktupsCount[i]];
			for (int j = 0; j < ktupsCount[i]; j++) {
				alignableScoreTableIndexes[i][j] = fillIndex;
				scoreTableIndexAlignable[fillIndex] = i;
				scoreTableIndexAlignableIndex[fillIndex] = j;
				fillIndex++;
			}
		}

		log.info("cluster initialized with " + alignablesCount + " alignables ");
	}
	
	protected IScorableKtup getKtup(int index) {
		int alignableIndex = scoreTableIndexAlignable[index];
		int alignableKtupIndex = scoreTableIndexAlignableIndex[index];
		return ktups[alignableIndex][alignableKtupIndex];		
	}

	
	protected void initScores() {
		scores = new int[filledKtupsCount][filledKtupsCount];
		
		for (int i = 0; i < filledKtupsCount; i++) {
			IScorableKtup ktupI = getKtup(i);
			for (int j = 0; j < filledKtupsCount; j++) {
				if (j > i) {
					break;
				}
				if (j == i) {
					scores[i][j] = AlignmentExtender.MIN_SCORE;
					continue;
				}
				
				if (scoreTableIndexAlignable[i] == scoreTableIndexAlignable[j]) {
					scores[i][j] = AlignmentExtender.MIN_SCORE;
					scores[j][i] = AlignmentExtender.MIN_SCORE;
					continue;
				}
				
				IScorableKtup ktupJ = getKtup(j);
				int scoreLeft = score(ktupI, ktupJ, AlignmentExtender.Direction.DIRECTION_LEFT);
				int scoreRight = score(ktupI, ktupJ, AlignmentExtender.Direction.DIRECTION_RIGHT);
				int score = Math.max(scoreLeft, 0) + Math.max(scoreRight, 0);
				scores[i][j] = score;
				scores[j][i] = score;
			}
		}		
	}
	
	protected int getTailAlignableFillIndex(int headCount, int tailCount) {
		if (headCount + tailCount <= maxAlignableKtups) {
			return headCount;
		}
		
		if (headCount > maxAlignableKtups / 2 && tailCount <= maxAlignableKtups / 2) {
			return headCount;
		}
		
		if (headCount <= maxAlignableKtups / 2 && tailCount > maxAlignableKtups / 2) {
			return headCount + tailCount - (maxAlignableKtups - headCount);
		}
		
		return headCount + tailCount - maxAlignableKtups / 2;
	}
	
	protected int getTailFillIndex(int headCount, int tailCount) {
		if (headCount + tailCount <= maxAlignableKtups) {
			return headCount;
		}
		
		if (headCount > maxAlignableKtups / 2 && tailCount <= maxAlignableKtups / 2) {
			return maxAlignableKtups - tailCount;
		}
		
		if (headCount <= maxAlignableKtups / 2 && tailCount > maxAlignableKtups / 2) {
			return headCount;
		}
		
		return maxAlignableKtups / 2;
	}
	
	protected void addCell(Cell cell, AlignmentExtenderContext context, INMultipleAlignment alignment) {
		int alignableXStart = cell.getAlignableXIndexStart(context);
		int alignableXEnd = cell.getAlignableXIndexEnd(context);
		int alignableYStart = cell.getAlignableYIndexStart(context);
		int alignableYEnd = cell.getAlignableYIndexEnd(context);
		INScorableAlignable alignableX = context.getAlignableX();
		INScorableAlignable alignableY = context.getAlignableY();
		Byte columnValue = null;
		if (alignableXEnd > alignableXStart && alignableYEnd > alignableYStart &&
				alignableX.getByte(alignableXStart) != null && alignableX.getByte(alignableXStart).equals(alignableY.getByte(alignableYStart))) {
			columnValue = alignableX.getByte(alignableXStart);
		}
		int columnScore;
		if (cell.getPreviousCell() == null) {
			columnScore = cell.getScore();
		}
		else {
			columnScore = cell.getScore() - cell.getPreviousCell().getScore();
		}
		alignment.addColumn(columnValue, columnScore, alignableX, alignableXStart, alignableXEnd, alignableY, alignableYStart, alignableYEnd);
	}

	protected Cell extend(IScorableKtup ktupX, IScorableKtup ktupY, AlignmentExtender.Direction direction) {
		AlignmentExtenderContext context = getContext(ktupX, ktupY, direction, maxAlignExtensionLength);
		Cell cell = alignmentExtender.extend(context);
		return cell;
	}
	
	protected AlignmentExtenderContext getContext(IScorableKtup ktupX, IScorableKtup ktupY, AlignmentExtender.Direction direction, int maxExtensionLength) {
		// set the drop score to be the aligned ktups score
		int dropScore = -ktupX.matchScore(ktupY);
		int alignableXAlignedTo;
		int alignableYAlignedTo;
		if (direction.equals( AlignmentExtender.Direction.DIRECTION_LEFT)) {
			alignableXAlignedTo = ktupX.getOffset();
			alignableYAlignedTo = ktupY.getOffset();
		}
		else {
			alignableXAlignedTo = ktupX.getOffset() + ktupX.getLength() - 1;
			alignableYAlignedTo = ktupY.getOffset() + ktupY.getLength() - 1;
		}
		AlignmentExtenderContext context = new AlignmentExtenderContext(ktupX.getAlignable(), alignableXAlignedTo, ktupY.getAlignable(), alignableYAlignedTo, direction, dropScore, maxExtensionLength);
		return context;
	}

	protected int score(IScorableKtup ktupX, IScorableKtup ktupY, AlignmentExtender.Direction direction) {
		AlignmentExtenderContext context = getContext(ktupX, ktupY, direction, maxScoreExtensionLength);
		int score = alignmentExtender.score(context);
		return score;
	}
	
	protected int score(IScorableKtup ktupI, IScorableKtup ktupJ) {
		int scoreLeft = score(ktupI, ktupJ, AlignmentExtender.Direction.DIRECTION_LEFT);
		int scoreRight = score(ktupI, ktupJ, AlignmentExtender.Direction.DIRECTION_RIGHT);
		int score = Math.max(scoreLeft, 0) + Math.max(scoreRight, 0);
		return score;
	}

	protected void addKtup(INMultipleAlignment alignment, IScorableKtup ktupX, IScorableKtup ktupY) {
		INScorableAlignable alignableX = ktupX.getAlignable();
		INScorableAlignable alignableY = ktupY.getAlignable();
		for (int i = 0; i < ktupX.getLength(); i++) {
			Byte columnValue = ktupX.getByte(i);
			int columnScore = ktupX.matchScore(ktupY, i);
			int alignableXStart = ktupX.getOffset() + i;
			int alignableXEnd = alignableXStart + 1;
			int alignableYStart = ktupY.getOffset() + i;
			int alignableYEnd = alignableYStart + 1;
			alignment.addColumn(columnValue, columnScore, alignableX, alignableXStart, alignableXEnd, alignableY, alignableYStart, alignableYEnd);
		}
	}
	
	protected IScorableKtup align(IScorableKtup alignedKtup1, IScorableKtup alignedKtup2) {
		Cell cellLeft = extend(alignedKtup1, alignedKtup2, AlignmentExtender.Direction.DIRECTION_LEFT);
		AlignmentExtenderContext contextLeft = getContext(alignedKtup1, alignedKtup2, AlignmentExtender.Direction.DIRECTION_LEFT, maxAlignExtensionLength);
		Cell cellRight = extend(alignedKtup1, alignedKtup2, AlignmentExtender.Direction.DIRECTION_RIGHT);
		AlignmentExtenderContext contextRight = getContext(alignedKtup1, alignedKtup2, AlignmentExtender.Direction.DIRECTION_RIGHT, maxAlignExtensionLength);
		
		INMultipleAlignment alignment = new NMultipleAlignment();
		alignment.setScoreCalculator(alignedKtup1.getAlignable().getScoreCalculator());
		
		// add left extension
		while (cellLeft != null) {
			// do not add the alignedTo cell
			if (cellLeft.getPreviousCell() != null) {
				addCell(cellLeft, contextLeft, alignment);
			}
			cellLeft = cellLeft.getPreviousCell();
		}
		
		// add ktup
		addKtup(alignment, alignedKtup1, alignedKtup2);
		int ktupOffset = alignment.length() - alignedKtup1.getLength();
		int ktupLength = alignedKtup1.getLength();
		IScorableKtup alignmentKtup = alignment.getKtup(ktupOffset, ktupLength);
		
		// add right extension
		Stack<Cell> cellStack = new Stack<Cell>();
		// do not add the alignedTo cell
		while (cellRight != null && cellRight.getPreviousCell() != null) {
			cellStack.push(cellRight);
			cellRight = cellRight.getPreviousCell();
		}
		while (!cellStack.isEmpty()) {
			cellRight = cellStack.pop();
			addCell(cellRight, contextRight, alignment);
		}
		
		return alignmentKtup;
	}

}
