package by.tms.clothes.module;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Sneakers implements Shoes {

    private int price;

    @Override
    public void putOn() {
        System.out.println("надеваем кросовки");
    }

    @Override
    public void takeOff() {
        System.out.println("снимаем кросовки");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
