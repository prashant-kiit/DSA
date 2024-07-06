package com.example.api.exceptionhandling.service;

import java.util.List;

import com.example.api.exceptionhandling.dao.Employee;
import com.example.api.exceptionhandling.dto.EmployeeRequest;

public interface EmployeeService {
    public Employee save(EmployeeRequest employeeRequest);

    public List<Employee> getAll();

    public Employee getOne(int id);
}
