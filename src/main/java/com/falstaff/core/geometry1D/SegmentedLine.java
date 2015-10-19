package com.falstaff.core.geometry1D;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SegmentedLine {
	
	private static final Logger log = LoggerFactory
	.getLogger(SegmentedLine.class.getName());
	
	protected List<Segment> segments;
	private boolean mergeOverlaps = true;

	public SegmentedLine() {
		this(true);
	}

	public SegmentedLine(boolean mergeOverlaps) {
		super();
		this.mergeOverlaps = mergeOverlaps;
		segments = new LinkedList<Segment>();
	}

	public SegmentedLine(SegmentedLine line, int shift, int extend) {
		this();
		for (Segment segment : line.getSegments()) {
			Segment shiftedSegment = new Segment(segment, shift,
					extend);
			if (segment.getLength() > 0) {
				addSegment(shiftedSegment);
			}
			else {
				log.warn("segment " + segment + " shift " + shift + " extend " + extend + " not added");
			}
		}
	}

	public SegmentedLine(List<Segment> segments) {
		super();
		this.segments = new LinkedList<Segment>(segments);
	}
	
	public static SegmentedLine merge(SegmentedLine line1, SegmentedLine line2) {
		return merge(line1, line2, true);
	}
	
	public void merge(SegmentedLine line) {
		SegmentedLine mergedLine = merge(this,line,mergeOverlaps);
		segments.clear();
		segments.addAll(mergedLine.getSegments());
	}

	public static SegmentedLine merge(SegmentedLine line1, SegmentedLine line2, boolean mergeSegments) {
		List<Segment> mergedSegments = new LinkedList<Segment>();
		ListIterator<Segment> iterator1 = line1.getSegments().listIterator();
		ListIterator<Segment> iterator2 = line2.getSegments().listIterator();
		Segment segment1 = null;
		Segment segment2 = null;
		Segment mergedSegment = null;
		while (iterator1.hasNext() || iterator2.hasNext() || segment1 != null
				|| segment2 != null) {
			if (segment1 == null && iterator1.hasNext())
				segment1 = iterator1.next();
			if (segment2 == null && iterator2.hasNext())
				segment2 = iterator2.next();

			// initialize merged segment
			if (mergedSegment == null) {
				if (segment1 != null && segment2 != null) {
					if (segment1.startsBefore(segment2)) {
						mergedSegment = segment1;
						segment1 = null;
					} else {
						mergedSegment = segment2;
						segment2 = null;
					}
				} else {
					if (segment1 != null) {
						mergedSegment = segment1;
						segment1 = null;
					} else {
						mergedSegment = segment2;
						segment2 = null;
					}
				}
			}

			boolean merged = false;
			if (mergeSegments) {
				// check if segment1 should be merged
				if (segment1 != null && mergedSegment.distance(segment1) <= 1) {
					if (!mergedSegment.equals(segment1))
						mergedSegment = Segment.merge(mergedSegment, segment1);
					segment1 = null;
					merged = true;
				}
				// check if segment2 should be merged
				if (segment2 != null && mergedSegment.distance(segment2) <= 1) {
					if (!mergedSegment.equals(segment2))
						mergedSegment = Segment.merge(mergedSegment, segment2);
					segment2 = null;
					merged = true;
				}
			}
			// if nothing was merged output merged segment
			if (!merged) {
				mergedSegments.add(mergedSegment);
				mergedSegment = null;
			}
		}

		if (mergedSegment != null) {
			mergedSegments.add(mergedSegment);
		}

		return new SegmentedLine(mergedSegments);
	}

	public void addSegment(Segment segment) {
		// find the first overlapping segment
		int start = 0;
		int end = segments.size() - 1;
		while (end - start > 1) {
			int middle = (start + end) / 2;
			Segment middleSegment = segments.get(middle);
			if (segment.startsBefore(middleSegment)
					|| segment.distance(middleSegment) <= 1) {
				end = middle;
			} else {
				start = middle;
			}
		}
		ListIterator<Segment> segmentsIterator = segments.listIterator(start);
		while (segmentsIterator.hasNext()) {
			Segment nextSegment = segmentsIterator.next();

			// if segments overlap merge them
			if (mergeOverlaps && segment.distance(nextSegment) <= 1) {
				segment = Segment.merge(segment, nextSegment);
				segmentsIterator.remove();
			} else {
				// keep the list sorted
				// null segment value indicates that the insertion was done
				if (segment.startsBefore(nextSegment)) {
					segmentsIterator.previous();
					segmentsIterator.add(segment);
					segment = null;
					break;
				}
			}
		}

		// if no insertions was done add new region to the end of the list
		if (segment != null) {
			segments.add(segment);
		}
	}

	public boolean contains(int point) {
		for (Segment segment : segments) {
			if (segment.contains(point))
				return true;
			if (segment.getStart() > point) {
				return false;
			}
		}
		return false;
	}

	public boolean intersects(SegmentedLine line) {
		ListIterator<Segment> iterator1 = getSegments().listIterator();
		ListIterator<Segment> iterator2 = line.getSegments().listIterator();
		Segment segment1 = null;
		Segment segment2 = null;
		while ((segment1 != null || iterator1.hasNext()) && (segment2 != null || iterator2.hasNext())) {
			// the loop invariant is that mergedSegment if not null should be
			// added
			if (segment1 == null)
				segment1 = iterator1.next();
			if (segment2 == null)
				segment2 = iterator2.next();
			if (segment1.intersects(segment2))
				return true;
			if (segment1.startsBefore(segment2))
				segment1 = null;
			else
				segment2 = null;
		}
		return false;
	}
	
	public boolean contains(SegmentedLine line) {
		ListIterator<Segment> iterator1 = getSegments().listIterator();
		ListIterator<Segment> iterator2 = line.getSegments().listIterator();
		Segment segment1 = null;
		Segment segment2 = null;
		while (segment2 != null || iterator2.hasNext()) {
			// the loop invariant is that mergedSegment if not null should be
			// added
			if (segment1 == null && iterator1.hasNext())
				segment1 = iterator1.next();
			if (segment2 == null)
				segment2 = iterator2.next();
			if (segment1 == null && segment2 != null) {
				return false;
			}
			if (segment2.startsBefore(segment1)) {
				return false;
			}
			if (segment1.intersects(segment2) && !segment1.contains(segment2)) {
				return false;
			}
			if (segment1.contains(segment2)) {
				segment2 = null;
			}
			else {
				segment1 = null;
			}
		}
		return true;
	}	

	public List<Segment> getSegments() {
		return segments;
	}

	@Override
	public String toString() {
		StringBuilder buffer = new StringBuilder();
		for (Segment segment : segments) {
			buffer.append(segment).append(" ");
		}
		return buffer.toString();
	}

	public int length() {
		int len = 0;
		for (Segment segment : segments) {
			len += segment.getLength();
		}
		return len;
	}
	
}
