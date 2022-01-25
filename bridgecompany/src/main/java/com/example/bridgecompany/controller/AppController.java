package com.example.bridgecompany.controller;

import com.example.bridgecompany.entity.Salary;
import com.example.bridgecompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
    @Autowired
    EmployeeRepository employeeRepository;
    @GetMapping("/")
    public String showHome(Model model){
        model.addAttribute("salary",new Salary());
        model.addAttribute("employeeList2", employeeRepository.findAll());
        return "index";
    }

}
