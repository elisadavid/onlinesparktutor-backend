package com.OnlineTutor.tutor.Tutor.weekTypeName;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "weektype_tb")
@Data
public class WeekModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "weekId")
    private Long weekId;

    @Column(name = "week")
    private String week;

    public Long getWeekId() {
        return weekId;
    }

    public void setWeekId(Long weekId) {
        this.weekId = weekId;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
