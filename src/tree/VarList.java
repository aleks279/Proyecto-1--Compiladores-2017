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
public class VarList {
    Environment lst;
	
	public VarList(String id)
	{
		lst = new Environment();
		lst.set(id,0);
	}
	
	public void add(String id)
	{
		lst.set(id,0);
	}
	
	public Environment e() { return lst; }
}