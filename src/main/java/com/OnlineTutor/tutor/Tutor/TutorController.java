package com.OnlineTutor.tutor.Tutor;

import com.OnlineTutor.tutor.Tutor.Education.EducationDto;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamDto;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamModel;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamsubDto;
import com.OnlineTutor.tutor.Tutor.availablesession.AvailableModel;
import com.OnlineTutor.tutor.Tutor.dayNames.DayModel;
import com.OnlineTutor.tutor.Tutor.hourlyrate.HourlyrateDto;
import com.OnlineTutor.tutor.Tutor.hourlyrate.HourlyrateModel;
import com.OnlineTutor.tutor.Tutor.qualification.QualificationModel;
import com.OnlineTutor.tutor.Tutor.teachingType.TeachingmodeModel;
import com.OnlineTutor.tutor.Tutor.timeSlot.TimeslotDto;
import com.OnlineTutor.tutor.Tutor.timeSlot.TimeslotModel;
import com.OnlineTutor.tutor.Tutor.weekTypeName.WeekDto;
import com.OnlineTutor.tutor.Tutor.weekTypeName.WeekModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping(path = "/api/tutor")
@CrossOrigin (origins = "http://localhost:8080")
public class TutorController {
    @Autowired
    private TutorService tutorService;

    //tutor registration

