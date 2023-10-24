//package com.smartstudy.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//@Configuration
//public class SecurityConfig {
//
//    @Bean
//    public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests(authorizeRequests ->
//                        authorizeRequests
//                                .requestMatchers(CustomRequestMatchers.publicUrls()).permitAll()
//                                .requestMatchers(CustomRequestMatchers.adminUrls()).hasRole("ADMIN")
//                                .requestMatchers(CustomRequestMatchers.userDetail()).authenticated() // Require authentication for /users/{username}
//                )
//                .formLogin(withDefaults());
//
//        return http.build();
//    }
//}
