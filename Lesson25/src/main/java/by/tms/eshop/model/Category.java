package by.tms.eshop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class Category {
    private String id;
    private String name;
    private String imageName;
    private String servletName;
    private List<Product> productList;

    public Category(String name, String imageName, String servletName) {
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

