package by.tms.realization;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class EconomCar extends Car {
    private boolean luggageBoot;

    public EconomCar() {
    }

    public EconomCar(EconomCar car) {
        super(car);
    }

    public EconomCar(int wheels, int doors, int price) {
        super(wheels, doors, price);
    }


    public EconomCar(EconomCar car, boolean luggageBoot) {
        super(car);
        if (car != null) {
            this.luggageBoot = luggageBoot;
        }
    }

    @Override
    public Car copy() {
        return new EconomCar(this);
    }

    @Override
    public String toString() {
        return "EconomCar{" +
                " luggageBoot=" + luggageBoot +
                " price=" + super.getPrice() +
                " doors=" + super.getDoors() +
                " wheels=" + super.getWheels() +
                '}';
    }

}


