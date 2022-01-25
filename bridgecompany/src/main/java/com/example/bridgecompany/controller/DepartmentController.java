package com.example.bridgecompany.controller;

import com.example.bridgecompany.entity.Department;
import com.example.bridgecompany.entity.Employee;
import com.example.bridgecompany.repository.DepartmentRepository;
import com.example.bridgecompany.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentRepository repository;

    @GetMapping("/departments")
    public String showDepartments(Model model){
        model.addAttribute("departmentList",repository.findAll());
        return "listDepartment";
    }

    @PostMapping("/addDepartment")
    public String addDepartment(Department department){
        repository.save(department);
        return "redirect:/departments";
    }
    @GetMapping("/deleteDepartment/{id}")
    public String deleteDepartment(@PathVariable("id") Integer id){
        repository.deleteById(id);
        return"redirect:/departments";
    }
    @GetMapping("/editDepartment/{id}")
    public String editdepartment(@PathVariable("id") Integer id, Model model){
        model.addAttribute("department", repository.findById(id).get());

        return"editDepartment";
    }
}
