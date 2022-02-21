package by.tms.clothes.module;

import lombok.Getter;

@Getter
public class Trousers extends Clothes implements MensClothes, WomensClothes {

    public Trousers(Size size, int price, String color) {
        super(size, price, color);
    }

    @Override
    public void putOnMan() {
        System.out.println("Мужчина надел штаны");
    }

    @Override
    public void putOnWoman() {
        System.out.println("Женщина надела штаны");
    }

    @Override
    public String toString() {
        return "Брюки: размер: " + getSize() + " цена:" + getPrice() + " цвет:" + getColor();
    }
}
