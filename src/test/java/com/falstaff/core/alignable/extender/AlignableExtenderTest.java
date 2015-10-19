package com.falstaff.core.alignable.extender;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.falstaff.FalstaffApplication;
import com.falstaff.core.alignable.extender.AlignmentExtender.Cell;
import com.falstaff.core.alignable.sequence.NScorableSequenceAlignable;
import com.falstaff.core.score.ByteDistribution;
import com.falstaff.core.score.ProbabilityScoreCalculator;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = FalstaffApplication.class)
public class AlignableExtenderTest {
	
	@Resource(name="alignmentExtender")
	IAlignmentExtender alignmentExtender;

	@Test
	public void test() {
		byte[] s1 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		byte[] s2 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };

		NScorableSequenceAlignable a1 = new NScorableSequenceAlignable(s1);
		NScorableSequenceAlignable a2 = new NScorableSequenceAlignable(s2);

		ByteDistribution distribution = new ByteDistribution();
		distribution.add(a1.byteIterator());
		distribution.add(a2.byteIterator());

		ProbabilityScoreCalculator scoreCalculator = new ProbabilityScoreCalculator(
				-2, -3, distribution);
		a1.setScoreCalculator(scoreCalculator);
		a2.setScoreCalculator(scoreCalculator);

		// right

		// full alignment
		//AlignmentExtender extender = new AlignmentExtender(4);
		IAlignmentExtender extender = (IAlignmentExtender)alignmentExtender;
		AlignmentExtenderContext context = new AlignmentExtenderContext(a1, 3, a2, 3,
				AlignmentExtender.Direction.DIRECTION_RIGHT, -12, 100);
		Cell cell = extender.extend(new AlignmentExtenderContext(a1, 3, a2, 3,
				AlignmentExtender.Direction.DIRECTION_RIGHT, -12, 100));
		check(cell, 30, 9, 9, 4, 4, 6,context);

		// end

		// substitution at the end
		byte[] s3 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 111 };
		a2.setSequence(s3);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 25, 8, 8, 4, 4, 5,context);

		// insertion one before the end
		byte[] s4 = { 101, 102, 103, 104, 105, 106, 107, 108, 110 };
		a2.setSequence(s4);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 22, 9, 8, 4, 4, 6,context);

		// deletion one before the end
		byte[] s5 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 111, 110 };
		a2.setSequence(s5);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 27, 9, 10, 4, 4, 7,context);

		// substitution one before the end
		byte[] s6 = { 101, 102, 103, 104, 105, 106, 107, 108, 112, 110 };
		a2.setSequence(s6);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 23, 9, 9, 4, 4, 6,context);

		// start

		// substitution at the start
		byte[] s7 = { 101, 102, 103, 104, 111, 106, 107, 108, 109, 110 };
		a2.setSequence(s7);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 23, 9, 9, 4, 4, 6,context);

		// insertion at the start
		byte[] s8 = { 101, 102, 103, 104, 106, 107, 108, 109, 110 };
		a2.setSequence(s8);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 22, 9, 8, 4, 3, 6,context);

		// deletion one before the start
		byte[] s9 = { 101, 102, 103, 104, 111, 105, 106, 107, 108, 109, 110 };
		a2.setSequence(s9);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 27, 9, 10, 3, 4, 7,context);

		// substitution every second
		byte[] s10 = { 101, 102, 103, 104, 111, 106, 112, 108, 113, 110 };
		a2.setSequence(s10);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 9, 9, 9, 4, 4, 6,context);

		// droping
		byte[] s11 = { 101, 102, 103, 104, 111, 112, 113, 114, 115, 116, 117,
				118, 119, 120, 105, 106, 107, 108, 109, 110 };
		a2.setSequence(s11);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		assertNull(cell);

		// left
		
		context = new AlignmentExtenderContext(a1, 6, a2, 6,
				AlignmentExtender.Direction.DIRECTION_LEFT, -12, 100);

		// full alignment
		byte[] s13 = { 101, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		a2.setSequence(s13);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 30, 0, 0, 5, 5, 6,context);

		// end

		// substitution at the end
		byte[] s12 = { 99, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		a2.setSequence(s12);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 25, 1, 1, 5, 5, 5,context);

		// insertion one before the end
		byte[] s14 = { 101, 103, 104, 105, 106, 107, 108, 110 };
		a2.setSequence(s14);
		context.setAlignableY(a2);
		context.setAlignableYAlignedTo(5);		
		cell = extender.extend(context);
		check(cell, 22, 0, 0, 5, 4, 6,context);

		// deletion one before the end
		byte[] s15 = { 101, 111, 102, 103, 104, 105, 106, 107, 108, 109, 110 };
		a2.setSequence(s15);
		context.setAlignableY(a2);
		context.setAlignableYAlignedTo(7);		
		cell = extender.extend(context);
		check(cell, 27, 0, 0, 5, 6, 7,context);

		// substitution one before the end
		byte[] s16 = { 101, 111, 103, 104, 105, 106, 107, 108, 109, 110 };
		a2.setSequence(s16);
		context.setAlignableY(a2);
		context.setAlignableYAlignedTo(6);		
		cell = extender.extend(context);
		check(cell, 23, 0, 0, 5, 5, 6,context);

		// start

		// substitution at the start
		byte[] s17 = { 101, 102, 103, 104, 105, 111, 107, 108, 109, 110 };
		a2.setSequence(s17);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		check(cell, 23, 0, 0, 5, 5, 6,context);

		// insertion at the start
		byte[] s18 = { 101, 102, 103, 104, 105, 107, 108, 109, 110 };
		a2.setSequence(s18);
		context.setAlignableY(a2);
		context.setAlignableYAlignedTo(5);		
		cell = extender.extend(context);
		check(cell, 22, 0, 0, 5, 5, 6,context);

		// deletion one before the start
		byte[] s19 = { 101, 102, 103, 104, 105, 106, 111, 107, 108, 109, 110 };
		a2.setSequence(s19);
		context.setAlignableY(a2);
		context.setAlignableYAlignedTo(7);		
		cell = extender.extend(context);
		check(cell, 27, 0, 0, 6, 6, 7,context);

		// substitution every second
		byte[] s20 = { 101, 113, 103, 112, 105, 111, 107, 108, 109, 110 };
		a2.setSequence(s20);
		context.setAlignableY(a2);
		context.setAlignableYAlignedTo(6);		
		cell = extender.extend(context);
		check(cell, 9, 0, 0, 5, 5, 6,context);

		// droping
		byte[] s21 = { 101, 102, 103, 104, 105, 106, 111, 112, 113, 114, 115, 116, 117,
				118, 119, 120, 107, 108, 109, 110 };
		a2.setSequence(s21);
		context.setAlignableYAlignedTo(16);
		context.setAlignableY(a2);		
		cell = extender.extend(context);
		assertNull(cell);

	}
	

	private void check(Cell cell, int score, int lastX, int lastY, int firstX,
			int firstY, int length, AlignmentExtenderContext context) {
		assertEquals(score, cell.getScore());
		assertEquals(lastX, cell.getAlignableXIndexStart(context));
		assertEquals(lastY, cell.getAlignableYIndexStart(context));
		int actualLength = 1;
		Cell previousCell = cell.getPreviousCell();
		while (previousCell.getPreviousCell() != null) {
			actualLength++;
			cell = previousCell;
			previousCell = cell.getPreviousCell();
		}
		assertEquals(length, actualLength);
		assertEquals(firstX, cell.getAlignableXIndexStart(context));
		assertEquals(firstY, cell.getAlignableYIndexStart(context));
	}

}
