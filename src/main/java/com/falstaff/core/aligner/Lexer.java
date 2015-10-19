package com.falstaff.core.aligner;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.falstaff.core.alignable.INFeaturedAlignable;
import com.falstaff.core.antlr.TokensSelector;
import com.falstaff.core.classification.FeaturedSample;
import com.falstaff.core.feature.TokenFeature;

public class Lexer extends
		NAbstractAligner<INFeaturedAlignable, INFeaturedAlignable> {

	private static final Logger log = LoggerFactory.getLogger(Lexer.class
			.getName());
	private static Map<String, Set<TokenFeature>> comments;
	
	static {
		comments = new HashMap<String, Set<TokenFeature>>();
		comments.put("c", new HashSet<TokenFeature>(Arrays.asList(new TokenFeature("/*"), new TokenFeature("*/"),new TokenFeature("//"))));
		comments.put("java", new HashSet<TokenFeature>(Arrays.asList(new TokenFeature("/*"), new TokenFeature("*/"),new TokenFeature("//"))));
	}
	
	private int maxTokensCutOff = -1;
	private String language;
	private Set<TokenFeature> features;

	public Lexer(int maxTokensCutOff, String language) {
		super();
		this.maxTokensCutOff = maxTokensCutOff;
		this.language = (language != null ? language.toLowerCase() : language);
		features = new HashSet<TokenFeature>();
	}

	@Override
	public Collection<? extends INFeaturedAlignable> transformInternal(
			Collection<? extends INFeaturedAlignable> alignables) {
			TokensSelector selector = new TokensSelector(maxTokensCutOff, language);
			selector.setProcessMonitor(processMonitor);
		setProcessName("generating 1-gram");
		int count = 0;
		for (INFeaturedAlignable alignable : alignables) {
			count++;
			setPercentageCompleted(count * 100 / alignables.size());
			if (!alignable.isText()) {
				log.warn("can not lex alignable that is not text " + alignable.getFileName());
				continue;
			}
			String project = ((FeaturedSample)alignable).getProject();
			try {
				selector.addSample(((FeaturedSample)alignable).getFile(), project, alignable.getEncoding());
			} catch (Exception e) {
				log.error("tokens extraction failed for sample " + ((FeaturedSample)alignable).getPath() + " " + e.getMessage());
			}
		}
		
		try {
			features.addAll(selector.getTokensAll());
			if (comments.containsKey(language)) {
				features.addAll(comments.get(language));
			}
		} catch (Exception e) {
			log.error("tokens extraction failed " + e.getMessage());
		}
		
		return alignables;
	}

	@Override
	public void clear() {
		features.clear();
		language = null;
	}

	@Override
	public String getName() {
		return "lexer";
	}

	public int getMaxTokensCutOff() {
		return maxTokensCutOff;
	}

	public void setMaxTokensCutOff(int maxTokensCutOff) {
		this.maxTokensCutOff = maxTokensCutOff;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Set<TokenFeature> getFeatures() {
		return features;
	}
}
