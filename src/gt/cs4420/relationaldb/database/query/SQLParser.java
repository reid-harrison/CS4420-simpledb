// $ANTLR 3.5 C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g 2013-04-24 15:52:35

///////////////////////////////////////////////////////////////////
//                                                               //
//   THIS IS A DERIVED FILE! MAKE ANY DESIRED CHANGES IN SQL.g   //
//                                                               //
///////////////////////////////////////////////////////////////////

package gt.cs4420.relationaldb.database.query;
import gt.cs4420.relationaldb.domain.Table;
import gt.cs4420.relationaldb.domain.Attribute;
import gt.cs4420.relationaldb.domain.exception.ValidationException;
import gt.cs4420.relationaldb.domain.validator.AttributeValidator;
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
		"CREATE_TABLE", "DESC", "DIGIT", "DOT", "DROP_TABLE", "EQUAL", "FOREIGN_KEY", 
		"FROM", "GREATER_THAN", "GREATER_THAN_EQUAL", "IDENT", "INNER_JOIN", "INSERT_INTO", 
		"INTEGER", "JOIN", "LEFT_JOIN", "LESS_THAN", "LESS_THAN_EQUAL", "LETTER", 
		"LPAREN", "NOT_EQUAL", "ON", "OR", "ORDER_BY", "OUTER_JOIN", "RIGHT_JOIN", 
		"RPAREN", "SELECT", "SEMI", "SET", "STRING_LITERAL", "TABLE", "UPDATE", 
		"VALUES", "WHERE", "WS", "'int'", "'varchar(10000)'"
	};
	public static final int EOF=-1;
	public static final int T__44=44;
	public static final int T__45=45;
	public static final int AND=4;
	public static final int ASC=5;
	public static final int COMMA=6;
	public static final int COMMENT=7;
	public static final int CREATE_TABLE=8;
	public static final int DESC=9;
	public static final int DIGIT=10;
	public static final int DOT=11;
	public static final int DROP_TABLE=12;
	public static final int EQUAL=13;
	public static final int FOREIGN_KEY=14;
	public static final int FROM=15;
	public static final int GREATER_THAN=16;
	public static final int GREATER_THAN_EQUAL=17;
	public static final int IDENT=18;
	public static final int INNER_JOIN=19;
	public static final int INSERT_INTO=20;
	public static final int INTEGER=21;
	public static final int JOIN=22;
	public static final int LEFT_JOIN=23;
	public static final int LESS_THAN=24;
	public static final int LESS_THAN_EQUAL=25;
	public static final int LETTER=26;
	public static final int LPAREN=27;
	public static final int NOT_EQUAL=28;
	public static final int ON=29;
	public static final int OR=30;
	public static final int ORDER_BY=31;
	public static final int OUTER_JOIN=32;
	public static final int RIGHT_JOIN=33;
	public static final int RPAREN=34;
	public static final int SELECT=35;
	public static final int SEMI=36;
	public static final int SET=37;
	public static final int STRING_LITERAL=38;
	public static final int TABLE=39;
	public static final int UPDATE=40;
	public static final int VALUES=41;
	public static final int WHERE=42;
	public static final int WS=43;

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
		int numForeignKey = 0;
		Table table1 = new Table();
		Table table2 = new Table();
		boolean isJoin = false;
		List<Table> tables = Lists.newArrayList();
		List<String> tableNames = Lists.newArrayList();
		List<Attribute> table1Attributes = Lists.newArrayList();
		List<Object> insertVals = Lists.newArrayList();
		Map<Attribute, Object> attrVals = Maps.newHashMap();
		AttributeValidator attrValidator = new AttributeValidator();
		StorageManager storageManager = new StorageManager();
		
		@Override    
	    public void displayRecognitionError(String[] tokenNames, RecognitionException e) {
	        String hdr = getErrorHeader(e);
	        String msg = getErrorMessage(e, tokenNames);
	        throw new RuntimeException(hdr + ":" + msg); 
	    }
	    
	    private void validateAttrVals(Table table) throws ValidationException {
	    	for(int i = 0; i < table1Attributes.size(); i++) {
					attrVals.put(table1Attributes.get(i), insertVals.get(i));			
				}
				
				attrValidator.validate(attrVals, table);
	    }


	public static class statement_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "statement"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:89:1: statement : ( select | create | insert | update | dropTable );
	public final SQLParser.statement_return statement() throws RecognitionException {
		SQLParser.statement_return retval = new SQLParser.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope select1 =null;
		ParserRuleReturnScope create2 =null;
		ParserRuleReturnScope insert3 =null;
		ParserRuleReturnScope update4 =null;
		ParserRuleReturnScope dropTable5 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:90:2: ( select | create | insert | update | dropTable )
			int alt1=5;
			switch ( input.LA(1) ) {
			case SELECT:
				{
				alt1=1;
				}
				break;
			case CREATE_TABLE:
				{
				alt1=2;
				}
				break;
			case INSERT_INTO:
				{
				alt1=3;
				}
				break;
			case UPDATE:
				{
				alt1=4;
				}
				break;
			case DROP_TABLE:
				{
				alt1=5;
				}
				break;
			default:
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}
			switch (alt1) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:90:4: select
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_select_in_statement86);
					select1=select();
					state._fsp--;

					adaptor.addChild(root_0, select1.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:91:4: create
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_create_in_statement91);
					create2=create();
					state._fsp--;

					adaptor.addChild(root_0, create2.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:92:4: insert
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_insert_in_statement96);
					insert3=insert();
					state._fsp--;

					adaptor.addChild(root_0, insert3.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:93:4: update
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_update_in_statement101);
					update4=update();
					state._fsp--;

					adaptor.addChild(root_0, update4.getTree());

					}
					break;
				case 5 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:94:4: dropTable
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_dropTable_in_statement106);
					dropTable5=dropTable();
					state._fsp--;

					adaptor.addChild(root_0, dropTable5.getTree());

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


	public static class create_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "create"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:99:1: create : createClause SEMI !;
	public final SQLParser.create_return create() throws RecognitionException {
		SQLParser.create_return retval = new SQLParser.create_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI7=null;
		ParserRuleReturnScope createClause6 =null;

		CommonTree SEMI7_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:100:2: ( createClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:100:4: createClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_createClause_in_create120);
			createClause6=createClause();
			state._fsp--;

			adaptor.addChild(root_0, createClause6.getTree());

			SEMI7=(Token)match(input,SEMI,FOLLOW_SEMI_in_create122); 
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
	// $ANTLR end "create"


	public static class select_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "select"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:1: select : selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !;
	public final SQLParser.select_return select() throws RecognitionException {
		SQLParser.select_return retval = new SQLParser.select_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI13=null;
		ParserRuleReturnScope selectClause8 =null;
		ParserRuleReturnScope fromClause9 =null;
		ParserRuleReturnScope onClause10 =null;
		ParserRuleReturnScope whereClause11 =null;
		ParserRuleReturnScope orderByClause12 =null;

		CommonTree SEMI13_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:2: ( selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:4: selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_selectClause_in_select135);
			selectClause8=selectClause();
			state._fsp--;

			adaptor.addChild(root_0, selectClause8.getTree());

			pushFollow(FOLLOW_fromClause_in_select137);
			fromClause9=fromClause();
			state._fsp--;

			adaptor.addChild(root_0, fromClause9.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:28: ( onClause )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ON) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:29: onClause
					{
					pushFollow(FOLLOW_onClause_in_select140);
					onClause10=onClause();
					state._fsp--;

					adaptor.addChild(root_0, onClause10.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:40: ( whereClause )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==WHERE) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:41: whereClause
					{
					pushFollow(FOLLOW_whereClause_in_select145);
					whereClause11=whereClause();
					state._fsp--;

					adaptor.addChild(root_0, whereClause11.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:55: ( orderByClause )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ORDER_BY) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:104:56: orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_select150);
					orderByClause12=orderByClause();
					state._fsp--;

					adaptor.addChild(root_0, orderByClause12.getTree());

					}
					break;

			}

			SEMI13=(Token)match(input,SEMI,FOLLOW_SEMI_in_select154); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:107:1: insert : insertClause valuesClause SEMI !;
	public final SQLParser.insert_return insert() throws RecognitionException {
		SQLParser.insert_return retval = new SQLParser.insert_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI16=null;
		ParserRuleReturnScope insertClause14 =null;
		ParserRuleReturnScope valuesClause15 =null;

		CommonTree SEMI16_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:108:2: ( insertClause valuesClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:108:4: insertClause valuesClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_insertClause_in_insert167);
			insertClause14=insertClause();
			state._fsp--;

			adaptor.addChild(root_0, insertClause14.getTree());

			pushFollow(FOLLOW_valuesClause_in_insert169);
			valuesClause15=valuesClause();
			state._fsp--;

			adaptor.addChild(root_0, valuesClause15.getTree());

			SEMI16=(Token)match(input,SEMI,FOLLOW_SEMI_in_insert171); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:111:1: update : updateClause setClause whereClause SEMI !;
	public final SQLParser.update_return update() throws RecognitionException {
		SQLParser.update_return retval = new SQLParser.update_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI20=null;
		ParserRuleReturnScope updateClause17 =null;
		ParserRuleReturnScope setClause18 =null;
		ParserRuleReturnScope whereClause19 =null;

		CommonTree SEMI20_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:112:2: ( updateClause setClause whereClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:112:4: updateClause setClause whereClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_updateClause_in_update184);
			updateClause17=updateClause();
			state._fsp--;

			adaptor.addChild(root_0, updateClause17.getTree());

			pushFollow(FOLLOW_setClause_in_update186);
			setClause18=setClause();
			state._fsp--;

			adaptor.addChild(root_0, setClause18.getTree());

			pushFollow(FOLLOW_whereClause_in_update188);
			whereClause19=whereClause();
			state._fsp--;

			adaptor.addChild(root_0, whereClause19.getTree());

			SEMI20=(Token)match(input,SEMI,FOLLOW_SEMI_in_update190); 
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


	public static class dropTable_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dropTable"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:115:1: dropTable : DROP_TABLE ^ table SEMI !;
	public final SQLParser.dropTable_return dropTable() throws RecognitionException {
		SQLParser.dropTable_return retval = new SQLParser.dropTable_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DROP_TABLE21=null;
		Token SEMI23=null;
		ParserRuleReturnScope table22 =null;

		CommonTree DROP_TABLE21_tree=null;
		CommonTree SEMI23_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:116:2: ( DROP_TABLE ^ table SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:116:4: DROP_TABLE ^ table SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			DROP_TABLE21=(Token)match(input,DROP_TABLE,FOLLOW_DROP_TABLE_in_dropTable203); 
			DROP_TABLE21_tree = (CommonTree)adaptor.create(DROP_TABLE21);
			root_0 = (CommonTree)adaptor.becomeRoot(DROP_TABLE21_tree, root_0);

			pushFollow(FOLLOW_table_in_dropTable206);
			table22=table();
			state._fsp--;

			adaptor.addChild(root_0, table22.getTree());

			SEMI23=(Token)match(input,SEMI,FOLLOW_SEMI_in_dropTable208); 
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
	// $ANTLR end "dropTable"


	public static class createClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "createClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:124:1: createClause : CREATE_TABLE ^ createTable ;
	public final SQLParser.createClause_return createClause() throws RecognitionException {
		SQLParser.createClause_return retval = new SQLParser.createClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token CREATE_TABLE24=null;
		ParserRuleReturnScope createTable25 =null;

		CommonTree CREATE_TABLE24_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:125:2: ( CREATE_TABLE ^ createTable )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:125:4: CREATE_TABLE ^ createTable
			{
			root_0 = (CommonTree)adaptor.nil();


			CREATE_TABLE24=(Token)match(input,CREATE_TABLE,FOLLOW_CREATE_TABLE_in_createClause231); 
			CREATE_TABLE24_tree = (CommonTree)adaptor.create(CREATE_TABLE24);
			root_0 = (CommonTree)adaptor.becomeRoot(CREATE_TABLE24_tree, root_0);

			pushFollow(FOLLOW_createTable_in_createClause234);
			createTable25=createTable();
			state._fsp--;

			adaptor.addChild(root_0, createTable25.getTree());

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
	// $ANTLR end "createClause"


	public static class selectClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "selectClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:128:1: selectClause : SELECT ^ columns ;
	public final SQLParser.selectClause_return selectClause() throws RecognitionException {
		SQLParser.selectClause_return retval = new SQLParser.selectClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SELECT26=null;
		ParserRuleReturnScope columns27 =null;

		CommonTree SELECT26_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:129:2: ( SELECT ^ columns )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:129:4: SELECT ^ columns
			{
			root_0 = (CommonTree)adaptor.nil();


			SELECT26=(Token)match(input,SELECT,FOLLOW_SELECT_in_selectClause245); 
			SELECT26_tree = (CommonTree)adaptor.create(SELECT26);
			root_0 = (CommonTree)adaptor.becomeRoot(SELECT26_tree, root_0);

			pushFollow(FOLLOW_columns_in_selectClause248);
			columns27=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns27.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:132:1: insertClause : INSERT_INTO ^ insertParams ;
	public final SQLParser.insertClause_return insertClause() throws RecognitionException {
		SQLParser.insertClause_return retval = new SQLParser.insertClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INSERT_INTO28=null;
		ParserRuleReturnScope insertParams29 =null;

		CommonTree INSERT_INTO28_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:133:2: ( INSERT_INTO ^ insertParams )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:133:4: INSERT_INTO ^ insertParams
			{
			root_0 = (CommonTree)adaptor.nil();


			INSERT_INTO28=(Token)match(input,INSERT_INTO,FOLLOW_INSERT_INTO_in_insertClause260); 
			INSERT_INTO28_tree = (CommonTree)adaptor.create(INSERT_INTO28);
			root_0 = (CommonTree)adaptor.becomeRoot(INSERT_INTO28_tree, root_0);

			pushFollow(FOLLOW_insertParams_in_insertClause263);
			insertParams29=insertParams();
			state._fsp--;

			adaptor.addChild(root_0, insertParams29.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:136:1: updateClause : UPDATE ^ table ;
	public final SQLParser.updateClause_return updateClause() throws RecognitionException {
		SQLParser.updateClause_return retval = new SQLParser.updateClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UPDATE30=null;
		ParserRuleReturnScope table31 =null;

		CommonTree UPDATE30_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:137:2: ( UPDATE ^ table )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:137:4: UPDATE ^ table
			{
			root_0 = (CommonTree)adaptor.nil();


			UPDATE30=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateClause275); 
			UPDATE30_tree = (CommonTree)adaptor.create(UPDATE30);
			root_0 = (CommonTree)adaptor.becomeRoot(UPDATE30_tree, root_0);

			pushFollow(FOLLOW_table_in_updateClause278);
			table31=table();
			state._fsp--;

			adaptor.addChild(root_0, table31.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:140:1: fromClause : FROM ^ tableClause ;
	public final SQLParser.fromClause_return fromClause() throws RecognitionException {
		SQLParser.fromClause_return retval = new SQLParser.fromClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FROM32=null;
		ParserRuleReturnScope tableClause33 =null;

		CommonTree FROM32_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:141:2: ( FROM ^ tableClause )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:141:4: FROM ^ tableClause
			{
			root_0 = (CommonTree)adaptor.nil();


			FROM32=(Token)match(input,FROM,FOLLOW_FROM_in_fromClause290); 
			FROM32_tree = (CommonTree)adaptor.create(FROM32);
			root_0 = (CommonTree)adaptor.becomeRoot(FROM32_tree, root_0);

			pushFollow(FOLLOW_tableClause_in_fromClause293);
			tableClause33=tableClause();
			state._fsp--;

			adaptor.addChild(root_0, tableClause33.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:144:1: tableClause : ( table | joinClause );
	public final SQLParser.tableClause_return tableClause() throws RecognitionException {
		SQLParser.tableClause_return retval = new SQLParser.tableClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope table34 =null;
		ParserRuleReturnScope joinClause35 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:145:2: ( table | joinClause )
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:145:4: table
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_table_in_tableClause306);
					table34=table();
					state._fsp--;

					adaptor.addChild(root_0, table34.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:146:4: joinClause
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_joinClause_in_tableClause311);
					joinClause35=joinClause();
					state._fsp--;

					adaptor.addChild(root_0, joinClause35.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:149:1: joinClause : table ( joinOperator ^ table )+ ;
	public final SQLParser.joinClause_return joinClause() throws RecognitionException {
		SQLParser.joinClause_return retval = new SQLParser.joinClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope table36 =null;
		ParserRuleReturnScope joinOperator37 =null;
		ParserRuleReturnScope table38 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:150:2: ( table ( joinOperator ^ table )+ )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:150:4: table ( joinOperator ^ table )+
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_table_in_joinClause323);
			table36=table();
			state._fsp--;

			adaptor.addChild(root_0, table36.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:150:10: ( joinOperator ^ table )+
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:150:11: joinOperator ^ table
					{
					pushFollow(FOLLOW_joinOperator_in_joinClause326);
					joinOperator37=joinOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(joinOperator37.getTree(), root_0);
					pushFollow(FOLLOW_table_in_joinClause329);
					table38=table();
					state._fsp--;

					adaptor.addChild(root_0, table38.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:157:1: onClause : ON ^ onSearchConditions ;
	public final SQLParser.onClause_return onClause() throws RecognitionException {
		SQLParser.onClause_return retval = new SQLParser.onClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ON39=null;
		ParserRuleReturnScope onSearchConditions40 =null;

		CommonTree ON39_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:158:2: ( ON ^ onSearchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:158:4: ON ^ onSearchConditions
			{
			root_0 = (CommonTree)adaptor.nil();



						if(!isJoin)
						{
							throw new IllegalArgumentException("Expecting previous join clause.");
						}
					
			ON39=(Token)match(input,ON,FOLLOW_ON_in_onClause352); 
			ON39_tree = (CommonTree)adaptor.create(ON39);
			root_0 = (CommonTree)adaptor.becomeRoot(ON39_tree, root_0);

			pushFollow(FOLLOW_onSearchConditions_in_onClause355);
			onSearchConditions40=onSearchConditions();
			state._fsp--;

			adaptor.addChild(root_0, onSearchConditions40.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:167:1: whereClause : WHERE ^ searchConditions ;
	public final SQLParser.whereClause_return whereClause() throws RecognitionException {
		SQLParser.whereClause_return retval = new SQLParser.whereClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHERE41=null;
		ParserRuleReturnScope searchConditions42 =null;

		CommonTree WHERE41_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:168:2: ( WHERE ^ searchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:168:4: WHERE ^ searchConditions
			{
			root_0 = (CommonTree)adaptor.nil();


			WHERE41=(Token)match(input,WHERE,FOLLOW_WHERE_in_whereClause367); 
			WHERE41_tree = (CommonTree)adaptor.create(WHERE41);
			root_0 = (CommonTree)adaptor.becomeRoot(WHERE41_tree, root_0);

			pushFollow(FOLLOW_searchConditions_in_whereClause370);
			searchConditions42=searchConditions();
			state._fsp--;

			adaptor.addChild(root_0, searchConditions42.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:171:1: orderByClause : ORDER_BY ^ column ( order )? ;
	public final SQLParser.orderByClause_return orderByClause() throws RecognitionException {
		SQLParser.orderByClause_return retval = new SQLParser.orderByClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ORDER_BY43=null;
		ParserRuleReturnScope column44 =null;
		ParserRuleReturnScope order45 =null;

		CommonTree ORDER_BY43_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:172:2: ( ORDER_BY ^ column ( order )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:172:4: ORDER_BY ^ column ( order )?
			{
			root_0 = (CommonTree)adaptor.nil();


			ORDER_BY43=(Token)match(input,ORDER_BY,FOLLOW_ORDER_BY_in_orderByClause382); 
			ORDER_BY43_tree = (CommonTree)adaptor.create(ORDER_BY43);
			root_0 = (CommonTree)adaptor.becomeRoot(ORDER_BY43_tree, root_0);

			pushFollow(FOLLOW_column_in_orderByClause385);
			column44=column();
			state._fsp--;

			adaptor.addChild(root_0, column44.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:172:21: ( order )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==ASC||LA7_0==DESC) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:172:22: order
					{
					pushFollow(FOLLOW_order_in_orderByClause388);
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:175:1: valuesClause : VALUES ^ LPAREN ! values RPAREN !;
	public final SQLParser.valuesClause_return valuesClause() throws RecognitionException {
		SQLParser.valuesClause_return retval = new SQLParser.valuesClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token VALUES46=null;
		Token LPAREN47=null;
		Token RPAREN49=null;
		ParserRuleReturnScope values48 =null;

		CommonTree VALUES46_tree=null;
		CommonTree LPAREN47_tree=null;
		CommonTree RPAREN49_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:176:2: ( VALUES ^ LPAREN ! values RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:176:4: VALUES ^ LPAREN ! values RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			VALUES46=(Token)match(input,VALUES,FOLLOW_VALUES_in_valuesClause402); 
			VALUES46_tree = (CommonTree)adaptor.create(VALUES46);
			root_0 = (CommonTree)adaptor.becomeRoot(VALUES46_tree, root_0);

			LPAREN47=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_valuesClause405); 
			pushFollow(FOLLOW_values_in_valuesClause408);
			values48=values();
			state._fsp--;

			adaptor.addChild(root_0, values48.getTree());

			RPAREN49=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_valuesClause410); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:179:1: setClause : SET ^ assignments ;
	public final SQLParser.setClause_return setClause() throws RecognitionException {
		SQLParser.setClause_return retval = new SQLParser.setClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SET50=null;
		ParserRuleReturnScope assignments51 =null;

		CommonTree SET50_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:180:2: ( SET ^ assignments )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:180:4: SET ^ assignments
			{
			root_0 = (CommonTree)adaptor.nil();


			SET50=(Token)match(input,SET,FOLLOW_SET_in_setClause422); 
			SET50_tree = (CommonTree)adaptor.create(SET50);
			root_0 = (CommonTree)adaptor.becomeRoot(SET50_tree, root_0);

			pushFollow(FOLLOW_assignments_in_setClause425);
			assignments51=assignments();
			state._fsp--;

			adaptor.addChild(root_0, assignments51.getTree());

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:190:1: insertParams : table ^ LPAREN ! columns RPAREN !;
	public final SQLParser.insertParams_return insertParams() throws RecognitionException {
		SQLParser.insertParams_return retval = new SQLParser.insertParams_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN53=null;
		Token RPAREN55=null;
		ParserRuleReturnScope table52 =null;
		ParserRuleReturnScope columns54 =null;

		CommonTree LPAREN53_tree=null;
		CommonTree RPAREN55_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:191:2: ( table ^ LPAREN ! columns RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:191:4: table ^ LPAREN ! columns RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_table_in_insertParams445);
			table52=table();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(table52.getTree(), root_0);
			LPAREN53=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_insertParams448); 
			pushFollow(FOLLOW_columns_in_insertParams451);
			columns54=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns54.getTree());

			RPAREN55=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_insertParams453); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:194:1: table : IDENT ;
	public final SQLParser.table_return table() throws RecognitionException {
		SQLParser.table_return retval = new SQLParser.table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT56=null;

		CommonTree IDENT56_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:195:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:195:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_table466); 
			IDENT56_tree = (CommonTree)adaptor.create(IDENT56);
			adaptor.addChild(root_0, IDENT56_tree);


						//build a Table for use with validation
						table1 = storageManager.getTable((IDENT56!=null?IDENT56.getText():null));
						if(table1 == null)
							throw new ValidationException("Table '" + (IDENT56!=null?IDENT56.getText():null) + "' does not exist in the database.");
						tables.add(table1);
						tableNames.add((IDENT56!=null?IDENT56.getText():null));
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (ValidationException e) {
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:207:1: onTable : IDENT ;
	public final SQLParser.onTable_return onTable() throws RecognitionException {
		SQLParser.onTable_return retval = new SQLParser.onTable_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT57=null;

		CommonTree IDENT57_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:208:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:208:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT57=(Token)match(input,IDENT,FOLLOW_IDENT_in_onTable486); 
			IDENT57_tree = (CommonTree)adaptor.create(IDENT57);
			adaptor.addChild(root_0, IDENT57_tree);


						if (!tableNames.contains((IDENT57!=null?IDENT57.getText():null)))
						{
							throw new IllegalArgumentException("'" + (IDENT57!=null?IDENT57.getText():null) + "' is not a table from which items are being queried.");
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


	public static class createTable_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "createTable"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:217:1: createTable : IDENT ^ LPAREN ! columnConstraints RPAREN !;
	public final SQLParser.createTable_return createTable() throws RecognitionException {
		SQLParser.createTable_return retval = new SQLParser.createTable_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT58=null;
		Token LPAREN59=null;
		Token RPAREN61=null;
		ParserRuleReturnScope columnConstraints60 =null;

		CommonTree IDENT58_tree=null;
		CommonTree LPAREN59_tree=null;
		CommonTree RPAREN61_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:218:2: ( IDENT ^ LPAREN ! columnConstraints RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:218:4: IDENT ^ LPAREN ! columnConstraints RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT58=(Token)match(input,IDENT,FOLLOW_IDENT_in_createTable502); 
			IDENT58_tree = (CommonTree)adaptor.create(IDENT58);
			root_0 = (CommonTree)adaptor.becomeRoot(IDENT58_tree, root_0);

			LPAREN59=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_createTable505); 
			pushFollow(FOLLOW_columnConstraints_in_createTable508);
			columnConstraints60=columnConstraints();
			state._fsp--;

			adaptor.addChild(root_0, columnConstraints60.getTree());

			RPAREN61=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_createTable510); 

						table1 = storageManager.getTable((IDENT58!=null?IDENT58.getText():null));
						if(table1 != null)
						{
							throw new ValidationException("Table with name '" + (IDENT58!=null?IDENT58.getText():null) + "' already exists.");
						}
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (ValidationException e) {
		}

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "createTable"


	public static class columnConstraints_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "columnConstraints"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:228:1: columnConstraints : columnConstraint ( COMMA ! columnConstraint )* ;
	public final SQLParser.columnConstraints_return columnConstraints() throws RecognitionException {
		SQLParser.columnConstraints_return retval = new SQLParser.columnConstraints_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA63=null;
		ParserRuleReturnScope columnConstraint62 =null;
		ParserRuleReturnScope columnConstraint64 =null;

		CommonTree COMMA63_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:229:2: ( columnConstraint ( COMMA ! columnConstraint )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:229:4: columnConstraint ( COMMA ! columnConstraint )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_columnConstraint_in_columnConstraints530);
			columnConstraint62=columnConstraint();
			state._fsp--;

			adaptor.addChild(root_0, columnConstraint62.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:229:21: ( COMMA ! columnConstraint )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==COMMA) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:229:22: COMMA ! columnConstraint
					{
					COMMA63=(Token)match(input,COMMA,FOLLOW_COMMA_in_columnConstraints533); 
					pushFollow(FOLLOW_columnConstraint_in_columnConstraints536);
					columnConstraint64=columnConstraint();
					state._fsp--;

					adaptor.addChild(root_0, columnConstraint64.getTree());

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

		    catch (RecognitionException e) {
		        throw e;
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "columnConstraints"


	public static class columnConstraint_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "columnConstraint"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:232:1: columnConstraint : column ^ dataType ( constraint )? ;
	public final SQLParser.columnConstraint_return columnConstraint() throws RecognitionException {
		SQLParser.columnConstraint_return retval = new SQLParser.columnConstraint_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope column65 =null;
		ParserRuleReturnScope dataType66 =null;
		ParserRuleReturnScope constraint67 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:233:2: ( column ^ dataType ( constraint )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:233:4: column ^ dataType ( constraint )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_columnConstraint549);
			column65=column();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(column65.getTree(), root_0);
			pushFollow(FOLLOW_dataType_in_columnConstraint552);
			dataType66=dataType();
			state._fsp--;

			adaptor.addChild(root_0, dataType66.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:233:21: ( constraint )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==FOREIGN_KEY) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:233:21: constraint
					{
					pushFollow(FOLLOW_constraint_in_columnConstraint554);
					constraint67=constraint();
					state._fsp--;

					adaptor.addChild(root_0, constraint67.getTree());

					}
					break;

			}


						if(numForeignKey > 1)
						{
							throw new IllegalArgumentException("Only one foreign key permitted in CREATE.");
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
	// $ANTLR end "columnConstraint"


	public static class dataType_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "dataType"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:1: dataType : ( 'int' | 'varchar(10000)' );
	public final SQLParser.dataType_return dataType() throws RecognitionException {
		SQLParser.dataType_return retval = new SQLParser.dataType_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set68=null;

		CommonTree set68_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:243:2: ( 'int' | 'varchar(10000)' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set68=input.LT(1);
			if ( (input.LA(1) >= 44 && input.LA(1) <= 45) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set68));
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
	// $ANTLR end "dataType"


	public static class constraint_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "constraint"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:247:1: constraint : FOREIGN_KEY ;
	public final SQLParser.constraint_return constraint() throws RecognitionException {
		SQLParser.constraint_return retval = new SQLParser.constraint_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FOREIGN_KEY69=null;

		CommonTree FOREIGN_KEY69_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:248:2: ( FOREIGN_KEY )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:248:4: FOREIGN_KEY
			{
			root_0 = (CommonTree)adaptor.nil();


			FOREIGN_KEY69=(Token)match(input,FOREIGN_KEY,FOLLOW_FOREIGN_KEY_in_constraint587); 
			FOREIGN_KEY69_tree = (CommonTree)adaptor.create(FOREIGN_KEY69);
			adaptor.addChild(root_0, FOREIGN_KEY69_tree);

			numForeignKey++;
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
	// $ANTLR end "constraint"


	public static class columns_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "columns"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:251:1: columns : ( column ( COMMA ! column )* ) ;
	public final SQLParser.columns_return columns() throws RecognitionException {
		SQLParser.columns_return retval = new SQLParser.columns_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA71=null;
		ParserRuleReturnScope column70 =null;
		ParserRuleReturnScope column72 =null;

		CommonTree COMMA71_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:252:2: ( ( column ( COMMA ! column )* ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:252:4: ( column ( COMMA ! column )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:252:4: ( column ( COMMA ! column )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:252:5: column ( COMMA ! column )*
			{
			pushFollow(FOLLOW_column_in_columns601);
			column70=column();
			state._fsp--;

			adaptor.addChild(root_0, column70.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:252:12: ( COMMA ! column )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==COMMA) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:252:13: COMMA ! column
					{
					COMMA71=(Token)match(input,COMMA,FOLLOW_COMMA_in_columns604); 
					pushFollow(FOLLOW_column_in_columns607);
					column72=column();
					state._fsp--;

					adaptor.addChild(root_0, column72.getTree());

					}
					break;

				default :
					break loop10;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:256:1: column : IDENT ;
	public final SQLParser.column_return column() throws RecognitionException {
		SQLParser.column_return retval = new SQLParser.column_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT73=null;

		CommonTree IDENT73_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:257:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:257:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT73=(Token)match(input,IDENT,FOLLOW_IDENT_in_column622); 
			IDENT73_tree = (CommonTree)adaptor.create(IDENT73);
			adaptor.addChild(root_0, IDENT73_tree);


						numCols++;
						table1Attributes.add(new Attribute((IDENT73!=null?IDENT73.getText():null)));
					
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:266:1: value : ( STRING_LITERAL | INTEGER );
	public final SQLParser.value_return value() throws RecognitionException {
		SQLParser.value_return retval = new SQLParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL74=null;
		Token INTEGER75=null;

		CommonTree STRING_LITERAL74_tree=null;
		CommonTree INTEGER75_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:267:2: ( STRING_LITERAL | INTEGER )
			int alt11=2;
			int LA11_0 = input.LA(1);
			if ( (LA11_0==STRING_LITERAL) ) {
				alt11=1;
			}
			else if ( (LA11_0==INTEGER) ) {
				alt11=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 11, 0, input);
				throw nvae;
			}

			switch (alt11) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:267:4: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL74=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_value639); 
					STRING_LITERAL74_tree = (CommonTree)adaptor.create(STRING_LITERAL74);
					adaptor.addChild(root_0, STRING_LITERAL74_tree);


								insertVals.add((STRING_LITERAL74!=null?STRING_LITERAL74.getText():null).substring(1, (STRING_LITERAL74!=null?STRING_LITERAL74.getText():null).length()-1));
								numVals++;
							
					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:272:5: INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					INTEGER75=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value649); 
					INTEGER75_tree = (CommonTree)adaptor.create(INTEGER75);
					adaptor.addChild(root_0, INTEGER75_tree);


								insertVals.add(Integer.parseInt((INTEGER75!=null?INTEGER75.getText():null)));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:279:1: values : ( value ( COMMA ! value )* ) ;
	public final SQLParser.values_return values() throws RecognitionException {
		SQLParser.values_return retval = new SQLParser.values_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA77=null;
		ParserRuleReturnScope value76 =null;
		ParserRuleReturnScope value78 =null;

		CommonTree COMMA77_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:280:2: ( ( value ( COMMA ! value )* ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:280:4: ( value ( COMMA ! value )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:280:4: ( value ( COMMA ! value )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:280:5: value ( COMMA ! value )*
			{
			pushFollow(FOLLOW_value_in_values666);
			value76=value();
			state._fsp--;

			adaptor.addChild(root_0, value76.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:280:11: ( COMMA ! value )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==COMMA) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:280:12: COMMA ! value
					{
					COMMA77=(Token)match(input,COMMA,FOLLOW_COMMA_in_values669); 
					pushFollow(FOLLOW_value_in_values672);
					value78=value();
					state._fsp--;

					adaptor.addChild(root_0, value78.getTree());

					}
					break;

				default :
					break loop12;
				}
			}

			}


						// Number of values must match number of attribues in INSERT
						if (!(numVals == numCols))
						{
							throw new IllegalArgumentException(numCols + " columns specified and " + numVals + " values entered.");
						}	
						
						// Once attributes and values are parsed, put them in a map for validation
						
						validateAttrVals(table1);
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (ValidationException e) {
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:294:1: order : ( ASC | DESC );
	public final SQLParser.order_return order() throws RecognitionException {
		SQLParser.order_return retval = new SQLParser.order_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set79=null;

		CommonTree set79_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:295:2: ( ASC | DESC )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set79=input.LT(1);
			if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set79));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:299:1: assignments : assignment ( COMMA ! assignment )* ;
	public final SQLParser.assignments_return assignments() throws RecognitionException {
		SQLParser.assignments_return retval = new SQLParser.assignments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA81=null;
		ParserRuleReturnScope assignment80 =null;
		ParserRuleReturnScope assignment82 =null;

		CommonTree COMMA81_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:300:2: ( assignment ( COMMA ! assignment )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:300:4: assignment ( COMMA ! assignment )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_assignment_in_assignments711);
			assignment80=assignment();
			state._fsp--;

			adaptor.addChild(root_0, assignment80.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:300:15: ( COMMA ! assignment )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==COMMA) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:300:16: COMMA ! assignment
					{
					COMMA81=(Token)match(input,COMMA,FOLLOW_COMMA_in_assignments714); 
					pushFollow(FOLLOW_assignment_in_assignments717);
					assignment82=assignment();
					state._fsp--;

					adaptor.addChild(root_0, assignment82.getTree());

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
	// $ANTLR end "assignments"


	public static class assignment_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "assignment"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:303:1: assignment : column EQUAL ^ value ;
	public final SQLParser.assignment_return assignment() throws RecognitionException {
		SQLParser.assignment_return retval = new SQLParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQUAL84=null;
		ParserRuleReturnScope column83 =null;
		ParserRuleReturnScope value85 =null;

		CommonTree EQUAL84_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:304:2: ( column EQUAL ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:304:4: column EQUAL ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_assignment731);
			column83=column();
			state._fsp--;

			adaptor.addChild(root_0, column83.getTree());

			EQUAL84=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_assignment733); 
			EQUAL84_tree = (CommonTree)adaptor.create(EQUAL84);
			root_0 = (CommonTree)adaptor.becomeRoot(EQUAL84_tree, root_0);

			pushFollow(FOLLOW_value_in_assignment736);
			value85=value();
			state._fsp--;

			adaptor.addChild(root_0, value85.getTree());


						validateAttrVals(table1);
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (ValidationException e) {
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:311:1: searchConditions : searchCondition ( logicalOperator ^ searchCondition )* ;
	public final SQLParser.searchConditions_return searchConditions() throws RecognitionException {
		SQLParser.searchConditions_return retval = new SQLParser.searchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope searchCondition86 =null;
		ParserRuleReturnScope logicalOperator87 =null;
		ParserRuleReturnScope searchCondition88 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:312:2: ( searchCondition ( logicalOperator ^ searchCondition )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:312:4: searchCondition ( logicalOperator ^ searchCondition )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_searchCondition_in_searchConditions756);
			searchCondition86=searchCondition();
			state._fsp--;

			adaptor.addChild(root_0, searchCondition86.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:312:20: ( logicalOperator ^ searchCondition )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==AND||LA14_0==OR) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:312:21: logicalOperator ^ searchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_searchConditions759);
					logicalOperator87=logicalOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(logicalOperator87.getTree(), root_0);
					pushFollow(FOLLOW_searchCondition_in_searchConditions762);
					searchCondition88=searchCondition();
					state._fsp--;

					adaptor.addChild(root_0, searchCondition88.getTree());

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
	// $ANTLR end "searchConditions"


	public static class searchCondition_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "searchCondition"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:315:1: searchCondition : column comparisonOperator ^ value ;
	public final SQLParser.searchCondition_return searchCondition() throws RecognitionException {
		SQLParser.searchCondition_return retval = new SQLParser.searchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope column89 =null;
		ParserRuleReturnScope comparisonOperator90 =null;
		ParserRuleReturnScope value91 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:316:2: ( column comparisonOperator ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:316:4: column comparisonOperator ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_searchCondition776);
			column89=column();
			state._fsp--;

			adaptor.addChild(root_0, column89.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_searchCondition778);
			comparisonOperator90=comparisonOperator();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(comparisonOperator90.getTree(), root_0);
			pushFollow(FOLLOW_value_in_searchCondition781);
			value91=value();
			state._fsp--;

			adaptor.addChild(root_0, value91.getTree());


						boolean found = false;
						
						for(Table table : tables)
						{
							if(!found)
							{
								validateAttrVals(table);
							}
						}
						
						if(!found)
						{
							throw new ValidationException("Validation error in WHERE clause conditions.");
						}
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (ValidationException e) {
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:336:1: onSearchConditions : onSearchCondition ( logicalOperator ^ onSearchCondition )* ;
	public final SQLParser.onSearchConditions_return onSearchConditions() throws RecognitionException {
		SQLParser.onSearchConditions_return retval = new SQLParser.onSearchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope onSearchCondition92 =null;
		ParserRuleReturnScope logicalOperator93 =null;
		ParserRuleReturnScope onSearchCondition94 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:337:2: ( onSearchCondition ( logicalOperator ^ onSearchCondition )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:337:4: onSearchCondition ( logicalOperator ^ onSearchCondition )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_onSearchCondition_in_onSearchConditions801);
			onSearchCondition92=onSearchCondition();
			state._fsp--;

			adaptor.addChild(root_0, onSearchCondition92.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:337:22: ( logicalOperator ^ onSearchCondition )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==AND||LA15_0==OR) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:337:23: logicalOperator ^ onSearchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_onSearchConditions804);
					logicalOperator93=logicalOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(logicalOperator93.getTree(), root_0);
					pushFollow(FOLLOW_onSearchCondition_in_onSearchConditions807);
					onSearchCondition94=onSearchCondition();
					state._fsp--;

					adaptor.addChild(root_0, onSearchCondition94.getTree());

					}
					break;

				default :
					break loop15;
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:340:1: onSearchCondition : onTable DOT ! column comparisonOperator ^ value ;
	public final SQLParser.onSearchCondition_return onSearchCondition() throws RecognitionException {
		SQLParser.onSearchCondition_return retval = new SQLParser.onSearchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DOT96=null;
		ParserRuleReturnScope onTable95 =null;
		ParserRuleReturnScope column97 =null;
		ParserRuleReturnScope comparisonOperator98 =null;
		ParserRuleReturnScope value99 =null;

		CommonTree DOT96_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:341:2: ( onTable DOT ! column comparisonOperator ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:341:4: onTable DOT ! column comparisonOperator ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_onTable_in_onSearchCondition820);
			onTable95=onTable();
			state._fsp--;

			adaptor.addChild(root_0, onTable95.getTree());

			DOT96=(Token)match(input,DOT,FOLLOW_DOT_in_onSearchCondition822); 
			pushFollow(FOLLOW_column_in_onSearchCondition824);
			column97=column();
			state._fsp--;

			adaptor.addChild(root_0, column97.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_onSearchCondition826);
			comparisonOperator98=comparisonOperator();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(comparisonOperator98.getTree(), root_0);
			pushFollow(FOLLOW_value_in_onSearchCondition829);
			value99=value();
			state._fsp--;

			adaptor.addChild(root_0, value99.getTree());


						Object tmp;
						attrValidator.validate(new Attribute[]{new Attribute((column97!=null?input.toString(column97.start,column97.stop):null))}, storageManager.getTable((onTable95!=null?input.toString(onTable95.start,onTable95.stop):null)));
						if((value99!=null?input.toString(value99.start,value99.stop):null).startsWith("'") && (value99!=null?input.toString(value99.start,value99.stop):null).endsWith("'"))
						{
							tmp = (value99!=null?input.toString(value99.start,value99.stop):null).substring(1, (value99!=null?input.toString(value99.start,value99.stop):null).length()-1);
						}
						else
						{
							tmp = Integer.parseInt((value99!=null?input.toString(value99.start,value99.stop):null));
						}
						
						attrValidator.attributeTypeCheck(storageManager.getTable((onTable95!=null?input.toString(onTable95.start,onTable95.stop):null)).getDescription().getAttribute((column97!=null?input.toString(column97.start,column97.stop):null)), tmp);
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}
		catch (ValidationException e) {
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:364:1: comparisonOperator : ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN );
	public final SQLParser.comparisonOperator_return comparisonOperator() throws RecognitionException {
		SQLParser.comparisonOperator_return retval = new SQLParser.comparisonOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set100=null;

		CommonTree set100_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:365:2: ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set100=input.LT(1);
			if ( input.LA(1)==EQUAL||(input.LA(1) >= GREATER_THAN && input.LA(1) <= GREATER_THAN_EQUAL)||(input.LA(1) >= LESS_THAN && input.LA(1) <= LESS_THAN_EQUAL)||input.LA(1)==NOT_EQUAL ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set100));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:373:1: logicalOperator : ( AND | OR );
	public final SQLParser.logicalOperator_return logicalOperator() throws RecognitionException {
		SQLParser.logicalOperator_return retval = new SQLParser.logicalOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set101=null;

		CommonTree set101_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:374:2: ( AND | OR )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set101=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==OR ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set101));
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:378:1: joinOperator : ( INNER_JOIN | OUTER_JOIN | LEFT_JOIN | RIGHT_JOIN | JOIN );
	public final SQLParser.joinOperator_return joinOperator() throws RecognitionException {
		SQLParser.joinOperator_return retval = new SQLParser.joinOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set102=null;

		CommonTree set102_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:379:2: ( INNER_JOIN | OUTER_JOIN | LEFT_JOIN | RIGHT_JOIN | JOIN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set102=input.LT(1);
			if ( input.LA(1)==INNER_JOIN||(input.LA(1) >= JOIN && input.LA(1) <= LEFT_JOIN)||(input.LA(1) >= OUTER_JOIN && input.LA(1) <= RIGHT_JOIN) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set102));
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



	public static final BitSet FOLLOW_select_in_statement86 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_create_in_statement91 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insert_in_statement96 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_update_in_statement101 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_dropTable_in_statement106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createClause_in_create120 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMI_in_create122 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectClause_in_select135 = new BitSet(new long[]{0x0000000000008000L});
	public static final BitSet FOLLOW_fromClause_in_select137 = new BitSet(new long[]{0x00000410A0000000L});
	public static final BitSet FOLLOW_onClause_in_select140 = new BitSet(new long[]{0x0000041080000000L});
	public static final BitSet FOLLOW_whereClause_in_select145 = new BitSet(new long[]{0x0000001080000000L});
	public static final BitSet FOLLOW_orderByClause_in_select150 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMI_in_select154 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insertClause_in_insert167 = new BitSet(new long[]{0x0000020000000000L});
	public static final BitSet FOLLOW_valuesClause_in_insert169 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMI_in_insert171 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_updateClause_in_update184 = new BitSet(new long[]{0x0000002000000000L});
	public static final BitSet FOLLOW_setClause_in_update186 = new BitSet(new long[]{0x0000040000000000L});
	public static final BitSet FOLLOW_whereClause_in_update188 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMI_in_update190 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_DROP_TABLE_in_dropTable203 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_table_in_dropTable206 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_SEMI_in_dropTable208 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREATE_TABLE_in_createClause231 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_createTable_in_createClause234 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_selectClause245 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_columns_in_selectClause248 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_INTO_in_insertClause260 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_insertParams_in_insertClause263 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_updateClause275 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_table_in_updateClause278 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_fromClause290 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_tableClause_in_fromClause293 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_tableClause306 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_joinClause_in_tableClause311 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_joinClause323 = new BitSet(new long[]{0x0000000300C80000L});
	public static final BitSet FOLLOW_joinOperator_in_joinClause326 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_table_in_joinClause329 = new BitSet(new long[]{0x0000000300C80002L});
	public static final BitSet FOLLOW_ON_in_onClause352 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_onSearchConditions_in_onClause355 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_whereClause367 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_searchConditions_in_whereClause370 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_BY_in_orderByClause382 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_column_in_orderByClause385 = new BitSet(new long[]{0x0000000000000222L});
	public static final BitSet FOLLOW_order_in_orderByClause388 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUES_in_valuesClause402 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAREN_in_valuesClause405 = new BitSet(new long[]{0x0000004000200000L});
	public static final BitSet FOLLOW_values_in_valuesClause408 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_RPAREN_in_valuesClause410 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_setClause422 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_assignments_in_setClause425 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_insertParams445 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAREN_in_insertParams448 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_columns_in_insertParams451 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_RPAREN_in_insertParams453 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_table466 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_onTable486 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_createTable502 = new BitSet(new long[]{0x0000000008000000L});
	public static final BitSet FOLLOW_LPAREN_in_createTable505 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_columnConstraints_in_createTable508 = new BitSet(new long[]{0x0000000400000000L});
	public static final BitSet FOLLOW_RPAREN_in_createTable510 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_columnConstraint_in_columnConstraints530 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_columnConstraints533 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_columnConstraint_in_columnConstraints536 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_column_in_columnConstraint549 = new BitSet(new long[]{0x0000300000000000L});
	public static final BitSet FOLLOW_dataType_in_columnConstraint552 = new BitSet(new long[]{0x0000000000004002L});
	public static final BitSet FOLLOW_constraint_in_columnConstraint554 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOREIGN_KEY_in_constraint587 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_columns601 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_columns604 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_column_in_columns607 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_IDENT_in_column622 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_value639 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_value649 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_values666 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_values669 = new BitSet(new long[]{0x0000004000200000L});
	public static final BitSet FOLLOW_value_in_values672 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_assignment_in_assignments711 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_assignments714 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_assignment_in_assignments717 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_column_in_assignment731 = new BitSet(new long[]{0x0000000000002000L});
	public static final BitSet FOLLOW_EQUAL_in_assignment733 = new BitSet(new long[]{0x0000004000200000L});
	public static final BitSet FOLLOW_value_in_assignment736 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions756 = new BitSet(new long[]{0x0000000040000012L});
	public static final BitSet FOLLOW_logicalOperator_in_searchConditions759 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions762 = new BitSet(new long[]{0x0000000040000012L});
	public static final BitSet FOLLOW_column_in_searchCondition776 = new BitSet(new long[]{0x0000000013032000L});
	public static final BitSet FOLLOW_comparisonOperator_in_searchCondition778 = new BitSet(new long[]{0x0000004000200000L});
	public static final BitSet FOLLOW_value_in_searchCondition781 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_onSearchCondition_in_onSearchConditions801 = new BitSet(new long[]{0x0000000040000012L});
	public static final BitSet FOLLOW_logicalOperator_in_onSearchConditions804 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_onSearchCondition_in_onSearchConditions807 = new BitSet(new long[]{0x0000000040000012L});
	public static final BitSet FOLLOW_onTable_in_onSearchCondition820 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_DOT_in_onSearchCondition822 = new BitSet(new long[]{0x0000000000040000L});
	public static final BitSet FOLLOW_column_in_onSearchCondition824 = new BitSet(new long[]{0x0000000013032000L});
	public static final BitSet FOLLOW_comparisonOperator_in_onSearchCondition826 = new BitSet(new long[]{0x0000004000200000L});
	public static final BitSet FOLLOW_value_in_onSearchCondition829 = new BitSet(new long[]{0x0000000000000002L});
}
