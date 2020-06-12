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
