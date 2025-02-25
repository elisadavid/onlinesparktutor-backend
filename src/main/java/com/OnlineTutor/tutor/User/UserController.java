package com.OnlineTutor.tutor.User;

import com.OnlineTutor.tutor.Tutor.LoginDto;
import com.OnlineTutor.tutor.Tutor.TutorModel;
import com.OnlineTutor.tutor.User.gender.GenderModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path ="/api/User" )
@CrossOrigin
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

    @DeleteMapping("/delete/user")
    public ResponseEntity<?>deleteuser(@RequestParam Long userId){
        return userService.deleteuser(userId);
    }

    //tutorlist

    @GetMapping("/getuser")
    public ResponseEntity<List<UserModel>> getuser() {
        return userService.getuserlist();
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
}
