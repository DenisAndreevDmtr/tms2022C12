package by.tms.utils;

import lombok.experimental.UtilityClass;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@UtilityClass
public class StreamApiClass {

    public static void printListMultiplyByNumber(List list, int number) {
        Stream<Integer> stream = list.stream();
        stream.forEach(x -> System.out.println(x * number));
    }

    public static void printEvenNumbersAndPrintThem(Set<Integer> set, int numbers) {
        Random random = new Random();
        for (int i = 0; i < numbers; i++) {
            set.add(random.nextInt(101));
        }
        Stream<Integer> stream = set.stream();
        long count = stream.filter(x -> x % 2 == 0)
                .count();
        System.out.println("число четных чисел составило " + count);
        Stream<Integer> stream1 = set.stream();
        stream1.filter(x -> x % 2 == 0).forEach(x -> System.out.println(x));
    }

    public static void printListObjectWithCapitalLetter(List<String> list) {
        Stream<String> stream = list.stream();
        stream.forEach(x -> System.out.println(x.substring(0, 1).toUpperCase() + x.substring(1)));
    }

    public static void printAllNumbersOfCarThatNewerThan(List<Car> list, int year) {
        Stream<Car> stream = list.stream();
        stream.filter(s -> s.getNumber() != null && s.getNumber() != "" && s.getYear() > year)
                .forEach(s -> System.out.println(s.getNumber()));
    }

    public static Optional<String> getOptionalStringOfSurnamesThatStartFromLetter(List<Person> list, String letter) {
        Stream<Person> stream = list.stream();
        Optional<String> optional = stream.filter(s -> s.getSurname().substring(0, 1).equalsIgnoreCase("Д")).map(x -> x.getSurname()).reduce((x, y) -> x + " " + y);
        return optional;
    }

    public static void printNumberOfpeopleThatSurnnameFirstLetterStart(List<Person> list) {
        Map<String, Long> map = list.stream().map(Person::getSurname)
                .collect(Collectors.groupingBy(x -> x.substring(0, 1), Collectors.counting()));
        for (Map.Entry<String, Long> str : map.entrySet()) {
            System.out.println("На букву " + str.getKey() + " - " + str.getValue() + " фамилии");
        }
    }
}