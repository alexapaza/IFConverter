package com.jalasoft.model.util;
/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/12/2020
 */
public class Logger {

    private static Logger logger = null;

    public static synchronized Logger getInstance() {
        if (logger == null)
            logger = new Logger();
        return logger;
    }

    public void writeLog(String message) {
        System.out.println(message);
    }
}