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
public class Minus extends Tree {
    Tree left;
    Tree right;

    public Minus(Tree l, Tree r) {
        left = l;
        right = r;
    }

    public Integer eval(Environment e) {
        return left.eval(e) - right.eval(e);
    }
    public void print() {
        System.out.print("(MINUS ");
        left.print();
        System.out.print(", ");
        right.print();
        System.out.print(")");
    }
}
