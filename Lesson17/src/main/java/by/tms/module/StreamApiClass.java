package by.tms.module;

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
        for (int i = 0; i < numbers - 1; i++) {
            set.add(random.nextInt(101));
        }
        Stream<Integer> stream = set.stream();
        List<Integer> list = stream.filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
        list.forEach(x -> System.out.println(x));
        System.out.println("Количество четных чисел в списке " + list.size());
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
        Stream<Person> stream = list.stream();
        List<String> surnamesFirstLetter = stream.map(x -> x.getSurname().substring(0, 1)).collect(Collectors.toList());
        HashMap<String, Integer> unicFirstLetters = new HashMap<>();
        for (int i = 0; i < surnamesFirstLetter.size(); i++) {
            unicFirstLetters.put(surnamesFirstLetter.get(i), unicFirstLetters.getOrDefault(surnamesFirstLetter.get(i), 0) + 1);
        }
        for (Map.Entry entry : unicFirstLetters.entrySet()) {
            System.out.println("Буква " + entry + " сотрудника");
        }
    }
}