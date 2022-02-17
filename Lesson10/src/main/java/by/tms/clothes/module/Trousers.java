package by.tms.clothes.module;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Trousers implements Pants {
    private int price;

    @Override
    public void putOn() {
        System.out.println("надеваем брюки");
    }

    @Override
    public void takeOff() {
        System.out.println("снимаем брюки");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
