package com.wx.service;

import com.wx.dao.MySql;
import com.wx.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MyService {

    @Autowired
    private MySql mySql;

    private Random random = new Random();

    public void insertUser(User user) {
        wrapperUser(user);
        mySql.insert(user);
    }

    private void wrapperUser(User user) {
        user.setAge(0);
        user.setUsername("w");
        user.setEmail("w@");
        user.setAddress("BEIJING");
        user.setTelnum("123");

        user.setUsername(user.getUsername() + random.nextInt(10));
        user.setAge(user.getAge() + random.nextInt(10));
        user.setAddress(user.getAddress() + random.nextInt(10));
        user.setEmail(user.getEmail() + random.nextInt(10));
        user.setTelnum(user.getTelnum() + random.nextInt(10));
    }

    public void deleteUser(int id) {
        System.out.println("delete start");
        mySql.delete("user", id);
        System.out.println("delete end");
    }

    public User queryUser(String name, String addr) {
        return mySql.query(name, addr);
    }

    public void updateUser(int id) {
        User user = new User();
        user.setUsername("hhhhh");
        user.setAddress("wukelan");
        user.setTelnum("010800820911");
        mySql.update(user, id);
    }
}
