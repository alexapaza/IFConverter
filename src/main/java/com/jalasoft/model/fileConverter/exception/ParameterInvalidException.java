/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.model.fileConverter.exception;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/12/2020
 */
public class ParameterInvalidException extends Exception {
    private static final String GENERAL_MESSAGE = "invalid parameter";
    private static final String FIELD_MESSAGE = "Invalid value = %s, on field = %s";

    public ParameterInvalidException() {
        super(GENERAL_MESSAGE);
    }

    public ParameterInvalidException(String currentMessage) {
        super(currentMessage);
    }

    public ParameterInvalidException(Throwable ex) {
        super(GENERAL_MESSAGE,ex);
    }
    public ParameterInvalidException(String field, String value) {
        super(String.format(FIELD_MESSAGE, field,value));
    }

}
