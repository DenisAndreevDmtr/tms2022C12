package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.repositories.ConnectionPool;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryRepositoryImpl implements CategoryRepository {
    private static final String GET_ALL_CATEGORIES = "SELECT * FROM category";
    private static final String GET_CATEGORY_NAME_BY_ID = "SELECT internet_shop.category.name FROM internet_shop.category WHERE id=?";
    private static final String CREATE_NEW_CATEGORY = "INSERT INTO category (name, rating, image_Path) VALUES (?, ?, ?)";
    private static final String GET_CATEGORY_BY_NAME = "SELECT * FROM category WHERE name=?";
    private static final String UPDATE_CATEGORY = "UPDATE category SET rating=? WHERE name=?";
    private static final String DELETE_CATEGORY = "DELETE FROM category WHERE id=?";
    private static final String GET_CATEGORY_BY_ID = "SELECT * FROM category WHERE id=?";

    @Override
    public List<Category> getAllCategories() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Category> categories = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CATEGORIES);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int rating = rs.getInt("rating");
                String imgPath = rs.getString("image_Path");
                categories.add(new Category(id, name, rating, imgPath));
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
        return categories;
    }

    @Override
    public String getCategoryNameByID(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        String result = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_NAME_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = rs.getString("name");
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
        return result;
    }

    //method should be updated
    @Override
    public Category create(Category entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Category category = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_CATEGORY);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setInt(2, entity.getRating());
            preparedStatement.setString(3, entity.getImageName());
            preparedStatement.executeUpdate();
            category = getCategoryByName(entity.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return category;
    }

    private Category getCategoryByName(String nameCategory) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Category category = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_BY_NAME);
            preparedStatement.setString(1, nameCategory);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int rating = rs.getInt("rating");
                String imgPath = rs.getString("image_Path");
                category = new Category(id, name, rating, imgPath);
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
        return category;
    }

    @Override
    public Category getCategoryById(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Category category = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCategory = rs.getInt("id");
                String name = rs.getString("name");
                int rating = rs.getInt("rating");
                String imgPath = rs.getString("image_Path");
                category = new Category(idCategory, name, rating, imgPath);
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
        return category;
    }

    //method should be updated
    @Override
    public List<Category> read() {
        return getAllCategories();
    }

    //method should be updated
    @Override
    public Category update(Category entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Category category = null;
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CATEGORY);
            preparedStatement.setInt(1, entity.getRating());
            preparedStatement.setString(2, entity.getName());
            preparedStatement.executeUpdate();
            category = getCategoryByName(entity.getName());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.closeConnection(connection);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return category;
    }

    //method should be updated
    @Override
    public void delete(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        Connection connection = null;
        try {
            connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CATEGORY);
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