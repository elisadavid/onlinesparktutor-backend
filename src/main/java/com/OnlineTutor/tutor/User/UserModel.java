package com.OnlineTutor.tutor.User;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.time.LocalTime;
@CrossOrigin
@Entity
@Table(name = "user_tb")
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "userId")
    private Long userId;

    @Column(name = "name")
    private String username;

    @Column(name = "email")
    private  String email;

    @Column(name = "password")
    private String password;

    @Column(name = "phn_no")
    private String phn_no;

    @Column(name = "gender")
    private String gender;

    @Column(name = "DOB")
    private String DOB;

    @Column(name = "course")
    private String course;

    @Column(name = "Subj_interest")
    private String Subj_interest;

    @Column(name = "pref_day")
    private String pref_day;

    @Column(name = "pref_time")
    private String pref_time;

    @Column(name = "location")
    private String location;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSubj_interest() {
        return Subj_interest;
    }

    public void setSubj_interest(String subj_interest) {
        Subj_interest = subj_interest;
    }

    public String getPref_day() {
        return pref_day;
    }

    public void setPref_day(String pref_day) {
        this.pref_day = pref_day;
    }

    public String getPref_time() {
        return pref_time;
    }

    public void setPref_time(String pref_time) {
        this.pref_time = pref_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
