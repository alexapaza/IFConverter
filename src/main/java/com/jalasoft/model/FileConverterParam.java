package com.jalasoft.model;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 5/31/2020
 */
public class FileConverterParam {
    private String inputPath;
    private String outputPath;
    private String format;
    private String fileName;

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public String getFileName() {
        return fileName;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public String getFormat() {
        return format;
    }
}
