package by.tms.fruits.module;

import by.tms.fruits.utils.CostsOfKgFruits;
import lombok.Getter;

@Getter
public class Apriсot extends Fruit {

    public Apriсot(double weight) {
        super(weight);
    }

    @Override
    public double calculateCostOfFruit() {
        return getWeight() * CostsOfKgFruits.APRICOT.getCost();
    }
}
