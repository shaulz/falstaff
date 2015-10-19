package com.falstaff.core.lookup;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.falstaff.core.alignable.sequence.NScorableSequenceAlignable;
import com.falstaff.core.lookup.ktup.INKtupIterator;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.CentroidIterator;
import com.falstaff.core.lookup.ktup.centroid.CountsCentroidFilter;
import com.falstaff.core.lookup.ktup.centroid.IKtupCentroid;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.EntropyScoreCalculator;
import com.falstaff.core.util.Histogram;

public class NTreeLookupTableTest {

	@Test
	public void testTreeCompactLookupTable() {
		ByteDistribution distribution = new ByteDistribution();
		byte[] s1 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		NScorableSequenceAlignable a1 = new NScorableSequenceAlignable(s1);
		distribution.add(a1.byteIterator());
		byte[] s2 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		NScorableSequenceAlignable a2 = new NScorableSequenceAlignable(s2);
		distribution.add(a2.byteIterator());
		byte[] s3 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		NScorableSequenceAlignable a3 = new NScorableSequenceAlignable(s3);
		distribution.add(a3.byteIterator());
		byte[] s4 = { 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		NScorableSequenceAlignable a4 = new NScorableSequenceAlignable(s4);
		distribution.add(a4.byteIterator());
		byte[] s5 = { 101, 102, 103, 104, 105, 106, 107, 108, 109 };
		NScorableSequenceAlignable a5 = new NScorableSequenceAlignable(s5);
		distribution.add(a5.byteIterator());
		byte[] s6 = { 101, 111, 103, 104, 105, 106, 107, 108, 112, 110 };
		NScorableSequenceAlignable a6 = new NScorableSequenceAlignable(s6);
		distribution.add(a6.byteIterator());
		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution, 6, 25);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		a4.setScoreCalculator(scoreCalculator);
		a5.setScoreCalculator(scoreCalculator);
		a6.setScoreCalculator(scoreCalculator);
		
		// test without filter
		List<INKtupIterator<? extends IScorableKtup>> iterators = new ArrayList<INKtupIterator<? extends IScorableKtup>>();
		iterators.add(a1.ktupIterator(4));
		iterators.add(a2.ktupIterator(4));
		iterators.add(a3.ktupIterator(4));
		iterators.add(a4.ktupIterator(4));
		iterators.add(a5.ktupIterator(4));
		iterators.add(a6.ktupIterator(4));
		INLookupTable<IScorableKtup> lookup = new NTreeCompactLookupTable<IScorableKtup>(4);
		lookup.add(iterators, null);
		lookup.fillStats();
		NLookupTableStats stats = lookup.getStats();
		Histogram<Integer> hist = stats.getKtupsInCentroidCounts();
		assertEquals(4, hist.get(1));
		assertEquals(0, hist.get(2));
		assertEquals(0, hist.get(3));
		assertEquals(2, hist.get(4));
		assertEquals(2, hist.get(5));
		assertEquals(3, hist.get(6));
		CentroidIterator<IScorableKtup> centroids = lookup.getCentroids(null);
		for (int i = 0; i < 3; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(6, centroid.getKtupsCount());
			assertEquals(6, centroid.getAlignablesCount());
		}
		for (int i = 0; i < 2; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(5, centroid.getKtupsCount());
			assertEquals(5, centroid.getAlignablesCount());
		}
		for (int i = 0; i < 2; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(4, centroid.getKtupsCount());
			assertEquals(4, centroid.getAlignablesCount());
		}
		for (int i = 0; i < 4; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(1, centroid.getKtupsCount());
			assertEquals(1, centroid.getAlignablesCount());
		}
		
		assertFalse(centroids.hasNext());
		
		// test with centroid filter
		iterators = new ArrayList<INKtupIterator<? extends IScorableKtup>>();
		iterators.add(a1.ktupIterator(4));
		iterators.add(a2.ktupIterator(4));
		iterators.add(a3.ktupIterator(4));
		iterators.add(a4.ktupIterator(4));
		iterators.add(a5.ktupIterator(4));
		iterators.add(a6.ktupIterator(4));
		lookup = new NTreeCompactLookupTable<IScorableKtup>(4);
		INKtupCentroidFilter<IScorableKtup> centroidFilter = new CountsCentroidFilter<IScorableKtup>(2, 2);
		lookup.add(iterators, centroidFilter);
		lookup.fillStats();
		stats = lookup.getStats();
		hist = stats.getKtupsInCentroidCounts();
		assertEquals(0, hist.get(1));
		assertEquals(0, hist.get(2));
		assertEquals(0, hist.get(3));
		assertEquals(2, hist.get(4));
		assertEquals(2, hist.get(5));
		assertEquals(3, hist.get(6));

		centroids = lookup.getCentroids(centroidFilter);
		
		List<INKtupIterator<? extends IScorableKtup>> removeIterators = new ArrayList<INKtupIterator<? extends IScorableKtup>>();
		removeIterators.add(a1.ktupIterator(4,2,6));
		removeIterators.add(a2.ktupIterator(4,2,6));
		removeIterators.add(a3.ktupIterator(4,2,6));
		removeIterators.add(a4.ktupIterator(4,1,5));
		removeIterators.add(a5.ktupIterator(4,2,6));
		removeIterators.add(a6.ktupIterator(4,6,9));
		removeIterators.add(a5.ktupIterator(4,5,8));
		
		lookup.remove(removeIterators, centroidFilter);

		for (int i = 0; i < 1; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(6, centroid.getKtupsCount());
			assertEquals(6, centroid.getAlignablesCount());
		}
		for (int i = 0; i < 1; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(5, centroid.getKtupsCount());
			assertEquals(5, centroid.getAlignablesCount());
		}
		for (int i = 0; i < 3; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(4, centroid.getKtupsCount());
			assertEquals(4, centroid.getAlignablesCount());
		}
		assertFalse(centroids.hasNext());
	}
	
