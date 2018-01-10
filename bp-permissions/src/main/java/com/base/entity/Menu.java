package com.base.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Menu {
    @Id
    private String id;
    @Column(nullable = false,unique = true)
    private String router;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(nullable = false)
    private String parentId;

    public Menu() {
    }

    public Menu(String id, String router, String name, String parentId) {
        this.id = id;
        this.router = router;
        this.name = name;
        this.parentId = parentId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
