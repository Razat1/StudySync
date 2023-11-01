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

//
//@Service
//    public class SubjectService {
//    private final SubjectRepository subjectRepository;
//    public SubjectService(SubjectRepository subjectRepository){
//        this.subjectRepository = subjectRepository;
//    }
//
//        public List<Subjects> getAllSubjects() {
//            return subjectRepository.findAll();
//        }
//
//        public Subjects getSubjectById(long subjectId) {
//            return subjectRepository.findById(subjectId).orElse(null);
//        }
//
//        public List<Subjects> getSubjectsByCriteria(String criteria) {
//
//            return null;
//        }
//
//        public Subjects createSubject(Subjects subject) {
//            return subjectRepository.save(subject);
//        }
//
//        public Subjects updateSubject(Subjects subject) {
//            // Check if the subject with the given ID exists
//            Subjects existingSubject = getSubjectById(subject.getSubjectId());
//            if (existingSubject != null) {
//                return subjectRepository.save(subject);
//            }
//            return null; // Handle the case where the subject doesn't exist
//        }
//    }
//
