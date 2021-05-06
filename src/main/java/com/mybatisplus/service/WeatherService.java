package com.mybatisplus.service;

import com.mybatisplus.bean.Weather;

import java.util.List;

public interface WeatherService {

    void insert(Weather weather);

    List<String> baseCity();

    List<Weather> selectWeatherByCityName(String city);
}
