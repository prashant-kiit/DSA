package com.example.api.exceptionhandling.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class EmployeeRequest {
    private String name;
    private Integer salary;
}
