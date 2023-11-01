package com.example.demo1.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/library";
    private static final String USR_NAME = "root";
    private static final String PASSWORD = "root@123";

    private Database() {
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(JDBC_URL, USR_NAME, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
