/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.Controller.endpoint;


import com.jalasoft.Controller.Exception.FileException;
import com.jalasoft.Controller.Response.ErrorResponse;
import com.jalasoft.Controller.Response.OKResponse;
import com.jalasoft.Controller.component.Properties;
import com.jalasoft.Controller.request.RequestConverterParameters;
import com.jalasoft.Controller.service.FileService;
import com.jalasoft.model.FileConverter;
import com.jalasoft.model.IFileConverter;
import com.jalasoft.model.fileConverter.exception.FileConverterException;
import com.jalasoft.model.fileConverter.exception.ParameterInvalidException;
import com.jalasoft.model.fileConverter.parameter.FileConverterParam;
import com.jalasoft.model.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.File;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 5/31/2020
 */
@RestController
@RequestMapping("/api/v3")
public class ControllerFileConverter {
    @Autowired
    private Properties properties;

    @Autowired
    private FileService fileService;

    @PostMapping("/converter")
    /**
     * "converter" endpoint, to gather the inputs for the file conversion
     * @return the ResponseEntity given the inputs, it could be ok response or bad response
     */

    public ResponseEntity gatherConverterInput(RequestConverterParameters parameter){
        try {
            File image = fileService.saveFileInputFolder(parameter.getFile(),parameter.getMd5());
            FileConverterParam param =
                    new FileConverterParam(image,properties.getInputFolder(),properties.getOutputFolder(),
                            parameter.getFormat());

            IFileConverter<FileConverterParam> fileConverter = new FileConverter();
            // param.validate();
            Result result= fileConverter.converFile( param);
            return ResponseEntity.ok().body(
                    new OKResponse<Integer>(HttpServletResponse.SC_OK,result.getResultText())
            );

        }catch (FileException e){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<String>(Integer.toString(HttpServletResponse.SC_BAD_REQUEST),e.getMessage())
            );
        }catch (ParameterInvalidException e){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<String>(Integer.toString(HttpServletResponse.SC_BAD_REQUEST),e.getMessage())
            );
        }catch (FileConverterException e){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<String>(Integer.toString(HttpServletResponse.SC_BAD_REQUEST),e.getMessage())
            );
        }

    }
    /**
     * "download" endpoint, to gather the inputs for the file conversion
     * @return the ResponseEntity given the inputs, it returns the download link of converted file
     */
    @PostMapping("/converter/download")
    public ResponseEntity extractMetadata(RequestConverterParameters parameter) {
        try {
            File image = fileService.saveFileInputFolder(parameter.getFile(),parameter.getMd5());
            FileConverterParam param =
                    new FileConverterParam(image,properties.getInputFolder(),properties.getOutputFolder(),
                            parameter.getFormat());

            IFileConverter<FileConverterParam> fileConverter = new FileConverter();
            // param.validate();
            Result result= fileConverter.converFile( param);
            String fileDownloadUri = fileService.getDownloadLink(new File(result.getResultText()));
            return ResponseEntity.ok().body(
                    new OKResponse<Integer>(HttpServletResponse.SC_OK,fileDownloadUri)
            );

        }catch (FileException e){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<String>(Integer.toString(HttpServletResponse.SC_BAD_REQUEST),e.getMessage())
            );
        }catch (ParameterInvalidException e){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<String>(Integer.toString(HttpServletResponse.SC_BAD_REQUEST),e.getMessage())
            );
        }catch (FileConverterException e){
            return ResponseEntity.badRequest().body(
                    new ErrorResponse<String>(Integer.toString(HttpServletResponse.SC_BAD_REQUEST),e.getMessage())
            );
        }

    }

}
