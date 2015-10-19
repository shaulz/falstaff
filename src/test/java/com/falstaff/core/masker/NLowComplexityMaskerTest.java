package com.falstaff.core.masker;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;
import java.util.List;

import org.junit.Test;

import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.alignable.sequence.NScorableSequenceAlignable;
import com.falstaff.core.geometry1D.BoundedSegmentedLine;

public class NLowComplexityMaskerTest {

	@Test
	public void test() {
		byte[] bytes = {0x00, 0x11, 0x00, 0x00, 0x00, 0x11, 0x00, 0x00, 0x22, 0x33, 0x44, 0x33, 0x33, 0x33, 0x44, 0x33, 0x33};
		INScorableAlignable alignable = new NScorableSequenceAlignable(bytes);
		List<INScorableAlignable> alignables = new LinkedList<INScorableAlignable>();
		alignables.add(alignable);
		
		NLowComplexityMasker masker = new NLowComplexityMasker();
		
		masker.transformInternal(alignables);
		
		BoundedSegmentedLine mask = alignables.get(0).getMask();
		assertEquals(16, mask.length());
	}
}
