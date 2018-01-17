package com.base.rest;

import com.base.entity.UserMenu;
import com.base.service.UserMenuService;
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
public class UserMenuControllerTest {
    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;
    @Autowired
    private UserMenuService service;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }

    @Test
    public void add() throws Exception {
        Gson gson = new Gson();
        UserMenu userMenu = new UserMenu();
        String id = UUID.randomUUID().toString();
        userMenu.setId(id);
        userMenu.setUserId("08acb760-c417-4438-864e-391535ed30b1");
        userMenu.setMenuId("417b8072-0d9f-4808-9821-064434e14247");
        String jsonStr = gson.toJson(userMenu);
        mvc.perform(MockMvcRequestBuilders.get("/usermenu/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void del() throws Exception {

        Gson gson = new Gson();
        List<UserMenu> userMenus = new ArrayList<UserMenu>();
        UserMenu userMenu = new UserMenu();
        userMenu.setId("e5d8feca-fb70-442d-9726-22814d535943");
        userMenus.add(userMenu);
        String jsonStr = gson.toJson(userMenus, new ArrayList<UserMenu>().getClass());
        mvc.perform(MockMvcRequestBuilders.post("/usermenu/del")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jsonStr))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void update() throws Exception {
        Gson gson = new Gson();
        UserMenu userMenu = service.findOne("1839af95-559b-4c29-9477-622318a0daca");
        userMenu.setMenuId("417b8072-0d9f-4808-9821-064434e14247");
        String jsonStr = gson.toJson(userMenu);
        mvc.perform(MockMvcRequestBuilders.get("/usermenu/update")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(jsonStr)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void query() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/usermenu/query")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }
}
