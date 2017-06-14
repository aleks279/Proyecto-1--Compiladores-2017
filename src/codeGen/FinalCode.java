/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeGen;

import static codeGen.CICode.finalCodeList;
import static codeGen.CICode.intermediateCode;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Ale
 */
public class FinalCode {

    public static void generateFinalCode(){
        int index ;
        int max = finalCodeList.size();
        String buffer = ";C0 Final Code\n";
        String line = "                                         ";
        Quadruple temp;
        String op;
        for (index = 0; index < max; index++) {
            temp = finalCodeList.get(index);
            op = temp.getOperation().toString();
            if (temp.getOperation().equals("CARGAR_DIRECCION")){
                buffer+=(line+"MOVE /"+temp.getOperand1()+" , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("CARGAR_VALOR")){
                buffer+=(line+"MOVE #"+temp.getOperand1()+" , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("SUMAR")){
                buffer+=(line+"ADD /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer+=(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (op.equals("RESTAR")){
                System.out.println("codeGen.FinalCode.generateFinalCode()");
                buffer+=(line+"SUB /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer+=(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("MULTIPLICAR")){
                buffer+=(line+"MUL /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer+=(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("DIVIDIR")){
                buffer+=(line+"DIV /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer+=(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("OR")){
                buffer+=(line+"OR /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer+=(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("AND")){
                buffer+=(line+"AND /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer+=(line+"MOVE .A , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("MAYOR")){
                buffer+=(line+"CMP /"+temp.getOperand2()+" , /"+temp.getOperand1()+"\n");
                buffer+=(line+"BN $5"+"\n");
                buffer+=(line+"MOVE #0 , /"+temp.getResult()+"\n");
                buffer+=(line+"BR $3"+"\n");
                buffer+=(line+"MOVE #1 , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("MENOR")){
                buffer+=(line+"CMP /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer+=(line+"BN $5"+"\n");
                buffer+=(line+"MOVE #0 , /"+temp.getResult()+"\n");
                buffer+=(line+"BR $3"+"\n");
                buffer+=(line+"MOVE #1 , /"+temp.getResult()+"\n");
            } 
            else if (temp.getOperation().equals("IGUAL")){
                buffer+=(line+"CMP /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer+=(line+"BZ $5"+"\n");
                buffer+=(line+"MOVE #0 , /"+temp.getResult()+"\n");
                buffer+=(line+"BR $3"+"\n");
                buffer+=(line+"MOVE #1 , /"+temp.getResult()+"\n");
            }
            else if (temp.getOperation().equals("DISTINTO")){
                buffer+=(line+"CMP /"+temp.getOperand1()+" , /"+temp.getOperand2()+"\n");
                buffer+=(line+"BZ $5"+"\n");
                buffer+=(line+"MOVE #0 , /"+temp.getResult()+"\n");
                buffer+=(line+"BR $3"+"\n");
                buffer+=(line+"MOVE #1 , /"+temp.getResult()+"\n");
            }
            else if (temp.getOperation().equals("ETIQUETA")){
                String subLine = temp.getResult()+":"+line;
                buffer+=(subLine.substring(0, line.length())+" NOP\n");
            }
            else if (temp.getOperation().equals("SALTAR_CONDICION")){
                buffer+=(line+"CMP #0 , /"+temp.getOperand1()+"\n");
                buffer+=(line+"BZ /"+temp.getResult()+"\n");
            }
            else if (temp.getOperation().equals("SALTAR_ETIQUETA")){
                buffer+=(line+"BR /"+temp.getResult()+"\n");
            }
            else if (temp.getOperation().equals("IMPRIMIR_ENTERO")){
                buffer+=(line+"WRINT /"+temp.getOperand1()+"\n");
            }
            else if (temp.getOperation().equals("IMPRIMIR_ENTERO")){
                buffer+=(line+"WRSTR /"+temp.getOperand1()+"\n");
            }
            else if (temp.getOperation().equals("PONER_CADENA")){
                String subLine = temp.getOperand1()+":"+line;
                
                buffer+=(subLine.substring(0, line.length())+"DATA        "+temp.getResult()+"\n");
            }
            else if (temp.getOperation().equals("FIN")){
                buffer+=(line+"HALT\n");
            }            
        }
        writeFile(buffer);
    }
    public static void writeFile(String finalCode){
        try{
                FileWriter writer = new FileWriter("FinalCode.ens");
                BufferedWriter buffer = new BufferedWriter(writer);
                buffer.write(finalCode);

                buffer.close();
                writer.close();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            }
    }

