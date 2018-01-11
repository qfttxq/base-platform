package com.base.service;

import com.base.entity.RoleMenu;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public interface RoleMenuService {
    RoleMenu add(RoleMenu roleMenu);
    void del(List<RoleMenu> roleMenus);
    void update(RoleMenu roleMenu);
    List<RoleMenu> query(RoleMenu roleMenu);
    RoleMenu findOne(String id);
}
