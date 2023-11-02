package com.smartstudy.entity;

import com.smartstudy.config.CustomUser;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "User_Subjects")

public class UserSubjects {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_subject_id")
    private Long userSubjectId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subjects subject;

    public UserSubjects() {
    }

//    public UserSubjects(User user, Subjects subject) {
//        this.user = user;
//        this.subject = subject;
//    }


    // Constructors, getters, and setters

    public Long getUserSubjectId() {
        return userSubjectId;
    }

    public void setUserSubjectId(Long userSubjectId) {
        this.userSubjectId = userSubjectId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Subjects getSubject() {
        return subject;
    }

    public void setSubject(Subjects subject) {
        this.subject = subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSubjects that = (UserSubjects) o;
        return Objects.equals(userSubjectId, that.userSubjectId) && Objects.equals(user, that.user) && Objects.equals(subject, that.subject);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userSubjectId, user, subject);
    }

    @Override
    public String toString() {
        return "User_Subjects{" +
                "userSubjectId=" + userSubjectId +
                ", user=" + user +
                ", subject=" + subject +
                '}';
    }

    public UserSubjects(User user, Subjects subject) {
        this.user = user;
        this.subject = subject;
    }
}