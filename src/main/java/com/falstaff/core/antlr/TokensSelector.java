package com.falstaff.core.antlr;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.antlr.v4.runtime.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.standard.expression.Token.TokenParsingTracer;

import all.AllLexer;

import com.falstaff.core.execution.IProcessMonitor;
import com.falstaff.core.execution.ProcessMonitor;
import com.falstaff.core.execution.ProcessStatus;
import com.falstaff.core.feature.TokenFeature;
import com.falstaff.core.util.Histogram;

public class TokensSelector implements IProcessMonitor {
	
	private static final Logger log = LoggerFactory
			.getLogger(TokensSelector.class.getName());
	
	private class TwoGram {
		private String text1;
		private int type1;
		private String text2;
		private int type2;
		private String space;
		
		public TwoGram(String text1, int type1, String text2, int type2,
				String space) {
			super();
			this.text1 = text1;
			this.type1 = type1;
			this.text2 = text2;
			this.type2 = type2;
			this.space = space;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((space == null) ? 0 : space.hashCode());
			result = prime * result + ((text1 == null) ? 0 : text1.hashCode());
			result = prime * result + ((text2 == null) ? 0 : text2.hashCode());
			result = prime * result + type1;
			result = prime * result + type2;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TwoGram other = (TwoGram) obj;
			if (space == null) {
				if (other.space != null)
					return false;
			} else if (!space.equals(other.space))
				return false;
			if (text1 == null) {
				if (other.text1 != null)
					return false;
			} else if (!text1.equals(other.text1))
				return false;
			if (text2 == null) {
				if (other.text2 != null)
					return false;
			} else if (!text2.equals(other.text2))
				return false;
			if (type1 != other.type1)
				return false;
			if (type2 != other.type2)
				return false;
			return true;
		}

		public String getText1() {
			return text1;
		}

		public void setText1(String text1) {
			this.text1 = text1;
		}

		public int getType1() {
			return type1;
		}

		public void setType1(int type1) {
			this.type1 = type1;
		}

		public String getText2() {
			return text2;
		}

		public void setText2(String text2) {
			this.text2 = text2;
		}

		public int getType2() {
			return type2;
		}

		public void setType2(int type2) {
			this.type2 = type2;
		}

		public String getSpace() {
			return space;
		}

		public void setSpace(String space) {
			this.space = space;
		}
		
		public TwoGram filter(int projectsCount) {
			String text1Filtered = text1;
			String text2Filtered = text2;
			if (type1 == AllLexer.AlphaSequence && alphaTokenProjectsCount.get(text1Filtered) < projectsCount) {
				text1Filtered = Tokenizer.ALPHA;
			}
			if (type1 == AllLexer.SignSequence && signTokenProjectsCount.get(text1Filtered) < projectsCount) {
				text1Filtered = Tokenizer.SIGN;
			}
			
			if (type2 == AllLexer.AlphaSequence && alphaTokenProjectsCount.get(text2Filtered) < projectsCount) {
				text2Filtered = Tokenizer.ALPHA;
			}
			if (type2 == AllLexer.SignSequence && signTokenProjectsCount.get(text2Filtered) < projectsCount) {
				text2Filtered = Tokenizer.SIGN;
			}
			
			if (!text1.equals(text1Filtered) || !text2.equals(text2Filtered)) {
				TwoGram twoGramFiltered = new TwoGram(text1Filtered, type1, text2Filtered, type2, space);
				return twoGramFiltered;
			}
			return this;
		}
		
	}

	private Histogram<String> alphaTokenCount = new Histogram<String>();
	private Histogram<String> alphaTokenFilesCount = new Histogram<String>();
	private Histogram<String> alphaTokenProjectsCount = new Histogram<String>();
	private Histogram<String> signTokenCount = new Histogram<String>();
	private Histogram<String> signTokenFilesCount = new Histogram<String>();
	private Histogram<String> signTokenProjectsCount = new Histogram<String>();
	private Map<String, Set<String>> projectTokens = new HashMap<String,Set<String>>();
	private Set<String> tokensAll = new HashSet<String>();
	private Map<File, String> filesAll = new HashMap<File, String>();
	private int maxTokensCutOff = -1;
	private String language;
	private Set<String> projects = new HashSet<String>();
	protected IProcessMonitor processMonitor = null;

	
	public TokensSelector(int maxTokensCutOff, String language) {
		super();
		this.maxTokensCutOff = maxTokensCutOff;
		this.language = language;
	}

