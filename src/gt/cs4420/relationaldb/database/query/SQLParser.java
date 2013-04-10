// $ANTLR 3.5 C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g 2013-04-10 01:22:49

///////////////////////////////////////////////////////////////////
//                                                               //
//   THIS IS A DERIVED FILE! MAKE ANY DESIRED CHANGES IN SQL.g   //
//                                                               //
///////////////////////////////////////////////////////////////////

package gt.cs4420.relationaldb.database.query;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.database.storage.StorageManager;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.Map;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.runtime.tree.*;


@SuppressWarnings("all")
public class SQLParser extends Parser {
	public static final String[] tokenNames = new String[] {
		"<invalid>", "<EOR>", "<DOWN>", "<UP>", "AND", "ASC", "COMMA", "COMMENT", 
		"DESC", "DIGIT", "DOT", "EQUAL", "FROM", "GREATER_THAN", "GREATER_THAN_EQUAL", 
		"IDENT", "INNER_JOIN", "INSERT_INTO", "INTEGER", "JOIN", "LEFT_JOIN", 
		"LESS_THAN", "LESS_THAN_EQUAL", "LETTER", "LPAREN", "NOT_EQUAL", "ON", 
		"OR", "ORDER_BY", "OUTER_JOIN", "RIGHT_JOIN", "RPAREN", "SELECT", "SEMI", 
		"SET", "STRING_LITERAL", "UPDATE", "VALUES", "WHERE", "WS"
	};
	public static final int EOF=-1;
	public static final int AND=4;
	public static final int ASC=5;
	public static final int COMMA=6;
	public static final int COMMENT=7;
	public static final int DESC=8;
	public static final int DIGIT=9;
	public static final int DOT=10;
	public static final int EQUAL=11;
	public static final int FROM=12;
	public static final int GREATER_THAN=13;
	public static final int GREATER_THAN_EQUAL=14;
	public static final int IDENT=15;
	public static final int INNER_JOIN=16;
	public static final int INSERT_INTO=17;
	public static final int INTEGER=18;
	public static final int JOIN=19;
	public static final int LEFT_JOIN=20;
	public static final int LESS_THAN=21;
	public static final int LESS_THAN_EQUAL=22;
	public static final int LETTER=23;
	public static final int LPAREN=24;
	public static final int NOT_EQUAL=25;
	public static final int ON=26;
	public static final int OR=27;
	public static final int ORDER_BY=28;
	public static final int OUTER_JOIN=29;
	public static final int RIGHT_JOIN=30;
	public static final int RPAREN=31;
	public static final int SELECT=32;
	public static final int SEMI=33;
	public static final int SET=34;
	public static final int STRING_LITERAL=35;
	public static final int UPDATE=36;
	public static final int VALUES=37;
	public static final int WHERE=38;
	public static final int WS=39;

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


		int numCols = 0;
		int numVals = 0;
		int numTables = 0;
		Table table1 = new Table();
		Table table2 = new Table();
		List<String> tables = Lists.newArrayList();
		List<Attribute> table1Attributes = Lists.newArrayList();
		List<Object> insertVals = Lists.newArrayList();
		Map<Attribute, Object> attrVals = Maps.newHashMap();
		//StorageManager storageManager = new StorageManager();
		
