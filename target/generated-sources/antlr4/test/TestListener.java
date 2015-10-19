// Generated from test\Test.g4 by ANTLR 4.5
package test;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link TestParser}.
 */
public interface TestListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link TestParser#kuku}.
	 * @param ctx the parse tree
	 */
	void enterKuku(TestParser.KukuContext ctx);
	/**
	 * Exit a parse tree produced by {@link TestParser#kuku}.
	 * @param ctx the parse tree
	 */
	void exitKuku(TestParser.KukuContext ctx);
}