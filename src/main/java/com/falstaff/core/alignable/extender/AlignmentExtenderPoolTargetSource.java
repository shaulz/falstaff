package com.falstaff.core.alignable.extender;

import org.springframework.aop.target.CommonsPoolTargetSource;

public class AlignmentExtenderPoolTargetSource extends CommonsPoolTargetSource {

	@Override
	public void passivateObject(Object obj) {
		((IAlignmentExtender)obj).clean();
		super.passivateObject(obj);
	}

}
