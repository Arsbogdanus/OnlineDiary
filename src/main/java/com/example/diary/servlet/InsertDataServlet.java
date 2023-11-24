package com.example.diary.servlet;

import com.example.diary.dao.PersonDAO;
import com.example.diary.models.Person;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertDataServlet extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/OnlineDiary";
    private static final String JDBC_USER = "Bogdan";
    private static final String JDBC_PASSWORD = "your_password";
    private PersonDAO personDAO;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        Person person = new Person();
        person.setEmail(email);
        person.setPassword(password);

        try {
            personDAO.save(person);
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("accountCreating.jsp");
    }
}