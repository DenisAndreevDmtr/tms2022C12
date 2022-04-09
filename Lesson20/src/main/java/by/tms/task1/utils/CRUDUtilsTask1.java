package by.tms.task1.utils;

import by.tms.task1.module.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUtilsTask1 {
    private static final String GET_ALL_PRODUCTS_QUERY = "SELECT * FROM products";
    private static final String INSERT_PRODUCTS_QUERY = "INSERT INTO products (name, description, amount, isavailable) VALUES (?, ?, ?, ?)";
    private static final String UPDATE_PRODUCTS_QUERY = "UPDATE products SET amount=?, isavailable=? WHERE id=?";
    private static final String DELETE_PRODUCTS_QUERY = "DELETE FROM products WHERE id=?";

    public static List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        Connection connection = DBUtilsTask1.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_QUERY);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                long id = rs.getLong("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                boolean isAvailable = rs.getBoolean("isavailable");
                products.add(new Product(id, name, description, amount, isAvailable));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public static List<Product> addProduct(Product product) {
        List<Product> products = new ArrayList<>();
        Connection connection = DBUtilsTask1.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCTS_QUERY);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, product.getDescription());
            preparedStatement.setInt(3, product.getAmount());
            preparedStatement.setBoolean(4, product.isAvailable());
            preparedStatement.executeUpdate();
            products = getAllProducts();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public static List<Product> updateProduct(int id, int amount, boolean isAvailable) {
        List<Product> products = new ArrayList<>();
        Connection connection = DBUtilsTask1.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCTS_QUERY);
            preparedStatement.setInt(1, amount);
            preparedStatement.setBoolean(2, isAvailable);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            products = getAllProducts();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public static List<Product> deleteProduct(int id) {
        List<Product> products = new ArrayList<>();
        Connection connection = DBUtilsTask1.getConnection();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCTS_QUERY);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            products = getAllProducts();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return products;
    }


}
