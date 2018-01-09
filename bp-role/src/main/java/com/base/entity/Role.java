package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    @Id
    private String id;

    @Column(nullable = false,unique = true)
    private String roleId;

    @Column(nullable = false,unique = true)
    private String roleName;

    @Column
    private String roleDesc;

    @Column(nullable = false,unique = true)
    private long createTime;

    public Role() {
    }

    public Role(String id, String roleId, String roleName, String roleDesc, long createTime) {
        this.id = id;
        this.roleId = roleId;
        this.roleName = roleName;
        this.roleDesc = roleDesc;
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
