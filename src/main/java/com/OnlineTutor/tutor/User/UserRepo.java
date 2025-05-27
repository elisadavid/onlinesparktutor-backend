package com.OnlineTutor.tutor.User;

import org.springframework.data.jpa.repository.JpaRepository;
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
}
