/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
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
