package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mybatisplus.bean.User;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserDao extends BaseMapper<User> {

    User selectById(Long id);
}
