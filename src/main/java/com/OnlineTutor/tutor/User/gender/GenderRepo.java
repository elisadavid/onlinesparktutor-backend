package com.OnlineTutor.tutor.User.gender;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenderRepo extends JpaRepository<GenderModel,Long> {
}
