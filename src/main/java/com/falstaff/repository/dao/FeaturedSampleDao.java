package com.falstaff.repository.dao;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.falstaff.core.classification.FeaturedSample;

@Component
public class FeaturedSampleDao {

	private static final Logger log = LoggerFactory
	.getLogger(FeaturedSampleDao.class.getName());
	
	@Autowired
	private FeaturedSamplesSetDao featuredSamplesSetDao;
	
	public void save(FeaturedSample featuredSample) throws IOException {
		featuredSamplesSetDao.save(featuredSample.getSamplesSet());
	}

}
