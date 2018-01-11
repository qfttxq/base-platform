package com.base.service.impl;

import com.base.entity.Menu;
import com.base.entity.RoleMenu;
import com.base.repository.MenuRepository;
import com.base.repository.RoleMenuRepository;
import com.base.service.MenuService;
import com.base.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public class RoleMenuServiceImpl implements RoleMenuService {

    @Autowired
    private RoleMenuRepository roleMenuRepository;

    @Override
    public RoleMenu add(RoleMenu roleMenu) {
        return roleMenuRepository.save(roleMenu);
    }

    @Override
    public void del(List<RoleMenu> roleMenus) {
        roleMenuRepository.delete(roleMenus);
    }

    @Override
    public void update(RoleMenu roleMenu) {
        roleMenuRepository.save(roleMenu);
    }

    @Override
    public List<RoleMenu> query(RoleMenu roleMenu) {
        return roleMenuRepository.findAll();
    }

    @Override
    public RoleMenu findOne(String id) {
        return roleMenuRepository.findOne(id);
    }
}
