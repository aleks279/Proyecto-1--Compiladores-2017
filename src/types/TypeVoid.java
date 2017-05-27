/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.util.*;

/**
 *
 * @author Saul
 */
public class TypeVoid extends Type {
    Type returnType;
    List<Type> paramTypes;
    
    public TypeVoid(Type rType) {
        this(rType, new ArrayList<Type>());
    }
    
    public TypeVoid(Type rType, List<Type> params) {
        super(Type.VOID, rType.witdh, rType.value);
        this.returnType = rType;
        this.paramTypes = params;
    }
    
    public void addParamType(List<Type> type) {
        this.paramTypes.addAll(type);
    }
    
    public Type getReturnType() {
        return this.returnType;
    }
    
    public void setReturnType(Type type) {
        this.returnType = type;
    }
    
    public List<Type> getParamTypes() {
        return this.paramTypes;
    }
    
    public String getName() {
        return this.value;
    }
}
