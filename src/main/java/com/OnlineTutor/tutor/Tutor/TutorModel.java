package com.OnlineTutor.tutor.Tutor;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
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

    @Column (name = "genderType")
    private String genderType;

    @Column(name = "qualificationId")
    private Long qualificationId;

    @Column(name = "qualification")
    private String qualification;

    @Column(name = "Experience")
    private Long Experience;




//    @Column(name = "degree")
//    private String degree;//null

    @Column(name = "location")
    private String location;

    @Lob
    @Column(name = "qualificationCertificate")
    private byte[] qualificationCertificate;

    @Column(name = "teachingModeId")
    private Long teachingModeId;

    @Column(name = "statusId")
    private Long statusId;

    private Long subjectId;
    @Column(name = "subjectName")
    private String subjectName;
//
    private Long streamId;

    @Column(name = "streamName")
    private String streamName;

    @Column(name = "Rating")
    private Long Rating;

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public Long getExperience() {
        return Experience;
    }

    public void setExperience(Long experience) {
        Experience = experience;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public Long getRating() {
        return Rating;
    }

    public void setRating(Long rating) {
        Rating = rating;
    }

    public Long getStreamId() {
        return streamId;
    }

    public void setStreamId(Long streamId) {
        this.streamId = streamId;
    }


    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
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

    public TutorModel(){
        this.statusId=1L;
    }


}

