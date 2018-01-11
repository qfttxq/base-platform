package com.base.service;

import com.base.entity.UserMenu;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public interface UserMenuService {
    UserMenu add(UserMenu userMenu);
    void del(List<UserMenu> userMenus);
    void update(UserMenu userMenu);
    List<UserMenu> query(UserMenu userMenu);
    UserMenu findOne(String id);
}
