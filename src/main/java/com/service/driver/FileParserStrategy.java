package com.service.driver;

import com.service.FileParser;
import com.validation.ValidationFactory;

import java.io.File;

public class FileParserStrategy {

    private FileParser fileParser;
    private File inputFile;
    private ValidationFactory validationFactory;


    public FileParserStrategy(FileParser fileParser, File inputFile) {
        this.fileParser = fileParser;
        this.inputFile = inputFile;
        this.validationFactory = new ValidationFactory();
    }


    public void parseInputFile() {
        this.validationFactory.getValidationService(fileParser).validate(inputFile);
        fileParser.readFile(inputFile);
    }

    public void addEmployee(File inputFile)
    {
       this.validationFactory.getValidationService(fileParser).validate(inputFile);
       fileParser.addEmployee(inputFile);
    }

    public void removeEmployee(String emplyeeName)
    {
        fileParser.deleteEmployee(emplyeeName);
    }

}
