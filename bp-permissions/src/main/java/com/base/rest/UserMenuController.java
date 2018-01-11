package com.base.rest;

import com.base.entity.UserMenu;
import com.base.service.UserMenuService;
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
@RequestMapping("usermenu")
public class UserMenuController {
    @Autowired
    private UserMenuService userMenuService;

    @RequestMapping("add")
    public UserMenu add(@RequestBody UserMenu userMenu){
        String id = UUID.randomUUID().toString();
        userMenu.setId(id);
        return  userMenuService.add(userMenu);
    }
    @RequestMapping("del")
    public void del(@RequestBody List<UserMenu> userMenus){
        userMenuService.del(userMenus);
    }
    @RequestMapping("update")
    public void update(UserMenu userMenu){
        userMenuService.update(userMenu);
    }
    @RequestMapping("query")
    public List<UserMenu> query(UserMenu userMenu){
        return userMenuService.query(userMenu);
    }
}
