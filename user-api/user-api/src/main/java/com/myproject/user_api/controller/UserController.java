package com.myproject.user_api.controller;

import com.myproject.user_api.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    // Kullanıcı listesi (hafızada tutuluyor)
    private List<User> userList = new ArrayList<>();

    // Örnek kullanıcı ekleme
    public UserController() {
        userList.add(new User("ahmet", "1234", "ahmet@example.com"));
        userList.add(new User("mehmet", "5678", "mehmet@example.com"));
    }

    // Kullanıcı Login
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        for (User u : userList) {
            if (u.getUsername().equals(user.getUsername()) && u.getPassword().equals(user.getPassword())) {
                return "Login başarılı!";
            }
        }
        return "Geçersiz kullanıcı adı veya şifre!";
    }

    // Şifre Güncelleme
    @PostMapping("/update-password")
    public String updatePassword(@RequestBody User user) {
        for (User u : userList) {
            if (u.getUsername().equals(user.getUsername())) {
                u.setPassword(user.getPassword());
                return "Şifre başarıyla güncellendi!";
            }
        }
        return "Kullanıcı bulunamadı!";
    }

    // Kullanıcı Bilgilerini Getirme
    @GetMapping("/user-info/{username}")
    public User getUserInfo(@PathVariable String username) {
        for (User u : userList) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null; // Kullanıcı bulunamazsa null döner
    }
}


