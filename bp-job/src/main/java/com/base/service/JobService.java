package com.base.service;

import com.base.entity.Job;

import java.util.List;

public interface JobService {
    Job add(Job job);
    void del(List<Job> jobs);
    void update(Job job);
    List<Job> query(Job job);
    Job findOne(String id);
}
