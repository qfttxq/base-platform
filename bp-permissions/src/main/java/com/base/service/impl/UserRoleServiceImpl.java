package com.base.service.impl;

import com.base.entity.UserRole;
import com.base.repository.UserRoleRepository;
import com.base.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;
    @Override
    public UserRole add(UserRole userRole) {
        return userRoleRepository.save(userRole);
    }

    @Override
    public void del(List<UserRole> userRoles) {
        userRoleRepository.delete(userRoles);
    }

    @Override
    public void update(UserRole userRole) {
        userRoleRepository.save(userRole);
    }

    @Override
    public List<UserRole> query(UserRole userRole) {
        return userRoleRepository.findAll();
    }

    @Override
    public UserRole findOne(String id) {
        return userRoleRepository.findOne(id);
    }
}
