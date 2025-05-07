package com.OnlineTutor.tutor.Tutor;

import lombok.Data;

@Data
public class ProfileDto {

    private Long tutor_id;
    private String name;
    private String email;
    private String Phn_no;
    private String qualification;
    private String subject;
    private String teachingMode;
    private String status;
    private String gender;
    private String location;
    private byte[] qualificationCertificate;
    private String stream;
    private String educationLevel;

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

    public String getPhn_no() {
        return Phn_no;
    }

    public void setPhn_no(String phn_no) {
        Phn_no = phn_no;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTeachingMode() {
        return teachingMode;
    }

    public void setTeachingMode(String teachingMode) {
        this.teachingMode = teachingMode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        this.stream = stream;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }
}

