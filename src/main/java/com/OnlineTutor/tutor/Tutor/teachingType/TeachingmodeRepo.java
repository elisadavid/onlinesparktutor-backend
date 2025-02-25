package com.OnlineTutor.tutor.Tutor.teachingType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachingmodeRepo extends JpaRepository<TeachingmodeModel,Long> {
}
