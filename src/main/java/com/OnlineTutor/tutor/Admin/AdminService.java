package com.OnlineTutor.tutor.Admin;

import com.OnlineTutor.tutor.Tutor.Education.EducationDto;
import com.OnlineTutor.tutor.Tutor.Education.EducationModel;
import com.OnlineTutor.tutor.Tutor.Education.EducationRepo;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamDto;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamModel;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamRepo;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamsubDto;
import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectDto;
import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectModel;
import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectRepo;
import com.OnlineTutor.tutor.Admin.status.StatusModel;
import com.OnlineTutor.tutor.Admin.status.StatusRepo;
import com.OnlineTutor.tutor.Tutor.TutorModel;
import com.OnlineTutor.tutor.Tutor.TutorRepo;
import com.OnlineTutor.tutor.User.BookingSession.BookingModel;
import com.OnlineTutor.tutor.User.BookingSession.BookingRepo;
import com.OnlineTutor.tutor.User.UserModel;
import com.OnlineTutor.tutor.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AdminService {
    @Autowired
    private AdminRepo adminRepo;
    @Autowired
    private EducationRepo educationRepo;
    @Autowired
    private StreamRepo streamRepo;
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private StatusRepo statusRepo;
    @Autowired
    private TutorRepo tutorRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private BookingRepo bookingRepo;


    public ResponseEntity<?> register(AdminModel adminModel) {
        AdminModel adminModel1 = new AdminModel();
        adminModel1.setAdminId(adminModel.getAdminId());
        adminModel1.setAdminName(adminModel.getAdminName());
        adminModel1.setEmail(adminModel.getEmail());
        adminModel1.setPassword(adminModel.getPassword());
        adminRepo.save(adminModel1);
        return new ResponseEntity<>(adminModel1, HttpStatus.OK);

    }

    public ResponseEntity<?> loginAPI(AdminloginDto adminloginDto) {
        Optional<AdminModel> optionalAdminModel = adminRepo.findByEmailAndPassword(adminloginDto.getEmail(), adminloginDto.getPassword());
        if (optionalAdminModel.isPresent()) {
            return new ResponseEntity<>("LOGIN SUCCESSFULLY", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("LOGIN FAILED", HttpStatus.BAD_REQUEST);
        }
    }


    public ResponseEntity<?> addeducationlevel(EducationModel educationModel) {
        EducationModel educationModel1 = new EducationModel();
        educationModel1.setEducationLevelId(educationModel.getEducationLevelId());
        educationModel1.setEducationLevel(educationModel.getEducationLevel());
        educationRepo.save(educationModel1);
        return new ResponseEntity<>(educationModel1, HttpStatus.OK);

    }

    public ResponseEntity<?> addstream(StreamModel streamModel) {
        StreamModel streamModel1 = new StreamModel();
        streamModel1.setStreamId(streamModel.getStreamId());
        streamModel1.setStreamName(streamModel.getStreamName());
        streamModel1.setEducationLevelId(streamModel.getEducationLevelId());
        streamRepo.save(streamModel1);
        return new ResponseEntity<>(streamModel1, HttpStatus.OK);

    }


    public ResponseEntity<?> resetuserpassword(String email, String password) {
        Optional<AdminModel> optionalAdminModel = adminRepo.findByEmail(email);
        if (optionalAdminModel.isPresent()) {
            AdminModel adminModel = optionalAdminModel.get();
            adminModel.setPassword(password);
            adminRepo.save(adminModel);
            return new ResponseEntity<>(adminModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> addsubject(SubjectModel subjectModel) {
        SubjectModel subjectModel1 = new SubjectModel();
        subjectModel1.setSubjectName(subjectModel.getSubjectName());
        subjectModel1.setStreamId(subjectModel.getStreamId());
        subjectRepo.save(subjectModel1);
        return new ResponseEntity<>(subjectModel1, HttpStatus.OK);

    }

    public ResponseEntity<List<SubjectModel>> getsubject() {
        List<SubjectModel> subjectModel = subjectRepo.findAll();
        return new ResponseEntity<>(subjectModel, HttpStatus.OK);
    }

    public ResponseEntity<?> updatesubject(Long subjectId, String subjectName, Long streamId) {
        Optional<SubjectModel> optionalSubjectModel = subjectRepo.findById(subjectId);
        if (optionalSubjectModel.isPresent()) {
            SubjectModel subjectModel = optionalSubjectModel.get();
            subjectModel.setSubjectName(subjectName);
            subjectModel.setStreamId(streamId);
            subjectRepo.save(subjectModel);
            return new ResponseEntity<>("subjct updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }

    }

    public ResponseEntity<?> deleteSub(long subjectId) {
        Optional<SubjectModel> optionalSubjectModel = subjectRepo.findById(subjectId);
        if (optionalSubjectModel.isPresent()) {
            SubjectModel subjectModel = optionalSubjectModel.get();
            subjectRepo.delete(subjectModel);
            return new ResponseEntity<>("sub deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<StreamModel>> getstream() {
        List<StreamModel> streamModel = streamRepo.findAll();
        return new ResponseEntity<>(streamModel, HttpStatus.OK);
    }

    public ResponseEntity<?> updatestream(Long educationlevelId, String streamName, Long streamId) {
        Optional<StreamModel> optionalStreamModel = streamRepo.findById(streamId);
        if (optionalStreamModel.isPresent()) {
            StreamModel streamModel = optionalStreamModel.get();
            streamModel.setStreamName(streamName);
            streamModel.setEducationLevelId(educationlevelId);
            streamRepo.save(streamModel);
            return new ResponseEntity<>("stream updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deletestream(long streamId) {
        Optional<StreamModel> optionalStreamModel = streamRepo.findById(streamId);
        if (optionalStreamModel.isPresent()) {
            StreamModel streamModel = optionalStreamModel.get();
            streamRepo.delete(streamModel);
            return new ResponseEntity<>("stream deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<EducationModel>> getEducation() {
        List<EducationModel> educationModel = educationRepo.findAll();
        return new ResponseEntity<>(educationModel, HttpStatus.OK);
    }

    public ResponseEntity<?> updateEducationlevel(Long educationlevelId, String educationLevel) {
        Optional<EducationModel> optionalEducationModel = educationRepo.findById(educationlevelId);
        if (optionalEducationModel.isPresent()) {
            EducationModel educationModel = optionalEducationModel.get();
            educationModel.setEducationLevel(educationLevel);
            educationRepo.save(educationModel);
            return new ResponseEntity<>("Education updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteEducationLevel(long educationlevelId) {
        Optional<EducationModel> optionalEducationModel = educationRepo.findById(educationlevelId);
        if (optionalEducationModel.isPresent()) {
            EducationModel educationModel = optionalEducationModel.get();
            educationRepo.delete(educationModel);
            return new ResponseEntity<>("education deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

//    public ResponseEntity<List<StreamDto>> getStreamFullDetails() {
//        List<StreamDto> streamDtoList = new ArrayList<>();
//        List<StreamModel> streamModelList = streamRepo.findAll();
//        if (!streamModelList.isEmpty()) {
//            for (StreamModel streamModel : streamModelList) {
//                StreamDto streamDto = new StreamDto();
//                streamDto.setStreamId(streamModel.getStreamId());
//                streamDto.setStreamName(streamModel.getStreamName());
//                streamDto.setEducationLevelId(streamModel.getEducationLevelId());
//                streamDto.setSubjectName(streamModel.getSubjectName());
//                Optional<EducationModel> optionalEducationModel = educationRepo.findById(streamModel.getEducationLevelId());
//                if (optionalEducationModel.isPresent()) {
//                    EducationModel educationModel = optionalEducationModel.get();
//                    streamDto.setEducationLevel(educationModel.getEducationLevel());
//                }
//
//                Optional<SubjectModel> optionalSubjectModel = subjectRepo.findById(streamModel.getSubjectId());
//                if (optionalSubjectModel.isPresent()) {
//                    SubjectModel subjectModel = optionalSubjectModel.get();
//                    streamDto.setSubjectName(subjectModel.getSubjectName());
//                }
//                streamDtoList.add(streamDto);
//            }
//            return new ResponseEntity<>(streamDtoList, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
//    }

//    public ResponseEntity<List<StreamDto>> getStreamFullDetails() {
//        List<StreamDto> streamDtoList = new ArrayList<>();
//        List<StreamModel> streamModelList = streamRepo.findAll();
//
//        for (StreamModel streamModel : streamModelList) {
//            StreamDto streamDto = new StreamDto();
//            streamDto.setStreamId(streamModel.getStreamId());
//            streamDto.setStreamName(streamModel.getStreamName());
//            streamDto.setEducationLevelId(streamModel.getEducationLevelId());
//
//            // Set education level name
//            educationRepo.findById(streamModel.getEducationLevelId())
//                    .ifPresent(edu -> streamDto.setEducationLevel(edu.getEducationLevel()));
//
//            List<String> subjectName = new ArrayList<>();
//            List<String> name = new ArrayList<>();
//
//            // Get subjects for this stream
//            List<SubjectModel> subjectList = subjectRepo.findByStreamId(streamModel.getStreamId());
//            for (SubjectModel subject : subjectList) {
//                subjectName.add(subject.getSubjectName());
//
//                // Get tutors for this subject
//                List<TutorModel> tutorList = tutorRepo.findBySubjectId(subject.getSubjectId());
//                for (TutorModel tutor : tutorList) {
//                    if (!name.contains(tutor.getName())) {
//                        name.add(tutor.getName());
//                    }
//                }
//            }
//
//            streamDto.setsubjectName(subjectName);
//            streamDto.setname(name);
//
//            streamDtoList.add(streamDto);
//        }
//
//        return new ResponseEntity<>(streamDtoList, HttpStatus.OK);
//    }



    public ResponseEntity<List<SubjectDto>> getsubjectdetails() {
        List<SubjectDto> subjectDtoList = new ArrayList<>();
        List<SubjectModel> subjectModelList = subjectRepo.findAll();
        if (!subjectModelList.isEmpty()) {
            for (SubjectModel subjectModel : subjectModelList) {
                SubjectDto subjectDto = new SubjectDto();
                subjectDto.setSubjectId(subjectModel.getSubjectId());
                subjectDto.setSubjectName(subjectModel.getSubjectName());
                subjectDto.setStreamId(subjectModel.getStreamId());
                Optional<StreamModel> optionalStreamModel = streamRepo.findById(subjectModel.getStreamId());
                if (optionalStreamModel.isPresent()) {
                    StreamModel streamModel = optionalStreamModel.get();
                    subjectDto.setStreamName(streamModel.getStreamName());
                }
                subjectDtoList.add(subjectDto);
            }
            return new ResponseEntity<>(subjectDtoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }


    public ResponseEntity<List<StreamsubDto>> getstreamsubdetails(Long streamId) {
        // Fetch subjects where stream_id matches and is not null
        List<SubjectModel> subjectModels = subjectRepo.findByStreamId(streamId);

        if (subjectModels == null || subjectModels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        List<StreamsubDto> streamsubDtoList = subjectModels.stream()
                .filter(subject -> subject.getStreamId() != null && subject.getStreamId().equals(streamId)) // extra safety
                .map(subject -> {
                    StreamsubDto dto = new StreamsubDto();
                    dto.setSubjectId(subject.getSubjectId());
                    dto.setSubjectName(subject.getSubjectName());
                    return dto;
                })
                .collect(Collectors.toList());

        return new ResponseEntity<>(streamsubDtoList, HttpStatus.OK);
    }


    public ResponseEntity<List<EducationDto>> geteducationalstream(Long educationlevelId) {
        List<StreamModel> streamModels = streamRepo.findByEducationLevelId(educationlevelId);
        if (streamModels == null || streamModels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<EducationDto> educationDtoList = new ArrayList<>();
        for (StreamModel streamModel : streamModels) {
            EducationDto educationDto = new EducationDto();
            educationDto.setEducationLevelId(streamModel.getEducationLevelId());
            educationDto.setStreamId(streamModel.getStreamId());
            educationDto.setStreamName(streamModel.getStreamName());
            educationDtoList.add(educationDto);
        }
        return new ResponseEntity<>(educationDtoList, HttpStatus.OK);
    }


    public ResponseEntity<?> updateadmin(String email, String password) {
        Optional<AdminModel> optionalAdminModel = adminRepo.findByEmail(email);
        if (optionalAdminModel.isPresent()) {
            AdminModel adminModel = optionalAdminModel.get();
            adminModel.setEmail(email);
            adminModel.setPassword(password);
            adminRepo.save(adminModel);
            return new ResponseEntity<>("admin updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteadmin(Long adminId) {
        Optional<AdminModel> optionalAdminModel = adminRepo.findById(adminId);
        if (optionalAdminModel.isPresent()) {
            AdminModel adminModel = optionalAdminModel.get();
            adminRepo.delete(adminModel);
            return new ResponseEntity<>("admin deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<AdminModel>> getadmin() {
        List<AdminModel> adminModel = adminRepo.findAll();
        return new ResponseEntity<>(adminModel, HttpStatus.OK);

    }

    public ResponseEntity<List<StatusModel>> getStatus() {
        List<StatusModel> statusModel = statusRepo.findAll();
        return new ResponseEntity<>(statusModel, HttpStatus.OK);
    }

    public ResponseEntity<?> addstatus(StatusModel statusModel) {
        StatusModel statusModel1 = new StatusModel();
        statusModel1.setStatusId(statusModel.getStatusId());
        statusModel1.setStatus(statusModel.getStatus());
        statusRepo.save(statusModel1);
        return new ResponseEntity<>(statusModel1, HttpStatus.OK);
    }

    public ResponseEntity<?> updateStatus(Long statusId, String status) {
        Optional<StatusModel> optionalStatusModel = statusRepo.findById(statusId);
        if (optionalStatusModel.isPresent()) {
            StatusModel statusModel = optionalStatusModel.get();
            statusModel.setStatus(status);
            statusRepo.save(statusModel);
            return new ResponseEntity<>("Status updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteStatus(Long statusId) {
        Optional<StatusModel> optionalStatusModel = statusRepo.findById(statusId);
        if (optionalStatusModel.isPresent()) {
            StatusModel statusModel = optionalStatusModel.get();
            statusRepo.delete(statusModel);
            return new ResponseEntity<>("status deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }

    }

//    public ResponseEntity<?> updatetutorStatus(Long tutorId, Long statusId, Long userId) {
//        Optional<UserModel> optionalUserModel = userRepo.findById(userId);
//        if (optionalUserModel.isPresent()) {
//            Optional<StatusModel> optionalStatusModel = statusRepo.findById(statusId);
//            if (optionalStatusModel.isPresent()) {
//                UserModel userModel = optionalUserModel.get();
//                StatusModel statusModel = optionalStatusModel.get();
//                tutorModel.setStatusId(statusId);
//                tutorRepo.save(tutorModel);
//                return new ResponseEntity<>(tutorModel,HttpStatus.OK);
//            }
//            else
//                return new ResponseEntity<>("status id is not presented",HttpStatus.NOT_FOUND);
//
//        }
//        return new ResponseEntity<>("tutorid is not presented",HttpStatus.NOT_FOUND);
//    }

    public ResponseEntity<?> updatetutorStatus(Long bookingId, Long statusId) {
        Optional<BookingModel> optionalBooking = bookingRepo.findById(bookingId);
        if (optionalBooking.isEmpty()) {
            return new ResponseEntity<>("Booking ID not found", HttpStatus.NOT_FOUND);
        }

        Optional<StatusModel> optionalStatus = statusRepo.findById(statusId);
        if (optionalStatus.isEmpty()) {
            return new ResponseEntity<>("Status ID not found", HttpStatus.NOT_FOUND);
        }

        BookingModel booking = optionalBooking.get();
        booking.setStatusId(statusId);  // or booking.setStatus(optionalStatus.get());
        bookingRepo.save(booking);

        // If status is Approved (let's say statusId = 2), update tutorId in UserModel
        if (statusId == 3) { // assuming 2 is Approved
            Long userId = booking.getUserId();
            Long tutorId = booking.getTutorId();

            Optional<UserModel> optionalUser = userRepo.findById(userId);
            if (optionalUser.isPresent()) {
                UserModel user = optionalUser.get();
                user.setTutorId(tutorId);
                userRepo.save(user);
            }
        }

        return new ResponseEntity<>("Booking status updated successfully", HttpStatus.OK);
    }


    public ResponseEntity<List<TutorModel>> gettutorlist() {
        List<TutorModel> tutorModel = tutorRepo.findAll();
        return new ResponseEntity<>(tutorModel, HttpStatus.OK);

    }

    public ResponseEntity<StreamDto> getStreamDetailsById(Long streamId) {
        Optional<StreamModel> streamOpt = streamRepo.findById(streamId);
        if (streamOpt.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        StreamModel streamModel = streamOpt.get();
        StreamDto streamDto = new StreamDto();

        streamDto.setStreamId(streamModel.getStreamId());
        streamDto.setStreamName(streamModel.getStreamName());
        streamDto.setEducationLevelId(streamModel.getEducationLevelId());

        // Get education level name
        educationRepo.findById(streamModel.getEducationLevelId())
                .ifPresent(edu -> streamDto.setEducationLevel(edu.getEducationLevel()));

        List<String> subjectNames = new ArrayList<>();
        List<String> tutorDisplayNames = new ArrayList<>();

        // Get all subjects for the stream
        List<SubjectModel> subjectList = subjectRepo.findByStreamId(streamId);
        for (SubjectModel subject : subjectList) {
            subjectNames.add(subject.getSubjectName());

            List<TutorModel> tutors = tutorRepo.findBySubjectId(subject.getSubjectId());
            for (TutorModel tutor : tutors) {
                Integer studentCount = userRepo.countStudentsByTutorId(tutor.getTutor_id());
                if (studentCount == null) studentCount = 0;

                String displayName = tutor.getName() + " (" + studentCount + " students)";

                if (!tutorDisplayNames.contains(displayName)) {
                    tutorDisplayNames.add(displayName);
                }
            }
        }



        streamDto.setSubjectName(subjectNames);
        streamDto.setName(tutorDisplayNames); // This contains tutor name + student count

        return new ResponseEntity<>(streamDto, HttpStatus.OK);
    }

}










//        List<StreamDto> streamDtoList = new ArrayList<>();
//        List<StreamModel>streamModelList = streamRepo.findAll();
//        if (!streamModelList.isEmpty()){
//            for (StreamModel streamModel : streamModelList){
//
//                StreamDto streamDto = new StreamDto();
//                streamDto.setStreamId(streamModel.getStreamId());
//                streamDto.setStreamName(streamModel.getStreamName());
//                streamDto.setEducationLevelId(streamModel.getEducationLevelId());
//                Optional<EducationModel>optionalEducationModel=streamRepo.findById(educationRepo.getEducationLevelId());
//                if (optionalEducationModel.isPresent()){
//                    StreamModel streamModel1=optionalstreammodel.get();
//                    streamDto.setEducationLevel(streamModel.g());
//                }
//                streamDtoList.add(streamDto);
//            }
//            return /new ResponseEntity<>(streamDtoList,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
//    }


