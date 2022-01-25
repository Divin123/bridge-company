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
public class Salary {
    @Id
            @GeneratedValue(strategy = GenerationType.AUTO)
    Integer salaryId;
    Integer amount;
    String allowance;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_emp_id")
    Employee employee;

}
