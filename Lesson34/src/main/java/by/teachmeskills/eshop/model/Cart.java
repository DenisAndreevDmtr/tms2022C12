package by.teachmeskills.eshop.model;

import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Setter
public class Cart {

    private Map<Integer, Product> products;
    private BigDecimal totalPrice = new BigDecimal(0);

    public Cart() {
        this.products = new HashMap<>();
    }

    public static Cart createCart(Object objCart) {
        Cart cart;
        if (objCart != null) {
            cart = (Cart) objCart;
        } else {
            cart = new Cart();
        }
        return cart;
    }

    public void addProduct(Product product) {
        products.put(product.getId(), product);
        totalPrice = totalPrice.add(product.getPrice());
    }

    public void removeProduct(int productId) {
        Product product = products.get(productId);
        products.remove(productId);
        totalPrice = totalPrice.subtract(product.getPrice());
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products.values());
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void clear() {
        products.clear();
    }
}
