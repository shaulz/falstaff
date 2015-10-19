package com.falstaff.service;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.falstaff.core.classification.IdentificationBatch.IdentificationBulk;

@Component
public class AsyncIdentifier {

	@Async
	public void identify(IdentificationBulk bulk) {
		bulk.identify();
	}

}
