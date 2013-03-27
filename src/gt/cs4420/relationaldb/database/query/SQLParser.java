// $ANTLR 3.5 C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g 2013-03-27 18:37:12

package gt.cs4420.relationaldb.database.query;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class SQLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASC", "COMMA", "DESC", 
		"DIGIT", "EQUAL", "FROM", "GREATER_THAN", "GREATER_THAN_EQUAL", "IDENT", 
		"INSERT", "INTEGER", "INTO", "LESS_THAN", "LESS_THAN_EQUAL", "LETTER", 
		"LPAREN", "NOT_EQUAL", "OR", "ORDER_BY", "RPAREN", "SELECT", "SEMI", "SET", 
		"STRING_LITERAL", "UPDATE", "VALUES", "WHERE", "WS"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ASC=5;
	public static final int COMMA=6;
	public static final int DESC=7;
	public static final int DIGIT=8;
	public static final int EQUAL=9;
	public static final int FROM=10;
	public static final int GREATER_THAN=11;
	public static final int GREATER_THAN_EQUAL=12;
	public static final int IDENT=13;
	public static final int INSERT=14;
	public static final int INTEGER=15;
	public static final int INTO=16;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:19:1: statement : ( select | insert | update );
	public final SQLParser.statement_return statement() throws RecognitionException {
		SQLParser.statement_return retval = new SQLParser.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope select1 =null;
		ParserRuleReturnScope insert2 =null;
		ParserRuleReturnScope update3 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:20:2: ( select | insert | update )
			int alt1=3;
			switch ( input.LA(1) ) {
			case SELECT:
				{
				alt1=1;
				}
				break;
			case INSERT:
				{
				alt1=2;
				}
				break;
			case UPDATE:
				{
				alt1=3;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:25:1: select : SELECT columns FROM table ( whereClause )? ( orderByClause )? SEMI ;
	public final SQLParser.select_return select() throws RecognitionException {
		SQLParser.select_return retval = new SQLParser.select_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SELECT4=null;
		Token FROM6=null;
		Token SEMI10=null;
		ParserRuleReturnScope columns5 =null;
		ParserRuleReturnScope table7 =null;
		ParserRuleReturnScope whereClause8 =null;
		ParserRuleReturnScope orderByClause9 =null;

		CommonTree SELECT4_tree=null;
		CommonTree FROM6_tree=null;
		CommonTree SEMI10_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:26:2: ( SELECT columns FROM table ( whereClause )? ( orderByClause )? SEMI )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:26:4: SELECT columns FROM table ( whereClause )? ( orderByClause )? SEMI
			{
			root_0 = (CommonTree)adaptor.nil();


			SELECT4=(Token)match(input,SELECT,FOLLOW_SELECT_in_select82); 
			SELECT4_tree = (CommonTree)adaptor.create(SELECT4);
			adaptor.addChild(root_0, SELECT4_tree);

			pushFollow(FOLLOW_columns_in_select84);
			columns5=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns5.getTree());

			FROM6=(Token)match(input,FROM,FOLLOW_FROM_in_select86); 
			FROM6_tree = (CommonTree)adaptor.create(FROM6);
			adaptor.addChild(root_0, FROM6_tree);

			pushFollow(FOLLOW_table_in_select88);
			table7=table();
			state._fsp--;

			adaptor.addChild(root_0, table7.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:26:30: ( whereClause )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==WHERE) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:26:31: whereClause
					{
					pushFollow(FOLLOW_whereClause_in_select91);
					whereClause8=whereClause();
					state._fsp--;

					adaptor.addChild(root_0, whereClause8.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:26:45: ( orderByClause )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ORDER_BY) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:26:46: orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_select96);
					orderByClause9=orderByClause();
					state._fsp--;

					adaptor.addChild(root_0, orderByClause9.getTree());

					}
					break;

			}

			SEMI10=(Token)match(input,SEMI,FOLLOW_SEMI_in_select100); 
			SEMI10_tree = (CommonTree)adaptor.create(SEMI10);
			adaptor.addChild(root_0, SEMI10_tree);

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:1: insert : INSERT INTO table LPAREN columns RPAREN VALUES LPAREN values RPAREN SEMI ;
	public final SQLParser.insert_return insert() throws RecognitionException {
		SQLParser.insert_return retval = new SQLParser.insert_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INSERT11=null;
		Token INTO12=null;
		Token LPAREN14=null;
		Token RPAREN16=null;
		Token VALUES17=null;
		Token LPAREN18=null;
		Token RPAREN20=null;
		Token SEMI21=null;
		ParserRuleReturnScope table13 =null;
		ParserRuleReturnScope columns15 =null;
		ParserRuleReturnScope values19 =null;

		CommonTree INSERT11_tree=null;
		CommonTree INTO12_tree=null;
		CommonTree LPAREN14_tree=null;
		CommonTree RPAREN16_tree=null;
		CommonTree VALUES17_tree=null;
		CommonTree LPAREN18_tree=null;
		CommonTree RPAREN20_tree=null;
		CommonTree SEMI21_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:30:2: ( INSERT INTO table LPAREN columns RPAREN VALUES LPAREN values RPAREN SEMI )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:30:4: INSERT INTO table LPAREN columns RPAREN VALUES LPAREN values RPAREN SEMI
			{
			root_0 = (CommonTree)adaptor.nil();


			INSERT11=(Token)match(input,INSERT,FOLLOW_INSERT_in_insert112); 
			INSERT11_tree = (CommonTree)adaptor.create(INSERT11);
			adaptor.addChild(root_0, INSERT11_tree);

			INTO12=(Token)match(input,INTO,FOLLOW_INTO_in_insert114); 
			INTO12_tree = (CommonTree)adaptor.create(INTO12);
			adaptor.addChild(root_0, INTO12_tree);

			pushFollow(FOLLOW_table_in_insert116);
			table13=table();
			state._fsp--;

			adaptor.addChild(root_0, table13.getTree());

			LPAREN14=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_insert118); 
			LPAREN14_tree = (CommonTree)adaptor.create(LPAREN14);
			adaptor.addChild(root_0, LPAREN14_tree);

			pushFollow(FOLLOW_columns_in_insert120);
			columns15=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns15.getTree());

			RPAREN16=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_insert122); 
			RPAREN16_tree = (CommonTree)adaptor.create(RPAREN16);
			adaptor.addChild(root_0, RPAREN16_tree);

			VALUES17=(Token)match(input,VALUES,FOLLOW_VALUES_in_insert124); 
			VALUES17_tree = (CommonTree)adaptor.create(VALUES17);
			adaptor.addChild(root_0, VALUES17_tree);

			LPAREN18=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_insert126); 
			LPAREN18_tree = (CommonTree)adaptor.create(LPAREN18);
			adaptor.addChild(root_0, LPAREN18_tree);

			pushFollow(FOLLOW_values_in_insert128);
			values19=values();
			state._fsp--;

			adaptor.addChild(root_0, values19.getTree());

			RPAREN20=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_insert130); 
			RPAREN20_tree = (CommonTree)adaptor.create(RPAREN20);
			adaptor.addChild(root_0, RPAREN20_tree);

			SEMI21=(Token)match(input,SEMI,FOLLOW_SEMI_in_insert132); 
			SEMI21_tree = (CommonTree)adaptor.create(SEMI21);
			adaptor.addChild(root_0, SEMI21_tree);

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:33:1: update : UPDATE table SET assignments whereClause SEMI ;
	public final SQLParser.update_return update() throws RecognitionException {
		SQLParser.update_return retval = new SQLParser.update_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UPDATE22=null;
		Token SET24=null;
		Token SEMI27=null;
		ParserRuleReturnScope table23 =null;
		ParserRuleReturnScope assignments25 =null;
		ParserRuleReturnScope whereClause26 =null;

		CommonTree UPDATE22_tree=null;
		CommonTree SET24_tree=null;
		CommonTree SEMI27_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:34:2: ( UPDATE table SET assignments whereClause SEMI )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:34:4: UPDATE table SET assignments whereClause SEMI
			{
			root_0 = (CommonTree)adaptor.nil();


			UPDATE22=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_update144); 
			UPDATE22_tree = (CommonTree)adaptor.create(UPDATE22);
			adaptor.addChild(root_0, UPDATE22_tree);

			pushFollow(FOLLOW_table_in_update146);
			table23=table();
			state._fsp--;

			adaptor.addChild(root_0, table23.getTree());

			SET24=(Token)match(input,SET,FOLLOW_SET_in_update148); 
			SET24_tree = (CommonTree)adaptor.create(SET24);
			adaptor.addChild(root_0, SET24_tree);

			pushFollow(FOLLOW_assignments_in_update150);
			assignments25=assignments();
			state._fsp--;

			adaptor.addChild(root_0, assignments25.getTree());

			pushFollow(FOLLOW_whereClause_in_update152);
			whereClause26=whereClause();
			state._fsp--;

			adaptor.addChild(root_0, whereClause26.getTree());

			SEMI27=(Token)match(input,SEMI,FOLLOW_SEMI_in_update154); 
			SEMI27_tree = (CommonTree)adaptor.create(SEMI27);
			adaptor.addChild(root_0, SEMI27_tree);

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


	public static class assignments_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignments"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:37:1: assignments : assignment ( COMMA assignment )* ;
	public final SQLParser.assignments_return assignments() throws RecognitionException {
		SQLParser.assignments_return retval = new SQLParser.assignments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA29=null;
		ParserRuleReturnScope assignment28 =null;
		ParserRuleReturnScope assignment30 =null;

		CommonTree COMMA29_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:38:2: ( assignment ( COMMA assignment )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:38:4: assignment ( COMMA assignment )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_assignment_in_assignments166);
			assignment28=assignment();
			state._fsp--;

			adaptor.addChild(root_0, assignment28.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:38:15: ( COMMA assignment )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==COMMA) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:38:16: COMMA assignment
					{
					COMMA29=(Token)match(input,COMMA,FOLLOW_COMMA_in_assignments169); 
					COMMA29_tree = (CommonTree)adaptor.create(COMMA29);
					adaptor.addChild(root_0, COMMA29_tree);

					pushFollow(FOLLOW_assignment_in_assignments171);
					assignment30=assignment();
					state._fsp--;

					adaptor.addChild(root_0, assignment30.getTree());

					}
					break;

				default :
					break loop4;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:41:1: assignment : column EQUAL value ;
	public final SQLParser.assignment_return assignment() throws RecognitionException {
		SQLParser.assignment_return retval = new SQLParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQUAL32=null;
		ParserRuleReturnScope column31 =null;
		ParserRuleReturnScope value33 =null;

		CommonTree EQUAL32_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:42:2: ( column EQUAL value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:42:4: column EQUAL value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_assignment185);
			column31=column();
			state._fsp--;

			adaptor.addChild(root_0, column31.getTree());

			EQUAL32=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_assignment187); 
			EQUAL32_tree = (CommonTree)adaptor.create(EQUAL32);
			adaptor.addChild(root_0, EQUAL32_tree);

			pushFollow(FOLLOW_value_in_assignment189);
			value33=value();
			state._fsp--;

			adaptor.addChild(root_0, value33.getTree());

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


	public static class columns_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "columns"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:45:1: columns : column ( COMMA column )* ;
	public final SQLParser.columns_return columns() throws RecognitionException {
		SQLParser.columns_return retval = new SQLParser.columns_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA35=null;
		ParserRuleReturnScope column34 =null;
		ParserRuleReturnScope column36 =null;

		CommonTree COMMA35_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:46:2: ( column ( COMMA column )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:46:4: column ( COMMA column )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_columns201);
			column34=column();
			state._fsp--;

			adaptor.addChild(root_0, column34.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:46:11: ( COMMA column )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==COMMA) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:46:12: COMMA column
					{
					COMMA35=(Token)match(input,COMMA,FOLLOW_COMMA_in_columns204); 
					COMMA35_tree = (CommonTree)adaptor.create(COMMA35);
					adaptor.addChild(root_0, COMMA35_tree);

					pushFollow(FOLLOW_column_in_columns206);
					column36=column();
					state._fsp--;

					adaptor.addChild(root_0, column36.getTree());

					}
					break;

				default :
					break loop5;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:49:1: column : IDENT ;
	public final SQLParser.column_return column() throws RecognitionException {
		SQLParser.column_return retval = new SQLParser.column_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT37=null;

		CommonTree IDENT37_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:53:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:53:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT37=(Token)match(input,IDENT,FOLLOW_IDENT_in_column223); 
			IDENT37_tree = (CommonTree)adaptor.create(IDENT37);
			adaptor.addChild(root_0, IDENT37_tree);

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


	public static class table_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "table"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:56:1: table : IDENT ;
	public final SQLParser.table_return table() throws RecognitionException {
		SQLParser.table_return retval = new SQLParser.table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT38=null;

		CommonTree IDENT38_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:60:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:60:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT38=(Token)match(input,IDENT,FOLLOW_IDENT_in_table239); 
			IDENT38_tree = (CommonTree)adaptor.create(IDENT38);
			adaptor.addChild(root_0, IDENT38_tree);

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


	public static class whereClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "whereClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:63:1: whereClause : WHERE searchConditions ;
	public final SQLParser.whereClause_return whereClause() throws RecognitionException {
		SQLParser.whereClause_return retval = new SQLParser.whereClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHERE39=null;
		ParserRuleReturnScope searchConditions40 =null;

		CommonTree WHERE39_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:64:2: ( WHERE searchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:64:4: WHERE searchConditions
			{
			root_0 = (CommonTree)adaptor.nil();


			WHERE39=(Token)match(input,WHERE,FOLLOW_WHERE_in_whereClause252); 
			WHERE39_tree = (CommonTree)adaptor.create(WHERE39);
			adaptor.addChild(root_0, WHERE39_tree);

			pushFollow(FOLLOW_searchConditions_in_whereClause254);
			searchConditions40=searchConditions();
			state._fsp--;

			adaptor.addChild(root_0, searchConditions40.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:67:1: orderByClause : ORDER_BY column ( COMMA column )* ( order )? ;
	public final SQLParser.orderByClause_return orderByClause() throws RecognitionException {
		SQLParser.orderByClause_return retval = new SQLParser.orderByClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ORDER_BY41=null;
		Token COMMA43=null;
		ParserRuleReturnScope column42 =null;
		ParserRuleReturnScope column44 =null;
		ParserRuleReturnScope order45 =null;

		CommonTree ORDER_BY41_tree=null;
		CommonTree COMMA43_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:68:2: ( ORDER_BY column ( COMMA column )* ( order )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:68:4: ORDER_BY column ( COMMA column )* ( order )?
			{
			root_0 = (CommonTree)adaptor.nil();


			ORDER_BY41=(Token)match(input,ORDER_BY,FOLLOW_ORDER_BY_in_orderByClause266); 
			ORDER_BY41_tree = (CommonTree)adaptor.create(ORDER_BY41);
			adaptor.addChild(root_0, ORDER_BY41_tree);

			pushFollow(FOLLOW_column_in_orderByClause268);
			column42=column();
			state._fsp--;

			adaptor.addChild(root_0, column42.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:68:20: ( COMMA column )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==COMMA) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:68:21: COMMA column
					{
					COMMA43=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderByClause271); 
					COMMA43_tree = (CommonTree)adaptor.create(COMMA43);
					adaptor.addChild(root_0, COMMA43_tree);

					pushFollow(FOLLOW_column_in_orderByClause273);
					column44=column();
					state._fsp--;

					adaptor.addChild(root_0, column44.getTree());

					}
					break;

				default :
					break loop6;
				}
			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:68:36: ( order )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==ASC||LA7_0==DESC) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:68:37: order
					{
					pushFollow(FOLLOW_order_in_orderByClause278);
					order45=order();
					state._fsp--;

					adaptor.addChild(root_0, order45.getTree());

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


	public static class order_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "order"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:71:1: order : ( ASC | DESC );
	public final SQLParser.order_return order() throws RecognitionException {
		SQLParser.order_return retval = new SQLParser.order_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set46=null;

		CommonTree set46_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:72:2: ( ASC | DESC )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set46=input.LT(1);
			if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set46));
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


	public static class searchConditions_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "searchConditions"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:76:1: searchConditions : searchCondition ( logicalOperator searchCondition )? ;
	public final SQLParser.searchConditions_return searchConditions() throws RecognitionException {
		SQLParser.searchConditions_return retval = new SQLParser.searchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope searchCondition47 =null;
		ParserRuleReturnScope logicalOperator48 =null;
		ParserRuleReturnScope searchCondition49 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:77:2: ( searchCondition ( logicalOperator searchCondition )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:77:4: searchCondition ( logicalOperator searchCondition )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_searchCondition_in_searchConditions309);
			searchCondition47=searchCondition();
			state._fsp--;

			adaptor.addChild(root_0, searchCondition47.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:77:20: ( logicalOperator searchCondition )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==AND||LA8_0==OR) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:77:21: logicalOperator searchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_searchConditions312);
					logicalOperator48=logicalOperator();
					state._fsp--;

					adaptor.addChild(root_0, logicalOperator48.getTree());

					pushFollow(FOLLOW_searchCondition_in_searchConditions314);
					searchCondition49=searchCondition();
					state._fsp--;

					adaptor.addChild(root_0, searchCondition49.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:80:1: searchCondition : column comparisonOperator value ;
	public final SQLParser.searchCondition_return searchCondition() throws RecognitionException {
		SQLParser.searchCondition_return retval = new SQLParser.searchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope column50 =null;
		ParserRuleReturnScope comparisonOperator51 =null;
		ParserRuleReturnScope value52 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:81:2: ( column comparisonOperator value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:81:4: column comparisonOperator value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_searchCondition328);
			column50=column();
			state._fsp--;

			adaptor.addChild(root_0, column50.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_searchCondition330);
			comparisonOperator51=comparisonOperator();
			state._fsp--;

			adaptor.addChild(root_0, comparisonOperator51.getTree());

			pushFollow(FOLLOW_value_in_searchCondition332);
			value52=value();
			state._fsp--;

			adaptor.addChild(root_0, value52.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:84:1: comparisonOperator : ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN );
	public final SQLParser.comparisonOperator_return comparisonOperator() throws RecognitionException {
		SQLParser.comparisonOperator_return retval = new SQLParser.comparisonOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set53=null;

		CommonTree set53_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:85:2: ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set53=input.LT(1);
			if ( input.LA(1)==EQUAL||(input.LA(1) >= GREATER_THAN && input.LA(1) <= GREATER_THAN_EQUAL)||(input.LA(1) >= LESS_THAN && input.LA(1) <= LESS_THAN_EQUAL)||input.LA(1)==NOT_EQUAL ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set53));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:93:1: logicalOperator : ( AND | OR );
	public final SQLParser.logicalOperator_return logicalOperator() throws RecognitionException {
		SQLParser.logicalOperator_return retval = new SQLParser.logicalOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set54=null;

		CommonTree set54_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:94:2: ( AND | OR )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set54=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==OR ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set54));
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
	// $ANTLR end "logicalOperator"


	public static class value_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:98:1: value : ( STRING_LITERAL | INTEGER );
	public final SQLParser.value_return value() throws RecognitionException {
		SQLParser.value_return retval = new SQLParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set55=null;

		CommonTree set55_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:99:2: ( STRING_LITERAL | INTEGER )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set55=input.LT(1);
			if ( input.LA(1)==INTEGER||input.LA(1)==STRING_LITERAL ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set55));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:1: values : value ( COMMA value )* ;
	public final SQLParser.values_return values() throws RecognitionException {
		SQLParser.values_return retval = new SQLParser.values_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA57=null;
		ParserRuleReturnScope value56 =null;
		ParserRuleReturnScope value58 =null;

		CommonTree COMMA57_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:2: ( value ( COMMA value )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:4: value ( COMMA value )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_value_in_values416);
			value56=value();
			state._fsp--;

			adaptor.addChild(root_0, value56.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:10: ( COMMA value )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==COMMA) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:11: COMMA value
					{
					COMMA57=(Token)match(input,COMMA,FOLLOW_COMMA_in_values419); 
					COMMA57_tree = (CommonTree)adaptor.create(COMMA57);
					adaptor.addChild(root_0, COMMA57_tree);

					pushFollow(FOLLOW_value_in_values421);
					value58=value();
					state._fsp--;

					adaptor.addChild(root_0, value58.getTree());

					}
					break;

				default :
					break loop9;
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

	// Delegated rules



	public static final BitSet FOLLOW_select_in_statement60 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insert_in_statement65 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_update_in_statement70 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_select82 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_columns_in_select84 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_FROM_in_select86 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_table_in_select88 = new BitSet(new long[]{0x0000000084800000L});
	public static final BitSet FOLLOW_whereClause_in_select91 = new BitSet(new long[]{0x0000000004800000L});
	public static final BitSet FOLLOW_orderByClause_in_select96 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMI_in_select100 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_in_insert112 = new BitSet(new long[]{0x0000000000010000L});
	public static final BitSet FOLLOW_INTO_in_insert114 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_table_in_insert116 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_LPAREN_in_insert118 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_columns_in_insert120 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RPAREN_in_insert122 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_VALUES_in_insert124 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_LPAREN_in_insert126 = new BitSet(new long[]{0x0000000010008000L});
	public static final BitSet FOLLOW_values_in_insert128 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RPAREN_in_insert130 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMI_in_insert132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_update144 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_table_in_update146 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_SET_in_update148 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_assignments_in_update150 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_whereClause_in_update152 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMI_in_update154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_assignment_in_assignments166 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_assignments169 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_assignment_in_assignments171 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_column_in_assignment185 = new BitSet(new long[]{0x0000000000000200L});
	public static final BitSet FOLLOW_EQUAL_in_assignment187 = new BitSet(new long[]{0x0000000010008000L});
	public static final BitSet FOLLOW_value_in_assignment189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_columns201 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_columns204 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_column_in_columns206 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_IDENT_in_column223 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_table239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_whereClause252 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_searchConditions_in_whereClause254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_BY_in_orderByClause266 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_column_in_orderByClause268 = new BitSet(new long[]{0x00000000000000E2L});
	public static final BitSet FOLLOW_COMMA_in_orderByClause271 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_column_in_orderByClause273 = new BitSet(new long[]{0x00000000000000E2L});
	public static final BitSet FOLLOW_order_in_orderByClause278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions309 = new BitSet(new long[]{0x0000000000400012L});
	public static final BitSet FOLLOW_logicalOperator_in_searchConditions312 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions314 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_searchCondition328 = new BitSet(new long[]{0x0000000000261A00L});
	public static final BitSet FOLLOW_comparisonOperator_in_searchCondition330 = new BitSet(new long[]{0x0000000010008000L});
	public static final BitSet FOLLOW_value_in_searchCondition332 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_values416 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_values419 = new BitSet(new long[]{0x0000000010008000L});
	public static final BitSet FOLLOW_value_in_values421 = new BitSet(new long[]{0x0000000000000042L});
}
