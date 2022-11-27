package com.hello.springboothello.dao;

import com.hello.springboothello.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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
