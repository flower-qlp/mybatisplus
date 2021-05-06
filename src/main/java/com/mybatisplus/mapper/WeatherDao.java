package com.mybatisplus.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.mybatisplus.bean.Weather;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherDao extends BaseMapper<Weather> {

    @Insert({"<script>",
            "insert into t_weather(city_code,city_name,weather_date,temperature_low,temperature_top) values",
            "<foreach collection='list' item='item' separator=','>",
            "(#{item.cityCode},#{item.cityName},#{item.weatherDate},#{item.temperatureLow},#{item.temperatureTop})",
            "</foreach>",
            "</script>"})
    int insertList(@Param("list") List<Weather> list);
}
