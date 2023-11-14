package com.example.diary;

import com.example.diary.controllers.LoginController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DiaryApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginController.class, args);
    }
}