package com.example.diary.dao;

import com.example.diary.models.Person;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:mysql://localhost:3306/MySQL";
    private static final String USER = "root";
    private static final String PASSWORD = "My18042010!";

    private Connection connection;

    //@Autowired
    public PersonDAO() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Throwable exception) {
            System.out.println("exception=" + exception);
        }
    }

    public Person show(int id) {
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

    public void save(Person person) {
        try {
            PreparedStatement preparedstatement = connection.prepareStatement("INSERT INTO Person (id, email, password) VALUES(?,?,? /*1, 'arsbogdanus@gmail.com', 54321*/)");

            preparedstatement.setInt(1, person.getId());
            preparedstatement.setString(2, person.getEmail());
            preparedstatement.setInt(3, Integer.parseInt(person.getPassword()));

            preparedstatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
