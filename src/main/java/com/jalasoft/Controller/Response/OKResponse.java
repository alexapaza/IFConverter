package com.jalasoft.Controller.Response;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/11/2020
 */
public class OKResponse<T> extends Response<T>{
    String message;
    public OKResponse(T status, String message) {
        super(status);
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
}
