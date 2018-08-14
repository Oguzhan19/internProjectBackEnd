package com.polarcape.intern.interproject.service;

import java.util.List;

import com.polarcape.intern.interproject.model.Employee;

public interface EmployeeService {

    public void addEmployee(Employee employee);

    public List<Employee> getAllEmployees();

    public void deleteEmployee(Long empID);

    public Employee getEmployee(Long empID);

    public void updateEmployee(Employee employee);
}
