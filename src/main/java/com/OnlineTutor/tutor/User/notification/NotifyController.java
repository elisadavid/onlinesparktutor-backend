package com.OnlineTutor.tutor.User.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api/notify")

public class NotifyController {
    @Autowired
    private NotifyRepo notifyRepo;

    @PostMapping("/user")
    public ResponseEntity<?> notifyUser(@RequestBody Map<String, Object> payload) {
        try {
            Long userId = Long.valueOf(payload.get("userId").toString());
            Long tutorId = Long.valueOf(payload.get("tutorId").toString());

            String message = payload.get("message").toString();

            NotifyModel notification = new NotifyModel();
            notification.setUserId(userId);
            notification.setTutorId(tutorId);
            notification.setMessage(message);
            notification.setTimestamp(LocalDateTime.now());
            notifyRepo.save(notification);

            return new ResponseEntity<>("Notification sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to send notification", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Optional: View user notifications
    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getUserNotifications(@PathVariable Long userId) {
        List<NotifyModel> list = notifyRepo.findByUserId(userId);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

}
