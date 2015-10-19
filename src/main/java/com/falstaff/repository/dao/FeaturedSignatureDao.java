package com.falstaff.repository.dao;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.falstaff.core.classification.FeaturedSignature;

@Component
public class FeaturedSignatureDao {

	private static final Logger log = LoggerFactory
	.getLogger(FeaturedSignatureDao.class.getName());
	
	@Autowired
	private FeaturedSignaturesSetDao featuredSignaturesSetDao;
	
	public void save(FeaturedSignature featuredSignature) throws IOException {
		featuredSignaturesSetDao.save(featuredSignature.getSignaturesSet());
	}
}
