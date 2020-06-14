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
