package com.OnlineTutor.tutor.Tutor.timeSlot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimeslotRepo extends JpaRepository<TimeslotModel,Long> {


//    List<TimeslotModel> findAllByTutorIdAndDayId(Long tutorId, Long dayId);
//    Optional<TimeslotModel> findByTutorIdAndDayIdAndStartTimeAndEndTime(Long tutorId, Long dayId, LocalTime startTime, LocalTime endTime);
}
