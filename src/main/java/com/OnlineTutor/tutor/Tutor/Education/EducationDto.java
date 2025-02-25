package com.OnlineTutor.tutor.Tutor.Education;

import lombok.Data;

@Data
public class EducationDto {

    private Long streamId;
    private String streamName;


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
}
