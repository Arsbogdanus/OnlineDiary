package com.example.diary.dao;

import com.example.diary.models.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:mysql://localhost:3306/OnlineDiaryMySQL";
    private static final String GMAIL = "mysql@gmail.com";
    private static final String PASSWORD = "mysql";


    private static final Connection connection;

    static {
        try {
            Class.forName("org.mysql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            connection = DriverManager.getConnection(URL, GMAIL, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Person show(int id){
        Person person = null;

        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("SELECT * FROM Person WHERE id=?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            resultSet.next();

            person = new Person();

            person.setId(resultSet.getInt("id"));
            person.setPassword(resultSet.getString("password"));
            person.setEmail(resultSet.getString("email"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return person;
    }
    public void save(Person person){
        try {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO Person VALUES(id, ?, ?)");

            preparedstatement.setString(2, person.getEmail());
            preparedstatement.setString(1, person.getPassword());

            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
