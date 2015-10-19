// Generated from all\All.g4 by ANTLR 4.5
package all;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AllParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, DigitSequence=2, AlphaSequence=3, SignSequence=4, HexadecimalDigitSequence=5, 
		Whitespace=6, Newline=7, Other=8, BlockComment=9, LineComment=10;
	public static final int
		RULE_dummy = 0;
	public static final String[] ruleNames = {
		"dummy"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "''"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, "DigitSequence", "AlphaSequence", "SignSequence", "HexadecimalDigitSequence", 
		"Whitespace", "Newline", "Other", "BlockComment", "LineComment"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "All.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public AllParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class DummyContext extends ParserRuleContext {
		public DummyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dummy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof AllListener ) ((AllListener)listener).enterDummy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof AllListener ) ((AllListener)listener).exitDummy(this);
		}
	}

	public final DummyContext dummy() throws RecognitionException {
		DummyContext _localctx = new DummyContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_dummy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3\f\7\4\2\t\2\3\2\3"+
		"\2\3\2\2\2\3\2\2\2\5\2\4\3\2\2\2\4\5\7\3\2\2\5\3\3\2\2\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}