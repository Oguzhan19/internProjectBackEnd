package com.polarcape.intern.interproject.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.polarcape.intern.interproject.model.Employee;
import com.polarcape.intern.interproject.repository.EmployeeRepository;
import com.polarcape.intern.interproject.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void addEmployee(Employee employee) {

        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long empID) {
        employeeRepository.deleteByEmployeeId(empID);
    }

    @Override
    public Employee getEmployee(Long empID) {
        return employeeRepository.findByEmployeeId(empID);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
}
