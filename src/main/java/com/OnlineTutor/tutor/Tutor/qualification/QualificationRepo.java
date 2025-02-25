package com.OnlineTutor.tutor.Tutor.qualification;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepo extends JpaRepository<QualificationModel,Long> {
}
