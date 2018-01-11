package com.base.service.impl;

import com.base.entity.Menu;
import com.base.entity.UserMenu;
import com.base.repository.MenuRepository;
import com.base.repository.UserMenuRepository;
import com.base.service.MenuService;
import com.base.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public class UserMenuServiceImpl implements UserMenuService {

    @Autowired
    private UserMenuRepository userMenuRepository;
    @Override
    public UserMenu add(UserMenu userMenu) {
        return userMenuRepository.save(userMenu);
    }

    @Override
    public void del(List<UserMenu> userMenus) {
        userMenuRepository.delete(userMenus);
    }

    @Override
    public void update(UserMenu userMenu) {
        userMenuRepository.save(userMenu);
    }

    @Override
    public List<UserMenu> query(UserMenu userMenu) {
        return userMenuRepository.findAll();
    }

    @Override
    public UserMenu findOne(String id) {
        return userMenuRepository.findOne(id);
    }
}
