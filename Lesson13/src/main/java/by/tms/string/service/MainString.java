package by.tms.string.service;

import by.tms.string.module.StringLine;
import by.tms.string.module.StringMas;

public class MainString {
    public static void main(String[] args) {
        StringLine stringTask1 = new StringLine("11abc12abf4");
        System.out.println(stringTask1.cutStringfromOneCharToAnotherChalWithLastIndex("a", "b"));
        StringLine stringTask2 = new StringLine("abcdabcdabcd");
        System.out.println(stringTask2.replaceALLSymbolsAtPossitionOneToSymbolsatPossitionAnother(3, 0));
        StringMas stringTask3 = new StringMas(new StringLine[]{
                new StringLine("дед"),
                new StringLine("мопед"),
                new StringLine("заказ"),
                new StringLine("велосипед"),
                new StringLine("казак")

        });
        System.out.println(stringTask3.getAllPalindromes());
        StringLine stringTask4 = new StringLine("Привет. На улице весна. Тепло и очень хорошо. Потоп. Хорошего всем настроения и здоровья вашей семье.");
        stringTask4.printSententensesFromOneNumberToAnotherNumberWordsAndPalindromes(3, 5);
        StringLine stringTask5 = new StringLine("string");
        System.out.println(stringTask5.getTwoMiddleSymbols());
        StringLine stringTask7 = new StringLine("Методы доступа называют ещё аксессорами (от англ. access — доступ), или по отдельности — геттерами (англ. get — чтение) and сеттерами (англ. set — запись)" +
                "" +
                "");
        System.out.println(stringTask7.countLatinWords());
    }
}
