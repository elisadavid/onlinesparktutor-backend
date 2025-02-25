package com.OnlineTutor.tutor.Tutor.hourlyrate;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class HourlyrateDto {

//    private Long rate_id;


    private double rate;
    private Long DayId;
    private String days;
    private Long teachingModeId;
    private String teachingMode;
    private  Long tutorId;
    private String name;

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
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

    public String getTeachingMode() {
        return teachingMode;
    }

    public void setTeachingMode(String teachingMode) {
        this.teachingMode = teachingMode;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
