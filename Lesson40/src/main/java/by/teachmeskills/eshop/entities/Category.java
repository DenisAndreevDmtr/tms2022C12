package by.teachmeskills.eshop.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {
    private String name;
    private int rating;
    private String imageName;
    private List<Product> productList;

    public Category(int id, String name, int rating, String imageName) {
        super(id);
        this.name = name;
        this.rating = rating;
        this.imageName = imageName;
    }

    public Category(int id, String name, int rating, String imageName, List<Product> productList) {
        super(id);
        this.name = name;
        this.rating = rating;
        this.imageName = imageName;
        this.productList = productList;
    }

    public String getImageName() {
        return imageName;
    }
}