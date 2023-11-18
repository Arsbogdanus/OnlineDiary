package com.example.diary.controllers;

import com.example.diary.models.Post;
import com.example.diary.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomePageController {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/homePage")
    public String noteMenu(Model model) {
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "homePage";
    }

    @GetMapping("/NewNote")
    public String noteAdd(Model model) {
        return "NewNote";
    }

    @PostMapping("/NewNote")
    public String notePostAdd(@RequestParam String theme, @RequestParam String note, Model model) {
        return "";
    }
}


