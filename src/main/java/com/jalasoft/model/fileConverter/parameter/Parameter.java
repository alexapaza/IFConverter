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
