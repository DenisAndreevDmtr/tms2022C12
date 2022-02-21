package by.tms.fugures.service;

import by.tms.fugures.module.Figures;
import by.tms.fugures.module.Line;
import by.tms.fugures.module.Rectangle;
import by.tms.fugures.module.Triangle;
import by.tms.fugures.utils.GeometricObjects;

public class MainFigure {
    public static void main(String[] args) {
        Figures[] figures = new Figures[3];
        figures[0] = new Line(5.0);
        figures[1] = new Triangle(2.0, 3.0, 4.0);
        figures[2] = new Rectangle(3.0, 5.0);

        for (int i = 0; i < figures.length; i++) {
            if (figures[i].getName() == GeometricObjects.RECTANGELE) {
                System.out.println("площадь прямоугольника равна " + ((Rectangle) figures[i]).getSquare());
            } else if (figures[i].getName() == GeometricObjects.TRIANGLE) {
                System.out.println("площадь треугольника равна " + ((Triangle) figures[i]).getSquare());
            } else {
                System.out.println("площадь фигуры не вычисляется");
            }
        }
    }
}