	public void addSample(File file, String project, String encoding) throws IOException {
		filesAll.put(file, encoding);
		projects.add(project);
		Tokenizer tokenizer = new Tokenizer();
		Set<String> fileTokens =  new HashSet<String>();
		List<Token> tokens = tokenizer.getTokens(file, language, encoding);
		for (Token token : tokens) {
			String text = token.getText();
			if (!projectTokens.containsKey(project)) {
				projectTokens.put(project, new HashSet<String>());
			}
			if (!projectTokens.get(project).contains(text)) {
				projectTokens.get(project).add(text);
				
				if (token.getType() == AllLexer.AlphaSequence) {
					alphaTokenProjectsCount.increment(text);
				}
				if (token.getType() == AllLexer.SignSequence) {
					signTokenProjectsCount.increment(text);
				}
			}
			
			if (!fileTokens.contains(text)) {
				fileTokens.add(text);
				if (token.getType() == AllLexer.AlphaSequence) {
					alphaTokenFilesCount.increment(text);
				}
				if (token.getType() == AllLexer.SignSequence) {
					signTokenFilesCount.increment(text);
				}
			}
			
			if (token.getType() == AllLexer.AlphaSequence) {
				alphaTokenCount.increment(text);
			}
			
			if (token.getType() == AllLexer.SignSequence) {
				signTokenCount.increment(text);
			}
			
			tokensAll.add(text);
		}
		
		signTokenCount.incrementN(Tokenizer.BOF, filesAll.size());
		signTokenFilesCount.incrementN(Tokenizer.BOF, filesAll.size()); 
		signTokenProjectsCount.incrementN(Tokenizer.BOF, projects.size()); 
	}
	
	public int getPercentageCompleted() {
		return processMonitor.getPercentageCompleted();
	}

	public void setPercentageCompleted(int percentageCompleted) {
		processMonitor.setPercentageCompleted(percentageCompleted);
	}

	public String getProcessName() {
		return processMonitor.getProcessName();
	}

	public void setProcessName(String processName) {
		processMonitor.setProcessName(processName);
	}

	public Calendar getStarted() {
		return processMonitor.getStarted();
	}

	public void setStarted(Calendar started) {
		processMonitor.setStarted(started);
	}

	public ProcessStatus getStatus() {
		return processMonitor.getStatus();
	}

	public void setStatus(ProcessStatus status) {
		processMonitor.setStatus(status);
	}

	private Set<String> filterByProjectsCount(int projectsCount) {
		Set<String> tokensAllFiltered = new HashSet<String>();
		for (String text : alphaTokenProjectsCount.keys()) {
			if (alphaTokenProjectsCount.get(text) >= projectsCount) {
				tokensAllFiltered.add(text);
			}
		}
		
		for (String text : signTokenProjectsCount.keys()) {
			if (signTokenProjectsCount.get(text) >= projectsCount) {
				tokensAllFiltered.add(text);
			}
		}
		
		return tokensAllFiltered;
	}
	
