package com.smartstudy.service;

import com.smartstudy.config.CustomUser;
import com.smartstudy.entity.Subjects;
import com.smartstudy.entity.User;
import com.smartstudy.entity.UserSubjects;
import com.smartstudy.repository.UserSubjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserSubjectService {
    private final UserSubjectRepository userSubjectRepository;

    public UserSubjectService(UserSubjectRepository userSubjectRepository) {
        this.userSubjectRepository = userSubjectRepository;
    }

    public void associateSubjectsWithUser(CustomUser customUser, List<Subjects> subjects) {
        for (Subjects subject : subjects) {
            UserSubjects userSubject = new UserSubjects(customUser.getUser(), subject);
            userSubjectRepository.save(userSubject);
        }
    }

    public List<Subjects> getUserSubjects(User user) {
        return userSubjectRepository.findByUser(user);
    }

    public void removeUserSubjectAssociation(User user, Subjects subject) {
        userSubjectRepository.deleteByUserAndSubject(user, subject);
    }

}
