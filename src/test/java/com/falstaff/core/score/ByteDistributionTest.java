package com.falstaff.core.score;

import static org.junit.Assert.*;

import org.junit.Test;

public class ByteDistributionTest {

	@Test
	public void test() {
		ByteDistribution distribution = new ByteDistribution();
		byte b = 100;
		distribution.add(b);
		b = 101;
		distribution.add(b);
		b = 101;
		distribution.add(b);
		b = 103;
		distribution.add(b);
		b = 103;
		distribution.add(b);
		b = 103;
		distribution.add(b);
		
		double e = distribution.getEntropy();		
		double e1 = distribution.getEntropy(e, null);
		distribution.add((Byte)null);
		double e2 = distribution.getEntropy();
		assertEquals(e2, e1, 0.000000000001);
		
		e = distribution.getEntropy();		
		e1 = distribution.getEntropy(e, null);
		distribution.add((Byte)null);
		e2 = distribution.getEntropy();
		assertEquals(e2, e1, 0.000000000001);
		
		e = distribution.getEntropy();
		b = 104;
		e1 = distribution.getEntropy(e, b);
		distribution.add(b);
		e2 = distribution.getEntropy();
		assertEquals(e2, e1, 0.000000000001);
		
		e = distribution.getEntropy();
		b = 104;
		e1 = distribution.getEntropy(e, b);
		distribution.add(b);
		e2 = distribution.getEntropy();
		assertEquals(e2, e1, 0.000000000001);
		
		e = distribution.getEntropy();
		b = 105;
		e1 = distribution.getEntropy(e, b, 3);
		distribution.add(b);
		distribution.add(b);
		distribution.add(b);
		e2 = distribution.getEntropy();
		assertEquals(e2, e1, 0.000000000001);
		
		e = distribution.getEntropy();
		b = 105;
		e1 = distribution.getEntropy(e, b, 2);
		distribution.add(b);
		distribution.add(b);
		e2 = distribution.getEntropy();
		assertEquals(e2, e1, 0.000000000001);	
		
		e = distribution.getEntropy();
		e1 = distribution.getEntropy(e, null, 3);
		distribution.add((Byte)null);
		distribution.add((Byte)null);
		distribution.add((Byte)null);
		e2 = distribution.getEntropy();
		assertEquals(e2, e1, 0.000000000001);

	}

}
