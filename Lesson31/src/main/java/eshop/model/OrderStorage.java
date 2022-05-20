package eshop.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class OrderStorage {
    private static List<Order> ordersInStorage = new ArrayList<>();

    public static List<Order> getOrderStorage() {
        return ordersInStorage;
    }

    public static void setOrderStorage(List<Order> ordersInStorage) {
        OrderStorage.ordersInStorage = ordersInStorage;
    }
}