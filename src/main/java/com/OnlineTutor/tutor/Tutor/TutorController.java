package com.OnlineTutor.tutor.Tutor;

import com.OnlineTutor.tutor.Tutor.Education.EducationDto;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamDto;
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

import java.util.List;

@RestController
@RequestMapping(path = "/api/tutor")
@CrossOrigin
public class TutorController {
    @Autowired
    private TutorService tutorService;

    //tutor registration

    @PostMapping("/tutor_reg")
    public ResponseEntity<?> adduser(@RequestBody TutorModel tutorModel) {
        try {
            return tutorService.adduser(tutorModel);
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
            return tutorService.updatetutors(email,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/tutor")
    public ResponseEntity<?>deletetutor(@RequestParam Long tutorId){
        return tutorService.deletetutor(tutorId);
    }

    //tutorlist

    @GetMapping("/gettutor")
    public ResponseEntity<List<TutorModel>> gettutor() {
        return tutorService.gettutor();
    }

    //reset tutor password

    @PutMapping("/resetpasswordtutor")
    public ResponseEntity<?>rstpasstutor(@RequestParam String email,@RequestParam String password){
        try {
            return tutorService.resetuserpassword(email,password);
        } catch (Exception e) {
            e.printStackTrace();
        }return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    // ------------------------------------------------------------------------------------------------------

    @PostMapping("/addhourlyrate")
    public ResponseEntity<?> addhourlyrate(@RequestBody HourlyrateModel hourlyrateModel) {
        try {
            return tutorService.addhourlyrate(hourlyrateModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Somethng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @GetMapping("/gethourlyrate")
    public ResponseEntity<List<HourlyrateModel>> gethourlyrate() {
        return tutorService.gethourlyrate();
    }

    @PutMapping("/updatehourlyrate")
    public ResponseEntity<?> updatehourlyrate(@RequestParam Long rate_id, @RequestParam double rate, @RequestParam Long DayId,@RequestParam Long teachingModeId, @RequestParam Long tutorId) {
        try {
            return tutorService.updatehourlyrate(rate_id, rate,DayId,teachingModeId,tutorId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/delete/rate")
    public ResponseEntity<?>deleteRateDetails(@RequestParam Long rate_id){
        return tutorService.deleterate(rate_id);
    }

    @GetMapping("/gethourlyrate/tutorid")
    public ResponseEntity<List<HourlyrateDto>>gethourlyratebytutorid(@RequestParam Long tutorId){
        return tutorService.gethourlyratetutorlist(tutorId);}
//searchtutor

//    @PostMapping("/searchtutor/service")
//    public ResponseEntity<?> searchTutors(@RequestBody TutorsearchDto tutorSearchDto) {
//        List<TutorModel> tutors = tutorService.searchTutors(tutorSearchDto);
//        if (tutors.isEmpty()) {
//            return new ResponseEntity<>("No tutors found matching", HttpStatus.NOT_FOUND);
//        }
//        return new ResponseEntity<>("tutors found", HttpStatus.OK);
//    }

//scheduling class

    @PostMapping("/addschedule")
    public ResponseEntity<?> addscheduling(@RequestBody TimeslotModel timeslotModel) {
        try {
            return tutorService.schedule(timeslotModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("SMTHNG WNT WRNG", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/get/timeslot/scheduling/details")
    public ResponseEntity<List<TimeslotDto>>getschedulingtimelist(){
        return tutorService.getschedulelist();
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
    public ResponseEntity<?>deletequal(@RequestParam long qualificationId){
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
            return tutorService.updateteaching(teachingModeId,teachingMode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/deleteteachingmode")
    public ResponseEntity<?>deleteteachingmode(@RequestParam long teachingModeId){
        return tutorService.deleteteachingmode(teachingModeId);
    }

//weekdetails

    @PostMapping("/weekTypes")
    public ResponseEntity<?>addweektyp(@RequestBody WeekModel weekModel){
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
            return tutorService.updateweek(weekId,week);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/deleteweek")
    public ResponseEntity<?>deleteweek(@RequestParam long weekId){
        return tutorService.deleteweek(weekId);
    }

    @GetMapping("/weeklist")
    public ResponseEntity<List<WeekModel>> getweeklist() {
        return tutorService.getweeklist();
    }

    @GetMapping(path = "/get/day/week/details")
    public ResponseEntity<List<WeekDto>>getdayweekdetails(){
        return tutorService.getDayFullDetails();
    }


    //daydetails

    @PostMapping("/addDays")
    public ResponseEntity<?>adddays(@RequestBody DayModel dayModel){
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
    public ResponseEntity<?>deleteday(@RequestParam long dayId){
        return tutorService.deleteday(dayId);
    }

    @GetMapping("/dayslist")
    public ResponseEntity<List<DayModel>> getdayslist() {
        return tutorService.getdayslist();
    }
}