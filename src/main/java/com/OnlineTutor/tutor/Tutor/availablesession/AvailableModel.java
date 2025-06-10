package com.OnlineTutor.tutor.Tutor.availablesession;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalTime;

@CrossOrigin
@Entity
@Table(name = "availableSession_tb")
@Data
public class AvailableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "sessionId")
    private Long sessionId;

    @Column(name = "morning_start_time")
    private LocalTime morningStartTime;

    @Column(name = "morning_end_time")
    private LocalTime morningEndTime;

    @Column(name = "evening_start_time")
    private LocalTime eveningStartTime;

    @Column(name = "evening_end_time")
    private LocalTime eveningEndTime;

    @Column(name = "ratePerHourWeekday")
    private Double ratePerHourWeekday;

    @Column (name = "ratePerHourWeekend")
    private Double ratePerHourWeekend;

    @Column(name = "extraHourRate")
    private Double extraHourRate;

    private Long weekId;
    private Long subjectId;
    private Long streamId;
    private Long tutorId;
    private Long dayId;
    private String experience;
    private String location;

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public Double getRatePerHourWeekday() {
        return ratePerHourWeekday;
    }

    public void setRatePerHourWeekday(Double ratePerHourWeekday) {
        this.ratePerHourWeekday = ratePerHourWeekday;
    }

    public Double getRatePerHourWeekend() {
        return ratePerHourWeekend;
    }

    public void setRatePerHourWeekend(Double ratePerHourWeekend) {
        this.ratePerHourWeekend = ratePerHourWeekend;
    }

    public Long getStreamId() {
        return streamId;
    }

    public void setStreamId(Long streamId) {
        this.streamId = streamId;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getStreamID() {
        return streamId;
    }

    public void setStreamID(Long streamID) {
        this.streamId = streamID;
    }

    public Long getSessionId() {
        return sessionId;
    }

    public void setSessionId(Long sessionId) {
        this.sessionId = sessionId;
    }

    public LocalTime getMorningStartTime() {
        return morningStartTime;
    }

    public void setMorningStartTime(LocalTime morningStartTime) {
        this.morningStartTime = morningStartTime;
    }

    public LocalTime getMorningEndTime() {
        return morningEndTime;
    }

    public void setMorningEndTime(LocalTime morningEndTime) {
        this.morningEndTime = morningEndTime;
    }

    public LocalTime getEveningStartTime() {
        return eveningStartTime;
    }

    public void setEveningStartTime(LocalTime eveningStartTime) {
        this.eveningStartTime = eveningStartTime;
    }

    public LocalTime getEveningEndTime() {
        return eveningEndTime;
    }

    public void setEveningEndTime(LocalTime eveningEndTime) {
        this.eveningEndTime = eveningEndTime;
    }



    public Double getExtraHourRate() {
        return extraHourRate;
    }

    public void setExtraHourRate(Double extraHourRate) {
        this.extraHourRate = extraHourRate;
    }

    public Long getWeekId() {
        return weekId;
    }

    public void setWeekId(Long weekId) {
        this.weekId = weekId;
    }
}

