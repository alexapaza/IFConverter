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
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/12/2020
 */
public class ExtractMetadataParameter extends Parameter {
    private String type;
    private String inDir;
    private String outDir;
    private final static List<String> TYPE_LIST= Arrays.asList("txt","png");

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

    @Override
    public void validate() throws ParameterInvalidException {
        if(inputFile.isHidden()){
           throw  new ParameterInvalidException();
        }
        if(!inputFile.isFile()){
            throw  new ParameterInvalidException();
        }
        if(inputFile.toPath().toString().contains("..")){
            throw  new ParameterInvalidException("invalid input file");
        }

        if (this.type.trim().isEmpty()) {
            throw new ParameterInvalidException();
        }

        if (!TYPE_LIST.contains(this.type)) {
            throw new ParameterInvalidException("type", type);
        }

    }

}
