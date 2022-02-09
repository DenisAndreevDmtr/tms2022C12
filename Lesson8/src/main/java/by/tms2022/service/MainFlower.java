package by.tms2022.service;

import by.tms2022.module.Bouquet;
import by.tms2022.module.FlowerMarket;

import java.util.ArrayList;

public class MainFlower {
    public static void main(String[] args) throws Exception {
        FlowerMarket flowerMarket = new FlowerMarket(new ArrayList<>());
        Bouquet first = flowerMarket.getBouquet("ROSE", "LILY", "ASTER", "TULIP", "CARNATION", "HERBERA");
        Bouquet second = flowerMarket.getBouquet("ROSE", "LILY", "ASTER", "HERBERA");
        Bouquet third = flowerMarket.getBouquet("ROSE", "LILY", "CARNATION", "ROSE");
        Bouquet forth = flowerMarket.getBouquet("ROSE", "LILY", "ROSE");
        Bouquet fives = flowerMarket.getBouquet("ROSE", "LILY", "LILY", "ASTER", "ASTER");

        for (int i = 0; i < flowerMarket.getBouquets().size(); i++) {
            Bouquet current = flowerMarket.getBouquets().get(i);
            System.out.println("цена букета " + current.priceOfBouquet());
            for (int j = 0; j < current.getFlowers().size(); j++) {
                System.out.println(current.getFlowers().get(j).toString());
            }
            System.out.println("количество цветов в букете " + current.getCountFLowersInBouquet());
            System.out.println("-----------------------");
        }
        System.out.println("всего цветов " + flowerMarket.getCountFlowers());
    }
}
