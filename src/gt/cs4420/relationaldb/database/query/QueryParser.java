package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.database.query.SQLParser.statement_return;

import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;


public class QueryParser {

	/**
	 * @param args
	 * @throws RecognitionException 
	 */
	public static void main(String[] args) throws RecognitionException {
		
		String select = "SELECT userID, firstName, lastName, password FROM users WHERE firstName = 'phil' AND lastName = 'oliver' ORDER BY lastName, firstName;";
		String insert = "INSERT INTO table1 (userID, firstName, lastname, password) VALUES (1, 'phil', 'oliver', 'unicorns');";	
		String update = "UPDATE users SET firstName = 'phil', lastName = 'oliver' WHERE userID = 1;";
		
		//CharStream charStream = new ANTLRStringStream(select);
		//CharStream charStream = new ANTLRStringStream(select);
		CharStream charStream = new ANTLRStringStream(update);
		SQLLexer lexer = new SQLLexer(charStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		SQLParser parser = new SQLParser(tokenStream);
		statement_return statement = parser.statement();
		System.out.println(statement.tree.toStringTree());
		
		DOTTreeGenerator gen = new DOTTreeGenerator();
		StringTemplate st = gen.toDOT(statement.tree);
		System.out.println(st);
		
		
		

		   
		

	}

}