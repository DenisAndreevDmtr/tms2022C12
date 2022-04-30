package eshop.model;

import java.util.Arrays;
import java.util.List;

public class CategoriesStorage {
    private static List<Category> categories = Arrays.asList(
            new Category(1, "Mobile phones", "mobile.jpg", "/mobiles"),
            new Category(2, "Laptops", "laptop.jpg", "/laptops"),
            new Category(3, "GPS Navigators", "jps_nav.jpg", "/navigators"),
            new Category(4, "Fridges", "fridge.jpg", "/fridges"),
            new Category(5, "Cars", "car.jpg", "/cars"),
            new Category(6, "Cameras", "camera.jpg", "/cameras")
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
