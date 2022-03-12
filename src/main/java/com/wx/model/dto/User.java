package com.wx.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    private String username;
    private Integer age;
    private String email;
    private String address;
    private String telnum;
}
