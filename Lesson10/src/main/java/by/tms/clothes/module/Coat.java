package by.tms.clothes.module;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Coat implements Jacket {
    private int price;

    @Override
    public void putOn() {
        System.out.println("надеваем пальто");
    }

    @Override
    public void takeOff() {
        System.out.println("снимаем пальто");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
