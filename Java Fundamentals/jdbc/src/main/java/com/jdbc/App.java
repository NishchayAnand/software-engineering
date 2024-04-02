package com.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {

    private static Connection connection;
    private static Statement statement;
    private static ResultSet resultSet;

    public static void main(String[] args) {
        try {

            connection = DBUtils.getConnection();

            // Creating a statment which can be send as SQL request to the database.
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customers");

            // Iterating over the resultSet
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String phoneNumber = resultSet.getString("phone_number");
                System.out.println("Name: " + name + ";Email: " + email + ";Phone Number: " + phoneNumber);
            }

        } catch (Exception e) {

            System.out.println("Error: " + e.getMessage());

            if (e instanceof SQLException) {
                SQLException sqlException = (SQLException) e;
                System.out.println("Error code: " + sqlException.getErrorCode());
                System.out.println("SQL State: " + sqlException.getSQLState());
            }

        } finally {

            try {
                resultSet.close();
            } catch (Exception e) {
                System.out.println("resultSet.close() Error:" + e.getMessage());
            }

            try {
                statement.close();
            } catch (Exception e) {
                System.out.println("statement.close() Error:" + e.getMessage());
            }

            try {
                connection.close();
            } catch (Exception e) {
                System.out.println("connection.close() Error:" + e.getMessage());
            }

        }
    }
}
