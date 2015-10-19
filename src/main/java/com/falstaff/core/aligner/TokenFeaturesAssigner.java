package com.falstaff.core.aligner;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import all.AllLexer;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.antlr.Tokenizer;
import com.falstaff.core.feature.TokenFeature;
import com.falstaff.core.lookup.ktup.IKtup;

public class TokenFeaturesAssigner extends NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> {
	
	private static final Logger log = LoggerFactory
			.getLogger(TokenFeaturesAssigner.class.getName());

	private Set<TokenFeature> features;
	private Map<String, TokenFeature> featuresMap;

	public TokenFeaturesAssigner(Set<TokenFeature> features) {
		super();
		this.features = features;
		featuresMap = new HashMap<String, TokenFeature>();
		for (TokenFeature feature : features) {
			featuresMap.put(feature.getName(), feature);
		}
	}

	@Override
	public Collection<? extends INFeaturedAlignable> transformInternal(
			Collection<? extends INFeaturedAlignable> formatFiles) {
		int assignedFormatFilesCount = 0;
		for (INFeaturedAlignable formatFile : formatFiles) {
			if (formatFile.length() > 0) {
				try {
					assign(formatFile);
				} catch (IOException e) {
					log.error("token features assignment to file " + formatFile.getFileName() + " failed " + e.getMessage());
				}
			}
			assignedFormatFilesCount++;
			if (processMonitor != null) {
				processMonitor.setPercentageCompleted(assignedFormatFilesCount * 100 / formatFiles.size());
			}
			log.debug("number of token features assigned to file " + formatFile.getFileName() + " is " + (formatFile.getFeatures() != null ? formatFile.getFeatures().size() : 0));
		}
		return formatFiles;
	}
	
	private void assign(INFeaturedAlignable<IKtup> formatFile) throws IOException {
		if (!formatFile.isText()) {
			log.warn("can not lex alignable that is not text " + formatFile.getFileName());
			return;
		}
		
		Tokenizer tokenizer = new Tokenizer();
		List<Token> tokens = tokenizer.getTokens(formatFile.charSequence().getSequence(), formatFile.getEncoding());

		String firstToken = Tokenizer.BOF;
		int firstTokenType = AllLexer.SignSequence;
		String space = "";
		Set<TokenFeature> fileTokenFeatures = new HashSet<TokenFeature>();
		TokenFeature tokenFeature;
		for (Token token : tokens) {
			boolean firstTokenSet = (firstToken != null);
			if (token.getType() == AllLexer.Whitespace) {
				if (space.isEmpty()) {
					space = Tokenizer.SPACE;
				}
				continue;
			}
			if (token.getType() == AllLexer.Newline) {
				space = Tokenizer.NEW_LINE;
				continue;
			}
			String text = null;
			if (token.getType() == AllLexer.DigitSequence) {
				if (firstToken == null) {
					firstToken = Tokenizer.DIGITS;
				}
				else {
					text = Tokenizer.DIGITS;
				}
				tokenFeature = new TokenFeature(Tokenizer.DIGITS);
				if (features.contains(tokenFeature)) {
					fileTokenFeatures.add(featuresMap.get(tokenFeature.getName()));
				}
			}
			if (token.getType() == AllLexer.HexadecimalDigitSequence) {
				if (firstToken == null) {
					firstToken = Tokenizer.HEXA_DIGITS;
				}
				else {
					text = Tokenizer.HEXA_DIGITS;
				}
				tokenFeature = new TokenFeature(Tokenizer.HEXA_DIGITS);
				if (features.contains(tokenFeature)) {
					fileTokenFeatures.add(featuresMap.get(tokenFeature.getName()));
				}
			}
			if (token.getType() == AllLexer.AlphaSequence) {
				String textTemp = token.getText();
				tokenFeature = new TokenFeature(textTemp);
				if (features.contains(tokenFeature)) {
					fileTokenFeatures.add(featuresMap.get(tokenFeature.getName()));
				}
				else {
					textTemp = Tokenizer.ALPHA;
					tokenFeature = new TokenFeature(Tokenizer.ALPHA);
					if (features.contains(tokenFeature)) {
						fileTokenFeatures.add(featuresMap.get(tokenFeature.getName()));
					}
				}
				if (firstToken == null) {
					firstToken = textTemp;
				}
				else {
					text = textTemp;
				}
			}
			if (token.getType() == AllLexer.SignSequence) {
				String textTemp = token.getText();
				tokenFeature = new TokenFeature(textTemp);
				if (features.contains(tokenFeature)) {
					fileTokenFeatures.add(featuresMap.get(tokenFeature.getName()));
				}
				else {
					textTemp = Tokenizer.SIGN;
					tokenFeature = new TokenFeature(Tokenizer.SIGN);
					if (features.contains(tokenFeature)) {
						fileTokenFeatures.add(featuresMap.get(tokenFeature.getName()));
					}
				}
				if (firstToken == null) {
					firstToken = textTemp;
				}
				else {
					text = textTemp;
				}
			}
			
			if (firstTokenSet && text == null) {
				firstToken = null;
				space = "";
				continue;
			}
			
			if (firstToken != null && token != null) {
				tokenFeature = new TokenFeature(firstToken, text, space);
				if (features.contains(tokenFeature)) {
					fileTokenFeatures.add(featuresMap.get(tokenFeature.getName()));
				}
			}
			
			firstToken = text;
			firstTokenType = token.getType();
			space = "";
		}
		
		for (TokenFeature feature : fileTokenFeatures) {
			formatFile.addFeature(feature);
		}
	}
	
	@Override
	public void clear() {
	}
	
	@Override
	public String getName() {
		return "token features assigner";
	}
		
}
