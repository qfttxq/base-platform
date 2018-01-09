package com.base.service;

import com.base.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);
    void del(List<User> users);
    void update(User user);
    List<User> query(User user);
    User findOne(String id);
}
