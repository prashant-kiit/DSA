package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import lombok.Data;

@Data
public class Database {
    private static Database database;
    private static List<Employee> employees;

    private Database() {
        employees = new ArrayList<>();
    }

    public static Database getInstance() {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public Employee getEmployeeOne(String name) {
        return employees.stream().filter(n -> n.getName().equals(name)).collect(Collectors.toList()).get(0);
    }

    public void insertEmployee(Employee employee) {
        employees.add(employee);
    }

    public void insertEmployeesList(List<Employee> emps) {
        employees = emps;
    }

}
