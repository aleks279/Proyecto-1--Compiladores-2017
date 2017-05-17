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
public class Literal {
    Integer val;
    public Literal(Integer i) {
        val = i;
    }

    public Integer eval(Environment e) {
        return val;
    }
    public void print() {
        System.out.print("(LITERAL " + val + ")");
    }
}
