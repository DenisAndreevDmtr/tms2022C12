package by.tms.utils;

import java.util.ArrayList;

public enum BlackList {
    BADWORD, ПЛОХОЕСЛОВО;

    public static ArrayList<String> getBlackListWords() {
        BlackList[] words = BlackList.values();
        ArrayList<String> blackListWords = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            blackListWords.add(words[i].toString());
        }
        return blackListWords;
    }

}
