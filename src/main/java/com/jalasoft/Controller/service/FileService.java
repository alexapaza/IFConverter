/*
 *  Copyright (c) 2020 Jalasoft.
 *
 * This software is the confidential and proprietary information of Jalasoft.
 * ("Confidential Information"). You shall not disclose such Confidential
 * Information and shall use it only in accordance with the terms of the
 *  license agreement you entered into with Jalasoft.
 */
package com.jalasoft.Controller.service;

import com.jalasoft.Controller.Exception.FileException;
import com.jalasoft.Controller.Response.Response;
import com.jalasoft.Controller.component.Properties;
import com.jalasoft.Controller.constant.ErrorConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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

    public File saveFileInputFolder(MultipartFile file, String md5) throws FileException {
        if (md5.isEmpty()){
            throw new FileException(ErrorConstant.FILE_ERROR);
        }
        String inputFilePath = "";
        String inputPath = properties.getInputFolder();
        String outputPath = properties.getOutputFolder();
        try {

            Files.createDirectories(Paths.get(inputPath)); // to create input folder
            Files.createDirectories(Paths.get(outputPath)); // to create output folder

            inputFilePath = inputPath + file.getOriginalFilename();

            Path path = Paths.get(inputFilePath);
            Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
            return new File(inputFilePath);
        }catch (IOException e){
            throw  new FileException(ErrorConstant.FILE_ERROR);
        }

    }
    public String getDownloadLink(File file) {
        return ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/api/v1/download/")
                .path(file.getName())
                .toUriString();
    }
}
