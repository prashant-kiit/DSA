package com.example;

public class Client {

    private static Controller controller = new Controller(Database.getInstance());

    public static void main(String[] args) {
        controller.addEmployee(new Employee("Prashant", 100));
        controller.addEmployee(new Employee("Kumar", 1000));
        controller.addEmployee(new Employee("Singh", 100000));
        controller.addEmployee(new Employee("Chinku", 10));

        System.out.println(controller.getEmployeesAll());
        System.out.println(controller.getEmployeeByName("Kumar"));
    }
}
