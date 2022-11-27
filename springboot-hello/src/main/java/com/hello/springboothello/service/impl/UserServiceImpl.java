package com.hello.springboothello.service.impl;

import com.hello.springboothello.dao.UserRepository;
import com.hello.springboothello.entity.User;
import com.hello.springboothello.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void add(User user) {
        userRepository.save(user);
    }

    @Override
    public List<User> list() {
        System.out.println("findAll");
        return userRepository.findAll();
    }
}
