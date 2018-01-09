package com.base;

import com.base.entity.User;
import com.base.service.UserService;
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

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
    @Autowired
    private UserService service;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }

    @Test
    public void add() throws Exception {

        mvc.perform(MockMvcRequestBuilders.get("/user/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .param("memberId", "210051")
                .param("name", "陈平")
                .param("idcard", "430181198408053319")
                .param("mobile", "18684710082")
                .param("createTime", new Date().getTime() + "")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void del() throws Exception {

        Gson gson = new Gson();
        List<User> users = new ArrayList<User>();
        User user = new User();
        user.setId("2b538356-81b9-4d1f-b1a8-a7485167ac5a");
        users.add(user);
        String jsonStr = gson.toJson(users, new ArrayList<User>().getClass());
        mvc.perform(MockMvcRequestBuilders.post("/user/del")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void update() throws Exception {

        User user = service.findOne("4ef1e596-3105-4b6d-b83b-2a042f378d9f");
        user.setName("李中二");
        user.setIdcard("430181199908053323");
        user.setAddress("湖南省长沙市雨花区");
        mvc.perform(MockMvcRequestBuilders.get("/user/update")
                .param("id", user.getId())
                .param("memberId", user.getMemberId())
                .param("name", user.getName())
                .param("sex", user.getSex() + "")
                .param("age", user.getAge() + "")
                .param("idcard", user.getIdcard())
                .param("address", user.getAddress())
                .param("mobile", user.getMobile())
                .param("createTime", user.getCreateTime() + "")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void query() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/user/query")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
