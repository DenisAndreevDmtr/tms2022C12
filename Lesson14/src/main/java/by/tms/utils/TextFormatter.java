package by.tms.utils;

import lombok.experimental.UtilityClass;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


@UtilityClass
public class TextFormatter {

    public static String readAndGetInformationFromTxtFile(File file) {
        String returnString = new String();
        try {
            List<String> stringList = FileUtils.readLines(file, "UTF-8");
            for (int i = 0; i < stringList.size(); i++) {

                returnString = returnString + stringList.get(i);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
        return returnString;
    }

    public static void writeSentensesFromOneLengthToAnotherOrSentensesWithPalindromes(String Text, File file, int startLength, int finishLength) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            PrintStream printStream = new PrintStream(fos);
            String[] sentenses = splitTextToSentence(Text);
            for (int i = 0; i < sentenses.length; i++) {
                String[] words = splitSentenceToWords(sentenses[i]);
                if (words.length >= startLength && words.length <= finishLength || checkSentenceHasPalindromes(words)) {
                    printStream.println(sentenses[i].trim());
                }
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }

    private static String[] splitTextToSentence(String text) {
        String[] subStr;
        subStr = text.split("\\.|\\?|!");
        return subStr;
    }

    private static String[] splitSentenceToWords(String text) {
        String[] subStr;
        subStr = text.split(" ");
        return subStr;
    }

    private static boolean checkSentenceHasPalindromes(String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (checkPalindromes(words[i])) {
                return true;
            }
        }
        return false;
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

    private static boolean checkWordIsBlackListWord(String string) {
        ArrayList<String> blackListWords = BlackList.getBlackListWords();
        return blackListWords.contains(string.toUpperCase());
    }

    private static boolean checkSentenseHasBlackListWord(String sentence) {
        String[] words = splitSentenceToWords(sentence);
        for (int i = 0; i < words.length; i++) {
            if (checkWordIsBlackListWord(words[i])) {
                return true;
            }
        }
        return false;
    }

    public static void checkTextHasBlackListWordsAndWriteSentencesThatShouldBeCorrected(String Text, File file) {
        try (FileOutputStream fos = new FileOutputStream(file)) {
            PrintStream printStream = new PrintStream(fos);
            String[] sentenses = splitTextToSentence(Text);
            int count = 0;
            for (int i = 0; i < sentenses.length; i++) {
                if (checkSentenseHasBlackListWord(sentenses[i])) {
                    printStream.println(sentenses[i]);
                    count += 1;
                }
            }
            if (count > 0) {
                System.out.println("Найдено " + count + " предложений,  которые должны быть скорректированы");
            } else {
                System.out.println("Запрещенных слов в тексте нет");
            }

        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
