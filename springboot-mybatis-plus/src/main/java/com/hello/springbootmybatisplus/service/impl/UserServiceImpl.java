package com.hello.springbootmybatisplus.service.impl;


import com.hello.springbootmybatisplus.dao.IUserDao;
import com.hello.springbootmybatisplus.entity.User;
import com.hello.springbootmybatisplus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public void add(User user) {
        // 使用jpa的方式
        // userRepository.save(user);

        // 使用mybatis的方式
        userDao.save(user);
    }

    @Override
    public List<User> list() {

        System.out.println("findAll");
        // 使用jpa的方式
        // return userRepository.findAll();
        // 使用mybatis的方式
        return userDao.findList();
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public int deleteById(Integer id) {
        return userDao.deleteById(id);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }


}
