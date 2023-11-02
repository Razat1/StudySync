package com.smartstudy.service;

import com.smartstudy.entity.User;
import com.smartstudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User register(String username, String password, String firstname, String lastname, String email) {
        if (username == null || password == null) {
            return null;
        }

        User existingUser = userRepository.findByUsername(username);
        if (existingUser != null) {
            System.out.println("Duplicated username");
            return null; // Return null to indicate that registration failed
        } else {
            User user = new User();
            String encodedPassword = passwordEncoder.encode(password);
            user.setRole("ROLE_USER");
            user.setUsername(username);
            user.setPassword(encodedPassword); // Store the encoded password in the user object
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            return userRepository.save(user);
        }
    }
    public User authenticate(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }

    public User getUserById(long id) {
        Optional<User> userOptional = userRepository.findById(id);
        return userOptional.orElse(null);
    }
}