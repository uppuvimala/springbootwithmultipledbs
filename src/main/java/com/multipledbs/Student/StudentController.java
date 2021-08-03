package com.multipledbs.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
   StudentService studentService;
   //StudentRepository studentRepository;
    /*@GetMapping("/students")
    private List<Student> getAllStudents(){

        return studentRepository.findAll();
                //studentService.getAllStudents();
    }*/
    //create student
    @PostMapping("/createStudent")
    public Student saveStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    //update studentById details
    @PutMapping("/{id}")
    public Student UpdateStudentById(@PathVariable("id") Long id,@RequestBody Student student){
        return studentService.updateStudentById(id, student);
    }

    //delete studentById
    @DeleteMapping("/{id}")
    public void deleteStudenById(@PathVariable("id") Long id){
        studentService.deleteById(id);
    }
}
