package eshop.model;

import java.util.ArrayList;
import java.util.List;

public class CartStorage {
    private static List<Product> productsInCart = new ArrayList<>();

    public static List<Product> getProductsInCart() {
        return productsInCart;
    }

    public static void setProductsInCart(List<Product> productsInCart) {
        CartStorage.productsInCart = productsInCart;
    }
}
