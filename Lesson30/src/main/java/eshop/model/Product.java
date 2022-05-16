package eshop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class Product {
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
    }

    public Product(String name, String imageName, String description, BigDecimal price) {
        this.name = name;
        this.imageName = imageName;
        this.description = description;
        this.price = price;
    }
}
