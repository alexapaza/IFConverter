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
