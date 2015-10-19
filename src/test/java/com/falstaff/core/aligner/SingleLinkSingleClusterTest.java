package com.falstaff.core.aligner;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.falstaff.FalstaffApplication;
import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.sequence.NScorableSequenceAlignable;
import com.falstaff.core.aligner.cluster.NSingleLinkSingleCluster;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.EntropyScoreCalculator;
import com.falstaff.core.score.ProbabilityScoreCalculator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FalstaffApplication.class)
public class SingleLinkSingleClusterTest {

	byte[] s1 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
	byte[] s2 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
	byte[] s3 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
	byte[] s4 = { 102, 103, 104, 105, 106, 107, 108, 109, 110 };
	byte[] s5 = { 101, 102, 103, 104, 105, 106, 107, 108, 109 };
	byte[] s6 = { 101, 111, 103, 104, 105, 106, 107, 108, 112, 110 };
	byte[] s7 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };

	NScorableSequenceAlignable a1 = new NScorableSequenceAlignable(s1);
	NScorableSequenceAlignable a2 = new NScorableSequenceAlignable(s2);
	NScorableSequenceAlignable a3 = new NScorableSequenceAlignable(s3);
	NScorableSequenceAlignable a4 = new NScorableSequenceAlignable(s4);
	NScorableSequenceAlignable a5 = new NScorableSequenceAlignable(s5);
	NScorableSequenceAlignable a6 = new NScorableSequenceAlignable(s6);
	NScorableSequenceAlignable a7 = new NScorableSequenceAlignable(s7);
	
	@Autowired
	NSingleLinkSingleCluster singleLinkSingleCluster;

	@Test
	public void testWithProbabilityScoreCalculator1() {
		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());

		ProbabilityScoreCalculator scoreCalculator = new ProbabilityScoreCalculator(
				-2, -3, distribution);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		
		IScorableKtup k1 = a1.getKtup(3, 4);
		IScorableKtup k2 = a2.getKtup(3, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		
		INMultipleAlignment alignment = singleLinkSingleCluster.cluster(ktups).get(0);
		assertEquals(10,alignment.length());
		assertEquals(new Byte((byte)101),alignment.getByte(0));
		assertEquals(new Byte((byte)110),alignment.getByte(9));
		assertEquals(5, alignment.getScore(0));
		assertEquals(5, alignment.getScore(9));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a1, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a2, 0));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a1, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a2, 9));
	}
	
	@Test
	public void testWithProbabilityScoreCalculator2() {
		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());
		distribution.add(a3.byteIterator());
		ProbabilityScoreCalculator scoreCalculator = new ProbabilityScoreCalculator(
				-2, -3, distribution);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		IScorableKtup k1 = a1.getKtup(3, 4);
		IScorableKtup k2 = a2.getKtup(3, 4);
		IScorableKtup k3 = a3.getKtup(3, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		ktups.add(k3);
		INMultipleAlignment alignment = singleLinkSingleCluster.cluster(ktups).get(0);
		assertEquals(3, alignment.getAlignedCount());
		assertEquals(10,alignment.length());
		assertEquals(new Byte((byte)101),alignment.getByte(0));
		assertEquals(new Byte((byte)110),alignment.getByte(9));
		assertEquals(15, alignment.getScore(0));
		assertEquals(15, alignment.getScore(9));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a1, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a2, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a3, 0));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a1, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a2, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a3, 9));
	}
	
	@Test
	public void testWithProbabilityScoreCalculator3() {
		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());
		distribution.add(a3.byteIterator());
		distribution.add(a4.byteIterator());
		distribution.add(a5.byteIterator());
		distribution.add(a6.byteIterator());
		ProbabilityScoreCalculator scoreCalculator = new ProbabilityScoreCalculator(
				-2, -3, distribution);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		a4.setScoreCalculator(scoreCalculator);
		a5.setScoreCalculator(scoreCalculator);
		a6.setScoreCalculator(scoreCalculator);

		IScorableKtup k1 = a1.getKtup(3, 4);
		IScorableKtup k2 = a2.getKtup(3, 4);
		IScorableKtup k3 = a3.getKtup(3, 4);
		IScorableKtup k4 = a4.getKtup(2, 4);
		IScorableKtup k5 = a5.getKtup(3, 4);
		IScorableKtup k6 = a6.getKtup(3, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		ktups.add(k3);
		ktups.add(0,k4);
		ktups.add(0,k5);
		ktups.add(0,k6);

		INMultipleAlignment alignment = singleLinkSingleCluster.cluster(ktups).get(0);;
		assertEquals(6, alignment.getAlignedCount());
		assertEquals(10,alignment.length());
		assertEquals(null,alignment.getByte(0));
		assertEquals(null,alignment.getByte(9));
		assertEquals(null,alignment.getByte(1));
		assertEquals(null,alignment.getByte(8));
		assertEquals(new Byte((byte)103),alignment.getByte(2));
		assertEquals(new Byte((byte)108),alignment.getByte(7));
		assertEquals(35, alignment.getScore(0));
		assertEquals(35, alignment.getScore(9));
		assertEquals(40, alignment.getScore(1));
		assertEquals(40, alignment.getScore(8));
		assertEquals(60, alignment.getScore(2));
		assertEquals(60, alignment.getScore(7));
		assertEquals(60, alignment.getScore(3));
		assertEquals(60, alignment.getScore(6));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a1, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a2, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a3, 0));
		assertEquals(null,alignment.getAlignedByte(a4, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a5, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a6, 0));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a1, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a2, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a3, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a4, 9));
		assertEquals(null,alignment.getAlignedByte(a5, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a6, 9));
		
		assertEquals(new Byte((byte)102),alignment.getAlignedByte(a1, 1));
		assertEquals(new Byte((byte)102),alignment.getAlignedByte(a2, 1));
		assertEquals(new Byte((byte)102),alignment.getAlignedByte(a3, 1));
		assertEquals(new Byte((byte)102),alignment.getAlignedByte(a4, 1));
		assertEquals(new Byte((byte)102),alignment.getAlignedByte(a5, 1));
		assertEquals(new Byte((byte)111),alignment.getAlignedByte(a6, 1));
		assertEquals(new Byte((byte)109),alignment.getAlignedByte(a1, 8));
		assertEquals(new Byte((byte)109),alignment.getAlignedByte(a2, 8));
		assertEquals(new Byte((byte)109),alignment.getAlignedByte(a3, 8));
		assertEquals(new Byte((byte)109),alignment.getAlignedByte(a4, 8));
		assertEquals(new Byte((byte)109),alignment.getAlignedByte(a5, 8));
		assertEquals(new Byte((byte)112),alignment.getAlignedByte(a6, 8));
		
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a1, 2));
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a2, 2));
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a3, 2));
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a4, 2));
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a5, 2));
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a6, 2));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a1, 7));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a2, 7));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a3, 7));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a4, 7));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a5, 7));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a6, 7));
	}
	
	@Test
	public void testWithEntropyScoreCalculator1() {
		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());

		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution,2,25);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		
		IScorableKtup k1 = a1.getKtup(3, 4);
		IScorableKtup k2 = a2.getKtup(3, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		
		INMultipleAlignment alignment = singleLinkSingleCluster.cluster(ktups).get(0);
		assertEquals(10,alignment.length());
		assertEquals(new Byte((byte)101),alignment.getByte(0));
		assertEquals(new Byte((byte)110),alignment.getByte(9));
		assertEquals(10, alignment.getScore(1));
		assertEquals(10, alignment.getScore(2));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a1, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a2, 0));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a1, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a2, 9));
	}
	
	@Test
	public void testWithEntropyScoreCalculator2() {
		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());
		distribution.add(a3.byteIterator());
		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution, 3, 25);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		IScorableKtup k1 = a1.getKtup(3, 4);
		IScorableKtup k2 = a2.getKtup(3, 4);
		IScorableKtup k3 = a3.getKtup(3, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		ktups.add(k3);
		INMultipleAlignment alignment = singleLinkSingleCluster.cluster(ktups).get(0);
		assertEquals(3, alignment.getAlignedCount());
		assertEquals(10,alignment.length());
		assertEquals(new Byte((byte)101),alignment.getByte(0));
		assertEquals(new Byte((byte)110),alignment.getByte(9));
		assertEquals(10, alignment.getScore(0));
		assertEquals(10, alignment.getScore(9));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a1, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a2, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a3, 0));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a1, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a2, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a3, 9));
	}
	
	@Test
	public void testWithEntropyScoreCalculator3() {
		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());
		distribution.add(a3.byteIterator());
		distribution.add(a4.byteIterator());
		distribution.add(a5.byteIterator());
		distribution.add(a6.byteIterator());
		distribution.add(a7.byteIterator());
		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution, 7, 25);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		a4.setScoreCalculator(scoreCalculator);
		a5.setScoreCalculator(scoreCalculator);
		a6.setScoreCalculator(scoreCalculator);
		a7.setScoreCalculator(scoreCalculator);

		IScorableKtup k1 = a1.getKtup(3, 4);
		IScorableKtup k2 = a2.getKtup(3, 4);
		IScorableKtup k3 = a3.getKtup(3, 4);
		IScorableKtup k4 = a4.getKtup(2, 4);
		IScorableKtup k5 = a5.getKtup(3, 4);
		IScorableKtup k6 = a6.getKtup(3, 4);
		IScorableKtup k7 = a7.getKtup(3, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		ktups.add(k3);
		ktups.add(0,k4);
		ktups.add(0,k5);
		ktups.add(0,k6);
		ktups.add(0,k7);
		INMultipleAlignment alignment = singleLinkSingleCluster.cluster(ktups).get(0);;
		assertEquals(7, alignment.getAlignedCount());
		assertEquals(10,alignment.length());
		assertEquals(null,alignment.getByte(0));
		assertEquals(null,alignment.getByte(9));
		assertEquals(null,alignment.getByte(1));
		assertEquals(null,alignment.getByte(8));
		assertEquals(new Byte((byte)103),alignment.getByte(2));
		assertEquals(new Byte((byte)108),alignment.getByte(7));
		assertEquals(3, alignment.getScore(0));
		assertEquals(3, alignment.getScore(9));
		assertEquals(3, alignment.getScore(1));
		assertEquals(3, alignment.getScore(8));
		assertEquals(10, alignment.getScore(2));
		assertEquals(10, alignment.getScore(7));
		assertEquals(10, alignment.getScore(3));
		assertEquals(10, alignment.getScore(6));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a1, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a2, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a3, 0));
		assertEquals(null,alignment.getAlignedByte(a4, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a5, 0));
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a6, 0));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a1, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a2, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a3, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a4, 9));
		assertEquals(null,alignment.getAlignedByte(a5, 9));
		assertEquals(new Byte((byte)110),alignment.getAlignedByte(a6, 9));
		
		assertEquals(new Byte((byte)102),alignment.getAlignedByte(a1, 1));
		assertEquals(new Byte((byte)102),alignment.getAlignedByte(a2, 1));
		assertEquals(new Byte((byte)102),alignment.getAlignedByte(a3, 1));
		assertEquals(new Byte((byte)102),alignment.getAlignedByte(a4, 1));
		assertEquals(new Byte((byte)102),alignment.getAlignedByte(a5, 1));
		assertEquals(new Byte((byte)111),alignment.getAlignedByte(a6, 1));
		assertEquals(new Byte((byte)109),alignment.getAlignedByte(a1, 8));
		assertEquals(new Byte((byte)109),alignment.getAlignedByte(a2, 8));
		assertEquals(new Byte((byte)109),alignment.getAlignedByte(a3, 8));
		assertEquals(new Byte((byte)109),alignment.getAlignedByte(a4, 8));
		assertEquals(new Byte((byte)109),alignment.getAlignedByte(a5, 8));
		assertEquals(new Byte((byte)112),alignment.getAlignedByte(a6, 8));
		
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a1, 2));
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a2, 2));
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a3, 2));
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a4, 2));
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a5, 2));
		assertEquals(new Byte((byte)103),alignment.getAlignedByte(a6, 2));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a1, 7));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a2, 7));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a3, 7));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a4, 7));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a5, 7));
		assertEquals(new Byte((byte)108),alignment.getAlignedByte(a6, 7));
	}
	
	
	@Test
	public void testLeftBoundaries1WithEntropyScoreCalculator() {
		byte[] s1 = { 101, 102, 103, 104, 105 };
		byte[] s2 = { 101, 102, 103, 104, 105 };
		byte[] s3 = { 101, 102, 103, 104, 105 };
		byte[] s4 = { 101, 102, 103, 104, 105 };
		byte[] s5 = { 101, 102, 103, 104, 105 };
		byte[] s6 = { 101, 102, 103, 104, 105 };
		byte[] s7 = { 100, 102, 103, 104, 105 };

		NScorableSequenceAlignable a1 = new NScorableSequenceAlignable(s1);
		NScorableSequenceAlignable a2 = new NScorableSequenceAlignable(s2);
		NScorableSequenceAlignable a3 = new NScorableSequenceAlignable(s3);
		NScorableSequenceAlignable a4 = new NScorableSequenceAlignable(s4);
		NScorableSequenceAlignable a5 = new NScorableSequenceAlignable(s5);
		NScorableSequenceAlignable a6 = new NScorableSequenceAlignable(s6);
		NScorableSequenceAlignable a7 = new NScorableSequenceAlignable(s7);

		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());
		distribution.add(a3.byteIterator());
		distribution.add(a4.byteIterator());
		distribution.add(a5.byteIterator());
		distribution.add(a6.byteIterator());
		distribution.add(a7.byteIterator());

		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution,7,25);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		a4.setScoreCalculator(scoreCalculator);
		a5.setScoreCalculator(scoreCalculator);
		a6.setScoreCalculator(scoreCalculator);
		a7.setScoreCalculator(scoreCalculator);
		
		IScorableKtup k1 = a1.getKtup(1, 4);
		IScorableKtup k2 = a2.getKtup(1, 4);
		IScorableKtup k3 = a3.getKtup(1, 4);
		IScorableKtup k4 = a4.getKtup(1, 4);
		IScorableKtup k5 = a5.getKtup(1, 4);
		IScorableKtup k6 = a6.getKtup(1, 4);
		IScorableKtup k7 = a7.getKtup(1, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		ktups.add(k3);
		ktups.add(k4);
		ktups.add(k5);
		ktups.add(k6);
		ktups.add(k7);
		
		INMultipleAlignment alignment = singleLinkSingleCluster.cluster(ktups).get(0);
	
		System.out.println("alignment " + alignment.toString());
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a6, 0));
		assertEquals(new Byte((byte)100),alignment.getAlignedByte(a7, 0));
	}
	
	@Test
	public void testLeftBoundaries2WithEntropyScoreCalculator() {
		byte[] s1 = { 101, 102, 103, 104, 105, 106 };
		byte[] s2 = { 101, 102, 103, 104, 105, 106 };
		byte[] s3 = { 101, 102, 103, 104, 105, 106 };
		byte[] s4 = { 101, 102, 103, 104, 105, 106 };
		byte[] s5 = { 101, 102, 103, 104, 105, 106 };
		byte[] s6 = { 101, 102, 103, 104, 105, 106 };
		byte[] s7 = { 100, 102, 103, 104, 105, 106 };

		NScorableSequenceAlignable a1 = new NScorableSequenceAlignable(s1);
		NScorableSequenceAlignable a2 = new NScorableSequenceAlignable(s2);
		NScorableSequenceAlignable a3 = new NScorableSequenceAlignable(s3);
		NScorableSequenceAlignable a4 = new NScorableSequenceAlignable(s4);
		NScorableSequenceAlignable a5 = new NScorableSequenceAlignable(s5);
		NScorableSequenceAlignable a6 = new NScorableSequenceAlignable(s6);
		NScorableSequenceAlignable a7 = new NScorableSequenceAlignable(s7);

		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());
		distribution.add(a3.byteIterator());
		distribution.add(a4.byteIterator());
		distribution.add(a5.byteIterator());
		distribution.add(a6.byteIterator());
		distribution.add(a7.byteIterator());

		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution,7,25);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		a4.setScoreCalculator(scoreCalculator);
		a5.setScoreCalculator(scoreCalculator);
		a6.setScoreCalculator(scoreCalculator);
		a7.setScoreCalculator(scoreCalculator);
		
		IScorableKtup k1 = a1.getKtup(2, 4);
		IScorableKtup k2 = a2.getKtup(2, 4);
		IScorableKtup k3 = a3.getKtup(2, 4);
		IScorableKtup k4 = a4.getKtup(2, 4);
		IScorableKtup k5 = a5.getKtup(2, 4);
		IScorableKtup k6 = a6.getKtup(2, 4);
		IScorableKtup k7 = a7.getKtup(2, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		ktups.add(k3);
		ktups.add(k4);
		ktups.add(k5);
		ktups.add(k6);
		ktups.add(k7);
		
		INMultipleAlignment alignment = singleLinkSingleCluster.cluster(ktups).get(0);
	
		System.out.println("alignment " + alignment.toString());
		assertEquals(new Byte((byte)101),alignment.getAlignedByte(a6, 0));
		assertEquals(new Byte((byte)100),alignment.getAlignedByte(a7, 0));
	}
	
	
	@Test
	public void testRightBoundaries1WithEntropyScoreCalculator() {
		byte[] s1 = { 101, 102, 103, 104, 105 };
		byte[] s2 = { 101, 102, 103, 104, 105 };
		byte[] s3 = { 101, 102, 103, 104, 105 };
		byte[] s4 = { 101, 102, 103, 104, 105 };
		byte[] s5 = { 101, 102, 103, 104, 105 };
		byte[] s6 = { 101, 102, 103, 104, 105 };
		byte[] s7 = { 101, 102, 103, 104, 106 };

		NScorableSequenceAlignable a1 = new NScorableSequenceAlignable(s1);
		NScorableSequenceAlignable a2 = new NScorableSequenceAlignable(s2);
		NScorableSequenceAlignable a3 = new NScorableSequenceAlignable(s3);
		NScorableSequenceAlignable a4 = new NScorableSequenceAlignable(s4);
		NScorableSequenceAlignable a5 = new NScorableSequenceAlignable(s5);
		NScorableSequenceAlignable a6 = new NScorableSequenceAlignable(s6);
		NScorableSequenceAlignable a7 = new NScorableSequenceAlignable(s7);

		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());
		distribution.add(a3.byteIterator());
		distribution.add(a4.byteIterator());
		distribution.add(a5.byteIterator());
		distribution.add(a6.byteIterator());
		distribution.add(a7.byteIterator());

		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution,7,25);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		a4.setScoreCalculator(scoreCalculator);
		a5.setScoreCalculator(scoreCalculator);
		a6.setScoreCalculator(scoreCalculator);
		a7.setScoreCalculator(scoreCalculator);
		
		IScorableKtup k1 = a1.getKtup(0, 4);
		IScorableKtup k2 = a2.getKtup(0, 4);
		IScorableKtup k3 = a3.getKtup(0, 4);
		IScorableKtup k4 = a4.getKtup(0, 4);
		IScorableKtup k5 = a5.getKtup(0, 4);
		IScorableKtup k6 = a6.getKtup(0, 4);
		IScorableKtup k7 = a7.getKtup(0, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		ktups.add(k3);
		ktups.add(k4);
		ktups.add(k5);
		ktups.add(k6);
		ktups.add(k7);
		
		INMultipleAlignment alignment = singleLinkSingleCluster.cluster(ktups).get(0);
	
		System.out.println("alignment " + alignment.toString());
		assertEquals(new Byte((byte)105),alignment.getAlignedByte(a6, 4));
		assertEquals(new Byte((byte)106),alignment.getAlignedByte(a7, 4));
	}
	
	@Test
	public void testRightBoundaries2WithEntropyScoreCalculator() {
		byte[] s1 = { 101, 102, 103, 104, 105, 106 };
		byte[] s2 = { 101, 102, 103, 104, 105, 106 };
		byte[] s3 = { 101, 102, 103, 104, 105, 106 };
		byte[] s4 = { 101, 102, 103, 104, 105, 106 };
		byte[] s5 = { 101, 102, 103, 104, 105, 106 };
		byte[] s6 = { 101, 102, 103, 104, 105, 106 };
		byte[] s7 = { 101, 102, 103, 104, 105, 107 };

		NScorableSequenceAlignable a1 = new NScorableSequenceAlignable(s1);
		NScorableSequenceAlignable a2 = new NScorableSequenceAlignable(s2);
		NScorableSequenceAlignable a3 = new NScorableSequenceAlignable(s3);
		NScorableSequenceAlignable a4 = new NScorableSequenceAlignable(s4);
		NScorableSequenceAlignable a5 = new NScorableSequenceAlignable(s5);
		NScorableSequenceAlignable a6 = new NScorableSequenceAlignable(s6);
		NScorableSequenceAlignable a7 = new NScorableSequenceAlignable(s7);

		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());
		distribution.add(a3.byteIterator());
		distribution.add(a4.byteIterator());
		distribution.add(a5.byteIterator());
		distribution.add(a6.byteIterator());
		distribution.add(a7.byteIterator());

		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution,7,25);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		a4.setScoreCalculator(scoreCalculator);
		a5.setScoreCalculator(scoreCalculator);
		a6.setScoreCalculator(scoreCalculator);
		a7.setScoreCalculator(scoreCalculator);
		
		IScorableKtup k1 = a1.getKtup(0, 4);
		IScorableKtup k2 = a2.getKtup(0, 4);
		IScorableKtup k3 = a3.getKtup(0, 4);
		IScorableKtup k4 = a4.getKtup(0, 4);
		IScorableKtup k5 = a5.getKtup(0, 4);
		IScorableKtup k6 = a6.getKtup(0, 4);
		IScorableKtup k7 = a7.getKtup(0, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		ktups.add(k3);
		ktups.add(k4);
		ktups.add(k5);
		ktups.add(k6);
		ktups.add(k7);
		
		INMultipleAlignment alignment = singleLinkSingleCluster.cluster(ktups).get(0);
	
		System.out.println("alignment " + alignment.toString());
		assertEquals(new Byte((byte)106),alignment.getAlignedByte(a6, 5));
		assertEquals(new Byte((byte)107),alignment.getAlignedByte(a7, 5));
	}

}
