package com.smartstudy.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Username")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Username")
    private String username;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    // Getters and setters
}
