package com.base.service.impl;

import com.base.entity.User;
import com.base.repository.UserRepository;
import com.base.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Override
    public User add(User user) {
         return userRepository.save(user);
    }

    @Override
    public void del(List<User> users) {
        userRepository.delete(users);
    }

    @Override
    public void update(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> query(User user) {
       return userRepository.findAll();
    }

    @Override
    public User findOne(String id) {
        return userRepository.findOne(id);
    }


}
