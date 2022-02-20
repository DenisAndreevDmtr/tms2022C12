package by.tms.clothes.service;

import by.tms.clothes.module.*;

public class MainClothes {
    public static void main(String[] args) {
        Clothes[] clothes = new Clothes[4];
        clothes[0] = new Tshirt(Size.M, 5, "Красный");
        clothes[1] = new Trousers(Size.L, 10, "Черные");
        clothes[2] = new Skirt(Size.XS, 4, "Желтая");
        clothes[3] = new Tie(Size.XXS, 1, "Cиний");
        Studio.putOnMan(clothes);
        System.out.println("________");
        Studio.putOnWoman(clothes);
    }
}
