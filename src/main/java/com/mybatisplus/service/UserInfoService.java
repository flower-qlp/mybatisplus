package com.mybatisplus.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mybatisplus.bean.TUserInfo;
import com.mybatisplus.mapper.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    public Boolean insert() {
        try {
            TUserInfo userInfo = new TUserInfo();
            userInfo.setNickName("苏大强");
            userInfo.setId(2L);
            userInfo.setAge(20);
            userInfo.setEnable(true);
            userInfo.insert();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public void select(){
        TUserInfo userInfo = new TUserInfo();
        userInfo.setId(1L);
        TUserInfo oneUser=userInfo.selectById();
        System.out.println(JSON.toJSONString(oneUser));
        List<TUserInfo> listInfos=userInfo.selectList(new EntityWrapper().like("nick_name","苏"));
        System.out.println(JSON.toJSONString(listInfos));

        List<TUserInfo> twoList=userInfoDao.selectByTwoTables();
        System.out.println(JSON.toJSONString(twoList));

    }
}
