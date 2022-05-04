package eshop.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class ProductsStorage {
    private static List<Product> products = Arrays.asList(
            new Product("Canon", "camera1.jpg", "Good camera", new BigDecimal(200), 6),
            new Product("Nikon", "camera2.jpg", "Very good camera", new BigDecimal(250), 6),
            new Product("BMW", "car1.jpg", "Good car", new BigDecimal(2300), 5),
            new Product("Nissan", "car2.jpg", "Very good car", new BigDecimal(2450), 5),
            new Product("LG", "fridge1.jpg", "Good fridge", new BigDecimal(900), 4),
            new Product("SAMSUNG", "fridge2.jpg", "Very good fridge", new BigDecimal(1050), 4),
            new Product("HP", "laptop1.png", "Good laptop", new BigDecimal(800), 2),
            new Product("DELL", "laptop2.jpg", "Very good laptop", new BigDecimal(950), 2),
            new Product("HTC", "mobile1.jpg", "Good mobile phone", new BigDecimal(500), 1),
            new Product("ZTE", "mobile2.jpg", "Very good mobile phone", new BigDecimal(550), 1),
            new Product("Navitel", "navigator1.jpg", "Good navigator", new BigDecimal(300), 3),
            new Product("Prestigio", "navigator2.jpg", "Very good navigator", new BigDecimal(450), 3)
    );

    public static List<Product> getProducts() {
        return products;
    }
}
