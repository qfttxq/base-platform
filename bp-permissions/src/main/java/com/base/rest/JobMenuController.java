package com.base.rest;

import com.base.entity.JobMenu;
import com.base.service.JobMenuService;
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
@RequestMapping("jobmenu")
public class JobMenuController {
    @Autowired
    private JobMenuService jobMenuService;

    @RequestMapping("add")
    public JobMenu add(@RequestBody JobMenu jobMenu){
        String id = UUID.randomUUID().toString();
        jobMenu.setId(id);
        return  jobMenuService.add(jobMenu);
    }
    @RequestMapping("del")
    public void del(@RequestBody List<JobMenu> jobMenus){
        jobMenuService.del(jobMenus);
    }
    @RequestMapping("update")
    public void update(JobMenu jobMenu){
        jobMenuService.update(jobMenu);
    }
    @RequestMapping("query")
    public List<JobMenu> query(JobMenu jobMenu){
        return jobMenuService.query(jobMenu);
    }
}
