/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symTable;

import types.Type;

/**
 *
 * @author Saul
 */
public class SymbolT {
    
    Type type;
    String name;
    boolean constant;
    private int address;
    
    public SymbolT(String pName, Type pType) {
        this(pName, pType, false);
    }
    
    public SymbolT(String pName, Type pType, boolean pConstant) {
        this.name = pName;
        this.type = pType;
        this.constant = pConstant;
    }
    
    public SymbolT(String pName, Type pType, boolean pConstant, int pAddress) {
        this.name = pName;
        this.type = pType;
        this.constant = pConstant;
        this.address = pAddress;
    }
    
    public Type getType() {
        return this.type;
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean isConstant() {
        return this.constant;
    }
    
    public int getAddress() {
        return this.address;
    }
    
    public void setAddress(int pAddress) {
        this.address = pAddress;
    }
}
