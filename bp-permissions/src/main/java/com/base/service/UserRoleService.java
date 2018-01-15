package com.base.service;

import com.base.entity.UserRole;

import java.util.List;

/**
 * Created by qfttx on 2018/1/11.
 */
public interface UserRoleService {
    UserRole add(UserRole userRole);
    void del(List<UserRole> userRoles);
    void update(UserRole userRole);
    List<UserRole> query(UserRole userRole);
    UserRole findOne(String id);
}
