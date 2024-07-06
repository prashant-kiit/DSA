package com.example;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Employees!" );

        Employee employee0 = new Employee();
        employee0.setName("Prashant");
        employee0.setSalary(100);

        Employee employee1 = new Employee();
        employee1.setName("Kumar");
        employee1.setSalary(1000);

        List<Employee> employees = new ArrayList<>();
        employees.add(employee0);
        employees.add(employee1);

        School school = new School();
        school.setEmployees(employees);
    }
}
