package com.falstaff.core.geometry2D;

public class Point {

	private int x;
	private int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// chessboard distance
	public int distance(Point point) {
		return Math.max(Math.abs(x - point.getX()), Math.abs(y - point.getY()));
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append('(').append(x).append(',').append(y).append(')');
		return buffer.toString();
	}
	
	

}
