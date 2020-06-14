/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.model.fileConverter.parameter;

import com.jalasoft.model.fileConverter.exception.ParameterInvalidException;

import java.io.File;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/2/2020
 */
public abstract class Parameter {
    protected File inputFile;

    Parameter(File inputFile){
        this.inputFile =inputFile;
    }

    public File getInputFile() {
        return inputFile;
    }
    public String getFileName() {
        return inputFile.getName();
    }

    public abstract void validate() throws ParameterInvalidException;

}
