package com.validation.impl;

import com.message.Messages;
import com.validation.FileValidator;
import com.validation.exceptions.FileInvalidException;
import org.apache.commons.io.FilenameUtils;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class XMlValidator implements FileValidator {

    private final String XML_EXT = "xml";
    Logger logger = org.apache.log4j.Logger.getLogger(XMlValidator.class);
    @Override
    public void validate(File file) {
        validateExtensions(file);
        try {
            logger.debug("meta validation invoked");
            DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = documentBuilder.parse(file);
            doc.getDocumentElement().normalize();
            logger.debug("meta validation completed");
        } catch (ParserConfigurationException|SAXException|IOException e1) {
            throw new FileInvalidException(Messages.FILE_ERROR, e1);
        }
    }

    private void validateExtensions(File file) {
        logger.debug("extension validation invoked");
        String ext = FilenameUtils.getExtension(file.getAbsolutePath());
        if (!ext.equalsIgnoreCase(XML_EXT))
            throw new FileInvalidException(Messages.EXTENSION_MISMATCH);
        logger.debug("extension validation completed");
    }


}
