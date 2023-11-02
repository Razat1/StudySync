package com.smartstudy.web;

import com.smartstudy.entity.User;
import com.smartstudy.repository.UserRepository;
import com.smartstudy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
public class UserController {

    private final UserService userService;
    @Autowired
    private UserRepository userRepository;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new User());
        return "Registration";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login";
    }

    @GetMapping("/user/personal")
    public String getPersonalPage(Principal principal, Model model){
       String Username = principal.getName();
       User user = userRepository.findByUsername(Username);
       model.addAttribute("userLogin", user.getFirstName());
        return "personal";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute User user) {
        System.out.println("register request: " + user);
        User registeredUser = userService.register(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getEmail());
        return registeredUser == null ? "error" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model) {
        System.out.println("login request: " + user);
        User authenticated = userService.authenticate(user.getUsername(), user.getPassword());
        if (authenticated != null) {

            return "redirect:/personal"; // Redirect to the "personal" page
        } else {
            return "error";
        }
    }

}

