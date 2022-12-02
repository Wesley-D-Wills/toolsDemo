package com.hello.springboothello.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hello.springboothello.dto.ResponseResult;
import com.hello.springboothello.entity.groups.UserGroups;
import com.hello.springboothello.entity.User;
import com.hello.springboothello.entity.UserParam;
import com.hello.springboothello.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ApiOperation(value = "user接口", httpMethod = "GET", notes = "这个是添加user的接口")
    public ResponseResult<User> addUser(User user) {
        logger.info("add user {}", user);
        userService.add(user);
        return ResponseResult.success(user);
    }

    @GetMapping("list")
    @ApiOperation(value = "list接口", httpMethod = "GET", notes = "获取全部user数据")
    public ResponseResult<List<User>> getUsers() {
        return ResponseResult.success(userService.list());
    }

    @PostMapping("page")
    @ApiOperation(value = "分页查询接口", httpMethod = "POST", notes = "获取分页user数据")
    public ResponseResult<PageInfo<User>> getPageUsers(@RequestBody Map<String, Integer> pageInfo) {
        // 直接返回所有数据
        // return ResponseResult.success(userService.list());

        // 分页查询（物理分页）
        PageHelper.startPage(pageInfo.getOrDefault("pageNum", 0),
                pageInfo.getOrDefault("pageSize", 3));
        List<User> list = userService.list();
        PageInfo<User> pageInfoResult = new PageInfo<>(list);
        return ResponseResult.success(pageInfoResult);
    }

    @GetMapping("find/{userId}")
    @ApiOperation(value = "查找user接口", httpMethod = "GET", notes = "根据id查找user")
    public ResponseResult<User> findUser(@PathVariable Integer userId) {
        return ResponseResult.success(userService.findById(userId));
    }

    @GetMapping("delete/{userId}")
    @ApiOperation(value = "user删除接口", httpMethod = "GET", notes = "这个是删除user的接口")
    public ResponseResult<Integer> deleteUser(@PathVariable Integer userId) {
        return ResponseResult.success(userService.deleteById(userId));
    }

    @PostMapping("updateUser")
    @ApiOperation(value = "update接口", httpMethod = "POST", notes = "这个是修改user的接口")
    public ResponseResult<Integer> updateUser(@RequestBody User user) {
        return ResponseResult.success(userService.update(user));
    }

    @PostMapping("add")
    public ResponseEntity<String> addUserParam(@Validated(UserGroups.AddValidationGroup.class) @RequestBody UserParam userParam
                                                 /* BindingResult bindingResult*/) {
//        if (bindingResult.hasErrors()) {
//            List<ObjectError> errors = bindingResult.getAllErrors();
//            errors.forEach(p -> {
//                FieldError fieldError = (FieldError) p;
//                logger.error("Invalid parameter : object - {}, field - {}, errorMessage - {}",
//                        fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
//            });
//            return ResponseEntity.badRequest().body("invalid paramter");
//        }
        return ResponseEntity.ok("success");
    }

    @PostMapping("update")
    public ResponseEntity<String> updateUserParam(@Validated @RequestBody UserParam userParam
                                                 /* BindingResult bindingResult*/) {
//        if (bindingResult.hasErrors()) {
//            List<ObjectError> errors = bindingResult.getAllErrors();
//            errors.forEach(p -> {
//                FieldError fieldError = (FieldError) p;
//                logger.error("Invalid parameter : object - {}, field - {}, errorMessage - {}",
//                        fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
//            });
//            return ResponseEntity.badRequest().body("invalid paramter");
//        }
        return ResponseEntity.ok("success");
    }
}
