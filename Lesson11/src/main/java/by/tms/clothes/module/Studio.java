package by.tms.clothes.module;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Studio {
    public static void putOnMan(Clothes[] clothes) {
        System.out.println("Из всего гардероба мужская одежда: ");
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i] instanceof MensClothes) {
                System.out.println(clothes[i].toString());
            }
        }
    }

    public static void putOnWoman(Clothes[] clothes) {
        System.out.println("Из всего гардероба женская одежда: ");
        for (int i = 0; i < clothes.length; i++) {
            if (clothes[i] instanceof WomensClothes) {
                System.out.println(clothes[i].toString());
            }
        }
    }
}