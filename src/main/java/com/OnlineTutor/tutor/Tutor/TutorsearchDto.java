package com.OnlineTutor.tutor.Tutor;

import lombok.Data;

import java.time.LocalTime;
@Data
public class TutorsearchDto {

    private Long subjectId;
    private String subjectName;

    //tmesltmodel
    private LocalTime startTime;
    private LocalTime endTime;
    private Long DayId;
    private String days;
    private Long teachingModeId;
    private String teachingModeName;

    //hrlyremdl
    private double rate;
    private String location;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
