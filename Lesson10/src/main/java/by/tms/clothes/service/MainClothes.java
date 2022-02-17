package by.tms.clothes.service;

import by.tms.clothes.module.*;

public class MainClothes {
    public static void main(String[] args) {
        Person person1 = new Person("Иван", new Coat(5), new Trousers(5), new Sandals(5));
        Person person2 = new Person("Александр", new Sweater(3), new Jeans(4), new Sneakers(6));
        person1.actionPutOn();
        person1.actionPutOff();
        person2.actionPutOn();
        person2.actionPutOff();
    }
}
