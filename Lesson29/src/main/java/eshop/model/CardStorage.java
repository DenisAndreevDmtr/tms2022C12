package eshop.model;

import java.util.ArrayList;
import java.util.List;

public class CardStorage {
    private static List<Product> productsInCard = new ArrayList<>();

    public static List<Product> getProductsInCard() {
        return productsInCard;
    }

    public static void setProductsInCard(List<Product> productsInCard) {
        CardStorage.productsInCard = productsInCard;
    }
}
