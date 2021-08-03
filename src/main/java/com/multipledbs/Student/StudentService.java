package com.multipledbs.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //create student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    //update StudentByd

    public Student updateStudentById(Long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }
    //delete StudentById
    public void deleteById(Long id){
        if(studentRepository.findById(id).isPresent()){
            studentRepository.deleteById(id);
        }
    }

}