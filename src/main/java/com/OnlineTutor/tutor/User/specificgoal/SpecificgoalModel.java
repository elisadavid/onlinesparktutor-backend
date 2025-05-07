package com.OnlineTutor.tutor.User.specificgoal;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Entity
@Table(name = "specificGoal_tb")
@Data
public class SpecificgoalModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "specificGoalId")
    private Long specificGoalId;

    @Column(name = "specificGoal")
    private String specificGoal;

    public String getSpecificGoal() {
        return specificGoal;
    }

    public void setSpecificGoal(String specificGoal) {
        this.specificGoal = specificGoal;
    }

    public Long getSpecificGoalId() {
        return specificGoalId;
    }

    public void setSpecificGoalId(Long specificGoalId) {
        this.specificGoalId = specificGoalId;
    }
}
