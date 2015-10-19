// Generated from all\All.g4 by ANTLR 4.5
package all;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class AllLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, DigitSequence=2, AlphaSequence=3, SignSequence=4, HexadecimalDigitSequence=5, 
		Whitespace=6, Newline=7, Other=8, BlockComment=9, LineComment=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "DigitSequence", "Digit", "AlphaSequence", "Alpha", "SignSequence", 
		"Sign", "HexadecimalDigitSequence", "HexadecimalDigit", "Whitespace", 
		"Newline", "Other", "BlockComment", "LineComment"
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

	public String language;

	public AllLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "All.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 11:
			Other_action((RuleContext)_localctx, actionIndex);
			break;
		}
	}
	private void Other_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:
			System.out.println("!!!!!!!!!!!!!!!!!!!unknown character " + getText());
			break;
		}
	}
	@Override
	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return BlockComment_sempred((RuleContext)_localctx, predIndex);
		case 13:
			return LineComment_sempred((RuleContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean BlockComment_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return language.equals("c") || language.equals("java");
		}
		return true;
	}
	private boolean LineComment_sempred(RuleContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return language.equals("c") || language.equals("java");
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\fj\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\3\6\3\"\n\3\r\3\16\3#\3"+
		"\4\3\4\3\5\6\5)\n\5\r\5\16\5*\3\6\3\6\3\7\6\7\60\n\7\r\7\16\7\61\3\b\3"+
		"\b\3\t\6\t\67\n\t\r\t\16\t8\3\n\3\n\3\13\6\13>\n\13\r\13\16\13?\3\f\3"+
		"\f\5\fD\n\f\3\f\5\fG\n\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\7\16"+
		"R\n\16\f\16\16\16U\13\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\7\17b\n\17\f\17\16\17e\13\17\3\17\3\17\3\17\3\17\3S\2\20\3"+
		"\3\5\4\7\2\t\5\13\2\r\6\17\2\21\7\23\2\25\b\27\t\31\n\33\13\35\f\3\2\t"+
		"\3\2\62;\4\2C\\c|\6\2#\61<B]b}\u0080\5\2\62;CHch\4\2\13\13\"\"\5\2\13"+
		"\f\17\17\"\u0080\4\2\f\f\17\17m\2\3\3\2\2\2\2\5\3\2\2\2\2\t\3\2\2\2\2"+
		"\r\3\2\2\2\2\21\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3"+
		"\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5!\3\2\2\2\7%\3\2\2\2\t(\3\2\2\2\13,"+
		"\3\2\2\2\r/\3\2\2\2\17\63\3\2\2\2\21\66\3\2\2\2\23:\3\2\2\2\25=\3\2\2"+
		"\2\27F\3\2\2\2\31H\3\2\2\2\33M\3\2\2\2\35]\3\2\2\2 \"\5\7\4\2! \3\2\2"+
		"\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$\6\3\2\2\2%&\t\2\2\2&\b\3\2\2\2\')\5"+
		"\13\6\2(\'\3\2\2\2)*\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\n\3\2\2\2,-\t\3\2\2"+
		"-\f\3\2\2\2.\60\5\17\b\2/.\3\2\2\2\60\61\3\2\2\2\61/\3\2\2\2\61\62\3\2"+
		"\2\2\62\16\3\2\2\2\63\64\t\4\2\2\64\20\3\2\2\2\65\67\5\23\n\2\66\65\3"+
		"\2\2\2\678\3\2\2\28\66\3\2\2\289\3\2\2\29\22\3\2\2\2:;\t\5\2\2;\24\3\2"+
		"\2\2<>\t\6\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2\2?@\3\2\2\2@\26\3\2\2\2AC\7"+
		"\17\2\2BD\7\f\2\2CB\3\2\2\2CD\3\2\2\2DG\3\2\2\2EG\7\f\2\2FA\3\2\2\2FE"+
		"\3\2\2\2G\30\3\2\2\2HI\n\7\2\2IJ\b\r\2\2JK\3\2\2\2KL\b\r\3\2L\32\3\2\2"+
		"\2MN\7\61\2\2NO\7,\2\2OS\3\2\2\2PR\13\2\2\2QP\3\2\2\2RU\3\2\2\2ST\3\2"+
		"\2\2SQ\3\2\2\2TV\3\2\2\2US\3\2\2\2VW\7,\2\2WX\7\61\2\2XY\3\2\2\2YZ\6\16"+
		"\2\2Z[\3\2\2\2[\\\b\16\3\2\\\34\3\2\2\2]^\7\61\2\2^_\7\61\2\2_c\3\2\2"+
		"\2`b\n\b\2\2a`\3\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2df\3\2\2\2ec\3\2\2"+
		"\2fg\6\17\3\2gh\3\2\2\2hi\b\17\3\2i\36\3\2\2\2\f\2#*\618?CFSc\4\3\r\2"+
		"\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}