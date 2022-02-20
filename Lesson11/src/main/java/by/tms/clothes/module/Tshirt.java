package by.tms.clothes.module;

import lombok.Getter;

@Getter
public class Tshirt extends Clothes implements MensClothes, WomensClothes {

    public Tshirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void putOnMan() {
        System.out.println("Мужчина надел футболку");
    }

    @Override
    public void putOnWoman() {
        System.out.println("Женщина надела футболку");
    }

    @Override
    public String toString() {
        return "Футболка: размер: " + getSize() + " цена:" + getPrice() + " цвет:" + getColor();
    }
}
