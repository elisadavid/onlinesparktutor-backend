package com.OnlineTutor.tutor.Tutor.dayNames;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Day_tb")
@Data
public class DayModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dayId")
    private Long dayId;

    @Column(name = "days")
    private String days;

    @Column(name = "weekId")
    private Long weekId;



    public Long getDayId() {
        return dayId;
    }

    public void setDayId(Long dayId) {
        this.dayId = dayId;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public Long getWeekId() {
        return weekId;
    }

    public void setWeekId(Long weekId) {
        this.weekId = weekId;
    }
}
