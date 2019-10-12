package com.mybatisplus.controller;

import com.mybatisplus.service.UserInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "userInfo")
public class UserInfoController {

    @Autowired
    private UserInfoService userInfoService;

    @PostMapping(value = "/create/userInfo")
    @ApiOperation(value = "创建用户信息")
    public Boolean insert() {
        return userInfoService.insert();
    }

    @PostMapping(value = "/select/userInfo")
    @ApiOperation(value = "查询用户信息")
    public void select() {
        userInfoService.select();
    }

}
