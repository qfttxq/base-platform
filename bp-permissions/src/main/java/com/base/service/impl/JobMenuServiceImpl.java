package com.base.service.impl;

import com.base.entity.JobMenu;
import com.base.repository.JobMenuRepository;
import com.base.service.JobMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public class JobMenuServiceImpl implements JobMenuService {

    @Autowired
    private JobMenuRepository jobMenuRepository;
    @Override
    public JobMenu add(JobMenu jobMenu) {
        return jobMenuRepository.save(jobMenu);
    }

    @Override
    public void del(List<JobMenu> jobMenus) {
        jobMenuRepository.delete(jobMenus);
    }

    @Override
    public void update(JobMenu jobMenu) {
        jobMenuRepository.save(jobMenu);
    }

    @Override
    public List<JobMenu> query(JobMenu jobMenu) {
        return jobMenuRepository.findAll();
    }

    @Override
    public JobMenu findOne(String id) {
        return jobMenuRepository.findOne(id);
    }
}
