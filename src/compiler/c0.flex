package compiler;

import java_cup.runtime.Symbol;  
import java.lang.System;
import java.io.*;

%%
%full
%unicode
%cup
%line
%char

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
Letter         = [A-Za-z_]
String         = \"([\x20-\x21\x23-\xFE])*\"

%%

"+"             { return symbol(sym.PLUS); }
"-"             { return symbol(sym.MINUS); }
"*"             { return symbol(sym.MUL); }
"/"             { return symbol(sym.DIV); }
"("             { return symbol(sym.LPAREN); }
")"             { return symbol(sym.RPAREN); }
"{"             { return symbol(sym.LBRACE); }
"}"             { return symbol(sym.RBRACE); }
";"             { return symbol(sym.SEMICOLON); }
"="             { return symbol(sym.ASSIGN); }
">"             { return symbol(sym.GREATER); }
"<"             { return symbol(sym.LESS); }
"=="            { return symbol(sym.EQUAL); }
"!="            { return symbol(sym.UNEQUAL); }
"&&"            { return symbol(sym.AND); }
"||"            { return symbol(sym.OR); }
"main"          { return symbol(sym.MAIN); }
"if"            { return symbol(sym.IF); }
"else"          { return symbol(sym.ELSE); }
"while"         { return symbol(sym.WHILE); }
"putw"          { return symbol(sym.PUTW); }
"puts"          { return symbol(sym.PUTS); }
"int"           { return symbol(sym.INTWORD); }
"struct"        { return symbol(sym.STRUCT); }
"break"         { return symbol(sym.BREAK); }
{String}        { return symbol(sym.STRING, yytext()); }
{Letter}({Letter}|{Digit})*     { return symbol(sym.ID, yytext()); }
{Digit}+        { return symbol(sym.INT, yytext()); }

({WhiteSpace}|{LineTerminator}|{WhiteSpace})+   {  }

.            { throw new Error("Illegal character <" + yytext() + ">");}
