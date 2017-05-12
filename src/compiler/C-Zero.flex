
import java_cup.runtime.*;


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

<YYINITIAL> { 
    {Number}        { return symbol(sym.NUMBER, new Integer(Integer.parseInt(yytext()))); }
    {Identifier}    { return symbol(sym.IDENT, yytext()); }
    "+"             { return symbol(sym.PLUS); }
    "-"             { return symbol(sym.MINUS); }
    "*"             { return symbol(sym.MUL); }
    "/"             { return symbol(sym.DIV); }
    "("             { return symbol(sym.LPAREN); }
    ")"             { return symbol(sym.RPAREN); }
    "{"             { return symbol(sym.LBRACES); }
    "}"             { return symbol(sym.RBRACES); }
    ";"             { return symbol(sym.SEMICOLON); }
    "="             { return symbol(sym.ASSIGN); }
    "<"             { return symbol(sym.LESS); }
    ">"             { return symbol(sym.GREATER); }
    "=="            { return symbol(sym.EQUAL); }
    "¡="            { return symbol(sym.UNEQUAL); }
    "&&"            { return symbol(sym.AND); }
    "||"            { return symbol(sym.OR); }
    "main"          { return symbol(sym.KEYWORD); }
    "if"            { return symbol(sym.KEYWORD); }
    "else"          { return symbol(sym.KEYWORD); }
    "while"         { return symbol(sym.KEYWORD); }
    "putw"          { return symbol(sym.KEYWORD); }
    "puts"          { return symbol(sym.KEYWORD); }
    "int"           { return symbol(sym.KEYWORD); }
    "break"         { return symbol(sym.KEYWORD); }

    {WhiteSpace} {}
}

.|\n            { throw new Error("Illegal character <" + yytext() + ">");}
