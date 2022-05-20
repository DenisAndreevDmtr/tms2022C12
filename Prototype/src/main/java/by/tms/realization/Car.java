package by.tms.realization;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Car {
    private int wheels;
    private int doors;
    private int price;

    public Car() {
    }

    public Car(Car car) {
        if (car != null) {
            this.wheels = car.wheels;
            this.doors = car.doors;
            this.price = car.price;
        }
    }

    public Car(int wheels, int doors, int price) {
        this.wheels = wheels;
        this.doors = doors;
        this.price = price;
    }

    public abstract Car copy();
}