		@Override    
	    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e, tokenNames);
	        throw new RuntimeException(hdr + ":" + msg);
	    }


	public static class statement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:73:1: statement : ( select | insert | update | EOF );
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:74:2: ( select | insert | update | EOF )
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:74:4: select
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_select_in_statement84);
					select1=select();
					state._fsp--;

					adaptor.addChild(root_0, select1.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:75:4: insert
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_insert_in_statement89);
					insert2=insert();
					state._fsp--;

					adaptor.addChild(root_0, insert2.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:76:4: update
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_update_in_statement94);
					update3=update();
					state._fsp--;

					adaptor.addChild(root_0, update3.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:77:4: EOF
					{
					root_0 = (CommonTree)adaptor.nil();


					EOF4=(Token)match(input,EOF,FOLLOW_EOF_in_statement99); 
					EOF4_tree = (CommonTree)adaptor.create(EOF4);
					adaptor.addChild(root_0, EOF4_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:82:1: select : selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !;
	public final SQLParser.select_return select() throws RecognitionException {
		SQLParser.select_return retval = new SQLParser.select_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI10=null;
		ParserRuleReturnScope selectClause5 =null;
		ParserRuleReturnScope fromClause6 =null;
		ParserRuleReturnScope onClause7 =null;
		ParserRuleReturnScope whereClause8 =null;
		ParserRuleReturnScope orderByClause9 =null;

		CommonTree SEMI10_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:83:2: ( selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:83:4: selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_selectClause_in_select113);
			selectClause5=selectClause();
			state._fsp--;

			adaptor.addChild(root_0, selectClause5.getTree());

			pushFollow(FOLLOW_fromClause_in_select115);
			fromClause6=fromClause();
			state._fsp--;

			adaptor.addChild(root_0, fromClause6.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:83:28: ( onClause )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ON) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:83:29: onClause
					{
					pushFollow(FOLLOW_onClause_in_select118);
					onClause7=onClause();
					state._fsp--;

					adaptor.addChild(root_0, onClause7.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:83:40: ( whereClause )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==WHERE) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:83:41: whereClause
					{
					pushFollow(FOLLOW_whereClause_in_select123);
					whereClause8=whereClause();
					state._fsp--;

					adaptor.addChild(root_0, whereClause8.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:83:55: ( orderByClause )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ORDER_BY) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:83:56: orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_select128);
					orderByClause9=orderByClause();
					state._fsp--;

					adaptor.addChild(root_0, orderByClause9.getTree());

					}
					break;

			}

			SEMI10=(Token)match(input,SEMI,FOLLOW_SEMI_in_select132); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:86:1: insert : insertClause valuesClause SEMI !;
	public final SQLParser.insert_return insert() throws RecognitionException {
		SQLParser.insert_return retval = new SQLParser.insert_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI13=null;
		ParserRuleReturnScope insertClause11 =null;
		ParserRuleReturnScope valuesClause12 =null;

		CommonTree SEMI13_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:87:2: ( insertClause valuesClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:87:4: insertClause valuesClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_insertClause_in_insert145);
			insertClause11=insertClause();
			state._fsp--;

			adaptor.addChild(root_0, insertClause11.getTree());

			pushFollow(FOLLOW_valuesClause_in_insert147);
			valuesClause12=valuesClause();
			state._fsp--;

			adaptor.addChild(root_0, valuesClause12.getTree());

			SEMI13=(Token)match(input,SEMI,FOLLOW_SEMI_in_insert149); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:90:1: update : updateClause setClause whereClause SEMI !;
	public final SQLParser.update_return update() throws RecognitionException {
		SQLParser.update_return retval = new SQLParser.update_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI17=null;
		ParserRuleReturnScope updateClause14 =null;
		ParserRuleReturnScope setClause15 =null;
		ParserRuleReturnScope whereClause16 =null;

		CommonTree SEMI17_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:91:2: ( updateClause setClause whereClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:91:4: updateClause setClause whereClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_updateClause_in_update162);
			updateClause14=updateClause();
			state._fsp--;

			adaptor.addChild(root_0, updateClause14.getTree());

			pushFollow(FOLLOW_setClause_in_update164);
			setClause15=setClause();
			state._fsp--;

			adaptor.addChild(root_0, setClause15.getTree());

			pushFollow(FOLLOW_whereClause_in_update166);
			whereClause16=whereClause();
			state._fsp--;

			adaptor.addChild(root_0, whereClause16.getTree());

			SEMI17=(Token)match(input,SEMI,FOLLOW_SEMI_in_update168); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:99:1: selectClause : SELECT ^ columns ;
	public final SQLParser.selectClause_return selectClause() throws RecognitionException {
		SQLParser.selectClause_return retval = new SQLParser.selectClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SELECT18=null;
		ParserRuleReturnScope columns19 =null;

		CommonTree SELECT18_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:100:2: ( SELECT ^ columns )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:100:4: SELECT ^ columns
			{
			root_0 = (CommonTree)adaptor.nil();


			SELECT18=(Token)match(input,SELECT,FOLLOW_SELECT_in_selectClause191); 
			SELECT18_tree = (CommonTree)adaptor.create(SELECT18);
			root_0 = (CommonTree)adaptor.becomeRoot(SELECT18_tree, root_0);

			pushFollow(FOLLOW_columns_in_selectClause194);
			columns19=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns19.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:1: insertClause : INSERT_INTO ^ insertParams ;
	public final SQLParser.insertClause_return insertClause() throws RecognitionException {
		SQLParser.insertClause_return retval = new SQLParser.insertClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INSERT_INTO20=null;
		ParserRuleReturnScope insertParams21 =null;

		CommonTree INSERT_INTO20_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:2: ( INSERT_INTO ^ insertParams )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:4: INSERT_INTO ^ insertParams
			{
			root_0 = (CommonTree)adaptor.nil();


			INSERT_INTO20=(Token)match(input,INSERT_INTO,FOLLOW_INSERT_INTO_in_insertClause206); 
			INSERT_INTO20_tree = (CommonTree)adaptor.create(INSERT_INTO20);
			root_0 = (CommonTree)adaptor.becomeRoot(INSERT_INTO20_tree, root_0);

			pushFollow(FOLLOW_insertParams_in_insertClause209);
			insertParams21=insertParams();
			state._fsp--;

			adaptor.addChild(root_0, insertParams21.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:107:1: updateClause : UPDATE ^ table ;
	public final SQLParser.updateClause_return updateClause() throws RecognitionException {
		SQLParser.updateClause_return retval = new SQLParser.updateClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UPDATE22=null;
		ParserRuleReturnScope table23 =null;

		CommonTree UPDATE22_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:108:2: ( UPDATE ^ table )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:108:4: UPDATE ^ table
			{
			root_0 = (CommonTree)adaptor.nil();


			UPDATE22=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateClause221); 
			UPDATE22_tree = (CommonTree)adaptor.create(UPDATE22);
			root_0 = (CommonTree)adaptor.becomeRoot(UPDATE22_tree, root_0);

			pushFollow(FOLLOW_table_in_updateClause224);
			table23=table();
			state._fsp--;

			adaptor.addChild(root_0, table23.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:111:1: fromClause : FROM ^ tableClause ;
	public final SQLParser.fromClause_return fromClause() throws RecognitionException {
		SQLParser.fromClause_return retval = new SQLParser.fromClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FROM24=null;
		ParserRuleReturnScope tableClause25 =null;

		CommonTree FROM24_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:112:2: ( FROM ^ tableClause )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:112:4: FROM ^ tableClause
			{
			root_0 = (CommonTree)adaptor.nil();


			FROM24=(Token)match(input,FROM,FOLLOW_FROM_in_fromClause236); 
			FROM24_tree = (CommonTree)adaptor.create(FROM24);
			root_0 = (CommonTree)adaptor.becomeRoot(FROM24_tree, root_0);

			pushFollow(FOLLOW_tableClause_in_fromClause239);
			tableClause25=tableClause();
			state._fsp--;

			adaptor.addChild(root_0, tableClause25.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "fromClause"


	public static class tableClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "tableClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:115:1: tableClause : ( table | joinClause );
	public final SQLParser.tableClause_return tableClause() throws RecognitionException {
		SQLParser.tableClause_return retval = new SQLParser.tableClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope table26 =null;
		ParserRuleReturnScope joinClause27 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:116:2: ( table | joinClause )
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==IDENT) ) {
				int LA5_1 = input.LA(2);
				if ( (LA5_1==ON||LA5_1==ORDER_BY||LA5_1==SEMI||LA5_1==WHERE) ) {
					alt5=1;
				}
				else if ( (LA5_1==INNER_JOIN||(LA5_1 >= JOIN && LA5_1 <= LEFT_JOIN)||(LA5_1 >= OUTER_JOIN && LA5_1 <= RIGHT_JOIN)) ) {
					alt5=2;
				}

				else {
					int nvaeMark = input.mark();
					try {
						input.consume();
						NoViableAltException nvae =
							new NoViableAltException("", 5, 1, input);
						throw nvae;
					} finally {
						input.rewind(nvaeMark);
					}
				}

			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 5, 0, input);
				throw nvae;
			}

			switch (alt5) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:116:4: table
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_table_in_tableClause252);
					table26=table();
					state._fsp--;

					adaptor.addChild(root_0, table26.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:117:4: joinClause
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_joinClause_in_tableClause257);
					joinClause27=joinClause();
					state._fsp--;

					adaptor.addChild(root_0, joinClause27.getTree());

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "tableClause"


	public static class joinClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "joinClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:120:1: joinClause : table ( joinOperator ^ table )+ ;
	public final SQLParser.joinClause_return joinClause() throws RecognitionException {
		SQLParser.joinClause_return retval = new SQLParser.joinClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope table28 =null;
		ParserRuleReturnScope joinOperator29 =null;
		ParserRuleReturnScope table30 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:121:2: ( table ( joinOperator ^ table )+ )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:121:4: table ( joinOperator ^ table )+
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_table_in_joinClause269);
			table28=table();
			state._fsp--;

			adaptor.addChild(root_0, table28.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:121:10: ( joinOperator ^ table )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==INNER_JOIN||(LA6_0 >= JOIN && LA6_0 <= LEFT_JOIN)||(LA6_0 >= OUTER_JOIN && LA6_0 <= RIGHT_JOIN)) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:121:11: joinOperator ^ table
					{
					pushFollow(FOLLOW_joinOperator_in_joinClause272);
					joinOperator29=joinOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(joinOperator29.getTree(), root_0);
					pushFollow(FOLLOW_table_in_joinClause275);
					table30=table();
					state._fsp--;

					adaptor.addChild(root_0, table30.getTree());

					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "joinClause"


	public static class onClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "onClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:124:1: onClause : ON ^ onSearchConditions ;
	public final SQLParser.onClause_return onClause() throws RecognitionException {
		SQLParser.onClause_return retval = new SQLParser.onClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ON31=null;
		ParserRuleReturnScope onSearchConditions32 =null;

		CommonTree ON31_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:125:2: ( ON ^ onSearchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:125:4: ON ^ onSearchConditions
			{
			root_0 = (CommonTree)adaptor.nil();


			ON31=(Token)match(input,ON,FOLLOW_ON_in_onClause289); 
			ON31_tree = (CommonTree)adaptor.create(ON31);
			root_0 = (CommonTree)adaptor.becomeRoot(ON31_tree, root_0);

			pushFollow(FOLLOW_onSearchConditions_in_onClause292);
			onSearchConditions32=onSearchConditions();
			state._fsp--;

			adaptor.addChild(root_0, onSearchConditions32.getTree());


						//need to check for prior existence of a join taking place
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "onClause"


	public static class onTable_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "onTable"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:131:1: onTable : IDENT ;
	public final SQLParser.onTable_return onTable() throws RecognitionException {
		SQLParser.onTable_return retval = new SQLParser.onTable_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT33=null;

		CommonTree IDENT33_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:132:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:132:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT33=(Token)match(input,IDENT,FOLLOW_IDENT_in_onTable307); 
			IDENT33_tree = (CommonTree)adaptor.create(IDENT33);
			adaptor.addChild(root_0, IDENT33_tree);


						if (!tables.contains((IDENT33!=null?IDENT33.getText():null)))
						{
							throw new IllegalArgumentException("'" + (IDENT33!=null?IDENT33.getText():null) + "' is not a table from which items are being queried.");
						}
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "onTable"


	public static class joinOperator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "joinOperator"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:141:1: joinOperator : ( INNER_JOIN | OUTER_JOIN | LEFT_JOIN | RIGHT_JOIN | JOIN );
	public final SQLParser.joinOperator_return joinOperator() throws RecognitionException {
		SQLParser.joinOperator_return retval = new SQLParser.joinOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set34=null;

		CommonTree set34_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:142:2: ( INNER_JOIN | OUTER_JOIN | LEFT_JOIN | RIGHT_JOIN | JOIN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set34=input.LT(1);
			if ( input.LA(1)==INNER_JOIN||(input.LA(1) >= JOIN && input.LA(1) <= LEFT_JOIN)||(input.LA(1) >= OUTER_JOIN && input.LA(1) <= RIGHT_JOIN) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set34));
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

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "joinOperator"


	public static class whereClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "whereClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:149:1: whereClause : WHERE ^ searchConditions ;
	public final SQLParser.whereClause_return whereClause() throws RecognitionException {
		SQLParser.whereClause_return retval = new SQLParser.whereClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHERE35=null;
		ParserRuleReturnScope searchConditions36 =null;

		CommonTree WHERE35_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:150:2: ( WHERE ^ searchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:150:4: WHERE ^ searchConditions
			{
			root_0 = (CommonTree)adaptor.nil();


			WHERE35=(Token)match(input,WHERE,FOLLOW_WHERE_in_whereClause353); 
			WHERE35_tree = (CommonTree)adaptor.create(WHERE35);
			root_0 = (CommonTree)adaptor.becomeRoot(WHERE35_tree, root_0);

			pushFollow(FOLLOW_searchConditions_in_whereClause356);
			searchConditions36=searchConditions();
			state._fsp--;

			adaptor.addChild(root_0, searchConditions36.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:153:1: orderByClause : ORDER_BY ^ column ( COMMA ! column )* ( order )? ;
	public final SQLParser.orderByClause_return orderByClause() throws RecognitionException {
		SQLParser.orderByClause_return retval = new SQLParser.orderByClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ORDER_BY37=null;
		Token COMMA39=null;
		ParserRuleReturnScope column38 =null;
		ParserRuleReturnScope column40 =null;
		ParserRuleReturnScope order41 =null;

		CommonTree ORDER_BY37_tree=null;
		CommonTree COMMA39_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:154:2: ( ORDER_BY ^ column ( COMMA ! column )* ( order )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:154:4: ORDER_BY ^ column ( COMMA ! column )* ( order )?
			{
			root_0 = (CommonTree)adaptor.nil();


			ORDER_BY37=(Token)match(input,ORDER_BY,FOLLOW_ORDER_BY_in_orderByClause368); 
			ORDER_BY37_tree = (CommonTree)adaptor.create(ORDER_BY37);
			root_0 = (CommonTree)adaptor.becomeRoot(ORDER_BY37_tree, root_0);

			pushFollow(FOLLOW_column_in_orderByClause371);
			column38=column();
			state._fsp--;

			adaptor.addChild(root_0, column38.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:154:21: ( COMMA ! column )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMA) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:154:22: COMMA ! column
					{
					COMMA39=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderByClause374); 
					pushFollow(FOLLOW_column_in_orderByClause377);
					column40=column();
					state._fsp--;

					adaptor.addChild(root_0, column40.getTree());

					}
					break;

				default :
					break loop7;
				}
			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:154:38: ( order )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==ASC||LA8_0==DESC) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:154:39: order
					{
					pushFollow(FOLLOW_order_in_orderByClause382);
					order41=order();
					state._fsp--;

					adaptor.addChild(root_0, order41.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:157:1: valuesClause : VALUES ^ LPAREN ! values RPAREN !;
	public final SQLParser.valuesClause_return valuesClause() throws RecognitionException {
		SQLParser.valuesClause_return retval = new SQLParser.valuesClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VALUES42=null;
		Token LPAREN43=null;
		Token RPAREN45=null;
		ParserRuleReturnScope values44 =null;

		CommonTree VALUES42_tree=null;
		CommonTree LPAREN43_tree=null;
		CommonTree RPAREN45_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:158:2: ( VALUES ^ LPAREN ! values RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:158:4: VALUES ^ LPAREN ! values RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			VALUES42=(Token)match(input,VALUES,FOLLOW_VALUES_in_valuesClause396); 
			VALUES42_tree = (CommonTree)adaptor.create(VALUES42);
			root_0 = (CommonTree)adaptor.becomeRoot(VALUES42_tree, root_0);

			LPAREN43=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_valuesClause399); 
			pushFollow(FOLLOW_values_in_valuesClause402);
			values44=values();
			state._fsp--;

			adaptor.addChild(root_0, values44.getTree());

			RPAREN45=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_valuesClause404); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:161:1: setClause : SET ^ assignments ;
	public final SQLParser.setClause_return setClause() throws RecognitionException {
		SQLParser.setClause_return retval = new SQLParser.setClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SET46=null;
		ParserRuleReturnScope assignments47 =null;

		CommonTree SET46_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:162:2: ( SET ^ assignments )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:162:4: SET ^ assignments
			{
			root_0 = (CommonTree)adaptor.nil();


			SET46=(Token)match(input,SET,FOLLOW_SET_in_setClause416); 
			SET46_tree = (CommonTree)adaptor.create(SET46);
			root_0 = (CommonTree)adaptor.becomeRoot(SET46_tree, root_0);

			pushFollow(FOLLOW_assignments_in_setClause419);
			assignments47=assignments();
			state._fsp--;

			adaptor.addChild(root_0, assignments47.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:172:1: insertParams : table ^ LPAREN ! columns RPAREN !;
	public final SQLParser.insertParams_return insertParams() throws RecognitionException {
		SQLParser.insertParams_return retval = new SQLParser.insertParams_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN49=null;
		Token RPAREN51=null;
		ParserRuleReturnScope table48 =null;
		ParserRuleReturnScope columns50 =null;

		CommonTree LPAREN49_tree=null;
		CommonTree RPAREN51_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:173:2: ( table ^ LPAREN ! columns RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:173:4: table ^ LPAREN ! columns RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_table_in_insertParams439);
			table48=table();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(table48.getTree(), root_0);
			LPAREN49=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_insertParams442); 
			pushFollow(FOLLOW_columns_in_insertParams445);
			columns50=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns50.getTree());

			RPAREN51=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_insertParams447); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:176:1: table : IDENT ;
	public final SQLParser.table_return table() throws RecognitionException {
		SQLParser.table_return retval = new SQLParser.table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT52=null;

		CommonTree IDENT52_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:177:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:177:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT52=(Token)match(input,IDENT,FOLLOW_IDENT_in_table460); 
			IDENT52_tree = (CommonTree)adaptor.create(IDENT52);
			adaptor.addChild(root_0, IDENT52_tree);


						//build a Table for use with validation
						table1.setName((IDENT52!=null?IDENT52.getText():null));
						tables.add((IDENT52!=null?IDENT52.getText():null));
						//storageManager.validateTableExists(table1.getName());
						//table1.setDescription(storageManager.getTableDescription((IDENT52!=null?IDENT52.getText():null)));
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:187:1: columns : ( column ( COMMA ! column )* ) ;
	public final SQLParser.columns_return columns() throws RecognitionException {
		SQLParser.columns_return retval = new SQLParser.columns_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA54=null;
		ParserRuleReturnScope column53 =null;
		ParserRuleReturnScope column55 =null;

		CommonTree COMMA54_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:188:2: ( ( column ( COMMA ! column )* ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:188:4: ( column ( COMMA ! column )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:188:4: ( column ( COMMA ! column )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:188:5: column ( COMMA ! column )*
			{
			pushFollow(FOLLOW_column_in_columns476);
			column53=column();
			state._fsp--;

			adaptor.addChild(root_0, column53.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:188:12: ( COMMA ! column )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==COMMA) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:188:13: COMMA ! column
					{
					COMMA54=(Token)match(input,COMMA,FOLLOW_COMMA_in_columns479); 
					pushFollow(FOLLOW_column_in_columns482);
					column55=column();
					state._fsp--;

					adaptor.addChild(root_0, column55.getTree());

					}
					break;

				default :
					break loop9;
				}
			}

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:191:1: column : IDENT ;
	public final SQLParser.column_return column() throws RecognitionException {
		SQLParser.column_return retval = new SQLParser.column_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT56=null;

		CommonTree IDENT56_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:192:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:192:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_column497); 
			IDENT56_tree = (CommonTree)adaptor.create(IDENT56);
			adaptor.addChild(root_0, IDENT56_tree);


						numCols++;
						table1Attributes.add(new Attribute((IDENT56!=null?IDENT56.getText():null)));
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:199:1: value : ( STRING_LITERAL | INTEGER );
	public final SQLParser.value_return value() throws RecognitionException {
		SQLParser.value_return retval = new SQLParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL57=null;
		Token INTEGER58=null;

		CommonTree STRING_LITERAL57_tree=null;
		CommonTree INTEGER58_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:200:2: ( STRING_LITERAL | INTEGER )
			int alt10=2;
			int LA10_0 = input.LA(1);
			if ( (LA10_0==STRING_LITERAL) ) {
				alt10=1;
			}
			else if ( (LA10_0==INTEGER) ) {
				alt10=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 10, 0, input);
				throw nvae;
			}

			switch (alt10) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:200:4: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL57=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_value512); 
					STRING_LITERAL57_tree = (CommonTree)adaptor.create(STRING_LITERAL57);
					adaptor.addChild(root_0, STRING_LITERAL57_tree);


								insertVals.add(STRING_LITERAL57);
								numVals++;
							
					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:205:5: INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					INTEGER58=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value522); 
					INTEGER58_tree = (CommonTree)adaptor.create(INTEGER58);
					adaptor.addChild(root_0, INTEGER58_tree);


								insertVals.add(INTEGER58);
								numVals++;
							
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:212:1: values : ( value ( COMMA ! value )* ) ;
	public final SQLParser.values_return values() throws RecognitionException {
		SQLParser.values_return retval = new SQLParser.values_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA60=null;
		ParserRuleReturnScope value59 =null;
		ParserRuleReturnScope value61 =null;

		CommonTree COMMA60_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:213:2: ( ( value ( COMMA ! value )* ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:213:4: ( value ( COMMA ! value )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:213:4: ( value ( COMMA ! value )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:213:5: value ( COMMA ! value )*
			{
			pushFollow(FOLLOW_value_in_values539);
			value59=value();
			state._fsp--;

			adaptor.addChild(root_0, value59.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:213:11: ( COMMA ! value )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==COMMA) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:213:12: COMMA ! value
					{
					COMMA60=(Token)match(input,COMMA,FOLLOW_COMMA_in_values542); 
					pushFollow(FOLLOW_value_in_values545);
					value61=value();
					state._fsp--;

					adaptor.addChild(root_0, value61.getTree());

					}
					break;

				default :
					break loop11;
				}
			}

			}


						if (!(numVals == numCols))
						{
							throw new IllegalArgumentException(numCols + " columns specified and " + numVals + " values entered.");
						}	
						
						for(int i = 0; i < table1Attributes.size(); i++) {
							attrVals.put(table1Attributes.get(i), insertVals.get(i));			
						}
						
						//storageManager.validateValueTypes(attrVals, table1);
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:228:1: order : ( ASC | DESC );
	public final SQLParser.order_return order() throws RecognitionException {
		SQLParser.order_return retval = new SQLParser.order_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set62=null;

		CommonTree set62_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:229:2: ( ASC | DESC )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set62=input.LT(1);
			if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set62));
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

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:233:1: assignments : assignment ( COMMA ! assignment )* ;
	public final SQLParser.assignments_return assignments() throws RecognitionException {
		SQLParser.assignments_return retval = new SQLParser.assignments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA64=null;
		ParserRuleReturnScope assignment63 =null;
		ParserRuleReturnScope assignment65 =null;

		CommonTree COMMA64_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:234:2: ( assignment ( COMMA ! assignment )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:234:4: assignment ( COMMA ! assignment )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_assignment_in_assignments582);
			assignment63=assignment();
			state._fsp--;

			adaptor.addChild(root_0, assignment63.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:234:15: ( COMMA ! assignment )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==COMMA) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:234:16: COMMA ! assignment
					{
					COMMA64=(Token)match(input,COMMA,FOLLOW_COMMA_in_assignments585); 
					pushFollow(FOLLOW_assignment_in_assignments588);
					assignment65=assignment();
					state._fsp--;

					adaptor.addChild(root_0, assignment65.getTree());

					}
					break;

				default :
					break loop12;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:237:1: assignment : column EQUAL ^ value ;
	public final SQLParser.assignment_return assignment() throws RecognitionException {
		SQLParser.assignment_return retval = new SQLParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQUAL67=null;
		ParserRuleReturnScope column66 =null;
		ParserRuleReturnScope value68 =null;

		CommonTree EQUAL67_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:238:2: ( column EQUAL ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:238:4: column EQUAL ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_assignment602);
			column66=column();
			state._fsp--;

			adaptor.addChild(root_0, column66.getTree());

			EQUAL67=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_assignment604); 
			EQUAL67_tree = (CommonTree)adaptor.create(EQUAL67);
			root_0 = (CommonTree)adaptor.becomeRoot(EQUAL67_tree, root_0);

			pushFollow(FOLLOW_value_in_assignment607);
			value68=value();
			state._fsp--;

			adaptor.addChild(root_0, value68.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:241:1: searchConditions : searchCondition ( logicalOperator ^ searchCondition )* ;
	public final SQLParser.searchConditions_return searchConditions() throws RecognitionException {
		SQLParser.searchConditions_return retval = new SQLParser.searchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope searchCondition69 =null;
		ParserRuleReturnScope logicalOperator70 =null;
		ParserRuleReturnScope searchCondition71 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:2: ( searchCondition ( logicalOperator ^ searchCondition )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:4: searchCondition ( logicalOperator ^ searchCondition )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_searchCondition_in_searchConditions619);
			searchCondition69=searchCondition();
			state._fsp--;

			adaptor.addChild(root_0, searchCondition69.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:20: ( logicalOperator ^ searchCondition )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==AND||LA13_0==OR) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:21: logicalOperator ^ searchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_searchConditions622);
					logicalOperator70=logicalOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(logicalOperator70.getTree(), root_0);
					pushFollow(FOLLOW_searchCondition_in_searchConditions625);
					searchCondition71=searchCondition();
					state._fsp--;

					adaptor.addChild(root_0, searchCondition71.getTree());

					}
					break;

				default :
					break loop13;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:245:1: searchCondition : column comparisonOperator ^ value ;
	public final SQLParser.searchCondition_return searchCondition() throws RecognitionException {
		SQLParser.searchCondition_return retval = new SQLParser.searchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope column72 =null;
		ParserRuleReturnScope comparisonOperator73 =null;
		ParserRuleReturnScope value74 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:246:2: ( column comparisonOperator ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:246:4: column comparisonOperator ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_searchCondition639);
			column72=column();
			state._fsp--;

			adaptor.addChild(root_0, column72.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_searchCondition641);
			comparisonOperator73=comparisonOperator();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(comparisonOperator73.getTree(), root_0);
			pushFollow(FOLLOW_value_in_searchCondition644);
			value74=value();
			state._fsp--;

			adaptor.addChild(root_0, value74.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "searchCondition"


	public static class onSearchConditions_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "onSearchConditions"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:250:1: onSearchConditions : onSearchCondition ( logicalOperator ^ onSearchCondition )* ;
	public final SQLParser.onSearchConditions_return onSearchConditions() throws RecognitionException {
		SQLParser.onSearchConditions_return retval = new SQLParser.onSearchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope onSearchCondition75 =null;
		ParserRuleReturnScope logicalOperator76 =null;
		ParserRuleReturnScope onSearchCondition77 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:251:2: ( onSearchCondition ( logicalOperator ^ onSearchCondition )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:251:4: onSearchCondition ( logicalOperator ^ onSearchCondition )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_onSearchCondition_in_onSearchConditions659);
			onSearchCondition75=onSearchCondition();
			state._fsp--;

			adaptor.addChild(root_0, onSearchCondition75.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:251:22: ( logicalOperator ^ onSearchCondition )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==AND||LA14_0==OR) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:251:23: logicalOperator ^ onSearchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_onSearchConditions662);
					logicalOperator76=logicalOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(logicalOperator76.getTree(), root_0);
					pushFollow(FOLLOW_onSearchCondition_in_onSearchConditions665);
					onSearchCondition77=onSearchCondition();
					state._fsp--;

					adaptor.addChild(root_0, onSearchCondition77.getTree());

					}
					break;

				default :
					break loop14;
				}
			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "onSearchConditions"


	public static class onSearchCondition_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "onSearchCondition"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:254:1: onSearchCondition : onTable DOT ! column comparisonOperator ^ value ;
	public final SQLParser.onSearchCondition_return onSearchCondition() throws RecognitionException {
		SQLParser.onSearchCondition_return retval = new SQLParser.onSearchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DOT79=null;
		ParserRuleReturnScope onTable78 =null;
		ParserRuleReturnScope column80 =null;
		ParserRuleReturnScope comparisonOperator81 =null;
		ParserRuleReturnScope value82 =null;

		CommonTree DOT79_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:255:2: ( onTable DOT ! column comparisonOperator ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:255:4: onTable DOT ! column comparisonOperator ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_onTable_in_onSearchCondition678);
			onTable78=onTable();
			state._fsp--;

			adaptor.addChild(root_0, onTable78.getTree());

			DOT79=(Token)match(input,DOT,FOLLOW_DOT_in_onSearchCondition680); 
			pushFollow(FOLLOW_column_in_onSearchCondition683);
			column80=column();
			state._fsp--;

			adaptor.addChild(root_0, column80.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_onSearchCondition685);
			comparisonOperator81=comparisonOperator();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(comparisonOperator81.getTree(), root_0);
			pushFollow(FOLLOW_value_in_onSearchCondition688);
			value82=value();
			state._fsp--;

			adaptor.addChild(root_0, value82.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "onSearchCondition"


	public static class comparisonOperator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "comparisonOperator"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:265:1: comparisonOperator : ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN );
	public final SQLParser.comparisonOperator_return comparisonOperator() throws RecognitionException {
		SQLParser.comparisonOperator_return retval = new SQLParser.comparisonOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set83=null;

		CommonTree set83_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:266:2: ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set83=input.LT(1);
			if ( input.LA(1)==EQUAL||(input.LA(1) >= GREATER_THAN && input.LA(1) <= GREATER_THAN_EQUAL)||(input.LA(1) >= LESS_THAN && input.LA(1) <= LESS_THAN_EQUAL)||input.LA(1)==NOT_EQUAL ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set83));
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

		    catch (RecognitionException e) {
		        throw e;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:274:1: logicalOperator : ( AND ^| OR ^);
	public final SQLParser.logicalOperator_return logicalOperator() throws RecognitionException {
		SQLParser.logicalOperator_return retval = new SQLParser.logicalOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token AND84=null;
		Token OR85=null;

		CommonTree AND84_tree=null;
		CommonTree OR85_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:275:2: ( AND ^| OR ^)
			int alt15=2;
			int LA15_0 = input.LA(1);
			if ( (LA15_0==AND) ) {
				alt15=1;
			}
			else if ( (LA15_0==OR) ) {
				alt15=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 15, 0, input);
				throw nvae;
			}

			switch (alt15) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:275:4: AND ^
					{
					root_0 = (CommonTree)adaptor.nil();


					AND84=(Token)match(input,AND,FOLLOW_AND_in_logicalOperator749); 
					AND84_tree = (CommonTree)adaptor.create(AND84);
					root_0 = (CommonTree)adaptor.becomeRoot(AND84_tree, root_0);

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:276:4: OR ^
					{
					root_0 = (CommonTree)adaptor.nil();


					OR85=(Token)match(input,OR,FOLLOW_OR_in_logicalOperator755); 
					OR85_tree = (CommonTree)adaptor.create(OR85);
					root_0 = (CommonTree)adaptor.becomeRoot(OR85_tree, root_0);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "logicalOperator"

	// Delegated rules



	public static final BitSet FOLLOW_select_in_statement84 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insert_in_statement89 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_update_in_statement94 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_EOF_in_statement99 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectClause_in_select113 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_fromClause_in_select115 = new BitSet(new long[]{0x0000004214000000L});
	public static final BitSet FOLLOW_onClause_in_select118 = new BitSet(new long[]{0x0000004210000000L});
	public static final BitSet FOLLOW_whereClause_in_select123 = new BitSet(new long[]{0x0000000210000000L});
	public static final BitSet FOLLOW_orderByClause_in_select128 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SEMI_in_select132 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insertClause_in_insert145 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_valuesClause_in_insert147 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SEMI_in_insert149 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_updateClause_in_update162 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_setClause_in_update164 = new BitSet(new long[]{0x0000004000000000L});
	public static final BitSet FOLLOW_whereClause_in_update166 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_SEMI_in_update168 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_selectClause191 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_columns_in_selectClause194 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_INTO_in_insertClause206 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_insertParams_in_insertClause209 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_updateClause221 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_table_in_updateClause224 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_fromClause236 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_tableClause_in_fromClause239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_tableClause252 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_joinClause_in_tableClause257 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_joinClause269 = new BitSet(new long[]{0x0000000060190000L});
	public static final BitSet FOLLOW_joinOperator_in_joinClause272 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_table_in_joinClause275 = new BitSet(new long[]{0x0000000060190002L});
	public static final BitSet FOLLOW_ON_in_onClause289 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_onSearchConditions_in_onClause292 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_onTable307 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_whereClause353 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_searchConditions_in_whereClause356 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_BY_in_orderByClause368 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_column_in_orderByClause371 = new BitSet(new long[]{0x0000000000000162L});
	public static final BitSet FOLLOW_COMMA_in_orderByClause374 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_column_in_orderByClause377 = new BitSet(new long[]{0x0000000000000162L});
	public static final BitSet FOLLOW_order_in_orderByClause382 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUES_in_valuesClause396 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LPAREN_in_valuesClause399 = new BitSet(new long[]{0x0000000800040000L});
	public static final BitSet FOLLOW_values_in_valuesClause402 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_RPAREN_in_valuesClause404 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_setClause416 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_assignments_in_setClause419 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_insertParams439 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LPAREN_in_insertParams442 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_columns_in_insertParams445 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_RPAREN_in_insertParams447 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_table460 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_columns476 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_columns479 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_column_in_columns482 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_IDENT_in_column497 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_value512 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_value522 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_values539 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_values542 = new BitSet(new long[]{0x0000000800040000L});
	public static final BitSet FOLLOW_value_in_values545 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_assignment_in_assignments582 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_assignments585 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_assignment_in_assignments588 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_column_in_assignment602 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_EQUAL_in_assignment604 = new BitSet(new long[]{0x0000000800040000L});
	public static final BitSet FOLLOW_value_in_assignment607 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions619 = new BitSet(new long[]{0x0000000008000012L});
	public static final BitSet FOLLOW_logicalOperator_in_searchConditions622 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions625 = new BitSet(new long[]{0x0000000008000012L});
	public static final BitSet FOLLOW_column_in_searchCondition639 = new BitSet(new long[]{0x0000000002606800L});
	public static final BitSet FOLLOW_comparisonOperator_in_searchCondition641 = new BitSet(new long[]{0x0000000800040000L});
	public static final BitSet FOLLOW_value_in_searchCondition644 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_onSearchCondition_in_onSearchConditions659 = new BitSet(new long[]{0x0000000008000012L});
	public static final BitSet FOLLOW_logicalOperator_in_onSearchConditions662 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_onSearchCondition_in_onSearchConditions665 = new BitSet(new long[]{0x0000000008000012L});
	public static final BitSet FOLLOW_onTable_in_onSearchCondition678 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_DOT_in_onSearchCondition680 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_column_in_onSearchCondition683 = new BitSet(new long[]{0x0000000002606800L});
	public static final BitSet FOLLOW_comparisonOperator_in_onSearchCondition685 = new BitSet(new long[]{0x0000000800040000L});
	public static final BitSet FOLLOW_value_in_onSearchCondition688 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_logicalOperator749 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_logicalOperator755 = new BitSet(new long[]{0x0000000000000002L});
}
