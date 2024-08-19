package com.example.api.exceptionhandling.repository;

import com.example.api.exceptionhandling.dao.Employee;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

    Optional<Employee> findByEmpId(int id);
    
}
