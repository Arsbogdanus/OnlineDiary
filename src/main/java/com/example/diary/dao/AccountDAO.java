package com.example.diary.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/OnlineDiary";
    private static final String JDBC_USER = "Bogdan";
    private static final String JDBC_PASSWORD = "your_password";

    private static final String INSERT_USER_SQL = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
    private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertUser(String username, String password, String email) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL)) {
            statement.setString(1, username);
            statement.setString(2, password);
            statement.setString(3, email);
            statement.executeUpdate();
        }
    }
}