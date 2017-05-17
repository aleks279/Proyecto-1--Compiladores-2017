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
public class Greater implements Cond{
    Tree left;
    Tree right;

    public Greater(Tree l, Tree r) {
        left = l;
        right = r;
    }
    @Override
    public boolean run(Environment e) {
        return (left.eval(e) > right.eval(e));
    }
    public void print() {
        System.out.print("(GREATER ");
        left.print();
        System.out.print(", ");
        right.print();
        System.out.print(")");
    }
}

   