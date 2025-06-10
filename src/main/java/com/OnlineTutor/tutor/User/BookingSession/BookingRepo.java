package com.OnlineTutor.tutor.User.BookingSession;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
    public interface BookingRepo  extends JpaRepository<BookingModel, Long> {
        List<BookingModel> findByTutorId(Long tutorId);
        List<BookingModel> findByUserId(Long userId);

    List<BookingModel> findByStreamIdAndTutorId(Long streamId, Long tutorId);
}


