package com.hello.springboothello.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "tb_user")
public class User {
    @Id
    private int userId;
    private String userName;
}
