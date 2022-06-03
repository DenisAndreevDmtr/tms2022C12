package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Product;
import by.teachmeskills.eshop.repositories.ProductRepository;
import by.teachmeskills.eshop.utils.ConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImpl implements ProductRepository {

    private static final String GET_ALL_PRODUCTS = "SELECT * FROM product";
    private static final String GET_ALL_PRODUCTS_BY_ID_CATEGORY = "SELECT * FROM product WHERE id_Category=?";
    private static final String GET_PRODUCT_BY_ID_PRODUCT = "SELECT * FROM product WHERE id_Product=?";
    private static final String GET_ALL_PRODUCTS_BY_REQUEST = " SELECT * FROM product WHERE name LIKE ? or description LIKE ?";


    @Override
    public List<Product> getAllProducts() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_Product");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int idCategory = rs.getInt("id_Category");
                String imagePath = rs.getString("image_Path");
                products.add(new Product(id, name, imagePath, description, price, idCategory));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> getAllProductsByIdCategory(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_BY_ID_CATEGORY);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id_Product");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int idCategory = rs.getInt("id_Category");
                String imagePath = rs.getString("image_Path");
                products.add(new Product(idProduct, name, imagePath, description, price, idCategory));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    public Product getProductById(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Product product = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_PRODUCT_BY_ID_PRODUCT);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id_Product");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int idCategory = rs.getInt("id_Category");
                String imagePath = rs.getString("image_Path");
                product = new Product(idProduct, name, imagePath, description, price, idCategory);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public List<Product> getListProductsbyRequest(String request) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_BY_REQUEST);
            String requestDB = '%' + request + '%';
            preparedStatement.setString(1, requestDB);
            preparedStatement.setString(2, requestDB);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id_Product");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int idCategory = rs.getInt("id_Category");
                String imagePath = rs.getString("image_Path");
                products.add(new Product(idProduct, name, imagePath, description, price, idCategory));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public Product create(Product entity) {
        return null;
    }

    @Override
    public List<Product> read() {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
