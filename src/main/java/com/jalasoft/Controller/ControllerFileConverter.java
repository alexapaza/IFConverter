package com.jalasoft.Controller;


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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import javax.servlet.http.HttpServletRequest;
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

    @PostMapping()
    /*public ResponseEntity gatherConverterInput(@RequestParam(value= "file")MultipartFile file,
                                               @RequestParam(value="format") String format,
                                               @RequestParam(value="md5") String md5){
*/
    public ResponseEntity gatherConverterInput(RequestConverterParameters parameter){


        try {
            File image = fileService.saveFileInputFolder(parameter.getFile(),parameter.getMd5());
            FileConverterParam param =
                    new FileConverterParam(image,properties.getInputFolder(),properties.getOutputFolder(),parameter.getFormat());

            IFileConverter<FileConverterParam> fileConverter = new FileConverter();
            param.validate();
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





}
