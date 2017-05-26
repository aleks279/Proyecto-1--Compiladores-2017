
import java_cup.runtime.*;

%%
%class Lexer
%unicode
%cup
%line
%column

%{
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }
    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]
WhiteSpace    = {LineTerminator} | [ \t\f]

Digit          = [0-9]
Number         = {Digit} {Digit}*
Letter         = [a-zA-Z]
Identifier     = {Letter} ({Letter}|{Digit})* 

%%

{Number}        { return symbol(sym.NUMBER, new Integer(Integer.parseInt(yytext()))); }
{Identifier}    { return symbol(sym.IDENT, yytext()); }
"??"             { return symbol(sym.QUOTE); }
"+"             { return symbol(sym.PLUS); }
"-"             { return symbol(sym.MINUS); }
"*"             { return symbol(sym.MUL); }
"/"             { return symbol(sym.DIV); }
"("             { return symbol(sym.LPAREN); }
")"             { return symbol(sym.RPAREN); }
"{"             { return symbol(sym.LBRACES); }
"{"             { return symbol(sym.LBRACES); }
"}"             { return symbol(sym.RBRACES); }
";"             { return symbol(sym.SEMICOLON); }
"="             { return symbol(sym.ASSIGN); }
">"             { return symbol(sym.GREATER); }
"<"             { return symbol(sym.LESS); }
"=="            { return symbol(sym.EQUAL); }
"¡="            { return symbol(sym.UNEQUAL); }
"&&"            { return symbol(sym.AND); }
"||"            { return symbol(sym.OR); }
"main"          { return symbol(sym.MAIN); }
"if"            { return symbol(sym.IF); }
"else"          { return symbol(sym.ELSE); }
"while"         { return symbol(sym.WHILE); }
"putw"          { return symbol(sym.PUTW); }
"puts"          { return symbol(sym.PUTS); }
"int"           { return symbol(sym.INT); }
"break"         { return symbol(sym.BREAK); }

{WhiteSpace} {}

.|\n            { throw new Error("Illegal character <" + yytext() + ">");}
