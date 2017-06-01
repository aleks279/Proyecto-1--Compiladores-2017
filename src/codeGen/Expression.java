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
public class Expression {
    private int address;
    
    public Expression(int pAddress) {
        this.address = pAddress;
    }
    
    int getAddress() {
        return this.address;
    }
}
