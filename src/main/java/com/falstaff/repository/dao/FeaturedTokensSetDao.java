package com.falstaff.repository.dao;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FeaturedSample;
import com.falstaff.core.classification.FeaturedTokensSet;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.feature.TokenFeature;

@Component
public class FeaturedTokensSetDao {

	private static final Logger log = LoggerFactory
	.getLogger(FeaturedTokensSetDao.class.getName());
	
	@Autowired
	private FileFormatDao formatDao;
	
	@PostConstruct
	public void init() throws IOException {
		List<FileFormat> formats = formatDao.getFormats();
		for (FileFormat format : formats) {
			List<FeaturedTokensSet> tokens = format.getTokens();
			if (tokens == null) {
				continue;
			}
			for (FeaturedTokensSet tokensSet : tokens) {
				setIds(tokensSet);
				//normalizeToken(TokensSet);
			}
		}
	}
	
	public void save(FeaturedSamplesSet featuredSamplesSet) throws IOException {
		formatDao.save(featuredSamplesSet.getFormat());
	}
	
	private void setIds(FeaturedTokensSet featuredTokensSet) {
		featuredTokensSet.setId();
		Set<TokenFeature> tokens = featuredTokensSet.getTokens();
		for (TokenFeature token : tokens) {
			token.setId();
		}
	}
	
	public void save(FeaturedTokensSet featuredTokensSet) throws IOException {
		formatDao.save(featuredTokensSet.getFormat());
	}
}
