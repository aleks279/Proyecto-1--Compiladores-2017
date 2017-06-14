/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeGen;

import static codeGen.CICode.finalCodeList;

/**
 *
 * @author Ale
 */
public class FinalCode {

    public static void generateFinalCode(){
        int index ;
        int max = finalCodeList.size();
        String buffer = "";
        String line = "                        ";
        Quadruple temp;
        for (index = 0; index<max; index++) {
            temp = finalCodeList.get(index);
            if (temp.getOperation().equals("CARGAR_DIRECCION")){
                buffer.concat(line+"MOVE /"+temp.getOperand1()+" , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("CARGAR_VALOR")){
                buffer.concat(line="MOVE #"+temp.getOperand1()+" , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("SUMAR")){
                buffer.concat(line+"ADD /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer.concat(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("RESTAR")){
                buffer.concat(line+"SUB /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer.concat(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("MULTIPLICAR")){
                buffer.concat(line+"MUL /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer.concat(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("DIVIDIR")){
                buffer.concat(line+"DIV /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer.concat(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("OR")){
                buffer.concat(line+"OR /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer.concat(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("AND")){
                buffer.concat(line+"AND /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer.concat(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("MAYOR")){
                buffer.concat(line+"CMP /"+temp.getOperand2()+" , /"+temp.getOperand1()+"\n");
                buffer.concat(line+"BN $5"+"\n");
                buffer.concat(line+"MOVE #0 , /"+temp.getResult()+"\n");
                buffer.concat(line+"BR $3"+"\n");
                buffer.concat(line+"MOVE #1 , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("MENOR")){
                buffer.concat(line+"CMP /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer.concat(line+"BN $5"+"\n");
                buffer.concat(line+"MOVE #0 , /"+temp.getResult()+"\n");
                buffer.concat(line+"BR $3"+"\n");
                buffer.concat(line+"MOVE #1 , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("IGUAL")){
                buffer.concat(line+"CMP /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer.concat(line+"BZ $5"+"\n");
                buffer.concat(line+"MOVE #0 , /"+temp.getResult()+"\n");
                buffer.concat(line+"BR $3"+"\n");
                buffer.concat(line+"MOVE #1 , /"+temp.getResult()+"\n");
            }
            else if (temp.getOperation().equals("DISTINTO")){
                buffer.concat(line+"CMP /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer.concat(line+"BZ $5"+"\n");
                buffer.concat(line+"MOVE #0 , /"+temp.getResult()+"\n");
                buffer.concat(line+"BR $3"+"\n");
                buffer.concat(line+"MOVE #1 , /"+temp.getResult()+"\n");
            }
            else if (temp.getOperation().equals(" ")){
                buffer.concat(line+"\n");
            }
            else if (temp.getOperation().equals(" ")){
                buffer.concat(line+"\n");
            }
            else if (temp.getOperation().equals(" ")){
                buffer.concat(line+"\n");
            }
            else if (temp.getOperation().equals(" ")){
                buffer.concat(line+"\n");
            }
            else if (temp.getOperation().equals(" ")){
                buffer.concat(line+"\n");
            }
            
        }
    }
}
