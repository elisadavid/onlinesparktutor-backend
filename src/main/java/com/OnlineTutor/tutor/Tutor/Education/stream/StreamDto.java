package com.OnlineTutor.tutor.Tutor.Education.stream;

import com.OnlineTutor.tutor.Tutor.TutorInfoDto;
import lombok.Data;

import java.util.List;

@Data
public class StreamDto {
    private Long streamId;
    private String streamName;
    private Long educationLevelId;
    private String educationLevel;

    private List<String> subjectName;  // List of subjects
    private List<String> name;         // List of tutor names
    private int numberOfStudents;// Total students in the stream

    private List<TutorInfoDto> tutors;

    public Long getStreamId() {
        return streamId;
    }

    public void setStreamId(Long streamId) {
        this.streamId = streamId;
    }

    public String getStreamName() {
        return streamName;
    }

    public void setStreamName(String streamName) {
        this.streamName = streamName;
    }

    public Long getEducationLevelId() {
        return educationLevelId;
    }

    public void setEducationLevelId(Long educationLevelId) {
        this.educationLevelId = educationLevelId;
    }

    public String getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    public List<String> getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(List<String> subjectName) {
        this.subjectName = subjectName;
    }

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public int getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(int numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    public List<TutorInfoDto> getTutors() {
        return tutors;
    }

    public void setTutors(List<TutorInfoDto> tutors) {
        this.tutors = tutors;
    }
}
