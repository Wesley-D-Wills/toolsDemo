package com.hello.springboothello.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

// 补充 @Entity和@Table 区别 https://www.jb51.net/article/234705.htm
@Data
@Entity
@Table(name = "tb_user")
@ApiModel("user实体类")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("user主键id")
    private Integer id;

    @Column
    private String username;

    private int age;
    private String address;
    private String telNum;
    private String email;
}
