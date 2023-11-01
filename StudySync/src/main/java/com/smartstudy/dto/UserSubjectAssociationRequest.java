package com.smartstudy.dto;

import com.smartstudy.entity.Subjects;
import com.smartstudy.entity.User;

import java.util.List;

public class UserSubjectAssociationRequest {
    private User user;
    private List<Subjects> subjects;
    public List<Long> SubjectIds;
    private User userId;

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Subjects> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subjects> subjects) {
        this.subjects = subjects;
    }

    public List<Long> getSubjectIds() {
        return SubjectIds;
    }

    public void setSubjectIds(List<Long> subjectIds) {
        SubjectIds = subjectIds;
    }
}