	@Test
	public void testTreeLookupTable() {
		ByteDistribution distribution = new ByteDistribution();
		byte[] s1 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		NScorableSequenceAlignable a1 = new NScorableSequenceAlignable(s1);
		distribution.add(a1.byteIterator());
		byte[] s2 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		NScorableSequenceAlignable a2 = new NScorableSequenceAlignable(s2);
		distribution.add(a2.byteIterator());
		byte[] s3 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		NScorableSequenceAlignable a3 = new NScorableSequenceAlignable(s3);
		distribution.add(a3.byteIterator());
		byte[] s4 = { 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		NScorableSequenceAlignable a4 = new NScorableSequenceAlignable(s4);
		distribution.add(a4.byteIterator());
		byte[] s5 = { 101, 102, 103, 104, 105, 106, 107, 108, 109 };
		NScorableSequenceAlignable a5 = new NScorableSequenceAlignable(s5);
		distribution.add(a5.byteIterator());
		byte[] s6 = { 101, 111, 103, 104, 105, 106, 107, 108, 112, 110 };
		NScorableSequenceAlignable a6 = new NScorableSequenceAlignable(s6);
		distribution.add(a6.byteIterator());
		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution, 6, 25);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		a4.setScoreCalculator(scoreCalculator);
		a5.setScoreCalculator(scoreCalculator);
		a6.setScoreCalculator(scoreCalculator);
		
		// test without filter
		List<INKtupIterator<? extends IScorableKtup>> iterators = new ArrayList<INKtupIterator<? extends IScorableKtup>>();
		iterators.add(a1.ktupIterator(4));
		iterators.add(a2.ktupIterator(4));
		iterators.add(a3.ktupIterator(4));
		iterators.add(a4.ktupIterator(4));
		iterators.add(a5.ktupIterator(4));
		iterators.add(a6.ktupIterator(4));
		INLookupTable<IScorableKtup> lookup = new NNTreeLookupTable<IScorableKtup>(4);
		lookup.add(iterators, null);
		lookup.fillStats();
		NLookupTableStats stats = lookup.getStats();
		Histogram<Integer> hist = stats.getKtupsInCentroidCounts();
		assertEquals(4, hist.get(1));
		assertEquals(0, hist.get(2));
		assertEquals(0, hist.get(3));
		assertEquals(2, hist.get(4));
		assertEquals(2, hist.get(5));
		assertEquals(3, hist.get(6));
		CentroidIterator<IScorableKtup> centroids = lookup.getCentroids(null);
		for (int i = 0; i < 3; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(6, centroid.getKtupsCount());
			assertEquals(6, centroid.getAlignablesCount());
		}
		for (int i = 0; i < 2; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(5, centroid.getKtupsCount());
			assertEquals(5, centroid.getAlignablesCount());
		}
		for (int i = 0; i < 2; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(4, centroid.getKtupsCount());
			assertEquals(4, centroid.getAlignablesCount());
		}
		for (int i = 0; i < 4; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(1, centroid.getKtupsCount());
			assertEquals(1, centroid.getAlignablesCount());
		}
		
		assertFalse(centroids.hasNext());
		
		// test with centroid filter
		iterators = new ArrayList<INKtupIterator<? extends IScorableKtup>>();
		iterators.add(a1.ktupIterator(4));
		iterators.add(a2.ktupIterator(4));
		iterators.add(a3.ktupIterator(4));
		iterators.add(a4.ktupIterator(4));
		iterators.add(a5.ktupIterator(4));
		iterators.add(a6.ktupIterator(4));
		lookup = new NNTreeLookupTable<IScorableKtup>(4);
		INKtupCentroidFilter<IScorableKtup> centroidFilter = new CountsCentroidFilter<IScorableKtup>(2, 2);
		lookup.add(iterators, centroidFilter);
		lookup.fillStats();
		stats = lookup.getStats();
		hist = stats.getKtupsInCentroidCounts();
		assertEquals(0, hist.get(1));
		assertEquals(0, hist.get(2));
		assertEquals(0, hist.get(3));
		assertEquals(2, hist.get(4));
		assertEquals(2, hist.get(5));
		assertEquals(3, hist.get(6));

		centroids = lookup.getCentroids(centroidFilter);
		
		List<INKtupIterator<? extends IScorableKtup>> removeIterators = new ArrayList<INKtupIterator<? extends IScorableKtup>>();
		removeIterators.add(a1.ktupIterator(4,2,6));
		removeIterators.add(a2.ktupIterator(4,2,6));
		removeIterators.add(a3.ktupIterator(4,2,6));
		removeIterators.add(a4.ktupIterator(4,1,5));
		removeIterators.add(a5.ktupIterator(4,2,6));
		removeIterators.add(a6.ktupIterator(4,6,9));
		removeIterators.add(a5.ktupIterator(4,5,8));
		
		lookup.remove(removeIterators, centroidFilter);

		for (int i = 0; i < 1; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(6, centroid.getKtupsCount());
			assertEquals(6, centroid.getAlignablesCount());
		}
		for (int i = 0; i < 1; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(5, centroid.getKtupsCount());
			assertEquals(5, centroid.getAlignablesCount());
		}
		for (int i = 0; i < 3; i++) {
			IKtupCentroid<IScorableKtup> centroid = centroids.next();
			assertEquals(4, centroid.getKtupsCount());
			assertEquals(4, centroid.getAlignablesCount());
		}
		assertFalse(centroids.hasNext());
	}


}
