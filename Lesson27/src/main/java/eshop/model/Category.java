package eshop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class Category {
    private int id;
    private String name;
    private String imageName;
    private String servletName;

    public Category(int id, String name, String imageName, String servletName) {
        this.id = id;
        this.name = name;
        this.imageName = imageName;
        this.servletName = servletName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", imageName='" + imageName + '\'' +
                '}';
    }
}

