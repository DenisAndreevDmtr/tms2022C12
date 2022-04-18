package by.tms.eshop.model;

import java.util.List;
import java.util.Objects;

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

    public String getServletName() {
        return servletName;
    }

    public void setServletName(String servletName) {
        this.servletName = servletName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
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
