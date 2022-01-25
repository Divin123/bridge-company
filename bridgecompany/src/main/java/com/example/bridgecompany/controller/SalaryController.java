package com.example.bridgecompany.controller;

import com.example.bridgecompany.entity.Salary;
import com.example.bridgecompany.repository.EmployeeRepository;
import com.example.bridgecompany.repository.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SalaryController {

    @Autowired
    private SalaryRepository repository;
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/salaries")
    public String showsalaries(Model model){
        model.addAttribute("salaryList",repository.findAll());
        return "listSalaries";
    }

    @PostMapping("/addSalary")
    public String addSalary(Salary salary){
        repository.save(salary);
        return "redirect:/salaries";
    }
    @GetMapping("/deleteSalary/{id}")
    public String deleteSalary(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return"redirect:/salaries";
    }
    @GetMapping("/editSalary/{id}")
    public String editSalary(@PathVariable("id") Integer id, Model model){
        model.addAttribute("salary", repository.findById(id).get());
        model.addAttribute("employeeList4",employeeRepository.findAll());
        return"editSalary";
    }

}
