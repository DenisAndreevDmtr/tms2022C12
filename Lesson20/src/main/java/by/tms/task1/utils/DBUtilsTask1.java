package by.tms.task1.utils;

import lombok.experimental.UtilityClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@UtilityClass

public class DBUtilsTask1 {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/INTERNET_SHOP";
    private static final String dbUsername = "root";
    private static final String dbPassword = "qazxsw123";

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
