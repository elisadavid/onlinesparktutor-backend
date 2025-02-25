package com.OnlineTutor.tutor.Tutor.Education.stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StreamRepo extends JpaRepository<StreamModel,Long> {

    List<StreamModel> findByEducationLevelId(Long educationlevelId);

}
