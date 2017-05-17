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
public class StartPoint {
    Body body;
    
    public StartPoint (Body b){
        body = b;
    }
    
    public void go(){
        body.run();
    }
}
