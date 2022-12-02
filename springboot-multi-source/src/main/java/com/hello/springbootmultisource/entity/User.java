package com.hello.springbootmultisource.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

// 补充 @Entity和@Table 区别 https://www.jb51.net/article/234705.htm
@Data
@ApiModel("user实体类")
public class User {

    @ApiModelProperty("user主键id")
    private Integer id;

    private String username;

    private int age;
    private String address;
    private String telNum;
    private String email;
}
