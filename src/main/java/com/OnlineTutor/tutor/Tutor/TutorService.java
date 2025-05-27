package com.OnlineTutor.tutor.Tutor;

import com.OnlineTutor.tutor.Admin.status.StatusRepo;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamRepo;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamsubDto;
import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectModel;
import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectRepo;
import com.OnlineTutor.tutor.Tutor.availablesession.AvailableModel;
import com.OnlineTutor.tutor.Tutor.availablesession.AvailableRepo;
import com.OnlineTutor.tutor.Tutor.dayNames.DayModel;
import com.OnlineTutor.tutor.Tutor.dayNames.DayRepo;
import com.OnlineTutor.tutor.Tutor.hourlyrate.HourlyrateDto;
import com.OnlineTutor.tutor.Tutor.hourlyrate.HourlyrateModel;
import com.OnlineTutor.tutor.Tutor.hourlyrate.HourlyrateRepo;
import com.OnlineTutor.tutor.Tutor.qualification.QualificationModel;
import com.OnlineTutor.tutor.Tutor.qualification.QualificationRepo;
import com.OnlineTutor.tutor.Tutor.teachingType.TeachingmodeModel;
import com.OnlineTutor.tutor.Tutor.teachingType.TeachingmodeRepo;
import com.OnlineTutor.tutor.Tutor.timeSlot.TimeslotDto;
import com.OnlineTutor.tutor.Tutor.timeSlot.TimeslotModel;
import com.OnlineTutor.tutor.Tutor.timeSlot.TimeslotRepo;
import com.OnlineTutor.tutor.Tutor.weekTypeName.WeekDto;
import com.OnlineTutor.tutor.Tutor.weekTypeName.WeekModel;
import com.OnlineTutor.tutor.Tutor.weekTypeName.WeekRepo;
import com.OnlineTutor.tutor.User.gender.GenderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TutorService {
    @Autowired
    private TutorRepo tutorRepo;

    @Autowired
    private HourlyrateRepo hourlyrateRepo;
    @Autowired
    private QualificationRepo qualificationRepo;

    @Autowired
    private TimeslotRepo timeslotRepo;
    @Autowired
    private WeekRepo weekRepo;
    @Autowired
    private DayRepo dayRepo;
    @Autowired
    private TeachingmodeRepo teachingmodeRepo;
    @Autowired
    private SubjectRepo subjectRepo;
    @Autowired
    private AvailableRepo availableRepo;
    @Autowired
    private StatusRepo statusRepo;
    @Autowired
    private GenderRepo genderRepo;
    @Autowired
    private StreamRepo streamRepo;


    public ResponseEntity<?> addtutor(TutorModel tutorModel, MultipartFile qualificationCertificate) throws IOException {
        TutorModel tutorModel1 = new TutorModel();
        tutorModel1.setTutor_id(tutorModel.getTutor_id());
        tutorModel1.setName(tutorModel.getName());
        tutorModel1.setEmail(tutorModel.getEmail());
        tutorModel1.setPassword(tutorModel.getPassword());
        tutorModel1.setPhn_no(tutorModel.getPhn_no());
        tutorModel1.setGenderId(tutorModel.getGenderId());
        tutorModel1.setLocation(tutorModel.getLocation());
        tutorModel1.setTeachingModeId(tutorModel.getTeachingModeId());
        tutorModel1.setQualificationId(tutorModel.getQualificationId());
        tutorModel1.setQualificationCertificate(qualificationCertificate.getBytes());
        tutorModel1.setSubjectId(tutorModel.getSubjectId());
        tutorModel1.setStreamId(tutorModel.getStreamId());
        tutorModel1.setRating(tutorModel.getRating());
        tutorModel1.setQualification(tutorModel.getQualification());
        tutorModel1.setExperience(tutorModel.getExperience());
        tutorModel1.setStreamName(tutorModel.getStreamName());
        tutorModel1.setSubjectName(tutorModel.getSubjectName());

        tutorRepo.save(tutorModel1);
        return new ResponseEntity<>(tutorModel1, HttpStatus.OK);

    }

    public ResponseEntity<?> logintutor(LoginDto loginDto) {
        Optional<TutorModel> optionalTutorModel = tutorRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if (optionalTutorModel.isPresent()) {
            loginDto.setTutor_id(optionalTutorModel.get().getTutor_id());
            return new ResponseEntity<>(loginDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("LOGIN FAILED", HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<?> updatetutors(String email, String password) {
        Optional<TutorModel> optionalTutorModel = tutorRepo.findByEmail(email);
        if (optionalTutorModel.isPresent()) {
            TutorModel tutorModel = optionalTutorModel.get();
            tutorModel.setEmail(email);
            tutorModel.setPassword(password);
            tutorRepo.save(tutorModel);
            return new ResponseEntity<>("tutor updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deletetutor(Long tutorId) {
        Optional<TutorModel> optionalTutorModel = tutorRepo.findById(tutorId);
        if (optionalTutorModel.isPresent()) {
            TutorModel tutorModel = optionalTutorModel.get();
            tutorRepo.delete(tutorModel);
            return new ResponseEntity<>("tutor deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<TutorModel>> gettutor() {
        List<TutorModel> tutorModel = tutorRepo.findAll();
        return new ResponseEntity<>(tutorModel, HttpStatus.OK);
    }

    public ResponseEntity<?> qualification(QualificationModel qualificationModel) {
        QualificationModel qualificationModel1 = new QualificationModel();
        qualificationModel1.setQual_id(qualificationModel.getQual_id());
        qualificationModel1.setQualification(qualificationModel.getQualification());
        qualificationRepo.save(qualificationModel1);
        return new ResponseEntity<>(qualificationModel1, HttpStatus.OK);
    }

    public ResponseEntity<List<QualificationModel>> getqualification() {
        List<QualificationModel> qualificationModel = qualificationRepo.findAll();
        return new ResponseEntity<>(qualificationModel, HttpStatus.OK);
    }

    public ResponseEntity<?> updatequalification(Long qualId, String qualification) {
        Optional<QualificationModel> optionalQualificationModel = qualificationRepo.findById(qualId);
        if (optionalQualificationModel.isPresent()) {
            QualificationModel qualificationModel = optionalQualificationModel.get();
            qualificationModel.setQualification(qualification);
            qualificationRepo.save(qualificationModel);
            return new ResponseEntity<>("qualification updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deletequal(long qualId) {
        Optional<QualificationModel> optionalQualificationModel = qualificationRepo.findById(qualId);
        if (optionalQualificationModel.isPresent()) {
            QualificationModel qualificationModel = optionalQualificationModel.get();
            qualificationRepo.delete(qualificationModel);
            return new ResponseEntity<>("qualification deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }


    public ResponseEntity<?> addteachingmode(TeachingmodeModel teachingmodeModel) {
        TeachingmodeModel teachingmodeModel1 = new TeachingmodeModel();
        teachingmodeModel1.setTeachingModeId(teachingmodeModel.getTeachingModeId());
        teachingmodeModel1.setTeachingMode(teachingmodeModel.getTeachingMode());
        teachingmodeRepo.save(teachingmodeModel1);
        return new ResponseEntity<>(teachingmodeModel1, HttpStatus.OK);

    }

    public ResponseEntity<List<TeachingmodeModel>> getteachinglist() {
        List<TeachingmodeModel> teachingmodeModel = teachingmodeRepo.findAll();
        return new ResponseEntity<>(teachingmodeModel, HttpStatus.OK);
    }

    public ResponseEntity<?> updateteaching(Long teachingModeId, String teachingMode) {
        Optional<TeachingmodeModel> optionalTeachingmodeModel = teachingmodeRepo.findById(teachingModeId);
        if (optionalTeachingmodeModel.isPresent()) {
            TeachingmodeModel teachingmodeModel = optionalTeachingmodeModel.get();
            teachingmodeModel.setTeachingMode(teachingMode);
            teachingmodeRepo.save(teachingmodeModel);
            return new ResponseEntity<>("teachingmode updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteteachingmode(long teachingModeId) {
        Optional<TeachingmodeModel> optionalTeachingmodeModel = teachingmodeRepo.findById(teachingModeId);
        if (optionalTeachingmodeModel.isPresent()) {
            TeachingmodeModel teachingmodeModel = optionalTeachingmodeModel.get();
            teachingmodeRepo.delete(teachingmodeModel);
            return new ResponseEntity<>("teachingmode deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> resetuserpassword(String email, String password) {
        Optional<TutorModel> optionalTutorModel = tutorRepo.findByEmail(email);
        if (optionalTutorModel.isPresent()) {
            TutorModel tutorModel = optionalTutorModel.get();
            tutorModel.setPassword(password);
            tutorRepo.save(tutorModel);
            return new ResponseEntity<>(tutorModel, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("user not found", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> week(WeekModel weekModel) {
        WeekModel weekModel1 = new WeekModel();
        weekModel1.setWeekId(weekModel.getWeekId());
        weekModel1.setWeek(weekModel.getWeek());
        weekRepo.save(weekModel1);
        return new ResponseEntity<>(weekModel1, HttpStatus.OK);

    }

    public ResponseEntity<List<WeekModel>> getweeklist() {
        List<WeekModel> weekModel = weekRepo.findAll();
        return new ResponseEntity<>(weekModel, HttpStatus.OK);
    }

    public ResponseEntity<?> updateweek(Long weekId, String week) {
        Optional<WeekModel> optionalWeekModel = weekRepo.findById(weekId);
        if (optionalWeekModel.isPresent()) {
            WeekModel weekModel = optionalWeekModel.get();
            weekModel.setWeek(week);
            weekRepo.save(weekModel);
            return new ResponseEntity<>("week updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteweek(Long weekId) {
        Optional<WeekModel> optionalWeekModel = weekRepo.findById(weekId);
        if (optionalWeekModel.isPresent()) {
            WeekModel weekModel = optionalWeekModel.get();
            weekRepo.delete(weekModel);
            return new ResponseEntity<>("week deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> addDays(DayModel dayModel) {
        DayModel dayModel1 = new DayModel();
        //dayModel1.setDayId(dayModel.getDayId());
        dayModel1.setDays(dayModel.getDays());
        dayModel1.setWeekId(dayModel.getWeekId());
        dayRepo.save(dayModel1);
        return new ResponseEntity<>(dayModel1, HttpStatus.OK);

    }

    public ResponseEntity<List<DayModel>> getdayslist() {
        List<DayModel> dayModel = dayRepo.findAll();
        return new ResponseEntity<>(dayModel, HttpStatus.OK);
    }

    public ResponseEntity<?> updatedays(Long dayId, String days, Long weekId) {
        Optional<DayModel> optionalDayModel = dayRepo.findById(dayId);
        if (optionalDayModel.isPresent()) {
            DayModel dayModel = optionalDayModel.get();
            dayModel.setDays(days);
            dayModel.setWeekId(weekId);
            dayRepo.save(dayModel);
            return new ResponseEntity<>("day updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleteday(long dayId) {
        Optional<DayModel> optionalDayModel = dayRepo.findById(dayId);
        if (optionalDayModel.isPresent()) {
            DayModel dayModel = optionalDayModel.get();
            dayRepo.delete(dayModel);
            return new ResponseEntity<>("day deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> addhourlyrate(HourlyrateModel hourlyrateModel) {
        HourlyrateModel hourlyrateModel1 = new HourlyrateModel();
//        hourlyrateModel1.setRate_id(hourlyrateModel.getRate_id());
        hourlyrateModel1.setRate(hourlyrateModel.getRate());
        hourlyrateModel1.setDayId(hourlyrateModel.getDayId());
        hourlyrateModel1.setTeachingModeId(hourlyrateModel.getTeachingModeId());
        hourlyrateModel1.setTutorId(hourlyrateModel.getTutorId());
        hourlyrateRepo.save(hourlyrateModel1);
        return new ResponseEntity<>(hourlyrateModel1, HttpStatus.OK);
    }

    public ResponseEntity<List<HourlyrateModel>> gethourlyrate() {
        List<HourlyrateModel> hourlyrateModel = hourlyrateRepo.findAll();
        return new ResponseEntity<>(hourlyrateModel, HttpStatus.OK);
    }

    public ResponseEntity<?> updatehourlyrate(Long rateId, double rate, Long dayId, Long teachingModeId, Long tutorId) {
        Optional<HourlyrateModel> optionalHourlyrateModel = hourlyrateRepo.findById(rateId);
        if (optionalHourlyrateModel.isPresent()) {
            HourlyrateModel hourlyrateModel = optionalHourlyrateModel.get();
            hourlyrateModel.setDayId(dayId);
            hourlyrateModel.setRate(rate);
            hourlyrateModel.setTeachingModeId(teachingModeId);
            hourlyrateModel.setTutorId(tutorId);
            hourlyrateRepo.save(hourlyrateModel);
            return new ResponseEntity<>("hourlyrate updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<?> deleterate(long rateId) {
        Optional<HourlyrateModel> optionalHourlyrateModel = hourlyrateRepo.findById(rateId);
        if (optionalHourlyrateModel.isPresent()) {
            HourlyrateModel hourlyrateModel = optionalHourlyrateModel.get();
            hourlyrateRepo.delete(hourlyrateModel);
            return new ResponseEntity<>("rate deleted", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("NOT FOUND", HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<List<WeekDto>> getDayFullDetails() {
        List<WeekDto> weekDtoList = new ArrayList<>();
        List<DayModel> dayModelList = dayRepo.findAll();
        if (!dayModelList.isEmpty()) {
            for (DayModel dayModel : dayModelList) {
                WeekDto weekDto = new WeekDto();
                weekDto.setDayId(dayModel.getDayId());
                weekDto.setDays(dayModel.getDays());
                weekDto.setWeekId(dayModel.getWeekId());
                Optional<WeekModel> optionalWeekModel = weekRepo.findById(dayModel.getWeekId());
                if (optionalWeekModel.isPresent()) {
                    WeekModel weekModel = optionalWeekModel.get();
                    weekDto.setWeekName(weekModel.getWeek());
                }
                weekDtoList.add(weekDto);
            }
            return new ResponseEntity<>(weekDtoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
    }

    //scheduling time
//    public ResponseEntity<?> schedule(TimeslotModel timeslotModel) {
//        TimeslotModel timeslotModel1 = new TimeslotModel();
//        timeslotModel1.setStartTime(timeslotModel.getStartTime());
//        timeslotModel1.setEndTime(timeslotModel.getEndTime());
//        timeslotModel1.setDayId(timeslotModel.getDayId());
//        timeslotModel1.setTeachingModeId(timeslotModel.getTeachingModeId());
//        timeslotModel1.setTutorId(timeslotModel.getTutorId());
//        timeslotRepo.save(timeslotModel1);
//        return new ResponseEntity<>(timeslotModel1, HttpStatus.OK);
//    }

//    public ResponseEntity<List<TimeslotDto>> getschedulelist() {
//        List<TimeslotDto> timeslotDtoList = new ArrayList<>();
//        List<TimeslotModel> timeslotModelList = timeslotRepo.findAll();
//
//        if (!timeslotModelList.isEmpty()) {
//            for (TimeslotModel timeslotModel : timeslotModelList) {
//                TimeslotDto timeslotDto = new TimeslotDto();
//
//                // Set basic fields from TimeslotModel
//                timeslotDto.setStartTime(timeslotModel.getStartTime());
//                timeslotDto.setEndTime(timeslotModel.getEndTime());
////                    timeslotDto.setSlotId(timeslotModel.getSlotId());
//                timeslotDto.setDayId(timeslotModel.getDayId());
//                timeslotDto.setTeachingModeId(timeslotModel.getTeachingModeId());
//                timeslotDto.setTutorId(timeslotModel.getTutorId());
//
//                // Fetch and set the corresponding DayModel
//                Optional<DayModel> optionalDayModel = dayRepo.findById(timeslotModel.getDayId());
//                optionalDayModel.ifPresent(dayModel -> timeslotDto.setDays(dayModel.getDays()));
//                ;// Set day information
//
//                // Fetch and set the corresponding TeachingmodeModel
//                Optional<TeachingmodeModel> optionalTeachingmodeModel = teachingmodeRepo.findById(timeslotModel.getTeachingModeId());
//                optionalTeachingmodeModel.ifPresent(teachingmodeModel -> timeslotDto.setTeachingModeName(teachingmodeModel.getTeachingMode()));  // Set teaching mode
//
//                // Fetch and set the corresponding TutorModel
//                Optional<TutorModel> optionalTutorModel = tutorRepo.findById(timeslotModel.getTutorId());
//                optionalTutorModel.ifPresent(tutorModel -> timeslotDto.setTutorName(tutorModel.getName()));  // Set tutor information
//
//                timeslotDtoList.add(timeslotDto);
//            }
//            return new ResponseEntity<>(timeslotDtoList, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
//    }
public ResponseEntity<List<TimeslotDto>> getschedulingtimelist() {
    List<TimeslotModel> timeslotModelList = timeslotRepo.findAll();
    if (timeslotModelList.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    List<TimeslotDto> timeslotDtoList = timeslotModelList.stream().map(timeslotModel -> {
        TimeslotDto dto = new TimeslotDto();

        dto.setStartTime(timeslotModel.getStartTime());
        dto.setEndTime(timeslotModel.getEndTime());
        dto.setDayId(timeslotModel.getDayId());
        dto.setTeachingModeId(timeslotModel.getTeachingModeId());
        dto.setTutorId(timeslotModel.getTutorId());

        // Set day name if exists
        dayRepo.findById(timeslotModel.getDayId())
                .ifPresent(dayModel -> dto.setDays(dayModel.getDays()));

        // Set teaching mode name if exists
        teachingmodeRepo.findById(timeslotModel.getTeachingModeId())
                .ifPresent(mode -> dto.setTeachingModeName(mode.getTeachingMode()));

        // Set tutor name if exists
        tutorRepo.findById(timeslotModel.getTutorId())
                .ifPresent(tutor -> dto.setTutorName(tutor.getName()));

        return dto;
    }).collect(Collectors.toList());

    return new ResponseEntity<>(timeslotDtoList, HttpStatus.OK);
}



    public ResponseEntity<List<HourlyrateDto>> gethourlyratetutorlist(Long tutorId) {
        List<HourlyrateModel> hourlyrateModels = hourlyrateRepo.findByTutorId(tutorId);
        if (hourlyrateModels == null || hourlyrateModels.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<HourlyrateDto> hourlyrateDtoList = new ArrayList<>();
        for (HourlyrateModel hourlyrateModel : hourlyrateModels) {
            HourlyrateDto hourlyrateDto = new HourlyrateDto();
            Optional<TutorModel> optionalTutorModel = tutorRepo.findById(hourlyrateModel.getTutorId());
            if (optionalTutorModel.isPresent()) {
                TutorModel tutorModel = optionalTutorModel.get();
                hourlyrateDto.setTutorId(tutorModel.getTutor_id());
                hourlyrateDto.setName(tutorModel.getName());
            }
            Optional<DayModel> optionalDayModel = dayRepo.findById(hourlyrateModel.getDayId());
            if (optionalDayModel.isPresent()) {
                DayModel dayModel = optionalDayModel.get();
                hourlyrateDto.setDayId(dayModel.getDayId());
                hourlyrateDto.setDays(dayModel.getDays());
            }
            hourlyrateDto.setRate(hourlyrateModel.getRate());
            Optional<TeachingmodeModel> optionalTeachingmodeModel = teachingmodeRepo.findById(hourlyrateModel.getTeachingModeId());
            if (optionalTeachingmodeModel.isPresent()) {
                TeachingmodeModel teachingmodeModel = optionalTeachingmodeModel.get();
                hourlyrateDto.setTeachingModeId(teachingmodeModel.getTeachingModeId());
                hourlyrateDto.setTeachingMode(teachingmodeModel.getTeachingMode());
            }
            hourlyrateDtoList.add(hourlyrateDto);
        }
        return new ResponseEntity<>(hourlyrateDtoList, HttpStatus.OK);
    }

    public List<TutorsearchDto> searchTutors(Long subjectId) {
        List<TutorsearchDto> tutorDtoList = new ArrayList<>();

        // Fetch the list of tutors by subjectId
        List<TutorModel> tutorModelList = tutorRepo.findBySubjectId(subjectId);

        // Fetch the subject to get its name
        SubjectModel subjectModel = subjectRepo.findById(subjectId)
                .orElse(null);

        if (!tutorModelList.isEmpty() && subjectModel != null) {
            for (TutorModel tutorModel : tutorModelList) {
                TutorsearchDto tutorsearchDto = new TutorsearchDto();

                // Set subject details
                tutorsearchDto.setSubjectId(subjectId);
                tutorsearchDto.setSubjectName(subjectModel.getSubjectName()); // Fetch the subject name from the SubjectModel

                // Set basic fields from Tutor entity
                tutorsearchDto.setTutor_id(tutorModel.getTutor_id());
                tutorsearchDto.setName(tutorModel.getName());
                tutorsearchDto.setEmail(tutorModel.getEmail());
                tutorsearchDto.setPhn_no(tutorModel.getPhn_no());
                tutorsearchDto.setPassword(tutorModel.getPassword());
                tutorsearchDto.setGenderId(tutorModel.getGenderId());
                tutorsearchDto.setQualificationId(tutorModel.getQualificationId());
//                tutorsearchDto.setDegree(tutorModel.getDegree());
                tutorsearchDto.setLocation(tutorModel.getLocation());
                tutorsearchDto.setQualificationCertificate(tutorModel.getQualificationCertificate());
                tutorsearchDto.setTeachingModeId(tutorModel.getTeachingModeId());
                tutorsearchDto.setStatusId(tutorModel.getStatusId());

                // Add to the list of Tutor DTOs
                tutorDtoList.add(tutorsearchDto);
            }
        } else {
            // If no tutors or subject found, handle accordingly
            TutorsearchDto noTutorDto = new TutorsearchDto();
            noTutorDto.setName("No tutor found for the subject ID: " + subjectId);
            tutorDtoList.add(noTutorDto);
        }

        return tutorDtoList;
    }

    public ResponseEntity<?> addavailability(AvailableModel availableModel) {
        AvailableModel availableModel1 = new AvailableModel();

        availableModel1.setMorningStartTime(availableModel.getMorningStartTime());
        availableModel1.setMorningEndTime(availableModel.getMorningEndTime());
        availableModel1.setEveningStartTime(availableModel.getEveningStartTime());
        availableModel1.setEveningEndTime(availableModel.getEveningEndTime());
        availableModel1.setRatePerHourWeekday(availableModel.getRatePerHourWeekday());
        availableModel1.setRatePerHourWeekend(availableModel.getRatePerHourWeekend());
        availableModel1.setWeekId(availableModel.getWeekId());
        availableModel1.setExtraHourRate(availableModel.getExtraHourRate());
        availableModel1.setSubjectId(availableModel.getSubjectId());
        availableModel1.setStreamId(availableModel.getStreamId());
        availableModel1.setTutorId(availableModel.getTutorId());
        availableModel1.setDayId(availableModel1.getDayId());

        availableRepo.save(availableModel1);

        //updating
        Optional<TutorModel> optionalTutor = tutorRepo.findById(availableModel.getTutorId());

        if (optionalTutor.isPresent()) {
            TutorModel tutor = optionalTutor.get();
            tutor.setStreamId(availableModel.getStreamId());
            tutor.setSubjectId(availableModel.getSubjectId());
            tutorRepo.save(tutor);  // updates existing tutor
        } else {
            return new ResponseEntity<>("Tutor not found", HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(availableModel1, HttpStatus.OK);
    }

public ProfileDto getTutorProfileById(Long tutorId) {
    // Fetch the tutor entity by tutorId from the database
    TutorModel tutorModel = tutorRepo.findById(tutorId)
            .orElseThrow(() -> new NoSuchElementException("Tutor not found with id: " + tutorId));

    ProfileDto profileDto = new ProfileDto();
    profileDto.setTutor_id(tutorModel.getTutor_id());
    profileDto.setName(tutorModel.getName());
    profileDto.setEmail(tutorModel.getEmail());
    profileDto.setPhn_no(tutorModel.getPhn_no());
    profileDto.setLocation(tutorModel.getLocation());
    profileDto.setQualificationCertificate(tutorModel.getQualificationCertificate());

    // Qualification
    Long qualificationId = tutorModel.getQualificationId();
    if (qualificationId != null) {
        qualificationRepo.findById(qualificationId).ifPresent(q ->
                profileDto.setQualification(q.getQualification())
        );
    }

    // Subject
    Long subjectId = tutorModel.getSubjectId();
    if (subjectId != null) {
        subjectRepo.findById(subjectId).ifPresent(subject ->
                profileDto.setSubject(subject.getSubjectName())
        );
    }

    // Teaching Mode
    Long teachingModeId = tutorModel.getTeachingModeId();
    if (teachingModeId != null) {
        teachingmodeRepo.findById(teachingModeId).ifPresent(mode ->
                profileDto.setTeachingMode(mode.getTeachingMode())
        );
    }

    // Status
    Long statusId = tutorModel.getStatusId();
    if (statusId != null) {
        statusRepo.findById(statusId).ifPresent(status ->
                profileDto.setStatus(status.getStatus())
        );
    }

    // Gender
    Long genderId = tutorModel.getGenderId();
    if (genderId != null) {
        genderRepo.findById(genderId).ifPresent(gender ->
                profileDto.setGender(gender.getGenderType())
        );
    }

    return profileDto;
}

//availability days
// READ ALL
public ResponseEntity<?> getAllAvailability() {
    List<AvailableModel> list = availableRepo.findAll();
    return new ResponseEntity<>(list, HttpStatus.OK);
}

    // READ ONE
    public ResponseEntity<?> getAvailabilityById(Long id) {
        Optional<AvailableModel> optional = availableRepo.findById(id);
        if (optional.isPresent()) {
            return new ResponseEntity<>(optional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Availability not found", HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE
    public ResponseEntity<?> updateAvailability(Long id, AvailableModel updatedModel) {
        Optional<AvailableModel> optional = availableRepo.findById(id);
        if (optional.isPresent()) {
            AvailableModel existing = optional.get();

            // Update the fields
            existing.setMorningStartTime(updatedModel.getMorningStartTime());
            existing.setMorningEndTime(updatedModel.getMorningEndTime());
            existing.setEveningStartTime(updatedModel.getEveningStartTime());
            existing.setEveningEndTime(updatedModel.getEveningEndTime());
            existing.setRatePerHourWeekday(updatedModel.getRatePerHourWeekday());
            existing.setRatePerHourWeekend(updatedModel.getRatePerHourWeekend());
            existing.setExtraHourRate(updatedModel.getExtraHourRate());
            existing.setStreamId(updatedModel.getStreamId());
            existing.setSubjectId(updatedModel.getSubjectId());
            existing.setTutorId(updatedModel.getTutorId());
            existing.setWeekId(updatedModel.getWeekId());
            existing.setDayId(updatedModel.getDayId());

            availableRepo.save(existing);
            return new ResponseEntity<>(existing, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Availability not found", HttpStatus.NOT_FOUND);
        }
    }

    // DELETE
    public ResponseEntity<?> deleteAvailability(Long id) {
        if (availableRepo.existsById(id)) {
            availableRepo.deleteById(id);
            return new ResponseEntity<>("Deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Availability not found", HttpStatus.NOT_FOUND);
        }
    }

//    public List<StreamsubDto> getStreamSubDetailsByTutor(Long tutorId) {
//        List<SubjectModel> subjectModels = subjectRepo.findByTutorId(tutorId);
//
//        List<StreamsubDto> streamsubDtoList = new ArrayList<>();
//        for (SubjectModel subjectModel : subjectModels) {
//            StreamsubDto dto = new StreamsubDto();
//            dto.setSubjectId(subjectModel.getSubjectId());
//            dto.setSubjectName(subjectModel.getSubjectName());
//            dto.setStreamId(subjectModel.getStreamId());
//
//            // Assuming subjectModel.getStream() gives access to the StreamModel
////            dto.setStreamName(subjectModel.getStream().getStreamName());
//
//            dto.setTutorId(tutorId);
//            streamsubDtoList.add(dto);
//        }
//        return streamsubDtoList;
//    }

    public ResponseEntity<List<StreamsubDto>> getStreamSubDetailsByTutor(Long tutorId) {
        List<TutorModel> tutorModelList = tutorRepo.findByTutorId(tutorId);

        List<StreamsubDto> streamsubDtoList = new ArrayList<>();
        for (TutorModel tutorModel : tutorModelList) {
            StreamsubDto dto = new StreamsubDto();
            dto.setSubjectId(tutorModel.getSubjectId());

            dto.setStreamId(tutorModel.getStreamId());
            dto.setTutorId(tutorId);

            SubjectModel subjectModel = subjectRepo.findById(tutorModel.getSubjectId()).orElse(null);
            if (subjectModel != null) {
                dto.setSubjectName(subjectModel.getSubjectName());
            } else {
                dto.setSubjectName("Unknown Subject");
            }
            // Optional: If you have streamName via relation
            // dto.setStreamName(subjectModel.getStream().getStreamName());

            streamsubDtoList.add(dto);
        }

        return ResponseEntity.ok(streamsubDtoList);
    }



    public ResponseEntity<?> getDetails(Long tutorId, Long dayId) {
        List<AvailableModel> availableModelList = availableRepo.findAllByTutorId(tutorId);
        if(!availableModelList.isEmpty()){
            return new ResponseEntity<>(availableModelList,HttpStatus.OK);
        }
        return new ResponseEntity<>("id not found",HttpStatus.NOT_FOUND);
    }
}






//
















