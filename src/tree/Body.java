/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tree;

/**
 *
 * @author Ale
 */
public class Body {
    Environment vars;
    Stmt stmt;
    public Body(VarList varl, Stmt s){
        vars = varl.e();
        stmt = s;
    }
    public void run(){
        stmt.run(vars);
    }
}
