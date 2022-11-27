package com.hello.springboothello.service;

import com.hello.springboothello.entity.User;

import java.util.List;

public interface UserService {
    void add(User user);

    List<User> list();
}
