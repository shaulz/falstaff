package com.falstaff.core.geometry2D;

//DiagonalRegion represents a parallelogram with :
//two sides parallel to the x axis
//two sides parallel to x = y diagonal
public interface IDiagonalParallelogram {
	public int getDiagonalLength();
	public int getWidth();
	public Point getStart();
	public Point getEnd();
	public boolean startsBefore(Point point);
	public boolean startsAfter(Point point);
	public boolean contains(Point point);
	public IDiagonalParallelogram extend(int extension, Point min, Point max);
}
