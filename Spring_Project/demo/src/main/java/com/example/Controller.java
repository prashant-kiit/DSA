package com.example;

import java.util.List;

public class Controller {
    private Database database;

    public Controller(Database database) {
        this.database = database;
    }

    public List<Employee> getEmployeesAll() {
        return database.getEmployees();
    }

    public Employee getEmployeeByName(String name) {
        return database.getEmployeeOne(name);
    }

    public Boolean isEmployeePresent(String name) {
        if (database.getEmployeeOne(name) == null)
            return false;
        return true;
    }

    public void addEmployee(Employee employee) {
        database.insertEmployee(employee);
    }

    public String getEmployeeRank(Integer salary) {
        if (salary <= 10)
            return "Intern";
        if (salary > 10 && salary <= 100)
            return "Junior";
        if (salary > 100 && salary <= 500)
            return "Intermediate";
        if (salary > 500 && salary <= 1000)
            return "Senior";
        return "Principal";
    }
}
