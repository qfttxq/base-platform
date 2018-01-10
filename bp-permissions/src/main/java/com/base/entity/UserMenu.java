package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserMenu {

    @Id
    private String id;
    @Column
    private String userId;
    @Column
    private String menuId;

    public UserMenu() {
    }

    public UserMenu(String id, String userId, String menuId) {
        this.id = id;
        this.userId = userId;
        this.menuId = menuId;
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

    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }
}
