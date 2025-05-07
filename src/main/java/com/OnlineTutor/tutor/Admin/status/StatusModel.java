package com.OnlineTutor.tutor.Admin.status;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@Entity
@Table(name = "status_tb")
@Data
public class StatusModel {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "statusId")
    private Long statusId;

     @Column(name = "status")
    private String status;

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
