package com.multipledbs.Employee;

import com.multipledbs.Student.Student;
import com.multipledbs.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    //create employee
    public Employee createEmployee(Employee employee)
    {
        return employeeRepository.save(employee);
    }
    //update EmployeeByd

    public Employee updateEmployeeById(Long id, Employee employee) {
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    //delete EmployeeById
    public void deleteById(Long id) {
        if (employeeRepository.findById(id).isPresent()) {
            employeeRepository.deleteById(id);
        }

    }
}
