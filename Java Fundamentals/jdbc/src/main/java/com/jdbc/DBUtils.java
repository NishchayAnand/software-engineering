package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtils {

    public static boolean tryConnection() throws Exception {

        String url = "jdbc:mysql://localhost:3306/test?user=root&password=root";

        Connection connection = DriverManager.getConnection(url);

        boolean isValid = connection.isValid(2);

        connection.close();

        return isValid;
    }

}
