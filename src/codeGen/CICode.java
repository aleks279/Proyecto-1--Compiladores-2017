/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeGen;

import java.util.*;

/**
 *
 * @author Ale
 */
public class CICode {
    public static String intermediateCode;
    public ArrayList<Quadruple> finalCodeList;
    public static void listenCode(){
        intermediateCode = "";
        finalCodeList = new ArrayList<Quadruple> ();
    }
    
    public static void saveCode(String val, String exp1, String exp2, String result){
        Quadruple quadruple = new Quadruple(val, exp1, exp2, result);
        finalCodeList.add(quadruple);
        intermediateCode+= quadruple.toString();
    }
    
    public static void closeIC(){
        // file writer and code generations
        // new file writer 
        System.out.println(intermediateCode);
    }
}
