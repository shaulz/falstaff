package com.falstaff.core.aligner;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.falstaff.FalstaffApplication;
import com.falstaff.core.alignable.INLookupAlignable;
import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.alignable.sequence.NScorableSequenceAlignable;
import com.falstaff.core.aligner.cluster.NClusterStrategy;
import com.falstaff.core.aligner.cluster.NSingleLinkCluster;
import com.falstaff.core.lookup.INLookupTable;
import com.falstaff.core.lookup.NTreeCompactLookupTable;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.lookup.ktup.centroid.CountsCentroidFilter;
import com.falstaff.core.lookup.ktup.centroid.INKtupCentroidFilter;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.EntropyScoreCalculator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FalstaffApplication.class)
public class CentroidsClusterTest {
	
	@Autowired
	@Qualifier("singleLinkCluster")
	NSingleLinkCluster singleLinkCluster;

	@Test
	public void test() {
		byte[] s1 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 121, 122, 123, 33, 34, 11, 12, 40, 41, 42, 43, 44 };
		byte[] s2 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 124, 125, 126, 35, 36, 13, 14, 40, 41, 42, 43, 44 };
		byte[] s3 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 127, 28, 29, 37, 38, 15, 16, 40, 41, 42, 43, 44 };
		byte[] s4 = { 102, 103, 104, 105, 106, 107, 108, 109, 110, 30, 31, 32, 123, 39, 20, 17, 18, 40, 41, 42, 43, 44 };
		byte[] s5 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 121, 122, 123, 21, 22, 19, 20, 40, 41, 42, 43, 44 };
		byte[] s6 = { 101, 111, 103, 104, 105, 106, 107, 108, 112, 110 };

		NScorableSequenceAlignable a1 = new NScorableSequenceAlignable(s1);
		NScorableSequenceAlignable a2 = new NScorableSequenceAlignable(s2);
		NScorableSequenceAlignable a3 = new NScorableSequenceAlignable(s3);
		NScorableSequenceAlignable a4 = new NScorableSequenceAlignable(s4);
		NScorableSequenceAlignable a5 = new NScorableSequenceAlignable(s5);
		NScorableSequenceAlignable a6 = new NScorableSequenceAlignable(s6);
		
		List<INScorableAlignable> alignables = new ArrayList<INScorableAlignable>();
		alignables.add(a1);
		alignables.add(a2);
		alignables.add(a3);
		alignables.add(a4);
		alignables.add(a5);
		alignables.add(a6);
		
		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());
		distribution.add(a3.byteIterator());
		distribution.add(a4.byteIterator());
		distribution.add(a5.byteIterator());
		distribution.add(a6.byteIterator());
		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution, 6, 25);
		
		INKtupCentroidFilter<IScorableKtup> centroidFilter = new CountsCentroidFilter<IScorableKtup>(1, 1);
		INLookupTable<IScorableKtup> lookup = new NTreeCompactLookupTable<IScorableKtup>(4);

		CentroidsClusterer centroidsCluster = new CentroidsClusterer(scoreCalculator, lookup, new NClusterStrategy(singleLinkCluster));
		centroidsCluster.setPostFillFilter(centroidFilter);
		
		Collection<INLookupAlignable> alignments = centroidsCluster.transform(alignables);
		
		assertEquals(2, alignments.size());
	}

}
