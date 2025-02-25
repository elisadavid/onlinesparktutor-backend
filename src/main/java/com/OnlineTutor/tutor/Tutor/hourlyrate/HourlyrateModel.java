package com.OnlineTutor.tutor.Tutor.hourlyrate;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "hourlyRate_tb")
@Data
public class HourlyrateModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "rate_id")
    private Long rate_id;

    @Column(name = "rate") //regular rate
    private double rate;

    @Column(name = "DayId")
    private Long DayId;

    @Column(name = "teachingModeId")
    private Long teachingModeId;

    @Column(name = "tutorId")
    private  Long tutorId;

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public Long getRate_id() {
        return rate_id;
    }

    public void setRate_id(Long rate_id) {
        this.rate_id = rate_id;
    }

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

    public Long getTeachingModeId() {
        return teachingModeId;
    }

    public void setTeachingModeId(Long teachingModeId) {
        this.teachingModeId = teachingModeId;
    }
}