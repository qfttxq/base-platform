package com.base.service.impl;

import com.base.entity.Role;
import com.base.repository.RoleRepository;
import com.base.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleRepository RoleRepository;
    @Override
    public Role add(Role Role) {
         return RoleRepository.save(Role);
    }

    @Override
    public void del(List<Role> Roles) {
        RoleRepository.delete(Roles);
    }

    @Override
    public void update(Role Role) {
        RoleRepository.save(Role);
    }

    @Override
    public List<Role> query(Role Role) {
       return RoleRepository.findAll();
    }

    @Override
    public Role findOne(String id) {
        return RoleRepository.findOne(id);
    }


}
