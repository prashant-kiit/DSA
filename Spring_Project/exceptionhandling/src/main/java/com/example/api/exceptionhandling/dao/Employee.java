package com.example.api.exceptionhandling.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;

@Entity
@Table(name = "EMPLOYEE_TABLE")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class Employee {
    @Id
    @GeneratedValue
    private Integer empId;

    @NotBlank(message = "Employee name cannot be blank")
    private String name;

    @Min(value = 1, message = "Salary must be a positive number")
    private Integer salary;
}
