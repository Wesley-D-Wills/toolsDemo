package com.hello.springbootmybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

// 补充 @Entity和@Table 区别 https://www.jb51.net/article/234705.htm
@Data
@TableName("tb_user") //https://blog.csdn.net/weixin_41842236/article/details/124696626
@ApiModel("user实体类")
public class User {

    @TableId(/*value = "id", */type = IdType.AUTO)
    @ApiModelProperty("user主键id")
    private Integer id;

    private String username;

    private int age;
    private String address;
    private String telNum;
    private String email;
}
