package com.falstaff.core.alignable.sequence;

import java.util.Set;

import com.falstaff.core.alignable.INScorableAlignable;
import com.falstaff.core.score.IScoreCalculator;

public class NAlignmentScoreCalculator {

	private IScoreCalculator scoreCalculator;
	
	public int matchScore(INScorableAlignable alignableThis, int columnThis, INScorableAlignable other, int columnOther) {		
		int score = alignableThis.getScore(columnThis) + other.getScore(columnOther);
		
		Set<INScorableAlignable> alignedThisAll = alignableThis.getAligned();
		Set<INScorableAlignable> alignedOtherAll = other.getAligned();
		for (INScorableAlignable alignedThis : alignedThisAll) {
			Byte byteThis = alignableThis.getAlignedByte(alignedThis, columnThis);
			if (alignedOtherAll.contains(alignedThis)) {
				throw new RuntimeException("can not align alignables containing same aligned");
			}
			for (INScorableAlignable alignedOther : alignedOtherAll) {
				Byte byteOther = other.getAlignedByte(alignedOther, columnOther);
				score += scoreCalculator.score(byteThis, byteOther);
			}
		}
		return score;
	}

	public int insertionScore(INScorableAlignable alignableThis, int columnThis, INScorableAlignable other, int columnOther) {
		int score = alignableThis.getScore(columnThis);
		Set<INScorableAlignable> alignedThisAll = alignableThis.getAligned();
		int alignedOtherAllCount = other.getAlignedCount();
		for (INScorableAlignable alignedThis : alignedThisAll) {
			Byte byteThis = alignableThis.getAlignedByte(alignedThis, columnThis);
			for (int i = 0; i < alignedOtherAllCount; i++) {
				score += scoreCalculator.score(byteThis, null);
			}
		}
		return score;
	}

	public int deletionScore(INScorableAlignable alignableThis, int columnThis, INScorableAlignable other, int columnOther) {
		return other.insertionScore(columnOther, alignableThis, columnThis);
	}

	public IScoreCalculator getScoreCalculator() {
		return scoreCalculator;
	}

	public void setScoreCalculator(IScoreCalculator scoreCalculator) {
		this.scoreCalculator = scoreCalculator;
	}
}
