package com.falstaff.core.alignable.extender;

import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.alignable.extender.AlignmentExtender.Direction;

public class AlignmentExtenderContext {

	private INScorableAlignable alignableX;
	public int getMaxExtensionLength() {
		return maxExtensionLength;
	}

	public void setMaxExtensionLength(int maxExtensionLength) {
		this.maxExtensionLength = maxExtensionLength;
	}

	private int alignableXMin;
	private int alignableXAlignedTo;
	private int alignableXMax;
	private INScorableAlignable alignableY;
	private int alignableYMin;
	private int alignableYAlignedTo;
	private int alignableYMax;
	
	private int direction;
	private int dropScore;
	private int maxExtensionLength = -1;
	
	public AlignmentExtenderContext(INScorableAlignable alignableX,
			int alignableXAlignedTo, INScorableAlignable alignableY,
			int alignableYAlignedTo, Direction direction, int dropScore, int maxExtensionLength) {
		super();
		this.alignableX = alignableX;
		this.alignableXAlignedTo = alignableXAlignedTo;
		this.alignableY = alignableY;
		this.alignableYAlignedTo = alignableYAlignedTo;
		this.direction = direction.getValue();
		this.dropScore = dropScore;
		this.maxExtensionLength = maxExtensionLength;
		
		alignableXMin = 0;
		alignableXMax = alignableX.length() - 1;
		
		alignableYMin = 0;
		alignableYMax = alignableY.length() - 1;
	}

	public INScorableAlignable getAlignableX() {
		return alignableX;
	}

	public void setAlignableX(INScorableAlignable alignableX) {
		this.alignableX = alignableX;
		alignableXMin = 0;
		alignableXMax = alignableX.length() - 1;
	}

	public int getAlignableXMin() {
		return alignableXMin;
	}

	public void setAlignableXMin(int alignableXMin) {
		this.alignableXMin = alignableXMin;
	}

	public int getAlignableXAlignedTo() {
		return alignableXAlignedTo;
	}

	public void setAlignableXAlignedTo(int alignableXAlignedTo) {
		this.alignableXAlignedTo = alignableXAlignedTo;
	}

	public int getAlignableXMax() {
		return alignableXMax;
	}

	public void setAlignableXMax(int alignableXMax) {
		this.alignableXMax = alignableXMax;
	}

	public INScorableAlignable getAlignableY() {
		return alignableY;
	}

	public void setAlignableY(INScorableAlignable alignableY) {
		this.alignableY = alignableY;
		alignableYMin = 0;
		alignableYMax = alignableY.length() - 1;
	}

	public int getAlignableYMin() {
		return alignableYMin;
	}

	public void setAlignableYMin(int alignableYMin) {
		this.alignableYMin = alignableYMin;
	}

	public int getAlignableYAlignedTo() {
		return alignableYAlignedTo;
	}

	public void setAlignableYAlignedTo(int alignableYAlignedTo) {
		this.alignableYAlignedTo = alignableYAlignedTo;
	}

	public int getAlignableYMax() {
		return alignableYMax;
	}

	public void setAlignableYMax(int alignableYMax) {
		this.alignableYMax = alignableYMax;
	}

	public Direction getDirection() {
		return Direction.fromInt(direction);
	}

	public void setDirection(Direction direction) {
		this.direction = direction.getValue();
	}

	public int getDropScore() {
		return dropScore;
	}

	public void setDropScore(int dropScore) {
		this.dropScore = dropScore;
	}
	
}
