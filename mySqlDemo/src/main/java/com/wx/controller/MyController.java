package com.wx.controller;

import com.wx.model.dto.User;
import com.wx.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/insert")
    public String insertUser() {
        myService.insertUser(new User());
        return "insert success";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable int id) {
        myService.deleteUser(id);
        return "delete success";
    }

    @GetMapping("/query")
    public String queryUser(@RequestParam(name = "name") String name, String addr) {
        User user = myService.queryUser(name, addr);
        return "query success: " + user;
    }

    @GetMapping("/update/{id}")
    public String updateUser(@PathVariable int id) {
        myService.updateUser(id);
        return "update success";
    }

    @GetMapping("/")
    public String login() {
        return "hello world";
    }
}
