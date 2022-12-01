package com.hello.springboothello.dao;

import com.hello.springboothello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * 在服务器启动的时候，jpa的启动管理类会自动扫描继承了JpaRepository的接口，然后添加到动态代理管理中，
 * 然后注入到spring的容器中。
 *
 * @NoRepositoryBean注解确保被该注解修饰的继承了JapRepository接口的接口不会在运行时被创建实例。也就是说，
 * 使用了该注解的接口不会被单独创建实例，只会作为作为其他接口的父接口而被使用
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

//    private List<User> userList = new ArrayList<>();
//
//    public void save(User user) {
//        userList.add(user);
//    }
//
//    public List<User> findAll() {
//        return userList;
//    }
}
