package com.OnlineTutor.tutor.Tutor.dayNames;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DayRepo extends JpaRepository<DayModel,Long> {

}
