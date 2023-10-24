package com.smartstudy.web;

import com.smartstudy.entity.User;
import com.smartstudy.repository.UserRepository; // Corrected import
import com.smartstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController { // Corrected class name
    @Autowired
    private UserRepository userRepository; // Corrected variable name

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to SmartStudy!";
    }

    @Autowired
    private UserService userService;

    @GetMapping("/{username}") // Changed path variable name to {username}
    public ResponseEntity<User> getUserByUsername(@PathVariable String username) {
        User user = userService.getUserByUsername(username);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
