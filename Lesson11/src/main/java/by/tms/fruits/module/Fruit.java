package by.tms.fruits.module;

import lombok.Getter;

@Getter
public abstract class Fruit {
    private double weight;

    public Fruit(double weight) {
        this.weight = weight;
    }

    private final void printManufacturerInfo() {
        System.out.println("Made in Belarus");
    }

    abstract double calculateCostOfFruit();
}
