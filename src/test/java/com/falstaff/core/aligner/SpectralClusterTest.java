package com.falstaff.core.aligner;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.falstaff.FalstaffApplication;
import com.falstaff.core.alignable.INMultipleAlignment;
import com.falstaff.core.alignable.sequence.NScorableSequenceAlignable;
import com.falstaff.core.aligner.cluster.NSpectralCluster;
import com.falstaff.core.lookup.ktup.IScorableKtup;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.EntropyScoreCalculator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FalstaffApplication.class)
public class SpectralClusterTest {
	
	@Autowired
	@Qualifier("spectralCluster")
	NSpectralCluster spectralCluster;

	@Test
	public void testPartitions() {
		byte[] s1 = {112, 111, 101, 102, 103, 104, 105, 106, 107, 108, 109 };
		byte[] s2 = {112, 111, 101, 102, 103, 104, 105, 106, 107, 108, 109 };
		byte[] s3 = {112, 111, 101, 102, 103, 104, 105, 106, 107, 108, 109 };
		byte[] s4 = {112, 111, 101, 102, 103, 104, 105, 106, 107, 120, 109 };
		byte[] s5 = {112, 111, 101, 102, 103, 104, 105, 106, 107, 120, 109 };
		byte[] s6 = {112, 111, 101, 102, 103, 104, 105, 106, 107, 108, 109 };
		byte[] s7 = {99, 100, 101, 102, 103, 104, 105, 110, 110, 110, 110 };
		byte[] s8 = {99, 100, 101, 102, 103, 104, 105, 110, 110, 110, 110 };

		NScorableSequenceAlignable a1 = new NScorableSequenceAlignable(s1);
		NScorableSequenceAlignable a2 = new NScorableSequenceAlignable(s2);
		NScorableSequenceAlignable a3 = new NScorableSequenceAlignable(s3);
		NScorableSequenceAlignable a4 = new NScorableSequenceAlignable(s4);
		NScorableSequenceAlignable a5 = new NScorableSequenceAlignable(s5);
		NScorableSequenceAlignable a6 = new NScorableSequenceAlignable(s6);
		NScorableSequenceAlignable a7 = new NScorableSequenceAlignable(s7);
		NScorableSequenceAlignable a8 = new NScorableSequenceAlignable(s8);

		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());
		distribution.add(a3.byteIterator());
		distribution.add(a4.byteIterator());
		distribution.add(a5.byteIterator());
		distribution.add(a6.byteIterator());
		distribution.add(a7.byteIterator());
		distribution.add(a8.byteIterator());

		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution,8,25);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);
		a3.setScoreCalculator(scoreCalculator);
		a4.setScoreCalculator(scoreCalculator);
		a5.setScoreCalculator(scoreCalculator);
		a6.setScoreCalculator(scoreCalculator);
		a7.setScoreCalculator(scoreCalculator);
		a8.setScoreCalculator(scoreCalculator);
		
		IScorableKtup k1 = a1.getKtup(2, 4);
		IScorableKtup k2 = a2.getKtup(2, 4);
		IScorableKtup k3 = a3.getKtup(2, 4);
		IScorableKtup k4 = a4.getKtup(2, 4);
		IScorableKtup k5 = a5.getKtup(2, 4);
		IScorableKtup k6 = a6.getKtup(2, 4);
		IScorableKtup k7 = a7.getKtup(2, 4);
		IScorableKtup k8 = a7.getKtup(2, 4);
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		ktups.add(k1);
		ktups.add(k2);
		ktups.add(k3);
		ktups.add(k4);
		ktups.add(k5);
		ktups.add(k6);
		ktups.add(k7);
		ktups.add(k8);
		
		spectralCluster.cluster(ktups);
	
		int[] clusters = spectralCluster.getCluster();
		assertEquals(1, clusters[0]);
		assertEquals(1, clusters[1]);
		assertEquals(1, clusters[2]);
		assertEquals(1, clusters[3]);
		assertEquals(1, clusters[4]);
		assertEquals(1, clusters[5]);
		assertEquals(0, clusters[6]);
		assertEquals(0, clusters[7]);
		
	}
	
	@Test
	public void testManySequences() {
		int n = 1000;
		byte[][] s = new byte[n][];
		for (int i = 0; i < n/2; i++) {
			s[i] = new byte[]{112, 111, 101, 102, 103, 104, 105, 106, 107, 108, 109 };
		}
		for (int i = n/2; i < n; i++) {
			s[i] = new byte[]{99, 100, 101, 102, 103, 104, 105, 110, 110, 110, 110 };
		}
		
		NScorableSequenceAlignable[] a = new NScorableSequenceAlignable[n];
		ByteDistribution distribution = new ByteDistribution();
		for (int i = 0; i < n; i++) {
			a[i] = new NScorableSequenceAlignable(s[i]);
			distribution.add(a[i].byteIterator());
		}
		
		EntropyScoreCalculator scoreCalculator = new EntropyScoreCalculator(distribution,n,25);
		IScorableKtup[] k = new IScorableKtup[n];
		List<IScorableKtup> ktups = new ArrayList<IScorableKtup>();
		for (int i = 0; i < n; i++) {
			a[i].setScoreCalculator(scoreCalculator);
			k[i] = a[i].getKtup(2, 4);
			ktups.add(k[i]);
		}
		
		List<INMultipleAlignment> alignments = spectralCluster.cluster(ktups);
	
		int[] clusters = spectralCluster.getCluster();
		for (int i = 0; i < clusters.length; i++) {
			if (i < n/2) {
				assertEquals(1, clusters[i]);
			}
			else {
				assertEquals(0, clusters[i]);
			}
			System.out.println(clusters[i] + "\n");
		}
		
		assertEquals(2, alignments.size());
		assertEquals("cdefghinnnn", alignments.get(0).getChars(0, alignments.get(0).length() - 1));
		assertEquals("poefghijklm", alignments.get(1).getChars(0, alignments.get(1).length() - 1));

	}
}
