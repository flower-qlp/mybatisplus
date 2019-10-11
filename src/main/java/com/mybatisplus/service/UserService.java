package com.mybatisplus.service;

import com.mybatisplus.bean.User;
import com.mybatisplus.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserService {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Autowired
    private UserDao userDao;

    public User selectById(Long id) {
        return userDao.selectById(id);
    }

    public Boolean createUser(User user) {
        try {
            user.setCreateTime(dateFormat.format(new Date()));
            userDao.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("用户插入失败，请联系管理员！");
        }
        return true;
    }

    /**
     * updateAll跟新所有值
     **/
    public Boolean updateUserAllById(User user) {
        try {
            user.setUpdateTime(dateFormat.format(new Date()));
            user.setCreateTime(null);
            userDao.updateAllColumnById(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请联系管理员！");
        }
        return true;
    }

    /**
     * update跟新非空值
     **/
    public Boolean updateUserById(User user) {
        try {
            user.setUpdateTime(dateFormat.format(new Date()));
            user.setCreateTime(null);
            userDao.updateById(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("请联系管理员！");
        }
        return true;
    }

    /**
     * 若出现一对多的情况会报错
     * selectOne 类似于  where user_code=#{userCode} and ...
     **/
    public User selectByCode(String code) {
        return userDao.selectOne(new User(code));
    }
}
