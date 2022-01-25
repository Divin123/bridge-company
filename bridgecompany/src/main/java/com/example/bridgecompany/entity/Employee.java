package com.example.bridgecompany.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer empId;
    @Column(nullable = false,unique = true, length = 40)
    String empName;
    String empPhone;
    @Column(nullable = false,unique = true, length = 40)
    String email;
}
