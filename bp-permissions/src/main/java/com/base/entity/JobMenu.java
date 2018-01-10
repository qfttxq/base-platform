package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JobMenu {
    @Id
    private  String  id;
    @Column
    private String jobId;
    @Column
    private String menuId;

    public JobMenu() {
    }

    public JobMenu(String id, String jobId, String menuId) {
        this.id = id;
        this.jobId = jobId;
        this.menuId = menuId;
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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
