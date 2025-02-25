package com.OnlineTutor.tutor.Tutor.Education;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepo extends JpaRepository<EducationModel,Long> {

    List<EducationModel> findByEducationLevelId(Long educationlevelId);
}
