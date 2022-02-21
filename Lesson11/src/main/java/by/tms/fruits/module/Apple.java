package by.tms.fruits.module;

import by.tms.fruits.utils.CostsOfKgFruits;

public class Apple extends Fruit {
    public Apple(double weight) {
        super(weight);
    }

    @Override
    public double calculateCostOfFruit() {
        return getWeight() * CostsOfKgFruits.APPLE.getCost();
    }
}
