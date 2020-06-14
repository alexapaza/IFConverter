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
public class  FileConverterException extends  Exception {
        private  static  final String message = "Error  conversion of the file";

        public FileConverterException(String currentMessage, Throwable ex ){
            super(currentMessage, ex);
        }

    public FileConverterException(Throwable ex) {
        super(message,ex);
    }
}
