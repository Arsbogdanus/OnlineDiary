package com.example.diary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
//    @Autowired
//    private UserService userService;

//    @PostMapping("/register")
//    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String password) {
//        User user = userService.registerUser(username, password);
//        return ResponseEntity.ok("Пользователь зарегистрирован: " + user.getUsername());
//    }
}