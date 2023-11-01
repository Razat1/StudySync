package com.smartstudy.web;

import com.smartstudy.entity.Subjects;
import com.smartstudy.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PersonalController {
    private final SubjectService subjectService;

    @Autowired
    public PersonalController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @GetMapping("/subjects")
    public String getSubjectsPage(Model model) {
        List<Subjects> subjects = subjectService.getAllSubjects();
        model.addAttribute("subjects", subjects); // Add subjects to the model
        model.addAttribute("subjectRequest", new Subjects());
        return "Subjects";
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subjects>> getAllSubjects() {
        List<Subjects> subjects = subjectService.getAllSubjects();
        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Subjects> addSubject(@RequestBody Subjects subject) {
        subjectService.addSubject(subject);
        return new ResponseEntity<>(subject, HttpStatus.CREATED);
    }
}

