package com.OnlineTutor.tutor.Admin;

import com.OnlineTutor.tutor.Tutor.Education.EducationDto;
import com.OnlineTutor.tutor.Tutor.Education.EducationModel;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamDto;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamModel;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamsubDto;
import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectDto;
import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectModel;
import com.OnlineTutor.tutor.Admin.status.StatusModel;
import com.OnlineTutor.tutor.Tutor.TutorModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/register")
    public ResponseEntity<?> reg(@RequestBody AdminModel adminModel) {
        try {
            return adminService.register(adminModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Email already taken", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AdminloginDto adminloginDto) {
        try {
            return adminService.loginAPI(adminloginDto);
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new ResponseEntity<>("somtng wnt wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/updateAdmin")
    public ResponseEntity<?> updateAdmin(@RequestParam String email, @RequestParam String password) {
        try {
            return adminService.updateadmin(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/admin")
    public ResponseEntity<?> deleteAdmin(@RequestParam Long adminId) {
        return adminService.deleteadmin(adminId);
    }

    @GetMapping("/getAdmin")
    public ResponseEntity<List<AdminModel>> getadmin() {
        return adminService.getadmin();
    }

    @GetMapping("/get/alltutors/list")
    public ResponseEntity<List<TutorModel>> gettutorlist() {
        return adminService.gettutorlist();
    }


    //reset password

    @PutMapping("/resetPasswordForAdmin")
    public ResponseEntity<?> rstPassAdmin(@RequestParam String email, @RequestParam String password) {
        try {
            return adminService.resetuserpassword(email, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //view all tutorslist


//educationLevel

    @PostMapping("/addEducationLevel")
    public ResponseEntity<?> addEducationLevel(@RequestBody EducationModel educationModel) {
        try {
            return adminService.addeducationlevel(educationModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("smthng wnt wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get/education")
    public ResponseEntity<List<EducationModel>> getEducationList() {
        return adminService.getEducation();
    }

    @PutMapping("/updateEducation")
    public ResponseEntity<?> updateEducation(@RequestParam Long educationlevelId, @RequestParam String educationLevel) {
        try {
            return adminService.updateEducationlevel(educationlevelId, educationLevel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/deleteEducationLevel")
    public ResponseEntity<?> deleteEducation(@RequestParam long educationlevelId) {
        return adminService.deleteEducationLevel(educationlevelId);
    }

    @GetMapping("/getEducationalStream")
    public ResponseEntity<List<EducationDto>> getEducationalStream(@RequestParam Long educationlevelId) {
        return adminService.geteducationalstream(educationlevelId);
    }

    @PostMapping("/addStream")
    public ResponseEntity<?> addStream(@RequestBody StreamModel streamModel) {
        try {
            return adminService.addstream(streamModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("smthng wnt wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get/stream")
    public ResponseEntity<List<StreamModel>> getStreamList() {
        return adminService.getstream();
    }

    @PutMapping("/update/stream")
    public ResponseEntity<?> updateStream(@RequestParam Long streamId, @RequestParam String streamName, @RequestParam Long educationlevelId) {
        try {
            return adminService.updatestream(educationlevelId, streamName, streamId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/Stream")
    public ResponseEntity<?> deleteStream(@RequestParam long streamId) {
        return adminService.deletestream(streamId);
    }

    @GetMapping(path = "/getStreamFullDetails")
    public ResponseEntity<List<StreamDto>> getStreamFullDetails() {
        return adminService.getStreamFullDetails();
    }

    //subject
    @PostMapping("/add/subjects")
    public ResponseEntity<?> addSubjects(@RequestBody SubjectModel subjectModel) {
        try {
            return adminService.addsubject(subjectModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("smthng wnt wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/get/subject")
    public ResponseEntity<List<SubjectModel>> getSubjectList() {
        return adminService.getsubject();
    }

    @PutMapping("/update/subject")
    public ResponseEntity<?> updateSubject(@RequestParam Long subjectId, @RequestParam String subjectName, @RequestParam Long streamId) {
        try {
            return adminService.updatesubject(subjectId, subjectName, streamId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/Subject")
    public ResponseEntity<?> deleteSubject(@RequestParam long subjectId) {
        return adminService.deleteSub(subjectId);
    }

    @GetMapping(path = "/getSubFullDetails")
    public ResponseEntity<List<SubjectDto>> getSubFullDetails() {
        return adminService.getsubjectdetails();
    }

    @GetMapping(path = "/getStreamSubjectDetails")
    public ResponseEntity<List<StreamsubDto>> getStreamSubDetails(@RequestParam Long streamId) {
        return adminService.getstreamsubdetails(streamId);
    }

    //status
    @PostMapping("/addStatus")
    public ResponseEntity<?> addStatus(@RequestBody StatusModel statusModel) {
        try {
            return adminService.addstatus(statusModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("smthng wnt wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping(path = "/getStatus")
    public ResponseEntity<List<StatusModel>> getStatus() {
        return adminService.getStatus();
    }

    @PutMapping(path = "/updateStatus")
    public ResponseEntity<?> updateStatus(@RequestParam Long statusId, @RequestParam String status) {
        try {
            return adminService.updateStatus(statusId, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping(path = "/deleteStatus")
    public ResponseEntity<?> deleteStatus(@RequestParam Long statusId) {
        return adminService.deleteStatus(statusId);
    }

//    @PutMapping("/updateTutorStatus")
//    public ResponseEntity<?> updTutorStatus(@RequestParam Long tutorId, @RequestParam Long statusId, @RequestParam Long userId) {
//        try {
//            return adminService.updatetutorStatus(tutorId, statusId, userId);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @PutMapping("/admin/update-booking-status")
    public ResponseEntity<?> updateBookingStatus(@RequestParam Long bookingId, @RequestParam Long statusId) {
        try {
            return adminService.updatetutorStatus(bookingId, statusId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}



