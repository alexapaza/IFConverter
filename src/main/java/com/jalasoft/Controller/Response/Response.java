package com.jalasoft.Controller.Response;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/6/2020
 */
public abstract class Response {

    private String status;

    public Response( String status) {
        this.status = status;
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
