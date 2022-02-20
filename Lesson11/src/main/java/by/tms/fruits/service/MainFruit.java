package by.tms.fruits.service;

import by.tms.fruits.module.*;

public class MainFruit {
    public static void main(String[] args) {
        Fruit[] fruits = new Fruit[6];
        fruits[0] = new Apple(0.9);
        fruits[1] = new Apriсot(3.8);
        fruits[2] = new Pear(1.2);
        fruits[3] = new Apple(1.1);
        fruits[4] = new Apriсot(4.7);
        fruits[5] = new Pear(0.7);
        System.out.println(FruitsMarket.calculateCostOfAllFruits(fruits));
        System.out.println(FruitsMarket.calculateCostOfFruitsByTypes(fruits));
    }
}
