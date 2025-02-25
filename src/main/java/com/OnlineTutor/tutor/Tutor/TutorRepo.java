package com.OnlineTutor.tutor.Tutor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TutorRepo extends JpaRepository<TutorModel,Long> {
    

    Optional<TutorModel> findByEmail(String email);

    Optional<TutorModel> findByEmailAndPassword(String email, String password);
}
