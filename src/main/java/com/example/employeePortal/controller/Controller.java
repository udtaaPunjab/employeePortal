package com.example.employeePortal.controller;


import com.example.employeePortal.model.Employee;
import com.example.employeePortal.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

// Using @Controller without @ResponseBody (on method level) will return html template by default.
@RestController
@RequestMapping("/employees") // basemapping
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from http://localhost:3000
public class Controller {
    EmployeeServiceImpl service;

    // Since only 1 constructor so autowired is optional
    @Autowired
    public Controller(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Employee> getAllEmployees(){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getAllEmployees(@PathVariable Integer id){
        return service.findById(id);
    }

    @PostMapping("/update")
    public Employee updateEmployee(@RequestBody Employee employee){
        System.out.println("Inside controller Employee -> "+employee);
        return service.update(employee);
    }

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee){
        System.out.println("Inside controller Employee -> "+employee);
        return service.add(employee);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id){
        service.deleteById(id);
    }
}
