package by.tms.service;

import by.tms.module.Number;
import by.tms.module.*;

public class MainGenerics {
    public static void main(String[] args) {
        GenericClass object = new GenericClass<>("123", new Animal("тигр", 100), new Number(9, "девять"));
        object.getClassOfParametrs();
        System.out.println(object.toString());
        MinMax<Integer> mas = new MinMax<>(new Integer[]{1, 3, 0, 2});
        mas.getInformationAboutObject();
        MinMax<Double> mas2 = new MinMax<>(new Double[]{1.0, 3.0, 0.0, 2.0});
        mas2.getInformationAboutObject();
        MinMax<String> mas3 = new MinMax<>(new String[]{"123", "521", "678", "2.0"});
        mas3.getInformationAboutObject();
        System.out.println(Calculator.divide(25.5, 5.1));
        System.out.println(Calculator.multiply(3, 5.15));
        System.out.println(Calculator.sum(3, 5.15));
    }
}
