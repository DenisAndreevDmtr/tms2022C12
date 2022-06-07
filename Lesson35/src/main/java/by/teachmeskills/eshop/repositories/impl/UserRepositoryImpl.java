package by.teachmeskills.eshop.repositories.impl;

import by.teachmeskills.eshop.entities.User;
import by.teachmeskills.eshop.repositories.UserRepository;
import by.teachmeskills.eshop.utils.ConnectionPool;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {
    private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id=?";
    private static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM user WHERE login=? AND password=?";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM user WHERE login=?";
    private static final String INSERT_NEW_USER = "INSERT INTO user (name, surname, email, password, login, birth_date, balance) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private static final String GET_ALL_USERS = "SELECT * FROM user";
    private static final String UPDATE_USER = "UPDATE user SET name=?, surname=?, email=?, password=?, login=?, birth_date=?, balance=? WHERE login=?";
    private static final String DELETE_USER = "DELETE FROM user WHERE id=?";

    @Override
    public User getUserById(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        User user = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String eMail = rs.getString("email");
                String password = rs.getString("password");
                String login = rs.getString("login");
                LocalDate date = rs.getDate("birth_date").toLocalDate();
                BigDecimal balance = rs.getBigDecimal("balance");
                user = new User(idUser, login, password, name, surname, date, eMail, balance);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public Optional<User> getUserByLoginAndPassword(String login, String password) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        User user = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN_AND_PASSWORD);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String eMail = rs.getString("email");
                String pass = rs.getString("password");
                String log = rs.getString("login");
                LocalDate date = rs.getDate("birth_date").toLocalDate();
                BigDecimal balance = rs.getBigDecimal("balance");
                user = new User(idUser, log, pass, name, surname, date, eMail, balance);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public Optional<User> getUserByLogin(String login) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        User user = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_USER_BY_LOGIN);
            preparedStatement.setString(1, login);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String eMail = rs.getString("email");
                String pass = rs.getString("password");
                String log = rs.getString("login");
                LocalDate date = rs.getDate("birth_date").toLocalDate();
                BigDecimal balance = rs.getBigDecimal("balance");
                user = new User(idUser, log, pass, name, surname, date, eMail, balance);
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Optional.ofNullable(user);
    }

    @Override
    public User create(User entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        User user = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_NEW_USER);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSurname());
            preparedStatement.setString(3, entity.getEMail());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setString(5, entity.getLogin());
            preparedStatement.setDate(6, Date.valueOf(entity.getDateBorn()));
            preparedStatement.setBigDecimal(7, entity.getBalance());
            preparedStatement.executeUpdate();
            user = getUserByLogin(entity.getLogin()).get();
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //method should be updated
    @Override
    public List<User> read() {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        List<User> users = new ArrayList<>();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_USERS);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idUser = rs.getInt("id");
                String name = rs.getString("name");
                String surname = rs.getString("surname");
                String eMail = rs.getString("email");
                String pass = rs.getString("password");
                String log = rs.getString("login");
                LocalDate date = rs.getDate("birth_date").toLocalDate();
                BigDecimal balance = rs.getBigDecimal("balance");
                users.add(new User(idUser, log, pass, name, surname, date, eMail, balance));
            }
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    //method should be updated
    @Override
    public User update(User entity) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        User user = null;
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER);
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getSurname());
            preparedStatement.setString(3, entity.getEMail());
            preparedStatement.setString(4, entity.getPassword());
            preparedStatement.setString(5, entity.getLogin());
            preparedStatement.setDate(6, Date.valueOf(entity.getDateBorn()));
            preparedStatement.setBigDecimal(7, entity.getBalance());
            preparedStatement.setString(8, entity.getLogin());
            preparedStatement.executeUpdate();
            connectionPool.closeConnection(connection);
            user = getUserByLogin(entity.getLogin()).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    //method should be updated
    @Override
    public void delete(int id) {
        ConnectionPool connectionPool = ConnectionPool.getInstance();
        try {
            Connection connection = connectionPool.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            connectionPool.closeConnection(connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}