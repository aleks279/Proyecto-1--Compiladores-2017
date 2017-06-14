/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeGen;

/**
 *
 * @author Saul
 */
public class ERRORS {
    public static final String UNDECLARED_SYM = "The symbol has not been declared";
    public static final String BREAK_OUT_OF_PLACE = "Used a break outside of a while block";
    public static final String REPEATED_SYMBOL = "Symbol has already been declared";
    
    
    
    public static void report(String error, int line){
        System.out.println("ERROR in line: "+String.valueOf(line)+" -> "+error);
    }
}
