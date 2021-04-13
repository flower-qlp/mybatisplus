package com.mybatisplus.controller;

import com.mybatisplus.bean.User;
import com.mybatisplus.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "user")
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/{id}")
    @ApiOperation(value = "根据ID查询用户信息")
    @CrossOrigin
    public User selectUserById(
            @ApiParam(value = "用户ID") @PathVariable(value = "id") Long id
    ) {
        return userService.selectById(id);
    }

    @PostMapping(value = "/create")
    @ApiOperation(value = "创建用户")
    @CrossOrigin
    public Boolean createUser(
            @RequestBody User user
    ) {
        return userService.createUser(user);
    }

    @PostMapping(value = "/update/all/id")
    @ApiOperation(value = "跟新用户全部信息")
    public Boolean updateUserAllById(
            @RequestBody User user
    ) {
        return userService.updateUserAllById(user);
    }

    @PostMapping(value = "/update/id")
    @ApiOperation(value = "根据条件跟新用户")
    public Boolean updateUserById(
            @RequestBody User user
    ) {
        return userService.updateUserById(user);
    }

    @GetMapping(value = "/select/{userCode}")
    @ApiOperation(value = "根据code获取用户信息")
    public User selectUserInfoByCode(
            @ApiParam(value = "用户代码") @PathVariable(value = "userCode") String userCode
    ) {
        return userService.selectByCode(userCode);
    }

    @PostMapping(value = "/select/list/map")
    @ApiOperation(value = "通过条件查询列表")
    public List<User> selectByMap(
            @RequestBody User user
    ) {
        return userService.selectByMap(user);
    }

    @GetMapping(value = "/select/list/page")
    @ApiOperation(value = "分页查询")
    public List<User> selectPage(
    ) {
        return userService.selectByPage();
    }
}
