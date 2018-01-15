package com.base.rest;

import com.base.entity.UserRole;
import com.base.service.UserRoleService;
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
@RequestMapping("userRole")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @RequestMapping("add")
    public UserRole add(@RequestBody UserRole userRole){
        String id = UUID.randomUUID().toString();
        userRole.setId(id);
        return  userRoleService.add(userRole);
    }
    @RequestMapping("del")
    public void del(@RequestBody List<UserRole> userRoles){
        userRoleService.del(userRoles);
    }
    @RequestMapping("update")
    public void update(UserRole userRole){
        userRoleService.update(userRole);
    }
    @RequestMapping("query")
    public List<UserRole> query(UserRole userRole){
        return userRoleService.query(userRole);
    }
}
