package com.OnlineTutor.tutor.Tutor.weekTypeName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekRepo extends JpaRepository<WeekModel,Long> {
}
