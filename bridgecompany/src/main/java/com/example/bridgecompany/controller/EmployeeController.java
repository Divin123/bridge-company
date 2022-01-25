package com.example.bridgecompany.controller;

import com.example.bridgecompany.entity.Employee;

import com.example.bridgecompany.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository repository;

    @GetMapping("/employees")
    public String showEmployee(Model model){
        model.addAttribute("employeeList",repository.findAll());
        return "listEmployees";
    }

    @PostMapping("/addEmployee")
    public String addEmployee(Employee employee, Model model){
        model.addAttribute("employee", new Employee());
        repository.save(employee);
        return "redirect:/employees";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return"redirect:/employees";
    }
    @GetMapping("/editEmployee/{id}")
    public String editEmployee(@PathVariable("id") Integer id, Model model){
        model.addAttribute("employee", repository.findById(id).get());

        return"editEmployee";
    }
}
