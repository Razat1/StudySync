package com.smartstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@SpringBootApplication
//public class StudySyncApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(StudySyncApplication.class, args);
//
//		System.out.println("Hello!");
//	}
//}
@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.smartstudy.repository")
@EntityScan(basePackages = {"com.smartstudy.entity", "com.smartstudy.config"}) // Add the package of CustomUser
public class StudySyncApplication {
	public static void main(String[] args) {
		SpringApplication.run(StudySyncApplication.class, args);
		System.out.println("Hello!");
	}
}
