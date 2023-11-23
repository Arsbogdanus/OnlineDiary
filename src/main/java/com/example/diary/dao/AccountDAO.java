package com.example.diary.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/OnlineDiary";
    private static final String JDBC_USER = "Bogdan";
    private static final String JDBC_PASSWORD = "My18042010!";

    private static final String INSERT_USER_SQL = "INSERT INTO Person (email, password) VALUES ('arsbogdanus@gmail.com', '54321')";
    private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    public void insertUser(String username, String password, String email) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(INSERT_USER_SQL)) {
            statement.setString(2, password);
            statement.setString(3, email);
            statement.executeUpdate();
        }
    }
}