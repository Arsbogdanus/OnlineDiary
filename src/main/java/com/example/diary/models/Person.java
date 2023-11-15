package com.example.diary.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class Person {
    private int id;
    @Size(min = 5, max = 10, message = "Password should be between 5 and 10 characters")
    private String password;
    @NotEmpty(message = "Email should not be empty")
    @Email
    private String email;

    public Person(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public Person() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
