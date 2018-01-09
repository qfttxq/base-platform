package com.base.rest;

import com.base.entity.Role;
import com.base.service.RoleService;
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
public class RoleControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
    @Autowired
    private RoleService service;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }

    @Test
    public void add() throws Exception {
        Gson gson = new Gson();
        String id = UUID.randomUUID().toString();
        Role role = new Role(id,"1","管理员","管理员",new Date().getTime());
        String jsonStr=gson.toJson(role);
        mvc.perform(MockMvcRequestBuilders.get("/role/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void del() throws Exception {

        Gson gson = new Gson();
        List<Role> roles = new ArrayList<Role>();
        Role role = new Role();
        role.setId("2b538356-81b9-4d1f-b1a8-a7485167ac5a");
        roles.add(role);
        String jsonStr = gson.toJson(role, new ArrayList<Role>().getClass());
        mvc.perform(MockMvcRequestBuilders.post("/role/del")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void update() throws Exception {
        Gson gson = new Gson();
        Role role = service.findOne("2c71b250-861e-4572-b211-f8ba4eb40a17");
        role.setRoleId("2");
        role.setRoleName("物流顾问");
        role.setRoleDesc("物流顾问");
        String jsonStr=gson.toJson(role);

        mvc.perform(MockMvcRequestBuilders.get("/role/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void query() throws Exception {
        Gson gson = new Gson();
        Role role = new Role();
        String jsonStr=gson.toJson(role);
        mvc.perform(MockMvcRequestBuilders.get("/role/query")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
