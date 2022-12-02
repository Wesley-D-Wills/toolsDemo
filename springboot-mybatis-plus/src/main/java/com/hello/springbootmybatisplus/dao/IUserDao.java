package com.hello.springbootmybatisplus.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hello.springbootmybatisplus.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IUserDao extends BaseMapper<User> {
    List<User> findList();

    User findById(Integer id);

    int deleteById(Integer id);

    int update(User user);

    int save(User user);

//    List<User> pageFind();
}
