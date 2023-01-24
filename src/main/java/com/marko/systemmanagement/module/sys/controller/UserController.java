package com.marko.systemmanagement.module.sys.controller;

import com.marko.systemmanagement.module.sys.model.RO.UserReq;
import com.marko.systemmanagement.module.sys.model.User;
import com.marko.systemmanagement.module.sys.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/sys_user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/saving")
    public User createUser(@Valid @RequestBody User user) {
        return userService.saveNewUser(user);
    }

    @PostMapping("/list")
    public ResponseEntity<Page<User>> queryList(@RequestBody UserReq ro) {
        return ResponseEntity.ok(userService.queryList(ro));
    }


}
