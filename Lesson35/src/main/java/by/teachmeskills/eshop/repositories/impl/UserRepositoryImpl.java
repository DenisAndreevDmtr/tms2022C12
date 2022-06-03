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
import java.util.List;
import java.util.Optional;


public class UserRepositoryImpl implements UserRepository {

    private static final String GET_USER_BY_ID = "SELECT * FROM user WHERE id_User=?";
    private static final String GET_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM user WHERE login=? AND password=?";
    private static final String GET_USER_BY_LOGIN = "SELECT * FROM user WHERE login=?";
    private static final String INSERT_NEW_USER = "INSERT INTO user (name, surname, email, password, login, birth_date, balance) VALUES (?, ?, ?, ?, ?, ?, ?)";


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
                int idUser = rs.getInt("id_User");
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
                int idUser = rs.getInt("id_User");
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
                int idUser = rs.getInt("id_User");
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

    @Override
    public List<User> read() {
        return null;
    }

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

}
