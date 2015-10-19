package com.falstaff.core.alignable.extender;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;

public class AlignmentExtender implements IAlignmentExtender {
	
	public static final int MIN_SCORE = Integer.MIN_VALUE;
	
	public static enum Direction {
		DIRECTION_LEFT (-1),
		DIRECTION_RIGHT (1);
		
		private final int value;

		private Direction(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
		
		public static Direction fromInt(int value) {
			switch(value) {
			case -1:
				return DIRECTION_LEFT;
			case 1:
				return DIRECTION_RIGHT;
			default:
				return null;
			}
		}
	}

	public class Cell {

		private int x;
		private int y;
		private int score;
		private Cell previousCell;
		
		public Cell(int x, int y) {
			this.x = x;
			this.y = y;
			score = MIN_SCORE;
			previousCell = null;
		}
		
		public Cell(Cell cell) {
			this.x = cell.getX();
			this.y = cell.getY();
			this.score = cell.getScore();
			this.previousCell = cell.getPreviousCell();
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		public int getScore() {
			return score;
		}

		public void setScore(int score) {
			this.score = score;
		}

		public Cell getPreviousCell() {
			return previousCell;
		}

		public void setPreviousCell(Cell previousCell) {
			this.previousCell = previousCell;
		}
	
		public int getAlignableXIndexStart(AlignmentExtenderContext context) {
			return context.getAlignableXAlignedTo() + context.getDirection().getValue() * x;
		}
		
		public int getAlignableXIndexEnd(AlignmentExtenderContext context) {
			if (previousCell.getX() != x) {
				return getAlignableXIndexStart(context) + 1;
			}
			return getAlignableXIndexStart(context);
		}
		
		public int getAlignableYIndexStart(AlignmentExtenderContext context) {
			return context.getAlignableYAlignedTo() + context.getDirection().getValue() * y;
		}
		
		public int getAlignableYIndexEnd(AlignmentExtenderContext context) {
			if (previousCell.getY() != y) {
				return getAlignableYIndexStart(context) + 1;
			}
			return getAlignableYIndexStart(context);
		}
		
		public boolean isAlignable(AlignmentExtenderContext context) {
			int indexX = getAlignableXIndexStart(context);
			int indexY = getAlignableYIndexStart(context);
			
			if (indexX < context.getAlignableXMin() || indexX > context.getAlignableXMax()) {
				return false;
			}
			
			if (indexY < context.getAlignableYMin() || indexY > context.getAlignableYMax()) {
				return false;
			}
			
			return true;
		}
		
		private int matchScore(AlignmentExtenderContext context) {
			int matchScore = context.getAlignableX().matchScore(getAlignableXIndexStart(context), context.getAlignableY(), getAlignableYIndexStart(context));
			return matchScore;
		}
		
		private int insertionScore(AlignmentExtenderContext context) {
			int insertionScore = context.getAlignableX().insertionScore(getAlignableXIndexStart(context), context.getAlignableY(), getAlignableYIndexStart(context));
			return insertionScore;
		}
		
		private int deletionScore(AlignmentExtenderContext context) {
			int deletionScore = context.getAlignableX().deletionScore(getAlignableXIndexStart(context), context.getAlignableY(), getAlignableYIndexStart(context));
			return deletionScore;
		}
		
	}
	
	
	// maximum number of deletions or insertions
	private int maxSkip;
	
	private List<Cell[]> alignment;
	private int step;
	
	private int bestScore;
	private Cell bestCell;

	public AlignmentExtender() {
		init();
	}
	
	private void init() {
		alignment = new ArrayList<Cell[]>();
		step = -1;
		bestScore = MIN_SCORE;
		bestCell = null;		
	}

	public void setMaxSkip(int maxSkip) {
		this.maxSkip = maxSkip;
	}

	/* (non-Javadoc)
	 * @see com.falstaff.core.alignable.extender.IAlignmentExtender#extend(com.falstaff.core.alignable.INAlignable, int, com.falstaff.core.alignable.INAlignable, int, com.falstaff.core.alignable.extender.AlignmentExtender.Direction, int)
	 */
	@Override
	public Cell extend(AlignmentExtenderContext context) {		

		align(context);
		
		// if alignment was found, copy resulting cells excluding the last already aligned cell		
		Cell bestCellCopy = null;
		if (bestCell != null) {
		    bestCellCopy = new Cell(bestCell);
		}
		Cell cell = bestCellCopy;
		while (cell != null) {
			Cell previousCell = cell.getPreviousCell();
			Cell previousCellCopy = null;
			if (previousCell != null) {
				previousCellCopy = new Cell(previousCell);
				cell.setPreviousCell(previousCellCopy);
			}
			cell = previousCellCopy;
		}
		return bestCellCopy;
	}
	
	@Override
	public int score(AlignmentExtenderContext context) {	
		align(context);
		return bestScore;
	}
	
	private void align(AlignmentExtenderContext context) {
		if (shouldClean()) {
			clean();
		}
		step = -1;
		while (true) {
			step++;
			int stepScore = computeStepScore(context);
			if (stepScore <= context.getDropScore()) {
				break;
			}
			if (context.getMaxExtensionLength() != -1 && step > context.getMaxExtensionLength()) {
				break;
			}
		}		
	}

