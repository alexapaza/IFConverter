/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.model;


import com.jalasoft.model.fileConverter.exception.FileConverterException;
import com.jalasoft.model.fileConverter.exception.ParameterInvalidException;
import com.jalasoft.model.fileConverter.parameter.FileConverterParam;
import org.junit.Test;
import java.io.File;
import static org.junit.Assert.*;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/12/2020
 */

public class FileConverterTest  {
    private final static String PATH_INPUT = "src/test/resources/fileConversionInput/";
    private final static String PATH_OUTPUT = "src/test/resources/fileConversionOutput/";


    @Test
    public void VerifyFileIsConvertedToPNGFile() throws ParameterInvalidException, FileConverterException {
        FileConverterParam param = new FileConverterParam(
               new File(PATH_INPUT + "RectangleInput.cmx"),PATH_INPUT, PATH_OUTPUT,"png");
        FileConverter ext = new FileConverter();
        assertEquals("RectangleInput.cmx.png", ext.converFile(param).getResultText() );
    }

    @Test(expected = ParameterInvalidException.class)
    public void verifyWrongFormatDestinationTriggerProperException() throws ParameterInvalidException, FileConverterException {
        FileConverterParam param = new FileConverterParam(
                new File(PATH_INPUT + "RectangleInput.cmx"),PATH_INPUT, PATH_OUTPUT,"pnga");
        FileConverter ext = new FileConverter();
         ext.converFile(param).getResultText() ;
    }

    @Test (expected = ParameterInvalidException.class)
    public void verifyNullAsFileTriggerProperException() throws ParameterInvalidException, FileConverterException {
        FileConverterParam param = new FileConverterParam(
                null,PATH_INPUT, PATH_OUTPUT,"png");
        FileConverter ext = new FileConverter();
        ext.converFile(param).getResultText() ;
    }

    @Test (expected = ParameterInvalidException.class)
    public void verifyNullAsFormatTriggerProperException() throws ParameterInvalidException, FileConverterException {
        FileConverterParam param = new FileConverterParam(
                new File(PATH_INPUT + "RectangleInput.cmx"),PATH_INPUT, PATH_OUTPUT,null);
        FileConverter ext = new FileConverter();
        ext.converFile(param).getResultText() ;
    }

    @Test (expected = FileConverterException.class)
    public void verifyProperExceptionIsTriggeredWhenSourceFileIsNotSupportedFormat() throws ParameterInvalidException, FileConverterException {
        FileConverterParam param = new FileConverterParam(
                new File(PATH_INPUT + "testFile.doc"),PATH_INPUT, PATH_OUTPUT,"png");
        FileConverter ext = new FileConverter();
        ext.converFile(param).getResultText() ;
    }
}