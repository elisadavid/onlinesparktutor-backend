package com.OnlineTutor.tutor.Tutor;

import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TutorRepo extends JpaRepository<TutorModel,Long> {
    

    Optional<TutorModel> findByEmail(String email);

    Optional<TutorModel> findByEmailAndPassword(String email, String password);

//    List<TutorModel> findBySubjectId(Long subjectId);

    List<TutorModel> findBySubjectId(Long subjectId);

    @Query("SELECT t FROM TutorModel t WHERE t.tutor_id = :tutorId")
    List<TutorModel> findByTutorId(Long tutorId);
}
