package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserJob {
    @Id
    private String id;
    @Column
    private String userId;
    @Column
    private String jobId;

    public UserJob() {
    }

    public UserJob(String id, String userId, String jobId) {
        this.id = id;
        this.userId = userId;
        this.jobId = jobId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
}
