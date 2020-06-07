package com.jalasoft.model.parameter;

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

    public void validate() throws Exception{
        if (inputFile.isHidden()){
            throw new Exception("Error file is hidden");
        }if (!inputFile.isFile()){
            throw new Exception("Error is not file");
        }

    }
}
