package by.teachmeskills.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Category {
    private int id;
    private String name;
    private String imageName;


    public Category(int id, String name, String imageName) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(imageName, category.imageName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, imageName);
    }
}
