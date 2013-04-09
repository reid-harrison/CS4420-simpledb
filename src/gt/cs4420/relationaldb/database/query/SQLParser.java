// $ANTLR 3.5 C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g 2013-04-08 20:29:19

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


		int numCols = 0;
		int numVals = 0;
		int numTables = 0;
		Table table1 = new Table();
		Table table2 = new Table();
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:72:1: statement : ( select | insert | update | EOF );
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:73:2: ( select | insert | update | EOF )
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:73:4: select
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_select_in_statement84);
					select1=select();
					state._fsp--;

					adaptor.addChild(root_0, select1.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:74:4: insert
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_insert_in_statement89);
					insert2=insert();
					state._fsp--;

					adaptor.addChild(root_0, insert2.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:75:4: update
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_update_in_statement94);
					update3=update();
					state._fsp--;

					adaptor.addChild(root_0, update3.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:76:4: EOF
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:81:1: select : selectClause fromClause ( whereClause )? ( orderByClause )? SEMI !;
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:82:2: ( selectClause fromClause ( whereClause )? ( orderByClause )? SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:82:4: selectClause fromClause ( whereClause )? ( orderByClause )? SEMI !
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

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:82:28: ( whereClause )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==WHERE) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:82:29: whereClause
					{
					pushFollow(FOLLOW_whereClause_in_select118);
					whereClause7=whereClause();
					state._fsp--;

					adaptor.addChild(root_0, whereClause7.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:82:43: ( orderByClause )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==ORDER_BY) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:82:44: orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_select123);
					orderByClause8=orderByClause();
					state._fsp--;

					adaptor.addChild(root_0, orderByClause8.getTree());

					}
					break;

			}

			SEMI9=(Token)match(input,SEMI,FOLLOW_SEMI_in_select127); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:85:1: insert : insertClause valuesClause SEMI !;
	public final SQLParser.insert_return insert() throws RecognitionException {
		SQLParser.insert_return retval = new SQLParser.insert_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI12=null;
		ParserRuleReturnScope insertClause10 =null;
		ParserRuleReturnScope valuesClause11 =null;

		CommonTree SEMI12_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:86:2: ( insertClause valuesClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:86:4: insertClause valuesClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_insertClause_in_insert140);
			insertClause10=insertClause();
			state._fsp--;

			adaptor.addChild(root_0, insertClause10.getTree());

			pushFollow(FOLLOW_valuesClause_in_insert142);
			valuesClause11=valuesClause();
			state._fsp--;

			adaptor.addChild(root_0, valuesClause11.getTree());

			SEMI12=(Token)match(input,SEMI,FOLLOW_SEMI_in_insert144); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:89:1: update : updateClause setClause whereClause SEMI !;
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:90:2: ( updateClause setClause whereClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:90:4: updateClause setClause whereClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_updateClause_in_update157);
			updateClause13=updateClause();
			state._fsp--;

			adaptor.addChild(root_0, updateClause13.getTree());

			pushFollow(FOLLOW_setClause_in_update159);
			setClause14=setClause();
			state._fsp--;

			adaptor.addChild(root_0, setClause14.getTree());

			pushFollow(FOLLOW_whereClause_in_update161);
			whereClause15=whereClause();
			state._fsp--;

			adaptor.addChild(root_0, whereClause15.getTree());

			SEMI16=(Token)match(input,SEMI,FOLLOW_SEMI_in_update163); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:98:1: selectClause : SELECT ^ columns ;
	public final SQLParser.selectClause_return selectClause() throws RecognitionException {
		SQLParser.selectClause_return retval = new SQLParser.selectClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SELECT17=null;
		ParserRuleReturnScope columns18 =null;

		CommonTree SELECT17_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:99:2: ( SELECT ^ columns )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:99:4: SELECT ^ columns
			{
			root_0 = (CommonTree)adaptor.nil();


			SELECT17=(Token)match(input,SELECT,FOLLOW_SELECT_in_selectClause186); 
			SELECT17_tree = (CommonTree)adaptor.create(SELECT17);
			root_0 = (CommonTree)adaptor.becomeRoot(SELECT17_tree, root_0);

			pushFollow(FOLLOW_columns_in_selectClause189);
			columns18=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns18.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:102:1: insertClause : INSERT_INTO ^ insertParams ;
	public final SQLParser.insertClause_return insertClause() throws RecognitionException {
		SQLParser.insertClause_return retval = new SQLParser.insertClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INSERT_INTO19=null;
		ParserRuleReturnScope insertParams20 =null;

		CommonTree INSERT_INTO19_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:2: ( INSERT_INTO ^ insertParams )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:4: INSERT_INTO ^ insertParams
			{
			root_0 = (CommonTree)adaptor.nil();


			INSERT_INTO19=(Token)match(input,INSERT_INTO,FOLLOW_INSERT_INTO_in_insertClause201); 
			INSERT_INTO19_tree = (CommonTree)adaptor.create(INSERT_INTO19);
			root_0 = (CommonTree)adaptor.becomeRoot(INSERT_INTO19_tree, root_0);

			pushFollow(FOLLOW_insertParams_in_insertClause204);
			insertParams20=insertParams();
			state._fsp--;

			adaptor.addChild(root_0, insertParams20.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:106:1: updateClause : UPDATE ^ table ;
	public final SQLParser.updateClause_return updateClause() throws RecognitionException {
		SQLParser.updateClause_return retval = new SQLParser.updateClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UPDATE21=null;
		ParserRuleReturnScope table22 =null;

		CommonTree UPDATE21_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:107:2: ( UPDATE ^ table )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:107:4: UPDATE ^ table
			{
			root_0 = (CommonTree)adaptor.nil();


			UPDATE21=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateClause216); 
			UPDATE21_tree = (CommonTree)adaptor.create(UPDATE21);
			root_0 = (CommonTree)adaptor.becomeRoot(UPDATE21_tree, root_0);

			pushFollow(FOLLOW_table_in_updateClause219);
			table22=table();
			state._fsp--;

			adaptor.addChild(root_0, table22.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:110:1: fromClause : FROM ^ table ;
	public final SQLParser.fromClause_return fromClause() throws RecognitionException {
		SQLParser.fromClause_return retval = new SQLParser.fromClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FROM23=null;
		ParserRuleReturnScope table24 =null;

		CommonTree FROM23_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:111:2: ( FROM ^ table )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:111:4: FROM ^ table
			{
			root_0 = (CommonTree)adaptor.nil();


			FROM23=(Token)match(input,FROM,FOLLOW_FROM_in_fromClause231); 
			FROM23_tree = (CommonTree)adaptor.create(FROM23);
			root_0 = (CommonTree)adaptor.becomeRoot(FROM23_tree, root_0);

			pushFollow(FOLLOW_table_in_fromClause234);
			table24=table();
			state._fsp--;

			adaptor.addChild(root_0, table24.getTree());

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


	public static class whereClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "whereClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:114:1: whereClause : WHERE ^ searchConditions ;
	public final SQLParser.whereClause_return whereClause() throws RecognitionException {
		SQLParser.whereClause_return retval = new SQLParser.whereClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHERE25=null;
		ParserRuleReturnScope searchConditions26 =null;

		CommonTree WHERE25_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:115:2: ( WHERE ^ searchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:115:4: WHERE ^ searchConditions
			{
			root_0 = (CommonTree)adaptor.nil();


			WHERE25=(Token)match(input,WHERE,FOLLOW_WHERE_in_whereClause246); 
			WHERE25_tree = (CommonTree)adaptor.create(WHERE25);
			root_0 = (CommonTree)adaptor.becomeRoot(WHERE25_tree, root_0);

			pushFollow(FOLLOW_searchConditions_in_whereClause249);
			searchConditions26=searchConditions();
			state._fsp--;

			adaptor.addChild(root_0, searchConditions26.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:118:1: orderByClause : ORDER_BY ^ column ( COMMA ! column )* ( order )? ;
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:119:2: ( ORDER_BY ^ column ( COMMA ! column )* ( order )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:119:4: ORDER_BY ^ column ( COMMA ! column )* ( order )?
			{
			root_0 = (CommonTree)adaptor.nil();


			ORDER_BY27=(Token)match(input,ORDER_BY,FOLLOW_ORDER_BY_in_orderByClause261); 
			ORDER_BY27_tree = (CommonTree)adaptor.create(ORDER_BY27);
			root_0 = (CommonTree)adaptor.becomeRoot(ORDER_BY27_tree, root_0);

			pushFollow(FOLLOW_column_in_orderByClause264);
			column28=column();
			state._fsp--;

			adaptor.addChild(root_0, column28.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:119:21: ( COMMA ! column )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0==COMMA) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:119:22: COMMA ! column
					{
					COMMA29=(Token)match(input,COMMA,FOLLOW_COMMA_in_orderByClause267); 
					pushFollow(FOLLOW_column_in_orderByClause270);
					column30=column();
					state._fsp--;

					adaptor.addChild(root_0, column30.getTree());

					}
					break;

				default :
					break loop4;
				}
			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:119:38: ( order )?
			int alt5=2;
			int LA5_0 = input.LA(1);
			if ( (LA5_0==ASC||LA5_0==DESC) ) {
				alt5=1;
			}
			switch (alt5) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:119:39: order
					{
					pushFollow(FOLLOW_order_in_orderByClause275);
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:122:1: valuesClause : VALUES ^ LPAREN ! values RPAREN !;
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:123:2: ( VALUES ^ LPAREN ! values RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:123:4: VALUES ^ LPAREN ! values RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			VALUES32=(Token)match(input,VALUES,FOLLOW_VALUES_in_valuesClause289); 
			VALUES32_tree = (CommonTree)adaptor.create(VALUES32);
			root_0 = (CommonTree)adaptor.becomeRoot(VALUES32_tree, root_0);

			LPAREN33=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_valuesClause292); 
			pushFollow(FOLLOW_values_in_valuesClause295);
			values34=values();
			state._fsp--;

			adaptor.addChild(root_0, values34.getTree());

			RPAREN35=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_valuesClause297); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:126:1: setClause : SET ^ assignments ;
	public final SQLParser.setClause_return setClause() throws RecognitionException {
		SQLParser.setClause_return retval = new SQLParser.setClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SET36=null;
		ParserRuleReturnScope assignments37 =null;

		CommonTree SET36_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:127:2: ( SET ^ assignments )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:127:4: SET ^ assignments
			{
			root_0 = (CommonTree)adaptor.nil();


			SET36=(Token)match(input,SET,FOLLOW_SET_in_setClause309); 
			SET36_tree = (CommonTree)adaptor.create(SET36);
			root_0 = (CommonTree)adaptor.becomeRoot(SET36_tree, root_0);

			pushFollow(FOLLOW_assignments_in_setClause312);
			assignments37=assignments();
			state._fsp--;

			adaptor.addChild(root_0, assignments37.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:137:1: insertParams : table ^ LPAREN ! columns RPAREN !;
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:138:2: ( table ^ LPAREN ! columns RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:138:4: table ^ LPAREN ! columns RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_table_in_insertParams332);
			table38=table();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(table38.getTree(), root_0);
			LPAREN39=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_insertParams335); 
			pushFollow(FOLLOW_columns_in_insertParams338);
			columns40=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns40.getTree());

			RPAREN41=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_insertParams340); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:141:1: table : IDENT ;
	public final SQLParser.table_return table() throws RecognitionException {
		SQLParser.table_return retval = new SQLParser.table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT42=null;

		CommonTree IDENT42_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:142:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:142:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT42=(Token)match(input,IDENT,FOLLOW_IDENT_in_table353); 
			IDENT42_tree = (CommonTree)adaptor.create(IDENT42);
			adaptor.addChild(root_0, IDENT42_tree);


						//build a Table for use with validation
						table1.setName((IDENT42!=null?IDENT42.getText():null));
						//storageManager.validateTableExists(table1.getName());
						//table1.setDescription(storageManager.getTableDescription((IDENT42!=null?IDENT42.getText():null)));
					
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:152:1: columns : ( column ( COMMA ! column )* ) ;
	public final SQLParser.columns_return columns() throws RecognitionException {
		SQLParser.columns_return retval = new SQLParser.columns_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA44=null;
		ParserRuleReturnScope column43 =null;
		ParserRuleReturnScope column45 =null;

		CommonTree COMMA44_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:153:2: ( ( column ( COMMA ! column )* ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:153:4: ( column ( COMMA ! column )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:153:4: ( column ( COMMA ! column )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:153:5: column ( COMMA ! column )*
			{
			pushFollow(FOLLOW_column_in_columns371);
			column43=column();
			state._fsp--;

			adaptor.addChild(root_0, column43.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:153:12: ( COMMA ! column )*
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( (LA6_0==COMMA) ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:153:13: COMMA ! column
					{
					COMMA44=(Token)match(input,COMMA,FOLLOW_COMMA_in_columns374); 
					pushFollow(FOLLOW_column_in_columns377);
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:156:1: column : IDENT ;
	public final SQLParser.column_return column() throws RecognitionException {
		SQLParser.column_return retval = new SQLParser.column_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT46=null;

		CommonTree IDENT46_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:160:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:160:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT46=(Token)match(input,IDENT,FOLLOW_IDENT_in_column395); 
			IDENT46_tree = (CommonTree)adaptor.create(IDENT46);
			adaptor.addChild(root_0, IDENT46_tree);


						numCols++;
						table1Attributes.add(new Attribute((IDENT46!=null?IDENT46.getText():null)));
					
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:167:1: value : ( STRING_LITERAL | INTEGER );
	public final SQLParser.value_return value() throws RecognitionException {
		SQLParser.value_return retval = new SQLParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL47=null;
		Token INTEGER48=null;

		CommonTree STRING_LITERAL47_tree=null;
		CommonTree INTEGER48_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:168:2: ( STRING_LITERAL | INTEGER )
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==STRING_LITERAL) ) {
				alt7=1;
			}
			else if ( (LA7_0==INTEGER) ) {
				alt7=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 7, 0, input);
				throw nvae;
			}

			switch (alt7) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:168:4: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL47=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_value410); 
					STRING_LITERAL47_tree = (CommonTree)adaptor.create(STRING_LITERAL47);
					adaptor.addChild(root_0, STRING_LITERAL47_tree);


								insertVals.add(STRING_LITERAL47);
								numVals++;
							
					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:173:5: INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					INTEGER48=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value420); 
					INTEGER48_tree = (CommonTree)adaptor.create(INTEGER48);
					adaptor.addChild(root_0, INTEGER48_tree);


								insertVals.add(INTEGER48);
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:180:1: values : ( value ( COMMA ! value )* ) ;
	public final SQLParser.values_return values() throws RecognitionException {
		SQLParser.values_return retval = new SQLParser.values_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA50=null;
		ParserRuleReturnScope value49 =null;
		ParserRuleReturnScope value51 =null;

		CommonTree COMMA50_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:181:2: ( ( value ( COMMA ! value )* ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:181:4: ( value ( COMMA ! value )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:181:4: ( value ( COMMA ! value )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:181:5: value ( COMMA ! value )*
			{
			pushFollow(FOLLOW_value_in_values437);
			value49=value();
			state._fsp--;

			adaptor.addChild(root_0, value49.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:181:11: ( COMMA ! value )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==COMMA) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:181:12: COMMA ! value
					{
					COMMA50=(Token)match(input,COMMA,FOLLOW_COMMA_in_values440); 
					pushFollow(FOLLOW_value_in_values443);
					value51=value();
					state._fsp--;

					adaptor.addChild(root_0, value51.getTree());

					}
					break;

				default :
					break loop8;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:196:1: order : ( ASC | DESC );
	public final SQLParser.order_return order() throws RecognitionException {
		SQLParser.order_return retval = new SQLParser.order_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set52=null;

		CommonTree set52_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:197:2: ( ASC | DESC )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set52=input.LT(1);
			if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set52));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:201:1: assignments : assignment ( COMMA ! assignment )* ;
	public final SQLParser.assignments_return assignments() throws RecognitionException {
		SQLParser.assignments_return retval = new SQLParser.assignments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA54=null;
		ParserRuleReturnScope assignment53 =null;
		ParserRuleReturnScope assignment55 =null;

		CommonTree COMMA54_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:202:2: ( assignment ( COMMA ! assignment )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:202:4: assignment ( COMMA ! assignment )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_assignment_in_assignments480);
			assignment53=assignment();
			state._fsp--;

			adaptor.addChild(root_0, assignment53.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:202:15: ( COMMA ! assignment )*
			loop9:
			while (true) {
				int alt9=2;
				int LA9_0 = input.LA(1);
				if ( (LA9_0==COMMA) ) {
					alt9=1;
				}

				switch (alt9) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:202:16: COMMA ! assignment
					{
					COMMA54=(Token)match(input,COMMA,FOLLOW_COMMA_in_assignments483); 
					pushFollow(FOLLOW_assignment_in_assignments486);
					assignment55=assignment();
					state._fsp--;

					adaptor.addChild(root_0, assignment55.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:205:1: assignment : column EQUAL ^ value ;
	public final SQLParser.assignment_return assignment() throws RecognitionException {
		SQLParser.assignment_return retval = new SQLParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQUAL57=null;
		ParserRuleReturnScope column56 =null;
		ParserRuleReturnScope value58 =null;

		CommonTree EQUAL57_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:206:2: ( column EQUAL ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:206:4: column EQUAL ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_assignment500);
			column56=column();
			state._fsp--;

			adaptor.addChild(root_0, column56.getTree());

			EQUAL57=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_assignment502); 
			EQUAL57_tree = (CommonTree)adaptor.create(EQUAL57);
			root_0 = (CommonTree)adaptor.becomeRoot(EQUAL57_tree, root_0);

			pushFollow(FOLLOW_value_in_assignment505);
			value58=value();
			state._fsp--;

			adaptor.addChild(root_0, value58.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:209:1: searchConditions : searchCondition ( logicalOperator ^ searchCondition )* ;
	public final SQLParser.searchConditions_return searchConditions() throws RecognitionException {
		SQLParser.searchConditions_return retval = new SQLParser.searchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope searchCondition59 =null;
		ParserRuleReturnScope logicalOperator60 =null;
		ParserRuleReturnScope searchCondition61 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:210:2: ( searchCondition ( logicalOperator ^ searchCondition )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:210:4: searchCondition ( logicalOperator ^ searchCondition )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_searchCondition_in_searchConditions517);
			searchCondition59=searchCondition();
			state._fsp--;

			adaptor.addChild(root_0, searchCondition59.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:210:20: ( logicalOperator ^ searchCondition )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==AND||LA10_0==OR) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:210:21: logicalOperator ^ searchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_searchConditions520);
					logicalOperator60=logicalOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(logicalOperator60.getTree(), root_0);
					pushFollow(FOLLOW_searchCondition_in_searchConditions523);
					searchCondition61=searchCondition();
					state._fsp--;

					adaptor.addChild(root_0, searchCondition61.getTree());

					}
					break;

				default :
					break loop10;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:213:1: searchCondition : column comparisonOperator ^ value ;
	public final SQLParser.searchCondition_return searchCondition() throws RecognitionException {
		SQLParser.searchCondition_return retval = new SQLParser.searchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope column62 =null;
		ParserRuleReturnScope comparisonOperator63 =null;
		ParserRuleReturnScope value64 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:214:2: ( column comparisonOperator ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:214:4: column comparisonOperator ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_searchCondition537);
			column62=column();
			state._fsp--;

			adaptor.addChild(root_0, column62.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_searchCondition539);
			comparisonOperator63=comparisonOperator();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(comparisonOperator63.getTree(), root_0);
			pushFollow(FOLLOW_value_in_searchCondition542);
			value64=value();
			state._fsp--;

			adaptor.addChild(root_0, value64.getTree());

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


	public static class comparisonOperator_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "comparisonOperator"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:223:1: comparisonOperator : ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN );
	public final SQLParser.comparisonOperator_return comparisonOperator() throws RecognitionException {
		SQLParser.comparisonOperator_return retval = new SQLParser.comparisonOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set65=null;

		CommonTree set65_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:224:2: ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set65=input.LT(1);
			if ( input.LA(1)==EQUAL||(input.LA(1) >= GREATER_THAN && input.LA(1) <= GREATER_THAN_EQUAL)||(input.LA(1) >= LESS_THAN && input.LA(1) <= LESS_THAN_EQUAL)||input.LA(1)==NOT_EQUAL ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set65));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:232:1: logicalOperator : ( AND ^| OR ^);
	public final SQLParser.logicalOperator_return logicalOperator() throws RecognitionException {
		SQLParser.logicalOperator_return retval = new SQLParser.logicalOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token AND66=null;
		Token OR67=null;

		CommonTree AND66_tree=null;
		CommonTree OR67_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:233:2: ( AND ^| OR ^)
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==AND) ) {
				alt11=1;
			}
			else if ( (LA11_0==OR) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:233:4: AND ^
					{
					root_0 = (CommonTree)adaptor.nil();


					AND66=(Token)match(input,AND,FOLLOW_AND_in_logicalOperator600); 
					AND66_tree = (CommonTree)adaptor.create(AND66);
					root_0 = (CommonTree)adaptor.becomeRoot(AND66_tree, root_0);

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:234:4: OR ^
					{
					root_0 = (CommonTree)adaptor.nil();


					OR67=(Token)match(input,OR,FOLLOW_OR_in_logicalOperator606); 
					OR67_tree = (CommonTree)adaptor.create(OR67);
					root_0 = (CommonTree)adaptor.becomeRoot(OR67_tree, root_0);

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
	public static final BitSet FOLLOW_selectClause_in_select113 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_fromClause_in_select115 = new BitSet(new long[]{0x0000000084800000L});
	public static final BitSet FOLLOW_whereClause_in_select118 = new BitSet(new long[]{0x0000000004800000L});
	public static final BitSet FOLLOW_orderByClause_in_select123 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMI_in_select127 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insertClause_in_insert140 = new BitSet(new long[]{0x0000000040000000L});
	public static final BitSet FOLLOW_valuesClause_in_insert142 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMI_in_insert144 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_updateClause_in_update157 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_setClause_in_update159 = new BitSet(new long[]{0x0000000080000000L});
	public static final BitSet FOLLOW_whereClause_in_update161 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_SEMI_in_update163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_selectClause186 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_columns_in_selectClause189 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_INTO_in_insertClause201 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_insertParams_in_insertClause204 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_updateClause216 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_table_in_updateClause219 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_fromClause231 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_table_in_fromClause234 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_whereClause246 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_searchConditions_in_whereClause249 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_BY_in_orderByClause261 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_column_in_orderByClause264 = new BitSet(new long[]{0x0000000000000162L});
	public static final BitSet FOLLOW_COMMA_in_orderByClause267 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_column_in_orderByClause270 = new BitSet(new long[]{0x0000000000000162L});
	public static final BitSet FOLLOW_order_in_orderByClause275 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUES_in_valuesClause289 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_LPAREN_in_valuesClause292 = new BitSet(new long[]{0x0000000010010000L});
	public static final BitSet FOLLOW_values_in_valuesClause295 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RPAREN_in_valuesClause297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_setClause309 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_assignments_in_setClause312 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_insertParams332 = new BitSet(new long[]{0x0000000000100000L});
	public static final BitSet FOLLOW_LPAREN_in_insertParams335 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_columns_in_insertParams338 = new BitSet(new long[]{0x0000000001000000L});
	public static final BitSet FOLLOW_RPAREN_in_insertParams340 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_table353 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_columns371 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_columns374 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_column_in_columns377 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_IDENT_in_column395 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_value410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_value420 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_values437 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_values440 = new BitSet(new long[]{0x0000000010010000L});
	public static final BitSet FOLLOW_value_in_values443 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_assignment_in_assignments480 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_assignments483 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_assignment_in_assignments486 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_column_in_assignment500 = new BitSet(new long[]{0x0000000000000400L});
	public static final BitSet FOLLOW_EQUAL_in_assignment502 = new BitSet(new long[]{0x0000000010010000L});
	public static final BitSet FOLLOW_value_in_assignment505 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions517 = new BitSet(new long[]{0x0000000000400012L});
	public static final BitSet FOLLOW_logicalOperator_in_searchConditions520 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions523 = new BitSet(new long[]{0x0000000000400012L});
	public static final BitSet FOLLOW_column_in_searchCondition537 = new BitSet(new long[]{0x0000000000263400L});
	public static final BitSet FOLLOW_comparisonOperator_in_searchCondition539 = new BitSet(new long[]{0x0000000010010000L});
	public static final BitSet FOLLOW_value_in_searchCondition542 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_AND_in_logicalOperator600 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_OR_in_logicalOperator606 = new BitSet(new long[]{0x0000000000000002L});
}
