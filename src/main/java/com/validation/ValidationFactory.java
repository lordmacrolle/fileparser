package com.validation;

import com.validation.impl.XMlValidator;
import com.service.FileParser;
import com.service.impl.XmlFileParser;

public class ValidationFactory {

    public FileValidator fileValidator;

    private XMlValidator xmlValidator = new XMlValidator();

    private FileValidator getXmlValidator() {
        return xmlValidator;
    }

    public FileValidator getValidationService(FileParser fileParser)
    {
        if(fileParser instanceof XmlFileParser)
            return getXmlValidator();
        //add other implementation;
       //either return default or return null and handle at calling end when no validator implementation is found.
    return getXmlValidator();
    }








}
