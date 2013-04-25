package gt.cs4420.relationaldb.database.query;

import java.util.List;

import gt.cs4420.relationaldb.database.storage.StorageManager;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Description;
import gt.cs4420.relationaldb.domain.JoinedRow;
import gt.cs4420.relationaldb.domain.Row;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.query.Constraint;
import gt.cs4420.relationaldb.domain.query.OrderConstraint;
import gt.cs4420.relationaldb.domain.query.JoinConstraint;
import gt.cs4420.relationaldb.domain.query.JoinConstraint.JoinType;
import gt.cs4420.relationaldb.domain.query.OrderConstraint.Direction;
import gt.cs4420.relationaldb.domain.query.ValueOperator;
import gt.cs4420.relationaldb.database.query.QueryParser;

import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.Tree;
import com.google.common.collect.Lists;

public class QueryEngine {

    private StorageManager storageManager;

    public QueryEngine(StorageManager storageManager) {
        this.storageManager = storageManager;
    }

    public boolean executeQuery(CommonTree queryTree) {

        //recurse down tree
            //match keywords to operations
            //should be off form "KEYWORD" -> parameters (as children)


        return false;
    }

    public List<JoinedRow> selectFromTable(QueryParser parser)
    {
    	Tree selectFromTableNode = parser.getQueryTree();
    	Tree selectNode = null;
    	Tree fromNode = null;
    	Tree onNode = null;
    	Tree whereNode = null;
    	Tree orderByNode = null;
    	Tree joinNode = null;
    	List<String> selectColumns = Lists.newArrayList();
    	List<String> joinTables = Lists.newArrayList();
    	JoinConstraint joinConstraint = null;
    	OrderConstraint orderConstraint = null;
    	
    	
    	Constraint whereConstraint = null;
    	boolean isJoin = false;
    			
    	for(int i = 0; i < selectFromTableNode.getChildCount(); i++)
		{
    		if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("SELECT"))
    			selectNode = selectFromTableNode.getChild(i);
    		if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("FROM"))
    			fromNode = selectFromTableNode.getChild(i);
    		if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("ON"))
    			onNode = selectFromTableNode.getChild(i);
    		if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("WHERE"))
    			whereNode = selectFromTableNode.getChild(i);
    		if(selectFromTableNode.getChild(i).getText().equalsIgnoreCase("ORDER BY"))
    			orderByNode = selectFromTableNode.getChild(i);
		}   	
    	
    	
    	if(selectNode != null)
    	{
    		for(int i = 0; i < selectNode.getChildCount()-1; i++)
    		{	
    			selectColumns.add(selectNode.getChild(i).getText());
    		}
    	}
    	
    	if(fromNode != null)
    	{
    		if(fromNode.getChild(0).getText().toUpperCase().contains("JOIN") && onNode != null)
    		{
    			joinNode = fromNode.getChild(0);
    			
    			for(int i = 0; i < joinNode.getChildCount(); i++)
    			{
    				joinTables.add(joinNode.getChild(i).getText());
    			}
    			
    			joinConstraint = new JoinConstraint(JoinType.INNER, ValueOperator.getByStringRepresentation(onNode.getChild(0).getText()), new Attribute(onNode.getChild(0).getChild(0).getChild(0).getText()), new Attribute(onNode.getChild(0).getChild(1).getChild(0).getText()));
    			isJoin = true;
    		}
    		else
    			joinTables.add(fromNode.getChild(0).getText());		
    	}
    	
    	if(whereNode != null)
    	{
    		parser.parseConstraint(selectFromTableNode);
    		
    	}
    	
    	if(orderByNode != null)
    	{
    		orderConstraint = new OrderConstraint(new Attribute(orderByNode.getChild(0).getText()),Direction.getByStringRepresenations(orderByNode.getChild(1).getText()));
    	}
    	
    	
    	if(isJoin)
    	{
    		try {
				return storageManager.selectJoin(joinTables.get(0), joinTables.get(1), joinConstraint, whereConstraint, orderConstraint);
			} catch (ValidationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
		return null;
    }
    
    public void createTable(Tree createTableNode) {

        //extra this node's relevant data
        String name = createTableNode.getChild(0).getText();
        //move down CREATE TABLE tree


        Description description = new Description();


        Table table = new Table(name, description);
    }

    public void dropTable(Tree dropTableNode) {

    }

    public void insertIntoTable(Tree insertIntoTableNode) {

    }
}
