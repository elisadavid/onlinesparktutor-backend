package com.OnlineTutor.tutor.Tutor;

import com.OnlineTutor.tutor.Tutor.Education.EducationDto;
import com.OnlineTutor.tutor.Tutor.Education.stream.StreamModel;
import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectModel;
import com.OnlineTutor.tutor.Tutor.Education.subject.SubjectRepo;
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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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


    public ResponseEntity<?> adduser(TutorModel tutorModel) {
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
        tutorModel1.setDegree(tutorModel.getDegree());
        tutorModel1.setQualification_verification(tutorModel.getQualification_verification());
        tutorModel1.setStatusId(tutorModel.getStatusId());

        tutorRepo.save(tutorModel1);
        return new ResponseEntity<>(tutorModel1, HttpStatus.OK);

    }

    public ResponseEntity<?> logintutor(LoginDto loginDto) {
        Optional<TutorModel> optionalTutorModel = tutorRepo.findByEmailAndPassword(loginDto.getEmail(), loginDto.getPassword());
        if (optionalTutorModel.isPresent()) {
            return new ResponseEntity<>("LOGIN SUCCESSFULLY", HttpStatus.OK);
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
    public ResponseEntity<?> schedule(TimeslotModel timeslotModel) {
        TimeslotModel timeslotModel1 = new TimeslotModel();
        timeslotModel1.setStartTime(timeslotModel.getStartTime());
        timeslotModel1.setEndTime(timeslotModel.getEndTime());
        timeslotModel1.setDayId(timeslotModel.getDayId());
        timeslotModel1.setTeachingModeId(timeslotModel.getTeachingModeId());
        timeslotModel1.setTutorId(timeslotModel.getTutorId());
        timeslotRepo.save(timeslotModel1);
        return new ResponseEntity<>(timeslotModel1, HttpStatus.OK);
    }

    public ResponseEntity<List<TimeslotDto>> getschedulelist() {
        List<TimeslotDto> timeslotDtoList = new ArrayList<>();
        List<TimeslotModel> timeslotModelList = timeslotRepo.findAll();

        if (!timeslotModelList.isEmpty()) {
            for (TimeslotModel timeslotModel : timeslotModelList) {
                TimeslotDto timeslotDto = new TimeslotDto();

                // Set basic fields from TimeslotModel
                timeslotDto.setStartTime(timeslotModel.getStartTime());
                timeslotDto.setEndTime(timeslotModel.getEndTime());
//                    timeslotDto.setSlotId(timeslotModel.getSlotId());
                timeslotDto.setDayId(timeslotModel.getDayId());
                timeslotDto.setTeachingModeId(timeslotModel.getTeachingModeId());
                timeslotDto.setTutorId(timeslotModel.getTutorId());

                // Fetch and set the corresponding DayModel
                Optional<DayModel> optionalDayModel = dayRepo.findById(timeslotModel.getDayId());
                optionalDayModel.ifPresent(dayModel -> timeslotDto.setDays(dayModel.getDays()));
                ;// Set day information

                // Fetch and set the corresponding TeachingmodeModel
                Optional<TeachingmodeModel> optionalTeachingmodeModel = teachingmodeRepo.findById(timeslotModel.getTeachingModeId());
                optionalTeachingmodeModel.ifPresent(teachingmodeModel -> timeslotDto.setTeachingModeName(teachingmodeModel.getTeachingMode()));  // Set teaching mode

                // Fetch and set the corresponding TutorModel
                Optional<TutorModel> optionalTutorModel = tutorRepo.findById(timeslotModel.getTutorId());
                optionalTutorModel.ifPresent(tutorModel -> timeslotDto.setTutorName(tutorModel.getName()));  // Set tutor information

                timeslotDtoList.add(timeslotDto);
            }
            return new ResponseEntity<>(timeslotDtoList, HttpStatus.OK);
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
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

//    public List<TutorModel> searchTutors(TutorsearchDto tutorSearchDto) {
//
//    }

}
//        List<TutorModel> tutorModels = tutorRepo.findAll(); // Assuming we get all tutors and filter based on criteria
//        if (tutorModels == null || tutorModels.isEmpty()) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//
//        }
//
//        List<TutorsearchDto> tutorSearchDtoList = new ArrayList<>();
//
//        for (TutorModel tutorModel : tutorModels) {
//            TutorsearchDto tutorsearchDto = new TutorsearchDto();
//
//            // Filtering based on Subject
//            if (tutorsearchDto.getSubjectId() != null) {
//                Optional<SubjectModel> optionalSubjectModel = subjectRepo.findById(tutorsearchDto.getSubjectId());
//                if (optionalSubjectModel.isPresent()) {
//                    SubjectModel subjectModel = optionalSubjectModel.get();
//                    tutorSearchDto.setSubjectId(subjectModel.getSubjectId());
//                    tutorSearchDto.setSubjectName(subjectModel.getSubjectName());
//                }
//            }
//
//            // Filtering based on Time Slot (Start Time, End Time, and Day)
//            if (tutorSearchDto.getStartTime() != null && tutorSearchDto.getEndTime() != null && tutorSearchDto.getDayId() != null) {
//                Optional<TimeslotModel> optionalTimeSlotModel = timeslotRepo.findByTutorIdAndDayIdAndStartTimeAndEndTime(
//                        tutorModel.getTutor_id(), tutorSearchDto.getDayId(), tutorsearchDto.getStartTime(), tutorsearchDto.getEndTime());
//
//                if (optionalTimeSlotModel.isPresent()) {
//                    TimeslotModel timeSlotModel = optionalTimeSlotModel.get();
//                    tutorSearchDto.setStartTime(timeSlotModel.getStartTime());
//                    tutorSearchDto.setEndTime(timeSlotModel.getEndTime());
//                    tutorSearchDto.setDayId(timeSlotModel.getDayId());
//
//                    Optional<DayModel> optionalDayModel = dayRepo.findById(timeSlotModel.getDayId());
//                    if (optionalDayModel.isPresent()) {
//                        DayModel dayModel = optionalDayModel.get();
//                        tutorSearchDto.setDays(dayModel.getDays());
//                    }
//                }
//            }
//
//            // Filtering based on Hourly Rate
//            if (tutorSearchDto.getRate() > 0) {
//                Optional<HourlyrateModel> optionalHourlyRateModel = hourlyrateRepo.findByTutorIdAndRate(
//                        tutorModel.getTutor_id(), tutorsearchDto.getRate());
//                if (optionalHourlyRateModel.isPresent()) {
//                    HourlyrateModel hourlyRateModel = optionalHourlyRateModel.get();
//                    tutorSearchDto.setRate(hourlyRateModel.getRate());
//                }
//            }
//
//            // Filtering based on Location
//            if (tutorSearchDto.getLocation() != null && !tutorSearchDto.getLocation().isEmpty()) {
//                if (tutorModel.getLocation().equalsIgnoreCase(tutorSearchDto.getLocation())) {
//                    tutorSearchDto.setLocation(tutorModel.getLocation());
//                }
//            }
//
//            // Filtering based on Teaching Mode
//            if (tutorSearchDto.getTeachingModeId() != null) {
//                Optional<TeachingmodeModel> optionalTeachingModeModel = teachingmodeRepo.findById(tutorSearchDto.getTeachingModeId());
//                if (optionalTeachingModeModel.isPresent()) {
//                    TeachingmodeModel teachingModeModel = optionalTeachingModeModel.get();
//                    tutorSearchDto.setTeachingModeId(teachingModeModel.getTeachingModeId());
//                    tutorSearchDto.setTeachingModeName(teachingModeModel.getTeachingMode());
//                }
//            }
//
//            // Add tutor details to the DTO list if it matches all the given search criteria
//            tutorSearchDtoList.add(tutorSearchDto);
//        }
//
//        if (tutorSearchDtoList == null || tutorSearchDtoList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//        return new ResponseEntity<>(tutorSearchDtoList, HttpStatus.OK);
//
//    }
















