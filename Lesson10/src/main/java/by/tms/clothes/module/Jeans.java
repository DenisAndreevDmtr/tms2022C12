package by.tms.clothes.module;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Jeans implements Pants {
    private int price;

    @Override
    public void putOn() {
        System.out.println("одеваем джинсы");
    }

    @Override
    public void takeOff() {
        System.out.println("снимаем джинсы");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
