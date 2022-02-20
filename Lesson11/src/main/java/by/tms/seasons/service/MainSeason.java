package by.tms.seasons.service;

import by.tms.seasons.module.Seasons;
import by.tms.seasons.utils.Helper;

public class MainSeason {
    public static void main(String[] args) {
        Seasons myFavoriteSeason = Seasons.SUMMER;
        System.out.println("Моя любимая пора года это " + myFavoriteSeason.name());
        Seasons[] seasons = Seasons.values();
        for (int i = 0; i < seasons.length; i++) {
            Helper.IloveSeason(seasons[i]);
            System.out.println(seasons[i].getDiscription());
        }
    }
}
