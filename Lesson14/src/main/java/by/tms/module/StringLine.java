package by.tms.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class StringLine {

    private String stringName;

    // 1) Даны строки разной длины c четным числом символов(казаки, просмотреть и так далее),
    // *  необходимо вернуть ее два средних знака.
    //        * Например, если дана строка "string"  результат будет "ri", для строки "code" результат "od",  для "Practice" результат "ct".

    public String getTwoMiddleSymbols() {
        return stringName.substring(stringName.length() / 2 - 1, stringName.length() / 2 + 1);
    }

    //2) Дана строка "cab, ccab, cccab" Необходимо составить регулярное выражение, сделать класс Pattern, Matcher, вызвать метод find и вывести слова на консоль
    // * Должно вывести:
    //       * cab
    // * ccab
    // * cccab

    public void findMachers(String str) {
        Pattern pattern = Pattern.compile(str);
        Matcher matcher = pattern.matcher(stringName);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }

    // * 3) Дана строка "Versions: Java  5, Java 6, Java   7, Java 8, Java 12."  Найти все подстроки "Java X", где X - число и распечатать их.

    public void findVersions() {
        Pattern pattern = Pattern.compile("Java\\ *[1-9]*");
        Matcher matcher = pattern.matcher(stringName);
        while (matcher.find()) {
            System.out.println(matcher.group().replaceAll("[\\s]{2,}", " "));
        }
    }

    //* 4*)со звездочкой! Предложение состоит из нескольких слов, разделенных пробелами. Например: "One two three раз два три one1 two2 123 ".
    //           *  Найти количество слов, содержащих только символы латинского алфавита.
    public void splitSenteseTowords() {
        String[] mas = stringName.split("\\ |\\.|,");
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i].matches("[A-Za-z]+")) {
                System.out.println(mas[i]);
                count += 1;
            }
        }
        System.out.println("Количество слов содержащих только латинские сиволы " + count);
    }

    //*  5*)со звездочкой! В метод на вход приходит строка
    //*
    //        *  public static boolean validate(String str) {
    //    return false;
    //}
    // * Необходимо выполнить проверку на валидацию входящей строки и вернуть false или true
    //        * - Строка должна содержать только маленькие латинские буквы и цифры 1 или 5 без знака подчеркивания.
    // * - Длина строки должна быть от 4 до 20 символов.

    public boolean validate() {
        boolean flag = false;
        if (stringName.matches("[a-z1-5]{4,20}")) {
            flag = true;
        }
        return flag;
    }
}
