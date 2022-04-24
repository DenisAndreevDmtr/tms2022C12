package eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter

public class Navigator extends Product {
    public Navigator(String name, String imageName, String description, BigDecimal price) {
        super(name, imageName, description, price);
    }
}
