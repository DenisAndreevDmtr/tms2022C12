package by.tms.utils;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Product {

    private static int counter;

    private long id;
    private String name;
    private int price;
    private int orderCreatinon;

    public Product(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.orderCreatinon = counter++;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", ordercreation=" + orderCreatinon +
                '}';
    }
}

