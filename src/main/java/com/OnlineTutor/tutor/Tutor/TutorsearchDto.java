package com.OnlineTutor.tutor.Tutor;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;
import lombok.Data;


@Data
public class TutorsearchDto {

    private Long subjectId;
    private String subjectName;


    private  Long tutor_id;


    private String name;


    private String email;


    private String password;


    private String phn_no;


    private Long genderId;


    private Long qualificationId;



    private String location;


    private byte[] qualificationCertificate;


    private Long teachingModeId;


    private Long statusId;

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public byte[] getQualificationCertificate() {
        return qualificationCertificate;
    }

    public void setQualificationCertificate(byte[] qualificationCertificate) {
        this.qualificationCertificate = qualificationCertificate;
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
