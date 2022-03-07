package by.tms.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Car implements Serializable {
    private String mark;
    private Engine engine;
    private Tank tank;
    private int speed;
    private BigDecimal price;

    @Override
    public String toString() {
        return "Car{" +
                "mark=" + mark +
                ", engine:" + " тип двигателя=" + engine.getType() + ", количество цилиндров=" + engine.getNumberOfCylinders() +
                ", tank:" + " тип топлива=" + tank.getFuelType() + ", объем топливного бака=" + tank.getVolume() +
                ", speed=" + speed +
                ", price=" + price +
                '}';
    }
}
