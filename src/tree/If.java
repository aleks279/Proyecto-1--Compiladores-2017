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
public class If {
        Cond cond;
	Stmt stmt;
	
	public If(Cond c, Stmt s)
	{
		cond = c;
		stmt = s;
	}
	
	public void run(Environment e)
	{
		if (cond.run(e))
			stmt.run(e);
	}
}
