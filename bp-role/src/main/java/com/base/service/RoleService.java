package com.base.service;

import com.base.entity.Role;

import java.util.List;

public interface RoleService {
    Role add(Role Role);
    void del(List<Role> Roles);
    void update(Role Role);
    List<Role> query(Role Role);
    Role findOne(String id);
}
