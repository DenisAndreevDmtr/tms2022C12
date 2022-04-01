package by.tms.task1.module;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor

public class Product {
    private long id;
    private String name;
    private String description;
    private int amount;
    private boolean isAvailable;

    public Product(String name, String description, int amount, boolean isAvailable) {
        this.name = name;
        this.description = description;
        this.amount = amount;
        this.isAvailable = isAvailable;
    }

    public Product(String yan, String yanovich, int i) {
    }
}
