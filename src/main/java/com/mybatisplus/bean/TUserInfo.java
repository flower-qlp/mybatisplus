package com.mybatisplus.bean;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
public class TUserInfo extends Model<TUserInfo> {

    private Long id;

    private Integer age;

    private String nickName;

    private Boolean sex;

    private String tel;

    private Long userId;

    private String userNameCh;

    private String userNameEn;

    private String createBy;

    private String createTime;

    private Boolean enable;

    private String updateBy;

    private String updateTime;


    @Override
    protected Serializable pkVal() {
        return id;
    }
}
