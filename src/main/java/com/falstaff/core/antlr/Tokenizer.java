package com.falstaff.core.antlr;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.Token;

import com.falstaff.core.util.Histogram;
import com.falstaff.core.util.Pair;

import all.AllLexer;

public class Tokenizer {
	
	public static final String BOF = "<BOF>";
	public static final String ALPHA = "alpha";
	public static final String DIGITS = "digits";
	public static final String HEXA_DIGITS = "hexa_digits";
	public static final String SIGN = "sign";
	public static final String SPACE = "WS";
	public static final String NEW_LINE = "NL";
	private FalstaffErrorListener errListener = new FalstaffErrorListener();
	
	public List<Token> getTokens(File file, String language, String encoding) throws IOException {
		if (encoding == null) {
			encoding = "UTF-8";
		}
		ANTLRFileStream input = new ANTLRFileStream(file.getAbsolutePath(),
				encoding);
		AllLexer lexer = new AllLexer(input);
		return lex(lexer, language);
	}
	
	public List<Token> getTokens(byte[] bytes, String encoding) throws IOException {
		if (encoding == null) {
			encoding = "UTF-8";
		}
		ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
		//ANTLRFileStream input = new ANTLRFileStream(bytes,
		//		encoding);
		ANTLRInputStream input = new ANTLRInputStream(bis);
		AllLexer lexer = new AllLexer(input);
		return lex(lexer, null);
	}
	
	private List<Token> lex(AllLexer lexer, String language) {
		// modify error listener
		lexer.removeErrorListeners();
		lexer.addErrorListener(errListener);

		// set language
		if (language != null) {
			lexer.language = language;
		}
		else {
			lexer.language = "";
		}
		// create a buffer of tokens pulled from the lexer
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		tokens.fill();
		
		return tokens.getTokens();
	}
}
