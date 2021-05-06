package com.mybatisplus.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.mybatisplus.bean.common.BaseBean;
import lombok.Data;

@TableName("t_weather")
@Data
public class Weather extends BaseBean implements Cloneable {
    @TableField(value = "temperature_top", exist = true)
    private double temperatureTop;

    @TableField(value = "temperature_low", exist = true)
    private double temperatureLow;

    @TableField(value = "city_code", exist = true)
    private String cityCode;

    @TableField(value = "city_name", exist = true)
    private String cityName;

    @TableField(value = "weather_date", exist = true)
    private String weatherDate;

    @Override
    public Weather clone()
            throws CloneNotSupportedException {
        return (Weather) super.clone();
    }
}
