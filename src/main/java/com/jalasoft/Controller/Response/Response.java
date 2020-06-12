package com.jalasoft.Controller.Response;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/6/2020
 */
public abstract class Response<T> {

    private T status;

    public Response( T status) {
        this.status = status;
    }
    public T getStatus() {
        return status;
    }

    public void setStatus(T status) {
        this.status = status;
    }
}
