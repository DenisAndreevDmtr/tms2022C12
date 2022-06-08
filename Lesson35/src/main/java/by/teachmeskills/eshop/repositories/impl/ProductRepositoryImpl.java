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
    private static final String GET_ALL_PRODUCTS_BY_CATEGORY_ID = "SELECT * FROM product WHERE category_id=?";
    private static final String GET_PRODUCT_BY_ID_PRODUCT = "SELECT * FROM product WHERE id=?";
    private static final String GET_ALL_PRODUCTS_BY_REQUEST = " SELECT * FROM product WHERE name LIKE ? or description LIKE ?";
    private static final String GET_ALL_PRODUCTS_BY_ID_ORDER = "SELECT internet_shop.product.*\n" +
            "FROM internet_shop.product\n" +
            "INNER JOIN internet_shop.order_product\n" +
            "ON order_product.product_id = internet_shop.product.id\n" +
            "INNER JOIN internet_shop.order\n" +
            "ON internet_shop.order.id = internet_shop.order_product.order_id\n" +
            "WHERE internet_shop.order_product.order_id = ?";
    private static final String UPDATE_PRODUCT = "UPDATE product SET name=?, description=?, price=?, category_id=?, image_Path=? WHERE id=?";
    private static final String DELETE_PRODUCT = "DELETE FROM product WHERE id=?";

    @Override
    public List<Product> getAllProductsByCategoryId(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_BY_CATEGORY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int idCategory = rs.getInt("category_id");
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
                int idProduct = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int idCategory = rs.getInt("category_id");
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
    public List<Product> getListProductsByNameOrDesc(String param) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_BY_REQUEST);
            String requestDB = '%' + param + '%';
            preparedStatement.setString(1, requestDB);
            preparedStatement.setString(2, requestDB);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int idCategory = rs.getInt("category_id");
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
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int idCategory = rs.getInt("category_id");
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
    public List<Product> getAllProductsByOrderId(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Product> products = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_PRODUCTS_BY_ID_ORDER);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idProduct = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                BigDecimal price = rs.getBigDecimal("price");
                int idCategory = rs.getInt("category_id");
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

    //method should be updated
    @Override
    public Product update(Product entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Product product = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setBigDecimal(3, entity.getPrice());
            preparedStatement.setInt(4, entity.getCategoryId());
            preparedStatement.setString(5, entity.getImageName());
            preparedStatement.setInt(6, entity.getId());
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
            product = getProductById(entity.getId());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    //method should be updated
    @Override
    public void delete(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}