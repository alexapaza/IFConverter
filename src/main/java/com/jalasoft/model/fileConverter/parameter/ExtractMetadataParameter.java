package com.jalasoft.model.fileConverter.parameter;

import java.io.File;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/12/2020
 */
public class ExtractMetadataParameter extends Parameter {
    private String type;
    private String inDir;
    private String outDir;

    ExtractMetadataParameter(File inputFile, String type, String inDir, String outDir) {
        super(inputFile);
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setInDir(String inDir) {
        this.inDir = inDir;
    }

    public void setOutDir(String outDir) {
        this.outDir = outDir;
    }

    public String getType() {
        return type;
    }

    public String getInDir() {
        return inDir;
    }

    public String getOutDir() {
        return outDir;
    }
}
