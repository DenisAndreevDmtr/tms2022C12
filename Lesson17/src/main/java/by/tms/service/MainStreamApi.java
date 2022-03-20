package by.tms.service;

import by.tms.module.Car;
import by.tms.module.Person;
import by.tms.module.StreamApiClass;
import by.tms.module.Student;

import java.util.*;
import java.util.stream.Collectors;

public class MainStreamApi {
    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        list1.add(2);
        list1.add(3);
        list1.add(4);
        StreamApiClass.printListMultiplyByNumber(list1, 2);

        Set<Integer> set = new HashSet();
        StreamApiClass.printEvenNumbersAndPrintThem(set, 50);

        List<String> list2 = new ArrayList<>();
        list2.add("john");
        list2.add("arya");
        list2.add("sansa");
        StreamApiClass.printListObjectWithCapitalLetter(list2);

        List<Car> cars = Arrays.asList(
                new Car("AA1111BX", 2007),
                new Car("AK5555IT", 2010),
                new Car(null, 2012),
                new Car("", 2015),
                new Car("AI3838PP", 2017));
        StreamApiClass.printAllNumbersOfCarThatNewerThan(cars, 2010);

        List<Person> persons = Arrays.asList(
                new Person("Иван", "Иванов"),
                new Person("Петр", "Павлов"),
                new Person("Петр", "Дервин"),
                new Person("Ян", "Петров"),
                new Person("Андрей", "Дробышев"),
                new Person("Павел", "Антонов"),
                new Person("Кирилл", "Дерябин"));
        if (StreamApiClass.getOptionalStringOfSurnamesThatStartFromLetter(persons, "Д").isPresent()) {
            System.out.println(StreamApiClass.getOptionalStringOfSurnamesThatStartFromLetter(persons, "Д").get());
        }
        StreamApiClass.printNumberOfpeopleThatSurnnameFirstLetterStart(persons);

        List<Student> students = Arrays.asList(
                new Student("Иван", 145221, 3, Arrays.asList(4, 5, 6, 6, 5)),
                new Student("Павел", 145221, 1, Arrays.asList(9, 8, 6, 6, 8)),
                new Student("Петр", 145222, 2, Arrays.asList(3, 3, 2, 2, 2)),
                new Student("Василий", 145223, 4, Arrays.asList(9, 5, 4, 3, 4)),
                new Student("Николай", 145225, 3, Arrays.asList(2, 1, 3, 2, 2)));
        List<Student> updateStudents = students.stream().filter(s -> s.getMarks().stream().mapToDouble(x -> x).average().orElse(0.0) >= 3).peek(y -> y.setNumberCourse(y.getNumberCourse() + 1)).collect(Collectors.toList());
        updateStudents.forEach(j -> System.out.println(j));


    }
}
