package com.multipledbs;

import com.multipledbs.Employee.Employee;
import com.multipledbs.Employee.EmployeeRepository;
import com.multipledbs.Student.Student;
import com.multipledbs.Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SpringbootwithmultipledbsApplication {
	//implements CommandLineRunner
	//@Autowired
	//private EmployeeRepository employeeRepository;
	//@Autowired
	//private StudentRepository studentRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootwithmultipledbsApplication.class, args);
	}

	//@Override
	public void run(String... args) throws Exception {
		/*employeeRepository.saveAll(Arrays.asList(
				new Employee(1,"fn1","ln1","em1"),
		new Employee(2,"fn2","ln2","em2"),
		new Employee(3,"fn3","ln3","em3")
		)
		);
		studentRepository.saveAll(Arrays.asList(
				new Student(1,"fn1","ln1","em1"),
		new Student(2,"fn2","ln2","em2"),
		new Student(3,"fn3","ln3","em3")

		));
	}*/
	}
}