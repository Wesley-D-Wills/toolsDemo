package com.hello.springboothello.controller;

import com.hello.springboothello.utils.TokenUtilsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/token")
@Api
public class TokenController {

    @Autowired
    private TokenUtilsService tokenUtilsService;

    /**
     * 获取 Token 接口
     *
     * @return Token 串
     */
    @GetMapping("/getToken")
    @ApiOperation(value = "token 接口", httpMethod = "GET", notes = "获取token接口")
    public String getToken() {
        // 获取用户信息（这里使用模拟数据）
        // 注：这里存储该内容只是举例，其作用为辅助验证，使其验证逻辑更安全，如这里存储用户信息，其目的为:
        // - 1)、使用"token"验证 Redis 中是否存在对应的 Key
        // - 2)、使用"用户信息"验证 Redis 的 Value 是否匹配。
        String userInfo = "myInfo";
        // 获取 Token 字符串，并返回
        return tokenUtilsService.generateToken(userInfo);
    }

    /**
     * 接口幂等性测试接口
     *
     * @param token 幂等 Token 串
     * @return 执行结果
     */
    @PostMapping("testToken")
    @ApiOperation(value = "验证token接口", httpMethod = "POST", notes = "接口幂等性测试接口")
    public String testToken(@RequestHeader String token) {
        // 获取用户信息（这里使用模拟数据）
        String userInfo = "myInfo";
        // 根据 Token 和与用户相关的信息到 Redis 验证是否存在对应的信息
        boolean result = tokenUtilsService.validToken(token, userInfo);
        // 根据验证结果响应不同信息
        return result ? "正常调用" : "重复调用";
    }
}
