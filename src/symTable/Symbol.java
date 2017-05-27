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
public class Symbol {
    
    Type type;
    String name;
    boolean constant;
    
    public Symbol(String pName, Type pType) {
        this(pName, pType, false);
    }
    
    public Symbol(String pName, Type pType, boolean pConstant) {
        this.name = pName;
        this.type = pType;
        this.constant = pConstant;
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
}
