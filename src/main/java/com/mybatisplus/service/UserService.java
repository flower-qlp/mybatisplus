package com.mybatisplus.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.mybatisplus.bean.User;
import com.mybatisplus.mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    /**
     * 根据条件查询
     **/
    public List<User> selectByMap(User user) {
        Map<String, Object> columnMap = new HashMap<>();
        columnMap.put("user_name", user.getUserName());
        return userDao.selectByMap(columnMap);
    }

    /**
     * 通过ids查询列表
     **/
    public List<User> selectByIds() {
        List<Long> ids = new ArrayList<>();
        ids.add(1L);
        ids.add(2L);
        return userDao.selectBatchIds(ids);
    }

    /**
     * 分页
     **/
    public List<User> selectByPage() {
        /**
         * 构造器
         * **/
        return userDao.selectPage(new Page<User>(1, 10),
                new EntityWrapper<User>()
                        .like("user_name", "1")
                        .or()   //or()和orNew()区别不大
                        .eq("create_by", "string")
                        .orderBy("id desc ")
        );
    }

    /**
     * 根据条件跟新数据
     * **/
    public void updateByEntityWrapper() {
        User user = new User();
        user.setCreateBy("admin");
        userDao.update(user, new EntityWrapper<User>()
                .eq("create_by", "string")
        );

    }
}
