package com.base.service;

import com.base.entity.JobMenu;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public interface JobMenuService {
    JobMenu add(JobMenu jobMenu);
    void del(List<JobMenu> jobMenus);
    void update(JobMenu jobMenu);
    List<JobMenu> query(JobMenu jobMenu);
    JobMenu findOne(String id);
}
