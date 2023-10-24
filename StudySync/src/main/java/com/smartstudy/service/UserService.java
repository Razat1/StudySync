package com.smartstudy.service;

import com.smartstudy.entity.User;
import com.smartstudy.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
//    @Autowired
//    private UserRepository userRepository;
//
//    public User getUserByUsername(String username) {
//        return userRepository.findByUsername(username);
//    }
//}
//@Service

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username) {
        logger.info("Checking the database connection.");
        User user = userRepository.findByUsername(username);
        return user;
    }
}

