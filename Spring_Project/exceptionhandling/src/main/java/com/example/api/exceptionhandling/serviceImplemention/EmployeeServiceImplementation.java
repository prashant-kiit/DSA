package com.example.api.exceptionhandling.serviceImplemention;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.exceptionhandling.dao.Employee;
import com.example.api.exceptionhandling.dto.EmployeeRequest;
import com.example.api.exceptionhandling.repository.EmployeeRepo;
import com.example.api.exceptionhandling.service.EmployeeService;

@Service
public class EmployeeServiceImplementation implements EmployeeService{

    @Autowired
    private EmployeeRepo employeeRepo;

    public Employee save(EmployeeRequest employeeRequest) {
        Employee employee = Employee.build(0, employeeRequest.getName(), employeeRequest.getSalary());
        return employeeRepo.save(employee);
    }

    public List<Employee> getAll() {
        return employeeRepo.findAll();
    }

    public Employee getOne(int id) {
        Optional<Employee> employee = employeeRepo.findByEmpId(id);
        if(employee.isPresent())
            return employee.get(); 
        return null;
    }

}
