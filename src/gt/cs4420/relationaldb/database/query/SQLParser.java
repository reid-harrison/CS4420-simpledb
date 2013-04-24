// $ANTLR 3.5 C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g 2013-04-24 04:02:28

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
		"CREATE_TABLE", "DESC", "DIGIT", "DOT", "EQUAL", "FOREIGN_KEY", "FROM", 
		"GREATER_THAN", "GREATER_THAN_EQUAL", "IDENT", "INNER_JOIN", "INSERT_INTO", 
		"INTEGER", "JOIN", "LEFT_JOIN", "LESS_THAN", "LESS_THAN_EQUAL", "LETTER", 
		"LPAREN", "NOT_EQUAL", "ON", "OR", "ORDER_BY", "OUTER_JOIN", "RIGHT_JOIN", 
		"RPAREN", "SELECT", "SEMI", "SET", "STRING_LITERAL", "UPDATE", "VALUES", 
		"WHERE", "WS", "'int'", "'varchar(10000)'"
	};
	public static final int EOF=-1;
	public static final int T__42=42;
	public static final int T__43=43;
	public static final int AND=4;
	public static final int ASC=5;
	public static final int COMMA=6;
	public static final int COMMENT=7;
	public static final int CREATE_TABLE=8;
	public static final int DESC=9;
	public static final int DIGIT=10;
	public static final int DOT=11;
	public static final int EQUAL=12;
	public static final int FOREIGN_KEY=13;
	public static final int FROM=14;
	public static final int GREATER_THAN=15;
	public static final int GREATER_THAN_EQUAL=16;
	public static final int IDENT=17;
	public static final int INNER_JOIN=18;
	public static final int INSERT_INTO=19;
	public static final int INTEGER=20;
	public static final int JOIN=21;
	public static final int LEFT_JOIN=22;
	public static final int LESS_THAN=23;
	public static final int LESS_THAN_EQUAL=24;
	public static final int LETTER=25;
	public static final int LPAREN=26;
	public static final int NOT_EQUAL=27;
	public static final int ON=28;
	public static final int OR=29;
	public static final int ORDER_BY=30;
	public static final int OUTER_JOIN=31;
	public static final int RIGHT_JOIN=32;
	public static final int RPAREN=33;
	public static final int SELECT=34;
	public static final int SEMI=35;
	public static final int SET=36;
	public static final int STRING_LITERAL=37;
	public static final int UPDATE=38;
	public static final int VALUES=39;
	public static final int WHERE=40;
	public static final int WS=41;

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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:88:1: statement : ( select | create | insert | update | EOF );
	public final SQLParser.statement_return statement() throws RecognitionException {
		SQLParser.statement_return retval = new SQLParser.statement_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EOF5=null;
		ParserRuleReturnScope select1 =null;
		ParserRuleReturnScope create2 =null;
		ParserRuleReturnScope insert3 =null;
		ParserRuleReturnScope update4 =null;

		CommonTree EOF5_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:89:2: ( select | create | insert | update | EOF )
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
			case EOF:
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:89:4: select
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_select_in_statement86);
					select1=select();
					state._fsp--;

					adaptor.addChild(root_0, select1.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:90:4: create
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_create_in_statement91);
					create2=create();
					state._fsp--;

					adaptor.addChild(root_0, create2.getTree());

					}
					break;
				case 3 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:91:4: insert
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_insert_in_statement96);
					insert3=insert();
					state._fsp--;

					adaptor.addChild(root_0, insert3.getTree());

					}
					break;
				case 4 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:92:4: update
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_update_in_statement101);
					update4=update();
					state._fsp--;

					adaptor.addChild(root_0, update4.getTree());

					}
					break;
				case 5 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:93:4: EOF
					{
					root_0 = (CommonTree)adaptor.nil();


					EOF5=(Token)match(input,EOF,FOLLOW_EOF_in_statement106); 
					EOF5_tree = (CommonTree)adaptor.create(EOF5);
					adaptor.addChild(root_0, EOF5_tree);

					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage()); 
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:98:1: create : createClause ^ LPAREN ! columnConstraints RPAREN ! SEMI !;
	public final SQLParser.create_return create() throws RecognitionException {
		SQLParser.create_return retval = new SQLParser.create_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token LPAREN7=null;
		Token RPAREN9=null;
		Token SEMI10=null;
		ParserRuleReturnScope createClause6 =null;
		ParserRuleReturnScope columnConstraints8 =null;

		CommonTree LPAREN7_tree=null;
		CommonTree RPAREN9_tree=null;
		CommonTree SEMI10_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:99:2: ( createClause ^ LPAREN ! columnConstraints RPAREN ! SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:99:4: createClause ^ LPAREN ! columnConstraints RPAREN ! SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_createClause_in_create120);
			createClause6=createClause();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(createClause6.getTree(), root_0);
			LPAREN7=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_create123); 
			pushFollow(FOLLOW_columnConstraints_in_create126);
			columnConstraints8=columnConstraints();
			state._fsp--;

			adaptor.addChild(root_0, columnConstraints8.getTree());

			RPAREN9=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_create128); 
			SEMI10=(Token)match(input,SEMI,FOLLOW_SEMI_in_create131); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:102:1: select : selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !;
	public final SQLParser.select_return select() throws RecognitionException {
		SQLParser.select_return retval = new SQLParser.select_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI16=null;
		ParserRuleReturnScope selectClause11 =null;
		ParserRuleReturnScope fromClause12 =null;
		ParserRuleReturnScope onClause13 =null;
		ParserRuleReturnScope whereClause14 =null;
		ParserRuleReturnScope orderByClause15 =null;

		CommonTree SEMI16_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:2: ( selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:4: selectClause fromClause ( onClause )? ( whereClause )? ( orderByClause )? SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_selectClause_in_select144);
			selectClause11=selectClause();
			state._fsp--;

			adaptor.addChild(root_0, selectClause11.getTree());

			pushFollow(FOLLOW_fromClause_in_select146);
			fromClause12=fromClause();
			state._fsp--;

			adaptor.addChild(root_0, fromClause12.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:28: ( onClause )?
			int alt2=2;
			int LA2_0 = input.LA(1);
			if ( (LA2_0==ON) ) {
				alt2=1;
			}
			switch (alt2) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:29: onClause
					{
					pushFollow(FOLLOW_onClause_in_select149);
					onClause13=onClause();
					state._fsp--;

					adaptor.addChild(root_0, onClause13.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:40: ( whereClause )?
			int alt3=2;
			int LA3_0 = input.LA(1);
			if ( (LA3_0==WHERE) ) {
				alt3=1;
			}
			switch (alt3) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:41: whereClause
					{
					pushFollow(FOLLOW_whereClause_in_select154);
					whereClause14=whereClause();
					state._fsp--;

					adaptor.addChild(root_0, whereClause14.getTree());

					}
					break;

			}

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:55: ( orderByClause )?
			int alt4=2;
			int LA4_0 = input.LA(1);
			if ( (LA4_0==ORDER_BY) ) {
				alt4=1;
			}
			switch (alt4) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:103:56: orderByClause
					{
					pushFollow(FOLLOW_orderByClause_in_select159);
					orderByClause15=orderByClause();
					state._fsp--;

					adaptor.addChild(root_0, orderByClause15.getTree());

					}
					break;

			}

			SEMI16=(Token)match(input,SEMI,FOLLOW_SEMI_in_select163); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:106:1: insert : insertClause valuesClause SEMI !;
	public final SQLParser.insert_return insert() throws RecognitionException {
		SQLParser.insert_return retval = new SQLParser.insert_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI19=null;
		ParserRuleReturnScope insertClause17 =null;
		ParserRuleReturnScope valuesClause18 =null;

		CommonTree SEMI19_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:107:2: ( insertClause valuesClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:107:4: insertClause valuesClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_insertClause_in_insert176);
			insertClause17=insertClause();
			state._fsp--;

			adaptor.addChild(root_0, insertClause17.getTree());

			pushFollow(FOLLOW_valuesClause_in_insert178);
			valuesClause18=valuesClause();
			state._fsp--;

			adaptor.addChild(root_0, valuesClause18.getTree());

			SEMI19=(Token)match(input,SEMI,FOLLOW_SEMI_in_insert180); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:110:1: update : updateClause setClause whereClause SEMI !;
	public final SQLParser.update_return update() throws RecognitionException {
		SQLParser.update_return retval = new SQLParser.update_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SEMI23=null;
		ParserRuleReturnScope updateClause20 =null;
		ParserRuleReturnScope setClause21 =null;
		ParserRuleReturnScope whereClause22 =null;

		CommonTree SEMI23_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:111:2: ( updateClause setClause whereClause SEMI !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:111:4: updateClause setClause whereClause SEMI !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_updateClause_in_update193);
			updateClause20=updateClause();
			state._fsp--;

			adaptor.addChild(root_0, updateClause20.getTree());

			pushFollow(FOLLOW_setClause_in_update195);
			setClause21=setClause();
			state._fsp--;

			adaptor.addChild(root_0, setClause21.getTree());

			pushFollow(FOLLOW_whereClause_in_update197);
			whereClause22=whereClause();
			state._fsp--;

			adaptor.addChild(root_0, whereClause22.getTree());

			SEMI23=(Token)match(input,SEMI,FOLLOW_SEMI_in_update199); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
		    }

		finally {
			// do for sure before leaving
		}
		return retval;
	}
	// $ANTLR end "update"


	public static class createClause_return extends ParserRuleReturnScope {
		CommonTree tree;
		@Override
		public CommonTree getTree() { return tree; }
	};


	// $ANTLR start "createClause"
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:119:1: createClause : CREATE_TABLE ^ createTable ;
	public final SQLParser.createClause_return createClause() throws RecognitionException {
		SQLParser.createClause_return retval = new SQLParser.createClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token CREATE_TABLE24=null;
		ParserRuleReturnScope createTable25 =null;

		CommonTree CREATE_TABLE24_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:120:2: ( CREATE_TABLE ^ createTable )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:120:4: CREATE_TABLE ^ createTable
			{
			root_0 = (CommonTree)adaptor.nil();


			CREATE_TABLE24=(Token)match(input,CREATE_TABLE,FOLLOW_CREATE_TABLE_in_createClause222); 
			CREATE_TABLE24_tree = (CommonTree)adaptor.create(CREATE_TABLE24);
			root_0 = (CommonTree)adaptor.becomeRoot(CREATE_TABLE24_tree, root_0);

			pushFollow(FOLLOW_createTable_in_createClause225);
			createTable25=createTable();
			state._fsp--;

			adaptor.addChild(root_0, createTable25.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:123:1: selectClause : SELECT ^ columns ;
	public final SQLParser.selectClause_return selectClause() throws RecognitionException {
		SQLParser.selectClause_return retval = new SQLParser.selectClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SELECT26=null;
		ParserRuleReturnScope columns27 =null;

		CommonTree SELECT26_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:124:2: ( SELECT ^ columns )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:124:4: SELECT ^ columns
			{
			root_0 = (CommonTree)adaptor.nil();


			SELECT26=(Token)match(input,SELECT,FOLLOW_SELECT_in_selectClause236); 
			SELECT26_tree = (CommonTree)adaptor.create(SELECT26);
			root_0 = (CommonTree)adaptor.becomeRoot(SELECT26_tree, root_0);

			pushFollow(FOLLOW_columns_in_selectClause239);
			columns27=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns27.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:127:1: insertClause : INSERT_INTO ^ insertParams ;
	public final SQLParser.insertClause_return insertClause() throws RecognitionException {
		SQLParser.insertClause_return retval = new SQLParser.insertClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token INSERT_INTO28=null;
		ParserRuleReturnScope insertParams29 =null;

		CommonTree INSERT_INTO28_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:128:2: ( INSERT_INTO ^ insertParams )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:128:4: INSERT_INTO ^ insertParams
			{
			root_0 = (CommonTree)adaptor.nil();


			INSERT_INTO28=(Token)match(input,INSERT_INTO,FOLLOW_INSERT_INTO_in_insertClause251); 
			INSERT_INTO28_tree = (CommonTree)adaptor.create(INSERT_INTO28);
			root_0 = (CommonTree)adaptor.becomeRoot(INSERT_INTO28_tree, root_0);

			pushFollow(FOLLOW_insertParams_in_insertClause254);
			insertParams29=insertParams();
			state._fsp--;

			adaptor.addChild(root_0, insertParams29.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:131:1: updateClause : UPDATE ^ table ;
	public final SQLParser.updateClause_return updateClause() throws RecognitionException {
		SQLParser.updateClause_return retval = new SQLParser.updateClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token UPDATE30=null;
		ParserRuleReturnScope table31 =null;

		CommonTree UPDATE30_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:132:2: ( UPDATE ^ table )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:132:4: UPDATE ^ table
			{
			root_0 = (CommonTree)adaptor.nil();


			UPDATE30=(Token)match(input,UPDATE,FOLLOW_UPDATE_in_updateClause266); 
			UPDATE30_tree = (CommonTree)adaptor.create(UPDATE30);
			root_0 = (CommonTree)adaptor.becomeRoot(UPDATE30_tree, root_0);

			pushFollow(FOLLOW_table_in_updateClause269);
			table31=table();
			state._fsp--;

			adaptor.addChild(root_0, table31.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:135:1: fromClause : FROM ^ tableClause ;
	public final SQLParser.fromClause_return fromClause() throws RecognitionException {
		SQLParser.fromClause_return retval = new SQLParser.fromClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FROM32=null;
		ParserRuleReturnScope tableClause33 =null;

		CommonTree FROM32_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:136:2: ( FROM ^ tableClause )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:136:4: FROM ^ tableClause
			{
			root_0 = (CommonTree)adaptor.nil();


			FROM32=(Token)match(input,FROM,FOLLOW_FROM_in_fromClause281); 
			FROM32_tree = (CommonTree)adaptor.create(FROM32);
			root_0 = (CommonTree)adaptor.becomeRoot(FROM32_tree, root_0);

			pushFollow(FOLLOW_tableClause_in_fromClause284);
			tableClause33=tableClause();
			state._fsp--;

			adaptor.addChild(root_0, tableClause33.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:139:1: tableClause : ( table | joinClause );
	public final SQLParser.tableClause_return tableClause() throws RecognitionException {
		SQLParser.tableClause_return retval = new SQLParser.tableClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope table34 =null;
		ParserRuleReturnScope joinClause35 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:140:2: ( table | joinClause )
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:140:4: table
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_table_in_tableClause297);
					table34=table();
					state._fsp--;

					adaptor.addChild(root_0, table34.getTree());

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:141:4: joinClause
					{
					root_0 = (CommonTree)adaptor.nil();


					pushFollow(FOLLOW_joinClause_in_tableClause302);
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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:144:1: joinClause : table ( joinOperator ^ table )+ ;
	public final SQLParser.joinClause_return joinClause() throws RecognitionException {
		SQLParser.joinClause_return retval = new SQLParser.joinClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope table36 =null;
		ParserRuleReturnScope joinOperator37 =null;
		ParserRuleReturnScope table38 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:145:2: ( table ( joinOperator ^ table )+ )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:145:4: table ( joinOperator ^ table )+
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_table_in_joinClause314);
			table36=table();
			state._fsp--;

			adaptor.addChild(root_0, table36.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:145:10: ( joinOperator ^ table )+
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:145:11: joinOperator ^ table
					{
					pushFollow(FOLLOW_joinOperator_in_joinClause317);
					joinOperator37=joinOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(joinOperator37.getTree(), root_0);
					pushFollow(FOLLOW_table_in_joinClause320);
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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:152:1: onClause : ON ^ onSearchConditions ;
	public final SQLParser.onClause_return onClause() throws RecognitionException {
		SQLParser.onClause_return retval = new SQLParser.onClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ON39=null;
		ParserRuleReturnScope onSearchConditions40 =null;

		CommonTree ON39_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:153:2: ( ON ^ onSearchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:153:4: ON ^ onSearchConditions
			{
			root_0 = (CommonTree)adaptor.nil();



						if(!isJoin)
						{
							throw new IllegalArgumentException("Expecting previous join clause.");
						}
					
			ON39=(Token)match(input,ON,FOLLOW_ON_in_onClause343); 
			ON39_tree = (CommonTree)adaptor.create(ON39);
			root_0 = (CommonTree)adaptor.becomeRoot(ON39_tree, root_0);

			pushFollow(FOLLOW_onSearchConditions_in_onClause346);
			onSearchConditions40=onSearchConditions();
			state._fsp--;

			adaptor.addChild(root_0, onSearchConditions40.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:162:1: whereClause : WHERE ^ searchConditions ;
	public final SQLParser.whereClause_return whereClause() throws RecognitionException {
		SQLParser.whereClause_return retval = new SQLParser.whereClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token WHERE41=null;
		ParserRuleReturnScope searchConditions42 =null;

		CommonTree WHERE41_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:163:2: ( WHERE ^ searchConditions )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:163:4: WHERE ^ searchConditions
			{
			root_0 = (CommonTree)adaptor.nil();


			WHERE41=(Token)match(input,WHERE,FOLLOW_WHERE_in_whereClause358); 
			WHERE41_tree = (CommonTree)adaptor.create(WHERE41);
			root_0 = (CommonTree)adaptor.becomeRoot(WHERE41_tree, root_0);

			pushFollow(FOLLOW_searchConditions_in_whereClause361);
			searchConditions42=searchConditions();
			state._fsp--;

			adaptor.addChild(root_0, searchConditions42.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:166:1: orderByClause : ORDER_BY ^ column ( order )? ;
	public final SQLParser.orderByClause_return orderByClause() throws RecognitionException {
		SQLParser.orderByClause_return retval = new SQLParser.orderByClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token ORDER_BY43=null;
		ParserRuleReturnScope column44 =null;
		ParserRuleReturnScope order45 =null;

		CommonTree ORDER_BY43_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:167:2: ( ORDER_BY ^ column ( order )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:167:4: ORDER_BY ^ column ( order )?
			{
			root_0 = (CommonTree)adaptor.nil();


			ORDER_BY43=(Token)match(input,ORDER_BY,FOLLOW_ORDER_BY_in_orderByClause373); 
			ORDER_BY43_tree = (CommonTree)adaptor.create(ORDER_BY43);
			root_0 = (CommonTree)adaptor.becomeRoot(ORDER_BY43_tree, root_0);

			pushFollow(FOLLOW_column_in_orderByClause376);
			column44=column();
			state._fsp--;

			adaptor.addChild(root_0, column44.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:167:21: ( order )?
			int alt7=2;
			int LA7_0 = input.LA(1);
			if ( (LA7_0==ASC||LA7_0==DESC) ) {
				alt7=1;
			}
			switch (alt7) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:167:22: order
					{
					pushFollow(FOLLOW_order_in_orderByClause379);
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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:170:1: valuesClause : VALUES ^ LPAREN ! values RPAREN !;
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:171:2: ( VALUES ^ LPAREN ! values RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:171:4: VALUES ^ LPAREN ! values RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			VALUES46=(Token)match(input,VALUES,FOLLOW_VALUES_in_valuesClause393); 
			VALUES46_tree = (CommonTree)adaptor.create(VALUES46);
			root_0 = (CommonTree)adaptor.becomeRoot(VALUES46_tree, root_0);

			LPAREN47=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_valuesClause396); 
			pushFollow(FOLLOW_values_in_valuesClause399);
			values48=values();
			state._fsp--;

			adaptor.addChild(root_0, values48.getTree());

			RPAREN49=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_valuesClause401); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:174:1: setClause : SET ^ assignments ;
	public final SQLParser.setClause_return setClause() throws RecognitionException {
		SQLParser.setClause_return retval = new SQLParser.setClause_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token SET50=null;
		ParserRuleReturnScope assignments51 =null;

		CommonTree SET50_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:175:2: ( SET ^ assignments )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:175:4: SET ^ assignments
			{
			root_0 = (CommonTree)adaptor.nil();


			SET50=(Token)match(input,SET,FOLLOW_SET_in_setClause413); 
			SET50_tree = (CommonTree)adaptor.create(SET50);
			root_0 = (CommonTree)adaptor.becomeRoot(SET50_tree, root_0);

			pushFollow(FOLLOW_assignments_in_setClause416);
			assignments51=assignments();
			state._fsp--;

			adaptor.addChild(root_0, assignments51.getTree());

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:185:1: insertParams : table ^ LPAREN ! columns RPAREN !;
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
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:186:2: ( table ^ LPAREN ! columns RPAREN !)
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:186:4: table ^ LPAREN ! columns RPAREN !
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_table_in_insertParams436);
			table52=table();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(table52.getTree(), root_0);
			LPAREN53=(Token)match(input,LPAREN,FOLLOW_LPAREN_in_insertParams439); 
			pushFollow(FOLLOW_columns_in_insertParams442);
			columns54=columns();
			state._fsp--;

			adaptor.addChild(root_0, columns54.getTree());

			RPAREN55=(Token)match(input,RPAREN,FOLLOW_RPAREN_in_insertParams444); 
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:189:1: table : IDENT ;
	public final SQLParser.table_return table() throws RecognitionException {
		SQLParser.table_return retval = new SQLParser.table_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT56=null;

		CommonTree IDENT56_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:190:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:190:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT56=(Token)match(input,IDENT,FOLLOW_IDENT_in_table457); 
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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:202:1: onTable : IDENT ;
	public final SQLParser.onTable_return onTable() throws RecognitionException {
		SQLParser.onTable_return retval = new SQLParser.onTable_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT57=null;

		CommonTree IDENT57_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:203:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:203:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT57=(Token)match(input,IDENT,FOLLOW_IDENT_in_onTable474); 
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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:212:1: createTable : IDENT ;
	public final SQLParser.createTable_return createTable() throws RecognitionException {
		SQLParser.createTable_return retval = new SQLParser.createTable_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT58=null;

		CommonTree IDENT58_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:213:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:213:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT58=(Token)match(input,IDENT,FOLLOW_IDENT_in_createTable490); 
			IDENT58_tree = (CommonTree)adaptor.create(IDENT58);
			adaptor.addChild(root_0, IDENT58_tree);


						table1 = storageManager.getTable((IDENT58!=null?IDENT58.getText():null));
						if(table1 != null)
						{
							throw new ValidationException("Table with name '" + (IDENT58!=null?IDENT58.getText():null) + "' already exists.");
						}
						System.out.println(table1);
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:224:1: columnConstraints : columnConstraint ( COMMA ! columnConstraint )* ;
	public final SQLParser.columnConstraints_return columnConstraints() throws RecognitionException {
		SQLParser.columnConstraints_return retval = new SQLParser.columnConstraints_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA60=null;
		ParserRuleReturnScope columnConstraint59 =null;
		ParserRuleReturnScope columnConstraint61 =null;

		CommonTree COMMA60_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:225:2: ( columnConstraint ( COMMA ! columnConstraint )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:225:4: columnConstraint ( COMMA ! columnConstraint )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_columnConstraint_in_columnConstraints506);
			columnConstraint59=columnConstraint();
			state._fsp--;

			adaptor.addChild(root_0, columnConstraint59.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:225:21: ( COMMA ! columnConstraint )*
			loop8:
			while (true) {
				int alt8=2;
				int LA8_0 = input.LA(1);
				if ( (LA8_0==COMMA) ) {
					alt8=1;
				}

				switch (alt8) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:225:22: COMMA ! columnConstraint
					{
					COMMA60=(Token)match(input,COMMA,FOLLOW_COMMA_in_columnConstraints509); 
					pushFollow(FOLLOW_columnConstraint_in_columnConstraints512);
					columnConstraint61=columnConstraint();
					state._fsp--;

					adaptor.addChild(root_0, columnConstraint61.getTree());

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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:228:1: columnConstraint : column dataType ( constraint )? ;
	public final SQLParser.columnConstraint_return columnConstraint() throws RecognitionException {
		SQLParser.columnConstraint_return retval = new SQLParser.columnConstraint_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope column62 =null;
		ParserRuleReturnScope dataType63 =null;
		ParserRuleReturnScope constraint64 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:229:2: ( column dataType ( constraint )? )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:229:4: column dataType ( constraint )?
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_columnConstraint525);
			column62=column();
			state._fsp--;

			adaptor.addChild(root_0, column62.getTree());

			pushFollow(FOLLOW_dataType_in_columnConstraint527);
			dataType63=dataType();
			state._fsp--;

			adaptor.addChild(root_0, dataType63.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:229:20: ( constraint )?
			int alt9=2;
			int LA9_0 = input.LA(1);
			if ( (LA9_0==FOREIGN_KEY) ) {
				alt9=1;
			}
			switch (alt9) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:229:20: constraint
					{
					pushFollow(FOLLOW_constraint_in_columnConstraint529);
					constraint64=constraint();
					state._fsp--;

					adaptor.addChild(root_0, constraint64.getTree());

					}
					break;

			}

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:232:1: dataType : ( 'int' | 'varchar(10000)' );
	public final SQLParser.dataType_return dataType() throws RecognitionException {
		SQLParser.dataType_return retval = new SQLParser.dataType_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set65=null;

		CommonTree set65_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:233:2: ( 'int' | 'varchar(10000)' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set65=input.LT(1);
			if ( (input.LA(1) >= 42 && input.LA(1) <= 43) ) {
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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:237:1: constraint : FOREIGN_KEY ;
	public final SQLParser.constraint_return constraint() throws RecognitionException {
		SQLParser.constraint_return retval = new SQLParser.constraint_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token FOREIGN_KEY66=null;

		CommonTree FOREIGN_KEY66_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:238:2: ( FOREIGN_KEY )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:238:4: FOREIGN_KEY
			{
			root_0 = (CommonTree)adaptor.nil();


			FOREIGN_KEY66=(Token)match(input,FOREIGN_KEY,FOLLOW_FOREIGN_KEY_in_constraint558); 
			FOREIGN_KEY66_tree = (CommonTree)adaptor.create(FOREIGN_KEY66);
			adaptor.addChild(root_0, FOREIGN_KEY66_tree);

			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:241:1: columns : ( column ( COMMA ! column )* ) ;
	public final SQLParser.columns_return columns() throws RecognitionException {
		SQLParser.columns_return retval = new SQLParser.columns_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA68=null;
		ParserRuleReturnScope column67 =null;
		ParserRuleReturnScope column69 =null;

		CommonTree COMMA68_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:2: ( ( column ( COMMA ! column )* ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:4: ( column ( COMMA ! column )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:4: ( column ( COMMA ! column )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:5: column ( COMMA ! column )*
			{
			pushFollow(FOLLOW_column_in_columns570);
			column67=column();
			state._fsp--;

			adaptor.addChild(root_0, column67.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:12: ( COMMA ! column )*
			loop10:
			while (true) {
				int alt10=2;
				int LA10_0 = input.LA(1);
				if ( (LA10_0==COMMA) ) {
					alt10=1;
				}

				switch (alt10) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:242:13: COMMA ! column
					{
					COMMA68=(Token)match(input,COMMA,FOLLOW_COMMA_in_columns573); 
					pushFollow(FOLLOW_column_in_columns576);
					column69=column();
					state._fsp--;

					adaptor.addChild(root_0, column69.getTree());

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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:246:1: column : IDENT ;
	public final SQLParser.column_return column() throws RecognitionException {
		SQLParser.column_return retval = new SQLParser.column_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token IDENT70=null;

		CommonTree IDENT70_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:247:2: ( IDENT )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:247:4: IDENT
			{
			root_0 = (CommonTree)adaptor.nil();


			IDENT70=(Token)match(input,IDENT,FOLLOW_IDENT_in_column591); 
			IDENT70_tree = (CommonTree)adaptor.create(IDENT70);
			adaptor.addChild(root_0, IDENT70_tree);


						numCols++;
						table1Attributes.add(new Attribute((IDENT70!=null?IDENT70.getText():null)));
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:256:1: value : ( STRING_LITERAL | INTEGER );
	public final SQLParser.value_return value() throws RecognitionException {
		SQLParser.value_return retval = new SQLParser.value_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token STRING_LITERAL71=null;
		Token INTEGER72=null;

		CommonTree STRING_LITERAL71_tree=null;
		CommonTree INTEGER72_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:257:2: ( STRING_LITERAL | INTEGER )
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
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:257:4: STRING_LITERAL
					{
					root_0 = (CommonTree)adaptor.nil();


					STRING_LITERAL71=(Token)match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_value608); 
					STRING_LITERAL71_tree = (CommonTree)adaptor.create(STRING_LITERAL71);
					adaptor.addChild(root_0, STRING_LITERAL71_tree);


								insertVals.add((STRING_LITERAL71!=null?STRING_LITERAL71.getText():null).substring(1, (STRING_LITERAL71!=null?STRING_LITERAL71.getText():null).length()-1));
								numVals++;
							
					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:262:5: INTEGER
					{
					root_0 = (CommonTree)adaptor.nil();


					INTEGER72=(Token)match(input,INTEGER,FOLLOW_INTEGER_in_value618); 
					INTEGER72_tree = (CommonTree)adaptor.create(INTEGER72);
					adaptor.addChild(root_0, INTEGER72_tree);


								insertVals.add(Integer.parseInt((INTEGER72!=null?INTEGER72.getText():null)));
								numVals++;
							
					}
					break;

			}
			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:269:1: values : ( value ( COMMA ! value )* ) ;
	public final SQLParser.values_return values() throws RecognitionException {
		SQLParser.values_return retval = new SQLParser.values_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA74=null;
		ParserRuleReturnScope value73 =null;
		ParserRuleReturnScope value75 =null;

		CommonTree COMMA74_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:270:2: ( ( value ( COMMA ! value )* ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:270:4: ( value ( COMMA ! value )* )
			{
			root_0 = (CommonTree)adaptor.nil();


			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:270:4: ( value ( COMMA ! value )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:270:5: value ( COMMA ! value )*
			{
			pushFollow(FOLLOW_value_in_values635);
			value73=value();
			state._fsp--;

			adaptor.addChild(root_0, value73.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:270:11: ( COMMA ! value )*
			loop12:
			while (true) {
				int alt12=2;
				int LA12_0 = input.LA(1);
				if ( (LA12_0==COMMA) ) {
					alt12=1;
				}

				switch (alt12) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:270:12: COMMA ! value
					{
					COMMA74=(Token)match(input,COMMA,FOLLOW_COMMA_in_values638); 
					pushFollow(FOLLOW_value_in_values641);
					value75=value();
					state._fsp--;

					adaptor.addChild(root_0, value75.getTree());

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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:284:1: order : ( ASC | DESC );
	public final SQLParser.order_return order() throws RecognitionException {
		SQLParser.order_return retval = new SQLParser.order_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set76=null;

		CommonTree set76_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:285:2: ( ASC | DESC )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set76=input.LT(1);
			if ( input.LA(1)==ASC||input.LA(1)==DESC ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set76));
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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:289:1: assignments : assignment ( COMMA ! assignment )* ;
	public final SQLParser.assignments_return assignments() throws RecognitionException {
		SQLParser.assignments_return retval = new SQLParser.assignments_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token COMMA78=null;
		ParserRuleReturnScope assignment77 =null;
		ParserRuleReturnScope assignment79 =null;

		CommonTree COMMA78_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:290:2: ( assignment ( COMMA ! assignment )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:290:4: assignment ( COMMA ! assignment )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_assignment_in_assignments677);
			assignment77=assignment();
			state._fsp--;

			adaptor.addChild(root_0, assignment77.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:290:15: ( COMMA ! assignment )*
			loop13:
			while (true) {
				int alt13=2;
				int LA13_0 = input.LA(1);
				if ( (LA13_0==COMMA) ) {
					alt13=1;
				}

				switch (alt13) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:290:16: COMMA ! assignment
					{
					COMMA78=(Token)match(input,COMMA,FOLLOW_COMMA_in_assignments680); 
					pushFollow(FOLLOW_assignment_in_assignments683);
					assignment79=assignment();
					state._fsp--;

					adaptor.addChild(root_0, assignment79.getTree());

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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:293:1: assignment : column EQUAL ^ value ;
	public final SQLParser.assignment_return assignment() throws RecognitionException {
		SQLParser.assignment_return retval = new SQLParser.assignment_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token EQUAL81=null;
		ParserRuleReturnScope column80 =null;
		ParserRuleReturnScope value82 =null;

		CommonTree EQUAL81_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:294:2: ( column EQUAL ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:294:4: column EQUAL ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_assignment697);
			column80=column();
			state._fsp--;

			adaptor.addChild(root_0, column80.getTree());

			EQUAL81=(Token)match(input,EQUAL,FOLLOW_EQUAL_in_assignment699); 
			EQUAL81_tree = (CommonTree)adaptor.create(EQUAL81);
			root_0 = (CommonTree)adaptor.becomeRoot(EQUAL81_tree, root_0);

			pushFollow(FOLLOW_value_in_assignment702);
			value82=value();
			state._fsp--;

			adaptor.addChild(root_0, value82.getTree());


						validateAttrVals(table1);
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:301:1: searchConditions : searchCondition ( logicalOperator ^ searchCondition )* ;
	public final SQLParser.searchConditions_return searchConditions() throws RecognitionException {
		SQLParser.searchConditions_return retval = new SQLParser.searchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope searchCondition83 =null;
		ParserRuleReturnScope logicalOperator84 =null;
		ParserRuleReturnScope searchCondition85 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:302:2: ( searchCondition ( logicalOperator ^ searchCondition )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:302:4: searchCondition ( logicalOperator ^ searchCondition )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_searchCondition_in_searchConditions719);
			searchCondition83=searchCondition();
			state._fsp--;

			adaptor.addChild(root_0, searchCondition83.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:302:20: ( logicalOperator ^ searchCondition )*
			loop14:
			while (true) {
				int alt14=2;
				int LA14_0 = input.LA(1);
				if ( (LA14_0==AND||LA14_0==OR) ) {
					alt14=1;
				}

				switch (alt14) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:302:21: logicalOperator ^ searchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_searchConditions722);
					logicalOperator84=logicalOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(logicalOperator84.getTree(), root_0);
					pushFollow(FOLLOW_searchCondition_in_searchConditions725);
					searchCondition85=searchCondition();
					state._fsp--;

					adaptor.addChild(root_0, searchCondition85.getTree());

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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:305:1: searchCondition : column comparisonOperator ^ value ;
	public final SQLParser.searchCondition_return searchCondition() throws RecognitionException {
		SQLParser.searchCondition_return retval = new SQLParser.searchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope column86 =null;
		ParserRuleReturnScope comparisonOperator87 =null;
		ParserRuleReturnScope value88 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:306:2: ( column comparisonOperator ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:306:4: column comparisonOperator ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_column_in_searchCondition739);
			column86=column();
			state._fsp--;

			adaptor.addChild(root_0, column86.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_searchCondition741);
			comparisonOperator87=comparisonOperator();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(comparisonOperator87.getTree(), root_0);
			pushFollow(FOLLOW_value_in_searchCondition744);
			value88=value();
			state._fsp--;

			adaptor.addChild(root_0, value88.getTree());


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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:326:1: onSearchConditions : onSearchCondition ( logicalOperator ^ onSearchCondition )* ;
	public final SQLParser.onSearchConditions_return onSearchConditions() throws RecognitionException {
		SQLParser.onSearchConditions_return retval = new SQLParser.onSearchConditions_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		ParserRuleReturnScope onSearchCondition89 =null;
		ParserRuleReturnScope logicalOperator90 =null;
		ParserRuleReturnScope onSearchCondition91 =null;


		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:327:2: ( onSearchCondition ( logicalOperator ^ onSearchCondition )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:327:4: onSearchCondition ( logicalOperator ^ onSearchCondition )*
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_onSearchCondition_in_onSearchConditions761);
			onSearchCondition89=onSearchCondition();
			state._fsp--;

			adaptor.addChild(root_0, onSearchCondition89.getTree());

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:327:22: ( logicalOperator ^ onSearchCondition )*
			loop15:
			while (true) {
				int alt15=2;
				int LA15_0 = input.LA(1);
				if ( (LA15_0==AND||LA15_0==OR) ) {
					alt15=1;
				}

				switch (alt15) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:327:23: logicalOperator ^ onSearchCondition
					{
					pushFollow(FOLLOW_logicalOperator_in_onSearchConditions764);
					logicalOperator90=logicalOperator();
					state._fsp--;

					root_0 = (CommonTree)adaptor.becomeRoot(logicalOperator90.getTree(), root_0);
					pushFollow(FOLLOW_onSearchCondition_in_onSearchConditions767);
					onSearchCondition91=onSearchCondition();
					state._fsp--;

					adaptor.addChild(root_0, onSearchCondition91.getTree());

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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:330:1: onSearchCondition : onTable DOT ! column comparisonOperator ^ value ;
	public final SQLParser.onSearchCondition_return onSearchCondition() throws RecognitionException {
		SQLParser.onSearchCondition_return retval = new SQLParser.onSearchCondition_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token DOT93=null;
		ParserRuleReturnScope onTable92 =null;
		ParserRuleReturnScope column94 =null;
		ParserRuleReturnScope comparisonOperator95 =null;
		ParserRuleReturnScope value96 =null;

		CommonTree DOT93_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:331:2: ( onTable DOT ! column comparisonOperator ^ value )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:331:4: onTable DOT ! column comparisonOperator ^ value
			{
			root_0 = (CommonTree)adaptor.nil();


			pushFollow(FOLLOW_onTable_in_onSearchCondition780);
			onTable92=onTable();
			state._fsp--;

			adaptor.addChild(root_0, onTable92.getTree());

			DOT93=(Token)match(input,DOT,FOLLOW_DOT_in_onSearchCondition782); 
			pushFollow(FOLLOW_column_in_onSearchCondition784);
			column94=column();
			state._fsp--;

			adaptor.addChild(root_0, column94.getTree());

			pushFollow(FOLLOW_comparisonOperator_in_onSearchCondition786);
			comparisonOperator95=comparisonOperator();
			state._fsp--;

			root_0 = (CommonTree)adaptor.becomeRoot(comparisonOperator95.getTree(), root_0);
			pushFollow(FOLLOW_value_in_onSearchCondition789);
			value96=value();
			state._fsp--;

			adaptor.addChild(root_0, value96.getTree());


						Object tmp;
						attrValidator.validate(new Attribute[]{new Attribute((column94!=null?input.toString(column94.start,column94.stop):null))}, storageManager.getTable((onTable92!=null?input.toString(onTable92.start,onTable92.stop):null)));
						if((value96!=null?input.toString(value96.start,value96.stop):null).startsWith("'") && (value96!=null?input.toString(value96.start,value96.stop):null).endsWith("'"))
						{
							tmp = (value96!=null?input.toString(value96.start,value96.stop):null).substring(1, (value96!=null?input.toString(value96.start,value96.stop):null).length()-1);
						}
						else
						{
							tmp = Integer.parseInt((value96!=null?input.toString(value96.start,value96.stop):null));
						}
						
						attrValidator.attributeTypeCheck(storageManager.getTable((onTable92!=null?input.toString(onTable92.start,onTable92.stop):null)).getDescription().getAttribute((column94!=null?input.toString(column94.start,column94.stop):null)), tmp);
					
			}

			retval.stop = input.LT(-1);

			retval.tree = (CommonTree)adaptor.rulePostProcessing(root_0);
			adaptor.setTokenBoundaries(retval.tree, retval.start, retval.stop);

		}

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:354:1: comparisonOperator : ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN );
	public final SQLParser.comparisonOperator_return comparisonOperator() throws RecognitionException {
		SQLParser.comparisonOperator_return retval = new SQLParser.comparisonOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set97=null;

		CommonTree set97_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:355:2: ( EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set97=input.LT(1);
			if ( input.LA(1)==EQUAL||(input.LA(1) >= GREATER_THAN && input.LA(1) <= GREATER_THAN_EQUAL)||(input.LA(1) >= LESS_THAN && input.LA(1) <= LESS_THAN_EQUAL)||input.LA(1)==NOT_EQUAL ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set97));
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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:363:1: logicalOperator : ( AND | OR );
	public final SQLParser.logicalOperator_return logicalOperator() throws RecognitionException {
		SQLParser.logicalOperator_return retval = new SQLParser.logicalOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set98=null;

		CommonTree set98_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:364:2: ( AND | OR )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set98=input.LT(1);
			if ( input.LA(1)==AND||input.LA(1)==OR ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set98));
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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:368:1: joinOperator : ( INNER_JOIN | OUTER_JOIN | LEFT_JOIN | RIGHT_JOIN | JOIN );
	public final SQLParser.joinOperator_return joinOperator() throws RecognitionException {
		SQLParser.joinOperator_return retval = new SQLParser.joinOperator_return();
		retval.start = input.LT(1);

		CommonTree root_0 = null;

		Token set99=null;

		CommonTree set99_tree=null;

		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:369:2: ( INNER_JOIN | OUTER_JOIN | LEFT_JOIN | RIGHT_JOIN | JOIN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			root_0 = (CommonTree)adaptor.nil();


			set99=input.LT(1);
			if ( input.LA(1)==INNER_JOIN||(input.LA(1) >= JOIN && input.LA(1) <= LEFT_JOIN)||(input.LA(1) >= OUTER_JOIN && input.LA(1) <= RIGHT_JOIN) ) {
				input.consume();
				adaptor.addChild(root_0, (CommonTree)adaptor.create(set99));
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

		    catch (Exception e) {
		        throw new RuntimeException(e.getMessage());
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
	public static final BitSet FOLLOW_EOF_in_statement106 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_createClause_in_create120 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAREN_in_create123 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_columnConstraints_in_create126 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_RPAREN_in_create128 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_SEMI_in_create131 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_selectClause_in_select144 = new BitSet(new long[]{0x0000000000004000L});
	public static final BitSet FOLLOW_fromClause_in_select146 = new BitSet(new long[]{0x0000010850000000L});
	public static final BitSet FOLLOW_onClause_in_select149 = new BitSet(new long[]{0x0000010840000000L});
	public static final BitSet FOLLOW_whereClause_in_select154 = new BitSet(new long[]{0x0000000840000000L});
	public static final BitSet FOLLOW_orderByClause_in_select159 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_SEMI_in_select163 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_insertClause_in_insert176 = new BitSet(new long[]{0x0000008000000000L});
	public static final BitSet FOLLOW_valuesClause_in_insert178 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_SEMI_in_insert180 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_updateClause_in_update193 = new BitSet(new long[]{0x0000001000000000L});
	public static final BitSet FOLLOW_setClause_in_update195 = new BitSet(new long[]{0x0000010000000000L});
	public static final BitSet FOLLOW_whereClause_in_update197 = new BitSet(new long[]{0x0000000800000000L});
	public static final BitSet FOLLOW_SEMI_in_update199 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_CREATE_TABLE_in_createClause222 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_createTable_in_createClause225 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SELECT_in_selectClause236 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_columns_in_selectClause239 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INSERT_INTO_in_insertClause251 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_insertParams_in_insertClause254 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_UPDATE_in_updateClause266 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_table_in_updateClause269 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FROM_in_fromClause281 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_tableClause_in_fromClause284 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_tableClause297 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_joinClause_in_tableClause302 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_joinClause314 = new BitSet(new long[]{0x0000000180640000L});
	public static final BitSet FOLLOW_joinOperator_in_joinClause317 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_table_in_joinClause320 = new BitSet(new long[]{0x0000000180640002L});
	public static final BitSet FOLLOW_ON_in_onClause343 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_onSearchConditions_in_onClause346 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_WHERE_in_whereClause358 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_searchConditions_in_whereClause361 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_ORDER_BY_in_orderByClause373 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_column_in_orderByClause376 = new BitSet(new long[]{0x0000000000000222L});
	public static final BitSet FOLLOW_order_in_orderByClause379 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_VALUES_in_valuesClause393 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAREN_in_valuesClause396 = new BitSet(new long[]{0x0000002000100000L});
	public static final BitSet FOLLOW_values_in_valuesClause399 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_RPAREN_in_valuesClause401 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_SET_in_setClause413 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_assignments_in_setClause416 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_table_in_insertParams436 = new BitSet(new long[]{0x0000000004000000L});
	public static final BitSet FOLLOW_LPAREN_in_insertParams439 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_columns_in_insertParams442 = new BitSet(new long[]{0x0000000200000000L});
	public static final BitSet FOLLOW_RPAREN_in_insertParams444 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_table457 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_onTable474 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_IDENT_in_createTable490 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_columnConstraint_in_columnConstraints506 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_columnConstraints509 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_columnConstraint_in_columnConstraints512 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_column_in_columnConstraint525 = new BitSet(new long[]{0x00000C0000000000L});
	public static final BitSet FOLLOW_dataType_in_columnConstraint527 = new BitSet(new long[]{0x0000000000002002L});
	public static final BitSet FOLLOW_constraint_in_columnConstraint529 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_FOREIGN_KEY_in_constraint558 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_column_in_columns570 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_columns573 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_column_in_columns576 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_IDENT_in_column591 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_STRING_LITERAL_in_value608 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_INTEGER_in_value618 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_value_in_values635 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_values638 = new BitSet(new long[]{0x0000002000100000L});
	public static final BitSet FOLLOW_value_in_values641 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_assignment_in_assignments677 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_COMMA_in_assignments680 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_assignment_in_assignments683 = new BitSet(new long[]{0x0000000000000042L});
	public static final BitSet FOLLOW_column_in_assignment697 = new BitSet(new long[]{0x0000000000001000L});
	public static final BitSet FOLLOW_EQUAL_in_assignment699 = new BitSet(new long[]{0x0000002000100000L});
	public static final BitSet FOLLOW_value_in_assignment702 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions719 = new BitSet(new long[]{0x0000000020000012L});
	public static final BitSet FOLLOW_logicalOperator_in_searchConditions722 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_searchCondition_in_searchConditions725 = new BitSet(new long[]{0x0000000020000012L});
	public static final BitSet FOLLOW_column_in_searchCondition739 = new BitSet(new long[]{0x0000000009819000L});
	public static final BitSet FOLLOW_comparisonOperator_in_searchCondition741 = new BitSet(new long[]{0x0000002000100000L});
	public static final BitSet FOLLOW_value_in_searchCondition744 = new BitSet(new long[]{0x0000000000000002L});
	public static final BitSet FOLLOW_onSearchCondition_in_onSearchConditions761 = new BitSet(new long[]{0x0000000020000012L});
	public static final BitSet FOLLOW_logicalOperator_in_onSearchConditions764 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_onSearchCondition_in_onSearchConditions767 = new BitSet(new long[]{0x0000000020000012L});
	public static final BitSet FOLLOW_onTable_in_onSearchCondition780 = new BitSet(new long[]{0x0000000000000800L});
	public static final BitSet FOLLOW_DOT_in_onSearchCondition782 = new BitSet(new long[]{0x0000000000020000L});
	public static final BitSet FOLLOW_column_in_onSearchCondition784 = new BitSet(new long[]{0x0000000009819000L});
	public static final BitSet FOLLOW_comparisonOperator_in_onSearchCondition786 = new BitSet(new long[]{0x0000002000100000L});
	public static final BitSet FOLLOW_value_in_onSearchCondition789 = new BitSet(new long[]{0x0000000000000002L});
}
