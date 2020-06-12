package com.jalasoft.Controller.request;

import org.springframework.web.multipart.MultipartFile;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/12/2020
 */
public class RequestConverterParameters {
    private String format;
    private String md5;
    private MultipartFile file;

    public RequestConverterParameters(String format, String md5, MultipartFile file) {
        this.format = format;
        this.md5 = md5;
        this.file = file;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }

    public String getFormat() {
        return format;
    }

    public String getMd5() {
        return md5;
    }

    public MultipartFile getFile() {
        return file;
    }
}
