/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.Controller.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/7/2020
 */


@Component
@ConfigurationProperties(prefix = "converter")
public class Properties {
    String inputFolder;
    String outputFolder;
    /**
     * getter for InputFolder
     * @return the input folder path.
     */
    public String getInputFolder() {
        return inputFolder;
    }
    /**
     * getter for output Folder
     * @return the output folder path.
     */
    public String getOutputFolder() {
        return outputFolder;
    }
    /**
     * setter for input Folder
     * @set the input folder path.
     */
    public void setInputFolder(String inputFolder) {
        this.inputFolder = inputFolder;
    }
    /**
     * setter for output Folder
     * @set the output folder path.
     */
    public void setOutputFolder(String outputFolder) {
        this.outputFolder = outputFolder;
    }
}
