package com.base.rest;

import com.base.entity.Job;
import com.base.service.JobService;
import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
    @Autowired
    private JobService service;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }

    @Test
    public void add() throws Exception {
        Gson gson = new Gson();
        String id = UUID.randomUUID().toString();
        Job job = new Job(id,"1","java开发工程师","java开发工程师",new Date().getTime());
        String jsonStr=gson.toJson(job);
        mvc.perform(MockMvcRequestBuilders.get("/job/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void del() throws Exception {

        Gson gson = new Gson();
        List<Job> roles = new ArrayList<Job>();
        Job job = new Job();
        job.setId("2b538356-81b9-4d1f-b1a8-a7485167ac5a");
        roles.add(job);
        String jsonStr = gson.toJson(job, new ArrayList<Job>().getClass());
        mvc.perform(MockMvcRequestBuilders.post("/job/del")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void update() throws Exception {
        Gson gson = new Gson();
        Job job = service.findOne("2c71b250-861e-4572-b211-f8ba4eb40a17");
        job.setJobId("2");
        job.setJobName("高级JAVA工程师");
        job.setJobDesc("物流顾问");
        String jsonStr=gson.toJson(job);

        mvc.perform(MockMvcRequestBuilders.get("/job/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void query() throws Exception {
        Gson gson = new Gson();
        Job job = new Job();
        String jsonStr=gson.toJson(job);
        mvc.perform(MockMvcRequestBuilders.get("/job/query")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
