package by.tms.additionaltask.service;

import by.tms.additionaltask.module.City;
import by.tms.additionaltask.module.Student;
import by.tms.additionaltask.utils.CRUDUtilsAdditionalTask;


public class MainAdditional {
    public static void main(String[] args) {
        System.out.println("Вывод всех студентов");
        CRUDUtilsAdditionalTask.getAllStudents().forEach(System.out::println);
        Student studentNew = new Student("Yan", "Yanovich", 3, 2);
        System.out.println("Выполнение добавления студентов");
        CRUDUtilsAdditionalTask.addStudent(studentNew).forEach(System.out::println);
        System.out.println("Выполнение редактирования студентов");
        CRUDUtilsAdditionalTask.updateStudent(1, 3).forEach(System.out::println);
        System.out.println("Выполнение задания удаления");
        CRUDUtilsAdditionalTask.deleteStudent(4).forEach(System.out::println);
        System.out.println("Cтуденты с городом");
        CRUDUtilsAdditionalTask.getAllStudentsWithCities().forEach(System.out::println);
        System.out.println("Список городов");
        CRUDUtilsAdditionalTask.getAllCities().forEach(System.out::println);
        City city = new City("Grodno");
        System.out.println("Добавление города");
        CRUDUtilsAdditionalTask.addCity(city);
        System.out.println("Удаление города");
        CRUDUtilsAdditionalTask.deleteStudent(4).forEach(System.out::println);
    }
}
