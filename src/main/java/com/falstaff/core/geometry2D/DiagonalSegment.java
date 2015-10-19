package com.falstaff.core.geometry2D;

import com.falstaff.core.geometry1D.Segment;


public class DiagonalSegment extends AbstractDiagonalParallelogram implements IDiagonalParallelogram {

	private Segment segment;
	private Diagonal diagonal;

	public Segment getSegment() {
		return segment;
	}

	public Segment getSegmentX() {
		return segment;
	}

	public Segment getSegmentY() {
		return new Segment(getStart().getY(), segment.getLength());
	}

	public DiagonalSegment(int xstart, int ystart, int diagonalLength) {
		segment = new Segment(xstart,diagonalLength);
		diagonal = new Diagonal(xstart,ystart);
	}

	public DiagonalSegment(Diagonal diagonal,Segment segment) {
		this.segment = segment;
		this.diagonal = diagonal;
	}

	// both segments are assumed to be on the same diagonal
	public boolean intersects(DiagonalSegment diagonalSegment) {
		return diagonal.equals(diagonalSegment.getDiagonal()) && segment.intersects(diagonalSegment.getSegment());
	}

//	public boolean overlap(int x,int diagonalLength) {
//		return (xstart >= x && xstart < x + diagonalLength) || within(x);
//	}

	public boolean startsBefore(DiagonalSegment diagonalSegment) {
		return diagonal.equals(diagonalSegment.getDiagonal()) && segment.startsBefore(diagonalSegment.getSegment());
	}

	public int distance(Point point) {
		if (startsAfter(point))
			return point.distance(getStart());
		if (endsBefore(point))
			return point.distance(getEnd());
		int offset = (point.getX() + point.getY() - getStart().getX() - getStart().getY()) / 2;
		Point offsetPoint = new Point(getStart().getX() + offset,getStart().getY() + offset);
		return point.distance(offsetPoint);
	}

	public int distance(DiagonalSegment segment) {
		int distance;

		distance = distance(segment.getStart());
		distance = Math.min(distance, distance(segment.getEnd()));
		distance = Math.min(distance, segment.distance(getStart()));
		distance = Math.min(distance, segment.distance(getEnd()));

		return distance;
	}

	// checks if the point belongs to a half plane above the line defined by
	// y = -x + C and passes through the segment start
	public boolean startsAfter(Point point) {
		return point.getX() + point.getY() < getStart().getX() + getStart().getY();
	}

	private boolean endsBefore(Point point) {
		return point.getX() + point.getY() > getEnd().getX() + getEnd().getY();
	}

	public Point getStart() {
		return new Point(segment.getStart(),segment.getStart() + diagonal.getYIntersection());
	}

	public Point getEnd() {
		return new Point(segment.getStart() + segment.getLength() - 1,segment.getStart() + diagonal.getYIntersection() + segment.getLength() - 1);
	}

	public Diagonal getUpperDiagonal() {
		return getDiagonal();
	}

	public Diagonal getLowerDiagonal() {
		return getDiagonal();
	}

	public Diagonal getDiagonal() {
		return diagonal;
	}

	public DiagonalSegment merge(DiagonalSegment diagonalSegment) {
		if (!diagonal.equals(diagonalSegment.getDiagonal())) {
				throw(new RuntimeException("IdentityRegions are not on the same diagonal "));
		}
		Segment mergedSegment = Segment.merge(segment,diagonalSegment.getSegment());
		return new DiagonalSegment(diagonal,mergedSegment);
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return 1;
	}

	public int getDiagonalLength() {
		// TODO Auto-generated method stub
		return segment.getLength();
	}

	public boolean contains(Point point) {
		// TODO Auto-generated method stub
		return diagonal.contains(point) && segment.contains(point.getX());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((diagonal == null) ? 0 : diagonal.hashCode());
		result = prime * result + ((segment == null) ? 0 : segment.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final DiagonalSegment other = (DiagonalSegment) obj;
		if (diagonal == null) {
			if (other.diagonal != null)
				return false;
		} else if (!diagonal.equals(other.diagonal))
			return false;
		if (segment == null) {
			if (other.segment != null)
				return false;
		} else if (!segment.equals(other.segment))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(getStart()).append(',').append(getEnd());
		return buffer.toString();
	}

	@Override
	public IDiagonalParallelogram extend(int extension, Point min, Point max) {
		Point start = getStart();
		Point end = getEnd();
		
		if (min.getX() > start.getX() || min.getY() > start.getY()) {
			min = start;
		}
		
		if (max.getX() < end.getX() || max.getY() < end.getY()) {
			max = end;
		}
		
		Point startExtended = new Point(start.getX() - extension, start.getY() - extension);
		if (startExtended.getX() < min.getX()) {
			int shift = min.getX() - startExtended.getX();
			startExtended = new Point(startExtended.getX() + shift,
					startExtended.getY() + shift);
		}
		if (startExtended.getY() < min.getY()) {
			int shift = min.getY() - startExtended.getY();
			startExtended = new Point(startExtended.getX() + shift,
					startExtended.getY() + shift);
		}		
		
		Point endExtended = new Point(end.getX() + extension, end.getY() + extension);
		if (endExtended.getX() > max.getX()) {
			int shift = endExtended.getX() - max.getX();
			endExtended = new Point(endExtended.getX() - shift,
					endExtended.getY() - shift);
		}
		if (endExtended.getY() > max.getY()) {
			int shift = endExtended.getY() - max.getY();
			endExtended = new Point(endExtended.getX() - shift,
					endExtended.getY() - shift);
		}		
		
		int extendedDiagonalLength = getDiagonalLength() + start.getX() - startExtended.getX() + endExtended.getX() - end.getX();
		return new DiagonalSegment(startExtended.getX(), startExtended.getY(),extendedDiagonalLength);
	}

}
