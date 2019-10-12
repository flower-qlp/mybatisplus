package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mybatisplus.bean.TUserInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserInfoDao extends BaseMapper<TUserInfo> {

    @Select("select nick_name as nickName from t_user_info")
    List<TUserInfo> selectByTwoTables();
}
