package by.tms2022.module;

import by.tms2022.util.FlowerConstants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
public class FlowerMarket {
    private ArrayList<Bouquet> bouquets;

    public Bouquet getBouquet(String... flowers) {
        Bouquet current = new Bouquet(new ArrayList<>());
        for (int i = 0; i < flowers.length; i++) {
            Flower flower = new Flower(flowers[i], getCost(flowers[i]));
            current.getFlowers().add(flower);
        }
        bouquets.add(current);
        return current;
    }

    public int getCost(String flower) {
        int cost = 0;
        for (int i = 0; i < FlowerConstants.INFO_FLOWER.length; i++) {
            if (flower.equals(FlowerConstants.INFO_FLOWER[i][0])) {
                cost = Integer.parseInt(FlowerConstants.INFO_FLOWER[i][1]);
                break;
            }
        }
        return cost;
    }

    public int getCountFlowers() {
        int count = 0;
        for (int i = 0; i < bouquets.size(); i++) {
            count = count + bouquets.get(i).getFlowers().size();
        }
        return count;
    }
}
