package by.teachmeskills.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String imageName;
    private String description;
    private BigDecimal price;
    private int idCategory;

    public Product(String name, String imageName, String description, BigDecimal price, int idCategory) {
        this.name = name;
        this.imageName = imageName;
        this.description = description;
        this.price = price;
        this.idCategory = idCategory;
        this.id = idCounter++;
    }

    public Product(String name, String imageName, String description, BigDecimal price) {
        this.name = name;
        this.imageName = imageName;
        this.description = description;
        this.price = price;
        this.id = idCounter++;
    }
}
