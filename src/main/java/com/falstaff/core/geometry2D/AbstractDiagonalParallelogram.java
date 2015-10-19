package com.falstaff.core.geometry2D;


public abstract class AbstractDiagonalParallelogram implements IDiagonalParallelogram {

	public AbstractDiagonalParallelogram() {
	}
	
	public boolean startsBefore(Point point) {
		return getStart().getX() < point.getX() && getStart().getY() < point.getY();
	}
	
	public boolean startsAfter(Point point) {
		return getEnd().getX() > point.getX() && getEnd().getY() > point.getY();
	}
}
