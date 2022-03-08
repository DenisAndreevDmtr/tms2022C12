package by.tms.service;


import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class MainStreamTask1 {

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        System.out.println("Считываем информация с тестового документа input1.txt");
        try {
            File file = new File("C://Users//User//IdeaProjects//tms2022C12//Lesson14//src//main//resources//input1.txt");
            stringList = FileUtils.readLines(file, "UTF-8");
            for (int i = 0; i < stringList.size(); i++) {
                System.out.println(stringList.get(i));
            }
            stringList.size();
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        System.out.println("Записываем слова палиндромы в новый текстовый документ");
        try (FileOutputStream fos = new FileOutputStream("C://Users//User//IdeaProjects//tms2022C12//Lesson14//src//main//resources//output1.txt")) {
            PrintStream printStream = new PrintStream(fos);
            for (int i = 0; i < stringList.size(); i++) {
                if (checkPalindromes(stringList.get(i))) {
                    printStream.println(stringList.get(i));
                }
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static boolean checkPalindromes(String checkString) {
        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder(checkString);
        StringBuilder reverseStr = stringBuilder.reverse();
        if (checkString.equalsIgnoreCase(reverseStr.toString()) && checkString.length() >= 2) {
            flag = true;
        }
        return flag;
    }

}