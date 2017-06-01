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
public class CodeData {
    public static int line;
    public static String token;
    
    public static void saveCodeData(int pLine, String pToken) {
        line = pLine;
        token = pToken;
    }
}
