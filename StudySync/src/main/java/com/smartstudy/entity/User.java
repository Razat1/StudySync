package com.smartstudy.entity;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "users_id")
    private Long users_id;

    @Column(name = "Username")
    private String username;

    @Column(name = "Password")
    private String password;

    @Column(name = "first_name")
    private String FirstName;

    @Column(name = "last_name")
    private String LastName;

    @Column(name = "Email")
    private String email;

    @Column(name = "role")
    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @ManyToMany
    @JoinTable(name = "User_Subjects",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subjects> subjects;

    // Getter method for the collection of subjects
    public Set<Subjects> getSubjects() {
        return subjects;
    }

    // Setter method if needed
    public void setSubjects(Set<Subjects> subjects) {
        this.subjects = subjects;
    }

    public Long getId() {
        return users_id;
    }

    public void setId(Long id) {
        this.users_id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = lastName;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(users_id, user.users_id) && Objects.equals(username, user.username) && Objects.equals(password, user.password) && Objects.equals(FirstName, user.FirstName) && Objects.equals(LastName, user.LastName) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users_id, username, password, FirstName, LastName, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + users_id +
                ", username='" + username + '\'' +
                ", firstName='" + FirstName + '\'' +
                ", lastName='" + LastName + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}