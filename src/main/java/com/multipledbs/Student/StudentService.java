package com.multipledbs.Student;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //get all studentss
    public List<Student> getAllStudents() {
        return studentRepository.findAll();

    }

    //create Student
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }


    //get StudentById
    public Optional<Student> getStudentbyId(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        return student;
    }
    //update StudentByd

    public Student updateStudentById(Long id, Student student) {
        student.setId(id);
        return studentRepository.save(student);
    }

    //delete StudentById
    public void deleteById(Long id) {
        if (studentRepository.findById(id).isPresent()) {
            studentRepository.deleteById(id);
        }
    }
}