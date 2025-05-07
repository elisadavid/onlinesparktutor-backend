package com.OnlineTutor.tutor.Tutor.availablesession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AvailableRepo extends JpaRepository<AvailableModel,Long> {
    List<AvailableModel> findAllByTutorId(Long tutorId);

//    List<AvailableModel> findAllByTutorIdAndDayId(Long tutorId, Long dayId);
}
