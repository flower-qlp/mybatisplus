package com.mybatisplus.test;

import com.alibaba.fastjson.JSON;
import com.mybatisplus.bean.User;
import com.mybatisplus.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class userTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUser() {
        User user = userService.selectById(1L);
        System.out.println(JSON.toJSONString(user));
    }

}
