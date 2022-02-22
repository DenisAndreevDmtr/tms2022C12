package by.tms.car.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Random;

@AllArgsConstructor
@Getter
@Setter
public class Car {
    private String mark;
    private int speed;
    private BigDecimal price;

    public Car() {
    }

    public void startCar() throws CarCantStartException {
        Random random = new Random();
        if (random.nextInt(21) % 2 == 0) {
            System.out.println("Машина марки " + mark + " успешно завелась");
        } else {
            throw new CarCantStartException("Машина марки " + mark + " не завелась");
        }
    }

    public class CarCantStartException extends Exception {
        public CarCantStartException(String message) {
            super(message);
        }
    }

}
