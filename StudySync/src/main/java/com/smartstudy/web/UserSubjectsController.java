package com.smartstudy.web;

import com.smartstudy.dto.UserSubjectAssociationRequest;
import com.smartstudy.entity.Subjects;
import com.smartstudy.entity.User;
import com.smartstudy.service.SubjectService;
import com.smartstudy.service.UserService;
import com.smartstudy.service.UserSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class UserSubjectsController {
    @Controller
    @RequestMapping("/user-subjects")
    public static class UserSubjectController {
        @Autowired
        private UserSubjectService userSubjectService;
        @Autowired
        private UserService userService; // Inject the UserService to fetch user information
        @Autowired
        private SubjectService subjectService; // Inject the SubjectService to fetch subject information

        @PostMapping("/associate")
        public ResponseEntity<Void> associateSubjects(@RequestBody UserSubjectAssociationRequest request) {
            // Fetch the user based on the provided user ID
            Long userId = request.getUserId().getId();
            User user = userService.getUserById(userId);

            // Fetch the selected subjects based on subject IDs
            List<Long> subjectIds = request.getSubjectIds();
            List<Subjects> subjects = subjectService.getSubjectIds(subjectIds);

            // Associate the subjects with the user
            userSubjectService.associateSubjectsWithUser(user, subjects);

            return new ResponseEntity<>(HttpStatus.CREATED);
        }
    }
}

