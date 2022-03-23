package com.codeforgeyt.filtering.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "employees")
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String email;
    private String firstName;
    private String lastName;


    public Employee(String email,
                    String firstName,
                    String lastName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
