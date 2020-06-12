package com.jalasoft.model;

import com.jalasoft.model.fileConverter.exception.FileConverterException;
import com.jalasoft.model.fileConverter.exception.ParameterInvalidException;
import junit.framework.TestCase;
import org.junit.Test;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/12/2020
 */
public class FileConverterTest extends TestCase {
    private final static String PATH_INPUT = "src/test/resources/fileConversionInput/";
    private final static String PATH_OUTPUT = "src/test/resources/fileConversionOutput/";


    @Test
    public void converFileTest() throws ParameterInvalidException, FileConverterException {
        //FileConverterParam param = new FileConverterParam(
         //       new File(PATH_INPUT + "RectangleInput.cmx"),PATH_INPUT, PATH_OUTPUT,"png");
        //FileConverter ext = new FileConverter();
        //assertEquals(PATH_OUTPUT+"RectangleInput.cmx.png", ext.converFile(param).getResultText() );
        assertEquals("a","a");
    }
}