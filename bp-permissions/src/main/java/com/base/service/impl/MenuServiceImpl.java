package com.base.service.impl;

import com.base.entity.Menu;
import com.base.repository.MenuRepository;
import com.base.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuRepository menuRepository;
    @Override
    public Menu add(Menu menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void del(List<Menu> menus) {
        menuRepository.delete(menus);
    }

    @Override
    public void update(Menu menu) {
        menuRepository.save(menu);
    }

    @Override
    public List<Menu> query(Menu menu) {
        return menuRepository.findAll();
    }

    @Override
    public Menu findOne(String id) {
        return menuRepository.findOne(id);
    }
}
