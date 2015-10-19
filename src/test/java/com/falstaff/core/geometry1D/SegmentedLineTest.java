package com.falstaff.core.geometry1D;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Test;

public class SegmentedLineTest {

	@Test
	public void testShiftExtendConstructor() {
		LinkedList<Segment> l = new LinkedList<Segment>();
		l.add(new Segment(1,3));  // 1-3
		l.add(new Segment(5,4));  // 5-8
		l.add(new Segment(10,4));  // 10-13
		SegmentedLine line = new SegmentedLine(l);
		SegmentedLine constructedLine = new SegmentedLine(line,0,2);
		assertEquals(constructedLine.getSegments().size(),1);
		assertEquals(constructedLine.getSegments().get(0), new Segment(1,15));
		
		l = new LinkedList<Segment>();
		l.add(new Segment(1,3));  // 1-3
		l.add(new Segment(5,4));  // 5-8
		l.add(new Segment(10,4));  // 10-13
		line = new SegmentedLine(l);
		constructedLine = new SegmentedLine(line,5,2);
		assertEquals(constructedLine.getSegments().size(),1);
		assertEquals(constructedLine.getSegments().get(0), new Segment(6,15));	
		
		l = new LinkedList<Segment>();
		l.add(new Segment(1,3));  // 1-3
		l.add(new Segment(5,5));  // 5-8
		l.add(new Segment(10,4));  // 10-13
		line = new SegmentedLine(l);
		constructedLine = new SegmentedLine(line,5,2);
		assertEquals(constructedLine.getSegments().size(),1);
		assertEquals(constructedLine.getSegments().get(0), new Segment(6,15));	
		
		l = new LinkedList<Segment>();
		l.add(new Segment(1,3));  // 1-3
		l.add(new Segment(5,5));  // 5-8
		l.add(new Segment(10,4));  // 10-13
		l.add(new Segment(21,4));  // 21-24
		line = new SegmentedLine(l);
		constructedLine = new SegmentedLine(line,5,2);
		assertEquals(constructedLine.getSegments().size(),2);
		assertEquals(constructedLine.getSegments().get(0), new Segment(6,15));	
		assertEquals(constructedLine.getSegments().get(1), new Segment(26,6));

		l = new LinkedList<Segment>();
		l.add(new Segment(0,2));  // 0-1
		l.add(new Segment(5,3));  // 1-3
		l.add(new Segment(9,5));  // 5-8
		l.add(new Segment(14,4));  // 10-13
		l.add(new Segment(21,4));  // 21-24
		line = new SegmentedLine(l);
		constructedLine = new SegmentedLine(line,5,2);
		assertEquals(constructedLine.getSegments().size(),3);
		assertEquals(constructedLine.getSegments().get(0), new Segment(5,4));
		assertEquals(constructedLine.getSegments().get(1), new Segment(10,15));	
		assertEquals(constructedLine.getSegments().get(2), new Segment(26,6));

	}
	