	private void initStep() {
		if (alignment.size() - 1 < step) {
			Cell[] cells = new Cell[maxSkipCellsCount()];
			cells[maxSkip] = new Cell(step, step);
			for (int i = 1; i <= maxSkip; i++) {
				cells[maxSkip - i] = new Cell(step, step + i);
				cells[maxSkip + i] = new Cell(step + i, step);
			}
			alignment.add(cells);
		}
	}
	
	private int maxSkipCellsCount() {
		return maxSkip * 2 + 1;
	}
	
	private void cleanCell(Cell cell) {
		cell.setScore(MIN_SCORE);
		cell.setPreviousCell(null);
	}	

	private int computeStepScore(AlignmentExtenderContext context) {
		int stepScore = MIN_SCORE;
		
		initStep();
		
		Cell diagonalCell = getCell(step, step);
		if (!diagonalCell.isAlignable(context)) {
			return stepScore;
		}
		else {
			stepScore = computeCellScore(diagonalCell, context);
			updateBestScore(diagonalCell);
		}
		
		for (int i = step + 1; i <= step + maxSkip; i++) {
			Cell updatedCell;
			updatedCell = getCell(i, step);
			stepScore = updateStepScore(updatedCell, stepScore, context);
			updatedCell = getCell(step, i);
			stepScore = updateStepScore(updatedCell, stepScore, context);
		}
		
		return stepScore;
	}
	
	private int updateStepScore(Cell cell, int stepScore, AlignmentExtenderContext context) {
		if (cell.isAlignable(context)) {
			int updatedScore = computeCellScore(cell, context);
			if (updatedScore > stepScore) {
				stepScore = updatedScore;
				updateBestScore(cell);
			}
		}
		return stepScore;
	}
	
	private void updateBestScore(Cell cell) {
		int score = cell.getScore();
		if (score > 0 && (score > bestScore || (score == bestScore && bestCell != null && Math.min(bestCell.getX(), bestCell.getY()) < Math.min(cell.getX(), cell.getY())))) {
			bestScore = score;
			bestCell = cell;
		}
	}	
	
	private Cell getCell(int x, int y) {		
		Cell cell = null;
		
		if (x < 0 || y < 0) {
			return cell;
		}
		
		int cellStep = Math.min(x, y);
		
		if (x > cellStep + maxSkip || y > cellStep + maxSkip) {
			return cell;
		}
		
		Cell[] cells = alignment.get(cellStep);
		
		if (x == cellStep) {
			cell = cells[maxSkip - (y - cellStep)];
		}
		else {
			cell = cells[maxSkip + (x - cellStep)];
		}

		return cell;
	}
	
	private int computeCellScore(Cell cell, AlignmentExtenderContext context) {
		Cell insertionCell = getCell(cell.getX() - 1, cell.getY());
		Cell matchCell = getCell(cell.getX() - 1, cell.getY() - 1);
		Cell deletionCell = getCell(cell.getX(), cell.getY() - 1);
		
		int insertionScore;
		int matchScore;
		int deletionScore;
		
		int cellScore;
		Cell previousCell;
		
		// diagonal cell in step == 0
		if (insertionCell == null && matchCell == null && deletionCell == null) {
			cellScore = 0;
			cell.setScore(cellScore);
			cell.setPreviousCell(null);
			return cellScore;
		}
		
		if (insertionCell == null || !insertionCell.isAlignable(context)) {
			insertionScore = MIN_SCORE;
		}
		else {
			insertionScore = insertionCell.getScore() + cell.insertionScore(context);
		}
		
		if (matchCell == null || !matchCell.isAlignable(context)) {
			matchScore = MIN_SCORE;
		}
		else {
			matchScore = matchCell.getScore() + cell.matchScore(context);
		}
		
		if (deletionCell == null || !deletionCell.isAlignable(context)) {
			deletionScore = MIN_SCORE;
		}
		else {
			deletionScore = deletionCell.getScore() + cell.deletionScore(context);
		}
		
		cellScore = matchScore;
		previousCell = matchCell;
		
		if (insertionScore > cellScore) {
			cellScore = insertionScore;
			previousCell = insertionCell;
		}
		
		if (deletionScore > cellScore) {
			cellScore = deletionScore;
			previousCell = deletionCell;
		}
		
		cell.setScore(cellScore);
		cell.setPreviousCell(previousCell);
		
		return cellScore;
	}
	
	private boolean shouldClean() {
		return step >= 0;
	}
	
	/* (non-Javadoc)
	 * @see com.falstaff.core.alignable.extender.IAlignmentExtender#clean()
	 */
	@Override
	public void clean() {
		bestScore = MIN_SCORE;
		bestCell = null;
		if (alignment == null || alignment.size() == 0) {
			return;
		}
		for (int i = 0; i <= step; i++) {
			Cell cells[] = alignment.get(i);
			for (Cell cell : cells) {
				cleanCell(cell);
			}
		}
		step = -1;
	}

}
