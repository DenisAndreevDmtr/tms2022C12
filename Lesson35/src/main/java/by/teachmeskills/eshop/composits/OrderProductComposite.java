package by.teachmeskills.eshop.composits;

import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderProductComposite {
    private Order order;
    private List<Product> productList;

    public OrderProductComposite(Order order, List<Product> productList) {
        this.order = order;
        this.productList = productList;
    }

    public Order getOrder() {
        return order;
    }

    public List<Product> getProductList() {
        return productList;
    }
}
