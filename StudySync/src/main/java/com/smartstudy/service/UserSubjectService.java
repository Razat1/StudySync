package com.smartstudy.service;

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

    public void associateSubjectsWithUser(User user, List<Subjects> subjects) {
        for (Subjects subject : subjects) {
            UserSubjects userSubject = new UserSubjects(user, subject);
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

//@Service
//public class UserSubjectService {
//    private final UserSubjectRepository userSubjectRepository;
//
//    public UserSubjectService(UserSubjectRepository userSubjectRepository) {
//        this.userSubjectRepository = userSubjectRepository;
//    }
//
//    public List<UserSubjects> getUserSubjectsForUser(User user) {
//        return userSubjectRepository.findByUser(user);
//    }
//
//    public List<UserSubjects> getUserSubjectsForSubject(Subjects subject) {
//        return userSubjectRepository.findBySubjects(subject);
//    }
//
//    public UserSubjects getUserSubjectById(long userSubjectId) {
//        return userSubjectRepository.findById(userSubjectId).orElse(null);
//    }
//
//    public UserSubjects createUserSubject(UserSubjects userSubjects) {
//        // You can add validation or business logic here if needed
//        return userSubjectRepository.save(userSubjects);
//    }
//
//    public UserSubjects updateUserSubject(UserSubjects userSubjects) {
//        // Check if the user-subject relationship with the given ID exists
//        UserSubjects existingUserSubject = getUserSubjectById(userSubjects.getUser_subject_id());
//        if (existingUserSubject != null) {
//            return userSubjectRepository.save(userSubjects);
//        }
//        return null; // Handle the case where the relationship doesn't exist
//    }
//}
