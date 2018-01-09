package com.base.rest;

import com.base.entity.Job;
import com.base.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("job")
public class JobController {
    @Autowired
    private JobService jobService;
    @RequestMapping(value = "add")
    public Job add( @RequestBody Job job){
        System.out.println("Job:"+job);
        String id = UUID.randomUUID().toString();
        job.setId(id);
        return  jobService.add(job);
    }
    @RequestMapping("update")
    public void update(@RequestBody Job job){
        jobService.update(job);
    }
    @RequestMapping("query")
    public List<Job> query(@RequestBody Job job){
        return jobService.query(job);
    }
    @RequestMapping("del")
    public void del(@RequestBody List<Job> jobs){
        jobService.del(jobs);
    }
}
