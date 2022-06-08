package by.teachmeskills.eshop.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@NoArgsConstructor
@Getter
@Setter
public class Cart {
    private List<Product> productsInCart;
}
