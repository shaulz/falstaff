package com.falstaff.core.geometry1D;


public class BoundedSegmentedLine extends SegmentedLine {
	private Segment bound;

	public BoundedSegmentedLine(int start,int length) {
		super();
		bound = new Segment(start,length);
	}
	
	public BoundedSegmentedLine(SegmentedLine line, int start,int length) {
		super();
		bound = new Segment(start,length);
		for (Segment segment : line.getSegments()) {
			this.addSegment(segment);
		}		
	}
	
	@Override
	public void addSegment(Segment segment) {
		Segment boundedSegment = Segment.intersection(bound,segment);
		if (boundedSegment != null)
		     super.addSegment(boundedSegment);
	}

	public BoundedSegmentedLine complement() {
		BoundedSegmentedLine complementLine = new BoundedSegmentedLine(bound.getStart(),bound.getLength());
		int complementSegmentStart = bound.getStart();
		for (Segment segment : segments) {
			if (segment.getStart() > complementSegmentStart) {
				complementLine.addSegment(new Segment(complementSegmentStart,segment.getStart() - complementSegmentStart));
			}
			complementSegmentStart = segment.getEnd() + 1;
		}
		if (complementSegmentStart <= bound.getEnd()) {
			complementLine.addSegment(new Segment(complementSegmentStart, bound.getEnd() - complementSegmentStart + 1));
		}
		return complementLine;
	}
	
}
