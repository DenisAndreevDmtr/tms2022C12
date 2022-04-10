package by.tms.additionaltask.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUTILSAdditionalTask {
    private static final String dbUrl = "jdbc:mysql://localhost:3306/STUDENTS_DB";
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
