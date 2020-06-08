package com.jalasoft.Controller;


import com.jalasoft.Controller.Response.Response;
import com.jalasoft.Controller.component.Properties;
import com.jalasoft.Controller.service.FileService;
import com.jalasoft.model.FileConverter;
import com.jalasoft.model.parameter.FileConverterParam;
import com.jalasoft.model.parameter.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
    public ResponseEntity gatherConverterInput(@RequestParam(value= "file")MultipartFile file,
                                               @RequestParam(value="format") String format,
                                               @RequestParam(value="md5") String md5){

        if (file.isEmpty()){
            return ResponseEntity.badRequest().body(
                    new Response("","File is empty","400")
            );

                    //  new ResponseEntity("","file is empty",400);
        }
        if (format.isEmpty()){
            return ResponseEntity.badRequest().body(
                    new Response("","format is wrong","400")
            );
        }
        if(md5.isEmpty()){
            return ResponseEntity.badRequest().body(
                    new Response("","md5 is wrong","400")
            );
        }



        try {
            File image = fileService.saveFileInputFolder(file,md5);
            FileConverterParam param =
                    new FileConverterParam(image,properties.getInputFolder(),properties.getOutputFolder(),format);

            FileConverter fileConverter = new FileConverter();
            param.validate();
            String result= fileConverter.converFile(param);
            return ResponseEntity.ok().body(
                    new Response(result,"","200")
            );

        }catch (Exception e){
            return ResponseEntity.badRequest().body(
                    new Response("",e.getMessage(),"400")
            );
        }
    }





}
