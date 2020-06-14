/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
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