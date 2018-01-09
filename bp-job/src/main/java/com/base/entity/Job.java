package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Job {
    @Id
    private String id;

    @Column(nullable = false,unique = true)
    private String jobId;

    @Column(nullable = false,unique = true)
    private String jobName;

    @Column
    private String jobDesc;

    @Column(nullable = false,unique = true)
    private long createTime;

    public Job() {
    }

    public Job(String id, String jobId, String jobName, String jobDesc, long createTime) {
        this.id = id;
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobDesc = jobDesc;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
