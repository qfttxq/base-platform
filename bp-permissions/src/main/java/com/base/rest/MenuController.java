package com.base.rest;

import com.base.entity.Menu;
import com.base.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * Created by qfttx on 2018/1/11.
 */
@RestController
@RequestMapping("menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("add")
    public Menu add(@RequestBody Menu menu){
        String id = UUID.randomUUID().toString();
        menu.setId(id);
        return menuService.add(menu);
    }
    @RequestMapping("del")
    public void del(@RequestBody List<Menu> menus){
        menuService.del(menus);
    }
    @RequestMapping("update")
    public void update(@RequestBody Menu menu){
        menuService.update(menu);
    }
    @RequestMapping("query")
    public List<Menu> query(Menu menu){
        return menuService.query(menu);
    }
}
