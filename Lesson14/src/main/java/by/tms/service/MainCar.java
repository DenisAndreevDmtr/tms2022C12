package by.tms.service;

import by.tms.utils.*;

import java.io.File;
import java.math.BigDecimal;

public class MainCar {
    public static void main(String[] args) {
        //Выполнение задания 4
        Car car = new Car(
                "Audi",
                new Engine("U-образный", 2),
                new Tank("Бензиновый", 50),
                200,
                new BigDecimal(20000));
        File fileOutPutSerialize = new File("C://Users//User//IdeaProjects//tms2022C12//Lesson14//src//main//resources//outputserialize.dat");
        SerializateClass.serializateObject(car, fileOutPutSerialize);
        Car car2 = (Car) SerializateClass.deSerializateObject(fileOutPutSerialize);
        System.out.println(car2);
        //Выполнение задания 5
        CarAdditional.readAndWriteFromJson();
    }
}
