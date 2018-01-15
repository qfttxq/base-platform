package com.base.rest;

import com.base.entity.UserJob;
import com.base.service.UserJobService;
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
@RequestMapping("userjob")
public class UserJobController {
    @Autowired
    private UserJobService userJobService;

    @RequestMapping("add")
    public UserJob add(@RequestBody UserJob userJob){
        String id = UUID.randomUUID().toString();
        userJob.setId(id);
        return  userJobService.add(userJob);
    }
    @RequestMapping("del")
    public void del(@RequestBody List<UserJob> menus){
        userJobService.del(menus);
    }
    @RequestMapping("update")
    public void update(UserJob userJob){
        userJobService.update(userJob);
    }
    @RequestMapping("query")
    public List<UserJob> query(UserJob userJob){
        return userJobService.query(userJob);
    }
}