	private Set<String>  filterByFilesCount(int filesCount) {
		Set<String> tokensAllFiltered = new HashSet<String>(tokensAll);
		for (String text : alphaTokenFilesCount.keys()) {
			if (alphaTokenFilesCount.get(text) < filesCount) {
				tokensAllFiltered.remove(text);
			}
		}
		
		for (String text : signTokenFilesCount.keys()) {
			if (signTokenFilesCount.get(text) < filesCount) {
				tokensAllFiltered.remove(text);
			}
		}
		
		return tokensAllFiltered;
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
	
	private Set<TwoGram> filterByProjectsCount(int projectsCutoff, Set<TwoGram> grams) {
		Set<TwoGram> filteredGrams = new HashSet<TwoGram>();
		for (TwoGram gram : grams) {
			TwoGram gramFiltered = gram.filter(projectsCutoff);
			filteredGrams.add(gramFiltered);
		}
		return filteredGrams;
	}

	public Set<TokenFeature> getTokensAll() throws IOException {
		setProcessName("generating 2-gram");
		setStatus(ProcessStatus.PROCESS_STARTED);
		setPercentageCompleted(0);
		alphaTokenProjectsCount.incrementN(Tokenizer.ALPHA, projects.size());
		signTokenProjectsCount.incrementN(Tokenizer.SIGN, projects.size());

		Set<String> lowTokensFiltered = new HashSet<String>(tokensAll);
		int lowTokensCount = lowTokensFiltered.size();
		Set<TwoGram> lowGrams = get2Grams();
		
		if (maxTokensCutOff == -1 || maxTokensCutOff >= (lowTokensCount + lowGrams.size())) {
			return getTokensAll(lowTokensFiltered, lowGrams);
		}
		
		int lowProjectsCutoff = 1;
		int highProjectsCutoff = projects.size();
		
		Set<String> highTokensFiltered = filterByProjectsCount(highProjectsCutoff);
		int highTokensCount = highTokensFiltered.size();
		Set<TwoGram> highGrams = filterByProjectsCount(highProjectsCutoff, lowGrams);
		
		while (Math.abs(lowProjectsCutoff - highProjectsCutoff) > 1) {
			setPercentageCompleted(maxTokensCutOff * 100 / (lowTokensCount + lowGrams.size()));
			
			int projectsCutoff = (lowProjectsCutoff + highProjectsCutoff) / 2;
			Set<String> tokensFiltered = filterByProjectsCount(projectsCutoff);
			int tokensCount = tokensFiltered.size();
			Set<TwoGram> grams = filterByProjectsCount(projectsCutoff, lowGrams);
			
			if (maxTokensCutOff < tokensCount + grams.size()) {
				lowProjectsCutoff = projectsCutoff;
				lowTokensFiltered = tokensFiltered;
				lowTokensCount = tokensCount;
				lowGrams = grams;
			}
			else {
				highProjectsCutoff = projectsCutoff;
				highTokensFiltered = tokensFiltered;
				highTokensCount = tokensCount;
				highGrams = grams;
			}
			
			log.info("for " + projectsCutoff + " cutoff number of tokens is " + tokensCount + " number of 2-grams is " + grams.size());
		}
		
		setStatus(ProcessStatus.PROCESS_FINISHED);
		
		log.info("final number of tokens is " + highTokensCount + " number of 2-grams is " + highGrams.size());
		return getTokensAll(highTokensFiltered, highGrams);
	}
	
	
	
	private Set<TokenFeature> getTokensAll(Set<String> tokens, Set<TwoGram> grams) {
		Set<TokenFeature> features = new HashSet<TokenFeature>();
		for (String token : tokens) {
			TokenFeature feature = new TokenFeature(token);
			features.add(feature);
		}
		
		for (TwoGram gram : grams) {
			TokenFeature feature = new TokenFeature(gram.getText1(), gram.getText2(), gram.getSpace());
			features.add(feature);
		}
		
		return features;
	}

	public Set<TwoGram> get2Grams() throws IOException {
		Set<TwoGram> grams = new HashSet<TwoGram>();
		
		for (File file : filesAll.keySet()) {
			String firstToken = Tokenizer.BOF;
			int firstTokenType = AllLexer.SignSequence;
			String space = "";
			Tokenizer tokenizer = new Tokenizer();
			List<Token> tokens = tokenizer.getTokens(file, language, filesAll.get(file));
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
				}
				if (token.getType() == AllLexer.HexadecimalDigitSequence) {
					if (firstToken == null) {
						firstToken = Tokenizer.HEXA_DIGITS;
					}
					else {
						text = Tokenizer.HEXA_DIGITS;
					}
				}
				if (token.getType() == AllLexer.AlphaSequence) {
					String textTemp = token.getText();
					if (!tokensAll.contains(textTemp)) {
						textTemp = Tokenizer.ALPHA;
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
					if (!tokensAll.contains(textTemp)) {
						textTemp = Tokenizer.SIGN;
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
					TwoGram gram = new TwoGram(firstToken, firstTokenType, text, token.getType(), space);
					grams.add(gram);
				}
				
				firstToken = text;
				firstTokenType = token.getType();
				space = "";
			}
		}
		
		return grams;
	}

	public IProcessMonitor getProcessMonitor() {
		return processMonitor;
	}

	public void setProcessMonitor(IProcessMonitor processMonitor) {
		this.processMonitor = processMonitor;
	}
}
