/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package types;

import java.util.HashMap;

/**
 *
 * @author Saul
 */
public class Type {
    public static int INTEGER = 1;
    public static int VOID = 2;
    public static int STRING = 3;
    public static int STRUCT = 4;
    public static int ERROR = 0;
    
    static HashMap<String, Type> types = new HashMap<String, Type>();
    
    int tag;
    int witdh;
    String value;
    
    public Type(int t, int w, String v) {
        this.tag = t;
        this.witdh = w;
        this.value = v;
    }

    public int getTag() {
        return tag;
    }

    public int getWitdh() {
        return witdh;
    }

    public String getValue() {
        return value;
    }
    
    public static void createTypes() {
        types.put(INTEGER+"", new Type(INTEGER, 2, "integer"));
        types.put(VOID+"", new Type(VOID, 0, "integer"));
        types.put(STRING+"", new Type(STRING, 8, "integer"));
        types.put(STRUCT+"", new Type(STRUCT, 3, "integer"));
        types.put(ERROR+"", new Type(ERROR, 0, "integer"));
    }
    
    public static Type getType(int tag){
        return types.get(""+tag);
    }
    
    public static Type getType(String val) {
        for(Type type : types.values()) {
            if(type.getValue().equals(val))
                return type;
        }
        return null;
    }
    
    public static Type max(Type t1, Type t2) {
        return t1.witdh > t2.witdh ? t1 : t2;
    }
}
