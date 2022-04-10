package by.tms.service;

import by.tms.utils.StringLine;

public class MainString {
    public static void main(String[] args) {
        StringLine stringTask1 = new StringLine("Practice");
        System.out.println(stringTask1.getTwoMiddleSymbols());
        StringLine stringTask2 = new StringLine("cab, ccab, cccab, ccc, ccccccab");
        stringTask2.findMachers("c+.b");
        StringLine stringTask3 = new StringLine("Versions: Java  5, Java 6, Java   7, Java 8, Java 12.");
        stringTask3.findVersions();
        StringLine stringTask4 = new StringLine("One, two. three раз два три one1 two2 123");
        stringTask4.splitSenteseTowords();
        StringLine stringTask5 = new StringLine("g2de1ag5");
        System.out.println(stringTask5.validate());
    }
}
