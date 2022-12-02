package com.hello.springbootmultisource.dao.demo2;


import com.hello.springbootmultisource.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDemo2Dao {
    List<User> findList();

    User findById(Integer id);

    int deleteById(Integer id);

    int update(User user);

    int save(User user);

//    List<User> pageFind();
}
