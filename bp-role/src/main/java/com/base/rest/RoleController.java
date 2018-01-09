package com.base.rest;

import com.base.entity.Role;
import com.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("role")
public class RoleController {
    @Autowired
    private RoleService RoleService;
    @RequestMapping(value = "add")
    public Role add( @RequestBody Role role){
        System.out.println("Role:"+role);
        String id = UUID.randomUUID().toString();
        role.setId(id);
        return  RoleService.add(role);
    }
    @RequestMapping("update")
    public void update(@RequestBody Role role){
        RoleService.update(role);
    }
    @RequestMapping("query")
    public List<Role> query(@RequestBody Role role){
        return RoleService.query(role);
    }
    @RequestMapping("del")
    public void del(@RequestBody List<Role> roles){
        RoleService.del(roles);
    }
}
