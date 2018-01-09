package com.base.rest;

import com.base.entity.User;
import com.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "add")
    public User add(User user){
        System.out.println("user:"+user);
        String id = UUID.randomUUID().toString();
        user.setId(id);
        return  userService.add(user);
    }
    @RequestMapping("update")
    public void update(User user){
        userService.update(user);
    }
    @RequestMapping("query")
    public List<User> query(User user){
        return userService.query(user);
    }
    @RequestMapping("del")
    public void del(@RequestBody List<User> users){
        userService.del(users);
    }
}
