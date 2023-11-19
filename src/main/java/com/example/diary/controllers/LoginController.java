package com.example.diary.controllers;

import com.example.diary.dao.PersonDAO;
import com.example.diary.models.Person;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final PersonDAO personDAO;

    @Autowired
    public LoginController(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

//    @GetMapping("/{id}")
//    public String show(@PathVariable("id") int id, Model model) {
//        model.addAttribute("person", personDAO.show(id));
//        return "templates/login";
//    }
//
//    @GetMapping("/{id}")
//    public String create(@ModelAttribute("person") Person person) {
//        return "templates/createAccount";
//    }
//
//    @PostMapping()
//    public String create(@ModelAttribute("person") @Valid Person person, BindingResult bindingResult) {
//    personDAO.save(person);
//    if (bindingResult.hasErцrors()){
//        return "templates/createAccount";
//    }
//        return "redirect:/people";
//    }



    @GetMapping("/creatingAccount")
    public String creatingAccountGet(Model model) {
        return "templates/creatingAccount";
    }
    @PostMapping("/creatingAccount")
    public String creatingAccountPost(@RequestParam String email, @RequestParam String password, Model model) {
        Person person = new Person(1, email, password);
        personDAO.save(person);
        return "redirect:/уляля";
    }
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