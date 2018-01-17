package com.base.rest;

import com.base.entity.Menu;
import com.base.service.MenuService;
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
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MenuControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
    @Autowired
    private MenuService service;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }

    @Test
    public void add() throws Exception {
        Gson gson = new Gson();
        Menu menu = new Menu();
        String id = UUID.randomUUID().toString();
        menu.setId(id);
        menu.setName("根菜单");
        menu.setRouter("rootMenu");
        menu.setParentId("0");
        String jsonStr = gson.toJson(menu);
        mvc.perform(MockMvcRequestBuilders.get("/menu/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void del() throws Exception {

        Gson gson = new Gson();
        List<Menu> menus = new ArrayList<Menu>();
        Menu menu = new Menu();
        menu.setId("0729074f-5c3a-431d-a627-d452139a9e0c");
        menus.add(menu);
        String jsonStr = gson.toJson(menus, new ArrayList<Menu>().getClass());
        mvc.perform(MockMvcRequestBuilders.post("/menu/del")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void update() throws Exception {
        Gson gson = new Gson();
        Menu menu = service.findOne("417b8072-0d9f-4808-9821-064434e14247");
        menu.setName("用户管理");
        menu.setRouter("/user");
        String jsonStr = gson.toJson(menu);
        mvc.perform(MockMvcRequestBuilders.get("/menu/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void query() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/menu/query")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
