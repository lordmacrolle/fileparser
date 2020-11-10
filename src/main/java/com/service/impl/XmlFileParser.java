package com.service.impl;

import com.message.Messages;
import com.model.Employee;
import com.model.Employees;
import com.repository.EmployeeDao;
import com.service.FileParser;
import com.validation.exceptions.FileInvalidException;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XmlFileParser implements FileParser {

    Logger logger = Logger.getLogger(XmlFileParser.class);

    @Override
    public void readFile(File file) {
        JAXBContext jaxbContext = null;
        Employees emps = null;
        try {
            jaxbContext = JAXBContext.newInstance(Employees.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            emps = (Employees) unmarshaller.unmarshal(file);
         } catch (JAXBException e) {
            new FileInvalidException(Messages.FILE_ERROR, e);
        }
        if(emps!=null && emps.getEmployees().size()>0)
        {
            EmployeeDao.getInstance().addEmployees(emps.getEmployees());
            logger.info(String.format(Messages.SUCCESS,emps.getEmployees().size()));
        }
    }

    @Override
    public void addEmployee(File file) {
        JAXBContext jaxbContext = null;
        Employee emp = null;
        try {
            jaxbContext = JAXBContext.newInstance(Employee.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            emp = (Employee) unmarshaller.unmarshal(file);
        }
        catch (JAXBException e) {
               throw  new FileInvalidException(Messages.FILE_ERROR, e);
        }
        if(emp!=null)
        {
            EmployeeDao.getInstance().addEmployee(emp);
            logger.info(String.format(Messages.EMP_ADDITION,emp.getName()));
        }
    }

    @Override
    public void deleteEmployee(String name) {

        boolean res = EmployeeDao.getInstance().removeEmployee(name);
        logger.info(String.format(Messages.EMP_REMOVE,res,name));
    }
}
