package com.base.service;

import com.base.entity.Menu;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public interface MenuService {
    Menu add(Menu menu);
    void del(List<Menu> menus);
    void update(Menu menu);
    List<Menu> query(Menu menu);
    Menu findOne(String id);
}
