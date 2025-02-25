package com.OnlineTutor.tutor.User;

import com.OnlineTutor.tutor.Tutor.TutorModel;
import com.OnlineTutor.tutor.User.gender.GenderModel;
import com.OnlineTutor.tutor.User.gender.GenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private GenderRepo genderRepo;

    public ResponseEntity<?> adduser(UserModel userModel) {
        UserModel userModel1=new UserModel();
        userModel1.setUserId(userModel.getUserId());
        userModel1.setUsername(userModel.getUsername());
        userModel1.setEmail(userModel.getEmail());
        userModel1.setPassword(userModel.getPassword());
        userModel1.setPhn_no(userModel.getPhn_no());
//        userModel1.setCourse(userModel.getCourse());
        userModel1.setDOB(userModel.getDOB());
//        userModel1.setGender(userModel.getGender());
        userModel1.setLocation(userModel.getLocation());
//        userModel1.setSubj_interest(userModel.getSubj_interest());
        userModel1.setPref_day(userModel.getPref_day());
        userModel1.setPref_time(userModel.getPref_time());
        userRepo.save(userModel1);
        return new ResponseEntity<>(userModel1, HttpStatus.OK);
    }

    public ResponseEntity<?> loginAPI(UserloginDto userloginDto) {
        Optional<UserModel>optionalUserModel=userRepo.findByEmailAndPassword(userloginDto.getEmail(),userloginDto.getPassword());
        if (optionalUserModel.isPresent()){
            return new ResponseEntity<>("LOGIN SUCCESSFULLY",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("LOGIN FAILED",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> gendertype(GenderModel genderModel) {
        GenderModel genderModel1=new GenderModel();
        genderModel1.setGenderId(genderModel.getGenderId());
        genderModel1.setGenderType(genderModel.getGenderType());
        genderRepo.save(genderModel1);
        return new ResponseEntity<>(genderModel1, HttpStatus.OK);

    }

    public ResponseEntity<?> resetuserpassword(String email, String password) {
        Optional<UserModel>optionalUserModel=userRepo.findByEmail(email);
        if (optionalUserModel.isPresent()){
            UserModel userModel=optionalUserModel.get();
            userModel.setPassword(password);
            userRepo.save(userModel);
            return new ResponseEntity<>(userModel,HttpStatus.OK);
        }else {
            return new ResponseEntity<>("user not found",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<GenderModel>> getgenderlist() {
        List<GenderModel>genderModel=genderRepo.findAll();
        return new ResponseEntity<>(genderModel,HttpStatus.OK);
    }


    public ResponseEntity<?> updategender(Long genderId, String genderType) {
        Optional<GenderModel>optionalGenderModel=genderRepo.findById(genderId);
        if (optionalGenderModel.isPresent()){
            GenderModel genderModel=optionalGenderModel.get();
            genderModel.setGenderType(genderType);
            genderRepo.save(genderModel);
            return new ResponseEntity<>("gender updated",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deletegender(long genderId) {
        Optional<GenderModel>optionalGenderModel=genderRepo.findById(genderId);
        if (optionalGenderModel.isPresent()) {
            GenderModel genderModel=optionalGenderModel.get();
            genderRepo.delete(genderModel);
            return new ResponseEntity<>("gender deleted",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> updateuser(String email, String password) {
        Optional<UserModel> optionalUserModel = userRepo.findByEmail(email);
        if (optionalUserModel.isPresent()) {
            UserModel userModel = optionalUserModel.get();
            userModel.setEmail(email);
            userModel.setPassword(password);
            userRepo.save(userModel);
            return new ResponseEntity<>("user updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteuser(Long userId) {
        Optional<UserModel> optionalUserModel = userRepo.findById(userId);
        if (optionalUserModel.isPresent()) {
            UserModel userModel = optionalUserModel.get();
            userRepo.delete(userModel);
            return new ResponseEntity<>("user deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<UserModel>> getuserlist() {
        List<UserModel> userModel = userRepo.findAll();
        return new ResponseEntity<>(userModel, HttpStatus.OK);
    }
}


