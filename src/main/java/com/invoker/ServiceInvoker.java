package com.invoker;

import com.message.Messages;
import com.service.driver.FileParserStrategy;
import com.service.driver.FileWriterStrategy;
import com.service.impl.XMlFileWriter;
import com.service.impl.XmlFileParser;
import com.validation.exceptions.ArgumentInvalidException;
import com.validation.exceptions.FileInvalidException;
import com.validation.exceptions.FileWriterException;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.io.File;

public class  ServiceInvoker{

    //loaded the config which can be changed for diff log level
    static {
        ClassLoader classLoader =  Thread.currentThread().getContextClassLoader();
        PropertyConfigurator.configure(classLoader.getResourceAsStream("log4j.properties"));
    }

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(ServiceInvoker.class);
        try {
            logger.info("Application started");
            if (args.length < 2)
                throw new ArgumentInvalidException(Messages.INVALID_ARGUMENT);
            String output = new StringBuilder(args[1]).append(File.separator).append("output_").append(System.currentTimeMillis()).append(".xml").toString();
            File outPutFile = new File(output);
            File inputFile = new File(args[0]);
            FileParserStrategy fileDriver = new FileParserStrategy(new XmlFileParser(), inputFile);
            fileDriver.parseInputFile();
            if (args.length > 2) {
                File addEmp = new File(args[2]);//can be taken from the run time argument as well.
                fileDriver.addEmployee(addEmp);
            }
            fileDriver.removeEmployee("Mohan");
            fileDriver.removeEmployee("shyam");
            FileWriterStrategy fileWriterStrategy = new FileWriterStrategy(new XMlFileWriter(outPutFile));
            fileWriterStrategy.generateEmployeeFile();
            logger.info("File successfully writtedn at the location :"+outPutFile.getAbsolutePath());
        }
        catch (ArgumentInvalidException| FileInvalidException| FileWriterException e)
        {
            logger.error(e.getMessage());
        }
        catch (Exception e)
        {
            logger.error(e.getLocalizedMessage(),e);
        }
    }


}
