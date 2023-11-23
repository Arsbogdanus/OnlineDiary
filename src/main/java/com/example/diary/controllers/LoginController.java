package com.example.diary.controllers;

import com.example.diary.dao.PersonDAO;
import com.example.diary.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.bouncycastle.cms.RecipientId.password;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final PersonDAO personDAO;

    //@Autowired
    public LoginController() {
        this.personDAO = new PersonDAO();
    }

/*    public LoginController(PersonDAO personDAO) {
        this.personDAO = personDAO;
        System.out.println("costructor 2");
    }*/

    @GetMapping("/creatingAccount")
    public String creatingAccountGet(Model model) {
        return "templates/creatingAccount";
    }

    /*
        @PostMapping("/creatingAccount")
    */
    public void creatingAccountPost(String email, String password) {
        Person person = new Person(email, password);
        System.out.println(">>> " + person.getEmail() + ", " + person.getPassword());
        personDAO.save(person);
    }
}