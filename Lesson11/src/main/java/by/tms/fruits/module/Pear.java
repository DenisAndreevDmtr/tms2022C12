package by.tms.fruits.module;

import by.tms.fruits.utils.CostsOfKgFruits;
import lombok.Getter;

@Getter
public class Pear extends Fruit {

    public Pear(double weight) {
        super(weight);
    }

    @Override
    public double calculateCostOfFruit() {
        return getWeight() * CostsOfKgFruits.PEAR.getCost();
    }
}
