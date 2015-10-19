package com.falstaff.core.geometry2D;

// diagonal of form y = yIntersection + x
public class Diagonal {

	private int yIntersection;

	public Diagonal(int x, int y) {
		this.yIntersection = y - x;
	}

	public Diagonal(Point point) {
		this.yIntersection = point.getY() - point.getX();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (! (obj instanceof Diagonal) ) {
			return false;
		}
		Diagonal d = (Diagonal)obj;
		return (yIntersection == d.yIntersection);
	}

	public Diagonal aboveOnY(int i) {
		return new Diagonal(0, yIntersection - i);
	}

	public boolean above(Diagonal diagonal) {
		return yIntersection < diagonal.getYIntersection();
	}

	public boolean above(Point point) {
		return above(new Diagonal(point));
	}

	public boolean below(Diagonal diagonal) {
		return yIntersection > diagonal.getYIntersection();
	}

	public boolean below(Point point) {
		return below(new Diagonal(point));
	}


	// chessboard distance
	public int distance(Diagonal diagonal) {
		return Math.abs(yIntersection - diagonal.getYIntersection()) / 2 + Math.abs(yIntersection - diagonal.getYIntersection()) % 2;
	}

	public int distance(Point point) {
		return distance(new Diagonal(point));
	}

	public Point closestPoint(Point point) {
		int x = point.getX() + (point.getY() - point.getX() - yIntersection) / 2;
		int y = yIntersection + x;
		return new Point(x,y);
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return yIntersection;
	}

	public int getYIntersection() {
		return yIntersection;
	}

	// returns the x coordinate of intersection between diagonal and horizontal
	public int intersectWithHorizonal(int y) {
		return y - yIntersection;
	}

	// return the y coordinate of intersection between diagonal and vertical
	public int intersectWithVertical(int x) {
		return yIntersection + x;
	}

	public boolean contains(Point point) {
		return (point.getY() - point.getX() == yIntersection);
	}

}
