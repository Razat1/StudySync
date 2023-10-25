package com.smartstudy.service;

import com.smartstudy.entity.User;
import com.smartstudy.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }
    public User register(String username, String password, String firstname, String lastname, String email) {
        if (username == null || password == null) {
            return null;
        } else {
            if(userRepository.findByUsername(username).isPresent()){
                System.out.println("Duplicated username");
            }
            User user = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setFirstName(firstname);
            user.setLastName(lastname);
            user.setEmail(email);
            return userRepository.save(user);
        }
    }
    public User authenticate (String username, String password){
        return userRepository.findByUsernameAndPassword(username, password).orElse(null);
    }
}



