/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codeGen;

/**
 *
 * @author Saul
 */
public class Quadruple {
    private String operation;
    private String operand1;
    private String operand2;
    private String result;
    
    Quadruple(String pOperation, String pOperand1, String pOperand2, String pResult) {
        this.operation = pOperation;
        this.operand1 = pOperand1;
        this.operand2 = pOperand2;
        this.result = pResult;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperand1() {
        return operand1;
    }

    public void setOperand1(String operand1) {
        this.operand1 = operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public void setOperand2(String operand2) {
        this.operand2 = operand2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    public String toString() {
        return this.operation+" "+this.operand1+" "+this.operand2+" "+this.result+"\n";
    }
}
