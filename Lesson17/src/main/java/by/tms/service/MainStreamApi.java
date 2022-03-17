package by.tms.service;

import by.tms.module.Car;
import by.tms.module.Person;
import by.tms.module.StreamApiClass;

import java.util.*;

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
    }
}
