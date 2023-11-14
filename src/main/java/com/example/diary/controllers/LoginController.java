package com.example.diary.controllers;

import com.example.diary.dao.PersonDAO;
import com.example.diary.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final PersonDAO personDAO;

    @Autowired
    public LoginController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("person", personDAO.show(id));
        return "templates/show";
    }


//    @GetMapping("/login")
//    public String loginMethod(Model model, String error, String logout) {
//        return "templates/login";
//    }
//
//    @PostMapping("/login")
//    public String loginPost(Model model, String username, String password) {
//        boolean isAuthenticated = checkCredentials(username, password);
//
//        if (isAuthenticated) {
//            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
//            SecurityContextHolder.getContext().setAuthentication(authentication);
//            return "homePage"; // Перенаправление пользователя после успешной аутентификации
//        } else {
//            model.addAttribute("error", "Неверные учетные данные");
//            return "login";
//        }
//    }
//
//    private boolean checkCredentials(String username, String password) {
//
//        // Здесь должна быть ваша логика проверки учетных данных
//        // Например, вы можете использовать сервис UserDetailsService для загрузки информации о пользователе и проверки пароля
//        // Возвращайте true, если аутентификация успешна, и false в противном случае
//
//        if (username == "admin" && password == "12345") {
//            return true;
//        } else {
//            return false; // Заглушка, замените на свою логику
//        }
//    }
}