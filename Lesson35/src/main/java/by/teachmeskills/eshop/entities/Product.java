package by.teachmeskills.eshop.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class Product extends BaseEntity {
    private String name;
    private String imageName;
    private String description;
    private BigDecimal price;
    private int idCategory;

    public Product(int id, String name, String imageName, String description, BigDecimal price, int idCategory) {
        super(id);
        this.name = name;
        this.imageName = imageName;
        this.description = description;
        this.price = price;
        this.idCategory = idCategory;
    }

    public Product(String name, String imageName, String description, BigDecimal price, int idCategory) {
        this.name = name;
        this.imageName = imageName;
        this.description = description;
        this.price = price;
        this.idCategory = idCategory;
    }
}
