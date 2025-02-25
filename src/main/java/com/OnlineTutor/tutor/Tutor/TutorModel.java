package com.OnlineTutor.tutor.Tutor;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tutor_tb")
@Data
public class TutorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "tutor_id")
    private  Long tutor_id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phn_no")
    private String phn_no;

    @Column(name = "genderId")
    private Long genderId;

    @Column(name = "qualificationId")
    private Long qualificationId;

    @Column(name = "degree")
    private String degree;//null

    @Column(name = "location")
    private String location;

    @Lob
    @Column(name = "qualification_verification")
    private byte[] qualification_verification;

    @Column(name = "teachingModeId")
    private Long teachingModeId;

    @Column(name = "statusId")
    private Long statusId;

    public TutorModel(){
        this.statusId=1L;
    }
    public Long getTutor_id() {
        return tutor_id;
    }

    public void setTutor_id(Long tutor_id) {
        this.tutor_id = tutor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhn_no() {
        return phn_no;
    }

    public void setPhn_no(String phn_no) {
        this.phn_no = phn_no;
    }

    public Long getGenderId() {
        return genderId;
    }

    public void setGenderId(Long genderId) {
        this.genderId = genderId;
    }

    public Long getQualificationId() {
        return qualificationId;
    }

    public void setQualificationId(Long qualificationId) {
        this.qualificationId = qualificationId;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public byte[] getQualification_verification() {
        return qualification_verification;
    }

    public void setQualification_verification(byte[] qualification_verification) {
        this.qualification_verification = qualification_verification;
    }

    public Long getTeachingModeId() {
        return teachingModeId;
    }

    public void setTeachingModeId(Long teachingModeId) {
        this.teachingModeId = teachingModeId;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
