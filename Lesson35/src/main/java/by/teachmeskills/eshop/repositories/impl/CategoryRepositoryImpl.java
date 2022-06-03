package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.Category;
import by.teachmeskills.eshop.repositories.CategoryRepository;
import by.teachmeskills.eshop.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepositoryImpl implements CategoryRepository {

    private static final String GET_ALL_CATEGORIES = "SELECT * FROM category";
    private static final String GET_CATEGORY_NAME_BY_ID = "SELECT internet_shop.category.name FROM internet_shop.category WHERE id_Category=?";

    @Override
    public List<Category> getAllCategories() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<Category> categories = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CATEGORIES);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id_Category");
                String name = rs.getString("name");
                int rating = rs.getInt("rating");
                String imgPath = rs.getString("image_Path");
                categories.add(new Category(id, name, rating, imgPath));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return categories;
    }


    @Override
    public String getCategoryNameByID(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        String result = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_CATEGORY_NAME_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                result = rs.getString("name");
            }
            connectionPool.closeConnection(connection);
        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Category create(Category entity) {
        return null;
    }

    @Override
    public List<Category> read() {
        return null;
    }

    @Override
    public Category update(Category entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }
}
