package com.jalasoft.Controller.service;

import com.jalasoft.Controller.Response.Response;
import com.jalasoft.Controller.component.Properties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
 * @date 6/7/2020
 */
@Service
public class FileService {
    @Autowired
    private Properties properties;

    public File saveFileInputFolder(MultipartFile file, String md5) throws Exception {
        if (md5.isEmpty()){
            throw new Exception("md5 is empty");
        }
        String inputFilePath = "";
        String inputPath = properties.getInputFolder();
        String outputPath = properties.getOutputFolder();

        Files.createDirectories(Paths.get(inputPath)); // to create input folder
        Files.createDirectories(Paths.get(outputPath)); // to create output folder

        inputFilePath = inputPath+file.getOriginalFilename();

        Path path = Paths.get(inputFilePath);
        Files.copy(file.getInputStream(),path, StandardCopyOption.REPLACE_EXISTING);
        return new File(inputFilePath);

    }
}
