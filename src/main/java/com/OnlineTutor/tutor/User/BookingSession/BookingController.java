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
        System.out.println("Received booking: " + bookingModel);
        try {
            BookingModel savedBooking = bookingService.create(bookingModel);
            return new ResponseEntity<>(savedBooking, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Invalid request or something went wrong while creating booking.", HttpStatus.BAD_REQUEST);
        }
    }



    @GetMapping("/tutor/{tutorId}")
    public ResponseEntity<List<BookingModel>> getTutorBookings(@PathVariable Long tutorId) {
        List<BookingModel> bookings = bookingService.getTutorBookings(tutorId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BookingModel>> getUserBookings(@PathVariable Long userId) {
        List<BookingModel> bookings = bookingService.getUserBookings(userId);
        return new ResponseEntity<>(bookings, HttpStatus.OK);
    }

    @DeleteMapping("/cancel/{bookingId}")
    public ResponseEntity<String> cancelBooking(@PathVariable Long bookingId) {
        try {
            bookingService.cancelBooking(bookingId);
            return new ResponseEntity<>("Booking cancelled successfully.", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/confirm/{bookingId}")
    public ResponseEntity<String> confirmBooking(@PathVariable Long bookingId) {
        try {
            bookingService.confirmBooking(bookingId);
            return new ResponseEntity<>("Booking confirmed successfully.", HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}



