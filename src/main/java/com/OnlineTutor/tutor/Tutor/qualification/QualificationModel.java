package com.OnlineTutor.tutor.Tutor.qualification;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Entity
@Table(name = "Qualification_tb")
@Data
public class QualificationModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "qual_id")
    private Long qual_id;

    @Column(name = "qualification")
    private String qualification;

    public Long getQual_id() {
        return qual_id;
    }

    public void setQual_id(Long qual_id) {
        this.qual_id = qual_id;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }
}
