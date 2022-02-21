package by.tms.seasons.utils;

import by.tms.seasons.module.Seasons;

public class Helper {
    public static void IloveSeason(Seasons season) {
        String ilove = "I love ";
        switch (season) {
            case AUTUMN -> {
                System.out.println(ilove + season.name() + ". Осенью красивая листва ");
            }
            case SPRING -> {
                System.out.println(ilove + season.name() + ". Весной все оживает");
            }
            case SUMMER -> {
                System.out.println(ilove + season.name() + ". Летом можно купаться");
            }
            case WINTER -> {
                System.out.println(ilove + season.name() + ". Зимой можно кататься на лыжах");
            }
            default -> {
                break;
            }
        }
    }


}
