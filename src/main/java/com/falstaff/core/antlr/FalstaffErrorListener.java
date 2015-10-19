package com.falstaff.core.antlr;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;

public class FalstaffErrorListener extends BaseErrorListener {

	@Override
	public void syntaxError(Recognizer<?, ?> recognizer,
			Object offendingSymbol, int line, int charPositionInLine,
			String msg, RecognitionException e) {
		// TODO Auto-generated method stub
		super.syntaxError(recognizer, offendingSymbol, line, charPositionInLine, msg, e);
		throw new RuntimeException(msg + " line " + line + " position " + charPositionInLine);
	}

}
