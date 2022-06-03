package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Order;
import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.OrderRepository;
import by.teachmeskills.eshop.utils.ConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository {

    private static final String INSERT_NEW_ORDER = "INSERT INTO internet_shop.order (price, date_Order, id_User) VALUES (?, ?, ?)";
    private static final String GET_ORDER_BY_ID_USER = "SELECT * FROM internet_shop.order WHERE id_User=?";
    private static final String INSERT_NEW_ORDER_PRODUCT = "INSERT INTO internet_shop.order_product (id_Product, id_Order) VALUES (?, ?)";
    private static final String GET_ALL_PRODUCTS_BY_ID_ORDER = "select internet_shop.product.*\n" +
            "from internet_shop.product\n" +
            "inner join internet_shop.order_product\n" +
            "on order_product.id_Product = internet_shop.product.id_product\n" +
            "inner join internet_shop.order\n" +
            "on internet_shop.order.id_Order = internet_shop.order_product.id_Order\n" +
            "where internet_shop.order_product.id_Order = ?";
    private static final String GET_ALL_ORDERS_BY_ID_USER = "SELECT * FROM internet_shop.order WHERE id_User=?";
    private static final String GET_ORDER_BY_ID_ORDER = "SELECT * FROM internet_shop.order WHERE id_Order=?";

    @Override
    public Order create(Order entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Order order = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ORDER);
            preparedStatement.setBigDecimal(1, entity.getPriceOrder());
            preparedStatement.setDate(2, Date.valueOf(entity.getDate()));
            preparedStatement.setInt(3, entity.getIdUser());
            preparedStatement.executeUpdate();
            order = getOrderByIdUser(entity.getIdUser());
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    public void create(int idProduct, int idOrder) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_ORDER_PRODUCT);
            preparedStatement.setInt(1, idProduct);
            preparedStatement.setInt(2, idOrder);
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Order getOrderByIdUser(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Order order = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID_USER);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("id_Order");
                BigDecimal price = rs.getBigDecimal("price");
                LocalDate date = rs.getDate("date_Order").toLocalDate();
                int idUser = rs.getInt("id_User");
                order = new Order(idOrder, price, date, idUser);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public List<Product> getAllProductsByIdOrder(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_BY_ID_ORDER);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id_Product");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int idCategory = rs.getInt("id_Category");
                String imgName = rs.getString("image_Path");
                Product product = new Product(idProduct, name, imgName, description, price, idCategory);
                products.add(product);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Integer> getAllIdOrdersByUserId(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Integer> idOrders = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_ORDERS_BY_ID_USER);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("id_Order");
                idOrders.add(idOrder);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return idOrders;
    }

    @Override
    public Order getOrderByIdOrder(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Order order = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ORDER_BY_ID_ORDER);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idOrder = rs.getInt("id_Order");
                BigDecimal price = rs.getBigDecimal("price");
                LocalDate date = rs.getDate("date_Order").toLocalDate();
                int idUser = rs.getInt("id_User");
                order = new Order(idOrder, price, date, idUser);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return order;
    }


    @Override
    public List<Order> read() {
        return null;
    }

    @Override
    public Order update(Order entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }


}
