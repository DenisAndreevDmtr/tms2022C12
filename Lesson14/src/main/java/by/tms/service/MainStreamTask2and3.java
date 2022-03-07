package by.tms.service;

import by.tms.module.TextFormatter;

import java.io.File;

public class MainStreamTask2and3 {
    public static void main(String[] args) {
        //Выполнение задания2
        File fileInPut = new File("C://Users//User//IdeaProjects//tms2022C12//Lesson14//src//main//resources//input2.txt");
        TextFormatter.readAndGetInformationFromTxtFile(fileInPut);
        String resultTask2 = TextFormatter.readAndGetInformationFromTxtFile(fileInPut);
        File fileOutPut = new File("C://Users//User//IdeaProjects//tms2022C12//Lesson14//src//main//resources//output2.txt");
        System.out.println("Записываем информацию в новый лист");
        TextFormatter.writeSentensesFromOneLengthToAnotherOrSentensesWithPalindromes(resultTask2, fileOutPut, 3, 5);
        //Выполнение задания3
        File originalText = new File("C://Users//User//IdeaProjects//tms2022C12//Lesson14//src//main//resources//originaltext.txt");
        TextFormatter.readAndGetInformationFromTxtFile(originalText);
        String resultTask3 = TextFormatter.readAndGetInformationFromTxtFile(originalText);
        File shouldBeCorrectedSentenses = new File("C://Users//User//IdeaProjects//tms2022C12//Lesson14//src//main//resources//sentensesshouldbecorrected.txt");
        TextFormatter.checkTextHasBlackListWordsAndWriteSentencesThatShouldBeCorrected(resultTask3, shouldBeCorrectedSentenses);
    }
}
