package by.tms.fugures.module;

import by.tms.fugures.utils.GeometricObjects;
import lombok.Getter;

@Getter
public class Rectangle extends Figures implements SqureAble {
    private double length;
    private double width;
    private GeometricObjects name = GeometricObjects.RECTANGELE;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double getSquare() {
        return length * width;
    }

}
