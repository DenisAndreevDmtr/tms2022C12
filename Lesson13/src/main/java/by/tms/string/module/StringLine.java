package by.tms.string.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StringLine {

    private String stringName;

    //1) Вырезать подстроку из строки начиная с первого вхождения символа(А) до, последнего вхождения сивола(B).
    public String cutStringfromOneCharToAnotherChalWithLastIndex(String start, String end) {
        int firstIndex = stringName.indexOf(start);
        int lastIndex = stringName.lastIndexOf(end);
        return stringName.substring(firstIndex, lastIndex + 1);
    }

    //2) Заменить все вхождения символа стоящего в позиции (3) на символ стоящий в позиции 0
    public String replaceALLSymbolsAtPossitionOneToSymbolsatPossitionAnother(int possitionOne, int possitionAnother) {
        char one = stringName.charAt(possitionOne);
        char another = stringName.charAt(possitionAnother);
        return stringName.replace(one, another);
    }

    //  4) Есть строка в которой содержится текст, предложения разделены точками.
    //       * После запуска программы на экран должны выводиться только те предложения в которых от 3-х до 5-ти слов.
    //       * Если в предложении присутствует слово-палиндром, то не имеет значения какое количество слов в предложении, оно выводится на экран.
    //        * Пишем все в ООП стиле.
    // * 1. Метод принимает строку и возвращает кол-во слов в строке.
    //        * 2. Метод принимает строку и проверяет есть ли в строке слово-палиндром. Если есть возвращает true, если нет false
    //        * В main создаем строку с текстом, также можно текст задавать с консоли.
    // * Разбиваем текст на предложения. Используя методы класса TextFormatter определяем подходит ли нам предложение.
    // * Если подходит, то выводим на экран.

    private String[] splitStringToSentenses() {
        String delimeter = "\\. ";
        String[] subStr;
        subStr = stringName.split(delimeter);
        return subStr;
    }

    public void printSententensesFromOneNumberToAnotherNumberWordsAndPalindromes(int startNumber, int endNumber) {
        String[] masForPrint = splitStringToSentenses();
        String delimeter = "\\ ";
        String[] subStr;
        for (int i = 0; i < masForPrint.length; i++) {
            subStr = masForPrint[i].split(delimeter);
            if (subStr.length >= startNumber && subStr.length <= endNumber) {
                System.out.println(masForPrint[i]);
            }
            if (checkSentenceHasPalindromes(subStr)) {
                System.out.println(masForPrint[i]);
            }
        }
    }

    private boolean checkSentenceHasPalindromes(String[] mas) {
        boolean flag = false;
        for (int j = 0; j < mas.length; j++) {
            if (checkPalindromes(mas[j])) {
                flag = true;
            }
        }
        return flag;
    }


    private boolean checkPalindromes(String checkString) {
        boolean flag = false;
        StringBuilder stringBuilder = new StringBuilder(checkString);
        StringBuilder reverseStr = stringBuilder.reverse();
        if (checkString.equalsIgnoreCase(reverseStr.toString()) && checkString.length() >= 2) {
            flag = true;
        }
        return flag;
    }

    //5)Даны строки разной длины (длина - четное число), необходимо вернуть ее два средних знака:
    public String getTwoMiddleSymbols() {
        char middle1 = stringName.charAt(stringName.length() / 2 - 1);
        char middle2 = stringName.charAt(stringName.length() / 2);
        return Character.toString(middle1) + Character.toString(middle2);
    }

    //7)Найти количество слов, содержащих только символы латинского алфавита.
    public String countLatinWords() {
        int count = 0;
        String[] str = stringName.split(",|—|\\(|\\)|\\.|\\ ");
        for (int i = 0; i < str.length; i++) {
            if (str[i].matches("^[a-zA-Z]+$")) {
                count += 1;
            }
        }
        return "Количество слов, содержащих только символы латинского алфавита " + count;
    }
}


