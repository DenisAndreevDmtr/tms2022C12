package by.tms.module;

import lombok.experimental.UtilityClass;

import java.io.File;

@UtilityClass
public class HelperFile {
    public static void printAllFilesAndFolders(File dir) {
        if (dir.isDirectory()) {
            System.out.println("Папка " + dir.getName() + " содежит:");
            for (File item : dir.listFiles()) {
                System.out.println(item.getName());
            }
            for (File item : dir.listFiles()) {
                if (item.isDirectory()) {
                    printAllFilesAndFolders(item);
                }
            }
        }
    }
}
