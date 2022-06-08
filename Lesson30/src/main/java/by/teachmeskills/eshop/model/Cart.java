package by.teachmeskills.eshop.model;

import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;


@NoArgsConstructor
public class Cart {
    private List<Product> productsInCart;
    private BigDecimal totalPrice;

    public Cart(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }

    public List<Product> getProductsInCart() {
        return productsInCart;
    }

    public void setProductsInCart(List<Product> productsInCart) {
        this.productsInCart = productsInCart;
    }
}

