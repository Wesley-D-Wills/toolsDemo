package com.hello.springboothello.service;

import com.hello.springboothello.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> list();

    User findById(Integer id);

    int deleteById(Integer id);

    int update(User user);
}
