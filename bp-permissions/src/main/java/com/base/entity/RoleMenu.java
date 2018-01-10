package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class RoleMenu {
    @Id
    private String id;
    @Column
    private String roleId;
    @Column
    private String menuId;

    public RoleMenu() {
    }

    public RoleMenu(String id, String roleId, String menuId) {
        this.id = id;
        this.roleId = roleId;
        this.menuId = menuId;
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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
