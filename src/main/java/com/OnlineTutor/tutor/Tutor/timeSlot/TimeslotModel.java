package com.OnlineTutor.tutor.Tutor.timeSlot;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalTime;
@CrossOrigin
@Entity
@Table(name = "timeslot_tb")
@Data
public class TimeslotModel {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "slotId")
     private Long slotId;

    @Column(name ="startTime" )
    private LocalTime startTime;

    @Column(name ="endTime" )
    private LocalTime endTime;

    @Column(name = "tutorId")
    private  Long tutorId;

    @Column(name = "DayId")
    private Long DayId;

    @Column(name = "teachingModeId")
    private Long teachingModeId;

    public Long getSlotId() {
        return slotId;
    }

    public void setSlotId(Long slotId) {
        this.slotId = slotId;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public Long getDayId() {
        return DayId;
    }

    public void setDayId(Long dayId) {
        DayId = dayId;
    }

    public Long getTeachingModeId() {
        return teachingModeId;
    }

    public void setTeachingModeId(Long teachingModeId) {
        this.teachingModeId = teachingModeId;
    }
}
