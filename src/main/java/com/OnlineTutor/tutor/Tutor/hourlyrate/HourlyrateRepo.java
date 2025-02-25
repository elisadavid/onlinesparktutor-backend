package com.OnlineTutor.tutor.Tutor.hourlyrate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface HourlyrateRepo extends JpaRepository<HourlyrateModel,Long> {
    List<HourlyrateModel> findByTutorId(Long tutorId);

    Optional<HourlyrateModel> findByTutorIdAndRate(Long tutorId, double rate);
}
