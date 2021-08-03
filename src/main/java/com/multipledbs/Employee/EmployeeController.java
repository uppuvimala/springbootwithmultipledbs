package com.multipledbs.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/Employees")
    private List<Employee> getAllEmpoyees(){
        return employeeRepository.findAll();
    }
}
