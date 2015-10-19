package com.falstaff.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.falstaff.crawler.FileFormatsCrawler;

@Component
public class AsyncOntologyUpdater {

	@Autowired
	FileFormatsCrawler fileFormatsCrawler;
	
	@Async
	public void update() throws IOException {
		fileFormatsCrawler.run();
	}

}
