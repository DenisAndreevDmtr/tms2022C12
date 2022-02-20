package by.tms.fruits.utils;

import lombok.Getter;

@Getter
public enum CostsOfKgFruits {
    APPLE(10), APRICOT(20), PEAR(15);

    private int cost;

    CostsOfKgFruits(int cost) {
        this.cost = cost;
    }
}
