package com.smartstudy.repository;

import com.smartstudy.entity.Subjects;
import com.smartstudy.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface SubjectRepository extends JpaRepository<Subjects, Long> {
//List<Subjects> findByUser(User user);
}
