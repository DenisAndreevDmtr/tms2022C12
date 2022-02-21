package by.tms.fugures.module;

import by.tms.fugures.utils.GeometricObjects;
import lombok.Getter;

@Getter
public class Line extends Figures {
    private double length;
    private GeometricObjects name = GeometricObjects.LINE;

    public Line(double length) {
        this.length = length;
    }
}
