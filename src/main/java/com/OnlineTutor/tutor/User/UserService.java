package com.OnlineTutor.tutor.User;

import com.OnlineTutor.tutor.Tutor.Education.EducationRepo;
import com.OnlineTutor.tutor.Tutor.TutorModel;
import com.OnlineTutor.tutor.User.gender.GenderModel;
import com.OnlineTutor.tutor.User.gender.GenderRepo;
import com.OnlineTutor.tutor.User.specificgoal.SpecificgoalModel;
import com.OnlineTutor.tutor.User.specificgoal.SpecificgoalRepo;
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
    @Autowired
    private SpecificgoalRepo specificgoalRepo;
    @Autowired
    private EducationRepo educationRepo;

    public ResponseEntity<?> adduser(UserModel userModel) {

        UserModel userModel1=new UserModel();
//        userModel1.setUserId(userModel.getUserId());
        userModel1.setUsername(userModel.getUsername());
        userModel1.setEmail(userModel.getEmail());
        userModel1.setPassword(userModel.getPassword());
        userModel1.setPhn_no(userModel.getPhn_no());
        userModel1.setLocation(userModel.getLocation());
        userModel1.setTeachingModeId(userModel.getTeachingModeId());
        userModel1.setWeekId(userModel.getWeekId());
        userModel1.setEducationLevelId(userModel.getEducationLevelId());
        userModel1.setSpecificGoalId(userModel.getSpecificGoalId());
//        userModel1.setSubjectId(userModel.getSubjectId());
//        userModel1.setPaymentId(userModel.getPaymentId());
        userRepo.save(userModel1);
        return new ResponseEntity<>(userModel1, HttpStatus.OK);
    }

    public ResponseEntity<?> loginAPI(UserloginDto userloginDto) {
        Optional<UserModel>optionalUserModel=userRepo.findByEmailAndPassword(userloginDto.getEmail(),userloginDto.getPassword());
        if (optionalUserModel.isPresent()){
            return new ResponseEntity<>("LOGIN SUCCESSFULLY",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("LOGIN FAILED",HttpStatus.NOT_FOUND);
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

    public ResponseEntity<?> specificagoals(SpecificgoalModel specificgoalModel) {
        SpecificgoalModel specificgoalModel1=new SpecificgoalModel();
        specificgoalModel1.setSpecificGoalId(specificgoalModel.getSpecificGoalId());
        specificgoalModel1.setSpecificGoal(specificgoalModel.getSpecificGoal());
        specificgoalRepo.save(specificgoalModel1);
        return new ResponseEntity<>(specificgoalModel1, HttpStatus.OK);
    }


    public ResponseEntity<List<SpecificgoalModel>> getSpecificgoal() {
        List<SpecificgoalModel>specificgoalModel=specificgoalRepo.findAll();
        return new ResponseEntity<>(specificgoalModel,HttpStatus.OK);
    }

    public ResponseEntity<?> updatespecificgoal(Long specificGoalId, String specificGoal) {
        Optional<SpecificgoalModel>optionalSpecificgoalModel=specificgoalRepo.findById(specificGoalId);
        if (optionalSpecificgoalModel.isPresent()){
            SpecificgoalModel specificgoalModel=optionalSpecificgoalModel.get();
            specificgoalModel.setSpecificGoal(specificGoal);
            specificgoalRepo.save(specificgoalModel);
            return new ResponseEntity<>("specificgoal updated",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteSpecificGoal(long specificGoalId) {
        Optional<SpecificgoalModel>optionalSpecificgoalModel=specificgoalRepo.findById(specificGoalId);
        if (optionalSpecificgoalModel.isPresent()) {
            SpecificgoalModel specificgoalModel=optionalSpecificgoalModel.get();
            specificgoalRepo.delete(specificgoalModel);
            return new ResponseEntity<>("specificgoal deleted",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("NOT FOUND",HttpStatus.NOT_FOUND);
        }
    }
}


