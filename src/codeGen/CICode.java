/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeGen;

/**
 *
 * @author Ale
 */
public class CICode {
    public static String intermediateCode;
    
    public void listenCode(){
        intermediateCode = "";
    }
    
    public void saveCode(String val, String exp1, String exp2, String result){
        intermediateCode+= val+" "+exp1+" "+exp2+" "+result+"\n";
    }
    
    public void closeIC(){
        // file writer and code generations
        // new file writer 
        System.out.println(intermediateCode);
    }
}
