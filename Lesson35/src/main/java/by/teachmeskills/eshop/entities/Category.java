package by.teachmeskills.eshop.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {
    private String name;
    private int rating;
    private String imageName;

    public Category(int id, String name, int rating, String imageName) {
        super(id);
        this.name = name;
        this.rating = rating;
        this.imageName = imageName;
    }
}