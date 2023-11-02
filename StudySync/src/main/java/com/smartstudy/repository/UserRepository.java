package com.smartstudy.repository;

import com.smartstudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findByUsernameAndPassword(String Username, String Password);
  public User findByUsername(String Username);

//    Optional<User>findByusers_id(Long Id);
}
