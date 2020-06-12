package com.jalasoft.model.fileConverter.parameter;

import com.jalasoft.model.fileConverter.exception.ParameterInvalidException;

import java.io.File;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/2/2020
 */
public class Parameter {
    File inputFile;
    Parameter(File inputFile){
        this.inputFile =inputFile;
    }

    public File getInputFile() {
        return inputFile;
    }
    public String getFileName() {
        return inputFile.getName();
    }

    public void validate() throws ParameterInvalidException {
        if (inputFile.isHidden()){
            throw new ParameterInvalidException();
        }if (!inputFile.isFile()){
            throw new ParameterInvalidException();
        }

    }
}
