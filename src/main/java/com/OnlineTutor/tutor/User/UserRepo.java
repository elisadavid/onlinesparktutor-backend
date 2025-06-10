package com.OnlineTutor.tutor.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository <UserModel,Long>{


    Optional<UserModel> findByEmailAndPassword(String email, String password);
    Optional<UserModel> findByEmail(String email);

//    List<UserModel> findBystreamIdandtutorId(Long streamId , Long tutorId);
List<UserModel> findByStreamIdAndTutorId(Long streamId, Long tutorId);

    List<UserModel> findByStreamId(Long streamId);

    String TutorId(Long tutorId);

    @Query("SELECT COUNT(u) FROM UserModel u WHERE u.tutorId = :tutorId")
    Integer countStudentsByTutorId(@Param("tutorId") Long tutorId);




}
