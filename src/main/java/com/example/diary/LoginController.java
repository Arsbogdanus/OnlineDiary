package com.example.diary;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class LoginController {
    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null) {
            model.addAttribute("error", "Неверные учетные данные");
        }

        if (logout != null) {
            model.addAttribute("message", "Вы успешно вышли из системы");
        }

        return "login";
    }

    @PostMapping("/login")
    public String loginPost(Model model, String username, String password) {
        boolean isAuthenticated = checkCredentials(username, password);

        if (isAuthenticated) {
            Authentication authentication = new UsernamePasswordAuthenticationToken(username, password);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            return "homePage"; // Перенаправление пользователя после успешной аутентификации
        } else {
            model.addAttribute("error", "Неверные учетные данные");
            return "login";
        }
    }


    private boolean checkCredentials(String username, String password) {

        // Здесь должна быть ваша логика проверки учетных данных
        // Например, вы можете использовать сервис UserDetailsService для загрузки информации о пользователе и проверки пароля
        // Возвращайте true, если аутентификация успешна, и false в противном случае

        if (username == "admin" && password == "12345") {
            return true;
        } else {
            return false; // Заглушка, замените на свою логику
        }
    }
}

