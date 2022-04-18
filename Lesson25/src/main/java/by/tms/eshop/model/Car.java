package by.tms.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class Car {
    private String id;
    private String name;
    private String imageName;
    private String description;
    private BigDecimal price;

    public Car(String name, String imageName, String description, BigDecimal price) {
        this.name = name;
        this.imageName = imageName;
        this.description = description;
        this.price = price;
    }
}


