package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

    // using DriverManager class to obtain connection to database
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/test?user=root&password=root";
        Connection connection = DriverManager.getConnection(url);
        boolean isValid = connection.isValid(2);
        if (!isValid) {
            throw new Exception("Invalid connection. Please check");
        }
        return connection;
    }

}
