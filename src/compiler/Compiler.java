/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compiler;
import java.io.File;
import java.io.StringReader;
import java_cup.runtime.*;

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
            // generate lexer
            String czeroFlex = "./src/compiler/c0.flex";
            File jflexFile = new File(czeroFlex);
            jflex.Main.generate(jflexFile);
            
            // generate parser and sym
            String options[] = new String[7];
            options[0] = "-destdir";
            options[1] = "src/compiler";
            options[2] = "-symbols"; 
            options[3] = "sym";
            options[4] = "-parser";         
            options[5] = "parser";
            
            options[6] = "src/compiler/c0.cup";
            
            try {
                java_cup.Main.main(options);
            } catch (Exception ex) {
                System.out.print(ex);
            }
            
            try {
                Yylex lexer = new Yylex(new StringReader(this.program));
                new parser(lexer).parse();
            } catch (Exception ex2) {
                System.out.print(ex2);
            }
            while (true) {
                String st = this.program;
                parser p = new parser(new Yylex(new StringReader(st)));
                Symbol s = p.parse();
            }
        }
        catch (Exception e) {
            System.out.println("Parsing error.");
            System.out.println(e);
        };
    }
}
