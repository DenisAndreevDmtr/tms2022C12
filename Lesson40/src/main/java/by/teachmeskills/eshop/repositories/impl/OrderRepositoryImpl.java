package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ConnectionPool;
import by.teachmeskills.eshop.repositories.OrderRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepositoryImpl implements OrderRepository {
    private static final String INSERT_NEW_ORDER = "INSERT INTO internet_shop.order (price, date_Order, user_id) VALUES (?, ?, ?)";
    private static final String GET_ORDER_BY_USER_ID = "SELECT * FROM internet_shop.order WHERE user_id=?";
    private static final String INSERT_NEW_ORDER_PRODUCT = "INSERT INTO internet_shop.order_product (product_id, order_id) VALUES (?, ?)";
    private static final String GET_ALL_ORDERS_BY_USER_ID = "SELECT * FROM internet_shop.order WHERE user_id=?";
    private static final String GET_ORDER_BY_ID_ORDER = "SELECT * FROM internet_shop.order WHERE id=?";
    private static final String GET_ALL_ORDERS = "SELECT * FROM internet_shop.order";
    private static final String UPDATE_ORDER = "UPDATE internet_shop.order SET price=? WHERE id=?";
    private static final String DELETE_ORDER = "DELETE FROM internet_shop.order WHERE id=?";

    @Override
    public Order create(Order entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Order order = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ORDER);
            preparedStatement.setBigDecimal(1, entity.getPriceOrder());
            preparedStatement.setDate(2, Date.valueOf(entity.getDate()));
            preparedStatement.setInt(3, entity.getUserId());
            preparedStatement.executeUpdate();
            order = getOrderByUserId(entity.getUserId());
            List<Product> productsInOrder = entity.getProductsInOrder();
            for (Product p : productsInOrder) {
                create(p.getId(), order.getId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return order;
    }

    public void create(int idProduct, int idOrder) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ORDER_PRODUCT);
            preparedStatement.setInt(1, idProduct);
            preparedStatement.setInt(2, idOrder);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Order getOrderByUserId(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Order order = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_USER_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("id");
                BigDecimal price = rs.getBigDecimal("price");
                LocalDate date = rs.getDate("date_Order").toLocalDate();
                int idUser = rs.getInt("user_id");
                order = new Order(idOrder, price, date, idUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return order;
    }

    @Override
    public List<Integer> getAllOrdersIdsByUserId(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Integer> idOrders = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ORDERS_BY_USER_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("id");
                idOrders.add(idOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return idOrders;
    }

    @Override
    public Order getOrderById(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Order order = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID_ORDER);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("id");
                BigDecimal price = rs.getBigDecimal("price");
                LocalDate date = rs.getDate("date_Order").toLocalDate();
                int idUser = rs.getInt("user_id");
                order = new Order(idOrder, price, date, idUser);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return order;
    }

    @Override
    public List<Order> read() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Order> orders = new ArrayList<>();
        Connection connection = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ORDERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("id");
                BigDecimal price = rs.getBigDecimal("price");
                LocalDate date = rs.getDate("date_Order").toLocalDate();
                int idUser = rs.getInt("user_id");
                orders.add(new Order(idOrder, price, date, idUser));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return orders;
    }

    //method should be updated
    @Override
    public Order update(Order entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Order order = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER);
            preparedStatement.setBigDecimal(1, entity.getPriceOrder());
            preparedStatement.setInt(2, entity.getId());
            preparedStatement.executeUpdate();
            order = getOrderById(entity.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return order;
    }

    //method should be updated
    @Override
    public void delete(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}