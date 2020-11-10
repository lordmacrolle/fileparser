package com.service.impl;

import com.message.Messages;
import com.model.Employees;
import com.repository.EmployeeDao;
import com.service.FileWriter;
import com.validation.exceptions.FileWriterException;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

public class XMlFileWriter implements FileWriter {

    Logger logger = Logger.getLogger(XMlFileWriter.class);

    private File outFile;

    public XMlFileWriter(File outFile) {
        this.outFile = outFile;
    }
    @Override
    public boolean writeFile() {
        JAXBContext jaxbContext = null;
        try {
            jaxbContext = JAXBContext.newInstance(Employees.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            Employees savedEmployees = EmployeeDao.getInstance().getEmployeeList();
            jaxbMarshaller.marshal(savedEmployees, this.outFile);
            logger.info("Total successfully written records are :" +savedEmployees.getEmployees().size());
            return true;
        } catch (JAXBException e) {
            throw new FileWriterException(Messages.FILE_WRITE_EXCEPTION,e);
        }
    }
}
