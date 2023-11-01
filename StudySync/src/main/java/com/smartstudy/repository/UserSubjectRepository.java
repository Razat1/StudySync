package com.smartstudy.repository;

import com.smartstudy.entity.Subjects;
import com.smartstudy.entity.User;
import com.smartstudy.entity.UserSubjects;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface UserSubjectRepository extends JpaRepository<UserSubjects, Long> {
    List<Subjects> findByUser(User user);

    void deleteByUserAndSubject(User user, Subjects subject);
    // You can add custom query methods here if needed
}
