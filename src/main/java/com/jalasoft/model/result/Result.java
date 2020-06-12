package com.jalasoft.model.result;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/12/2020
 */
public class Result {
    private  String resultText;

    public Result(String resultText) {
        this.resultText = resultText;
    }

    public String getResultText() {
        return resultText;
    }

    public void setResultText(String resultText) {
        this.resultText = resultText;
    }
}
