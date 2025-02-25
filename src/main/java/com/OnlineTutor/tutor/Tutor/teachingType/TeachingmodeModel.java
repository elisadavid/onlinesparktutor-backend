package com.OnlineTutor.tutor.Tutor.teachingType;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "teachingmode_tb")
@Data
public class TeachingmodeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "teachingModeId")
    private Long teachingModeId;

    @Column(name = "teachingMode")
    private String teachingMode;

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
}
