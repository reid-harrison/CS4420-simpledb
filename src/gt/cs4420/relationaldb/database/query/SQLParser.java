// $ANTLR 3.5 C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g 2013-03-27 16:52:35

package gt.cs4420.relationaldb.database.query;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class SQLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "COMMENT", "DIGIT", "IDENT", "INTEGER", 
		"LETTER", "STRING_LITERAL", "WS", "'!='", "'('", "')'", "','", "';'", 
		"'<'", "'<='", "'='", "'>'", "'>='", "'and'", "'from'", "'insert'", "'into'", 
		"'or'", "'select'", "'values'", "'where'"
	};
	public static final int EOF=-1;
	public static final int T__11=11;
	public static final int T__12=12;
	public static final int T__13=13;
	public static final int T__14=14;
	public static final int T__15=15;
	public static final int T__16=16;
	public static final int T__17=17;
	public static final int T__18=18;
	public static final int T__19=19;
	public static final int T__20=20;
	public static final int T__21=21;
	public static final int T__22=22;
	public static final int T__23=23;
	public static final int T__24=24;
	public static final int T__25=25;
	public static final int T__26=26;
	public static final int T__27=27;
	public static final int T__28=28;
	public static final int COMMENT=4;
	public static final int DIGIT=5;
	public static final int IDENT=6;
	public static final int INTEGER=7;
	public static final int LETTER=8;
	public static final int STRING_LITERAL=9;
	public static final int WS=10;

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:22:1: statement : ( select | insert );
	public final SQLParser.statement_return statement() throws RecognitionException {
		SQLParser.statement_return retval = new SQLParser.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope select1 =null;
		ParserRuleReturnScope insert2 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:23:2: ( select | insert )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0==26) ) {
				alt1=1;
			}
			else if ( (LA1_0==23) ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:23:4: select
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_select_in_statement63);
					select1=select();
					state._fsp--;

					adaptor.addChild(root_0, select1.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:24:4: insert
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_insert_in_statement68);
					insert2=insert();
					state._fsp--;

					adaptor.addChild(root_0, insert2.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:28:1: select : 'select' ^ columns 'from' ^ table ( whereClause )? ( orderByClause )? ';' !;
	public final SQLParser.select_return select() throws RecognitionException {
		SQLParser.select_return retval = new SQLParser.select_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal3=null;
		Token string_literal5=null;
		Token char_literal9=null;
		ParserRuleReturnScope columns4 =null;
		ParserRuleReturnScope table6 =null;
		ParserRuleReturnScope whereClause7 =null;
		ParserRuleReturnScope orderByClause8 =null;

		CommonTree string_literal3_tree=null;
		CommonTree string_literal5_tree=null;
		CommonTree char_literal9_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:2: ( 'select' ^ columns 'from' ^ table ( whereClause )? ( orderByClause )? ';' !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:4: 'select' ^ columns 'from' ^ table ( whereClause )? ( orderByClause )? ';' !
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal3=(Token)match(input,26,FOLLOW_26_in_select81); 
			string_literal3_tree = (CommonTree)adaptor.create(string_literal3);
			root_0 = (CommonTree)adaptor.becomeRoot(string_literal3_tree, root_0);

			pushFollow(FOLLOW_columns_in_select84);
			columns4=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns4.getTree());

			string_literal5=(Token)match(input,22,FOLLOW_22_in_select86); 
			string_literal5_tree = (CommonTree)adaptor.create(string_literal5);
			root_0 = (CommonTree)adaptor.becomeRoot(string_literal5_tree, root_0);

			pushFollow(FOLLOW_table_in_select89);
			table6=table();
			state._fsp--;

			adaptor.addChild(root_0, table6.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:36: ( whereClause )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==28) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:37: whereClause
					{
					pushFollow(FOLLOW_whereClause_in_select92);
					whereClause7=whereClause();
					state._fsp--;

					adaptor.addChild(root_0, whereClause7.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:51: ( orderByClause )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==IDENT) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:29:52: orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_select97);
					orderByClause8=orderByClause();
					state._fsp--;

					adaptor.addChild(root_0, orderByClause8.getTree());

					}
					break;

			}

			char_literal9=(Token)match(input,15,FOLLOW_15_in_select101); 
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


	public static class columns_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "columns"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:32:1: columns : column ( ',' ! column )* ;
	public final SQLParser.columns_return columns() throws RecognitionException {
		SQLParser.columns_return retval = new SQLParser.columns_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal11=null;
		ParserRuleReturnScope column10 =null;
		ParserRuleReturnScope column12 =null;

		CommonTree char_literal11_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:33:2: ( column ( ',' ! column )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:33:4: column ( ',' ! column )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_columns114);
			column10=column();
			state._fsp--;

			adaptor.addChild(root_0, column10.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:33:11: ( ',' ! column )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==14) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:33:12: ',' ! column
					{
					char_literal11=(Token)match(input,14,FOLLOW_14_in_columns117); 
					pushFollow(FOLLOW_column_in_columns120);
					column12=column();
					state._fsp--;

					adaptor.addChild(root_0, column12.getTree());

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
	// $ANTLR end "columns"


	public static class column_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "column"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:36:1: column : IDENT ;
	public final SQLParser.column_return column() throws RecognitionException {
		SQLParser.column_return retval = new SQLParser.column_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT13=null;

		CommonTree IDENT13_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:37:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:37:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT13=(Token)match(input,IDENT,FOLLOW_IDENT_in_column134); 
			IDENT13_tree = (CommonTree)adaptor.create(IDENT13);
			adaptor.addChild(root_0, IDENT13_tree);

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:41:1: table : IDENT ;
	public final SQLParser.table_return table() throws RecognitionException {
		SQLParser.table_return retval = new SQLParser.table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT14=null;

		CommonTree IDENT14_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:49:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:49:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT14=(Token)match(input,IDENT,FOLLOW_IDENT_in_table151); 
			IDENT14_tree = (CommonTree)adaptor.create(IDENT14);
			adaptor.addChild(root_0, IDENT14_tree);

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:52:1: whereClause : 'where' searchCondition ;
	public final SQLParser.whereClause_return whereClause() throws RecognitionException {
		SQLParser.whereClause_return retval = new SQLParser.whereClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal15=null;
		ParserRuleReturnScope searchCondition16 =null;

		CommonTree string_literal15_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:53:2: ( 'where' searchCondition )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:53:4: 'where' searchCondition
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal15=(Token)match(input,28,FOLLOW_28_in_whereClause164); 
			string_literal15_tree = (CommonTree)adaptor.create(string_literal15);
			adaptor.addChild(root_0, string_literal15_tree);

			pushFollow(FOLLOW_searchCondition_in_whereClause166);
			searchCondition16=searchCondition();
			state._fsp--;

			adaptor.addChild(root_0, searchCondition16.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:56:1: orderByClause : IDENT ( ',' IDENT )* ;
	public final SQLParser.orderByClause_return orderByClause() throws RecognitionException {
		SQLParser.orderByClause_return retval = new SQLParser.orderByClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT17=null;
		Token char_literal18=null;
		Token IDENT19=null;

		CommonTree IDENT17_tree=null;
		CommonTree char_literal18_tree=null;
		CommonTree IDENT19_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:57:2: ( IDENT ( ',' IDENT )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:57:4: IDENT ( ',' IDENT )*
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT17=(Token)match(input,IDENT,FOLLOW_IDENT_in_orderByClause178); 
			IDENT17_tree = (CommonTree)adaptor.create(IDENT17);
			adaptor.addChild(root_0, IDENT17_tree);

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:57:10: ( ',' IDENT )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0==14) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:57:11: ',' IDENT
					{
					char_literal18=(Token)match(input,14,FOLLOW_14_in_orderByClause181); 
					char_literal18_tree = (CommonTree)adaptor.create(char_literal18);
					adaptor.addChild(root_0, char_literal18_tree);

					IDENT19=(Token)match(input,IDENT,FOLLOW_IDENT_in_orderByClause183); 
					IDENT19_tree = (CommonTree)adaptor.create(IDENT19);
					adaptor.addChild(root_0, IDENT19_tree);

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
	// $ANTLR end "orderByClause"


	public static class searchCondition_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "searchCondition"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:60:1: searchCondition :;
	public final SQLParser.searchCondition_return searchCondition() throws RecognitionException {
		SQLParser.searchCondition_return retval = new SQLParser.searchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:61:2: ()
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:62:2: 
			{
			root_0 = (CommonTree)adaptor.nil();


			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:64:1: comparisonOperator : ( '=' | '!=' | '<=' | '<' | '>=' | '>' );
	public final SQLParser.comparisonOperator_return comparisonOperator() throws RecognitionException {
		SQLParser.comparisonOperator_return retval = new SQLParser.comparisonOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set20=null;

		CommonTree set20_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:65:2: ( '=' | '!=' | '<=' | '<' | '>=' | '>' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set20=input.LT(1);
			if ( input.LA(1)==11||(input.LA(1) >= 16 && input.LA(1) <= 20) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set20));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:73:1: logicalOperator : ( 'and' | 'or' );
	public final SQLParser.logicalOperator_return logicalOperator() throws RecognitionException {
		SQLParser.logicalOperator_return retval = new SQLParser.logicalOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set21=null;

		CommonTree set21_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:74:2: ( 'and' | 'or' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set21=input.LT(1);
			if ( input.LA(1)==21||input.LA(1)==25 ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set21));
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


	public static class insert_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "insert"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:78:1: insert : 'insert' ^ 'into' table 'values' ^ '(' ! values ')' ! ';' !;
	public final SQLParser.insert_return insert() throws RecognitionException {
		SQLParser.insert_return retval = new SQLParser.insert_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token string_literal22=null;
		Token string_literal23=null;
		Token string_literal25=null;
		Token char_literal26=null;
		Token char_literal28=null;
		Token char_literal29=null;
		ParserRuleReturnScope table24 =null;
		ParserRuleReturnScope values27 =null;

		CommonTree string_literal22_tree=null;
		CommonTree string_literal23_tree=null;
		CommonTree string_literal25_tree=null;
		CommonTree char_literal26_tree=null;
		CommonTree char_literal28_tree=null;
		CommonTree char_literal29_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:79:2: ( 'insert' ^ 'into' table 'values' ^ '(' ! values ')' ! ';' !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:79:4: 'insert' ^ 'into' table 'values' ^ '(' ! values ')' ! ';' !
			{
			root_0 = (CommonTree)adaptor.nil();


			string_literal22=(Token)match(input,23,FOLLOW_23_in_insert261); 
			string_literal22_tree = (CommonTree)adaptor.create(string_literal22);
			root_0 = (CommonTree)adaptor.becomeRoot(string_literal22_tree, root_0);

			string_literal23=(Token)match(input,24,FOLLOW_24_in_insert264); 
			string_literal23_tree = (CommonTree)adaptor.create(string_literal23);
			adaptor.addChild(root_0, string_literal23_tree);

			pushFollow(FOLLOW_table_in_insert266);
			table24=table();
			state._fsp--;

			adaptor.addChild(root_0, table24.getTree());

			string_literal25=(Token)match(input,27,FOLLOW_27_in_insert268); 
			string_literal25_tree = (CommonTree)adaptor.create(string_literal25);
			root_0 = (CommonTree)adaptor.becomeRoot(string_literal25_tree, root_0);

			char_literal26=(Token)match(input,12,FOLLOW_12_in_insert271); 
			pushFollow(FOLLOW_values_in_insert274);
			values27=values();
			state._fsp--;

			adaptor.addChild(root_0, values27.getTree());

			char_literal28=(Token)match(input,13,FOLLOW_13_in_insert276); 
			char_literal29=(Token)match(input,15,FOLLOW_15_in_insert279); 
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


	public static class value_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "value"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:82:1: value : ( STRING_LITERAL | INTEGER );
	public final SQLParser.value_return value() throws RecognitionException {
		SQLParser.value_return retval = new SQLParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set30=null;

		CommonTree set30_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:83:2: ( STRING_LITERAL | INTEGER )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set30=input.LT(1);
			if ( input.LA(1)==INTEGER||input.LA(1)==STRING_LITERAL ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set30));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:87:1: values : value ( ',' ! value )* ;
	public final SQLParser.values_return values() throws RecognitionException {
		SQLParser.values_return retval = new SQLParser.values_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token char_literal32=null;
		ParserRuleReturnScope value31 =null;
		ParserRuleReturnScope value33 =null;

		CommonTree char_literal32_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:88:2: ( value ( ',' ! value )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:88:4: value ( ',' ! value )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_value_in_values310);
			value31=value();
			state._fsp--;

			adaptor.addChild(root_0, value31.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:88:10: ( ',' ! value )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==14) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:88:11: ',' ! value
					{
					char_literal32=(Token)match(input,14,FOLLOW_14_in_values313); 
					pushFollow(FOLLOW_value_in_values316);
					value33=value();
					state._fsp--;

					adaptor.addChild(root_0, value33.getTree());

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
	// $ANTLR end "values"

	// Delegated rules



	public static final BitSet FOLLOW_select_in_statement63 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insert_in_statement68 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_26_in_select81 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_columns_in_select84 = new BitSet(new long[]{0x0000000000400000L});
	public static final BitSet FOLLOW_22_in_select86 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_table_in_select89 = new BitSet(new long[]{0x0000000010008040L});
	public static final BitSet FOLLOW_whereClause_in_select92 = new BitSet(new long[]{0x0000000000008040L});
	public static final BitSet FOLLOW_orderByClause_in_select97 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_select101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_columns114 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_columns117 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_column_in_columns120 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_IDENT_in_column134 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_table151 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_28_in_whereClause164 = new BitSet(new long[]{0x0000000000000000L});
	public static final BitSet FOLLOW_searchCondition_in_whereClause166 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_orderByClause178 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_orderByClause181 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_IDENT_in_orderByClause183 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_23_in_insert261 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_24_in_insert264 = new BitSet(new long[]{0x0000000000000040L});
	public static final BitSet FOLLOW_table_in_insert266 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_27_in_insert268 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_12_in_insert271 = new BitSet(new long[]{0x0000000000000280L});
	public static final BitSet FOLLOW_values_in_insert274 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_13_in_insert276 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_15_in_insert279 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_values310 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_14_in_values313 = new BitSet(new long[]{0x0000000000000280L});
	public static final BitSet FOLLOW_value_in_values316 = new BitSet(new long[]{0x0000000000004002L});
}
