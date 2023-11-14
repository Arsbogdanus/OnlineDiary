package com.example.diary.dao;

import com.example.diary.models.Person;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private static final String URL = "jdbc:mysql://localhost:3306/OnlineDiaryMySQL";
    private static final String GMAIL = "mysql@gmail.com";
    private static final String PASSWORD = "mysql";


    private static Connection connection;

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

    private List<Person> people;


    public Person show(int id){
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }
    public void save(Person person){
        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 +",'" + person.getName() + "'" +
                    "'," + person.getName() + ",'" + person.getEmail() + "')";
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
