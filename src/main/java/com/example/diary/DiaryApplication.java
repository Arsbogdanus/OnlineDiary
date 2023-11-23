package com.example.diary;

import com.example.diary.controllers.LoginController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DiaryApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(LoginController.class, args);
        try {
            LoginController loginController = new LoginController();
            loginController.creatingAccountPost("arsbogdanus@gmail.com", "54321");
        } catch (Throwable exception) {
            System.out.println(exception.getMessage());
        }
    }
}