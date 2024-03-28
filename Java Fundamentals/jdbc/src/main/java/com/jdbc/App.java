package com.jdbc;

public class App {
    public static void main(String[] args) {
        try {
            boolean isConnected = DBUtils.tryConnection();
            System.out.println("Connection Established: " + isConnected);
        } catch (Exception e) {
            System.out.println("Unable to connect to the database. Error: " + e.getMessage());
        }

    }
}
