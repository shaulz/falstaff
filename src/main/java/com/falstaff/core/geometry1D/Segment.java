package com.falstaff.core.geometry1D;

public class Segment {
	private final int start;
	private final int length;

	public Segment(int start, int length) {
		super();
		this.start = start;
		this.length = length;
	}
	
	public Segment(Segment segment, int shift, int extend) {
		this(segment.getStart() + shift,segment.getLength() + extend);
	}

	public boolean intersects(Segment seg) {
		return contains(seg.getStart()) || seg.contains(start);
	}

	public static Segment intersection(Segment segment1, Segment segment2) {
		if (!segment1.intersects(segment2))
			return null;
		if (segment1.startsBefore(segment2)) {
			return new Segment(segment2.getStart(),Math.min(segment2.getEnd(), segment1.getEnd()) - segment2.getStart() + 1);
		}
		else {
			return new Segment(segment1.getStart(),Math.min(segment2.getEnd(), segment1.getEnd()) - segment1.getStart() + 1);
		}
	}

	public boolean contains(int point) {
		return (point >= start && point < start + length);
	}

	public boolean contains(Segment segment) {
		return(segment.getStart() >= start && getEnd() >= segment.getEnd());
	}

	public static Segment merge(Segment segment1, Segment segment2) {
		if (segment1.distance(segment2) > 1) {
			throw new RuntimeException("segments " + segment1 + " " + segment2 + " can not be merged");
		}
		int mergedStart = Math.min(segment1.getStart(), segment2.getStart());
		int mergedLength = Math.max(segment1.getStart() + segment1.getLength() - mergedStart, segment2.getStart() + segment2.getLength()- mergedStart);
		return new Segment(mergedStart,mergedLength);
	}

	public boolean startsBefore(Segment seg){
		return start < seg.getStart();
	}

	public int distance(Segment seg) {
		if (intersects(seg))
			return 0;
		return Math.min(
				Math.abs(start - seg.getStart() - seg.getLength() + 1),
				Math.abs(seg.getStart() - start - length + 1));
	}

	public int getStart() {
		return start;
	}

	public int getEnd() {
		return start + length - 1;
	}

	public int getLength() {
		return length;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + length;
		result = prime * result + start;
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
		Segment other = (Segment) obj;
		if (length != other.length)
			return false;
		if (start != other.start)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		buffer.append(start).append(',').append(getEnd());
		return buffer.toString();
	}
	
}
