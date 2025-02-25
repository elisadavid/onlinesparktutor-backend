package com.OnlineTutor.tutor.Tutor.Education.stream;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "stream_tb")
@Data
public class StreamModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "streamId")
    private Long streamId;

    @Column(name = "streamName")
    private String streamName;

    @Column(name = "educationLevelId")
    private Long educationLevelId;

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
}
