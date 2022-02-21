package by.tms.clothes.module;

import lombok.Getter;

@Getter
public class Skirt extends Clothes implements WomensClothes {

    public Skirt(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void putOnWoman() {
        System.out.println("Женщина надела юбку");
    }

    @Override
    public String toString() {
        return "Юбка: размер: " + getSize() + " цена:" + getPrice() + " цвет:" + getColor();
    }
}
