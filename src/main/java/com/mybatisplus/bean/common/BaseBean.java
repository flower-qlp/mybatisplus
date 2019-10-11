package com.mybatisplus.bean.common;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

@Data
public class BaseBean {

    /**
     * value和数据库列名一致,若实体类和列名一致，可以省略value值
     * **/
    @TableId(type = IdType.AUTO)
    private Long id;

    private Boolean enable;

    @TableField(value = "create_by",exist = true)
    private String createBy;

    @TableField(value = "create_time",exist = true)
    private String createTime;

    @TableField(value = "update_by",exist = true)
    private String updateBy;

    @TableField(value = "update_time",exist = true)
    private String updateTime;


}
