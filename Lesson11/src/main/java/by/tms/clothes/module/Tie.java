package by.tms.clothes.module;

import lombok.Getter;

@Getter
public class Tie extends Clothes implements MensClothes {

    public Tie(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void putOnMan() {
        System.out.println("Мужчина надел галстук");
    }

    @Override
    public String toString() {
        return "Галстук: размер: " + getSize() + " цена:" + getPrice() + " цвет:" + getColor();
    }
}
