package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRole {
    @Id
    private String id;
    @Column
    private String userId;
    @Column
    private String roleId;
}
