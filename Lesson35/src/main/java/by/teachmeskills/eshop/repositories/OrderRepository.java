package by.teachmeskills.eshop.repositories;

import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;

import java.util.List;


public interface OrderRepository extends BaseRepository<Order> {
    Order getOrderByIdOrder(int id);

    Order getOrderByIdUser(int id);

    List<Product> getAllProductsByIdOrder(int id);

    List<Integer> getAllIdOrdersByUserId(int id);

    void create(int productId, int orderId);
}
