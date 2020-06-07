package com.jalasoft.model;

import com.aspose.imaging.Image;
import com.aspose.imaging.SmoothingMode;
import com.aspose.imaging.imageoptions.CmxRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.PositioningTypes;
import com.jalasoft.model.parameter.FileConverterParam;
import com.jalasoft.model.parameter.Parameter;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 5/31/2020
 */
public class FileConverter {

    public String converFile(FileConverterParam param) throws Exception {
        String dataDirFile = param.getInputPath()+ param.getFileName(); // param.getInputPath()+param.getFileName(); // "src/main/resources/CMX/Rectangle.cmx";

        try (Image image = Image.load(dataDirFile)){
            CmxRasterizationOptions cmxRasterizationOptions = new CmxRasterizationOptions();
            cmxRasterizationOptions.setPositioning(PositioningTypes.DefinedByDocument);
            cmxRasterizationOptions.setSmoothingMode(SmoothingMode.AntiAlias);
            PngOptions options = new PngOptions();
            options.setVectorRasterizationOptions(cmxRasterizationOptions);
            image.save(  param.getOutputPath()+ param.getFileName()+"."+ param.getFormat(), options);
            return "File converted succesfully";
        }catch (Exception e){
            throw  new Exception("Fail file conversion:"+e.getMessage());
        }

    }

}
