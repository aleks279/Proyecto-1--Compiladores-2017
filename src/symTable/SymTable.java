/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symTable;

import java.util.*;

/**
 *
 * @author Saul
 */
public class SymTable {
    
    public static SymTable currentScope;
    static SymTable root = new SymTable(null);
    static int tableCounter;
    
    HashMap<String, Symbol> table;
    SymTable previous;
    List<String> vars;
    
    public SymTable(SymTable pPrevious) {
        table = new HashMap<String, Symbol>();
        this.previous = pPrevious;
        vars = new ArrayList<String>();
    }
    
    public static SymTable getRoot() {
        return root;
    }
    
    public static void initialize() {
        tableCounter = 0;
        currentScope = root;
    }
    
    public static boolean insert(String name, Symbol sym) {
        if(!currentScope.table.containsKey(name)) {
            currentScope.table.put(name, sym);
            return true;
        }
        return false;
    }
    
    public static void insertSymbol(String name, Symbol sym) {
        SymTable t = currentScope.previous;
        t.table.put(name, sym);
    }
    
    public static boolean canInsertVariable(String name, Symbol sym) {
        if(!currentScope.table.containsKey(sym)) {
            currentScope.table.put(name, sym);
            currentScope.vars.add(name);
            return true;
        }
        return false;
    }
    
    public static Symbol get(String name) {
        return get(name, currentScope);
    }
    
    public static Symbol get(String name, SymTable table) {
        for(SymTable t = table; t != null; t = t.previous) {
            Symbol s = (Symbol) (t.table.get(name));
            if(s != null)
                return s;
        }
        return null;
    }
    
    static void push(SymTable table) {
        tableCounter++;
        currentScope = new SymTable(table);
    }
    
    public static void push() {
        push(currentScope);
    }
    
    public static void pop() {
        currentScope = currentScope.previous;
        tableCounter--;
    }
}
