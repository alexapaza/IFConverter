package com.jalasoft.model.fileConverter.parameter;

import com.jalasoft.model.IFileConverter;
import com.jalasoft.model.fileConverter.exception.FileConverterException;
import com.jalasoft.model.fileConverter.exception.ParameterInvalidException;
import com.jalasoft.model.result.Result;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/12/2020
 */
public class ExtractMetadataFromFile implements IFileConverter<ExtractMetadataParameter> {


    @Override
    public Result converFile(ExtractMetadataParameter param) throws ParameterInvalidException, FileConverterException {
        return null;
    }
}
