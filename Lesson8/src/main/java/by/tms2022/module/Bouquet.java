package by.tms2022.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;


@Getter
@Setter
@AllArgsConstructor
public class Bouquet {
    private ArrayList<Flower> flowers;

    public int priceOfBouquet() {
        int price = 0;
        for (int i = 0; i < flowers.size(); i++) {
            price += flowers.get(i).getPrice();
        }
        return price;
    }

    public int getCountFLowersInBouquet() {
        return flowers.size();
    }

}
