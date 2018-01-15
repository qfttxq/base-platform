package com.base.service.impl;

import com.base.entity.UserJob;
import com.base.repository.UserJobRepository;
import com.base.service.UserJobService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public class UserJobServiceImpl implements UserJobService {

    @Autowired
    private UserJobRepository userJobRepository;

    @Override
    public UserJob add(UserJob userJob) {
        return userJobRepository.save(userJob);
    }

    @Override
    public void del(List<UserJob> userJobs) {
        userJobRepository.delete(userJobs);
    }

    @Override
    public void update(UserJob userJob) {
        userJobRepository.save(userJob);
    }

    @Override
    public List<UserJob> query(UserJob userJob) {
        return userJobRepository.findAll();
    }

    @Override
    public UserJob findOne(String id) {
        return userJobRepository.findOne(id);
    }
}
