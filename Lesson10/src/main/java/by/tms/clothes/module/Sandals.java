package by.tms.clothes.module;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sandals implements Shoes {
    private int price;

    @Override
    public void putOn() {
        System.out.println("надеваем сандали");
    }

    @Override
    public void takeOff() {
        System.out.println("снимаем сандали");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
