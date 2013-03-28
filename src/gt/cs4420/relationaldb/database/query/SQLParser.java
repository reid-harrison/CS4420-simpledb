// $ANTLR 3.5 C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g 2013-03-27 20:09:21

package gt.cs4420.relationaldb.database.query;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class SQLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASC", "COMMA", "COMMENT", 
		"DESC", "DIGIT", "EQUAL", "FROM", "GREATER_THAN", "GREATER_THAN_EQUAL", 
		"IDENT", "INSERT_INTO", "INTEGER", "LESS_THAN", "LESS_THAN_EQUAL", "LETTER", 
		"LPAREN", "NOT_EQUAL", "OR", "ORDER_BY", "RPAREN", "SELECT", "SEMI", "SET", 
		"STRING_LITERAL", "UPDATE", "VALUES", "WHERE", "WS"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ASC=5;
	public static final int COMMA=6;
	public static final int COMMENT=7;
	public static final int DESC=8;
	public static final int DIGIT=9;
	public static final int EQUAL=10;
	public static final int FROM=11;
	public static final int GREATER_THAN=12;
	public static final int GREATER_THAN_EQUAL=13;
	public static final int IDENT=14;
	public static final int INSERT_INTO=15;
	public static final int INTEGER=16;
	public static final int LESS_THAN=17;
	public static final int LESS_THAN_EQUAL=18;
	public static final int LETTER=19;
	public static final int LPAREN=20;
	public static final int NOT_EQUAL=21;
	public static final int OR=22;
	public static final int ORDER_BY=23;
	public static final int RPAREN=24;
	public static final int SELECT=25;
	public static final int SEMI=26;
	public static final int SET=27;
	public static final int STRING_LITERAL=28;
	public static final int UPDATE=29;
	public static final int VALUES=30;
	public static final int WHERE=31;
	public static final int WS=32;

	// delegates
	public Parser[] getDelegates() {
		return new Parser[] {};
	}

	// delegators


	public SQLParser(TokenStream input) {
		this(input, new RecognizerSharedState());
	}
	public SQLParser(TokenStream input, RecognizerSharedState state) {
		super(input, state);
	}

	protected TreeAdaptor adaptor = new CommonTreeAdaptor();

	public void setTreeAdaptor(TreeAdaptor adaptor) {
		this.adaptor = adaptor;
	}
	public TreeAdaptor getTreeAdaptor() {
		return adaptor;
	}
	@Override public String[] getTokenNames() { return SQLParser.tokenNames; }
	@Override public String getGrammarFileName() { return "C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g"; }


	public static class statement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:19:1: statement : ( select | insert | update | EOF );
	public final SQLParser.statement_return statement() throws RecognitionException {
		SQLParser.statement_return retval = new SQLParser.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EOF4=null;
		ParserRuleReturnScope select1 =null;
		ParserRuleReturnScope insert2 =null;
		ParserRuleReturnScope update3 =null;

		CommonTree EOF4_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:20:2: ( select | insert | update | EOF )
			int alt1=4;
			switch ( input.LA(1) ) {
			case SELECT:
				{
				alt1=1;
				}
				break;
			case INSERT_INTO:
				{
				alt1=2;
				}
				break;
			case UPDATE:
				{
				alt1=3;
				}
				break;
			case EOF:
				{
				alt1=4;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:20:4: select
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_select_in_statement60);
					select1=select();
					state._fsp--;

					adaptor.addChild(root_0, select1.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:21:4: insert
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_insert_in_statement65);
					insert2=insert();
					state._fsp--;

					adaptor.addChild(root_0, insert2.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:22:4: update
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_update_in_statement70);
					update3=update();
					state._fsp--;

					adaptor.addChild(root_0, update3.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:23:4: EOF
					{
					root_0 = (CommonTree)adaptor.nil();


					EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_statement75); 
					EOF4_tree = (CommonTree)adaptor.create(EOF4);
					adaptor.addChild(root_0, EOF4_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "statement"


	public static class select_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "select"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:28:1: select : selectClause fromClause ( whereClause )? ( orderByClause )? SEMI !;
	public final SQLParser.select_return select() throws RecognitionException {
		SQLParser.select_return retval = new SQLParser.select_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI9=null;
		ParserRuleReturnScope selectClause5 =null;
		ParserRuleReturnScope fromClause6 =null;
		ParserRuleReturnScope whereClause7 =null;
		ParserRuleReturnScope orderByClause8 =null;

		CommonTree SEMI9_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:2: ( selectClause fromClause ( whereClause )? ( orderByClause )? SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:4: selectClause fromClause ( whereClause )? ( orderByClause )? SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_selectClause_in_select89);
			selectClause5=selectClause();
			state._fsp--;

			adaptor.addChild(root_0, selectClause5.getTree());

			pushFollow(FOLLOW_fromClause_in_select91);
			fromClause6=fromClause();
			state._fsp--;

			adaptor.addChild(root_0, fromClause6.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:28: ( whereClause )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==WHERE) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:29: whereClause
					{
					pushFollow(FOLLOW_whereClause_in_select94);
					whereClause7=whereClause();
					state._fsp--;

					adaptor.addChild(root_0, whereClause7.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:43: ( orderByClause )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ORDER_BY) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:44: orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_select99);
					orderByClause8=orderByClause();
					state._fsp--;

					adaptor.addChild(root_0, orderByClause8.getTree());

					}
					break;

			}

			SEMI9=(Token)match(input,SEMI,FOLLOW_SEMI_in_select103); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "select"


	public static class insert_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "insert"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:32:1: insert : insertClause valuesClause SEMI !;
	public final SQLParser.insert_return insert() throws RecognitionException {
		SQLParser.insert_return retval = new SQLParser.insert_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI12=null;
		ParserRuleReturnScope insertClause10 =null;
		ParserRuleReturnScope valuesClause11 =null;

		CommonTree SEMI12_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:33:2: ( insertClause valuesClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:33:4: insertClause valuesClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_insertClause_in_insert116);
			insertClause10=insertClause();
			state._fsp--;

			adaptor.addChild(root_0, insertClause10.getTree());

			pushFollow(FOLLOW_valuesClause_in_insert118);
			valuesClause11=valuesClause();
			state._fsp--;

			adaptor.addChild(root_0, valuesClause11.getTree());

			SEMI12=(Token)match(input,SEMI,FOLLOW_SEMI_in_insert120); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "insert"


	public static class update_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "update"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:36:1: update : updateClause setClause whereClause SEMI !;
	public final SQLParser.update_return update() throws RecognitionException {
		SQLParser.update_return retval = new SQLParser.update_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI16=null;
		ParserRuleReturnScope updateClause13 =null;
		ParserRuleReturnScope setClause14 =null;
		ParserRuleReturnScope whereClause15 =null;

		CommonTree SEMI16_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:37:2: ( updateClause setClause whereClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:37:4: updateClause setClause whereClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_updateClause_in_update133);
			updateClause13=updateClause();
			state._fsp--;

			adaptor.addChild(root_0, updateClause13.getTree());

			pushFollow(FOLLOW_setClause_in_update135);
			setClause14=setClause();
			state._fsp--;

			adaptor.addChild(root_0, setClause14.getTree());

			pushFollow(FOLLOW_whereClause_in_update137);
			whereClause15=whereClause();
			state._fsp--;

			adaptor.addChild(root_0, whereClause15.getTree());

			SEMI16=(Token)match(input,SEMI,FOLLOW_SEMI_in_update139); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "update"


	public static class selectClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "selectClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:45:1: selectClause : SELECT ^ columns ;
	public final SQLParser.selectClause_return selectClause() throws RecognitionException {
		SQLParser.selectClause_return retval = new SQLParser.selectClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SELECT17=null;
		ParserRuleReturnScope columns18 =null;

		CommonTree SELECT17_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:46:2: ( SELECT ^ columns )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:46:4: SELECT ^ columns
			{
			root_0 = (CommonTree)adaptor.nil();


			SELECT17=(Token)match(input,SELECT,FOLLOW_SELECT_in_selectClause162); 
			SELECT17_tree = (CommonTree)adaptor.create(SELECT17);
			root_0 = (CommonTree)adaptor.becomeRoot(SELECT17_tree, root_0);

			pushFollow(FOLLOW_columns_in_selectClause165);
			columns18=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns18.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "selectClause"


	public static class insertClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "insertClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:49:1: insertClause : INSERT_INTO ^ insertParams ;
	public final SQLParser.insertClause_return insertClause() throws RecognitionException {
		SQLParser.insertClause_return retval = new SQLParser.insertClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INSERT_INTO19=null;
		ParserRuleReturnScope insertParams20 =null;

		CommonTree INSERT_INTO19_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:50:2: ( INSERT_INTO ^ insertParams )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:50:4: INSERT_INTO ^ insertParams
			{
			root_0 = (CommonTree)adaptor.nil();


			INSERT_INTO19=(Token)match(input,INSERT_INTO,FOLLOW_INSERT_INTO_in_insertClause177); 
			INSERT_INTO19_tree = (CommonTree)adaptor.create(INSERT_INTO19);
			root_0 = (CommonTree)adaptor.becomeRoot(INSERT_INTO19_tree, root_0);

			pushFollow(FOLLOW_insertParams_in_insertClause180);
			insertParams20=insertParams();
			state._fsp--;

			adaptor.addChild(root_0, insertParams20.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "insertClause"


	public static class updateClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "updateClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:53:1: updateClause : UPDATE ^ table ;
	public final SQLParser.updateClause_return updateClause() throws RecognitionException {
		SQLParser.updateClause_return retval = new SQLParser.updateClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UPDATE21=null;
		ParserRuleReturnScope table22 =null;

		CommonTree UPDATE21_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:54:2: ( UPDATE ^ table )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:54:4: UPDATE ^ table
			{
			root_0 = (CommonTree)adaptor.nil();


			UPDATE21=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateClause192); 
			UPDATE21_tree = (CommonTree)adaptor.create(UPDATE21);
			root_0 = (CommonTree)adaptor.becomeRoot(UPDATE21_tree, root_0);

			pushFollow(FOLLOW_table_in_updateClause195);
			table22=table();
			state._fsp--;

			adaptor.addChild(root_0, table22.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "updateClause"


	public static class fromClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "fromClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:57:1: fromClause : FROM ^ table ;
	public final SQLParser.fromClause_return fromClause() throws RecognitionException {
		SQLParser.fromClause_return retval = new SQLParser.fromClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FROM23=null;
		ParserRuleReturnScope table24 =null;

		CommonTree FROM23_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:58:2: ( FROM ^ table )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:58:4: FROM ^ table
			{
			root_0 = (CommonTree)adaptor.nil();


			FROM23=(Token)match(input,FROM,FOLLOW_FROM_in_fromClause207); 
			FROM23_tree = (CommonTree)adaptor.create(FROM23);
			root_0 = (CommonTree)adaptor.becomeRoot(FROM23_tree, root_0);

			pushFollow(FOLLOW_table_in_fromClause210);
			table24=table();
			state._fsp--;

			adaptor.addChild(root_0, table24.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "fromClause"


	public static class whereClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "whereClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:61:1: whereClause : WHERE ^ searchConditions ;
	public final SQLParser.whereClause_return whereClause() throws RecognitionException {
		SQLParser.whereClause_return retval = new SQLParser.whereClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHERE25=null;
		ParserRuleReturnScope searchConditions26 =null;

		CommonTree WHERE25_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:62:2: ( WHERE ^ searchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:62:4: WHERE ^ searchConditions
			{
			root_0 = (CommonTree)adaptor.nil();


			WHERE25=(Token)match(input,WHERE,FOLLOW_WHERE_in_whereClause222); 
			WHERE25_tree = (CommonTree)adaptor.create(WHERE25);
			root_0 = (CommonTree)adaptor.becomeRoot(WHERE25_tree, root_0);

			pushFollow(FOLLOW_searchConditions_in_whereClause225);
			searchConditions26=searchConditions();
			state._fsp--;

			adaptor.addChild(root_0, searchConditions26.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "whereClause"


	public static class orderByClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "orderByClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:65:1: orderByClause : ORDER_BY ^ column ( COMMA ! column )* ( order )? ;
	public final SQLParser.orderByClause_return orderByClause() throws RecognitionException {
		SQLParser.orderByClause_return retval = new SQLParser.orderByClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ORDER_BY27=null;
		Token COMMA29=null;
		ParserRuleReturnScope column28 =null;
		ParserRuleReturnScope column30 =null;
		ParserRuleReturnScope order31 =null;

		CommonTree ORDER_BY27_tree=null;
		CommonTree COMMA29_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:66:2: ( ORDER_BY ^ column ( COMMA ! column )* ( order )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:66:4: ORDER_BY ^ column ( COMMA ! column )* ( order )?
			{
			root_0 = (CommonTree)adaptor.nil();


			ORDER_BY27=(Token)match(input,ORDER_BY,FOLLOW_ORDER_BY_in_orderByClause237); 
			ORDER_BY27_tree = (CommonTree)adaptor.create(ORDER_BY27);
			root_0 = (CommonTree)adaptor.becomeRoot(ORDER_BY27_tree, root_0);

			pushFollow(FOLLOW_column_in_orderByClause240);
			column28=column();
			state._fsp--;

			adaptor.addChild(root_0, column28.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:66:21: ( COMMA ! column )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==COMMA) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:66:22: COMMA ! column
					{
					COMMA29=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderByClause243); 
					pushFollow(FOLLOW_column_in_orderByClause246);
					column30=column();
					state._fsp--;

					adaptor.addChild(root_0, column30.getTree());

					}
					break;

				default :
					break loop4;
				}
			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:66:38: ( order )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ASC||LA5_0==DESC) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:66:39: order
					{
					pushFollow(FOLLOW_order_in_orderByClause251);
					order31=order();
					state._fsp--;

					adaptor.addChild(root_0, order31.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "orderByClause"


	public static class valuesClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "valuesClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:69:1: valuesClause : VALUES ^ LPAREN ! values RPAREN !;
	public final SQLParser.valuesClause_return valuesClause() throws RecognitionException {
		SQLParser.valuesClause_return retval = new SQLParser.valuesClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VALUES32=null;
		Token LPAREN33=null;
		Token RPAREN35=null;
		ParserRuleReturnScope values34 =null;

		CommonTree VALUES32_tree=null;
		CommonTree LPAREN33_tree=null;
		CommonTree RPAREN35_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:70:2: ( VALUES ^ LPAREN ! values RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:70:4: VALUES ^ LPAREN ! values RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			VALUES32=(Token)match(input,VALUES,FOLLOW_VALUES_in_valuesClause265); 
			VALUES32_tree = (CommonTree)adaptor.create(VALUES32);
			root_0 = (CommonTree)adaptor.becomeRoot(VALUES32_tree, root_0);

			LPAREN33=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_valuesClause268); 
			pushFollow(FOLLOW_values_in_valuesClause271);
			values34=values();
			state._fsp--;

			adaptor.addChild(root_0, values34.getTree());

			RPAREN35=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_valuesClause273); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "valuesClause"


	public static class setClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "setClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:73:1: setClause : SET ^ assignments ;
	public final SQLParser.setClause_return setClause() throws RecognitionException {
		SQLParser.setClause_return retval = new SQLParser.setClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SET36=null;
		ParserRuleReturnScope assignments37 =null;

		CommonTree SET36_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:74:2: ( SET ^ assignments )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:74:4: SET ^ assignments
			{
			root_0 = (CommonTree)adaptor.nil();


			SET36=(Token)match(input,SET,FOLLOW_SET_in_setClause285); 
			SET36_tree = (CommonTree)adaptor.create(SET36);
			root_0 = (CommonTree)adaptor.becomeRoot(SET36_tree, root_0);

			pushFollow(FOLLOW_assignments_in_setClause288);
			assignments37=assignments();
			state._fsp--;

			adaptor.addChild(root_0, assignments37.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "setClause"


	public static class insertParams_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "insertParams"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:84:1: insertParams : table ^ LPAREN ! columns RPAREN !;
	public final SQLParser.insertParams_return insertParams() throws RecognitionException {
		SQLParser.insertParams_return retval = new SQLParser.insertParams_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN39=null;
		Token RPAREN41=null;
		ParserRuleReturnScope table38 =null;
		ParserRuleReturnScope columns40 =null;

		CommonTree LPAREN39_tree=null;
		CommonTree RPAREN41_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:85:2: ( table ^ LPAREN ! columns RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:85:4: table ^ LPAREN ! columns RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_table_in_insertParams308);
			table38=table();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(table38.getTree(), root_0);
			LPAREN39=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_insertParams311); 
			pushFollow(FOLLOW_columns_in_insertParams314);
			columns40=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns40.getTree());

			RPAREN41=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_insertParams316); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "insertParams"


	public static class table_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "table"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:88:1: table : IDENT ;
	public final SQLParser.table_return table() throws RecognitionException {
		SQLParser.table_return retval = new SQLParser.table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT42=null;

		CommonTree IDENT42_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:92:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:92:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT42=(Token)match(input,IDENT,FOLLOW_IDENT_in_table332); 
			IDENT42_tree = (CommonTree)adaptor.create(IDENT42);
			adaptor.addChild(root_0, IDENT42_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "table"


	public static class columns_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "columns"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:95:1: columns : column ( COMMA ! column )* ;
	public final SQLParser.columns_return columns() throws RecognitionException {
		SQLParser.columns_return retval = new SQLParser.columns_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA44=null;
		ParserRuleReturnScope column43 =null;
		ParserRuleReturnScope column45 =null;

		CommonTree COMMA44_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:96:2: ( column ( COMMA ! column )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:96:4: column ( COMMA ! column )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_columns344);
			column43=column();
			state._fsp--;

			adaptor.addChild(root_0, column43.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:96:11: ( COMMA ! column )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==COMMA) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:96:12: COMMA ! column
					{
					COMMA44=(Token)match(input,COMMA,FOLLOW_COMMA_in_columns347); 
					pushFollow(FOLLOW_column_in_columns350);
					column45=column();
					state._fsp--;

					adaptor.addChild(root_0, column45.getTree());

					}
					break;

				default :
					break loop6;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "columns"


	public static class column_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "column"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:99:1: column : IDENT ;
	public final SQLParser.column_return column() throws RecognitionException {
		SQLParser.column_return retval = new SQLParser.column_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT46=null;

		CommonTree IDENT46_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT46=(Token)match(input,IDENT,FOLLOW_IDENT_in_column367); 
			IDENT46_tree = (CommonTree)adaptor.create(IDENT46);
			adaptor.addChild(root_0, IDENT46_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "column"


	public static class value_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:106:1: value : ( STRING_LITERAL | INTEGER );
	public final SQLParser.value_return value() throws RecognitionException {
		SQLParser.value_return retval = new SQLParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set47=null;

		CommonTree set47_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:107:2: ( STRING_LITERAL | INTEGER )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set47=input.LT(1);
			if ( input.LA(1)==INTEGER||input.LA(1)==STRING_LITERAL ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set47));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "value"


	public static class values_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "values"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:111:1: values : value ( COMMA ! value )* ;
	public final SQLParser.values_return values() throws RecognitionException {
		SQLParser.values_return retval = new SQLParser.values_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA49=null;
		ParserRuleReturnScope value48 =null;
		ParserRuleReturnScope value50 =null;

		CommonTree COMMA49_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:112:2: ( value ( COMMA ! value )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:112:4: value ( COMMA ! value )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_value_in_values397);
			value48=value();
			state._fsp--;

			adaptor.addChild(root_0, value48.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:112:10: ( COMMA ! value )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMA) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:112:11: COMMA ! value
					{
					COMMA49=(Token)match(input,COMMA,FOLLOW_COMMA_in_values400); 
					pushFollow(FOLLOW_value_in_values403);
					value50=value();
					state._fsp--;

					adaptor.addChild(root_0, value50.getTree());

					}
					break;

				default :
					break loop7;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "values"


	public static class order_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "order"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:115:1: order : ( ASC | DESC );
	public final SQLParser.order_return order() throws RecognitionException {
		SQLParser.order_return retval = new SQLParser.order_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set51=null;

		CommonTree set51_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:116:2: ( ASC | DESC )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set51=input.LT(1);
			if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set51));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "order"


	public static class assignments_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignments"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:120:1: assignments : assignment ( COMMA ! assignment )* ;
	public final SQLParser.assignments_return assignments() throws RecognitionException {
		SQLParser.assignments_return retval = new SQLParser.assignments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA53=null;
		ParserRuleReturnScope assignment52 =null;
		ParserRuleReturnScope assignment54 =null;

		CommonTree COMMA53_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:121:2: ( assignment ( COMMA ! assignment )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:121:4: assignment ( COMMA ! assignment )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_assignment_in_assignments434);
			assignment52=assignment();
			state._fsp--;

			adaptor.addChild(root_0, assignment52.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:121:15: ( COMMA ! assignment )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==COMMA) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:121:16: COMMA ! assignment
					{
					COMMA53=(Token)match(input,COMMA,FOLLOW_COMMA_in_assignments437); 
					pushFollow(FOLLOW_assignment_in_assignments440);
					assignment54=assignment();
					state._fsp--;

					adaptor.addChild(root_0, assignment54.getTree());

					}
					break;

				default :
					break loop8;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignments"


	public static class assignment_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:124:1: assignment : column EQUAL ^ value ;
	public final SQLParser.assignment_return assignment() throws RecognitionException {
		SQLParser.assignment_return retval = new SQLParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQUAL56=null;
		ParserRuleReturnScope column55 =null;
		ParserRuleReturnScope value57 =null;

		CommonTree EQUAL56_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:125:2: ( column EQUAL ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:125:4: column EQUAL ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_assignment454);
			column55=column();
			state._fsp--;

			adaptor.addChild(root_0, column55.getTree());

			EQUAL56=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_assignment456); 
			EQUAL56_tree = (CommonTree)adaptor.create(EQUAL56);
			root_0 = (CommonTree)adaptor.becomeRoot(EQUAL56_tree, root_0);

			pushFollow(FOLLOW_value_in_assignment459);
			value57=value();
			state._fsp--;

			adaptor.addChild(root_0, value57.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "assignment"


	public static class searchConditions_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "searchConditions"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:128:1: searchConditions : searchCondition ( logicalOperator ^ searchCondition )? ;
	public final SQLParser.searchConditions_return searchConditions() throws RecognitionException {
		SQLParser.searchConditions_return retval = new SQLParser.searchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope searchCondition58 =null;
		ParserRuleReturnScope logicalOperator59 =null;
		ParserRuleReturnScope searchCondition60 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:129:2: ( searchCondition ( logicalOperator ^ searchCondition )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:129:4: searchCondition ( logicalOperator ^ searchCondition )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_searchCondition_in_searchConditions471);
			searchCondition58=searchCondition();
			state._fsp--;

			adaptor.addChild(root_0, searchCondition58.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:129:20: ( logicalOperator ^ searchCondition )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==AND||LA9_0==OR) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:129:21: logicalOperator ^ searchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_searchConditions474);
					logicalOperator59=logicalOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(logicalOperator59.getTree(), root_0);
					pushFollow(FOLLOW_searchCondition_in_searchConditions477);
					searchCondition60=searchCondition();
					state._fsp--;

					adaptor.addChild(root_0, searchCondition60.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "searchConditions"


	public static class searchCondition_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "searchCondition"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:132:1: searchCondition : column comparisonOperator ^ value ;
	public final SQLParser.searchCondition_return searchCondition() throws RecognitionException {
		SQLParser.searchCondition_return retval = new SQLParser.searchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope column61 =null;
		ParserRuleReturnScope comparisonOperator62 =null;
		ParserRuleReturnScope value63 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:133:2: ( column comparisonOperator ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:133:4: column comparisonOperator ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_searchCondition491);
			column61=column();
			state._fsp--;

			adaptor.addChild(root_0, column61.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_searchCondition493);
			comparisonOperator62=comparisonOperator();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(comparisonOperator62.getTree(), root_0);
			pushFollow(FOLLOW_value_in_searchCondition496);
			value63=value();
			state._fsp--;

			adaptor.addChild(root_0, value63.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "searchCondition"


	public static class comparisonOperator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "comparisonOperator"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:142:1: comparisonOperator : ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN );
	public final SQLParser.comparisonOperator_return comparisonOperator() throws RecognitionException {
		SQLParser.comparisonOperator_return retval = new SQLParser.comparisonOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set64=null;

		CommonTree set64_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:143:2: ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set64=input.LT(1);
			if ( input.LA(1)==EQUAL||(input.LA(1) >= GREATER_THAN && input.LA(1) <= GREATER_THAN_EQUAL)||(input.LA(1) >= LESS_THAN && input.LA(1) <= LESS_THAN_EQUAL)||input.LA(1)==NOT_EQUAL ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set64));
				state.errorRecovery=false;
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				throw mse;
			}
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "comparisonOperator"


	public static class logicalOperator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "logicalOperator"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:151:1: logicalOperator : ( AND ^| OR ^);
	public final SQLParser.logicalOperator_return logicalOperator() throws RecognitionException {
		SQLParser.logicalOperator_return retval = new SQLParser.logicalOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token AND65=null;
		Token OR66=null;

		CommonTree AND65_tree=null;
		CommonTree OR66_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:152:2: ( AND ^| OR ^)
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==AND) ) {
				alt10=1;
			}
			else if ( (LA10_0==OR) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:152:4: AND ^
					{
					root_0 = (CommonTree)adaptor.nil();


					AND65=(Token)match(input,AND,FOLLOW_AND_in_logicalOperator554); 
					AND65_tree = (CommonTree)adaptor.create(AND65);
					root_0 = (CommonTree)adaptor.becomeRoot(AND65_tree, root_0);

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:153:4: OR ^
					{
					root_0 = (CommonTree)adaptor.nil();


					OR66=(Token)match(input,OR,FOLLOW_OR_in_logicalOperator560); 
					OR66_tree = (CommonTree)adaptor.create(OR66);
					root_0 = (CommonTree)adaptor.becomeRoot(OR66_tree, root_0);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (RecognitionException re) {
			reportError(re);
			recover(input,re);
			retval.tree = (CommonTree)adaptor.errorNode(input, retval.start, input.LT(-1), re);
		}
		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "logicalOperator"

	// Delegated rules



	public static final BitSet FOLLOW_select_in_statement60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insert_in_statement65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_update_in_statement70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EOF_in_statement75 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectClause_in_select89 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_fromClause_in_select91 = new BitSet(new long[]{0x0000000084800000L});
	public static final BitSet FOLLOW_whereClause_in_select94 = new BitSet(new long[]{0x0000000004800000L});
	public static final BitSet FOLLOW_orderByClause_in_select99 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMI_in_select103 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insertClause_in_insert116 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_valuesClause_in_insert118 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMI_in_insert120 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_updateClause_in_update133 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_setClause_in_update135 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_whereClause_in_update137 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMI_in_update139 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_selectClause162 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_columns_in_selectClause165 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_INTO_in_insertClause177 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_insertParams_in_insertClause180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_updateClause192 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_table_in_updateClause195 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_fromClause207 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_table_in_fromClause210 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_whereClause222 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_searchConditions_in_whereClause225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_BY_in_orderByClause237 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_column_in_orderByClause240 = new BitSet(new long[]{0x0000000000000162L});
	public static final BitSet FOLLOW_COMMA_in_orderByClause243 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_column_in_orderByClause246 = new BitSet(new long[]{0x0000000000000162L});
	public static final BitSet FOLLOW_order_in_orderByClause251 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUES_in_valuesClause265 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_LPAREN_in_valuesClause268 = new BitSet(new long[]{0x0000000010010000L});
	public static final BitSet FOLLOW_values_in_valuesClause271 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RPAREN_in_valuesClause273 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_setClause285 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_assignments_in_setClause288 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_insertParams308 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_LPAREN_in_insertParams311 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_columns_in_insertParams314 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RPAREN_in_insertParams316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_table332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_columns344 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_columns347 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_column_in_columns350 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_IDENT_in_column367 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_values397 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_values400 = new BitSet(new long[]{0x0000000010010000L});
	public static final BitSet FOLLOW_value_in_values403 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_assignment_in_assignments434 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_assignments437 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_assignment_in_assignments440 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_column_in_assignment454 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EQUAL_in_assignment456 = new BitSet(new long[]{0x0000000010010000L});
	public static final BitSet FOLLOW_value_in_assignment459 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions471 = new BitSet(new long[]{0x0000000000400012L});
	public static final BitSet FOLLOW_logicalOperator_in_searchConditions474 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions477 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_searchCondition491 = new BitSet(new long[]{0x0000000000263400L});
	public static final BitSet FOLLOW_comparisonOperator_in_searchCondition493 = new BitSet(new long[]{0x0000000010010000L});
	public static final BitSet FOLLOW_value_in_searchCondition496 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_logicalOperator554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_logicalOperator560 = new BitSet(new long[]{0x0000000000000002L});
}
