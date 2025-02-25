package com.OnlineTutor.tutor.Tutor.Education.subject;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "subject_tb")
@Data
public class SubjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subjectId")
    private Long subjectId;

    @Column(name = "streamId")
    private Long streamId;

    @Column(name = "subjectName")
    private String subjectName;

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getStreamId() {
        return streamId;
    }

    public void setStreamId(Long streamId) {
        this.streamId = streamId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }
}
