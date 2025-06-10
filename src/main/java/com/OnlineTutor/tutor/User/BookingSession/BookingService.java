package com.OnlineTutor.tutor.User.BookingSession;

import com.OnlineTutor.tutor.Tutor.qualification.QualificationModel;
import com.OnlineTutor.tutor.User.UserModel;
import com.OnlineTutor.tutor.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
 public class BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private UserRepo userRepo;

    public BookingModel create(BookingModel bookingModel) {


        if (bookingModel.getStatusId() == null) {
            bookingModel.setStatusId(1L); // default status = Confirmed or Active
        }
        Long subjectId = bookingModel.getSubjectId();
        Long streamId = bookingModel.getStreamId();
        Long userId = bookingModel.getUserId();
        Long tutorId = bookingModel.getTutorId();

        Optional<UserModel> optionalUser = userRepo.findById(userId);
        if (optionalUser.isPresent()) {
            UserModel userModel = optionalUser.get(); // ✅ Get the existing user
            userModel.setTutorId(tutorId);// ✅ Update tutorId
            userModel.setStreamId(streamId);
            userModel.setSubjectId(subjectId);
            userRepo.save(userModel);                // ✅ Save updated user
        }

        // Save booking in DB
        return bookingRepo.save(bookingModel);
    }

    // Get bookings by tutor ID
    public List<BookingModel> getTutorBookings(Long tutorId) {
        return bookingRepo.findByTutorId(tutorId);
    }

    // Get bookings by user ID
    public List<BookingModel> getUserBookings(Long userId) {
        return bookingRepo.findByUserId(userId);
    }

    // Cancel booking by setting statusId to a cancel code (e.g., 0)
    public void cancelBooking(Long bookingId) {
        Optional<BookingModel> optionalBooking = bookingRepo.findById(bookingId);
        if (optionalBooking.isPresent()) {
            BookingModel booking = optionalBooking.get();
            booking.setStatusId(0L); // 0 = Cancelled
            bookingRepo.save(booking);
        } else {
            throw new RuntimeException("Booking not found with ID: " + bookingId);
        }
    }

    // Confirm booking by setting statusId = 1
    public void confirmBooking(Long bookingId) {
        Optional<BookingModel> optionalBooking = bookingRepo.findById(bookingId);
        if (optionalBooking.isPresent()) {
            BookingModel booking = optionalBooking.get();
            booking.setStatusId(1L); // 1 = Confirmed
            bookingRepo.save(booking);
        } else {
            throw new RuntimeException("Booking not found with ID: " + bookingId);
        }
    }
}

