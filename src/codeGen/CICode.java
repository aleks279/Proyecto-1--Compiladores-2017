/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeGen;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Ale
 */
public class CICode {
    public static String intermediateCode;
    public static ArrayList<Quadruple> finalCodeList = new ArrayList<Quadruple> ();
    public static ArrayList<String> stringList = new ArrayList<String>();
    public static void listenCode(){
        intermediateCode = "";
        
    }
    
    public static void saveCode(String val, String exp1, String exp2, String result){
        Quadruple quadruple = new Quadruple(val, exp1, exp2, result);
        finalCodeList.add(quadruple);
        intermediateCode+= quadruple.toString();
    }
    
    public static void generateStrings(){
        //jasdkfaksf
    }

    public static void closeIC(){
//        try{
//            FileWriter writer = new FileWriter("CodeIntermediate.CI");
//            BufferedWriter buffer = new BufferedWriter(writer);
//            buffer.write(intermediateCode);
//
//            buffer.close();
//            writer.close();
//            
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
        System.out.println(intermediateCode);
        
    }
}
