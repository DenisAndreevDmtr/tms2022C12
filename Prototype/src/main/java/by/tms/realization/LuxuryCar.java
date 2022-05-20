package by.tms.realization;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class LuxuryCar extends Car {
    private boolean cabriolet;

    public LuxuryCar() {
    }

    public LuxuryCar(LuxuryCar car) {
        super(car);
    }

    public LuxuryCar(int wheels, int doors, int price) {
        super(wheels, doors, price);
    }

    public LuxuryCar(LuxuryCar car, boolean cabriolet) {
        super(car);
        if (car != null) {
            this.cabriolet = cabriolet;
        }
    }


    @Override
    public Car copy() {
        return new LuxuryCar(this);
    }

    @Override
    public String toString() {
        return "LuxuryCar{" +
                " cabriolet=" + cabriolet +
                " price=" + super.getPrice() +
                " doors=" + super.getDoors() +
                " wheels=" + super.getWheels() +
                '}';
    }
}


