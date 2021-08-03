package com.multipledbs.Employee;

import com.multipledbs.Student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
   EmployeeService employeeService;
   /* @GetMapping("/Employees")
    private List<Employee> getAllEmpoyees(){
        return employeeRepository.findAll();}*/
    //createEmployee
   @PostMapping("/createemployee")
   public Employee saveEmployee(@RequestBody Employee employee){
       return employeeService.createEmployee(employee);
   }
    //update employeeById details
    @PutMapping("/{id}")
    public Employee UpdateEmployeeById(@PathVariable("id") Long id,@RequestBody Employee employee){
        return employeeService.updateEmployeeById(id, employee);
    }
    //delete employeeById
    @DeleteMapping("/{id}")
    public void deleteEmployeeById(@PathVariable("id") Long id){
        employeeService.deleteById(id);
    }
}
