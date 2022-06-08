package by.teachmeskills.eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class Order {
    private static int orderCounter = 1;
    private int idOrder;
    private BigDecimal priceOrder;
    private List<Product> productsInOrder;
    private LocalDate date;
    private int idUser;

    public Order(BigDecimal priceOrder, List<Product> productsInOrder, LocalDate date, int idUser) {
        this.idOrder = orderCounter++;
        this.priceOrder = priceOrder;
        this.productsInOrder = productsInOrder;
        this.date = date;
        this.idUser = idUser;
    }

    public BigDecimal getPriceOrder() {
        return priceOrder;
    }

    public List<Product> getProductsInOrder() {
        return productsInOrder;
    }

    public int getIdOrder() {
        return idOrder;
    }
}

