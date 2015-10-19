package com.falstaff.repository.dao;

import java.io.IOException;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FeaturedSample;
import com.falstaff.core.classification.FeaturedSignature;
import com.falstaff.core.classification.FeaturedSignaturesSet;
import com.falstaff.core.classification.FileFormat;

@Component
public class FeaturedSignaturesSetDao {

	private static final Logger log = LoggerFactory
	.getLogger(FeaturedSignaturesSetDao.class.getName());
	
	@Autowired
	private FileFormatDao formatDao;
	
	@PostConstruct
	public void init() throws IOException {
		List<FileFormat> formats = formatDao.getFormats();
		for (FileFormat format : formats) {
			List<FeaturedSignaturesSet> signatures = format.getSignatures();
			if (signatures == null) {
				continue;
			}
			for (FeaturedSignaturesSet signaturesSet : signatures) {
				setIds(signaturesSet);
				//normalizeSignature(signaturesSet);
			}
		}
	}
	
	public void save(FeaturedSamplesSet featuredSamplesSet) throws IOException {
		formatDao.save(featuredSamplesSet.getFormat());
	}
	
	private void setIds(FeaturedSignaturesSet featuredSignaturesSet) {
		featuredSignaturesSet.setId();
		List<FeaturedSignature> signatures = featuredSignaturesSet.getSignatures();
		for (FeaturedSignature signature : signatures) {
			signature.setId();
			signature.getSignature().setSignatureId();
		}
	}
	
	private void normalizeSignature(FeaturedSignaturesSet featuredSignaturesSet) throws IOException {
		featuredSignaturesSet.setId();
		boolean normalized = false;
		List<FeaturedSignature> signatures = featuredSignaturesSet.getSignatures();
		for (FeaturedSignature signature : signatures) {
			normalized = normalized || signature.getSignature().normalizeRegularExpression();
		}
		
		if (normalized) {
			save(featuredSignaturesSet);
		}
	}
	
	public void save(FeaturedSignaturesSet featuredSignaturesSet) throws IOException {
		formatDao.save(featuredSignaturesSet.getFormat());
	}
}
