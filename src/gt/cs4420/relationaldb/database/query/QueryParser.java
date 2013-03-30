package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.query.SQLParser.statement_return;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;

public class QueryParser {

	
	private CommonTree queryTree;
	
	public QueryParser(final String query) throws RecognitionException {
		CharStream charStream = new ANTLRStringStream(query);
		SQLLexer lexer = new SQLLexer(charStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		SQLParser parser = new SQLParser(tokenStream);
		statement_return statement = parser.statement();
		
		queryTree = statement.tree;
	}
	
	public CommonTree getQueryTree()
	{
		return queryTree;
	}
}