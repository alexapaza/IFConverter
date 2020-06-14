/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
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
