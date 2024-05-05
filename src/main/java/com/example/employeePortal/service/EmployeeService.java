package com.example.employeePortal.service;

import com.example.employeePortal.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    public List<Employee>  findAll();
    public Optional<Employee> findById(int id);
    public Employee update(Employee employee);

    public Employee add(Employee employee);
    public void deleteById(int id);
}
