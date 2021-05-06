package com.mybatisplus.service;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.mybatisplus.bean.Weather;
import com.mybatisplus.service.adapter.WeatherAdapter;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service()
public class WeatherServiceImpl extends WeatherAdapter
        implements WeatherService {

    @Override
    public void insert(Weather weather) {
        testInsertWeather();
    }

    @Override
    public List<String> baseCity() {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.setSqlSelect("distinct city_name");
        wrapper.eq("enable", 1);
        List<Weather> weathers = weatherDao.selectList(wrapper);
        return weathers.parallelStream().map(x -> x.getCityName()).collect(Collectors.toList());
    }

    @Override
    public List<Weather> selectWeatherByCityName(String city) {
        if (StringUtils.isEmpty(city)) {
            return new ArrayList<>();
        }
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.eq("enable", 1);
        wrapper.setSqlSelect("temperature_top", "temperature_low", "weather_date");
        wrapper.like("city_name", city);
        return weatherDao.selectList(wrapper);
    }
}
