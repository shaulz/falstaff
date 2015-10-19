package com.falstaff.core.alignable.extender;

import com.falstaff.core.alignable.extender.AlignmentExtender.Cell;

public interface IAlignmentExtender {

	public Cell extend(AlignmentExtenderContext context);
	public int score(AlignmentExtenderContext context);
	public void clean();
}