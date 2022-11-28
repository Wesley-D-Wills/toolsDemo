package com.hello.springboothello.controller;

import com.hello.springboothello.dto.ResponseResult;
import com.hello.springboothello.entity.User;
import com.hello.springboothello.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping("/add")
    public ResponseResult<User> addUser(User user) {
        logger.info("add user {}", user);
        userService.add(user);
        return ResponseResult.success(user);
    }

    @GetMapping("list")
    public ResponseResult<List<User>> getUsers() {
        return ResponseResult.success(userService.list());
    }
}
