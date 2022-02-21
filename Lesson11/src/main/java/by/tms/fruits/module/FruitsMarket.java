package by.tms.fruits.module;

public class FruitsMarket {
    public static String calculateCostOfAllFruits(Fruit... fruits) {
        double cost = 0;
        for (int i = 0; i < fruits.length; i++) {
            cost += fruits[i].calculateCostOfFruit();
        }
        return "Цена всех фруктов равна " + cost;
    }

    public static String calculateCostOfFruitsByTypes(Fruit... fruits) {
        double[] mas = new double[3];
        for (int i = 0; i < fruits.length; i++) {
            if (fruits[i] instanceof Apple) {
                mas[0] += fruits[i].calculateCostOfFruit();
            } else if (fruits[i] instanceof Apriсot) {
                mas[1] += fruits[i].calculateCostOfFruit();
            } else {
                mas[2] += fruits[i].calculateCostOfFruit();
            }
        }
        return "Цена фруктов типа яблоко равна " + mas[0] + ", цена фруктов типа абрикос равна " + mas[1] + ", цена фруктов типа груша равна " + mas[2];
    }

}
