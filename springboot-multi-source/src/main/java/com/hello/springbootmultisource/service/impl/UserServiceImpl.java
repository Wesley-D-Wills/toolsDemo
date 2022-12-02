package com.hello.springbootmultisource.service.impl;


import com.hello.springbootmultisource.dao.demo1.IUserDao;
import com.hello.springbootmultisource.dao.demo2.IUserDemo2Dao;
import com.hello.springbootmultisource.entity.User;
import com.hello.springbootmultisource.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private IUserDemo2Dao  userDemo2Dao;

    @Override
    public void add(User user) {
        // 使用jpa的方式
        // userRepository.save(user);

        // 使用mybatis的方式
        userDao.save(user);
        userDemo2Dao.save(user);
    }

    @Override
    public List<User> list() {

        System.out.println("findAll");
        // 使用jpa的方式
        // return userRepository.findAll();
        System.out.println(userDemo2Dao.findList());
        // 使用mybatis的方式
        return userDao.findList();
    }

    @Override
    public User findById(Integer id) {
        System.out.println(userDemo2Dao.findById(id));
        return userDao.findById(id);
    }

    @Override
    public int deleteById(Integer id) {
        System.out.println(userDemo2Dao.deleteById(id));
        return userDao.deleteById(id);
    }

    @Override
    public int update(User user) {
        System.out.println(userDemo2Dao.update(user));
        return userDao.update(user);
    }


}
