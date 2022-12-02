package com.hello.springbootmybatisplus.dao;

import com.hello.springbootmybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDao {
    List<User> findList();

    User findById(Integer id);

    int deleteById(Integer id);

    int update(User user);

    int save(User user);

//    List<User> pageFind();
}
