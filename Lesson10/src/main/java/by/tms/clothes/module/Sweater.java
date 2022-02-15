package by.tms.clothes.module;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sweater implements Jacket {
    private int price;

    @Override
    public void putOn() {
        System.out.println("надеваем cвитер");
    }

    @Override
    public void takeOff() {
        System.out.println("снимаем cвитер");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
