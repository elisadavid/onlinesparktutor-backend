package com.OnlineTutor.tutor.User;

import com.OnlineTutor.tutor.Tutor.Education.EducationRepo;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamRepo;
import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectRepo;
import com.OnlineTutor.tutor.Tutor.TutorModel;
import com.OnlineTutor.tutor.Tutor.TutorRepo;
import com.OnlineTutor.tutor.Tutor.availablesession.AvailableModel;
import com.OnlineTutor.tutor.User.BookingSession.BookingModel;
import com.OnlineTutor.tutor.User.BookingSession.BookingRepo;
import com.OnlineTutor.tutor.User.gender.GenderModel;
import com.OnlineTutor.tutor.User.gender.GenderRepo;
import com.OnlineTutor.tutor.User.specificgoal.SpecificgoalModel;
import com.OnlineTutor.tutor.User.specificgoal.SpecificgoalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
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
    @Autowired
    private StreamRepo streamRepo;
    @Autowired
    private TutorRepo tutorRepo;
    @Autowired
    SubjectRepo subjectRepo;
    @Autowired
    private BookingRepo bookingRepo;


    public ResponseEntity<?> adduser(UserModel userModel) {

        UserModel userModel1 = new UserModel();
//        userModel1.setUserId(userModel.getUserId());
        userModel1.setUsername(userModel.getUsername());
        userModel1.setEmail(userModel.getEmail());
        userModel1.setPassword(userModel.getPassword());
        userModel1.setPhn_no(userModel.getPhn_no());
        userModel1.setLocation(userModel.getLocation());
        userModel1.setTeachingModeId(userModel.getTeachingModeId());
        userModel1.setTeachingMode(userModel.getTeachingMode());
        userModel1.setWeekId(userModel.getWeekId());
        userModel1.setEducationLevelId(userModel.getEducationLevelId());
        userModel1.setSpecificGoalId(userModel.getSpecificGoalId());
        userModel1.setSubjectId(userModel.getSubjectId());
        userModel1.setStreamId(userModel.getStreamId());
        userModel1.setTutorId(userModel.getTutorId());
        userModel1.setStreamName(userModel.getStreamName());
//        userModel1.setPaymentId(userModel.getPaymentId());
        userRepo.save(userModel1);
        return new ResponseEntity<>(userModel1, HttpStatus.OK);
    }

    public ResponseEntity<?> loginAPI(UserloginDto userloginDto) {
        Optional<UserModel> optionalUserModel = userRepo.findByEmailAndPassword(userloginDto.getEmail(), userloginDto.getPassword());
        if (optionalUserModel.isPresent()) {
            UserloginDto userloginDto1 = new UserloginDto();
            userloginDto1.setStreamId(optionalUserModel.get().getStreamId());
            userloginDto1.setUserId(optionalUserModel.get().getUserId());
            return new ResponseEntity<>(userloginDto1, HttpStatus.OK);

        } else {
            return new ResponseEntity<>("LOGIN FAILED", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> gendertype(GenderModel genderModel) {
        GenderModel genderModel1 = new GenderModel();
        genderModel1.setGenderId(genderModel.getGenderId());
        genderModel1.setGenderType(genderModel.getGenderType());
        genderRepo.save(genderModel1);
        return new ResponseEntity<>(genderModel1, HttpStatus.OK);

    }

    public ResponseEntity<?> resetuserpassword(String email, String password) {
        Optional<UserModel> optionalUserModel = userRepo.findByEmail(email);
        if (optionalUserModel.isPresent()) {
            UserModel userModel = optionalUserModel.get();
            userModel.setPassword(password);
            userRepo.save(userModel);
            return new ResponseEntity<>(userModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<GenderModel>> getgenderlist() {
        List<GenderModel> genderModel = genderRepo.findAll();
        return new ResponseEntity<>(genderModel, HttpStatus.OK);
    }


    public ResponseEntity<?> updategender(Long genderId, String genderType) {
        Optional<GenderModel> optionalGenderModel = genderRepo.findById(genderId);
        if (optionalGenderModel.isPresent()) {
            GenderModel genderModel = optionalGenderModel.get();
            genderModel.setGenderType(genderType);
            genderRepo.save(genderModel);
            return new ResponseEntity<>("gender updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deletegender(long genderId) {
        Optional<GenderModel> optionalGenderModel = genderRepo.findById(genderId);
        if (optionalGenderModel.isPresent()) {
            GenderModel genderModel = optionalGenderModel.get();
            genderRepo.delete(genderModel);
            return new ResponseEntity<>("gender deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
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
        SpecificgoalModel specificgoalModel1 = new SpecificgoalModel();
        specificgoalModel1.setSpecificGoalId(specificgoalModel.getSpecificGoalId());
        specificgoalModel1.setSpecificGoal(specificgoalModel.getSpecificGoal());
        specificgoalRepo.save(specificgoalModel1);
        return new ResponseEntity<>(specificgoalModel1, HttpStatus.OK);
    }


    public ResponseEntity<List<SpecificgoalModel>> getSpecificgoal() {
        List<SpecificgoalModel> specificgoalModel = specificgoalRepo.findAll();
        return new ResponseEntity<>(specificgoalModel, HttpStatus.OK);
    }

    public ResponseEntity<?> updatespecificgoal(Long specificGoalId, String specificGoal) {
        Optional<SpecificgoalModel> optionalSpecificgoalModel = specificgoalRepo.findById(specificGoalId);
        if (optionalSpecificgoalModel.isPresent()) {
            SpecificgoalModel specificgoalModel = optionalSpecificgoalModel.get();
            specificgoalModel.setSpecificGoal(specificGoal);
            specificgoalRepo.save(specificgoalModel);
            return new ResponseEntity<>("specificgoal updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteSpecificGoal(long specificGoalId) {
        Optional<SpecificgoalModel> optionalSpecificgoalModel = specificgoalRepo.findById(specificGoalId);
        if (optionalSpecificgoalModel.isPresent()) {
            SpecificgoalModel specificgoalModel = optionalSpecificgoalModel.get();
            specificgoalRepo.delete(specificgoalModel);
            return new ResponseEntity<>("specificgoal deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

//    public ResponseEntity<?> getUsersByStreamId(Long streamId , Long tutorId) {
//        List<UserModel> users = userRepo.findByStreamIdAndTutorId(streamId,tutorId);
//        if (!users.isEmpty()) {
//            return new ResponseEntity<>(users, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>("No users found for stream ID: " + streamId, HttpStatus.NOT_FOUND);
//        }
//    }

    public ResponseEntity<?> getUsersByStreamId(Long streamId, Long tutorId) {
        if (streamId == null || tutorId == null) {
            return new ResponseEntity<>("Stream ID and Tutor ID must not be null", HttpStatus.BAD_REQUEST);
        }

        // Get bookings with this stream and tutor
        List<BookingModel> bookings = bookingRepo.findByStreamIdAndTutorId(streamId, tutorId);

        if (bookings == null || bookings.isEmpty()) {
            return new ResponseEntity<>("No bookings found for the given Stream ID and Tutor ID.", HttpStatus.NOT_FOUND);
        }

        // Collect valid users (non-null userId and found in DB)
        List<UserModel> userList = new ArrayList<>();
        for (BookingModel booking : bookings) {
            Long userId = booking.getUserId();
            if (userId != null) {
                Optional<UserModel> optionalUser = userRepo.findById(userId);
                optionalUser.ifPresent(userList::add);
            }

        }

        if (userList.isEmpty()) {
            return new ResponseEntity<>("No valid users found for the bookings.", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    public UserproDto getUserprofileById(Long userId) {
        // Fetch user from user_repo
        UserModel userModel = userRepo.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found with id: " + userId));

        UserproDto userproDto = new UserproDto();

        // Basic details
        userproDto.setUserId(userModel.getUserId());
        userproDto.setUsername(userModel.getUsername());
        userproDto.setEmail(userModel.getEmail());
        userproDto.setPassword(userModel.getPassword());
        userproDto.setLocation(userModel.getLocation());
        userproDto.setGender(userproDto.getGender());
        userproDto.setPhn_no(userModel.getPhn_no());

        // Subject
        if (userModel.getSubjectId() != null) {
            subjectRepo.findById(userModel.getSubjectId()).ifPresent(subject ->
                    userproDto.setSubjectName(subject.getSubjectName()));
        }

        // Stream
        if (userModel.getStreamId() != null) {
            streamRepo.findById(userModel.getStreamId()).ifPresent(stream ->
                    userproDto.setStreamName(stream.getStreamName()));
        }

        // Education Level
        if (userModel.getEducationLevelId() != null) {
            educationRepo.findById(userModel.getEducationLevelId()).ifPresent(edu ->
                    userproDto.setEducationLevel(edu.getEducationLevel()));
        }

        // Gender (if you have a genderId column in UserModel and genderRepo)
        // Optional: Uncomment if gender info is available

        if (userModel.getGenderId() != null) {
            genderRepo.findById(userModel.getGenderId()).ifPresent(g ->
                    userproDto.setGender(g.getGenderType()));
        }


        return userproDto;
    }

    public boolean updateUserProfile(Long userId, UserproDto dto) {
        Optional<UserModel> optional = userRepo.findById(userId);
        if (!optional.isPresent()) {
            return false;
        }

        UserModel user = optional.get();

        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPhn_no(dto.getPhn_no());
        user.setLocation(dto.getLocation());

//        user.setQualification(dto.getEducationLevel()); // Assuming educationLevel is used for qualification
//        user.setSubjectName(dto.getSubjectName());
//        user.setTeachingMode(dto.getTeachingMode());
        user.setStreamName(dto.getStreamName());

        userRepo.save(user);
        return true;
    }

}






