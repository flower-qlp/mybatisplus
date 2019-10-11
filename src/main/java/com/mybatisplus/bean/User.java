package com.mybatisplus.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.mybatisplus.bean.common.BaseBean;
import lombok.Data;

@Data
@TableName(value = "t_user")
public class User extends BaseBean {

    /**
     * 需要配置文件开启驼峰 exist =true标识 数据库没有该字段 需要转换为驼峰
     **/
    @TableField(value = "user_name", exist = true)
    private String userName;

    @TableField(value = "user_code", exist = true)
    private String userCode;

    private String password;


    public User() {
    }

    public User(String userCode) {
        this.userCode = userCode;
    }
}
