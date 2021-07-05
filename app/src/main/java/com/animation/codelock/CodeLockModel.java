package com.animation.codelock;


public class CodeLockModel {
    // Initialization: String for output window and secret code string
    private String totalExpression;
    final private String secretCode = "0000";


    public CodeLockModel() {
        totalExpression = "";
    }

    public void putInputSymbol(String sym) {
        totalExpression = totalExpression.concat(sym);
    }
    public String getResult() {
        return totalExpression;
    }
    public void reset() {
        totalExpression = "";
    }

    // Function: checks if the right code was entered
    public boolean checkCode(String sym) {
        try {
            // Simulation of hard work
            Thread.sleep(1000);
        } catch (InterruptedException e) {
           // Do nothing...
        }
        return totalExpression.equals(secretCode);
    }
}