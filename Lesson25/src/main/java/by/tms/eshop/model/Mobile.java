package by.tms.eshop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class Mobile {
    private String id;
    private String name;
    private String imageName;
    private String description;
    private BigDecimal price;

    public Mobile(String name, String imageName, String description, BigDecimal price) {
        this.name = name;
        this.imageName = imageName;
        this.description = description;
        this.price = price;
    }
}

