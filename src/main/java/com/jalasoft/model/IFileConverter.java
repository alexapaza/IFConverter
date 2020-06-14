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
