package by.tms.car.service;

import by.tms.car.module.Car;

import java.math.BigDecimal;

public class MainCar {
    public static void main(String[] args) {
        Car car1 = new Car("Audi", 220, new BigDecimal(30000));
        Car car2 = new Car("BMW", 230, new BigDecimal(40000));
        try {
            car1.startCar();
        } catch (Car.CarCantStartException e) {
            System.out.println(e.getMessage());
        }
        try {
            car2.startCar();
        } catch (Car.CarCantStartException e) {
            System.out.println(e.getMessage());
        }

    }
}