	@Test
	public void testMerge() {
		LinkedList<Segment> l1 = new LinkedList<Segment>();
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,5)); 
		SegmentedLine line1 = new SegmentedLine(l1);
		LinkedList<Segment> l2 = new LinkedList<Segment>();
		l2.add(new Segment(10,5));  
		l2.add(new Segment(20,5));  
		l2.add(new Segment(30,5)); 
		SegmentedLine line2 = new SegmentedLine(l2);	
		
		SegmentedLine line = SegmentedLine.merge(line1,line2);
		assertEquals(line.getSegments().size(),1);
		assertEquals(line.getSegments().get(0), new Segment(5,30));

		line = SegmentedLine.merge(line2,line1);
		assertEquals(line.getSegments().size(),1);
		assertEquals(line.getSegments().get(0), new Segment(5,30));
		
		l1 = new LinkedList<Segment>();
		l1.add(new Segment(0,1)); 
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,5)); 
		l1.add(new Segment(100,1));
		line1 = new SegmentedLine(l1);
		l2 = new LinkedList<Segment>();
		l2.add(new Segment(3,1));
		l2.add(new Segment(10,5));  
		l2.add(new Segment(20,5));  
		l2.add(new Segment(30,5)); 
		l2.add(new Segment(50,1));
		l2.add(new Segment(75,1));
		l2.add(new Segment(102,1));
		line2 = new SegmentedLine(l2);	

		line = SegmentedLine.merge(line1,line2);
		assertEquals(line.getSegments().size(),7);
		assertEquals(line.getSegments().get(0), new Segment(0,1));
		assertEquals(line.getSegments().get(1), new Segment(3,1));
		assertEquals(line.getSegments().get(2), new Segment(5,30));
		assertEquals(line.getSegments().get(3), new Segment(50,1));
		assertEquals(line.getSegments().get(4), new Segment(75,1));
		assertEquals(line.getSegments().get(5), new Segment(100,1));
		assertEquals(line.getSegments().get(6), new Segment(102,1));
		
		line = SegmentedLine.merge(line2,line1);
		assertEquals(line.getSegments().size(),7);
		assertEquals(line.getSegments().get(0), new Segment(0,1));
		assertEquals(line.getSegments().get(1), new Segment(3,1));
		assertEquals(line.getSegments().get(2), new Segment(5,30));
		assertEquals(line.getSegments().get(3), new Segment(50,1));
		assertEquals(line.getSegments().get(4), new Segment(75,1));
		assertEquals(line.getSegments().get(5), new Segment(100,1));
		assertEquals(line.getSegments().get(6), new Segment(102,1));

		l1 = new LinkedList<Segment>();
		l1.add(new Segment(0,1)); 
		l1.add(new Segment(5,7));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,7)); 
		l1.add(new Segment(50,2));
		l1.add(new Segment(100,1));
		line1 = new SegmentedLine(l1);
		l2 = new LinkedList<Segment>();
		l2.add(new Segment(3,1));
		l2.add(new Segment(10,5));  
		l2.add(new Segment(18,8));  
		l2.add(new Segment(30,5)); 
		l2.add(new Segment(50,1));
		l2.add(new Segment(75,1));
		l2.add(new Segment(102,1));
		line2 = new SegmentedLine(l2);	

		line = SegmentedLine.merge(line1,line2);
		assertEquals(line.getSegments().size(),7);
		assertEquals(line.getSegments().get(0), new Segment(0,1));
		assertEquals(line.getSegments().get(1), new Segment(3,1));
		assertEquals(line.getSegments().get(2), new Segment(5,30));
		assertEquals(line.getSegments().get(3), new Segment(50,2));
		assertEquals(line.getSegments().get(4), new Segment(75,1));
		assertEquals(line.getSegments().get(5), new Segment(100,1));
		assertEquals(line.getSegments().get(6), new Segment(102,1));
		
		line = SegmentedLine.merge(line2,line1);
		assertEquals(line.getSegments().size(),7);
		assertEquals(line.getSegments().get(0), new Segment(0,1));
		assertEquals(line.getSegments().get(1), new Segment(3,1));
		assertEquals(line.getSegments().get(2), new Segment(5,30));
		assertEquals(line.getSegments().get(3), new Segment(50,2));
		assertEquals(line.getSegments().get(4), new Segment(75,1));
		assertEquals(line.getSegments().get(5), new Segment(100,1));
		assertEquals(line.getSegments().get(6), new Segment(102,1));
	}
	
	@Test
	public void testIntersects() {
		LinkedList<Segment> l1 = new LinkedList<Segment>();
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,5)); 
		SegmentedLine line1 = new SegmentedLine(l1);
		LinkedList<Segment> l2 = new LinkedList<Segment>();
		l2.add(new Segment(10,5));  
		l2.add(new Segment(20,5));  
		l2.add(new Segment(30,5)); 
		SegmentedLine line2 = new SegmentedLine(l2);	
		assertFalse(line1.intersects(line2));
		assertFalse(line2.intersects(line1));
		
		l1 = new LinkedList<Segment>();
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,6));  
		l1.add(new Segment(25,5)); 
		line1 = new SegmentedLine(l1);
		l2 = new LinkedList<Segment>();
		l2.add(new Segment(10,5));  
		l2.add(new Segment(20,5));  
		l2.add(new Segment(30,5)); 	
		line2 = new SegmentedLine(l2);	
		assertTrue(line1.intersects(line2));
		assertTrue(line2.intersects(line1));	
		
		l1 = new LinkedList<Segment>();
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,5)); 
		l1.add(new Segment(35,5)); 
		line1 = new SegmentedLine(l1);
		l2 = new LinkedList<Segment>();
		l2.add(new Segment(39,1));
		line2 = new SegmentedLine(l2);			
		assertTrue(line1.intersects(line2));
		assertTrue(line2.intersects(line1));
	}
	
	@Test
	public void testContains() {
		LinkedList<Segment> l1 = new LinkedList<Segment>();
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,5)); 
		l1.add(new Segment(35,5));
		l1.add(new Segment(45,5));
		l1.add(new Segment(55,5));
		SegmentedLine line1 = new SegmentedLine(l1);
		LinkedList<Segment> l2 = new LinkedList<Segment>();
		l2.add(new Segment(5,5));  
		l2.add(new Segment(25,5));  
		l2.add(new Segment(55,5)); 
		SegmentedLine line2 = new SegmentedLine(l2);	
		assertTrue(line1.contains(line2));
		assertFalse(line2.contains(line1));
		
		l1 = new LinkedList<Segment>();
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,5)); 
		l1.add(new Segment(35,5));
		l1.add(new Segment(45,5));
		l1.add(new Segment(55,5));
		line1 = new SegmentedLine(l1);
		l2 = new LinkedList<Segment>();
		l2.add(new Segment(55,5)); 
		line2 = new SegmentedLine(l2);	
		assertTrue(line1.contains(line2));
		assertFalse(line2.contains(line1));
		
		l1 = new LinkedList<Segment>();
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,5)); 
		l1.add(new Segment(35,5));
		l1.add(new Segment(45,5));
		l1.add(new Segment(55,5));
		line1 = new SegmentedLine(l1);
		l2 = new LinkedList<Segment>();
		l2.add(new Segment(5,55)); 
		line2 = new SegmentedLine(l2);	
		assertFalse(line1.contains(line2));
		assertTrue(line2.contains(line1));
		
		l1 = new LinkedList<Segment>();
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,5)); 
		l1.add(new Segment(35,5));
		l1.add(new Segment(45,5));
		l1.add(new Segment(55,5));
		line1 = new SegmentedLine(l1);
		l2 = new LinkedList<Segment>();
		l2.add(new Segment(4,58)); 
		line2 = new SegmentedLine(l2);	
		assertFalse(line1.contains(line2));
		assertTrue(line2.contains(line1));
						
		l1 = new LinkedList<Segment>();
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,5)); 
		l1.add(new Segment(35,5));
		l1.add(new Segment(45,5));
		l1.add(new Segment(55,6));
		line1 = new SegmentedLine(l1);
		l2 = new LinkedList<Segment>();
		l2.add(new Segment(5,55)); 
		line2 = new SegmentedLine(l2);	
		assertFalse(line1.contains(line2));
		assertFalse(line2.contains(line1));
		
		l1 = new LinkedList<Segment>();
		l1.add(new Segment(5,5));  
		l1.add(new Segment(15,5));  
		l1.add(new Segment(25,5)); 
		l1.add(new Segment(35,5));
		l1.add(new Segment(45,5));
		l1.add(new Segment(55,5));
		line1 = new SegmentedLine(l1);
		l2 = new LinkedList<Segment>();
		l2.add(new Segment(4,57)); 
		line2 = new SegmentedLine(l2);	
		assertFalse(line1.contains(line2));
		assertTrue(line2.contains(line1));
	}
}
