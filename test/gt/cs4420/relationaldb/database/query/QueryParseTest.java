package gt.cs4420.relationaldb.database.query;

import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.query.*;
import gt.cs4420.relationaldb.test.TestFailedException;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.DOTTreeGenerator;
import org.antlr.stringtemplate.StringTemplate;
import org.junit.Test;

public class QueryParseTest {

    @Test
    public void testQueryParse_createQuery() {
        String query = "CREATE TABLE persons (id int, name string)";
        QueryParser parser;

        try {
            parser = new QueryParser(query);
        } catch(RecognitionException e) {
            throw new TestFailedException("Query parse", e.getMessage());
        }

        DOTTreeGenerator gen = new DOTTreeGenerator();
        CommonTree queryTree = parser.getQueryTree();
        StringTemplate st = gen.toDOT(queryTree);

        System.out.println(st);
    }

	public static void main(String[] args) throws RecognitionException {
        QueryParseTest test = new QueryParseTest();

        try {
            test.runTest(2);

           /* for (int i = 0; i < 3; i++) {
                test.runTest(i);
            } */
        } catch (final TestFailedException tfe) {
            System.out.println(tfe.getMessage());
        }

	}

    private void runTest(int choice) {
        String query = "";
        Constraint expectedConstraint = null;

        switch(choice)
        {
            case 0:
                query = "SELECT userID, firstName, lastName, password FROM users INNER JOIN accounts OUTER JOIN company ON users.name=1 AND accounts.status = 'stupid' WHERE userID >= 1 AND firstName = 'phil' OR lastName = 'oliver' ORDER BY lastName, firstName;";

                ValueConstraint vc1 = new ValueConstraint(new Attribute("userID"), "1", ValueOperator.GREATER_THAN_EQUAL_TO);
                ValueConstraint vc2 = new ValueConstraint(new Attribute("firstName"), "'phil'", ValueOperator.EQUALS);
                ValueConstraint vc3 = new ValueConstraint(new Attribute("lastName"), "'oliver'", ValueOperator.EQUALS);

                LogicalConstraint lc1 = new LogicalConstraint(LogicalOperator.AND, vc1, vc2);
                LogicalConstraint lc2 = new LogicalConstraint(LogicalOperator.OR, lc1, vc3);

                expectedConstraint = lc2;
                break;

            case 1:
                query = "INSERT INTO table1 (userID, firstName, lastname, password) VALUES (1, 'phil', 'oliver', 'unicorns');";
                break;

            case 2:
                query = "UPDATE users SET firstName = 'phil', lastName = 'oliver' WHERE userID = 1;";

                ValueConstraint vc = new ValueConstraint(new Attribute("userID"), "1", ValueOperator.EQUALS);
                expectedConstraint = vc;

                break;
            default:
                break;
        }

        QueryParser parser = null;

        try {
            parser = new QueryParser(query);
        } catch(RecognitionException e) {
            throw new TestFailedException("Query parse", e.getMessage());
        }

        DOTTreeGenerator gen = new DOTTreeGenerator();
        CommonTree queryTree = parser.getQueryTree();
        StringTemplate st = gen.toDOT(queryTree);

        // This prints out a DOT Tree declaration for the query tree. Use GraphViz to view it.
        System.out.println(st);

        /***
         * Begin tests
         */

        if (expectedConstraint != null) {
            Constraint constraint = parser.getWhereConstraint();

            if (!expectedConstraint.equals(constraint)) {
                throw new TestFailedException("Where constraints", "parsed where clause does not match expected");
            }
        }
    }

}
