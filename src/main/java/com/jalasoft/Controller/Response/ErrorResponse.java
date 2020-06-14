/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.Controller.Response;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/11/2020
 */
public class ErrorResponse<T> extends Response<T> {
    String error;
    public ErrorResponse(T status, String error) {
        super(status);
        this.error = error;

    }
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
