package com.jalasoft.model;

import com.jalasoft.model.fileConverter.exception.FileConverterException;
import com.jalasoft.model.fileConverter.exception.ParameterInvalidException;
import com.jalasoft.model.fileConverter.parameter.FileConverterParam;
import com.jalasoft.model.fileConverter.parameter.Parameter;
import com.jalasoft.model.result.Result;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/12/2020
 */
public interface IFileConverter<T extends Parameter> {
    Result converFile(T param) throws ParameterInvalidException, FileConverterException;
}
