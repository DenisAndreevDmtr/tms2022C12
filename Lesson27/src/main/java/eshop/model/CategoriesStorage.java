package eshop.model;

import java.util.Arrays;
import java.util.List;

public class CategoriesStorage {
    private static List<Category> categories = Arrays.asList(
            new Category(1, "Mobile phones", "mobile.jpg"),
            new Category(2, "Laptops", "laptop.jpg"),
            new Category(3, "GPS Navigators", "jps_nav.jpg"),
            new Category(4, "Fridges", "fridge.jpg"),
            new Category(5, "Cars", "car.jpg"),
            new Category(6, "Cameras", "camera.jpg")
    );

    public static List<Category> getCategories() {
        return categories;
    }

    public static String getCategoryNameById(int id) {
        for (Category c : categories) {
            if (c.getId() == id) {
                return c.getName();
            }
        }
        return "";
    }
}
