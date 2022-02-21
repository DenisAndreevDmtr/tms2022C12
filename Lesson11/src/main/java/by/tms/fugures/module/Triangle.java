package by.tms.fugures.module;


import by.tms.fugures.utils.GeometricObjects;
import lombok.Getter;

@Getter
public class Triangle extends Figures implements SqureAble {
    private double side1Length;
    private double side2Length;
    private double side3Length;
    private GeometricObjects name = GeometricObjects.TRIANGLE;

    public Triangle(double side1Length, double side2Length, double side3Length) {
        this.side1Length = side1Length;
        this.side2Length = side2Length;
        this.side3Length = side3Length;
    }

    @Override
    public double getSquare() {
        return Math.sqrt(getHalfPerimetr() * (getHalfPerimetr() - side1Length) * (getHalfPerimetr() - side2Length) * (getHalfPerimetr() - side3Length));
    }

    private double getHalfPerimetr() {
        return (side1Length + side2Length + side3Length) / 2;
    }
}
