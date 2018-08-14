package com.polarcape.intern.interproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.polarcape.intern.interproject.model.Employee;
import com.polarcape.intern.interproject.repository.EmployeeRepository;
import com.polarcape.intern.interproject.service.EmployeeService;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @RequestMapping(value = "/employee", method = RequestMethod.GET)
    public List<Employee> listEmployee() {
        return employeeService.getAllEmployees();
    }

    @RequestMapping(value = "/getEmployee", method = RequestMethod.GET)
    public Employee getEmployee(@RequestParam("id") Long id) {
        return employeeService.getEmployee(id);

    }

    @RequestMapping(value = "/newEmployee", method = RequestMethod.POST)
    public void addEmployee(@RequestBody Employee employee) {
        employeeService.addEmployee(employee);
    }

    @RequestMapping(value = "/deleteEmployee", method = RequestMethod.DELETE)
    public void deleteEmployee(HttpServletRequest request) {
        Long employeeId = Long.parseLong(request.getParameter("empID"));
        employeeService.deleteEmployee(employeeId);
    }

    @RequestMapping(value = "/updateEmployee", method = RequestMethod.PUT)
    public void updateEmployee(@RequestParam("id") Long id) {

        Employee employee;
        employee = employeeService.getEmployee(id);
        employee.setEmail("atkafasi");
        employeeRepository.save(employee);

    }
}
