package com.hello.springboothello.entity;

import com.hello.springboothello.entity.groups.UserGroups;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

// 参数校验
@Data
@Builder
public class UserParam  {

    @NotEmpty(message = "userId could not be empty", groups = UserGroups.AddValidationGroup.class)
    private String userId;

    @NotEmpty(message = "email could not be empty")
    @Email(message = "invalid email")
    private String email;

    @NotEmpty(message = "cardNo could not be empty")
    @Pattern(regexp = "^(\\d{6})(\\d{4})(\\d{2})(\\d{2})(\\d{3})([0-9]|X)$", message = "invalid ID")
    private String cardNo;

    @NotEmpty(message = "nickName could not be empty")
    @Length(min = 1, max = 10, message = "nick name should be 1-10")
    private String nickName;

//    @NotEmpty(message = "sex could not be empty")
    @Range(min = 0, max = 1, message = "sex should be 0-1")
    private int sex;

    @Max(value = 100, message = "Please input valid age 0-100")
    @Min(value = 0, message = "Please input valid age 0-100")
    private int age;

//    @Valid
//    private AddressParam address;
}
