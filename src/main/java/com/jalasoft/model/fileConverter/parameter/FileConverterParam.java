package com.jalasoft.model.fileConverter.parameter;

import com.jalasoft.model.fileConverter.exception.ParameterInvalidException;

import java.io.File;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 5/31/2020
 */
public class FileConverterParam extends Parameter {
    private String inputPath;
    private String outputPath;
    private String format;

    public FileConverterParam(File inputFile, String inputPath, String outputPath, String format) {
        super(inputFile);
        this.inputPath = inputPath;
        this.outputPath = outputPath;
        this.format = format;
    }


    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }
    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
    public void setFormat(String format) {
        this.format = format;
    }

    public String getInputPath() {
        return inputPath;
    }
    public String getOutputPath() {
        return outputPath;
    }
    public String getFormat() {
        return format;
    }

    @Override
    public void validate() throws ParameterInvalidException {
        super.validate();
        if (this.inputPath.trim().isEmpty()){
            throw new ParameterInvalidException();
        }
        if (this.outputPath.trim().isEmpty()){
            throw new ParameterInvalidException();
        }
        if (this.format.trim().isEmpty()){
            throw new ParameterInvalidException();
        }


    }
}