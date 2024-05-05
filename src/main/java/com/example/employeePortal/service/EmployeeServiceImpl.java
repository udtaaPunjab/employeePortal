package com.example.employeePortal.service;

import com.example.employeePortal.exception.EmployeeNotFoundException;
import com.example.employeePortal.model.Employee;
import com.example.employeePortal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository repository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        Optional<Employee> employee = repository.findById(id);
        if(employee.isEmpty()){
            throw new EmployeeNotFoundException("Employee not found with id "+id);
        }
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        System.out.println("Inside update. Employee - " + employee);
        Optional<Employee> currentEmployee = findById(employee.getId());
        if(currentEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Employee not found with id "+employee.getId());
        }
        Employee updatedEmployee = repository.save(employee);
        System.out.println("Updated Employee - " + updatedEmployee);
        return updatedEmployee;
    }

    @Override
    public Employee add(Employee employee) {
        System.out.println("Inside add. Employee - " + employee);
        Employee addedEmployee = repository.save(employee);
        System.out.println("Added Employee - " + addedEmployee);
        return addedEmployee;
    }

    @Override
    public void deleteById(int id) {
        Optional<Employee> currentEmployee = findById(id);
        if(currentEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Employee not found with id "+id);
        }
         repository.deleteById(id);
    }
}
