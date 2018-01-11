package com.base.rest;

import com.base.entity.RoleMenu;
import com.base.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by qfttx on 2018/1/11.
 */
@RestController
@RequestMapping("rolemenu")
public class RoleMenuController {
    @Autowired
    private RoleMenuService roleMenuService;

    @RequestMapping("add")
    public RoleMenu add(@RequestBody RoleMenu roleMenu){
        String id = UUID.randomUUID().toString();
        roleMenu.setId(id);
        return  roleMenuService.add(roleMenu);
    }
    @RequestMapping("del")
    public void del(@RequestBody List<RoleMenu> roleMenus){
        roleMenuService.del(roleMenus);
    }
    @RequestMapping("update")
    public void update(RoleMenu roleMenu){
        roleMenuService.update(roleMenu);
    }
    @RequestMapping("query")
    public List<RoleMenu> query(RoleMenu roleMenu){
        return roleMenuService.query(roleMenu);
    }
}
