// $ANTLR 3.5 C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g 2013-04-24 04:02:28

///////////////////////////////////////////////////////////////////
//                                                               //
//   THIS IS A DERIVED FILE! MAKE ANY DESIRED CHANGES IN SQL.g   //
//                                                               //
///////////////////////////////////////////////////////////////////

package gt.cs4420.relationaldb.database.query;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")  
public class SQLLexer extends Lexer {
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

		@Override
	    public void reportError(RecognitionException e) {
	        throw new RuntimeException(e.getMessage());
	    }



	// delegates
	// delegators
	public Lexer[] getDelegates() {
		return new Lexer[] {};
	}

	public SQLLexer() {} 
	public SQLLexer(CharStream input) {
		this(input, new RecognizerSharedState());
	}
	public SQLLexer(CharStream input, RecognizerSharedState state) {
		super(input,state);
	}
	@Override public String getGrammarFileName() { return "C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g"; }

	// $ANTLR start "T__42"
	public final void mT__42() throws RecognitionException {
		try {
			int _type = T__42;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:24:7: ( 'int' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:24:9: 'int'
			{
			match("int"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__42"

	// $ANTLR start "T__43"
	public final void mT__43() throws RecognitionException {
		try {
			int _type = T__43;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:25:7: ( 'varchar(10000)' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:25:9: 'varchar(10000)'
			{
			match("varchar(10000)"); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "T__43"

	// $ANTLR start "CREATE_TABLE"
	public final void mCREATE_TABLE() throws RecognitionException {
		try {
			int _type = CREATE_TABLE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:381:14: ( ( 'c' | 'C' ) ( 'r' | 'R' ) ( 'e' | 'E' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'e | E' ) ' ' ( 't' | 'T' ) ( 'a' | 'A' ) ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'e' | 'E' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:381:16: ( 'c' | 'C' ) ( 'r' | 'R' ) ( 'e' | 'E' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'e | E' ) ' ' ( 't' | 'T' ) ( 'a' | 'A' ) ( 'b' | 'B' ) ( 'l' | 'L' ) ( 'e' | 'E' )
			{
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:381:71: ( 'e | E' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:381:72: 'e | E'
			{
			match("e | E"); 

			}

			match(' '); 
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "CREATE_TABLE"

	// $ANTLR start "SELECT"
	public final void mSELECT() throws RecognitionException {
		try {
			int _type = SELECT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:382:8: ( ( 's' | 'S' ) ( 'e' | 'E' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'c' | 'C' ) ( 't' | 'T' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:382:10: ( 's' | 'S' ) ( 'e' | 'E' ) ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'c' | 'C' ) ( 't' | 'T' )
			{
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SELECT"

	// $ANTLR start "FROM"
	public final void mFROM() throws RecognitionException {
		try {
			int _type = FROM;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:383:6: ( ( 'f' | 'F' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'm' | 'M' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:383:8: ( 'f' | 'F' ) ( 'r' | 'R' ) ( 'o' | 'O' ) ( 'm' | 'M' )
			{
			if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='M'||input.LA(1)=='m' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FROM"

	// $ANTLR start "WHERE"
	public final void mWHERE() throws RecognitionException {
		try {
			int _type = WHERE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:384:7: ( ( 'w' | 'W' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'e' | 'E' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:384:9: ( 'w' | 'W' ) ( 'h' | 'H' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 'e' | 'E' )
			{
			if ( input.LA(1)=='W'||input.LA(1)=='w' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WHERE"

	// $ANTLR start "ORDER_BY"
	public final void mORDER_BY() throws RecognitionException {
		try {
			int _type = ORDER_BY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:385:10: ( ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ' ' ( 'b' | 'B' ) ( 'y' | 'Y' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:385:12: ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'd' | 'D' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ' ' ( 'b' | 'B' ) ( 'y' | 'Y' )
			{
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			match(' '); 
			if ( input.LA(1)=='B'||input.LA(1)=='b' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ORDER_BY"

	// $ANTLR start "INSERT_INTO"
	public final void mINSERT_INTO() throws RecognitionException {
		try {
			int _type = INSERT_INTO;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:386:13: ( ( 'i' | 'I' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 't' | 'T' ) ' ' ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'o' | 'O' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:386:15: ( 'i' | 'I' ) ( 'n' | 'N' ) ( 's' | 'S' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( 't' | 'T' ) ' ' ( 'i' | 'I' ) ( 'n' | 'N' ) ( 't' | 'T' ) ( 'o' | 'O' )
			{
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			match(' '); 
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INSERT_INTO"

	// $ANTLR start "VALUES"
	public final void mVALUES() throws RecognitionException {
		try {
			int _type = VALUES;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:387:8: ( ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'u' | 'U' ) ( 'e' | 'E' ) ( 's' | 'S' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:387:10: ( 'v' | 'V' ) ( 'a' | 'A' ) ( 'l' | 'L' ) ( 'u' | 'U' ) ( 'e' | 'E' ) ( 's' | 'S' )
			{
			if ( input.LA(1)=='V'||input.LA(1)=='v' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "VALUES"

	// $ANTLR start "AND"
	public final void mAND() throws RecognitionException {
		try {
			int _type = AND;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:388:5: ( ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:388:7: ( 'a' | 'A' ) ( 'n' | 'N' ) ( 'd' | 'D' )
			{
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "AND"

	// $ANTLR start "OR"
	public final void mOR() throws RecognitionException {
		try {
			int _type = OR;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:389:4: ( ( 'o' | 'O' ) ( 'r' | 'R' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:389:6: ( 'o' | 'O' ) ( 'r' | 'R' )
			{
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OR"

	// $ANTLR start "UPDATE"
	public final void mUPDATE() throws RecognitionException {
		try {
			int _type = UPDATE;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:390:8: ( ( 'u' | 'U' ) ( 'p' | 'P' ) ( 'd' | 'D' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'e' | 'E' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:390:10: ( 'u' | 'U' ) ( 'p' | 'P' ) ( 'd' | 'D' ) ( 'a' | 'A' ) ( 't' | 'T' ) ( 'e' | 'E' )
			{
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='P'||input.LA(1)=='p' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "UPDATE"

	// $ANTLR start "SET"
	public final void mSET() throws RecognitionException {
		try {
			int _type = SET;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:391:5: ( ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:391:7: ( 's' | 'S' ) ( 'e' | 'E' ) ( 't' | 'T' )
			{
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SET"

	// $ANTLR start "ASC"
	public final void mASC() throws RecognitionException {
		try {
			int _type = ASC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:392:5: ( ( 'a' | 'A' ) ( 's' | 'S' ) ( 'c' | 'C' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:392:7: ( 'a' | 'A' ) ( 's' | 'S' ) ( 'c' | 'C' )
			{
			if ( input.LA(1)=='A'||input.LA(1)=='a' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='C'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ASC"

	// $ANTLR start "FOREIGN_KEY"
	public final void mFOREIGN_KEY() throws RecognitionException {
		try {
			int _type = FOREIGN_KEY;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:393:13: ( ( 'f' | 'F' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'e' | 'E' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'n' | 'N' ) ' ' ( 'k' | 'K' ) ( 'e' | 'E' ) ( 'y' | 'Y' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:393:15: ( 'f' | 'F' ) ( 'o' | 'O' ) ( 'r' | 'R' ) ( 'e' | 'E' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'n' | 'N' ) ' ' ( 'k' | 'K' ) ( 'e' | 'E' ) ( 'y' | 'Y' )
			{
			if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			match(' '); 
			if ( input.LA(1)=='K'||input.LA(1)=='k' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='Y'||input.LA(1)=='y' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "FOREIGN_KEY"

	// $ANTLR start "DESC"
	public final void mDESC() throws RecognitionException {
		try {
			int _type = DESC;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:394:5: ( ( 'd' | 'D' ) ( 'e' | 'E' ) ( 's' | 'S' ) ( 'c' | 'S' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:394:7: ( 'd' | 'D' ) ( 'e' | 'E' ) ( 's' | 'S' ) ( 'c' | 'S' )
			{
			if ( input.LA(1)=='D'||input.LA(1)=='d' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='S'||input.LA(1)=='s' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='S'||input.LA(1)=='c' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DESC"

	// $ANTLR start "JOIN"
	public final void mJOIN() throws RecognitionException {
		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:395:15: ( ( 'j' | 'J' ) ( 'o' | 'O' ) ( 'i' | 'I' ) ( 'n' | 'N' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:395:17: ( 'j' | 'J' ) ( 'o' | 'O' ) ( 'i' | 'I' ) ( 'n' | 'N' )
			{
			if ( input.LA(1)=='J'||input.LA(1)=='j' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "JOIN"

	// $ANTLR start "INNER_JOIN"
	public final void mINNER_JOIN() throws RecognitionException {
		try {
			int _type = INNER_JOIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:396:11: ( ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'n' | 'N' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( ' ' ) JOIN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:396:13: ( 'i' | 'I' ) ( 'n' | 'N' ) ( 'n' | 'N' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( ' ' ) JOIN
			{
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:396:68: ( ' ' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:396:69: ' '
			{
			match(' '); 
			}

			mJOIN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INNER_JOIN"

	// $ANTLR start "OUTER_JOIN"
	public final void mOUTER_JOIN() throws RecognitionException {
		try {
			int _type = OUTER_JOIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:397:11: ( ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( ' ' ) JOIN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:397:13: ( 'o' | 'O' ) ( 'u' | 'U' ) ( 't' | 'T' ) ( 'e' | 'E' ) ( 'r' | 'R' ) ( ' ' ) JOIN
			{
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='U'||input.LA(1)=='u' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:397:68: ( ' ' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:397:69: ' '
			{
			match(' '); 
			}

			mJOIN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "OUTER_JOIN"

	// $ANTLR start "LEFT_JOIN"
	public final void mLEFT_JOIN() throws RecognitionException {
		try {
			int _type = LEFT_JOIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:398:10: ( ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 't' | 'T' ) ( ' ' ) JOIN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:398:12: ( 'l' | 'L' ) ( 'e' | 'E' ) ( 'f' | 'F' ) ( 't' | 'T' ) ( ' ' ) JOIN
			{
			if ( input.LA(1)=='L'||input.LA(1)=='l' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='E'||input.LA(1)=='e' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='F'||input.LA(1)=='f' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:398:56: ( ' ' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:398:57: ' '
			{
			match(' '); 
			}

			mJOIN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LEFT_JOIN"

	// $ANTLR start "RIGHT_JOIN"
	public final void mRIGHT_JOIN() throws RecognitionException {
		try {
			int _type = RIGHT_JOIN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:399:11: ( ( 'r' | 'R' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'h' | 'H' ) ( 't' | 'T' ) ( ' ' ) JOIN )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:399:13: ( 'r' | 'R' ) ( 'i' | 'I' ) ( 'g' | 'G' ) ( 'h' | 'H' ) ( 't' | 'T' ) ( ' ' ) JOIN
			{
			if ( input.LA(1)=='R'||input.LA(1)=='r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='I'||input.LA(1)=='i' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='G'||input.LA(1)=='g' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='H'||input.LA(1)=='h' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='T'||input.LA(1)=='t' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:399:68: ( ' ' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:399:69: ' '
			{
			match(' '); 
			}

			mJOIN(); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RIGHT_JOIN"

	// $ANTLR start "ON"
	public final void mON() throws RecognitionException {
		try {
			int _type = ON;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:400:4: ( ( 'o' | 'O' ) ( 'n' | 'N' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:400:6: ( 'o' | 'O' ) ( 'n' | 'N' )
			{
			if ( input.LA(1)=='O'||input.LA(1)=='o' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			if ( input.LA(1)=='N'||input.LA(1)=='n' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "ON"

	// $ANTLR start "DOT"
	public final void mDOT() throws RecognitionException {
		try {
			int _type = DOT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:401:5: ( '.' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:401:7: '.'
			{
			match('.'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DOT"

	// $ANTLR start "LPAREN"
	public final void mLPAREN() throws RecognitionException {
		try {
			int _type = LPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:403:8: ( '(' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:403:10: '('
			{
			match('('); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LPAREN"

	// $ANTLR start "RPAREN"
	public final void mRPAREN() throws RecognitionException {
		try {
			int _type = RPAREN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:404:8: ( ')' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:404:10: ')'
			{
			match(')'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "RPAREN"

	// $ANTLR start "COMMA"
	public final void mCOMMA() throws RecognitionException {
		try {
			int _type = COMMA;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:405:7: ( ',' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:405:9: ','
			{
			match(','); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMA"

	// $ANTLR start "SEMI"
	public final void mSEMI() throws RecognitionException {
		try {
			int _type = SEMI;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:406:6: ( ';' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:406:8: ';'
			{
			match(';'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "SEMI"

	// $ANTLR start "EQUAL"
	public final void mEQUAL() throws RecognitionException {
		try {
			int _type = EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:408:7: ( '=' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:408:9: '='
			{
			match('='); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "EQUAL"

	// $ANTLR start "NOT_EQUAL"
	public final void mNOT_EQUAL() throws RecognitionException {
		try {
			int _type = NOT_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:409:11: ( ( '!=' | '<>' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:409:13: ( '!=' | '<>' )
			{
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:409:13: ( '!=' | '<>' )
			int alt1=2;
			int LA1_0 = input.LA(1);
			if ( (LA1_0=='!') ) {
				alt1=1;
			}
			else if ( (LA1_0=='<') ) {
				alt1=2;
			}

			else {
				NoViableAltException nvae =
					new NoViableAltException("", 1, 0, input);
				throw nvae;
			}

			switch (alt1) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:409:14: '!='
					{
					match("!="); 

					}
					break;
				case 2 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:409:21: '<>'
					{
					match("<>"); 

					}
					break;

			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "NOT_EQUAL"

	// $ANTLR start "LESS_THAN_EQUAL"
	public final void mLESS_THAN_EQUAL() throws RecognitionException {
		try {
			int _type = LESS_THAN_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:410:17: ( '<=' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:410:19: '<='
			{
			match("<="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS_THAN_EQUAL"

	// $ANTLR start "LESS_THAN"
	public final void mLESS_THAN() throws RecognitionException {
		try {
			int _type = LESS_THAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:411:11: ( '<' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:411:13: '<'
			{
			match('<'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LESS_THAN"

	// $ANTLR start "GREATER_THAN_EQUAL"
	public final void mGREATER_THAN_EQUAL() throws RecognitionException {
		try {
			int _type = GREATER_THAN_EQUAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:412:20: ( '>=' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:412:22: '>='
			{
			match(">="); 

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATER_THAN_EQUAL"

	// $ANTLR start "GREATER_THAN"
	public final void mGREATER_THAN() throws RecognitionException {
		try {
			int _type = GREATER_THAN;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:413:14: ( '>' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:413:16: '>'
			{
			match('>'); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "GREATER_THAN"

	// $ANTLR start "LETTER"
	public final void mLETTER() throws RecognitionException {
		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:415:17: ( ( 'a' .. 'z' | 'A' .. 'Z' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			if ( (input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "LETTER"

	// $ANTLR start "DIGIT"
	public final void mDIGIT() throws RecognitionException {
		try {
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:416:16: ( ( '0' .. '9' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
			{
			if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			}

		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "DIGIT"

	// $ANTLR start "IDENT"
	public final void mIDENT() throws RecognitionException {
		try {
			int _type = IDENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:417:7: ( LETTER ( LETTER | DIGIT )* )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:417:9: LETTER ( LETTER | DIGIT )*
			{
			mLETTER(); 

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:417:16: ( LETTER | DIGIT )*
			loop2:
			while (true) {
				int alt2=2;
				int LA2_0 = input.LA(1);
				if ( ((LA2_0 >= '0' && LA2_0 <= '9')||(LA2_0 >= 'A' && LA2_0 <= 'Z')||(LA2_0 >= 'a' && LA2_0 <= 'z')) ) {
					alt2=1;
				}

				switch (alt2) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9')||(input.LA(1) >= 'A' && input.LA(1) <= 'Z')||(input.LA(1) >= 'a' && input.LA(1) <= 'z') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					break loop2;
				}
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "IDENT"

	// $ANTLR start "INTEGER"
	public final void mINTEGER() throws RecognitionException {
		try {
			int _type = INTEGER;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:418:9: ( ( DIGIT )+ )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:418:11: ( DIGIT )+
			{
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:418:11: ( DIGIT )+
			int cnt3=0;
			loop3:
			while (true) {
				int alt3=2;
				int LA3_0 = input.LA(1);
				if ( ((LA3_0 >= '0' && LA3_0 <= '9')) ) {
					alt3=1;
				}

				switch (alt3) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
					{
					if ( (input.LA(1) >= '0' && input.LA(1) <= '9') ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt3 >= 1 ) break loop3;
					EarlyExitException eee = new EarlyExitException(3, input);
					throw eee;
				}
				cnt3++;
			}

			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "INTEGER"

	// $ANTLR start "STRING_LITERAL"
	public final void mSTRING_LITERAL() throws RecognitionException {
		try {
			int _type = STRING_LITERAL;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:419:16: ( '\\'' ( . )* '\\'' )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:419:18: '\\'' ( . )* '\\''
			{
			match('\''); 
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:419:23: ( . )*
			loop4:
			while (true) {
				int alt4=2;
				int LA4_0 = input.LA(1);
				if ( (LA4_0=='\'') ) {
					alt4=2;
				}
				else if ( ((LA4_0 >= '\u0000' && LA4_0 <= '&')||(LA4_0 >= '(' && LA4_0 <= '\uFFFF')) ) {
					alt4=1;
				}

				switch (alt4) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:419:23: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop4;
				}
			}

			match('\''); 
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "STRING_LITERAL"

	// $ANTLR start "COMMENT"
	public final void mCOMMENT() throws RecognitionException {
		try {
			int _type = COMMENT;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:422:9: ( '--' ( . )* ( '\\r' | '\\n' ) )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:422:11: '--' ( . )* ( '\\r' | '\\n' )
			{
			match("--"); 

			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:422:16: ( . )*
			loop5:
			while (true) {
				int alt5=2;
				int LA5_0 = input.LA(1);
				if ( (LA5_0=='\n'||LA5_0=='\r') ) {
					alt5=2;
				}
				else if ( ((LA5_0 >= '\u0000' && LA5_0 <= '\t')||(LA5_0 >= '\u000B' && LA5_0 <= '\f')||(LA5_0 >= '\u000E' && LA5_0 <= '\uFFFF')) ) {
					alt5=1;
				}

				switch (alt5) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:422:16: .
					{
					matchAny(); 
					}
					break;

				default :
					break loop5;
				}
			}

			if ( input.LA(1)=='\n'||input.LA(1)=='\r' ) {
				input.consume();
			}
			else {
				MismatchedSetException mse = new MismatchedSetException(null,input);
				recover(mse);
				throw mse;
			}
			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "COMMENT"

	// $ANTLR start "WS"
	public final void mWS() throws RecognitionException {
		try {
			int _type = WS;
			int _channel = DEFAULT_TOKEN_CHANNEL;
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:423:4: ( ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+ )
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:423:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
			{
			// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:423:6: ( ' ' | '\\t' | '\\n' | '\\r' | '\\f' )+
			int cnt6=0;
			loop6:
			while (true) {
				int alt6=2;
				int LA6_0 = input.LA(1);
				if ( ((LA6_0 >= '\t' && LA6_0 <= '\n')||(LA6_0 >= '\f' && LA6_0 <= '\r')||LA6_0==' ') ) {
					alt6=1;
				}

				switch (alt6) {
				case 1 :
					// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:
					{
					if ( (input.LA(1) >= '\t' && input.LA(1) <= '\n')||(input.LA(1) >= '\f' && input.LA(1) <= '\r')||input.LA(1)==' ' ) {
						input.consume();
					}
					else {
						MismatchedSetException mse = new MismatchedSetException(null,input);
						recover(mse);
						throw mse;
					}
					}
					break;

				default :
					if ( cnt6 >= 1 ) break loop6;
					EarlyExitException eee = new EarlyExitException(6, input);
					throw eee;
				}
				cnt6++;
			}

			_channel = HIDDEN;
			}

			state.type = _type;
			state.channel = _channel;
		}
		finally {
			// do for sure before leaving
		}
	}
	// $ANTLR end "WS"

	@Override
	public void mTokens() throws RecognitionException {
		// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:8: ( T__42 | T__43 | CREATE_TABLE | SELECT | FROM | WHERE | ORDER_BY | INSERT_INTO | VALUES | AND | OR | UPDATE | SET | ASC | FOREIGN_KEY | DESC | INNER_JOIN | OUTER_JOIN | LEFT_JOIN | RIGHT_JOIN | ON | DOT | LPAREN | RPAREN | COMMA | SEMI | EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN | IDENT | INTEGER | STRING_LITERAL | COMMENT | WS )
		int alt7=37;
		alt7 = dfa7.predict(input);
		switch (alt7) {
			case 1 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:10: T__42
				{
				mT__42(); 

				}
				break;
			case 2 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:16: T__43
				{
				mT__43(); 

				}
				break;
			case 3 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:22: CREATE_TABLE
				{
				mCREATE_TABLE(); 

				}
				break;
			case 4 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:35: SELECT
				{
				mSELECT(); 

				}
				break;
			case 5 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:42: FROM
				{
				mFROM(); 

				}
				break;
			case 6 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:47: WHERE
				{
				mWHERE(); 

				}
				break;
			case 7 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:53: ORDER_BY
				{
				mORDER_BY(); 

				}
				break;
			case 8 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:62: INSERT_INTO
				{
				mINSERT_INTO(); 

				}
				break;
			case 9 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:74: VALUES
				{
				mVALUES(); 

				}
				break;
			case 10 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:81: AND
				{
				mAND(); 

				}
				break;
			case 11 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:85: OR
				{
				mOR(); 

				}
				break;
			case 12 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:88: UPDATE
				{
				mUPDATE(); 

				}
				break;
			case 13 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:95: SET
				{
				mSET(); 

				}
				break;
			case 14 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:99: ASC
				{
				mASC(); 

				}
				break;
			case 15 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:103: FOREIGN_KEY
				{
				mFOREIGN_KEY(); 

				}
				break;
			case 16 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:115: DESC
				{
				mDESC(); 

				}
				break;
			case 17 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:120: INNER_JOIN
				{
				mINNER_JOIN(); 

				}
				break;
			case 18 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:131: OUTER_JOIN
				{
				mOUTER_JOIN(); 

				}
				break;
			case 19 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:142: LEFT_JOIN
				{
				mLEFT_JOIN(); 

				}
				break;
			case 20 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:152: RIGHT_JOIN
				{
				mRIGHT_JOIN(); 

				}
				break;
			case 21 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:163: ON
				{
				mON(); 

				}
				break;
			case 22 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:166: DOT
				{
				mDOT(); 

				}
				break;
			case 23 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:170: LPAREN
				{
				mLPAREN(); 

				}
				break;
			case 24 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:177: RPAREN
				{
				mRPAREN(); 

				}
				break;
			case 25 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:184: COMMA
				{
				mCOMMA(); 

				}
				break;
			case 26 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:190: SEMI
				{
				mSEMI(); 

				}
				break;
			case 27 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:195: EQUAL
				{
				mEQUAL(); 

				}
				break;
			case 28 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:201: NOT_EQUAL
				{
				mNOT_EQUAL(); 

				}
				break;
			case 29 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:211: LESS_THAN_EQUAL
				{
				mLESS_THAN_EQUAL(); 

				}
				break;
			case 30 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:227: LESS_THAN
				{
				mLESS_THAN(); 

				}
				break;
			case 31 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:237: GREATER_THAN_EQUAL
				{
				mGREATER_THAN_EQUAL(); 

				}
				break;
			case 32 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:256: GREATER_THAN
				{
				mGREATER_THAN(); 

				}
				break;
			case 33 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:269: IDENT
				{
				mIDENT(); 

				}
				break;
			case 34 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:275: INTEGER
				{
				mINTEGER(); 

				}
				break;
			case 35 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:283: STRING_LITERAL
				{
				mSTRING_LITERAL(); 

				}
				break;
			case 36 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:298: COMMENT
				{
				mCOMMENT(); 

				}
				break;
			case 37 :
				// C:\\Users\\Phil\\Documents\\GitHub\\CS4420\\src\\gt\\cs4420\\relationaldb\\database\\query\\SQL.g:1:306: WS
				{
				mWS(); 

				}
				break;

		}
	}


	protected DFA7 dfa7 = new DFA7(this);
	static final String DFA7_eotS =
		"\1\uffff\16\30\7\uffff\1\60\1\62\5\uffff\11\30\1\77\1\30\1\101\6\30\4"+
		"\uffff\1\110\6\30\1\117\4\30\1\uffff\1\30\1\uffff\1\125\1\126\4\30\1\uffff"+
		"\6\30\1\uffff\1\141\4\30\2\uffff\1\30\1\147\10\30\1\uffff\1\30\1\161\3"+
		"\30\2\uffff\2\30\1\uffff\1\30\1\170\1\30\1\172\1\30\3\uffff\1\174\2\uffff"+
		"\1\30\3\uffff\1\30\3\uffff";
	static final String DFA7_eofS =
		"\177\uffff";
	static final String DFA7_minS =
		"\1\11\1\116\1\101\1\122\1\105\1\117\1\110\2\116\1\101\1\116\1\120\2\105"+
		"\1\111\7\uffff\2\75\5\uffff\2\116\2\114\1\105\1\114\1\117\1\122\1\105"+
		"\1\60\1\124\1\60\1\104\1\103\1\104\1\123\1\106\1\107\4\uffff\1\60\2\105"+
		"\1\143\1\125\1\101\1\105\1\60\1\115\1\105\1\122\1\105\1\uffff\1\105\1"+
		"\uffff\2\60\1\101\1\123\1\124\1\110\1\uffff\2\122\1\150\1\105\1\124\1"+
		"\103\1\uffff\1\60\1\111\1\105\2\122\2\uffff\1\124\1\60\1\40\2\124\1\40"+
		"\1\141\1\123\1\145\1\124\1\uffff\1\107\1\60\2\40\1\105\2\uffff\2\40\1"+
		"\uffff\1\162\1\60\1\40\1\60\1\116\3\uffff\1\60\2\uffff\1\50\3\uffff\1"+
		"\40\3\uffff";
	static final String DFA7_maxS =
		"\1\172\1\156\1\141\1\162\1\145\1\162\1\150\1\165\1\156\1\141\1\163\1\160"+
		"\2\145\1\151\7\uffff\1\76\1\75\5\uffff\1\164\1\163\1\162\1\154\1\145\1"+
		"\164\1\157\1\162\1\145\1\172\1\164\1\172\1\144\1\143\1\144\1\163\1\146"+
		"\1\147\4\uffff\1\172\2\145\1\143\1\165\1\141\1\145\1\172\1\155\1\145\1"+
		"\162\1\145\1\uffff\1\145\1\uffff\2\172\1\141\1\143\1\164\1\150\1\uffff"+
		"\2\162\1\150\1\145\1\164\1\143\1\uffff\1\172\1\151\1\145\2\162\2\uffff"+
		"\1\164\1\172\1\40\2\164\1\40\1\141\1\163\1\145\1\164\1\uffff\1\147\1\172"+
		"\2\40\1\145\2\uffff\2\40\1\uffff\1\162\1\172\1\40\1\172\1\156\3\uffff"+
		"\1\172\2\uffff\1\50\3\uffff\1\40\3\uffff";
	static final String DFA7_acceptS =
		"\17\uffff\1\26\1\27\1\30\1\31\1\32\1\33\1\34\2\uffff\1\41\1\42\1\43\1"+
		"\44\1\45\22\uffff\1\35\1\36\1\37\1\40\14\uffff\1\13\1\uffff\1\25\6\uffff"+
		"\1\1\6\uffff\1\15\5\uffff\1\12\1\16\12\uffff\1\5\5\uffff\1\20\1\23\2\uffff"+
		"\1\21\5\uffff\1\6\1\7\1\22\1\uffff\1\24\1\10\1\uffff\1\11\1\3\1\4\1\uffff"+
		"\1\14\1\2\1\17";
	static final String DFA7_specialS =
		"\177\uffff}>";
	static final String[] DFA7_transitionS = {
			"\2\34\1\uffff\2\34\22\uffff\1\34\1\25\5\uffff\1\32\1\20\1\21\2\uffff"+
			"\1\22\1\33\1\17\1\uffff\12\31\1\uffff\1\23\1\26\1\24\1\27\2\uffff\1\12"+
			"\1\30\1\3\1\14\1\30\1\5\2\30\1\10\2\30\1\15\2\30\1\7\2\30\1\16\1\4\1"+
			"\30\1\13\1\11\1\6\3\30\6\uffff\1\12\1\30\1\3\1\14\1\30\1\5\2\30\1\1\2"+
			"\30\1\15\2\30\1\7\2\30\1\16\1\4\1\30\1\13\1\2\1\6\3\30",
			"\1\36\37\uffff\1\35",
			"\1\40\37\uffff\1\37",
			"\1\41\37\uffff\1\41",
			"\1\42\37\uffff\1\42",
			"\1\44\2\uffff\1\43\34\uffff\1\44\2\uffff\1\43",
			"\1\45\37\uffff\1\45",
			"\1\50\3\uffff\1\46\2\uffff\1\47\30\uffff\1\50\3\uffff\1\46\2\uffff\1"+
			"\47",
			"\1\36\37\uffff\1\36",
			"\1\40\37\uffff\1\40",
			"\1\51\4\uffff\1\52\32\uffff\1\51\4\uffff\1\52",
			"\1\53\37\uffff\1\53",
			"\1\54\37\uffff\1\54",
			"\1\55\37\uffff\1\55",
			"\1\56\37\uffff\1\56",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"\1\57\1\25",
			"\1\61",
			"",
			"",
			"",
			"",
			"",
			"\1\65\4\uffff\1\64\32\uffff\1\65\4\uffff\1\64\1\63",
			"\1\65\4\uffff\1\64\32\uffff\1\65\4\uffff\1\64",
			"\1\67\37\uffff\1\67\5\uffff\1\66",
			"\1\67\37\uffff\1\67",
			"\1\70\37\uffff\1\70",
			"\1\71\7\uffff\1\72\27\uffff\1\71\7\uffff\1\72",
			"\1\73\37\uffff\1\73",
			"\1\74\37\uffff\1\74",
			"\1\75\37\uffff\1\75",
			"\12\30\7\uffff\3\30\1\76\26\30\6\uffff\3\30\1\76\26\30",
			"\1\100\37\uffff\1\100",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"\1\102\37\uffff\1\102",
			"\1\103\37\uffff\1\103",
			"\1\104\37\uffff\1\104",
			"\1\105\37\uffff\1\105",
			"\1\106\37\uffff\1\106",
			"\1\107\37\uffff\1\107",
			"",
			"",
			"",
			"",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"\1\111\37\uffff\1\111",
			"\1\112\37\uffff\1\112",
			"\1\113",
			"\1\114\37\uffff\1\114",
			"\1\115\37\uffff\1\115",
			"\1\116\37\uffff\1\116",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"\1\120\37\uffff\1\120",
			"\1\121\37\uffff\1\121",
			"\1\122\37\uffff\1\122",
			"\1\123\37\uffff\1\123",
			"",
			"\1\124\37\uffff\1\124",
			"",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"\1\127\37\uffff\1\127",
			"\1\130\17\uffff\1\130",
			"\1\131\37\uffff\1\131",
			"\1\132\37\uffff\1\132",
			"",
			"\1\133\37\uffff\1\133",
			"\1\134\37\uffff\1\134",
			"\1\135",
			"\1\136\37\uffff\1\136",
			"\1\137\37\uffff\1\137",
			"\1\140\37\uffff\1\140",
			"",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"\1\142\37\uffff\1\142",
			"\1\143\37\uffff\1\143",
			"\1\144\37\uffff\1\144",
			"\1\145\37\uffff\1\145",
			"",
			"",
			"\1\146\37\uffff\1\146",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"\1\150",
			"\1\151\37\uffff\1\151",
			"\1\152\37\uffff\1\152",
			"\1\153",
			"\1\154",
			"\1\155\37\uffff\1\155",
			"\1\156",
			"\1\157\37\uffff\1\157",
			"",
			"\1\160\37\uffff\1\160",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"\1\162",
			"\1\163",
			"\1\164\37\uffff\1\164",
			"",
			"",
			"\1\165",
			"\1\166",
			"",
			"\1\167",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"\1\171",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"\1\173\37\uffff\1\173",
			"",
			"",
			"",
			"\12\30\7\uffff\32\30\6\uffff\32\30",
			"",
			"",
			"\1\175",
			"",
			"",
			"",
			"\1\176",
			"",
			"",
			""
	};

	static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
	static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
	static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
	static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
	static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
	static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
	static final short[][] DFA7_transition;

	static {
		int numStates = DFA7_transitionS.length;
		DFA7_transition = new short[numStates][];
		for (int i=0; i<numStates; i++) {
			DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
		}
	}

	protected class DFA7 extends DFA {

		public DFA7(BaseRecognizer recognizer) {
			this.recognizer = recognizer;
			this.decisionNumber = 7;
			this.eot = DFA7_eot;
			this.eof = DFA7_eof;
			this.min = DFA7_min;
			this.max = DFA7_max;
			this.accept = DFA7_accept;
			this.special = DFA7_special;
			this.transition = DFA7_transition;
		}
		@Override
		public String getDescription() {
			return "1:1: Tokens : ( T__42 | T__43 | CREATE_TABLE | SELECT | FROM | WHERE | ORDER_BY | INSERT_INTO | VALUES | AND | OR | UPDATE | SET | ASC | FOREIGN_KEY | DESC | INNER_JOIN | OUTER_JOIN | LEFT_JOIN | RIGHT_JOIN | ON | DOT | LPAREN | RPAREN | COMMA | SEMI | EQUAL | NOT_EQUAL | LESS_THAN_EQUAL | LESS_THAN | GREATER_THAN_EQUAL | GREATER_THAN | IDENT | INTEGER | STRING_LITERAL | COMMENT | WS );";
		}
	}

}
