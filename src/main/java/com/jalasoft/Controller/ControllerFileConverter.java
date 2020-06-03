package com.jalasoft.Controller;

import com.jalasoft.model.FileConverter;
import com.jalasoft.model.parameter.FileConverterParam;
import com.jalasoft.model.parameter.Parameter;
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
    @PostMapping()
    public String gatherConverterInput(@RequestParam(value= "file")MultipartFile file,
                                       @RequestParam(value="format") String format,
                                       @RequestParam(value="md5") String md5){

        if (file.isEmpty()){
            return "error file";
        }
        if (format.isEmpty()){
            return "error format";
        }
        if(md5.isEmpty()){
            return "erro in msd5";
        }
        String inputFilePath = "";
        String inputPath = "src/main/resources/CMXInputPath/";
        String outputPath = "src/main/resources/CMXOutputPath/";
        try {
            Files.createDirectories(Paths.get(inputPath)); // to create input folder
            Files.createDirectories(Paths.get(outputPath)); // to create output folder

            inputFilePath = inputPath+file.getOriginalFilename();

            Path path = Paths.get(inputFilePath);
            Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
            System.out.println(path.getFileSystem());
            System.out.println();


        } catch (IOException e) {
            e.getMessage();
        }
        File image = new File(inputFilePath);
        FileConverterParam param = new FileConverterParam(image,inputPath,outputPath,format);

        FileConverter fileConverter = new FileConverter();

        try {
            param.validate();
            fileConverter.converFile(param);

        }catch (Exception e){
            e.getMessage();
        }


        return "file converted";
    }





}
