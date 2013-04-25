package gt.cs4420.relationaldb.database.query;

import com.google.common.base.Strings;
import gt.cs4420.relationaldb.database.query.SQLParser.statement_return;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.query.*;
import org.antlr.runtime.ANTLRStringStream;
import org.antlr.runtime.CharStream;
import org.antlr.runtime.CommonTokenStream;
import org.antlr.runtime.RecognitionException;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;

public class QueryParser {

	
	private CommonTree queryTree;

    private Constraint whereConstraint;

	public QueryParser(final String query) throws RecognitionException, ValidationException {
		CharStream charStream = new ANTLRStringStream(query);
		SQLLexer lexer = new SQLLexer(charStream);
		CommonTokenStream tokenStream = new CommonTokenStream(lexer);
		SQLParser parser = new SQLParser(tokenStream);
		statement_return statement = parser.statement();
		
		queryTree = statement.tree;

        //whereConstraint = parseConstraint(queryTree);
	}
	
	public CommonTree getQueryTree()
	{
		return queryTree;
	}

    public Constraint getWhereConstraint() {
        return whereConstraint;
    }

    public Constraint parseConstraint(final Tree queryRoot) {
        String text = queryRoot.getText();

        if (Strings.isNullOrEmpty(text)) {
            for (int i = 0; i < queryRoot.getChildCount(); i++) {
                if ("WHERE".equals(queryRoot.getChild(i).getText())) {
                    return parseWhereConstraint(queryRoot.getChild(i));
                }
            }
        }

        if ("WHERE".equalsIgnoreCase(text)) {
            return parseWhereConstraint(queryRoot);
        }

        throw new IllegalArgumentException("The root of the query tree or the root of the where clause is required to parse the constraints");
    }

    private Constraint parseWhereConstraint(final Tree whereRoot) {
        Tree operatorNode = whereRoot;

        //If passed the WHERE node, step down to the first operator
        if ("WHERE".equalsIgnoreCase(operatorNode.getText())) {
            operatorNode = operatorNode.getChild(0);
        }

        String operatorString = operatorNode.getText();

        LogicalOperator logicalOperator = LogicalOperator.getByStringRepresentation(operatorString);
        ValueOperator valueOperator = ValueOperator.getByStringRepresentation(operatorString);

        //Logical constraint
        if (logicalOperator != null) {
            Constraint leftConstraint = parseWhereConstraint(operatorNode.getChild(0));
            Constraint rightConstraint = parseWhereConstraint(operatorNode.getChild(1));

            return new LogicalConstraint(logicalOperator, leftConstraint, rightConstraint);
        }

        //Value constraint
        if (valueOperator != null) {
            Attribute attribute = new Attribute(operatorNode.getChild(0).getText());
            Object value = operatorNode.getChild(1).getText();

            return new ValueConstraint(attribute, value, (ValueOperator) valueOperator);
        }

        return null;
    }
}