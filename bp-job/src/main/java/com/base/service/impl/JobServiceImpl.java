package com.base.service.impl;

import com.base.entity.Job;
import com.base.repository.JobRepository;
import com.base.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Override
    public Job add(Job job) {
         return jobRepository.save(job);
    }

    @Override
    public void del(List<Job> jobs) {
        jobRepository.delete(jobs);
    }

    @Override
    public void update(Job job) {
        jobRepository.save(job);
    }

    @Override
    public List<Job> query(Job job) {
       return jobRepository.findAll();
    }

    @Override
    public Job findOne(String id) {
        return jobRepository.findOne(id);
    }


}
