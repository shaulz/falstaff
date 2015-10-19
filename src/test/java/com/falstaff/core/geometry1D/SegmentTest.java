package com.falstaff.core.geometry1D;

import static org.junit.Assert.*;
import org.junit.Test;

public class SegmentTest {
	
	@Test
	public void testIntersects() {
		Segment s1 = new Segment(3,10);
		assertTrue(s1.intersects(new Segment(0,4)));
		assertTrue(s1.intersects(new Segment(12,1)));
		assertTrue(s1.intersects(new Segment(0,100)));
		assertTrue(s1.intersects(new Segment(5,1)));
		assertFalse(s1.intersects(new Segment(0,3)));
		assertFalse(s1.intersects(new Segment(13,1)));
		assertFalse(s1.intersects(new Segment(50,100)));
		assertFalse(s1.intersects(new Segment(0,2)));
	}
	
	@Test
	public void testIntersection() {
		Segment s = Segment.intersection(new Segment(0,1), new Segment(1,1));
		assertNull(s);
	    s = Segment.intersection(new Segment(1,1), new Segment(0,1));
		assertNull(s);
		s = Segment.intersection(new Segment(0,100), new Segment(1,1));
		assertEquals(new Segment(1,1), s);
		s = Segment.intersection(new Segment(0,100), new Segment(1,1));
		assertEquals(new Segment(1,1), s);
		
		s = Segment.intersection(new Segment(3,100), new Segment(5,98));
		assertEquals(new Segment(5,98), s);
		s = Segment.intersection(new Segment(3,100), new Segment(5,99));
		assertEquals(new Segment(5,98), s);
		s = Segment.intersection(new Segment(3,100), new Segment(5,97));
		assertEquals(new Segment(5,97), s);

		s = Segment.intersection(new Segment(5,98),new Segment(3,100));
		assertEquals(new Segment(5,98), s);
		s = Segment.intersection(new Segment(5,99), new Segment(3,100));
		assertEquals(new Segment(5,98), s);
		s = Segment.intersection(new Segment(5,97), new Segment(3,100));
		assertEquals(new Segment(5,97), s);
		
		s = Segment.intersection(new Segment(3,100), new Segment(3,98));
		assertEquals(new Segment(3,98), s);
		s = Segment.intersection(new Segment(3,100), new Segment(2,98));
		assertEquals(new Segment(3,97), s);		
		s = Segment.intersection(new Segment(3,100), new Segment(4,98));
		assertEquals(new Segment(4,98), s);		
		
		s = Segment.intersection(new Segment(3,98),new Segment(3,100));
		assertEquals(new Segment(3,98), s);
		s = Segment.intersection(new Segment(2,98), new Segment(3,100));
		assertEquals(new Segment(3,97), s);		
		s = Segment.intersection(new Segment(4,98), new Segment(3,100));
		assertEquals(new Segment(4,98), s);			
		
	}
	
	@Test
	public void testDistance() {
		Segment s = new Segment(3,100);
		int d = s.distance(new Segment(4,1));
		assertEquals(d, 0);		
		d = s.distance(new Segment(3,1));
		assertEquals(d, 0);
		d = s.distance(new Segment(102,1));
		assertEquals(d, 0);
		d = s.distance(new Segment(2,1));
		assertEquals(d, 1);
		d = s.distance(new Segment(103,1));
		assertEquals(d, 1);
		d = s.distance(new Segment(2,100));
		assertEquals(d, 0);
	}
	
}
