package com.base.service;

import com.base.entity.UserJob;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public interface UserJobService {
    UserJob add(UserJob userJob);
    void del(List<UserJob> userJobs);
    void update(UserJob userJob);
    List<UserJob> query(UserJob userJob);
    UserJob findOne(String id);
}
