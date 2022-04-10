package by.tms.utils;

import java.lang.Number;

public class Calculator {

    public static <V extends Number, T extends Number> Double sum(T a, V b) {
        return a.doubleValue() + b.doubleValue();
    }

    public static <V extends Number, T extends Number> Double multiply(T a, V b) {
        return a.doubleValue() * b.doubleValue();
    }

    public static <V extends Number, T extends Number> Double divide(T a, V b) {
        return a.doubleValue() / b.doubleValue();
    }
}
