package com.repository;

import com.model.Employee;
import com.model.Employees;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//user this class to store temp emp data can be further extended using dao layer
public class EmployeeDao {


    private static EmployeeDao employeeDao = new EmployeeDao();

    private Map<String, Employee> employeeMap = null;

    private EmployeeDao() {
        this.employeeMap = new HashMap<>();
    }

    public static EmployeeDao getInstance() {
        return employeeDao;
    }

    public boolean addEmployees(List<Employee> employees) {
       Map<String, Employee> latestEmployees =  employees.stream().collect(Collectors.toMap(Employee::getName, emp -> emp));
       employeeMap.putAll(latestEmployees);
       return true;
    }

    public Employee addEmployee(Employee employee) {
       return this.employeeMap.putIfAbsent(employee.getName(),employee);
    }

    public boolean removeEmployee(String empName) {
        return  this.employeeMap.remove(empName)!=null;
    }

    public Employees getEmployeeList() {
        Employees emps = new Employees();
        emps.setEmployees(employeeMap.values().stream().collect(Collectors.toList()));
        return emps;
    }
}



