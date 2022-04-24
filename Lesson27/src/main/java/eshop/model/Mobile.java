package eshop.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class Mobile extends Product {

    public Mobile(String name, String imageName, String description, BigDecimal price) {
        super(name, imageName, description, price);
    }
}

