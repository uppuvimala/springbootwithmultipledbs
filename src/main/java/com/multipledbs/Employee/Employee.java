package com.multipledbs.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Employee {
    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
