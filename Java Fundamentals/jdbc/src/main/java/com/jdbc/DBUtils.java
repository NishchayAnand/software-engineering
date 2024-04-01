package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.sql.DataSource;

public class DBUtils {

    // using DriverManager class to obtain connection to database
    public static boolean tryConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/test?user=root&password=root";

        Connection connection = DriverManager.getConnection(url);

        boolean isValid = connection.isValid(2);

        connection.close();

        return isValid;
    }

    // using DataSource object to obtain connection to database
    public static boolean tryConnection2() throws Exception {

        // Connection connection = dataSource.getConnection();

        // boolean isValid = connection.isValid(2);

        // connection.close();

        return false;
    }

}
