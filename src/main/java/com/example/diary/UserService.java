package com.example.diary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

//    private final UserRepository userRepository;
//    private final PasswordEncoder passwordEncoder;
//
//    @Autowired
//    public UserService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    public User findByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//
//    public void saveUser(User user) {
//        userRepository.save(user);
//    }
//
//    @Autowired
//    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
//        this.userRepository = userRepository;
//        this.passwordEncoder = passwordEncoder;
//    }
//
//    public void registerUser(String username, String password) {
//        // Проверяем, существует ли пользователь с таким именем
//        if (userRepository.findByUsername(username).isPresent()) {
//            throw new UserAlreadyExistsException("Пользователь с таким именем уже существует");
//        }
//
//        // Хешируем пароль
//        String encodedPassword = passwordEncoder.encode(password);
//
//        // Создаем нового пользователя
//        User user = new User(username, encodedPassword);
//
//        // Сохраняем пользователя в базе данных
//        userRepository.save(user);
//    }
}