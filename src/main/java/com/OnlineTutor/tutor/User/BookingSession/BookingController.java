package com.OnlineTutor.tutor.User.BookingSession;

import com.OnlineTutor.tutor.Tutor.dayNames.DayModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;


    // Create a new booking session
    @PostMapping("/create")
    public ResponseEntity<?> createBookingSession(@RequestBody BookingModel bookingModel) {
        try {
            BookingModel savedBooking = bookingService.create(bookingModel);
            return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Something went wrong while creating booking.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Get bookings by tutorId
    @GetMapping("/tutor/{tutorId}")
    public ResponseEntity<List<BookingModel>> getTutorBookings(@RequestParam Long tutorId) {
        List<BookingModel> bookings = bookingService.getTutorBookings(tutorId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // Get bookings by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingModel>> getUserBookings(@RequestParam Long userId) {
        List<BookingModel> bookings = bookingService.getUserBookings(userId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    // Cancel booking by bookingId
    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<String> cancelBooking(@RequestParam Long bookingId) {
        try {
            bookingService.cancelBooking(bookingId);
            return new ResponseEntity<>("Booking cancelled successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Booking cancellation failed.", HttpStatus.NOT_FOUND);
        }
    }
}


