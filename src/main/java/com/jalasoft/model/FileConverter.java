package com.jalasoft.model;

import com.aspose.imaging.Image;
import com.aspose.imaging.SmoothingMode;
import com.aspose.imaging.imageoptions.CmxRasterizationOptions;
import com.aspose.imaging.imageoptions.PngOptions;
import com.aspose.imaging.imageoptions.PositioningTypes;
import com.jalasoft.model.fileConverter.exception.FileConverterException;
import com.jalasoft.model.fileConverter.exception.ParameterInvalidException;
import com.jalasoft.model.fileConverter.parameter.FileConverterParam;
import com.jalasoft.model.fileConverter.parameter.Parameter;
import com.jalasoft.model.result.Result;
import com.jalasoft.model.util.Logger;

/**
 * @author Alexander Apaza
 * @version 1.1
 * @date 5/31/2020
 */

public class FileConverter implements IFileConverter<FileConverterParam> {
    Logger logger = Logger.getInstance();
    @Override
    public Result converFile(FileConverterParam param) throws FileConverterException, ParameterInvalidException {
        param.validate();
        String dataDirFile = param.getInputPath()+ param.getFileName(); // param.getInputPath()+param.getFileName(); // "src/main/resources/CMX/Rectangle.cmx";

        try (Image image = Image.load(dataDirFile)){
            CmxRasterizationOptions cmxRasterizationOptions = new CmxRasterizationOptions();
            cmxRasterizationOptions.setPositioning(PositioningTypes.DefinedByDocument);
            cmxRasterizationOptions.setSmoothingMode(SmoothingMode.AntiAlias);
            PngOptions options = new PngOptions();
            options.setVectorRasterizationOptions(cmxRasterizationOptions);
            image.save(  param.getOutputPath()+ param.getFileName()+"."+ param.getFormat(), options);
            logger.writeLog("INFO:File Conversion went fine");
            return new Result(param.getFileName()+"."+ param.getFormat());

        }catch (Exception e){
            logger.writeLog("ERROR:File convertion failed below the detail:"+e.getMessage());
            throw  new FileConverterException(e);
        }

    }

}
