package by.teachmeskills.eshop.entities;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class Order extends BaseEntity {
    private BigDecimal priceOrder;
    private LocalDate date;
    private int idUser;

    public Order(int id, BigDecimal priceOrder, LocalDate date, int idUser) {
        super(id);
        this.priceOrder = priceOrder;
        this.date = date;
        this.idUser = idUser;
    }

    public Order(BigDecimal priceOrder, LocalDate date, int idUser) {
        this.priceOrder = priceOrder;
        this.date = date;
        this.idUser = idUser;
    }
}

