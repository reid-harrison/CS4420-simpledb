// $ANTLR 3.5 C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g 2013-04-24 00:39:17

///////////////////////////////////////////////////////////////////
//                                                               //
//   THIS IS A DERIVED FILE! MAKE ANY DESIRED CHANGES IN SQL.g   //
//                                                               //
///////////////////////////////////////////////////////////////////

package gt.cs4420.relationaldb.database.query;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.Table;
import org.antlr.runtime.*;
import org.antlr.runtime.tree.CommonTree;
import org.antlr.runtime.tree.CommonTreeAdaptor;
import org.antlr.runtime.tree.TreeAdaptor;

import java.util.List;
import java.util.Map;


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
		boolean isJoin = false;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:74:1: statement : ( select | insert | update | EOF );
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:75:2: ( select | insert | update | EOF )
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:75:4: select
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_select_in_statement84);
					select1=select();
					state._fsp--;

					adaptor.addChild(root_0, select1.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:76:4: insert
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_insert_in_statement89);
					insert2=insert();
					state._fsp--;

					adaptor.addChild(root_0, insert2.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:77:4: update
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_update_in_statement94);
					update3=update();
					state._fsp--;

					adaptor.addChild(root_0, update3.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:78:4: EOF
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:83:1: select : selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !;
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:84:2: ( selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:84:4: selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !
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

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:84:28: ( onClause )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ON) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:84:29: onClause
					{
					pushFollow(FOLLOW_onClause_in_select118);
					onClause7=onClause();
					state._fsp--;

					adaptor.addChild(root_0, onClause7.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:84:40: ( whereClause )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==WHERE) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:84:41: whereClause
					{
					pushFollow(FOLLOW_whereClause_in_select123);
					whereClause8=whereClause();
					state._fsp--;

					adaptor.addChild(root_0, whereClause8.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:84:55: ( orderByClause )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ORDER_BY) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:84:56: orderByClause
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:87:1: insert : insertClause valuesClause SEMI !;
	public final SQLParser.insert_return insert() throws RecognitionException {
		SQLParser.insert_return retval = new SQLParser.insert_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI13=null;
		ParserRuleReturnScope insertClause11 =null;
		ParserRuleReturnScope valuesClause12 =null;

		CommonTree SEMI13_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:88:2: ( insertClause valuesClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:88:4: insertClause valuesClause SEMI !
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:91:1: update : updateClause setClause whereClause SEMI !;
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:92:2: ( updateClause setClause whereClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:92:4: updateClause setClause whereClause SEMI !
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:100:1: selectClause : SELECT ^ columns ;
	public final SQLParser.selectClause_return selectClause() throws RecognitionException {
		SQLParser.selectClause_return retval = new SQLParser.selectClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SELECT18=null;
		ParserRuleReturnScope columns19 =null;

		CommonTree SELECT18_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:101:2: ( SELECT ^ columns )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:101:4: SELECT ^ columns
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:1: insertClause : INSERT_INTO ^ insertParams ;
	public final SQLParser.insertClause_return insertClause() throws RecognitionException {
		SQLParser.insertClause_return retval = new SQLParser.insertClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INSERT_INTO20=null;
		ParserRuleReturnScope insertParams21 =null;

		CommonTree INSERT_INTO20_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:105:2: ( INSERT_INTO ^ insertParams )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:105:4: INSERT_INTO ^ insertParams
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:108:1: updateClause : UPDATE ^ table ;
	public final SQLParser.updateClause_return updateClause() throws RecognitionException {
		SQLParser.updateClause_return retval = new SQLParser.updateClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UPDATE22=null;
		ParserRuleReturnScope table23 =null;

		CommonTree UPDATE22_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:109:2: ( UPDATE ^ table )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:109:4: UPDATE ^ table
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:112:1: fromClause : FROM ^ tableClause ;
	public final SQLParser.fromClause_return fromClause() throws RecognitionException {
		SQLParser.fromClause_return retval = new SQLParser.fromClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FROM24=null;
		ParserRuleReturnScope tableClause25 =null;

		CommonTree FROM24_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:113:2: ( FROM ^ tableClause )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:113:4: FROM ^ tableClause
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:116:1: tableClause : ( table | joinClause );
	public final SQLParser.tableClause_return tableClause() throws RecognitionException {
		SQLParser.tableClause_return retval = new SQLParser.tableClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope table26 =null;
		ParserRuleReturnScope joinClause27 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:117:2: ( table | joinClause )
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:117:4: table
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_table_in_tableClause252);
					table26=table();
					state._fsp--;

					adaptor.addChild(root_0, table26.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:118:4: joinClause
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:121:1: joinClause : table ( joinOperator ^ table )+ ;
	public final SQLParser.joinClause_return joinClause() throws RecognitionException {
		SQLParser.joinClause_return retval = new SQLParser.joinClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope table28 =null;
		ParserRuleReturnScope joinOperator29 =null;
		ParserRuleReturnScope table30 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:122:2: ( table ( joinOperator ^ table )+ )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:122:4: table ( joinOperator ^ table )+
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_table_in_joinClause269);
			table28=table();
			state._fsp--;

			adaptor.addChild(root_0, table28.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:122:10: ( joinOperator ^ table )+
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:122:11: joinOperator ^ table
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


						isJoin = true;
					
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:129:1: onClause : ON ^ onSearchConditions ;
	public final SQLParser.onClause_return onClause() throws RecognitionException {
		SQLParser.onClause_return retval = new SQLParser.onClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ON31=null;
		ParserRuleReturnScope onSearchConditions32 =null;

		CommonTree ON31_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:130:2: ( ON ^ onSearchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:130:4: ON ^ onSearchConditions
			{
			root_0 = (CommonTree)adaptor.nil();



						if(!isJoin)
						{
							throw new IllegalArgumentException("Expecting previous join clause.");
						}
					
			ON31=(Token)match(input,ON,FOLLOW_ON_in_onClause298); 
			ON31_tree = (CommonTree)adaptor.create(ON31);
			root_0 = (CommonTree)adaptor.becomeRoot(ON31_tree, root_0);

			pushFollow(FOLLOW_onSearchConditions_in_onClause301);
			onSearchConditions32=onSearchConditions();
			state._fsp--;

			adaptor.addChild(root_0, onSearchConditions32.getTree());

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


	public static class whereClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "whereClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:139:1: whereClause : WHERE ^ searchConditions ;
	public final SQLParser.whereClause_return whereClause() throws RecognitionException {
		SQLParser.whereClause_return retval = new SQLParser.whereClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHERE33=null;
		ParserRuleReturnScope searchConditions34 =null;

		CommonTree WHERE33_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:140:2: ( WHERE ^ searchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:140:4: WHERE ^ searchConditions
			{
			root_0 = (CommonTree)adaptor.nil();


			WHERE33=(Token)match(input,WHERE,FOLLOW_WHERE_in_whereClause313); 
			WHERE33_tree = (CommonTree)adaptor.create(WHERE33);
			root_0 = (CommonTree)adaptor.becomeRoot(WHERE33_tree, root_0);

			pushFollow(FOLLOW_searchConditions_in_whereClause316);
			searchConditions34=searchConditions();
			state._fsp--;

			adaptor.addChild(root_0, searchConditions34.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:143:1: orderByClause : ORDER_BY ^ column ( COMMA ! column )* ( order )? ;
	public final SQLParser.orderByClause_return orderByClause() throws RecognitionException {
		SQLParser.orderByClause_return retval = new SQLParser.orderByClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ORDER_BY35=null;
		Token COMMA37=null;
		ParserRuleReturnScope column36 =null;
		ParserRuleReturnScope column38 =null;
		ParserRuleReturnScope order39 =null;

		CommonTree ORDER_BY35_tree=null;
		CommonTree COMMA37_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:144:2: ( ORDER_BY ^ column ( COMMA ! column )* ( order )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:144:4: ORDER_BY ^ column ( COMMA ! column )* ( order )?
			{
			root_0 = (CommonTree)adaptor.nil();


			ORDER_BY35=(Token)match(input,ORDER_BY,FOLLOW_ORDER_BY_in_orderByClause328); 
			ORDER_BY35_tree = (CommonTree)adaptor.create(ORDER_BY35);
			root_0 = (CommonTree)adaptor.becomeRoot(ORDER_BY35_tree, root_0);

			pushFollow(FOLLOW_column_in_orderByClause331);
			column36=column();
			state._fsp--;

			adaptor.addChild(root_0, column36.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:144:21: ( COMMA ! column )*
			loop7:
			while (true) {
				int alt7=2;
				int LA7_0 = input.LA(1);
				if ( (LA7_0==COMMA) ) {
					alt7=1;
				}

				switch (alt7) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:144:22: COMMA ! column
					{
					COMMA37=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderByClause334); 
					pushFollow(FOLLOW_column_in_orderByClause337);
					column38=column();
					state._fsp--;

					adaptor.addChild(root_0, column38.getTree());

					}
					break;

				default :
					break loop7;
				}
			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:144:38: ( order )?
			int alt8=2;
			int LA8_0 = input.LA(1);
			if ( (LA8_0==ASC||LA8_0==DESC) ) {
				alt8=1;
			}
			switch (alt8) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:144:39: order
					{
					pushFollow(FOLLOW_order_in_orderByClause342);
					order39=order();
					state._fsp--;

					adaptor.addChild(root_0, order39.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:147:1: valuesClause : VALUES ^ LPAREN ! values RPAREN !;
	public final SQLParser.valuesClause_return valuesClause() throws RecognitionException {
		SQLParser.valuesClause_return retval = new SQLParser.valuesClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VALUES40=null;
		Token LPAREN41=null;
		Token RPAREN43=null;
		ParserRuleReturnScope values42 =null;

		CommonTree VALUES40_tree=null;
		CommonTree LPAREN41_tree=null;
		CommonTree RPAREN43_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:148:2: ( VALUES ^ LPAREN ! values RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:148:4: VALUES ^ LPAREN ! values RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			VALUES40=(Token)match(input,VALUES,FOLLOW_VALUES_in_valuesClause356); 
			VALUES40_tree = (CommonTree)adaptor.create(VALUES40);
			root_0 = (CommonTree)adaptor.becomeRoot(VALUES40_tree, root_0);

			LPAREN41=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_valuesClause359); 
			pushFollow(FOLLOW_values_in_valuesClause362);
			values42=values();
			state._fsp--;

			adaptor.addChild(root_0, values42.getTree());

			RPAREN43=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_valuesClause364); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:151:1: setClause : SET ^ assignments ;
	public final SQLParser.setClause_return setClause() throws RecognitionException {
		SQLParser.setClause_return retval = new SQLParser.setClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SET44=null;
		ParserRuleReturnScope assignments45 =null;

		CommonTree SET44_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:152:2: ( SET ^ assignments )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:152:4: SET ^ assignments
			{
			root_0 = (CommonTree)adaptor.nil();


			SET44=(Token)match(input,SET,FOLLOW_SET_in_setClause376); 
			SET44_tree = (CommonTree)adaptor.create(SET44);
			root_0 = (CommonTree)adaptor.becomeRoot(SET44_tree, root_0);

			pushFollow(FOLLOW_assignments_in_setClause379);
			assignments45=assignments();
			state._fsp--;

			adaptor.addChild(root_0, assignments45.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:162:1: insertParams : table ^ LPAREN ! columns RPAREN !;
	public final SQLParser.insertParams_return insertParams() throws RecognitionException {
		SQLParser.insertParams_return retval = new SQLParser.insertParams_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN47=null;
		Token RPAREN49=null;
		ParserRuleReturnScope table46 =null;
		ParserRuleReturnScope columns48 =null;

		CommonTree LPAREN47_tree=null;
		CommonTree RPAREN49_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:163:2: ( table ^ LPAREN ! columns RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:163:4: table ^ LPAREN ! columns RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_table_in_insertParams399);
			table46=table();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(table46.getTree(), root_0);
			LPAREN47=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_insertParams402); 
			pushFollow(FOLLOW_columns_in_insertParams405);
			columns48=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns48.getTree());

			RPAREN49=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_insertParams407); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:166:1: table : IDENT ;
	public final SQLParser.table_return table() throws RecognitionException {
		SQLParser.table_return retval = new SQLParser.table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT50=null;

		CommonTree IDENT50_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:167:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:167:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT50=(Token)match(input,IDENT,FOLLOW_IDENT_in_table420); 
			IDENT50_tree = (CommonTree)adaptor.create(IDENT50);
			adaptor.addChild(root_0, IDENT50_tree);


						//build a Table for use with validation
						table1.setName((IDENT50!=null?IDENT50.getText():null));
						tables.add((IDENT50!=null?IDENT50.getText():null));
						//storageManager.validateTableExists(table1.getName());
						//table1.setDescription(storageManager.getTable((IDENT50!=null?IDENT50.getText():null)).getDescription());
					
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


	public static class onTable_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "onTable"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:178:1: onTable : IDENT ;
	public final SQLParser.onTable_return onTable() throws RecognitionException {
		SQLParser.onTable_return retval = new SQLParser.onTable_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT51=null;

		CommonTree IDENT51_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:179:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:179:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT51=(Token)match(input,IDENT,FOLLOW_IDENT_in_onTable437); 
			IDENT51_tree = (CommonTree)adaptor.create(IDENT51);
			adaptor.addChild(root_0, IDENT51_tree);


						if (!tables.contains((IDENT51!=null?IDENT51.getText():null)))
						{
							throw new IllegalArgumentException("'" + (IDENT51!=null?IDENT51.getText():null) + "' is not a table from which items are being queried.");
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


	public static class columns_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "columns"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:188:1: columns : ( column ( COMMA ! column )* ) ;
	public final SQLParser.columns_return columns() throws RecognitionException {
		SQLParser.columns_return retval = new SQLParser.columns_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA53=null;
		ParserRuleReturnScope column52 =null;
		ParserRuleReturnScope column54 =null;

		CommonTree COMMA53_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:189:2: ( ( column ( COMMA ! column )* ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:189:4: ( column ( COMMA ! column )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:189:4: ( column ( COMMA ! column )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:189:5: column ( COMMA ! column )*
			{
			pushFollow(FOLLOW_column_in_columns453);
			column52=column();
			state._fsp--;

			adaptor.addChild(root_0, column52.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:189:12: ( COMMA ! column )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==COMMA) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:189:13: COMMA ! column
					{
					COMMA53=(Token)match(input,COMMA,FOLLOW_COMMA_in_columns456); 
					pushFollow(FOLLOW_column_in_columns459);
					column54=column();
					state._fsp--;

					adaptor.addChild(root_0, column54.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:193:1: column : IDENT ;
	public final SQLParser.column_return column() throws RecognitionException {
		SQLParser.column_return retval = new SQLParser.column_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT55=null;

		CommonTree IDENT55_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:194:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:194:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT55=(Token)match(input,IDENT,FOLLOW_IDENT_in_column474); 
			IDENT55_tree = (CommonTree)adaptor.create(IDENT55);
			adaptor.addChild(root_0, IDENT55_tree);


						numCols++;
						table1Attributes.add(new Attribute((IDENT55!=null?IDENT55.getText():null)));
					
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:203:1: value : ( STRING_LITERAL | INTEGER );
	public final SQLParser.value_return value() throws RecognitionException {
		SQLParser.value_return retval = new SQLParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL56=null;
		Token INTEGER57=null;

		CommonTree STRING_LITERAL56_tree=null;
		CommonTree INTEGER57_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:204:2: ( STRING_LITERAL | INTEGER )
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:204:4: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL56=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_value491); 
					STRING_LITERAL56_tree = (CommonTree)adaptor.create(STRING_LITERAL56);
					adaptor.addChild(root_0, STRING_LITERAL56_tree);


								insertVals.add(STRING_LITERAL56);
								numVals++;
							
					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:209:5: INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					INTEGER57=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value501); 
					INTEGER57_tree = (CommonTree)adaptor.create(INTEGER57);
					adaptor.addChild(root_0, INTEGER57_tree);


								insertVals.add(INTEGER57);
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:216:1: values : ( value ( COMMA ! value )* ) ;
	public final SQLParser.values_return values() throws RecognitionException {
		SQLParser.values_return retval = new SQLParser.values_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA59=null;
		ParserRuleReturnScope value58 =null;
		ParserRuleReturnScope value60 =null;

		CommonTree COMMA59_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:217:2: ( ( value ( COMMA ! value )* ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:217:4: ( value ( COMMA ! value )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:217:4: ( value ( COMMA ! value )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:217:5: value ( COMMA ! value )*
			{
			pushFollow(FOLLOW_value_in_values518);
			value58=value();
			state._fsp--;

			adaptor.addChild(root_0, value58.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:217:11: ( COMMA ! value )*
			loop11:
			while (true) {
				int alt11=2;
				int LA11_0 = input.LA(1);
				if ( (LA11_0==COMMA) ) {
					alt11=1;
				}

				switch (alt11) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:217:12: COMMA ! value
					{
					COMMA59=(Token)match(input,COMMA,FOLLOW_COMMA_in_values521); 
					pushFollow(FOLLOW_value_in_values524);
					value60=value();
					state._fsp--;

					adaptor.addChild(root_0, value60.getTree());

					}
					break;

				default :
					break loop11;
				}
			}

			}


						// Number of values must match number of attribues in INSERT
						if (!(numVals == numCols))
						{
							throw new IllegalArgumentException(numCols + " columns specified and " + numVals + " values entered.");
						}	
						
						// Once attributes and values are parsed, put them in a map for validation
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:234:1: order : ( ASC | DESC );
	public final SQLParser.order_return order() throws RecognitionException {
		SQLParser.order_return retval = new SQLParser.order_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set61=null;

		CommonTree set61_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:235:2: ( ASC | DESC )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set61=input.LT(1);
			if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set61));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:239:1: assignments : assignment ( COMMA ! assignment )* ;
	public final SQLParser.assignments_return assignments() throws RecognitionException {
		SQLParser.assignments_return retval = new SQLParser.assignments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA63=null;
		ParserRuleReturnScope assignment62 =null;
		ParserRuleReturnScope assignment64 =null;

		CommonTree COMMA63_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:240:2: ( assignment ( COMMA ! assignment )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:240:4: assignment ( COMMA ! assignment )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_assignment_in_assignments560);
			assignment62=assignment();
			state._fsp--;

			adaptor.addChild(root_0, assignment62.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:240:15: ( COMMA ! assignment )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==COMMA) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:240:16: COMMA ! assignment
					{
					COMMA63=(Token)match(input,COMMA,FOLLOW_COMMA_in_assignments563); 
					pushFollow(FOLLOW_assignment_in_assignments566);
					assignment64=assignment();
					state._fsp--;

					adaptor.addChild(root_0, assignment64.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:243:1: assignment : column EQUAL ^ value ;
	public final SQLParser.assignment_return assignment() throws RecognitionException {
		SQLParser.assignment_return retval = new SQLParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQUAL66=null;
		ParserRuleReturnScope column65 =null;
		ParserRuleReturnScope value67 =null;

		CommonTree EQUAL66_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:244:2: ( column EQUAL ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:244:4: column EQUAL ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_assignment580);
			column65=column();
			state._fsp--;

			adaptor.addChild(root_0, column65.getTree());

			EQUAL66=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_assignment582); 
			EQUAL66_tree = (CommonTree)adaptor.create(EQUAL66);
			root_0 = (CommonTree)adaptor.becomeRoot(EQUAL66_tree, root_0);

			pushFollow(FOLLOW_value_in_assignment585);
			value67=value();
			state._fsp--;

			adaptor.addChild(root_0, value67.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:248:1: searchConditions : searchCondition ( logicalOperator ^ searchCondition )* ;
	public final SQLParser.searchConditions_return searchConditions() throws RecognitionException {
		SQLParser.searchConditions_return retval = new SQLParser.searchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope searchCondition68 =null;
		ParserRuleReturnScope logicalOperator69 =null;
		ParserRuleReturnScope searchCondition70 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:249:2: ( searchCondition ( logicalOperator ^ searchCondition )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:249:4: searchCondition ( logicalOperator ^ searchCondition )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_searchCondition_in_searchConditions598);
			searchCondition68=searchCondition();
			state._fsp--;

			adaptor.addChild(root_0, searchCondition68.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:249:20: ( logicalOperator ^ searchCondition )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==AND||LA13_0==OR) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:249:21: logicalOperator ^ searchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_searchConditions601);
					logicalOperator69=logicalOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(logicalOperator69.getTree(), root_0);
					pushFollow(FOLLOW_searchCondition_in_searchConditions604);
					searchCondition70=searchCondition();
					state._fsp--;

					adaptor.addChild(root_0, searchCondition70.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:252:1: searchCondition : column comparisonOperator ^ value ;
	public final SQLParser.searchCondition_return searchCondition() throws RecognitionException {
		SQLParser.searchCondition_return retval = new SQLParser.searchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope column71 =null;
		ParserRuleReturnScope comparisonOperator72 =null;
		ParserRuleReturnScope value73 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:253:2: ( column comparisonOperator ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:253:4: column comparisonOperator ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_searchCondition618);
			column71=column();
			state._fsp--;

			adaptor.addChild(root_0, column71.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_searchCondition620);
			comparisonOperator72=comparisonOperator();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(comparisonOperator72.getTree(), root_0);
			pushFollow(FOLLOW_value_in_searchCondition623);
			value73=value();
			state._fsp--;

			adaptor.addChild(root_0, value73.getTree());


						//TODO Possibly validate type of value against column type?
					
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:260:1: onSearchConditions : onSearchCondition ( logicalOperator ^ onSearchCondition )* ;
	public final SQLParser.onSearchConditions_return onSearchConditions() throws RecognitionException {
		SQLParser.onSearchConditions_return retval = new SQLParser.onSearchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope onSearchCondition74 =null;
		ParserRuleReturnScope logicalOperator75 =null;
		ParserRuleReturnScope onSearchCondition76 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:261:2: ( onSearchCondition ( logicalOperator ^ onSearchCondition )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:261:4: onSearchCondition ( logicalOperator ^ onSearchCondition )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_onSearchCondition_in_onSearchConditions640);
			onSearchCondition74=onSearchCondition();
			state._fsp--;

			adaptor.addChild(root_0, onSearchCondition74.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:261:22: ( logicalOperator ^ onSearchCondition )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==AND||LA14_0==OR) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:261:23: logicalOperator ^ onSearchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_onSearchConditions643);
					logicalOperator75=logicalOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(logicalOperator75.getTree(), root_0);
					pushFollow(FOLLOW_onSearchCondition_in_onSearchConditions646);
					onSearchCondition76=onSearchCondition();
					state._fsp--;

					adaptor.addChild(root_0, onSearchCondition76.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:264:1: onSearchCondition : onTable DOT ! column comparisonOperator ^ value ;
	public final SQLParser.onSearchCondition_return onSearchCondition() throws RecognitionException {
		SQLParser.onSearchCondition_return retval = new SQLParser.onSearchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DOT78=null;
		ParserRuleReturnScope onTable77 =null;
		ParserRuleReturnScope column79 =null;
		ParserRuleReturnScope comparisonOperator80 =null;
		ParserRuleReturnScope value81 =null;

		CommonTree DOT78_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:265:2: ( onTable DOT ! column comparisonOperator ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:265:4: onTable DOT ! column comparisonOperator ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_onTable_in_onSearchCondition659);
			onTable77=onTable();
			state._fsp--;

			adaptor.addChild(root_0, onTable77.getTree());

			DOT78=(Token)match(input,DOT,FOLLOW_DOT_in_onSearchCondition661); 
			pushFollow(FOLLOW_column_in_onSearchCondition664);
			column79=column();
			state._fsp--;

			adaptor.addChild(root_0, column79.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_onSearchCondition666);
			comparisonOperator80=comparisonOperator();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(comparisonOperator80.getTree(), root_0);
			pushFollow(FOLLOW_value_in_onSearchCondition669);
			value81=value();
			state._fsp--;

			adaptor.addChild(root_0, value81.getTree());


						//TODO Possibly validate type of value against column type?
					
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:277:1: comparisonOperator : ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN );
	public final SQLParser.comparisonOperator_return comparisonOperator() throws RecognitionException {
		SQLParser.comparisonOperator_return retval = new SQLParser.comparisonOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set82=null;

		CommonTree set82_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:278:2: ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set82=input.LT(1);
			if ( input.LA(1)==EQUAL||(input.LA(1) >= GREATER_THAN && input.LA(1) <= GREATER_THAN_EQUAL)||(input.LA(1) >= LESS_THAN && input.LA(1) <= LESS_THAN_EQUAL)||input.LA(1)==NOT_EQUAL ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set82));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:286:1: logicalOperator : ( AND | OR );
	public final SQLParser.logicalOperator_return logicalOperator() throws RecognitionException {
		SQLParser.logicalOperator_return retval = new SQLParser.logicalOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set83=null;

		CommonTree set83_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:287:2: ( AND | OR )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set83=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==OR ) {
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
	// $ANTLR end "logicalOperator"


	public static class joinOperator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "joinOperator"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:291:1: joinOperator : ( INNER_JOIN | OUTER_JOIN | LEFT_JOIN | RIGHT_JOIN | JOIN );
	public final SQLParser.joinOperator_return joinOperator() throws RecognitionException {
		SQLParser.joinOperator_return retval = new SQLParser.joinOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set84=null;

		CommonTree set84_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:292:2: ( INNER_JOIN | OUTER_JOIN | LEFT_JOIN | RIGHT_JOIN | JOIN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set84=input.LT(1);
			if ( input.LA(1)==INNER_JOIN||(input.LA(1) >= JOIN && input.LA(1) <= LEFT_JOIN)||(input.LA(1) >= OUTER_JOIN && input.LA(1) <= RIGHT_JOIN) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set84));
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
	public static final BitSet FOLLOW_ON_in_onClause298 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_onSearchConditions_in_onClause301 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_whereClause313 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_searchConditions_in_whereClause316 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_BY_in_orderByClause328 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_column_in_orderByClause331 = new BitSet(new long[]{0x0000000000000162L});
	public static final BitSet FOLLOW_COMMA_in_orderByClause334 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_column_in_orderByClause337 = new BitSet(new long[]{0x0000000000000162L});
	public static final BitSet FOLLOW_order_in_orderByClause342 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUES_in_valuesClause356 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LPAREN_in_valuesClause359 = new BitSet(new long[]{0x0000000800040000L});
	public static final BitSet FOLLOW_values_in_valuesClause362 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_RPAREN_in_valuesClause364 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_setClause376 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_assignments_in_setClause379 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_insertParams399 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_LPAREN_in_insertParams402 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_columns_in_insertParams405 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_RPAREN_in_insertParams407 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_table420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_onTable437 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_columns453 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_columns456 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_column_in_columns459 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_IDENT_in_column474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_value491 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_value501 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_values518 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_values521 = new BitSet(new long[]{0x0000000800040000L});
	public static final BitSet FOLLOW_value_in_values524 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_assignment_in_assignments560 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_assignments563 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_assignment_in_assignments566 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_column_in_assignment580 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_EQUAL_in_assignment582 = new BitSet(new long[]{0x0000000800040000L});
	public static final BitSet FOLLOW_value_in_assignment585 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions598 = new BitSet(new long[]{0x0000000008000012L});
	public static final BitSet FOLLOW_logicalOperator_in_searchConditions601 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions604 = new BitSet(new long[]{0x0000000008000012L});
	public static final BitSet FOLLOW_column_in_searchCondition618 = new BitSet(new long[]{0x0000000002606800L});
	public static final BitSet FOLLOW_comparisonOperator_in_searchCondition620 = new BitSet(new long[]{0x0000000800040000L});
	public static final BitSet FOLLOW_value_in_searchCondition623 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_onSearchCondition_in_onSearchConditions640 = new BitSet(new long[]{0x0000000008000012L});
	public static final BitSet FOLLOW_logicalOperator_in_onSearchConditions643 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_onSearchCondition_in_onSearchConditions646 = new BitSet(new long[]{0x0000000008000012L});
	public static final BitSet FOLLOW_onTable_in_onSearchCondition659 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_DOT_in_onSearchCondition661 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_column_in_onSearchCondition664 = new BitSet(new long[]{0x0000000002606800L});
	public static final BitSet FOLLOW_comparisonOperator_in_onSearchCondition666 = new BitSet(new long[]{0x0000000800040000L});
	public static final BitSet FOLLOW_value_in_onSearchCondition669 = new BitSet(new long[]{0x0000000000000002L});
}
