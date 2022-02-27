package by.tms.string.service;

import by.tms.string.module.Employee;

public class MainEmployee {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];
        employees[0] = new Employee("Иван Иванович Иванов", 200.2);
        employees[1] = new Employee("Петр Петрович Петров", 300.5);
        employees[2] = new Employee("Сидр Сидорович Сидоров", 400.8);
        for (int i = 0; i < employees.length; i++) {
            employees[i].generateReport();
        }
    }

}
