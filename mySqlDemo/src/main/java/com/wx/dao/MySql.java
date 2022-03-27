package com.wx.dao;

import com.wx.model.dto.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

@Repository
@Mapper // 在启动类上写@MapperScan("com.wx.dao") 或者 直接在Mapper类上添加@Mapper
public interface MySql {
    @Insert("INSERT INTO user(username, age, email, address, tel_num) VALUES(#{username}, " +
            "#{age}, #{email}, #{address}, #{telnum})")
    void insert(User user);

    @Delete("DELETE FROM ${table} where id = #{id}")
    void delete(String table, int id);

    // 如果没有使用数据转换tel_num转换失败
    @Select("SELECT * from user where username = #{name} and address = #{addr}")
    User query(String name, String addr);

    @Update("UPDATE user SET tel_num = #{user.telnum}, username = #{user.username}, address = #{user.address} where id = #{id}")
    void update(User user, int id);
}
