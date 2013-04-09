package gt.cs4420.relationaldb.database.query;

import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;

public class QueryParseTest {

	public static void main(String[] args) throws RecognitionException {
		
		String query = "";
		int choice = 0;
		
		switch(choice)
		{
			case 0:
				query = "SELECT userID, firstName, lastName, password FROM users INNER JOIN accounts OUTER JOIN company ON users.name=1 AND accounts.status = 'stupid' WHERE userID >= 1 AND firstName = 'phil' AND lastName = 'oliver' ORDER BY lastName, firstName;";
				break;
			
			case 1:
				query = "INSERT INTO table1 (userID, firstName, lastname, password) VALUES (1, 'phil', 'oliver', 'unicorns');";
				break;
				
			case 2:
				query = "UPDATE users SET firstName = 'phil', lastName = 'oliver' WHERE userID = 1;";
				break;
			default:
				break;
		}
		
		QueryParser parsed = new QueryParser(query);
		
		DOTTreeGenerator gen = new DOTTreeGenerator();
		StringTemplate st = gen.toDOT(parsed.getQueryTree());
		
		// This prints out a DOT Tree declaration for the query tree. Use GraphViz to view it.
		System.out.println(st);
	}
}
