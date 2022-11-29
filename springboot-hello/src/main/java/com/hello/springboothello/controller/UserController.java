package com.hello.springboothello.controller;

import com.hello.springboothello.dto.ResponseResult;
import com.hello.springboothello.entity.groups.UserGroups;
import com.hello.springboothello.entity.User;
import com.hello.springboothello.entity.UserParam;
import com.hello.springboothello.service.UserService;
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

@RestController
@RequestMapping("/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ResponseResult<User> addUser(User user) {
        logger.info("add user {}", user);
        userService.add(user);
        return ResponseResult.success(user);
    }

    @GetMapping("list")
    public ResponseResult<List<User>> getUsers() {
        return ResponseResult.success(userService.list());
    }

    @PostMapping("add")
    public ResponseEntity<String> addUserParam(@Validated(UserGroups.AddValidationGroup.class) @RequestBody UserParam userParam,
                                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                logger.error("Invalid parameter : object - {}, field - {}, errorMessage - {}",
                        fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body("invalid paramter");
        }
        return ResponseEntity.ok("success");
    }

    @PostMapping("update")
    public ResponseEntity<String> updateUserParam(@Validated @RequestBody UserParam userParam,
                                                  BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> errors = bindingResult.getAllErrors();
            errors.forEach(p -> {
                FieldError fieldError = (FieldError) p;
                logger.error("Invalid parameter : object - {}, field - {}, errorMessage - {}",
                        fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body("invalid paramter");
        }
        return ResponseEntity.ok("success");
    }
}
