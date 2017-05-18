/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;
import java.io.File;
import tree.*;

/**
 *
 * @author Saul
 */
public class Compiler {
    private String program;
    
    public Compiler(String pProgram) {
        this.program = pProgram;
    }
    
    public void compile() {
        try {
            String calculatorFlex = "./src/compiler/C-zero.flex";
            File jflexFile = new File(calculatorFlex);

            jflex.Main.generate(jflexFile);

//            while (true) {
//                String st = this.program;
//                Environment env = new Environment();
//                parser p = new parser(new Lexer(new StringReader(st)));
//                Symbol s = p.parse();
//                Tree tree = (Tree) s.value;
//                env.print();
//                tree.print();
//            }
        }
        catch (Exception e) {
            System.out.println("Parsing error.");
            System.out.println(e);
        };
    }
}