    @PostMapping("/tutor_reg")
    public ResponseEntity<?> addtutor(@RequestPart TutorModel tutorModel, @RequestParam MultipartFile qualificationCertificate) {
        try {
            return tutorService.addtutor(tutorModel, qualificationCertificate);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //tutor login

    @PostMapping("/tutor_login")
    public ResponseEntity<?> tutorlogin(@RequestBody LoginDto loginDto) {
        try {
            return tutorService.logintutor(loginDto);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("somtng wnt wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //update,delete

    @PutMapping("/updatetutor")
    public ResponseEntity<?> updatetutor(@RequestParam String email, @RequestParam String password) {
        try {
            return tutorService.updatetutors(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{tutorId}")
    public ResponseEntity<?> deletetutor(@PathVariable Long tutorId) {
        return tutorService.deletetutor(tutorId);
    }

    //tutorlist

    @GetMapping("/gettutor")
    public ResponseEntity<List<TutorModel>> gettutor() {
        return tutorService.gettutor();
    }

    @GetMapping("/getTutor/tutorId")


    //reset tutor password

    @PutMapping("/resetpasswordtutor")
    public ResponseEntity<?> rstpasstutor(@RequestParam String email, @RequestParam String password) {
        try {
            return tutorService.resetuserpassword(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }



//     updation profile

    @PutMapping("/update/profile/{tutorId}")
    public ResponseEntity<String> updateProfile(@PathVariable Long tutorId, @RequestBody ProfileDto dto) {
        boolean updated = tutorService.updateTutorProfile(tutorId, dto);
        if (updated) {
            return ResponseEntity.ok("Tutor profile updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tutor not found");
        }
    }


    // ------------------------------------------------------------------------------------------------------

//    @PostMapping("/addhourlyrate")
//    public ResponseEntity<?> addhourlyrate(@RequestBody HourlyrateModel hourlyrateModel) {
//        try {
//            return tutorService.addhourlyrate(hourlyrateModel);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>("Somethng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    @GetMapping("/gethourlyrate")
//    public ResponseEntity<List<HourlyrateModel>> gethourlyrate() {
//        return tutorService.gethourlyrate();
//    }
//
//    @PutMapping("/updatehourlyrate")
//    public ResponseEntity<?> updatehourlyrate(@RequestParam Long rate_id, @RequestParam double rate, @RequestParam Long DayId,@RequestParam Long teachingModeId, @RequestParam Long tutorId) {
//        try {
//            return tutorService.updatehourlyrate(rate_id, rate,DayId,teachingModeId,tutorId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//    @DeleteMapping("/delete/rate")
//    public ResponseEntity<?>deleteRateDetails(@RequestParam Long rate_id){
//        return tutorService.deleterate(rate_id);
//    }

  //fetchProfile

    @GetMapping("/tutor/profile/{tutorId}")
    public ResponseEntity<ProfileDto> getTutorProfile(@PathVariable Long tutorId) {
        ProfileDto profileDto = tutorService.getTutorProfileById(tutorId);
        return ResponseEntity.ok(profileDto);
    }

    @GetMapping("/gethourlyrate/tutorid")
    public ResponseEntity<List<HourlyrateDto>> gethourlyratebytutorid(@RequestParam Long tutorId) {
        return tutorService.gethourlyratetutorlist(tutorId);
    }
//searchtutor

    //    @GetMapping("/searchtutor/service")
//    public ResponseEntity<?> searchTutors(@RequestParam Long subjectId) {
//        List<TutorsearchDto> tutors = tutorService.searchTutors(subjectId);
//        if (tutors.isEmpty()) {
//            return new ResponseEntity<>("tutors found", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>("No tutors found matching", HttpStatus.OK);
//    }
    @GetMapping("/searchtutor/service")
    public ResponseEntity<?> searchTutors(@RequestParam Long subjectId) {
        List<TutorsearchDto> tutors = tutorService.searchTutors(subjectId);

        if (tutors.isEmpty()) {
            // Return a "not found" message with a 404 status if no tutors were found
            return new ResponseEntity<>("No tutors found for the subject ID: " + subjectId, HttpStatus.NOT_FOUND);
        }

        // Return the list of tutors if found with a 200 OK status
        return new ResponseEntity<>(tutors, HttpStatus.OK);
    }


//scheduling class

//    @PostMapping("/addschedule")
//    public ResponseEntity<?> addscheduling(@RequestBody TimeslotModel timeslotModel) {
//        try {
//            return tutorService.schedule(timeslotModel);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>("SMTHNG WNT WRNG", HttpStatus.INTERNAL_SERVER_ERROR);
//    }

//    @GetMapping(path = "/get/timeslot/scheduling/details")
//    public ResponseEntity<?> getschedulingtimelist(
//            @RequestParam(required = false) Long tutorId,
//            @RequestParam(required = false) Long dayId,
//            @RequestParam(required = false) Long teachingModeId) {
//        try {
//            List<TimeslotDto> result = tutorService.getschedulingtimelist(tutorId,Long dayId,teachingModeId);
//            if (result.isEmpty()) {
//                return new ResponseEntity<>("No scheduling found", HttpStatus.NOT_FOUND);
//            }
//            return new ResponseEntity<>(result, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error fetching scheduling", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }


//fetch schedules ................................................................
    @GetMapping(path = "/get/timeslot/scheduling/details")
    public ResponseEntity<?> getschedulingtimelist(
            @RequestParam(required = false) Long tutorId,
            @RequestParam(required = false) Long dayId
    ) {
        try {
            return tutorService.getDetails(tutorId, dayId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }


    //qualification
    @PostMapping("/add/qualification")
    public ResponseEntity<?> qualification(@RequestBody QualificationModel qualificationModel) {
        try {
            return tutorService.qualification(qualificationModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get/qualification")
    public ResponseEntity<List<QualificationModel>> getqualificationlist() {
        return tutorService.getqualification();
    }

    @PutMapping("/update/qualification")
    public ResponseEntity<?> updateQualification(@RequestParam Long qual_id, @RequestParam String qualification) {
        try {
            return tutorService.updatequalification(qual_id, qualification);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/deletequalification")
    public ResponseEntity<?> deletequal(@RequestParam long qualificationId) {
        return tutorService.deletequal(qualificationId);
    }

    //teachingmode

    @PostMapping("/teachingmode")
    public ResponseEntity<?> addteachingmode(@RequestBody TeachingmodeModel teachingmodeModel) {
        try {
            return tutorService.addteachingmode(teachingmodeModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("smthng wnt wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/teachinglist")
    public ResponseEntity<List<TeachingmodeModel>> getteachinglist() {
        return tutorService.getteachinglist();
    }

    @PutMapping("/updateteachingmode")
    public ResponseEntity<?> updateteachngmode(@RequestParam Long teachingModeId, @RequestParam String teachingMode) {
        try {
            return tutorService.updateteaching(teachingModeId, teachingMode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/deleteteachingmode")
    public ResponseEntity<?> deleteteachingmode(@RequestParam long teachingModeId) {
        return tutorService.deleteteachingmode(teachingModeId);
    }

//weekdetails

    @PostMapping("/weekTypes")
    public ResponseEntity<?> addweektyp(@RequestBody WeekModel weekModel) {
        try {
            return tutorService.week(weekModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("smthng wnt wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/updateWeek")
    public ResponseEntity<?> updateWeek(@RequestParam Long weekId, @RequestParam String week) {
        try {
            return tutorService.updateweek(weekId, week);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/deleteweek")
    public ResponseEntity<?> deleteweek(@RequestParam long weekId) {
        return tutorService.deleteweek(weekId);
    }

    @GetMapping("/weeklist")
    public ResponseEntity<List<WeekModel>> getweeklist() {
        return tutorService.getweeklist();
    }

    @GetMapping(path = "/get/day/week/details")
    public ResponseEntity<List<WeekDto>> getdayweekdetails() {
        return tutorService.getDayFullDetails();
    }


    //daydetails

    @PostMapping("/addDays")
    public ResponseEntity<?> adddays(@RequestBody DayModel dayModel) {
        try {
            return tutorService.addDays(dayModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("smthng wnt wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/updatedays")
    public ResponseEntity<?> updateDays(@RequestParam Long dayId, @RequestParam String days, @RequestParam Long weekId) {
        try {
            return tutorService.updatedays(dayId, days, weekId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/deleteday")
    public ResponseEntity<?> deleteday(@RequestParam long dayId) {
        return tutorService.deleteday(dayId);
    }

    @GetMapping("/dayslist")
    public ResponseEntity<List<DayModel>> getdayslist() {
        return tutorService.getdayslist();
    }

    @PostMapping("/add/availability")
    public ResponseEntity<?> addavailability(@RequestBody AvailableModel availableModel) {
        try {
            return tutorService.addavailability(availableModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Somethng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/availability")
    public ResponseEntity<?> getAllAvailability() {
        try {
            return tutorService.getAllAvailability();
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch availability", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // READ ONE
    @GetMapping("/availability/{id}")
    public ResponseEntity<?> getAvailabilityById(@PathVariable Long id) {
        try {
            return tutorService.getAvailabilityById(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Availability not found", HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE
    @PutMapping("/update/availability/{id}")
    public ResponseEntity<?> updateAvailability(@PathVariable Long id, @RequestBody AvailableModel updatedModel) {
        try {
            return tutorService.updateAvailability(id, updatedModel);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to update availability", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // DELETE
    @DeleteMapping("/delete/availability/{id}")
    public ResponseEntity<?> deleteAvailability(@PathVariable Long id) {
        try {
            return tutorService.deleteAvailability(id);
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to delete availability", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//fetch courses....................................................
    @GetMapping("/getStreamSubDetailsByTutor/{tutorId}")
    public ResponseEntity<?> getStreamSubDetailsByTutor(@PathVariable Long tutorId) {
        try {
            return tutorService.getStreamSubDetailsByTutor(tutorId);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Something went wrong");
        }

    }
    @GetMapping("/getTutorbystream/{streamId}")
    public ResponseEntity<List<TutordetailsDto>> getTutorByStream(@PathVariable Long streamId) {
        try {
            List<TutordetailsDto> tutors = tutorService.gettutorsByStream(streamId);
            return new ResponseEntity<>(tutors, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

//        List<StreamsubDto> streamsubDtoList = tutorService.getStreamSubDetailsByTutor(tutorId);

//        if (streamsubDtoList == null || streamsubDtoList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }

//        return new ResponseEntity<>(streamsubDtoList, HttpStatus.OK);





