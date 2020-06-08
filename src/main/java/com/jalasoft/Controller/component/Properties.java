package com.jalasoft.Controller.component;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 6/7/2020
 */


@Component
@ConfigurationProperties(prefix = "converter")
public class Properties {
    String inputFolder;
    String outputFolder;

    public String getInputFolder() {
        return inputFolder;
    }

    public String getOutputFolder() {
        return outputFolder;
    }

    public void setInputFolder(String inputFolder) {
        this.inputFolder = inputFolder;
    }

    public void setOutputFolder(String outputFolder) {
        this.outputFolder = outputFolder;
    }
}
