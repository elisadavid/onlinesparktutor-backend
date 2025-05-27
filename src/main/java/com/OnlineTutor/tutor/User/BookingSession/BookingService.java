package com.OnlineTutor.tutor.User.BookingSession;

import com.OnlineTutor.tutor.Tutor.qualification.QualificationModel;
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
// Create a new booking


    public BookingModel create(BookingModel bookingModel) {
         // Default status
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

    // Cancel a booking by setting its status
    public void cancelBooking(Long bookingId) {
        Optional<BookingModel> optionalBooking = bookingRepo.findById(bookingId);
        if (optionalBooking.isPresent()) {
            BookingModel booking = optionalBooking.get();
//            booking.setStatus("Cancelled");
            bookingRepo.save(booking);
        } else {
            throw new RuntimeException("Booking not found with ID: " + bookingId);
        }
    }
}


