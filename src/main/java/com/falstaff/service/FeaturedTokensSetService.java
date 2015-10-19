package com.falstaff.service;

import java.io.IOException;
import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.falstaff.core.aligner.ClustererContext;
import com.falstaff.core.aligner.ContentPropertiesFeatureAssigner;
import com.falstaff.core.aligner.Lexer;
import com.falstaff.core.aligner.MagicClustererContext;
import com.falstaff.core.aligner.NFilePropertiesFeatureAssigner;
import com.falstaff.core.classification.AlignedSignaturesSet;
import com.falstaff.core.classification.FeaturedSamplesSet;
import com.falstaff.core.classification.FeaturedSignature;
import com.falstaff.core.classification.FeaturedSignaturesSet;
import com.falstaff.core.classification.FeaturedTokensSet;
import com.falstaff.core.classification.FileFormat;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.feature.TokenFeature;
import com.falstaff.repository.dao.FeaturedTokensSetDao;
import com.falstaff.repository.dao.FileFormatDao;

@Service
public class FeaturedTokensSetService {

	private static final Logger log = LoggerFactory
	.getLogger(FeaturedTokensSetService.class.getName());

	@Autowired
	FeaturedTokensSetDao featuredTokensSetDao;
	
	@Autowired
	FileFormatDao fileFormatDao;
	
	@Autowired
	AsyncAligner asyncAligner;
	
	@Value("${falstaff.core.service.max_tokens_cutoff}")
	int maxTokensCutOff;
	
	public FeaturedTokensSet create(FeaturedTokensSet tokensSet) throws IOException {
		tokensSet.setCreated(Calendar.getInstance());
		tokensSet.setUpdated(tokensSet.getCreated());
		featuredTokensSetDao.save(tokensSet);
		return tokensSet;
	}
	
	public FeaturedTokensSet setFormat(FeaturedTokensSet tokensSet, FileFormat fileFormat) throws IOException {
		tokensSet.setFormat(fileFormat);
		fileFormat.updateTokensSet(tokensSet);
		return tokensSet;
	}
	
	public void save(FeaturedTokensSet tokensSet) throws IOException {
		featuredTokensSetDao.save(tokensSet);
	}
	
	public LexerContext defaultLexerContext(FeaturedSamplesSet samplesSet) {
		FeaturedTokensSet tokens = new FeaturedTokensSet(samplesSet.getName(), samplesSet.getFormat());
		LexerContext context = new LexerContext(maxTokensCutOff, tokens);
		return context;
	}
	
	public void lex(FeaturedSamplesSet samplesSet, LexerContext context) {
		ProcessMonitor processMonitor = new ProcessMonitor();
		samplesSet.setProcessMonitor(processMonitor);
		context.getTokensSet().setProcessMonitor(processMonitor);
		ContentPropertiesFeatureAssigner contentPropertiesFeatureAssigner = new ContentPropertiesFeatureAssigner();
		contentPropertiesFeatureAssigner.setProcessMonitor(processMonitor);
		Lexer lexer = new Lexer(context.getMaxTokensCutOff(), samplesSet.getFormat().getName());
		lexer.setProcessMonitor(processMonitor);
		lexer.setCleanAfterTransform(false);
		asyncAligner.lex(samplesSet, contentPropertiesFeatureAssigner, lexer, context);
		return;
	}
	
	public TokenFeature createTokenFeature(FeaturedTokensSet tokensSet, TokenFeature tokenFeature) throws IOException {
		tokensSet.addTokenFeature(tokenFeature);
		featuredTokensSetDao.save(tokensSet);
		return tokenFeature;
	}

}
