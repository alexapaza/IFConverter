package com.jalasoft.Controller.Exception;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/11/2020
 */
public class FileException extends Exception {

    public FileException(String message, Throwable ex) {
        super(message, ex);
    }

    public FileException(String message) {
        super(message);
    }
}
