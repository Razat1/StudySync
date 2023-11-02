package com.smartstudy.service;

import com.smartstudy.entity.Subjects;
import com.smartstudy.repository.SubjectRepository;
import com.smartstudy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.util.List;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public List<Subjects> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public void addSubject(Subjects subject) {
        subjectRepository.save(subject);
    }

    public List<Subjects> getSubjectIds(List<Long> subjectIds) {
        return subjectRepository.findAllById(subjectIds);
    }
}


