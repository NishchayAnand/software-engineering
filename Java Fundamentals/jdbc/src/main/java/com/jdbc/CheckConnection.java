package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class CheckConnection {

    public boolean tryConnection() throws Exception {

        Connection connection = DriverManager.getConnection(null);

        boolean isValid = connection.isValid(2);

        connection.close();

        return isValid;
    }

}
