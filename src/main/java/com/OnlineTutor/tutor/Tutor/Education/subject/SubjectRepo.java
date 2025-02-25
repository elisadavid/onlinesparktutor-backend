package com.OnlineTutor.tutor.Tutor.Education.subject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubjectRepo extends JpaRepository<SubjectModel,Long> {

    List<SubjectModel> findByStreamId(Long streamId);
}
