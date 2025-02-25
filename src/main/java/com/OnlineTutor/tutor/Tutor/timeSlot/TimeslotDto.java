package com.OnlineTutor.tutor.Tutor.timeSlot;

import lombok.Data;

import java.time.LocalTime;
@Data
public class TimeslotDto {
    private Long slotId;
    private LocalTime startTime;
    private LocalTime endTime;
    private  Long tutorId;
    private String tutorName;
    private Long DayId;
    private String days;
    private Long teachingModeId;
    private String teachingModeName;

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

    public String getTutorName() {
        return tutorName;
    }

    public void setTutorName(String tutorName) {
        this.tutorName = tutorName;
    }

    public Long getDayId() {
        return DayId;
    }

    public void setDayId(Long dayId) {
        DayId = dayId;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }


    public Long getTeachingModeId() {
        return teachingModeId;
    }

    public void setTeachingModeId(Long teachingModeId) {
        this.teachingModeId = teachingModeId;
    }

    public String getTeachingModeName() {
        return teachingModeName;
    }

    public void setTeachingModeName(String teachingModeName) {
        this.teachingModeName = teachingModeName;
    }
}
