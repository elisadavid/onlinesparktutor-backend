package com.OnlineTutor.tutor.User;

import com.OnlineTutor.tutor.Tutor.Education.stream.StreamsubDto;
import com.OnlineTutor.tutor.Tutor.LoginDto;
import com.OnlineTutor.tutor.Tutor.TutorModel;
import com.OnlineTutor.tutor.User.gender.GenderModel;
import com.OnlineTutor.tutor.User.specificgoal.SpecificgoalModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/User" )
@CrossOrigin(origins = "http://localhost:8080")
public class UserController {
    @Autowired
    private UserService userService;

    //registration
    @PostMapping("/register")
    public ResponseEntity<?> adduser(@RequestBody UserModel userModel) {
        try {
            return userService.adduser(userModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //login
    @PostMapping("/login")
    public ResponseEntity<?>userlogin(@RequestBody UserloginDto userloginDto){
        try {
            return userService.loginAPI(userloginDto);
        }catch (Exception e){
            e.printStackTrace();
        }
   return new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PutMapping("/updateuser")
    public ResponseEntity<?> updateuser(@RequestParam String email, @RequestParam String password) {
        try {
            return userService.updateuser(email,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<?>deleteuser(@PathVariable Long userId){
        return userService.deleteuser(userId);
    }

    //tutorlist

    @GetMapping("/getuser")
    public ResponseEntity<List<UserModel>> getuser() {
        return userService.getuserlist();
    }


   //profile..................................
   @GetMapping("/user/profile/{userId}")
   public ResponseEntity<UserproDto> getUserprofile(@PathVariable Long userId) {
       UserproDto userproDto = userService.getUserprofileById(userId);
       return ResponseEntity.ok(userproDto);
   }


//    updation profile

    @PutMapping("/update/profile/{userId}")
    public ResponseEntity<String> updateProfile(@PathVariable Long userId, @RequestBody UserproDto dto) {
        boolean updated = userService.updateUserProfile(userId, dto);
        if (updated) {
            return ResponseEntity.ok("user profile updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
    }

    @GetMapping("/genderlist")
    public ResponseEntity<List<GenderModel>> getgenderlist() {
        return userService.getgenderlist();
    }

    @PutMapping("/updategender")
    public ResponseEntity<?> updategender(@RequestParam Long genderId, @RequestParam String genderType) {
        try {
            return userService.updategender(genderId,genderType);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/deletegender")
    public ResponseEntity<?>deltegender(@RequestParam long genderId){
        return userService.deletegender(genderId);
    }


    //forgot password
    @PutMapping(path = "/resetpassworduser")
    public ResponseEntity<?>rstpass(@RequestParam String email,@RequestParam String password){
        try {
            return userService.resetuserpassword(email,password);
        } catch (Exception e) {
            e.printStackTrace();
        }return new ResponseEntity<>("Something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //gender
    @PostMapping("/gender")
    public ResponseEntity<?>gendertyp(@RequestBody GenderModel genderModel){
        try {
            return userService.gendertype(genderModel);
        } catch (Exception e) {
            e.printStackTrace();
        }return new ResponseEntity<>("Smthng wnt wrng",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //specific goal

    @PostMapping("/add/specificGoal")
    public ResponseEntity<?>specificgoal(@RequestBody SpecificgoalModel specificgoalModel){
        try {
            return userService.specificagoals(specificgoalModel);
        } catch (Exception e) {
            e.printStackTrace();
        }return new ResponseEntity<>("Smthng wnt wrng",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @GetMapping("/specificGoal/list")
    public ResponseEntity<List<SpecificgoalModel>> getspecificlist() {
        return userService.getSpecificgoal();
    }

    @PutMapping("/update/specificGoal")
    public ResponseEntity<?> updatespecificgoal(@RequestParam Long specificGoalId, @RequestParam String specificGoal) {
        try {
            return userService.updatespecificgoal(specificGoalId,specificGoal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("Smthng wnt wrng", HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @DeleteMapping("/delete/specificGoal")
    public ResponseEntity<?>deleteSpecificGoal(@RequestParam long specificGoalId){
        return userService.deleteSpecificGoal(specificGoalId);
    }

//    @GetMapping("/users/stream/{streamId}")
//    public ResponseEntity<?> getUsersByStreamId(@RequestParam Long streamId) {
//        List<UserModel> userModelList = userRepo.findById(streamId);
//        if (!userModelList.isEmpty()) {
//            return new ResponseEntity<>(userModelList, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("No users found for streamId: " + streamId, HttpStatus.NOT_FOUND);
//        }
//    }


    //fetchUsers..............................................

           @GetMapping("/users/stream")
        public ResponseEntity<?> getUsersByStreamId(@RequestParam Long streamId, @RequestParam Long tutorId) {
    try {
        return userService.getUsersByStreamId(streamId,tutorId);
    } catch (Exception e) {
        return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
    }
}

       }
