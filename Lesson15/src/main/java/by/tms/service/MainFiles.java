package by.tms.service;

import by.tms.utils.HelperFile;

import java.io.File;

public class MainFiles {
    public static void main(String[] args) {
        File dir = new File("C://Users//User//IdeaProjects//tms2022C12//Lesson15//src//main//resources//folder123");
        HelperFile.printAllFilesAndFolders(dir);
    }
}
